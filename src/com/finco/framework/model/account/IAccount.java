package com.finco.framework.model.account;

import java.util.List;

import com.finco.framework.model.Customer;
import com.finco.framework.model.ICustomer;

public interface IAccount {
	
	double getBalance();
	
	void addEntry(TransactionEntry transactionEntry);
	
	void setCustomer(Customer customer);
	
	ICustomer getCustomer();
	
	String getAccountNumber();
	
	String getType();
	List<TransactionEntry> getTransactionList();

}
