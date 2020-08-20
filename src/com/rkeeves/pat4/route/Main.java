package com.rkeeves.pat4.route;

import java.io.IOException;

import com.rkeeves.pat4.route.data.RouteWaypoint;
import com.rkeeves.pat4.route.data.Route;
import com.rkeeves.pat4.route.data.RouteFactory;
import com.rkeeves.pat4.route.data.TransactionCommandFactory;
import com.rkeeves.pat4.route.logic.RouteFinalizer;
import com.rkeeves.pat4.route.persistence.RouteFileReader;
import com.rkeeves.pat4.route.persistence.RouteFileSimpleWriter;
import com.rkeeves.pat4.route.persistence.RouteFileWriter;
import com.rkeeves.pat4.route.validation.ValidatorService;

public class Main {

	public static void main(String[] args) {
		if(args.length<3) {
			System.out.println("Specify an in_binary_file, out_binary_file, out_ascci_file");
			return;
		}
		translate_trade_route(args[0],args[1],args[2]);
		System.out.println("In        "+args[0]);
		System.out.println("Bin Out   "+args[1]);
		System.out.println("Ascii Out "+args[2]);
    }
	
	private static void translate_trade_route(String in_binary_file, String out_binary_file, String out_ascci_file) {
		try {
			Route r = new RouteFileReader().readRouteFile(in_binary_file);
			System.out.println("--- Validation Beg ---");
			new ValidatorService()
				.validate(r)
				.forEach(System.out::println);
			System.out.println("--- Validation End ---");
			new RouteFileWriter().writeRouteFile(out_binary_file, r);
			new RouteFileSimpleWriter().writeRouteFile(out_ascci_file, r);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void write_trade_route(String fname,Route r) {
		RouteFileWriter rfw = new RouteFileWriter();
		try {
			rfw.writeRouteFile(fname, r);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Route example_trade_route() {
		Route r = new RouteFactory().createRouteDefault();
		r.routeName = "Route 01";
		r.saveName = "Route 01";
		r.cityCount=1;
		r.waypoints.add(
				new RouteWaypoint(
						(byte) 31, 
						true, 
						false,
						new TransactionCommandFactory()
						.createTransactionCommandArray()));
		r.waypoints.add(
				new RouteWaypoint(
						(byte) 10, 
						true, 
						false,
						new TransactionCommandFactory()
						.createTransactionCommandArray()));
		r.waypoints.add(
				new RouteWaypoint(
						(byte) 18, 
						true, 
						false,
						new TransactionCommandFactory()
						.createTransactionCommandArray()));
		return new RouteFinalizer().finalize(r);
	}
}


