package com.rkeeves.pat4.route.validation;

public class ValidationError {

	public ValidationError(String msg) {
		super();
		this.msg = msg;
	}

	public final String msg;

	@Override
	public String toString() {
		return "ValidationError [msg=" + msg + "]";
	}
	
	
}
