package com.framework.finco.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Observable;

import com.finco.framework.model.account.Account;
import com.framework.finco.ApplicationFactory;

public class AbstractController {
	
	protected List<Account> accountList;
	
	public AbstractController() {
		accountList=new ArrayList<Account>();
	}

	public void createAccount(Account account){
		accountList.add(account);
		ApplicationFactory.getFinancialAppFormIntance().loadTableWithData();
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
