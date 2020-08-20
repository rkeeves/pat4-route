package com.rkeeves.pat4.route.validation;

import java.util.LinkedList;
import java.util.List;

import com.rkeeves.pat4.route.data.Route;
import com.rkeeves.pat4.route.data.RouteWaypoint;
import com.rkeeves.pat4.route.data.TransactionCommand;

public class ValidatorService {
	
	public ValidatorService() {
		super();
		this.vRoute = new RouteValidatorFactory().createRouteValidator();
		this.vWp = new RouteWaypointValidatorFactory().createRouteWaypointValidator();
		this.vTrx = new TransactionCommandValidatorFactory().createTransactionCommandValidator();
	}
	
	public ValidatorService(Validator<Route> vRoute, Validator<RouteWaypoint> vWp,
			Validator<TransactionCommand> vTrx) {
		super();
		this.vRoute = vRoute;
		this.vWp = vWp;
		this.vTrx = vTrx;
	}

	private Validator<Route> vRoute;
	
	private Validator<RouteWaypoint> vWp;
	
	private Validator<TransactionCommand> vTrx;	
	
	public List<ValidationError> validate(Route o){
		List<ValidationError> l = new LinkedList<ValidationError>();
		l.addAll(vRoute.validate(o));
		for (RouteWaypoint wp : o.waypoints)
			l.addAll(validate(wp));
		return l;
	}
	
	public List<ValidationError> validate(RouteWaypoint o){
		List<ValidationError> l = new LinkedList<ValidationError>();
		l.addAll(vWp.validate(o));
		for (TransactionCommand trx : o.transactions)
			l.addAll(validate(trx));
		return l;
	}
	
	public List<ValidationError> validate(TransactionCommand r){
		return vTrx.validate(r);
	}
}
