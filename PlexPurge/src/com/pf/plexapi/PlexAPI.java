package com.pf.plexapi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import com.pf.justwatch.JustWatchAPI;
import com.pf.justwatch.JustWatchAPIException;
import com.pf.plexapi.model.library.Directory;
import com.pf.plexapi.model.library.Libraries;
import com.pf.plexapi.model.movie.MovieItem;
import com.pf.plexapi.model.movies.Movies;
import com.pf.plexapi.model.movies.Video;
import com.pf.plexapi.model.simple.SimpleMovie;
import com.pf.plexapi.xml.PlexPurgeSettings;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.MapperWrapper;

public class PlexAPI {
	private final static String PLEX_PURGE_SETTINGS_FILE = "config/plex-purge-settings.xml";
	private Logger logger = Logger.getLogger(getClass());
	private String hostname = "localhost";
	private int port = 32400;
	private String plexToken = null;
	XStream libraryXStream = null;
	XStream moviesXStream = null;
	XStream movieItemXStream = null;
	boolean netflixSwitch = false;
	boolean amazonPrimeSwitch = false;
	private PlexPurgeSettings plexPurgeSettings;
	
	public PlexAPI(String hostname, int port, String plexToken) {
		if(hostname != null) {
			this.hostname = hostname;
		}
		if(port > 0) {
			this.port = port;
		}
		this.plexToken = plexToken;
		initialize();
	}
	
	public List<String> getLibraries() throws PlexAPIException {
		List<String> libraryList = new ArrayList<String>();
		
		try {
			URL url = new URL("http://" + hostname + ":" + port + 
										"/library/sections" +
										"?X-Plex-Token=" + plexToken);
			logger.debug("url=" + url);
			Libraries libraries = new Libraries();
			libraries.setMediaContainer((com.pf.plexapi.model.library.MediaContainer)libraryXStream.fromXML(url));
			Directory tmpDirectory = null;
			for(int x = 0; x < libraries.getMediaContainer().getDirectory().length; x++) {
				tmpDirectory = libraries.getMediaContainer().getDirectory()[x];
				libraryList.add(tmpDirectory.getTitle());
			}
		} catch (Exception e) {
			throw(new PlexAPIException("Get Plex all libraries failed!", e));
		}
		return(libraryList);
	}
	
	public String getLibraryKey(String libraryName) throws PlexAPIException {
		logger.debug("getLibraryKey(" + libraryName + ")");
		String libraryKey = null;
		try {
			URL url = new URL("http://" + hostname + ":" + port + 
										"/library/sections" +
										"?X-Plex-Token=" + plexToken);
			logger.debug("url=" + url);
			Libraries libraries = new Libraries();
			libraries.setMediaContainer((com.pf.plexapi.model.library.MediaContainer)libraryXStream.fromXML(url));
			Directory tmpDirectory = null;
			for(int x = 0; x < libraries.getMediaContainer().getDirectory().length && libraryKey == null; x++) {
				tmpDirectory = libraries.getMediaContainer().getDirectory()[x];
				logger.debug("tmpDirectory=" + tmpDirectory);
				if(tmpDirectory.getTitle().equals(libraryName)) {
					libraryKey = tmpDirectory.getKey();
				}
			}
		} catch (Exception e) {
			throw(new PlexAPIException("Get Plex library key failed for library name " + libraryName + "!", e));
		}

		return libraryKey;
	}
	
	public Movies getMovies(String libraryKey) throws PlexAPIException {
		logger.debug("getMovies(" + libraryKey + ")");
		Movies movies = null;
		try {
			URL url = new URL("http://" + hostname + ":" + port + 
										"/library/sections/" + libraryKey + "/all" +
										"?X-Plex-Token=" + plexToken);
			logger.debug("url=" + url);
			movies = new Movies();
			movies.setMediaContainer((com.pf.plexapi.model.movies.MediaContainer)moviesXStream.fromXML(url));
			logger.debug("movies=" + movies);
		}
		catch(Exception e) {
			throw(new PlexAPIException("Get movies failed for library key " + libraryKey + "!", e));
		}
		return movies;		
	}
	
