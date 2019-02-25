package com.pf.plexjobserver;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class CouchPotatoWebHook
 */
@WebServlet(description = "CouchPotato WebHook", urlPatterns = { "/CouchPotatoWebHook" })
public class CouchPotatoWebHook extends HttpServlet {
	private static Logger LOG = Logger.getLogger(CouchPotatoWebHook.class);
	private static final long serialVersionUID = 1L;
	private String baseMovieDir = "/mnt/htpcdrive2/plex/movies";
      
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

		if(System.getenv("BASE_MOVIE_DIR") != null) {
			baseMovieDir = System.getenv("BASE_MOVIE_DIR");
			LOG.info("BASE_MOVIE_DIR=" + baseMovieDir);
		}
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
		String message = request.getParameter("message");
		if(imdbId == null) {
			// This means that couchpotato is just checking we are up.
			LOG.info("Couchpotato is just checking we are up.");
			out.println("OK");
			return;
		}
		// TODO: Need a way to convert imdb_id to movie name.
		// For now we'll use the message parameter passed which is in the format
		// Downloaded <TITLE> (<TYPE>)
		String title = message;
		Pattern pattern = Pattern.compile("(?!:Downloaded) .* (?!:\\()");
		Matcher matcher = pattern.matcher(message);
		if (matcher.find())
		{
			title = matcher.group().trim();
		}
		else {
			throw new IOException("Unable to parse title from message \"" + 
					message + "\"");
		}
		// Find the movie directory to get the move file.
		File dir = new File(baseMovieDir);
		final String tmpTitle = title.replaceFirst("The", "")
				.replaceFirst("A", "")
				.trim();
		File[] matchingFiles = dir.listFiles(new FileFilter() {
		    public boolean accept(File pathname) {
		        return pathname.getName().startsWith(tmpTitle);
		    }
		});
		if(matchingFiles == null) {
			throw new IOException("Base movie directory was not found: " + 
					baseMovieDir);
		}
		if(matchingFiles.length == 0) {
			throw new IOException("Movie directory " + title + " was not found in directory " + baseMovieDir);
		}
		if(matchingFiles.length > 1) {
			throw new IOException("More than one movie entry was found for " + title);
		}
		String movieDirStr = baseMovieDir + "/" + matchingFiles[0].getName();
		File movieDir = new File(movieDirStr);
		if(! movieDir.exists()) {
			throw(new IOException("movieDir=" + movieDir + " does not exist."));
		}
		String movieFile = null;
		String[] files = movieDir.list();
		for(String file : files) {
			if(file.matches(title + "(.mp4|.avi|.mkv)")) {
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
			throw(new IOException("Unable to find media for movie " + title + "!"));
		}
		
		out.println("OK");
	}
}
