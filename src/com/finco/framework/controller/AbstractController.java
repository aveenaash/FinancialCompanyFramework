package com.finco.framework.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Observable;

import com.finco.framework.model.account.Account;

public abstract class AbstractController {
	
	protected List<Account> accountList;
	
	public AbstractController() {
		
	}

	void createAccount(){
		String accountNumber = getAccountNumber();		
		Account account = new Account(getAccountNumber());
		accountList.add(account);
	}
	
	private String getAccountNumber() {
		return (Math.random()*10000000)+"";
	}

	void addInterestToAllAccount(){
		for(Account account : accountList){
			
		}
	}
	
	
	public Account getAccount(String accountId){
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
