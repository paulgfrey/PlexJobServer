package com.pf.canistreamit.api;

public class CanIStreamItAPIException extends Exception {

	public CanIStreamItAPIException() {
		super();
	}

	public CanIStreamItAPIException(String message) {
		super(message);
	}

	public CanIStreamItAPIException(Throwable cause) {
		super(cause);
	}

	public CanIStreamItAPIException(String message, Throwable cause) {
		super(message, cause);
	}

	public CanIStreamItAPIException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

