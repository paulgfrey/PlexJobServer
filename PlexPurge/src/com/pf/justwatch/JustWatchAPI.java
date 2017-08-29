package com.pf.justwatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pf.justwatch.model.Item;
import com.pf.justwatch.model.JustWatchMovies;
import com.pf.justwatch.model.Offer;
import com.pf.plexapi.model.simple.SimpleMovie;

/**
 * This API class is using the GuideBox API <a href="https://api.guidebox.com/">https://api.guidebox.com/</a>.  This API
 * queries many of the video providers (Hulu Plus, Amazon, etc - not Netflix).  You can
 * use this API to determine if a movie is available for streaming or not.
 * NOTE: To clearly identify the movie, the API will require an IMDB ID to start the look up process.
 * 
 * This class uses REST APIs to return JSON data.
 * @author paulf
 *
 */
public class JustWatchAPI {
	private Logger logger = Logger.getLogger(getClass());
	private CloseableHttpClient httpClient;
	private final static String UA = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.120 Safari/537.36";
	private final static int MAX_RETRIES = 3;
	private final static long SLEEP_TIME = 1000L;
	private String baseUrl = "https://api.justwatch.com/titles/en_US/popular";
	private final static int AMAZONPRIME_PROVIDER_ID = 9;
	private final static int NETFLIX_PROVIDER_ID = 8;
	private final static long SLEEP_BETWEEN_CALLS = (10L*1000L);

	public JustWatchAPI() throws JustWatchAPIException {
		initialize();
	}
	
