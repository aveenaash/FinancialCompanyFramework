package com.framework.finco.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Observable;

import com.bank.CheckingAccount;
import com.bank.SavingAccount;
import com.finco.framework.model.Customer;
import com.finco.framework.model.CustomerFactory;
import com.finco.framework.model.account.Account;
import com.finco.framework.model.account.Deposit;
import com.finco.framework.model.account.TransactionEntry;
import com.finco.framework.model.account.Withdraw;
import com.framework.finco.ApplicationFactory;

public class AbstractController {
	
	protected List<Account> accountList;
	
	public AbstractController() {
		accountList=new ArrayList<Account>();
	}

	public void createAccount(Account account){
		accountList.add(account);
		System.out.println("Account nu "+ account.getAccountNumber());
		System.out.println("Customer Name :"+ account.getCustomer().getName());
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
	
	
	public void loadDummyData(){
		Account account = new CheckingAccount();
		account.setAccountNumber(getAccountNumber());
		Customer personal = CustomerFactory.getInstance("Personal", "John Doe", "1000 N 4th Street", "Fairfield", "Iowa", "52557", new Date(1990, 8, 19), "john.doe@gmail.com");
		personal.setAccount(account);
		
		TransactionEntry transactionEntry = new TransactionEntry(new Deposit(), 100f, "monthly salary");
		account.addEntry(transactionEntry);
		
		transactionEntry = new TransactionEntry(new Deposit(), 200f, "gift");
		account.addEntry(transactionEntry);
		
		transactionEntry = new TransactionEntry(new Withdraw(), 50f, "buy a mobile");
		account.addEntry(transactionEntry);
		
		accountList.add(account);
		
		
		account = new SavingAccount(getAccountNumber());
		
		Customer company = CustomerFactory.getInstance("Company", "Luiz Rodrigage", "1000 N 4th Street", "Fairfield", "Iowa", "52557", null, "luiz.rodrigage@gmail.com");
		
		company.setAccount(account);
		
		transactionEntry = new TransactionEntry(new Deposit(), 20000f, "project money");
		account.addEntry(transactionEntry);
		
		transactionEntry = new TransactionEntry(new Withdraw(), 500f, "buy office stuff");
		account.addEntry(transactionEntry);
		accountList.add(account);
		ApplicationFactory.getFinancialAppFormIntance().loadTableWithData();
		
		
	}
	
}
