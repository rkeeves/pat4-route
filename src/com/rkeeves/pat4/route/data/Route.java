package com.rkeeves.pat4.route.data;

import java.util.ArrayList;
/**
 * Passive data class representing a trade route.
 * It consists of waypoints (cities).
 * Each city has 1 transaction order for each existing ware.
 * 
 * @author rkeeves
 *
 */
public class Route {
	
	
	

	public Route(int cityCount, int routeNameLen, int travelTime, String routeName, ArrayList<RouteWaypoint> waypoints,
			String saveName) {
		super();
		this.cityCount = cityCount;
		this.routeNameLen = routeNameLen;
		this.travelTime = travelTime;
		this.routeName = routeName;
		this.waypoints = waypoints;
		this.saveName = saveName;
	}

	public int getCityCount() {
		return cityCount;
	}

	public int getRouteNameLen() {
		return routeNameLen;
	}

	public int getTravelTime() {
		return travelTime;
	}

	public String getRouteName() {
		return routeName;
	}

	public ArrayList<RouteWaypoint> getWaypoints() {
		return waypoints;
	}

	public String getSaveName() {
		return saveName;
	}

	public int cityCount;
	
	public int routeNameLen;
	/**
	 * Estimated time for full route in days
	 */
	public int travelTime;
	/**
	 * The route's name. Displayed ingame in the convoy UI.
	 * Max 21 characters INCLUDING delimiter NUL.
	 */
	public String routeName;

	/**
	 * Arbitrary number of checkpoints.
	 */
	public ArrayList<RouteWaypoint> waypoints;

	/**
	 * The route's save name. Displayed ingame in the load route menu.
	 * Max 31 characters INCLUDING delimiter NUL.
	 */
	public String saveName;

	@Override
	public String toString() {
		return "Route [cityCount=" + cityCount + ", routeNameLen=" + routeNameLen + ", travelTime=" + travelTime
				+ ", routeName=" + routeName + ", waypoints=" + waypoints + ", saveName=" + saveName + "]";
	}

	

	

	
}
