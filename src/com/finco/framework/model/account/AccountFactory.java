package com.finco.framework.model.account;

import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

import com.bank.AccType;
import com.bank.GoldAccount;
import com.bank.SilverAccount;

public class AccountFactory {

	public static Account account;
	public static Observer observer;
	public static Map<AccType, Account>hashmap=new HashMap<>();
	
//	static
//	{
//		hashmap.put(AccType.CHECKING, new GoldAccount());
//		hashmap.put(AccType.SAVING, new SilverAccount());
//	}
	
	public static Account getInstance(AccType accType){
//		if(accType == AccType.CHECKING){
//			Account account = new GoldAccount();
//			
//			if(observer != null){
//				account.addObserver(observer);
//			}
//			
//			return account;
//		}
//		else if(accType == AccType.SAVING){
//			Account account = new SilverAccount();
//
//			if(observer != null){
//				account.addObserver(observer);
//			}
//			
//			return account;
//		}
                return new Account();
	}
	
}