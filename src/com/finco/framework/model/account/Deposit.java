package com.finco.framework.model.account;

import java.util.List;

public class Deposit implements TransactionType{

	@Override
	public String toString() {
		return "Deposit";
		
	}

	@Override
	public double getAmount(double amount) {
		return amount;	
	}
	
}
