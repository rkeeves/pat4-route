package com.rkeeves.pat4.route.validation;

import java.util.function.Function;

public class ComposableCheck<T,U> implements Check<T> {

	@Override
	public boolean isValid(T o) {
		return composed_check.apply(o);
	}

	@Override
	public String message(T o) {
		return composed_msgGenerator.apply(o);
	}

	public ComposableCheck(Function<T,U> getter, Function<U,Boolean> check, Function<U,String> msgGenerator) {
		this.composed_check = check.compose(getter);
		this.composed_msgGenerator = msgGenerator.compose(getter);
	}

	private Function<T,Boolean> composed_check;
	
	private Function<T,String> composed_msgGenerator;
}