	private Object postJSONObject(String url, JustWatchAPIQuery query, Class clz) throws JustWatchAPIException {
		Object rtnObject = null;
		
		int retry = 0;
		Throwable error = null;
	    do {
			HttpPost httpPost = new HttpPost(url);
			
		    HttpResponse response = null;
		    try {
	    		try {
	    			logger.info("Sleeping " + (SLEEP_BETWEEN_CALLS/1000L) + " secs...");
					Thread.sleep(SLEEP_BETWEEN_CALLS);
				} catch (InterruptedException e) {
					// do nothing
				}
		    	GsonBuilder gsonBuilder = new GsonBuilder();  
		    	gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);  
		    	Gson gson = gsonBuilder.create();
		    	String jsonInput = gson.toJson(query);
		    	logger.debug("JSON=" + jsonInput);
		    	StringEntity input = new StringEntity(jsonInput);
		        httpPost.setHeader("Accept", "application/json");
		        httpPost.setHeader("Content-type", "application/json");
				httpPost.setEntity(input);	
				logger.debug("Executing " + httpPost.toString());
				response = httpClient.execute(httpPost);
	    		if(response.getStatusLine().getStatusCode() == 500) {
	    			throw(new JustWatchAPIException("HTTP status code 500 Error encountered for request " + 
	    					httpPost + "!"));
	    		}
	    		if(response.getStatusLine().getStatusCode() == 429) {
	    			logger.warn("JustWatchAPI sent a too many requests error message. Sleeping 5 mins...");
	    			Thread.sleep(5L*60L*1000L);
	    		}
	    		if(response.getStatusLine().getStatusCode() != 200) {
	    			throw new JustWatchAPIException("HTTP status code:" + 
	    								response.getStatusLine().getStatusCode() + " reason:" +
	    								response.getStatusLine().getReasonPhrase() + "!");
	    		}
		    	rtnObject = gson.fromJson(new InputStreamReader(response.getEntity().getContent()), clz);
		    	logger.debug("rtnObject=" + rtnObject);
		    	if(rtnObject == null) {
		    		throw(new JustWatchAPIException("JSON object was empty!"));
		    	}
		    	error = null;
		    	break;
			} catch (Throwable e) {
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
				logger.info("Sleeping " + SLEEP_TIME + " ms.");
				try {
					Thread.sleep(SLEEP_TIME);
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
			throw(new JustWatchAPIException("Error getting JSON from JustWatch API!", error));
		}	
		
		return(rtnObject);
	}
	
	private static Map<String, Item> plexMovieMap = new HashMap<>();
	private static Map<String, Item> justMoviesMap = new HashMap<>();
	private Item getMovie(SimpleMovie simpleMovie) throws JustWatchAPIException {
		Item foundItem = null;
		String sanitizedTitle = getSanitizedTitle(simpleMovie);
		if((foundItem = plexMovieMap.get(simpleMovie.getMovieId())) != null) {
			logger.debug("Found in plexMovieMap, " + simpleMovie);
			return(foundItem);
		}
		if(justMoviesMap.size() > 0) {
			// Look through the rest of the lise to see if we have the movie already.
			for(Item item : justMoviesMap.values()) {
				if(justWatchMovieMatchesPlexMovie(item, simpleMovie)) {
					logger.debug("Found in justMoviesMap, " + simpleMovie);
					foundItem = item;
					break;
				}
			}
			if(foundItem != null) {
				// Add it to the plexMovieMap
				plexMovieMap.put(simpleMovie.getMovieId(), foundItem);
				return foundItem;
			}
		}
		logger.debug("Sanitized title=" + sanitizedTitle);
		JustWatchAPIQuery query = new JustWatchAPIQuery();
		query.setQuery(sanitizedTitle);
		query.setReleaseYearFrom(Integer.parseInt(simpleMovie.getYear()));
		query.setReleaseYearUntil(query.getReleaseYearFrom());
		query.setContentTypes(new String[]{"movie"});
		query.setProviders(new String[] {"amp,nfx"});
		
		JustWatchMovies justWatchMovies = (JustWatchMovies)postJSONObject(
				baseUrl, query, JustWatchMovies.class);
		if(justWatchMovies.getItems() == null) {
			logger.warn("Unable to get JustWatch Movie data for " + simpleMovie);
			return foundItem;
		}
		for(Item item : justWatchMovies.getItems()) {
			logger.debug("item=" + item.getTitle() + " (" + item.getOriginalReleaseYear() + ")");
			if(justWatchMovieMatchesPlexMovie(item, simpleMovie)) {
				foundItem = item;
			}
			if(! justMoviesMap.containsKey(String.valueOf(item.getId()))) {
				justMoviesMap.put(String.valueOf(item.getId()), item);
			}
		}
		if(foundItem == null) {
			logger.warn("Unable to find movie " + simpleMovie.getTitle() + 
					" (" + simpleMovie.getYear() + ") from JustWatchAPI. Skipping.");
		}
		else {
			logger.debug("Plex movie found online, " + simpleMovie);
			plexMovieMap.put(simpleMovie.getMovieId(), foundItem);
		}
		return(foundItem);
	}
	
	private boolean justWatchMovieMatchesPlexMovie(Item item, SimpleMovie simpleMovie) {
		String sanitizedTitle = getSanitizedTitle(simpleMovie);
		String sanitizedItemSummary = getSanitizedSummary(item.getTitle(), item.getShortDescription());
		String sanitizedPlexSummary = getSanitizedSummary(simpleMovie.getTitle(), simpleMovie.getSummary());
		if((item.getTitle().trim().equalsIgnoreCase(sanitizedTitle) &&
				item.getOriginalReleaseYear() == Integer.parseInt(simpleMovie.getYear()))
				|| sanitizedItemSummary.equals(sanitizedPlexSummary)) {
			return true;
		}
		else {
			return false;
		}
	}
	private String getSanitizedTitle(SimpleMovie simpleMovie) {
		String rtnTitle = simpleMovie.getTitle();
		rtnTitle = rtnTitle.replace('.', ' ');
		int ndx = rtnTitle.indexOf(simpleMovie.getYear());
		if(ndx != -1) {
			rtnTitle = rtnTitle.substring(0, ndx);
		}
		return rtnTitle.trim();
	}
	
	private String getSanitizedSummary(String title, String summary) {
		// Strip all punctuation and whitespace
		if(summary != null) {
			return summary.replaceAll("[^A-Za-z]+", "").toLowerCase();
		}
		else {
			return(title.toLowerCase());
		}
	}
	
	private boolean matchProvider(SimpleMovie simpleMovie, int providerId) throws JustWatchAPIException {
		boolean matchFound = false;
		
		Item foundItem = getMovie(simpleMovie);
		if(foundItem == null) {
			return matchFound;
		}
		if(foundItem.getOffers() == null) {
			logger.warn("Unable to determine provider because there were no offers for movie " + 
					simpleMovie);
			return matchFound;
		}
		for(Offer offer : foundItem.getOffers()) {
			if(offer.getProviderId() == providerId) {
				matchFound = true;
				break;
			}
		}

		return matchFound;
	}
	
	public boolean isAmazonPrime(SimpleMovie simpleMovie) throws JustWatchAPIException {
		boolean rtnAmazonPrime = matchProvider(simpleMovie, AMAZONPRIME_PROVIDER_ID);
		if(rtnAmazonPrime) {
			logger.debug("Amazon Prime Movie: " + simpleMovie);
		}
		return rtnAmazonPrime;
	}

	public boolean isNetFlix(SimpleMovie simpleMovie) throws JustWatchAPIException {
		boolean rtnNetFlix = matchProvider(simpleMovie, NETFLIX_PROVIDER_ID);
		if(rtnNetFlix) {
			logger.debug("NetFlix Movie: " + simpleMovie);
		}
		return rtnNetFlix;
	}

	private void initialize() throws JustWatchAPIException {
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, (certificate, authType) -> true)
					.build();

			httpClient = HttpClients.custom()
					.setSSLContext(sslContext)
					.setSSLHostnameVerifier(new NoopHostnameVerifier())
					.setUserAgent(UA).build();
		} catch (Exception e) {
			throw new JustWatchAPIException("Unable to initialize HTTPClient!", e);
		}
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

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

    private static class DefaultTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

        @Override
        public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }
    
    class JustWatchAPIQuery {
		private String query;
		private String[] contentTypes;
		private int releaseYearFrom;
		private int releaseYearUntil;
		private String[] providers;
		
		public String[] getContentTypes() {
			return contentTypes;
		}
		public void setContentTypes(String[] contentTypes) {
			this.contentTypes = contentTypes;
		}
		public int getReleaseYearFrom() {
			return releaseYearFrom;
		}
		public void setReleaseYearFrom(int releaseYearFrom) {
			this.releaseYearFrom = releaseYearFrom;
		}
		public int getReleaseYearUntil() {
			return releaseYearUntil;
		}
		public void setReleaseYearUntil(int releaseYearUntil) {
			this.releaseYearUntil = releaseYearUntil;
		}
		public String[] getProviders() {
			return providers;
		}
		public void setProviders(String[] providers) {
			this.providers = providers;
		}
		public String getQuery() {
			return query;
		}
		public void setQuery(String query) {
			this.query = query;
		}
	}
}
