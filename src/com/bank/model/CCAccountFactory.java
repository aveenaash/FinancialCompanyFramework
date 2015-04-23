package com.bank.model;

import com.finco.framework.model.account.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

import com.bank.AccType;
import com.bank.BronzeAccount;
import com.bank.GoldAccount;
import com.bank.SilverAccount;

public class CCAccountFactory extends AccountFactory{

	public static Account account;
	public static Observer observer;
	public static Map<AccType, Account>hashmap=new HashMap<>();
	
	static
	{
		hashmap.put(AccType.GOLD, new GoldAccount());
		hashmap.put(AccType.SILVER, new SilverAccount());
                hashmap.put(AccType.BRONZE, new BronzeAccount());
	}
	
	public static Account getInstance(AccType accType){
		if(accType == AccType.GOLD){
			Account account = new GoldAccount();
			
			if(observer != null){
				account.addObserver(observer);
			}
			
			return account;
		}
		else if(accType == AccType.SILVER){
			Account account = new SilverAccount();

			if(observer != null){
				account.addObserver(observer);
			}
			
			return account;
		}
                else if(accType == AccType.BRONZE){
			Account account = new BronzeAccount();

			if(observer != null){
				account.addObserver(observer);
			}
			
			return account;
		}
                return null;
	}
	
}