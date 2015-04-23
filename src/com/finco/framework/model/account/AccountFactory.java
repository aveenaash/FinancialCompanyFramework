package com.finco.framework.model.account;

import java.util.HashMap;
import java.util.Map;
import java.util.Observer;

public class AccountFactory {

	public static Account account;
	public static Observer observer;

        public static Account getInstance(){
                Account account = new Account();
			
                if(observer != null){
                        account.addObserver(observer);
                }

                return account;
        }
        
}