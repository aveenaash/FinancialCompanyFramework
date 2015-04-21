package com.finco.framework.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Observable;

import com.finco.framework.model.Customer;
import com.finco.framework.model.CustomerFactory;
import com.finco.framework.model.ICustomer;
import com.finco.framework.model.account.Account;
import com.finco.framework.model.account.Deposit;
import com.finco.framework.model.account.IAccount;
import com.finco.framework.model.account.TransactionEntry;
import com.finco.framework.model.account.Withdraw;
import com.finco.framework.search.SearchAccount;
import com.framework.finco.ApplicationFactory;

public class AbstractController {
	
	protected List<Account> accountList;
	
	public AbstractController() {
		accountList = new ArrayList<Account>();
		
	}
	
	
	

	void createAccount(){
		
		Account account = new Account(getAccountNumber());
		
		Customer personal = CustomerFactory.getInstance("Personal", "John Doe", "1000 N 4th Street", "Fairfield", "Iowa", "52557", new Date(1990, 8, 19), "john.doe@gmail.com");
		personal.setAccount(account);
		
		TransactionEntry transactionEntry = new TransactionEntry(new Deposit(), 100f, "monthly salary");
		account.addEntry(transactionEntry);
		
		transactionEntry = new TransactionEntry(new Deposit(), 200f, "gift");
		account.addEntry(transactionEntry);
		
		transactionEntry = new TransactionEntry(new Withdraw(), 50f, "buy a mobile");
		account.addEntry(transactionEntry);
		
		accountList.add(account);
		
		
		account = new Account(getAccountNumber());
		
		Customer company = CustomerFactory.getInstance("Company", "Luiz Rodrigage", "1000 N 4th Street", "Fairfield", "Iowa", "52557", null, "luiz.rodrigage@gmail.com");
		
		company.setAccount(account);
		
		transactionEntry = new TransactionEntry(new Deposit(), 20000f, "project money");
		account.addEntry(transactionEntry);
		
		transactionEntry = new TransactionEntry(new Withdraw(), 500f, "buy office stuff");
		account.addEntry(transactionEntry);
		
		
		accountList.add(account);
		
		System.out.println(new Date().toLocaleString());
		//personal
		
	}
	
	
	void createAccount2(){
		
		Account account = new Account(getAccountNumber());
		
		Customer personal = CustomerFactory.getInstance("Personal", "John Doe", "1000 N 4th Street", "Fairfield", "Iowa", "52557", new Date(1990, 8, 19), "john.doe@gmail.com");
		personal.setAccount(account);
		
		TransactionEntry transactionEntry = new TransactionEntry(new Deposit(), 100f, "monthly salary");
		account.addEntry(transactionEntry);
		
		transactionEntry = new TransactionEntry(new Deposit(), 200f, "gift");
		account.addEntry(transactionEntry);
		
		transactionEntry = new TransactionEntry(new Withdraw(), 50f, "buy a mobile");
		account.addEntry(transactionEntry);
		
		accountList.add(account);
		
		
		account = new Account(getAccountNumber());
		
		Customer company = CustomerFactory.getInstance("Company", "Luiz Rodrigage", "1000 N 4th Street", "Fairfield", "Iowa", "52557", null, "luiz.rodrigage@gmail.com");
		
		company.setAccount(account);
		
		transactionEntry = new TransactionEntry(new Deposit(), 20000f, "project money");
		account.addEntry(transactionEntry);
		
		transactionEntry = new TransactionEntry(new Withdraw(), 500f, "buy office stuff");
		account.addEntry(transactionEntry);
		
		
		accountList.add(account);
		
		System.out.println(new Date().toLocaleString());
		//personal
		
	}
	
	private String getAccountNumber() {
		return ((Math.random()*10000000)+"").substring(0, 7);
	}

	void addInterestToAllAccount(){
		for(IAccount account : accountList){
			
		}
	}
	
	void displayAllAccountInformation(){
		for(IAccount account : accountList){
			System.out.println("---------------------------------------------------------");
			System.out.println("Account Number: "+account.getAccountNumber());
			System.out.println("Customer: "+account.getCustomer().toString());
			System.out.println("List of Transaction: ");
			for(TransactionEntry tEntry: account.getTransactionList()){
				System.out.println("Transaction: Amount = "+ tEntry.getAmount()+ ", Transaction Type : " + tEntry.getTransactionType().toString()+ ", Date = "+tEntry.getDate()+ ", Note = " + tEntry.getNote());
			}
			System.out.println("Get Total Balance: "+account.getBalance());
		}
	}
	
	public IAccount getAccount(String accountId){
		int accountIndex = getAccountIndexByAccountId(accountId);
		return (accountList.get(accountIndex) != null)?accountList.get(accountIndex):null;
	}

	private int getAccountIndexByAccountId(String accountId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	
	
	
	
	
}
