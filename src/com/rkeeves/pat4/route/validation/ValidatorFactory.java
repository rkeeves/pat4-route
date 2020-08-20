package com.rkeeves.pat4.route.validation;

import java.util.function.Function;

public class ValidatorFactory<T> {
	
	protected <U> Check<T> compose(Function<T,U> getter, Function<U,Boolean> check, Function<U,String> messageFactory) {
		return new ComposableCheck<T, U>(
				getter, 
				check, 
				messageFactory);
	}

}
