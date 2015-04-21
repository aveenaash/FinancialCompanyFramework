package com.finco.framework.model.account;

import java.util.ArrayList;
import java.util.List;

import com.finco.framework.model.Customer;
import com.finco.framework.model.ICustomer;

public class Account implements IAccount{
	
	private String accountNumber;
	private Customer customer;
	private List<TransactionEntry> transactionList;
	private double currentBalance; 
	
	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
		this.transactionList = new ArrayList<TransactionEntry>();
		this.currentBalance = 0;
	}
	
	@Override
	public double getBalance() {
		if(currentBalance == 0){
			this.calculateBalance();
		}
		return currentBalance;		
	}
	
	public void calculateBalance(){
		for(TransactionEntry transaction: transactionList){
			currentBalance += transaction.getTransactionType().getAmount(transaction.getAmount());
		}		
	}
	
	@Override
	public void addEntry(TransactionEntry transactionEntry) {
		if(!this.transactionList.contains(transactionEntry)){
			this.transactionList.add(transactionEntry);
		}
	}
	
	public void removeEntry(TransactionEntry transactionEntry) {
		if(this.transactionList.contains(transactionEntry)){
			this.transactionList.remove(transactionEntry);
		}
	}
	
	//getters and setters
	
	@Override
	public void setCustomer(Customer customer){
		this.customer = customer;
	}
	
	@Override
	public Customer getCustomer() {
		return customer;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public List<TransactionEntry> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<TransactionEntry> transactionList) {
		this.transactionList = transactionList;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customer="
				+ customer + ", transactionList=" + transactionList
				+ ", currentBalance=" + currentBalance + "]";
	}
	
	

	
		
}
