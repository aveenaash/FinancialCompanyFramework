package com.finco.framework.model.account;

import java.util.Observable;
import java.util.Observer;

import com.finco.framework.search.IPredicate;

public class EmailObserver implements Observer{

	private Account account;
	private IPredicate<Double> predicate;
	
	public EmailObserver(Account account, IPredicate<Double> predicate){
		this.account = account;
		this.predicate = predicate;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
//		if(arg0==account){
//			if(predicate.check(account.getBalance())){
//				sendEmail();
//			}
//		}
	}
	
	private void sendEmail(){
		
	}
}