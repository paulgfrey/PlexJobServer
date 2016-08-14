package com.pf.plexjobserver;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pf.guidebox.GuideBoxAPI;
import com.pf.guidebox.GuideBoxAPIException;
import com.pf.guidebox.model.GuideBoxMovie;

/**
 * Servlet implementation class CouchPotatoWebHook
 */
@WebServlet(description = "CouchPotato WebHook", urlPatterns = { "/CouchPotatoWebHook" })
public class CouchPotatoWebHook extends HttpServlet {
	private static Logger LOG = Logger.getLogger(CouchPotatoWebHook.class);
	private static final long serialVersionUID = 1L;
	private static final String BASE_MOVIE_DIR = "/mnt/htpcdrive2/plex/movies";
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CouchPotatoWebHook() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		performTask(request, response);
	}

	private void performTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = "paulf";

		ServletOutputStream out = response.getOutputStream();
		LOG.info("Headers:");
		Enumeration<String> headNames = request.getHeaderNames();
		List<String> headerNameList = Collections.list(headNames);
		
		for(String name : headerNameList) {
			LOG.info(name + "=" + request.getHeader(name));
		}
		
		Enumeration<String> params = request.getParameterNames();
		List<String> paramNames = Collections.list(params);
		LOG.info("Parameters:");
		for(String name : paramNames) {
			LOG.info(name + "=" + request.getParameter(name));
		}
		String imdbId = request.getParameter("imdb_id");
		try {
			GuideBoxMovie guideBoxMovie = (new GuideBoxAPI()).getMovieByImdb(imdbId);
			String movieDirStr = BASE_MOVIE_DIR + "/" + guideBoxMovie.getTitle() + " (" + guideBoxMovie.getReleaseYear() + ")";
			File movieDir = new File(movieDirStr);
			if(! movieDir.exists()) {
				throw(new IOException("movieDir=" + movieDir + " does not exist."));
			}
			String movieFile = null;
			String[] files = movieDir.list();
			for(String file : files) {
				if(file.startsWith(guideBoxMovie.getTitle() + ".")) {
					movieFile = movieDirStr + "/" + file;
					break;
				}
			}
			if(movieFile != null) {
				// Make sure the file exists
				if(!(new File(movieFile)).exists()) {
					throw(new IOException("Video file " + movieFile + " was not found!"));
				}
				String hostname = InetAddress.getLocalHost().getHostName();
				LOG.info("hostname=" + hostname);
				if(hostname.toLowerCase().contains("odroid")) {
					username = "odroid";
				}
				JobExecutor job = new JobExecutor(username, movieFile, "IN_MOVED_TO");
				job.execute();
			}
			else {
				throw(new IOException("Unable to find media for movie " + guideBoxMovie.getTitle() + "!"));
			}
		} catch (GuideBoxAPIException e) {
			throw(new IOException(e));
		}
		
		out.println("OK");
	}
}