	public MovieItem getMovie(String movieKey) throws PlexAPIException {
		logger.debug("getMovie(" + movieKey + ")");
		MovieItem movieItem = null;
		try {
			URL url = new URL("http://" + hostname + ":" + port + 
										movieKey +
										"?X-Plex-Token=" + plexToken);
			logger.debug("url=" + url);
			movieItem = new MovieItem();
			movieItem.setMediaContainer((com.pf.plexapi.model.movie.MediaContainer)movieItemXStream.fromXML(url));
			logger.debug("movies=" + movieItem);
		}
		catch(Exception e) {
			throw(new PlexAPIException("Get movie failed for movie key " + movieKey + "!", e));
		}
		return movieItem;		
	}
	
	public SimpleMovie getSimpleMovie(String libraryName, String movieFile) throws PlexAPIException {
		SimpleMovie movie = null;
		
		// temporarily turn off the netflix api
		boolean saveNetflixSwitch = isNetflixSwitch();
		boolean saveAmazonPrimeSwitch = isAmazonPrimeSwitch();
		try {
			setNetflixSwitch(false);
			setAmazonPrimeSwitch(false);
			List<SimpleMovie> movies = getSimpleMovies(libraryName);
			for(SimpleMovie tmpMovie : movies) {
				if(movieFile.equals(tmpMovie.getMediaFile())) {
					movie = tmpMovie;
					break;
				}
			}
		}
		finally {
			setNetflixSwitch(saveNetflixSwitch);
			setAmazonPrimeSwitch(saveAmazonPrimeSwitch);
		}
		JustWatchAPI justWatchApi;
		try {
			justWatchApi = new JustWatchAPI();
		} catch (JustWatchAPIException e1) {
			throw(new PlexAPIException("JustWatchAPI failed for file " + 
					movieFile + "!", e1));
		}
		if(isNetflixSwitch() && movie != null) {
			try {
				movie.setNetflix(justWatchApi.isNetFlix(movie));
			}
			catch (JustWatchAPIException e) {
				throw(new PlexAPIException("Unable to determine if netflix streamable for file " + 
						movieFile + "!", e));
			}
		}
		if(isAmazonPrimeSwitch() && movie != null) {
			try {
				movie.setAmazonPrime(justWatchApi.isAmazonPrime(movie));
			}
			catch (JustWatchAPIException e) {
				throw(new PlexAPIException("Unable to determine if amazon prime streamable for file " + 
						movieFile + "!", e));
			}
		}
		return(movie);
	}
	
	public List<SimpleMovie> getSimpleMovies(String plexLibraryName) throws PlexAPIException {
		String libraryKey = getLibraryKey(plexLibraryName);
		Movies movies = getMovies(libraryKey);
		// Convert to simpleMovie
		List<SimpleMovie> simpleMovies = new ArrayList<SimpleMovie>();
		Video tmpVideo = null;
		MovieItem tmpMovieItem = null;
		SimpleMovie tmpSimpleMovie = null;
		JustWatchAPI justWatchApi;
		try {
			justWatchApi = new JustWatchAPI();
		} catch (JustWatchAPIException e1) {
			throw(new PlexAPIException("JustWatchAPI failed!", e1));
		}
		for(int x = 0; x < movies.getMediaContainer().getVideo().length; x++) {
			tmpVideo = movies.getMediaContainer().getVideo()[x];
			tmpSimpleMovie = new SimpleMovie();
			tmpSimpleMovie.setLibraryKey(libraryKey);
			tmpSimpleMovie.setMovieKey(tmpVideo.getKey());
			tmpSimpleMovie.setTitle(tmpVideo.getTitle());
			tmpSimpleMovie.setYear(tmpVideo.getYear());
			tmpSimpleMovie.setSummary(tmpVideo.getSummary());
			if(tmpVideo.getMedia().size() > 1) {
				logger.warn("There were more than 2 media files for " + tmpVideo.getTitle());
			}
			tmpSimpleMovie.setMediaFile(tmpVideo.getMedia().get(0).getPart().get(0).getFile());
			
			tmpMovieItem = getMovie(tmpVideo.getKey());
			// extract IMDB ID
			if(tmpMovieItem.getMediaContainer().getVideo() == null) {
				logger.warn("The PLEX movie " + tmpMovieItem + " was missing Video object! Skipping.");
				continue;
			}
			String guid = tmpMovieItem.getMediaContainer().getVideo().getGuid();
			if(guid == null) {
				logger.warn("The PLEX movie " + tmpMovieItem + " was missing Video.guid! Skipping.");
				continue;
			}
			// example: com.plexapp.agents.imdb://tt3682448?lang=en
			int startNdx = guid.lastIndexOf("/");
			int endNdx = guid.lastIndexOf("?");
			if(startNdx != -1 && endNdx != -1) {
				startNdx++;
				tmpSimpleMovie.setMovieId(guid.substring(startNdx, endNdx));
				if(tmpSimpleMovie.getMovieId() == null || tmpSimpleMovie.getMovieId().trim().length() == 0) {
					logger.warn("The PLEX movie " + tmpSimpleMovie.getTitle() + 
							" (" + tmpSimpleMovie.getYear() + ") was not matched! (No ID!). Skipping.");
					continue;
				}
			}
			if(isNetflixSwitch()) {
				try {
					tmpSimpleMovie.setNetflix(justWatchApi.isNetFlix(tmpSimpleMovie));
				}
				catch (JustWatchAPIException e) {
					throw(new PlexAPIException("Unable to determine if netflix streamable for file " + 
							tmpSimpleMovie + "!", e));
				}
			}
			if(isAmazonPrimeSwitch()) {
				try {
					tmpSimpleMovie.setAmazonPrime(justWatchApi.isAmazonPrime(tmpSimpleMovie));
				}
				catch (JustWatchAPIException e) {
					throw(new PlexAPIException("Unable to determine if amazon prime streamable for file " + 
							tmpSimpleMovie + "!", e));
				}
			}
			simpleMovies.add(tmpSimpleMovie);
		}
		return(simpleMovies);
	}
	
