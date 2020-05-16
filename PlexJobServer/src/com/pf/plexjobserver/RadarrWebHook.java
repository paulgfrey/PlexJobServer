package com.pf.plexjobserver;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pf.plexjobserver.radarr.model.WebhookDTO;

/**
 * Servlet implementation class RadarrWebHook
 */
@WebServlet("/RadarrWebHook")
public class RadarrWebHook extends HttpServlet {
	private static Logger LOG = Logger.getLogger(RadarrWebHook.class);
	private static final long serialVersionUID = 1L;
	private String username = "paulf";
	private String baseMovieDir = "/mnt/htpcdrive2/plex/movies";
	private String radarrBaseMovieDir = "/movies";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RadarrWebHook() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		WebhookDTO webhookDto = mapper.readValue(request.getReader(), WebhookDTO.class);
		
		LOG.info(webhookDto.toString());
		
		handleRadarrWebHook(webhookDto);
		
		response.setStatus(200);
		response.getOutputStream().println("OK");
	}
	
	private void handleRadarrWebHook(WebhookDTO webhookDto) throws IOException {
		String radarrMovieFile = String.format("%s/%s",
				webhookDto.getMovie().getAdditionalProperties().get("folderPath"),
				webhookDto.getMovieFile().getRelativePath());
		LOG.debug("radarrMovieFile=" + radarrMovieFile);
		String movieFile = radarrMovieFile.replace(radarrBaseMovieDir, baseMovieDir);
		LOG.debug("movieFile=" + movieFile);
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
			else if(hostname.toLowerCase().contains("atomicpi")) {
				username = "atomicpi";
			}
			JobExecutor job = new JobExecutor(username, movieFile, "IN_MOVED_TO");
			job.execute();
		}
		else {
			throw(new IOException("Unable to find media for movie " + webhookDto.getMovie().getTitle() + "!"));
		}
	}

}
