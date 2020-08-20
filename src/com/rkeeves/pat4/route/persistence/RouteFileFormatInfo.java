package com.rkeeves.pat4.route.persistence;

public class RouteFileFormatInfo {
	/**
	 * Used at the beginning of all autoroute files.
	 */
	public static final int V_CODE = 4;
	
	
	/**
	 * Closing symbol in the tail of the file.
	 */
	public static final byte[] CLOSING_SYMBOL = new byte[] {(byte) 0xfe,(byte) 0xaf,(byte) 0xde,(byte) 0xba};
	

}
