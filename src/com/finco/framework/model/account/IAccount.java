package com.finco.framework.model.account;

public interface IAccount {
	
	double getBalance();
	
	void addEntry(TransactionEntry transactionEntry);

}
