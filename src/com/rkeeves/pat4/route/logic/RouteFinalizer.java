package com.rkeeves.pat4.route.logic;

import com.rkeeves.pat4.route.data.GameData;
import com.rkeeves.pat4.route.data.Route;

public class RouteFinalizer {
	public Route finalize(Route r){
		r.routeNameLen = r.routeName.length()+1;
		r.cityCount = r.waypoints.size();
		r.travelTime = (int) Math.rint( GameData.getFullTravelTime(r.waypoints));
		return r;
	}
}
