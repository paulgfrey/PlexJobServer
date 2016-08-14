package com.pf.netflix.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.pf.guidebox.GuideBoxAPI;
import com.pf.guidebox.model.GuideBoxMovie;
import com.pf.netflix.api.model.IMDBResponse;
import com.pf.netflix.api.model.MovieResponse;
import com.pf.plexapi.model.movie.MovieItem;
import com.pf.plexapi.model.simple.SimpleMovie;
import com.pf.plexapi.model.simple.Source;

/**
 * This class uses the REST API called the Netflix Roulette API.  I am using the V2 version 
 * to determine if the one of my Plex movies has a Netflix ID assuming that if it has a Netflix
 * ID, it's available streaming on Netflix.
 * Main Site: <a href="http://github.com/Codeusa/Netflix-Roulette-API">http://github.com/Codeusa/Netflix-Roulette-API</a><br>
 * Code Base: <a href="http://netflixroulette.net/api/v2/usa/">http://netflixroulette.net/api/v2/usa/</a><BR>
 * NOTE: To clearly identify the movie, the API will require an IMDB ID to start the look up process.
 * 
 * This class uses REST APIs to return JSON data.
 * @author paulf
 *
 */
public class NetflixAPI {
	private Logger logger = Logger.getLogger(getClass());
	private Gson gson = new Gson();
	private DefaultHttpClient httpClient;
	private final static String UA = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.120 Safari/537.36";
	private final static int MAX_RETRIES = 3;
	private final static String IMDB_LOOKUP_URL = "http://netflixroulette.net/api/v2/usa/imdb";
	private final static String NETFLIX_MOVIE_URL = "http://netflixroulette.net/api/v2/usa/movie";
	private GuideBoxAPI guideBoxAPI;

	public NetflixAPI() {
		initialize();
	}
	
	public String getNetflixId(SimpleMovie movie) throws NetflixAPIException {
		String netflixId = null;
		
		int retry = 0;
		Throwable error = null;
		do {
			
		    HttpResponse response = null;
		    try {
		    	String imdbId = null;
		    	if(movie.getSource() == Source.IMDB) {
		    		imdbId = movie.getMovieId();
		    	}
		    	else {
			    	GuideBoxMovie movieDbMovie = guideBoxAPI.getMovieByMovieDb(movie.getMovieId());	
			    	imdbId = movieDbMovie.getImdb();
		    	}
		    	if(imdbId == null || imdbId.trim().length() == 0) {
		    		logger.warn("Unable to determine IMDB ID for movie " + movie.getTitle() + 
		    				" (" + movie.getYear() + "). Skipping!");
		    		return(netflixId);
		    	}
		    	HttpGet httpGet = new HttpGet(IMDB_LOOKUP_URL + "?imdbId=" + imdbId);
				logger.debug("Executing " + IMDB_LOOKUP_URL + "?imdbId=" + imdbId);
		    	response = httpClient.execute(httpGet);
				IMDBResponse imdbResponse = gson.fromJson(new InputStreamReader(response.getEntity().getContent()), IMDBResponse.class);
				logger.debug("imdbResponse=" + imdbResponse);
				if(imdbResponse != null && imdbResponse.getStatuscode().equals("200")) {
					netflixId = imdbResponse.getNetflix_id();
				}
				else {
					logger.warn("Netflix API: IMDB Query for " + imdbId + " didn't return any response!");
				}
				break;
		    }
		    catch(Throwable e) {
				error = e;
				if(response != null) {
					try {
						if (logger.isDebugEnabled()) {
							logger.debug("response=" + response2Str(response));
							response = null;
						}
					} catch (IOException e1) {
						// nothing to do
					}
				}
				logger.warn("Sleeping 1 second.");
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e1) {
					// nothing to do
				}
				retry++;
			}
		    finally {
		    	if(response != null) {
		    		try {
						EntityUtils.consume(response.getEntity());
					} catch (IOException e) {
						// do nothing
					}
		    	}
		    }
		}
		while(retry < MAX_RETRIES);
		if(error != null) {
			throw(new NetflixAPIException("Error getting Netflix ID for movie " +
					movie.getTitle() + " (" + movie.getYear() + ")!", error));
		}
		
		if(netflixId == null) {
			return(netflixId);
		}
		// Verify the year matches 
		// If the year of the netflix year does not match the IMDB years, this is not
		// available online
		do {
			HttpGet httpGet = new HttpGet(NETFLIX_MOVIE_URL + "?netflixid=" + netflixId);
			logger.debug("Executing " + NETFLIX_MOVIE_URL + "?netflixid=" + netflixId);
			
		    HttpResponse response = null;
		    try {
				response = httpClient.execute(httpGet);
				MovieResponse movieResponse = gson.fromJson(new InputStreamReader(response.getEntity().getContent()), MovieResponse.class);
				logger.debug("movieResponse=" + movieResponse);
				if(movieResponse != null && movieResponse.getStatuscode().equals("200")) {
					// Now check that the year in Netflix matches Plex IMDB year
					if(! movieResponse.getNetflix_results()[0].getYear().equals(movie.getYear())) {
						netflixId = null;
						logger.warn("Netflix API: Movie " + movie.getTitle() + 
								" Netflix Year=" + movieResponse.getNetflix_results()[0].getYear() + 
								" Plex (IMDB) Year=" + movie.getYear() + 
								". Netflix mismatch, removing netflixid!");
					}
				}
				else {
					logger.warn("Netflix API: Movie Query for " + movie.getMovieId() + " didn't return any response!");
				}
				break;
		    }
		    catch(Throwable e) {
				error = e;
				if(response != null) {
					try {
						if (logger.isDebugEnabled()) {
							logger.debug("response=" + response2Str(response));
							response = null;
						}
					} catch (IOException e1) {
						// nothing to do
					}
				}
				logger.warn("Sleeping 1 second.");
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e1) {
					// nothing to do
				}
				retry++;
			}
		    finally {
		    	if(response != null) {
		    		try {
						EntityUtils.consume(response.getEntity());
					} catch (IOException e) {
						// do nothing
					}
		    	}
		    }
		}
		while(retry < MAX_RETRIES);
		if(error != null) {
			throw(new NetflixAPIException("Error getting Netflix ID for IMDB ID " +
					movie.getMovieId() + "!", error));
		}
		
		return(netflixId);
	}

	private String response2Str(HttpResponse response) throws IOException {
		InputStream is = null;
		StringBuilder total = new StringBuilder();
		try {
			is = response.getEntity().getContent();
			BufferedReader r = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while ((line = r.readLine()) != null) {
			   total.append(line);
			}
		}
		finally {
			is.close();
		}
		return total.toString();
	}

	private void initialize() {
		try {
		   httpClient = new DefaultHttpClient();
		   httpClient.setRedirectStrategy(new LaxRedirectStrategy());
		   httpClient.getParams().setParameter(CoreProtocolPNames.USER_AGENT, UA);
		} catch (Throwable e) {
			logger.error("Unable to initialize HttpClient.", e);
		}
		guideBoxAPI = new GuideBoxAPI();
	}
}
