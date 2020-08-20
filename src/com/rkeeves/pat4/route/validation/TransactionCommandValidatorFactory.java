package com.rkeeves.pat4.route.validation;

import java.util.LinkedList;
import java.util.List;

import com.rkeeves.pat4.route.data.GameData;
import com.rkeeves.pat4.route.data.TransactionCommand;
import com.rkeeves.pat4.route.data.TransactionType;

public class TransactionCommandValidatorFactory extends ValidatorFactory<TransactionCommand>{
	public Validator<TransactionCommand> createTransactionCommandValidator() {
		List<Check<TransactionCommand>> l = new LinkedList<Check<TransactionCommand>>();
		l.add(createGoodIdCheck());
		l.add(createTransactionTypeCheck());
		l.add(createLoadPriceFactorCheck());
		l.add(createUnloadPriceFactorCheck());
		l.add(createLoadQtyCheck());
		l.add(createUnloadQtyCheck());
		return new Validator<TransactionCommand>(l);
	}
	
	public Check<TransactionCommand> createGoodIdCheck() {
		return compose(
				TransactionCommand::getGoodId, 
				x->0<=x&&x<GameData.WARE_COUNT, 
				v->String.format("Good id (%d) must be in range [0;%d]", v, GameData.WARE_COUNT-1));
	}
	
	public Check<TransactionCommand> createTransactionTypeCheck() {
		return compose(
				TransactionCommand::getTransactionType, 
				x->x>=TransactionType.min()&&x<=TransactionType.max(), 
				v->String.format("Unknown transaction type %02X ", v));
	}
	
	public Check<TransactionCommand> createLoadPriceFactorCheck() {
		return compose(
				TransactionCommand::getLoadPriceFactor, 
				x->x<0 || (x>=GameData.PRICE_FACTOR_MIN&&x<=GameData.PRICE_FACTOR_MAX), 
				v->String.format("Load price factor out of bounds %f ", v));
	}
	
	public Check<TransactionCommand> createUnloadPriceFactorCheck() {
		return compose(
				TransactionCommand::getUnloadPriceFactor, 
				x->x<0 || (x>=GameData.PRICE_FACTOR_MIN&&x<=GameData.PRICE_FACTOR_MAX), 
				v->String.format("Unload price factor out of bounds %f ", v));
	}
	
	public Check<TransactionCommand> createLoadQtyCheck() {
		return compose(
				TransactionCommand::getLoadQty, 
				x->x>=0, 
				v-> String.format("Load quantity less than 0 %d ", v));
	}
	
	public Check<TransactionCommand> createUnloadQtyCheck() {
		return compose(
				TransactionCommand::getUnloadQty, 
				x->x>=0, 
				v-> String.format("Unload quantity less than 0 %d ", v));
	}
	
	
	
}
