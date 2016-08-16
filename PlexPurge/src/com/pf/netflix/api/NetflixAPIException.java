package com.pf.netflix.api;

public class NetflixAPIException extends Exception {

	public NetflixAPIException() {
		super();
	}

	public NetflixAPIException(String message) {
		super(message);
	}

	public NetflixAPIException(Throwable cause) {
		super(cause);
	}

	public NetflixAPIException(String message, Throwable cause) {
		super(message, cause);
	}

	public NetflixAPIException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
