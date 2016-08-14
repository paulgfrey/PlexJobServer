package com.pf.plexapi.model.simple;

public class SimpleMovie {
	private Source source = null;
	private String title = null;
	private String year = null;
	private String movieId = null;
	private String libraryKey = null;
	private String movieKey = null;
	private String mediaFile = null;
	private String netflixId = null;
	private boolean amazonPrime = false;
	
	public SimpleMovie() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieDbId) {
		this.movieId = movieDbId;
		if(movieId != null && movieId.startsWith("tt")) {
			source = Source.IMDB;
		}
		else {
			source = Source.MOVIEDB;
		}
	}

	public String getLibraryKey() {
		return libraryKey;
	}

	public void setLibraryKey(String libraryKey) {
		this.libraryKey = libraryKey;
	}

	public String getMovieKey() {
		return movieKey;
	}

	public void setMovieKey(String movieKey) {
		this.movieKey = movieKey;
	}

	public String getMediaFile() {
		return mediaFile;
	}

	public void setMediaFile(String mediaFile) {
		this.mediaFile = mediaFile;
	}

	@Override
	public String toString() {
		return "title=" + title + 
				"|year=" + year + "|movieId=" + movieId + 
				"|netflixId=" + netflixId + 
				"|libraryKey=" + libraryKey + 
				"|movieKey=" + movieKey + 
				"|mediaFile=" + mediaFile + 
				"|amazonPrime=" + amazonPrime + "|";
	}

	public String getNetflixId() {
		return netflixId;
	}

	public void setNetflixId(String netflixId) {
		this.netflixId = netflixId;
	}

	public boolean isAmazonPrime() {
		return amazonPrime;
	}

	public void setAmazonPrime(boolean amazonPrime) {
		this.amazonPrime = amazonPrime;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}
}
