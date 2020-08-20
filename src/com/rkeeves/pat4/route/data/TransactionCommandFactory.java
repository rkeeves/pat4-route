package com.rkeeves.pat4.route.data;

public class TransactionCommandFactory {

	public TransactionCommand[] createTransactionCommandArray() {
		TransactionCommand[] a = new TransactionCommand[GameData.WARE_COUNT];
		for (byte i = 0; i < a.length; i++)
			a[i] = createTransactionCommandDefault(i);
		return a;
	}

	public TransactionCommand createTransactionCommandDefault(byte goodId) {
		return new TransactionCommand(goodId, TransactionType.toByte(TransactionType.NO_TRADE), 1.0f, 1.0f, 0, 0);
	}
	
	public TransactionCommand createTransactionCommand(
			byte goodId, 
			byte transactionType, 
			float loadPriceFactor,
			float unloadPriceFactor, 
			int loadQty, 
			int unloadQty) {
		return new TransactionCommand(goodId, transactionType, loadPriceFactor, unloadPriceFactor, loadQty, unloadQty);
	}
}
