package com.pf.plexapi;

public class PlexAPIException extends Exception {

	public PlexAPIException() {
	}

	public PlexAPIException(String message) {
		super(message);
	}

	public PlexAPIException(Throwable cause) {
		super(cause);
	}

	public PlexAPIException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlexAPIException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