	public PlexAPI(String plexToken) throws IOException {
		this((String)null, 0, plexToken);
	}

	private void initialize() {	
		// Set up Library XStream converter
		libraryXStream = new XStream(new DomDriver());
		libraryXStream.autodetectAnnotations(true);
		libraryXStream.alias("MediaContainer", com.pf.plexapi.model.library.MediaContainer.class);
		libraryXStream.alias("Directory", com.pf.plexapi.model.library.Directory.class);
		libraryXStream.alias("Location", com.pf.plexapi.model.library.Location.class);
		
		moviesXStream = new XStream(new DomDriver());
		moviesXStream.autodetectAnnotations(true);
		moviesXStream.alias("Country", com.pf.plexapi.model.movies.Country.class);
		moviesXStream.alias("Director", com.pf.plexapi.model.movies.Director.class);
		moviesXStream.alias("Genre", com.pf.plexapi.model.movies.Genre.class);
		moviesXStream.alias("Media", com.pf.plexapi.model.movies.Media.class);
		moviesXStream.alias("MediaContainer", com.pf.plexapi.model.movies.MediaContainer.class);
		moviesXStream.alias("Part", com.pf.plexapi.model.movies.Part.class);
		moviesXStream.alias("Role", com.pf.plexapi.model.movies.Role.class);
		moviesXStream.alias("Video", com.pf.plexapi.model.movies.Video.class);
		moviesXStream.alias("Writer", com.pf.plexapi.model.movies.Writer.class);
		
		movieItemXStream = new XStream(new DomDriver()) {
		    @Override
		    protected MapperWrapper wrapMapper(MapperWrapper next) {
		        return new MapperWrapper(next) {
		            @Override
		            public boolean shouldSerializeMember(Class definedIn, String fieldName) {
		                if (definedIn == Object.class) {
		                    return false;
		                }
		                return super.shouldSerializeMember(definedIn, fieldName);
		            }
		        };
		    }
		};
		movieItemXStream.autodetectAnnotations(true);
		movieItemXStream.alias("Country", com.pf.plexapi.model.movie.Country.class);
		movieItemXStream.alias("Director", com.pf.plexapi.model.movie.Director.class);
		movieItemXStream.alias("Producer", com.pf.plexapi.model.movie.Producer.class);
		movieItemXStream.alias("Genre", com.pf.plexapi.model.movie.Genre.class);
		movieItemXStream.alias("Media", com.pf.plexapi.model.movie.Media.class);
		movieItemXStream.alias("MediaContainer", com.pf.plexapi.model.movie.MediaContainer.class);
		movieItemXStream.alias("Part", com.pf.plexapi.model.movie.Part.class);
		movieItemXStream.alias("Role", com.pf.plexapi.model.movie.Role.class);
		movieItemXStream.alias("Video", com.pf.plexapi.model.movie.Video.class);
		movieItemXStream.alias("Stream", com.pf.plexapi.model.movie.Stream.class);
		movieItemXStream.alias("Writer", com.pf.plexapi.model.movie.Writer.class);
		movieItemXStream.alias("Field", com.pf.plexapi.model.movie.Field.class);
		
		File plexPurgeSettingsFile = new File(PLEX_PURGE_SETTINGS_FILE);
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(PlexPurgeSettings.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			plexPurgeSettings = (PlexPurgeSettings) jaxbUnmarshaller.unmarshal(plexPurgeSettingsFile);
		} catch (JAXBException e) {
			logger.warn("Error unmarshaling file " + plexPurgeSettingsFile + "!", e);
		}		
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getPlexToken() {
		return plexToken;
	}

	public void setPlexToken(String plexToken) {
		this.plexToken = plexToken;
	}

	public final static void printUsage() {
		System.err.println("usage: com.pf.plexapi.PlexAPI [-file output_file] [-host host] [-port port] -token plexToken [-library Plex_Library] [-listMovies [-netflix] [-amazonPrime] | -listLibraries | -getMovieInfo movieFile [-netflix] [-amazonPrime]]");
	}
	
	public static void main(String[] args) {
		String hostname = null;
		int port = 0;
		String plexToken = null;
		String libraryName = "Movies";
		boolean listMovies = false;
		boolean listLibraries = false;
		boolean netflix = false;
		boolean amazonPrime = false;
		String movieFile = null;
		File outputFile = null;
		
		for (int i = 0; i < args.length; i++) {
			if(args[i].equals("-host")) {
				i++;
				hostname = args[i];
			}
			else if(args[i].equals("-port")) {
				i++;
				port = Integer.valueOf(args[i]);
			}
			else if(args[i].equals("-token")) {
				i++;
				plexToken = args[i];
			}
			else if(args[i].equals("-library")) {
				i++;
				libraryName = args[i];				
			}
			else if(args[i].equalsIgnoreCase("-listMovies")) {
				listMovies = true;
			}
			else if(args[i].equalsIgnoreCase("-listLibraries")) {
				listLibraries = true;
			}
			else if(args[i].equalsIgnoreCase("-netflix")) {
				netflix = true;
			}
			else if(args[i].equalsIgnoreCase("-amazonPrime")) {
				amazonPrime = true;
			}
			else if(args[i].equalsIgnoreCase("-getMovieInfo")) {
				i++;
				movieFile = args[i];
			}
			else if(args[i].equalsIgnoreCase("-file")) {
				i++;
				outputFile = new File(args[i]);
			}
			else {
				printUsage();
				System.exit(-1);
			}
		}
		if(args.length == 0 || plexToken == null) {
			printUsage();
			System.exit(-1);
		}
		PlexAPI plexAPI;
		try {
			plexAPI = new PlexAPI(hostname, port, plexToken);
			plexAPI.setNetflixSwitch(netflix);
			plexAPI.setAmazonPrimeSwitch(amazonPrime);
			PrintStream out = System.out;
			try {
				if(outputFile != null) {
					out = new PrintStream(outputFile);
				}
				if(listLibraries) {
					for (String name : plexAPI.getLibraries()) {
						out.println(name);
					}
				}
				else if(listMovies) {
					for(SimpleMovie movie : plexAPI.getSimpleMovies(libraryName)) {
						out.println(movie);
					}
				}
				else if(movieFile != null) {
					if(libraryName == null) {
						System.err.println("If you use getMovieInfo, you must supply a library.");
						System.exit(-1);
					}
					out.println(plexAPI.getSimpleMovie(libraryName, movieFile));
				}
			} catch (PlexAPIException | FileNotFoundException e) {
				e.printStackTrace(System.err);
				System.exit(-1);
			}
			finally {
				if(out != null && out != System.out) {
					out.close();
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace(System.err);
			System.exit(-1);
		}
		System.exit(0);
	}

	public boolean isNetflixSwitch() {
		return netflixSwitch;
	}

	public void setNetflixSwitch(boolean netflixSwitch) {
		this.netflixSwitch = netflixSwitch;
	}

	public boolean isAmazonPrimeSwitch() {
		return amazonPrimeSwitch;
	}

	public void setAmazonPrimeSwitch(boolean amazonPrimeSwitch) {
		this.amazonPrimeSwitch = amazonPrimeSwitch;
	}
}
