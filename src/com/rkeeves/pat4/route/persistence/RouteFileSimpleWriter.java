package com.rkeeves.pat4.route.persistence;

import java.io.IOException;
import java.io.PrintWriter;

import com.rkeeves.pat4.route.data.GameData;
import com.rkeeves.pat4.route.data.Good;
import com.rkeeves.pat4.route.data.Route;
import com.rkeeves.pat4.route.data.RouteWaypoint;
import com.rkeeves.pat4.route.data.TransactionCommand;
import com.rkeeves.pat4.route.data.TransactionType;

public class RouteFileSimpleWriter {
	public void writeRouteFile(String outputFile, Route r) throws IOException {
        try (
        		PrintWriter  os = new PrintWriter (outputFile);
        ) {
            serializeRoute(os, r);
            os.flush();
            os.close();
        } catch (IOException ex) {
            throw ex;
        }
    }
	
	private void serializeRoute(PrintWriter out, Route tr) throws IOException {
		out.println(String.format("[%s]",tr.saveName));
		out.println(String.format("  route = %s",tr.routeName));
		out.println(String.format("  route_name_len = %s",tr.routeNameLen));
		out.println(String.format("  cities = %s",tr.cityCount));
		out.println(String.format("  travel_time = %s",tr.travelTime));
		for (RouteWaypoint d : tr.waypoints)
			serializeRouteWaypoint(out, d);
	}
	
	private void serializeRouteWaypoint(PrintWriter  out, RouteWaypoint c) throws IOException {
		out.println(String.format("[%d - %s]",c.townId,GameData.getTownName(c.townId)));
		out.println("    repair = "+c.shouldRepair);
		out.println("    skip = "+c.shouldSkip);
        for (int i = 0; i < GameData.WARE_COUNT; i++)
        	serializeTransactionCommand(out,c.transactions[i]);
	}
	
	private void serializeTransactionCommand(PrintWriter  out, TransactionCommand to) throws IOException {
		Good g = GameData.getGood(to.goodId);
		out.println(String.format("    [%d - %s]", g.id, g.name));
		out.println(String.format("      trade = %s", TransactionType.fromByte(to.transactionType).toString()));
		if(to.loadPriceFactor >=0)
			out.println(String.format("      loadPrice   = %d (%f)", (int) (g.base_price*to.loadPriceFactor),to.loadPriceFactor));
		else
			out.println("      loadPrice   = FROM_WAREHOUSE");
		if(to.loadQty != 2147483647)
			out.println(String.format("      loadQty     = %d", to.loadQty));
		else
			out.println("      loadQty     = MAX");
		if(to.loadPriceFactor >=0)
			out.println(String.format("      unloadPrice = %d (%f)", (int) (g.base_price*to.unloadPriceFactor),to.unloadPriceFactor));
		else
			out.println("      unloadPrice = TO_WAREHOUSE");
		if(to.unloadQty != 2147483647)
			out.println(String.format("      unloadQty   = %d", to.unloadQty));
		else
			out.println("      unloadQty   = MAX");
	}
}
