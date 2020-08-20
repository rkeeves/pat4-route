package com.rkeeves.pat4.route.data;

import java.util.ArrayList;

public class GameData {
	
	public static final byte WARE_COUNT = 20;
	
	public static final byte TOWN_COUNT = 32;
	
	public static final float PRICE_FACTOR_MIN = 0.8f;
	
	public static final float PRICE_FACTOR_MAX = 2.0f;
	
	public static final int ROUTE_NAME_MAX_LEN_INCLUDING_NUL = 21;

	public static final int SAVE_NAME_MAX_LEN_INCLUDING_NUL = 31;
	
	private static final String[] townNames = new String[] {
			"EDI",
			"SCA",
			"BOS",
			"LON",
			"BRU",
			"HAA",
			"GRO",
			"COL",
			"BRM",
			"HAM",
			"LUB",
			"ROS",
			"RIP",
			"FLE",
			"AAL",
			"NAE",
			"BRG",
			"STA",
			"OSL",
			"STO",
			"GOT",
			"MAL",
			"AHU",
			"VIS",
			"STE",
			"DAN",
			"THO",
			"KON",
			"RIG",
			"REV",
			"HEL",
			"NOV",
			"NIM",
			"MIN",
			"BRL",
			"ERF",
			"POS",
			"WAR",
			"BRS",
			"KAU"
	};
	
	public static String getTownName(byte idx) {
		return townNames[idx];
	}
	
	public static final float[][] travel_times = 
			new float[][]{
		new float[]{0f},
		new float[]{1f, 0f},
		new float[]{1.6f, 0.6f, 0f},
		new float[]{2.5f, 1.5f, 1.2f, 0f},
		new float[]{2.3f, 1.3f, 1f, 0.7f, 0f},
		new float[]{2.1f, 1.2f, 1.1f, 1.1f, 0.5f, 0f},
		new float[]{2.2f, 1.5f, 1.5f, 1.7f, 1.2f, 0.8f, 0f},
		new float[]{2.7f, 1.9f, 1.7f, 1.6f, 1.1f, 1.1f, 1.7f, 0f},
		new float[]{2.8f, 2.2f, 2.2f, 2.4f, 1.9f, 1.5f, 0.8f, 2.3f, 0f},
		new float[]{2.9f, 2.3f, 2.3f, 2.5f, 2f, 1.6f, 0.9f, 2.4f, 0.7f, 0f},
		new float[]{4.6f, 4.5f, 4.8f, 5.2f, 4.8f, 4.3f, 3.8f, 4.8f, 4f, 3.9f, 0f},
		new float[]{4.5f, 4.4f, 4.7f, 5.1f, 4.7f, 4.2f, 3.7f, 4.7f, 3.8f, 3.8f, 0.3f, 0f},
		new float[]{2.4f, 1.9f, 2.1f, 2.4f, 1.9f, 1.5f, 0.8f, 2.3f, 0.9f, 0.9f, 3.2f, 3.1f, 0f},
		new float[]{4.4f, 4.3f, 4.7f, 5.1f, 4.7f, 4.2f, 3.7f, 4.7f, 3.8f, 3.8f, 0.6f, 0.6f, 3f, 0f},
		new float[]{3.3f, 3.2f, 3.5f, 3.9f, 3.5f, 3f, 2.5f, 3.7f, 2.7f, 2.6f, 1.4f, 1.3f, 1.9f, 1.2f, 0f},
		new float[]{4.1f, 4f, 4.3f, 4.7f, 4.3f, 3.9f, 3.3f, 4.4f, 3.5f, 3.5f, 0.6f, 0.6f, 2.7f, 0.5f, 0.9f, 0f},
		new float[]{2.4f, 2.7f, 3.3f, 3.9f, 3.6f, 3.2f, 2.9f, 3.8f, 3.2f, 3.2f, 3.8f, 3.7f, 2.4f, 3.7f, 2.5f, 3.4f, 0f},
		new float[]{2f, 2.2f, 2.7f, 3.3f, 3f, 2.6f, 2.2f, 3.3f, 2.5f, 2.5f, 3.1f, 3f, 1.7f, 3f, 1.8f, 2.7f, 0.7f, 0f},
		new float[]{3.3f, 3.3f, 3.7f, 4.1f, 3.7f, 3.2f, 2.7f, 3.8f, 2.9f, 2.8f, 2.4f, 2.3f, 2.1f, 2.3f, 1.1f, 2f, 2.5f, 1.8f, 0f},
		new float[]{6.4f, 6.2f, 6.6f, 7f, 6.5f, 6.1f, 5.6f, 6.3f, 5.7f, 5.7f, 2.9f, 2.6f, 4.9f, 3.1f, 3.2f, 3.1f, 5.6f, 4.9f, 4.2f, 0f},
		new float[]{3.1f, 3f, 3.3f, 3.7f, 3.3f, 2.9f, 2.3f, 3.5f, 2.5f, 2.5f, 1.7f, 1.5f, 1.7f, 1.6f, 0.5f, 1.2f, 2.3f, 1.7f, 0.8f, 3.4f, 0f},
		new float[]{4f, 3.9f, 4.2f, 4.6f, 4.2f, 3.7f, 3.2f, 4.2f, 3.3f, 3.3f, 0.8f, 0.6f, 2.6f, 1f, 0.9f, 1f, 3.2f, 2.5f, 1.8f, 2.5f, 1f, 0f},
		new float[]{4.6f, 4.5f, 4.8f, 5.2f, 4.8f, 4.4f, 3.8f, 4.8f, 4f, 4f, 1.2f, 0.9f, 3.2f, 1.4f, 1.5f, 1.4f, 3.8f, 3.2f, 2.4f, 1.9f, 1.7f, 0.7f, 0f},
		new float[]{5.7f, 5.6f, 5.9f, 6.3f, 5.9f, 5.5f, 4.9f, 5.7f, 5.1f, 5f, 2.3f, 2f, 4.3f, 2.4f, 2.6f, 2.5f, 4.9f, 4.3f, 3.5f, 0.8f, 2.7f, 1.8f, 1.2f, 0f},
		new float[]{4.8f, 4.7f, 5f, 5.4f, 5f, 4.5f, 4f, 4.9f, 4.2f, 4.1f, 1.2f, 0.9f, 3.4f, 1.4f, 1.7f, 1.4f, 4f, 3.4f, 2.6f, 2.5f, 1.8f, 0.9f, 0.9f, 1.8f, 0f},
		new float[]{5.6f, 5.5f, 5.8f, 6.2f, 5.8f, 5.3f, 4.8f, 5.6f, 4.9f, 4.9f, 2f, 1.8f, 4.1f, 2.2f, 2.4f, 2.2f, 4.8f, 4.1f, 3.4f, 2.1f, 2.6f, 1.7f, 1.2f, 1.4f, 1.4f, 0f},
		new float[]{5.4f, 5.3f, 5.6f, 6f, 5.6f, 5.2f, 4.7f, 6.3f, 4.9f, 4.9f, 2.4f, 2.2f, 4.2f, 2.6f, 2.8f, 2.6f, 4.8f, 4.2f, 3.6f, 2.4f, 2.9f, 2.1f, 1.7f, 1.8f, 1.8f, 0.7f, 0f},
		new float[]{5.6f, 5.5f, 6f, 6.3f, 5.8f, 5.4f, 4.9f, 5.8f, 5f, 5f, 2.2f, 1.9f, 4.3f, 2.4f, 2.6f, 2.5f, 4.9f, 4.4f, 3.5f, 1.8f, 2.8f, 1.8f, 1.4f, 1.3f, 1.6f, 0.5f, 1.1f, 0f},
		new float[]{7f, 6.8f, 7.2f, 7.6f, 7.1f, 6.7f, 6.2f, 6.8f, 6.3f, 6.3f, 3.5f, 3.2f, 5.5f, 3.7f, 3.8f, 3.7f, 6.2f, 5.5f, 4.8f, 1.7f, 4f, 3.1f, 2.5f, 1.6f, 3f, 2.2f, 2.5f, 1.8f, 0f},
		new float[]{7.3f, 7.2f, 7.5f, 8f, 7.5f, 7.1f, 6.5f, 7.1f, 6.7f, 6.7f, 3.9f, 3.6f, 5.9f, 4.1f, 4.2f, 4.1f, 6.6f, 5.9f, 5.2f, 1.5f, 4.4f, 3.5f, 2.9f, 1.8f, 3.5f, 2.7f, 2.9f, 2.3f, 1.3f, 0f},
		new float[]{7.5f, 7.4f, 7.7f, 8.1f, 7.7f, 7.3f, 6.7f, 7.3f, 6.9f, 6.9f, 4.1f, 3.8f, 6.1f, 4.3f, 4.4f, 4.3f, 6.8f, 6.1f, 5.4f, 1.7f, 4.6f, 3.7f, 3.1f, 2f, 3.7f, 2.9f, 3.1f, 2.5f, 1.6f, 0.3f, 0f},
		new float[]{8.5f, 8.4f, 8.7f, 9f, 8.6f, 8.3f, 7.8f, 9.3f, 7.9f, 7.9f, 5.5f, 5.3f, 7.3f, 5.7f, 5.8f, 5.7f, 7.8f, 7.2f, 6.6f, 3.5f, 6f, 5.1f, 4.6f, 3.7f, 5.1f, 4.5f, 5.1f, 4.2f, 3.3f, 2.3f, 2.1f, 0f}
		};
	
