package com.rkeeves.pat4.route.persistence;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.rkeeves.pat4.io.Pat4FileDataInput;
import com.rkeeves.pat4.io.Pat4LittleEndianDataInput;
import com.rkeeves.pat4.route.data.GameData;
import com.rkeeves.pat4.route.data.Route;
import com.rkeeves.pat4.route.data.RouteFactory;
import com.rkeeves.pat4.route.data.RouteWaypoint;
import com.rkeeves.pat4.route.data.TransactionCommand;

public class RouteFileReader {
	public Route readRouteFile(String outputFile) throws IOException {
        try (
        		DataInputStream in = new DataInputStream(
        			    new BufferedInputStream(
        			        new FileInputStream(outputFile)));
        ) {
        	Pat4LittleEndianDataInput lein = new Pat4LittleEndianDataInput(in);
            Route r = deserializeRoute(lein);
            in.close();
            return r;
        } catch (IOException ex) {
            throw ex;
        }
    }
	
	public Route deserializeRoute(Pat4FileDataInput in) throws IOException {
		vcodeCheck(in);
		int cityCount = in.readInt();
		if(cityCount<0)
			throw new DeserializationException(String.format("Invalid city count %d", cityCount));
		int routeNameLen = in.readInt();
		int travelTime = in.readInt();
		String routeName = in.readVarLenNulTerminatedString();
		ArrayList<RouteWaypoint> waypoints = new ArrayList<RouteWaypoint>();
		for (int i = 0; i < cityCount; i++)
			waypoints.add(deserializeRouteWaypoint(in));
		closingSymbolCheck(in);
		String saveName = in.readVarLenNulTerminatedString();
		return new RouteFactory()
				.createRoute(cityCount, 
						routeNameLen, 
						travelTime, 
						routeName, 
						waypoints, 
						saveName);
	}

	private void vcodeCheck(Pat4FileDataInput in) throws IOException {
		int v_code = in.readInt();
		if(v_code != RouteFileFormatInfo.V_CODE)
			throw new DeserializationException(String.format("Expected V_CODE 0x%08X got 0x%08X", RouteFileFormatInfo.V_CODE,v_code));
	}
	
	private void closingSymbolCheck(Pat4FileDataInput in) throws IOException {
		for (int i = 0; i < RouteFileFormatInfo.CLOSING_SYMBOL.length; i++) {
			byte b = in.readByte();
			if(b != RouteFileFormatInfo.CLOSING_SYMBOL[i])
				throw new DeserializationException(String.format("Closing symbol mismatch expected 0x%02X, got 0x%02X. Maybe there are more towns in the file than indicated at the start?", RouteFileFormatInfo.CLOSING_SYMBOL[i],b));
		}
	}
	
	private RouteWaypoint deserializeRouteWaypoint(Pat4FileDataInput in) throws IOException {
		byte townId = in.readByte();
		boolean shouldRepair = in.readBoolean();
		boolean shouldSkip = in.readBoolean();
		TransactionCommand[] arr = new TransactionCommand[GameData.WARE_COUNT];
		for (int i = 0; i < GameData.WARE_COUNT; i++)
			arr[i] = deserializeTransactionCommand(in);
		return new RouteWaypoint(townId, shouldRepair, shouldSkip,arr);
	}
	
	private TransactionCommand deserializeTransactionCommand(Pat4FileDataInput in) throws IOException {
		byte good_id = in.readByte();
		byte transactionType = in.readByte();
		float load_price_factor = in.readFloat();
		float unload_price_factor = in.readFloat();
		int load_qty = in.readInt();
		int unload_qty = in.readInt();
		return new TransactionCommand(good_id,transactionType, load_price_factor, unload_price_factor, load_qty, unload_qty);
	}
	
	
}
