package com.pf.guidebox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.pf.guidebox.model.GuideBoxMovie;
import com.pf.guidebox.model.Movie;
import com.pf.guidebox.model.SubscriptionWebSource;
import com.pf.plexapi.model.simple.SimpleMovie;
import com.pf.plexapi.model.simple.Source;

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
public class GuideBoxAPI {
	private Logger logger = Logger.getLogger(getClass());
	private Gson gson = new Gson();
	private CloseableHttpClient httpClient;
	private final static String UA = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.120 Safari/537.36";
	private final static int MAX_RETRIES = 3;
	private final static long SLEEP_TIME = 1000L;
	private String apiKey = "rKxgwstY28L034p2ArKC9LUGRnL8mJTJ";
	private String baseUrl = "https://api-public.guidebox.com/v1.43/US";

	public GuideBoxAPI() {
		initialize();
	}
	
	private Object getJSONObject(String url, Class clz) throws GuideBoxAPIException {
		Object rtnObject = null;
		
		int retry = 0;
		Throwable error = null;
	    do {
			HttpGet httpGet = new HttpGet(url);
			logger.debug("Executing " + httpGet.toString());
			
		    HttpResponse response = null;
		    try {
				response = httpClient.execute(httpGet);
	    		if(response.getStatusLine().getStatusCode() == 500) {
	    			throw(new GuideBoxAPIException("HTTP status code 500 Error encountered for request " + 
	    									httpGet + "!"));
	    		}
		    	rtnObject = gson.fromJson(new InputStreamReader(response.getEntity().getContent()), clz);
		    	logger.debug("rtnObject=" + rtnObject);
		    	if(rtnObject == null) {
		    		throw(new GuideBoxAPIException("JSON object was empty!"));
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
				logger.debug("Sleeping " + SLEEP_TIME + " ms.");
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
			throw(new GuideBoxAPIException("Error getting JSON from GuideBox API!", error));
		}	
		
		return(rtnObject);
	}
	
	public boolean isAmazonPrime(SimpleMovie simpleMovie) throws GuideBoxAPIException {
		boolean rtnIsAmazonPrime = false;
		// First get the GuideBox ID
		GuideBoxMovie guideBoxMovie = null;
		if(simpleMovie.getSource() == Source.IMDB) {
			guideBoxMovie = getMovieByImdb(simpleMovie.getMovieId());
		}
		else {
			guideBoxMovie = getMovieByMovieDb(simpleMovie.getMovieId());	
		}
		if(guideBoxMovie.getId() == null) {
			logger.warn("Unable to determine if movie " + simpleMovie.getTitle() + 
					" (" + simpleMovie.getYear() + ") is Amazon Prime because there was no GuideBox API record. Skipping.");
			return(rtnIsAmazonPrime);
		}
		Movie movie = (Movie)getJSONObject(baseUrl + 
				"/" + apiKey + "/movie/" + guideBoxMovie.getId(), Movie.class);
		// Check subscription web services for Amazon Prime
		List<SubscriptionWebSource> subSourceList = movie.getSubscriptionWebSources();
		if(subSourceList != null && ! subSourceList.isEmpty()) {
			for(SubscriptionWebSource subSrc : subSourceList) {
				if(subSrc.getSource().equalsIgnoreCase("amazon_prime")) {
					rtnIsAmazonPrime = true;
					break;
				}
			}
		}
		return(rtnIsAmazonPrime);
	}
	
	public GuideBoxMovie getMovieByMovieDb(String movieDbId) throws GuideBoxAPIException {
		if(movieDbId == null || movieDbId.trim().length() == 0) {
			throw(new GuideBoxAPIException("MovieDB ID was missing [movieDbId=" + movieDbId + "]!"));
		}
		GuideBoxMovie guideBoxMovie = (GuideBoxMovie)getJSONObject(baseUrl + 
				"/" + apiKey + "/search/movie/id/themoviedb/" + 
				movieDbId, GuideBoxMovie.class);
		return guideBoxMovie;
	}

	public GuideBoxMovie getMovieByImdb(String imdbId) throws GuideBoxAPIException {
		if(imdbId == null || imdbId.trim().length() == 0) {
			throw(new GuideBoxAPIException("IMDB ID was missing [imdbId=" + imdbId + "]!"));
		}
		GuideBoxMovie guideBoxMovie = (GuideBoxMovie)getJSONObject(baseUrl + 
				"/" + apiKey + "/search/movie/id/imdb/" + 
				imdbId, GuideBoxMovie.class);
		return guideBoxMovie;
	}

	private void initialize() {
		try {
		    SSLContextBuilder builder = new SSLContextBuilder();
		    builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
		    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
		            builder.build());
		    httpClient = HttpClients.custom().setSSLSocketFactory(
		            sslsf).build();
		}
		catch(Exception e) {
			throw(new RuntimeException(e));
		}
//			public boolean isTrusted(X509Certificate[] certificate,
//					String authType) {
//				return true;
//			}
//		};
//		try {
//			SSLSocketFactory sf = new SSLSocketFactory(acceptingTrustStrategy,
//					SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
//			   SchemeRegistry registry = new SchemeRegistry();
//			   registry.register(new Scheme("https", 443, sf));
//			   ClientConnectionManager ccm = new PoolingClientConnectionManager(registry);
//			 
//			   httpClient = new DefaultHttpClient(ccm);
//			   httpClient.setRedirectStrategy(new LaxRedirectStrategy());
//			   httpClient.getParams().setParameter(CoreProtocolPNames.USER_AGENT, UA);
//		} catch (KeyManagementException | UnrecoverableKeyException
//				| NoSuchAlgorithmException | KeyStoreException e) {
//			logger.warn("Unable to initialize SSL HttpClient.", e);
//		}
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

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
}
