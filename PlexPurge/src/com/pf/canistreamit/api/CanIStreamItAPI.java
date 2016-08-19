package com.pf.canistreamit.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.Arrays;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.pf.canistreamit.model.Movie;
import com.pf.guidebox.GuideBoxAPI;
import com.pf.guidebox.model.GuideBoxMovie;
import com.pf.plexapi.model.simple.SimpleMovie;
import com.pf.plexapi.model.simple.Source;

/**
 * The CanIStreamIt API consists of the following REST calls:
 * Returns a movie's info (we need the movie ID to determine if it's streamable):
 * 	http://www.canistream.it/services/search?moveName=<movie name>
 * 
 * Returns whether the movie is streamable and from whom:
 * 	http://www.canistream.it/services/query?moveId=<canistreamit's movie id>&attributes=1&mediaType=streaming
 * @author paulf
 *
 */
public class CanIStreamItAPI {
	private Logger logger = Logger.getLogger(getClass());
	private Gson gson = new Gson();
	private DefaultHttpClient httpClient;
	private final static String UA = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.120 Safari/537.36";
	private final static int MAX_RETRIES = 3;
	private final static String MOVIE_SEARCH_URL = "http://www.canistream.it/services/search";
	private final static String MOVIE_QUERY_URL = "http://www.canistream.it/services/query";
	private GuideBoxAPI guideBoxAPI;

	public CanIStreamItAPI() {
		initialize();
	}

	public boolean isNetflixStreamable(SimpleMovie simpleMovie) throws CanIStreamItAPIException {
		boolean rtnVal = false;
		
		Movie movie = doMovieSearch(simpleMovie);
		// Now do a streamable search
		if(movie != null) {
			rtnVal = findStreamingType(movie, "netflix_instant");
		}
		
		return(rtnVal);
	}
	
	public Movie doMovieSearch(SimpleMovie simpleMovie) throws CanIStreamItAPIException {
		int retry = 0;
		Throwable error = null;
		Movie canIStreamItMovie = null;
		do {	
		    HttpResponse response = null;
		    try {
		    	// We need to get the real title of the movie from Plex's movie ID (Movie DB or IMDB)
		    	// because we can't trust the movie title in Plex yet.
		    	if(simpleMovie.getTitle().toLowerCase().contains("mkv") 
		    			|| simpleMovie.getTitle().toLowerCase().contains("720p")
		    			|| simpleMovie.getTitle().toLowerCase().contains("1080p")
		    			|| simpleMovie.getTitle().toLowerCase().contains("+")
		    			|| simpleMovie.getTitle().toLowerCase().contains("visit")) {
			    	GuideBoxMovie guideBoxMovie = null;
			    	if(simpleMovie.getSource() == Source.IMDB) {
			    		guideBoxMovie = guideBoxAPI.getMovieByImdb(simpleMovie.getMovieId());
			    	}
			    	else {
			    		guideBoxMovie = guideBoxAPI.getMovieByMovieDb(simpleMovie.getMovieId());	
			    	}
			    	// If there is no title from GuideBox then just move forward with the Plex title.
			    	if(guideBoxMovie != null && guideBoxMovie.getTitle() != null) {
				    	simpleMovie.setTitle(guideBoxMovie.getTitle());
			    	}
		    	}
		    	HttpGet httpGet = new HttpGet(MOVIE_SEARCH_URL + "?movieName=" 
		    							+ URLEncoder.encode(simpleMovie.getTitle()));
				logger.debug("Executing " + httpGet.toString());
		    	response = httpClient.execute(httpGet);
				Movie[] canIStreamItMovieArr = gson.fromJson(new InputStreamReader(response.getEntity().getContent()), Movie[].class);
				if(canIStreamItMovieArr != null && response.getStatusLine().getStatusCode() == 200) {
					logger.debug("canIStreamItMovieArr=" + Arrays.asList(canIStreamItMovieArr));
					// There will be a list of movies and some might have the same name so check the year
					for(Movie cmovie: Arrays.asList(canIStreamItMovieArr)) {
						if(cmovie.getTitle().equalsIgnoreCase(simpleMovie.getTitle())) {
							// Equals year plus or minus 1 
							if(cmovie.getYear() == Integer.parseInt(simpleMovie.getYear())
									|| (cmovie.getYear()-1) == Integer.parseInt(simpleMovie.getYear())
									|| (cmovie.getYear()+1) == Integer.parseInt(simpleMovie.getYear())) {
								canIStreamItMovie = cmovie;
								break;
							}
						}
					}
				}
				else {
					logger.warn("CanIStreamIt API: Movie Search for " + simpleMovie.getTitle() + " didn't return any response!");
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
			throw(new CanIStreamItAPIException("Error getting CanIStreamIt for movie " +
					simpleMovie.getTitle() + " (" + simpleMovie.getYear() + ")!", error));
		}
		logger.debug("canIStreamIt Movie is " + canIStreamItMovie);
		
		return(canIStreamItMovie);
	}
	
	public boolean findStreamingType(Movie canIStreamItMovie, String streamingType) throws CanIStreamItAPIException {
		boolean rtnVal = false;
		
		int retry = 0;
		Throwable error = null;
		do {	
		    HttpResponse response = null;
		    try {
		    	HttpGet httpGet = new HttpGet(MOVIE_QUERY_URL + "?movieId=" 
		    							+ URLEncoder.encode(canIStreamItMovie.getId())
										+ "&attributes=1"
										+ "&mediaType=streaming");
				logger.debug("Executing " + httpGet.toString());
		    	response = httpClient.execute(httpGet);
		    	String jsonResp = response2Str(response);
				if(jsonResp != null && response.getStatusLine().getStatusCode() == 200) {
					logger.debug("jsonResp=" + jsonResp);
					rtnVal = jsonResp.toLowerCase().contains(streamingType);
				}
				else {
					logger.warn("CanIStreamIt API: Movie Search for " + canIStreamItMovie.getTitle() + " didn't return any response!");
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
			throw(new CanIStreamItAPIException("Error getting CanIStreamIt for query " +
					canIStreamItMovie + "!", error));
		}
		logger.debug("rtnVal=" + rtnVal);
		
		return(rtnVal);
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
