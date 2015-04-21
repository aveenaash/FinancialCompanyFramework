package com.finco.framework.model.account;

import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

import com.bank.AccType;
import com.bank.CheckingAccount;
import com.bank.SavingAccount;

public class AccountFactory {

	public static Account account;
	public static Observer observer;
	public static Map<AccType, Account>hashmap=new HashMap<>();
	
	static
	{
		hashmap.put(AccType.CHECKING, new CheckingAccount());
		hashmap.put(AccType.SAVING, new SavingAccount());
	}
	
	public static Account getInstance(AccType accType){
		if(accType == AccType.CHECKING){
			Account account = new CheckingAccount();
			
			if(observer != null){
				account.addObserver(observer);
			}
			
			return account;
		}
		else if(accType == AccType.CHECKING){
			Account account = new SavingAccount();

			if(observer != null){
				account.addObserver(observer);
			}
			
			return account;
		}
		return null;
	}
	
}