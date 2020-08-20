package com.rkeeves.pat4.route.data;

import java.util.ArrayList;

public class RouteFactory {

	public Route createRouteDefault() {
		String s = "undefined";
		return new Route(0, s.length()+1, 0, s, new ArrayList<RouteWaypoint>(), s);
	}
	
	
	public Route createRoute(int cityCount, int routeNameLen, int travelTime, String routeName, ArrayList<RouteWaypoint> waypoints,
			String saveName) {
		return new Route(cityCount, routeNameLen, travelTime, routeName, waypoints, saveName);
	}
}
