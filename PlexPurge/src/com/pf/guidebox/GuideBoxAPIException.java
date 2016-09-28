package com.pf.guidebox;

public class GuideBoxAPIException extends Exception {

	public GuideBoxAPIException() {
		super();
	}

	public GuideBoxAPIException(String message) {
		super(message);
	}

	public GuideBoxAPIException(Throwable cause) {
		super(cause);
	}

	public GuideBoxAPIException(String message, Throwable cause) {
		super(message, cause);
	}

	public GuideBoxAPIException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
