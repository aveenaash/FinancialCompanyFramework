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
import com.finco.framework.model.account.IAccount;

public abstract class AbstractController {
	
	protected List<IAccount> accountList;
	
	public AbstractController() {
		accountList = new ArrayList<IAccount>();
		
	}

	void createAccount(){
		
		Account account = new Account(getAccountNumber());
		
		
		Customer personal = CustomerFactory.getInstance("Personal", "John Doe", "1000 N 4th Street", "Fairfield", "Iowa", "52557", new Date(1990, 8, 19), "john.doe@gmail.com");
		personal.setAccount(account);
		
		accountList.add(account);
		
		
		account = new Account(getAccountNumber());
		
		Customer company = CustomerFactory.getInstance("Company", "Luiz Rodrigage", "1000 N 4th Street", "Fairfield", "Iowa", "52557", null, "luiz.rodrigage@gmail.com");
		
		company.setAccount(account);
		
		accountList.add(account);
		
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

	public List<IAccount> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<IAccount> accountList) {
		this.accountList = accountList;
	}
	
	
	
	
	
}
