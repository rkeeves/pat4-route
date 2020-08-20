package com.rkeeves.pat4.route.data;

/**
 * Passive data class.
 * Represents transaction commands regarding a specific good,
 * for a given trade route stop.
 * 
 * @author rkeeves
 * 
 */
public class TransactionCommand {
	
	public TransactionCommand(
			byte goodId, 
			byte transactionType, 
			float loadPriceFactor,
			float unloadPriceFactor, 
			int loadQty, 
			int unloadQty) 
	{
		super();
		this.goodId = goodId;
		this.transactionType = transactionType;
		this.loadPriceFactor = loadPriceFactor;
		this.unloadPriceFactor = unloadPriceFactor;
		this.loadQty = loadQty;
		this.unloadQty = unloadQty;
	}
	
	public byte getGoodId() {
		return goodId;
	}

	public byte getTransactionType() {
		return transactionType;
	}

	public float getLoadPriceFactor() {
		return loadPriceFactor;
	}

	public float getUnloadPriceFactor() {
		return unloadPriceFactor;
	}

	public int getLoadQty() {
		return loadQty;
	}

	public int getUnloadQty() {
		return unloadQty;
	}

	public byte goodId;
	
	public byte transactionType;
	
	public float loadPriceFactor;
	
	public float unloadPriceFactor;
    
	public int loadQty;
    
	public int unloadQty;

	@Override
	public String toString() {
		return "TransactionCommand [goodId=" + goodId + ", transactionType=" + transactionType + ", loadPriceFactor="
				+ loadPriceFactor + ", unloadPriceFactor=" + unloadPriceFactor + ", loadQty=" + loadQty + ", unloadQty="
				+ unloadQty + "]";
	}
}
