package com.rkeeves.pat4.route.persistence;

import java.io.IOException;

public class DeserializationException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeserializationException() {
		super();
	}

	public DeserializationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DeserializationException(String arg0) {
		super(arg0);
	}

	public DeserializationException(Throwable arg0) {
		super(arg0);
	}

}
