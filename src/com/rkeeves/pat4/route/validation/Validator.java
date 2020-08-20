package com.rkeeves.pat4.route.validation;

import java.util.LinkedList;
import java.util.List;

public class Validator<T>{

	public Validator(List<Check<T>> checks) {
		super();
		this.checks = checks;
	}

	private final List<Check<T>> checks;
	
	public List<ValidationError> validate(T o) {
		List<ValidationError> l= new LinkedList<ValidationError>();
		for (Check<T> check : checks)
			if(!check.isValid(o))
				l.add(new ValidationError(check.message(o)));
		return l;
	}
	
	
}
