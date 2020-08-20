package com.rkeeves.pat4.route.validation;

import java.util.LinkedList;
import java.util.List;

import com.rkeeves.pat4.route.data.GameData;
import com.rkeeves.pat4.route.data.RouteWaypoint;

public class RouteWaypointValidatorFactory extends ValidatorFactory<RouteWaypoint>{

	public Validator<RouteWaypoint> createRouteWaypointValidator() {
		List<Check<RouteWaypoint>> l = new LinkedList<Check<RouteWaypoint>>();
		l.add(createTownIdCheck());
		return new Validator<RouteWaypoint>(l);
	}
	
	public Check<RouteWaypoint> createTownIdCheck() {
		return compose(
				RouteWaypoint::getTownId, 
				x->x>=0&&x<=GameData.TOWN_COUNT, 
				v->String.format("Town id %d larger than max %d", v, GameData.TOWN_COUNT-1));
	}
}
