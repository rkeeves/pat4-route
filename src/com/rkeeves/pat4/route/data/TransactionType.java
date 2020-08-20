package com.rkeeves.pat4.route.data;

public enum TransactionType {
	NO_TRADE,
	AUTO_TRADE,
	MANUAL_TRADE,
	UNKNOWN;
	
	public static TransactionType fromByte(byte c) {
		switch (c) {
		case 0:
			return NO_TRADE;
		case 1:
			return AUTO_TRADE;
		case 2:
			return MANUAL_TRADE;
		default:
			return UNKNOWN;
		}
	}
	
	public static byte min() {return 0;}
	
	public static byte max() {return 3;}
	
	public static byte toByte(TransactionType t) {
		switch (t) {
		case NO_TRADE:
			return 0;
		case AUTO_TRADE:
			return 1;
		case MANUAL_TRADE:
			return 2;
		default:
			return 0;
		}
	}
}
