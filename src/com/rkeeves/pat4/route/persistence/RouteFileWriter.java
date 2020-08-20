package com.rkeeves.pat4.route.persistence;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.rkeeves.pat4.io.Pat4FileDataOutput;
import com.rkeeves.pat4.io.Pat4LittleEndianDataOutput;
import com.rkeeves.pat4.route.data.GameData;
import com.rkeeves.pat4.route.data.Route;
import com.rkeeves.pat4.route.data.RouteWaypoint;
import com.rkeeves.pat4.route.data.TransactionCommand;

public class RouteFileWriter{
	
	public void writeRouteFile(String outputFile, Route r) throws IOException {
        try (
        		DataOutputStream os = new DataOutputStream(
        			    new BufferedOutputStream(
        			        new FileOutputStream(outputFile)));
        ) {
        	Pat4LittleEndianDataOutput leos = new Pat4LittleEndianDataOutput(os);
            serializeRoute(leos, r);
            os.flush();
            os.close();
        } catch (IOException ex) {
            throw ex;
        }
    }
	
	private void serializeRoute(Pat4FileDataOutput out, Route tr) throws IOException {
		out.writeInt(RouteFileFormatInfo.V_CODE);
		out.writeInt(tr.cityCount);
		out.writeInt(tr.routeNameLen);
		out.writeInt(tr.travelTime);
		out.writeVarLenNulTerminatedString(tr.routeName);;
		for (RouteWaypoint d : tr.waypoints)
			serializeRouteWaypoint(out, d);
		for (byte b : RouteFileFormatInfo.CLOSING_SYMBOL)
			out.writeByte(b);
		out.writeVarLenNulTerminatedString(tr.saveName);
	}
	
	private void serializeRouteWaypoint(Pat4FileDataOutput out, RouteWaypoint c) throws IOException {
		out.writeByte(c.townId);
		out.writeBoolean(c.shouldRepair);
        out.writeBoolean(c.shouldSkip);
        for (int i = 0; i < GameData.WARE_COUNT; i++)
        	serializeTransactionCommand(out,c.transactions[i]);
	}
	
	private void serializeTransactionCommand(Pat4FileDataOutput out, TransactionCommand to) throws IOException {
		out.writeByte(to.goodId);
		out.writeByte(to.transactionType);
		out.writeFloat(to.loadPriceFactor);
		out.writeFloat(to.unloadPriceFactor);
		out.writeInt(to.loadQty);
		out.writeInt(to.unloadQty);
	}
}
