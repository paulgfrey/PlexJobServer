package com.pf.plexjobserver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;

/**
 * Servlet implementation class PlexWebHook
 */
@WebServlet("/PlexWebHook")
@MultipartConfig
public class PlexWebHook extends HttpServlet {
	private static Logger LOG = Logger.getLogger(PlexWebHook.class);
	private static final long serialVersionUID = 1L;
	private String baseMovieDir = "/mnt/htpcdrive2/plex/movies";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlexWebHook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<Part> parts = request.getParts();
		for(Part part : parts) {
			LOG.debug("part=" + part.toString());
			LOG.debug("part.name=" + part.getName());
		}
		String jsonString = IOUtils.toString(request.getPart("payload").getInputStream(), Charset.defaultCharset());
		
		LOG.info("jsonString=" + jsonString);
		
		JSONObject obj = new JSONObject(jsonString);
		if(obj.getString("event").equals("media.rate")) {
			JSONObject metadata = obj.getJSONObject("Metadata");
			String title = metadata.getString("title");
			LOG.debug(String.format("title=%s", title));
			
			File movieFile = findFile(title);
			if(movieFile == null) {
				throw new IOException(String.format("Unable to find movie for title=%s", title));
			}
			LOG.debug("movieFile=" + movieFile);
			File skipFile = new File(movieFile.toString().replaceAll("\\.mp4", ".skip"));
			LOG.debug("skipFile=" + skipFile);
			String rating = obj.getString("rating");
			if("2".equals(rating)) {
				// Remove skip
				skipFile.delete();
				LOG.info(String.format("%s deleted", skipFile));
			}
			else if("10".equals(rating)) {
				// create skipFile
				skipFile.createNewFile();
				LOG.info(String.format("%s created", skipFile));
			}
			else {
				LOG.info("Rating was not 2 or 10, so doing nothing.");
			}
		}
		
		response.setStatus(200);
	}
	
	private File findFile(String title) throws IOException {
		String regex = String.format(".*%s.*\\.mp4", title.replaceAll("[()]", "."));
		LOG.debug("regex=" + regex);
		Path source = Paths.get(baseMovieDir);
        Optional<Path> filePath = Files.walk(source).filter(s -> s.toString().matches(regex)).findFirst();
        if(filePath.isPresent()) {
        	return filePath.get().toFile();
        }
        else {
    		return null;
        }
	}

}