	public static float getTravelTime(int from_town_id, int to_town_id) {
		return (from_town_id >= to_town_id) ? travel_times[from_town_id][to_town_id] : travel_times[to_town_id][from_town_id];
	}
	
	public static float getFullTravelTime(ArrayList<RouteWaypoint> pnts) {
		float accu = 0.0f;
		int n = pnts.size();
		for (int i = 0; i < n; i++)
			accu += 1 + getTravelTime(pnts.get(i).townId, pnts.get((i+1) % n).townId);
		return accu;
	}
	
	private static final Good[] goods = new Good[] {
			new Good((byte) 0, "WOD", 33),
			new Good((byte) 1, "BRI", 33),
			new Good((byte) 2, "GRA", 33),
			new Good((byte) 3, "HEM", 33),
			new Good((byte) 4, "WOL", 50),
			new Good((byte) 5, "RAW", 50),
			new Good((byte) 6, "HON", 50),
			new Good((byte) 7, "SAL", 58),
			new Good((byte) 8, "GOO", 167),
			new Good((byte) 9, "MED", 150),
			new Good((byte) 10, "FAB", 150),
			new Good((byte) 11, "BEE", 75),
			new Good((byte) 12, "STO", 129),
			new Good((byte) 13, "CLO", 350),
			new Good((byte) 14, "CHE", 100),
			new Good((byte) 15, "PIT", 117),
			new Good((byte) 16, "PEL", 300),
			new Good((byte) 17, "MET", 288),
			new Good((byte) 18, "WIN", 400),
			new Good((byte) 19, "SPI", 500)
	};
	
	
	public static Good getGood(byte idx) {
		return goods[idx];
	}
}
