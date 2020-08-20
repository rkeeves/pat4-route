package com.rkeeves.pat4.route.validation;

public interface Check<T> {

	boolean isValid(T o);
	
	String message(T o);
}
