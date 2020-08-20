package com.rkeeves.pat4.route.validation;

import java.util.LinkedList;
import java.util.List;

import com.rkeeves.pat4.route.data.GameData;
import com.rkeeves.pat4.route.data.Route;

public class RouteValidatorFactory extends ValidatorFactory<Route> {
	
	public Check<Route> createRouteNameLengthAndStringLengthCheck() {
		return compose(
				o->o, 
				o->o.routeName.length()+1 == o.routeNameLen, 
				o->String.format("Route's routeNameLength field %d and actual length %d mismatch: %s",o.routeNameLen, o.routeName.length()+1,o.routeName));
	}
	
	public Check<Route> createRouteNameLengthCheck() {
		return compose(
				Route::getRouteName, 
				s->s.length()<GameData.ROUTE_NAME_MAX_LEN_INCLUDING_NUL, 
				v->String.format("Route name (%d) was longer than the allowed maximum (%d) : %s",v.length(),GameData.ROUTE_NAME_MAX_LEN_INCLUDING_NUL-1,v));
	}
	
	public Check<Route> createRouteSaveNameLengthCheck() {
		return compose(
				Route::getSaveName, 
				s->s.length()<GameData.SAVE_NAME_MAX_LEN_INCLUDING_NUL, 
				v->String.format("Route save name (%d) was longer than the allowed maximum (%d) : %s",v.length(),GameData.SAVE_NAME_MAX_LEN_INCLUDING_NUL-1,v));
	}
	
	public Check<Route> createCityCountWithListLengthMismatchCheck() {
		return compose(
				o->o, 
				o->o.cityCount == o.waypoints.size(), 
				v->String.format("Route had mismatching citycount: expected %d actual %",v.waypoints.size(),v.cityCount));
	}
	
	public Validator<Route> createRouteValidator() {
		List<Check<Route>> l = new LinkedList<Check<Route>>();
		l.add(createRouteNameLengthAndStringLengthCheck());
		l.add(createRouteNameLengthCheck());
		l.add(createRouteSaveNameLengthCheck());
		l.add(createCityCountWithListLengthMismatchCheck());
		return new Validator<Route>(l);
	}
}
