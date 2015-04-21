package com.finco.framework.model.account;

import java.util.HashMap;


import java.util.Map;


import com.bank.AccType;
import com.bank.CheckingAccount;
import com.bank.SavingAccount;

public class AccountFactory {

	public static Account account;
	public static Map<AccType, Account>hashmap=new HashMap<>();
	
	static
	{
		hashmap.put(AccType.CHECKING, new CheckingAccount());
		hashmap.put(AccType.SAVING, new SavingAccount());
	}
	public static Account getInstance(AccType accType){
		return hashmap.get(accType);
	}
	

}
