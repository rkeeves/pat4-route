package com.rkeeves.pat4.route.data;

import java.util.Arrays;
/**
 * Passive data class.
 * Represents one stop point (aka a city) in a trade route.
 * 
 * @author rkeeves
 * 
 */
public class RouteWaypoint {
	
	public RouteWaypoint(byte townId, boolean shouldRepair, boolean shouldSkip, TransactionCommand[] transactions) {
		super();
		this.townId = townId;
		this.shouldRepair = shouldRepair;
		this.shouldSkip = shouldSkip;
		this.transactions = transactions;
	}

	
	public byte getTownId() {
		return townId;
	}

	public boolean isShouldRepair() {
		return shouldRepair;
	}

	public boolean isShouldSkip() {
		return shouldSkip;
	}

	public TransactionCommand[] getTransactions() {
		return transactions;
	}


	/**
	 * The town's id. You can find this in the townlist.ini file
	 */
	public byte townId;
	
	/**
	 * Controls whether to allow repair in the town.
	 */
	public boolean shouldRepair;
	
	/**
	 * Controls whether this checkpoint should be skipped.
	 */
	public boolean shouldSkip;
	
	/**
	 * Each of the 20 wares' commands regarding transactions.
	 * Aka unload/load quantities, prices. 
	 */
	public final TransactionCommand[] transactions;

	@Override
	public String toString() {
		return "Checkpoint [townId=" + townId + ", shouldRepair=" + shouldRepair + ", shouldSkip=" + shouldSkip
				+ ", transactions=" + Arrays.toString(transactions) + "]";
	}
	
	
}
