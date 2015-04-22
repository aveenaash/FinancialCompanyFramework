package com.finco.framework.model.account;

import java.io.UnsupportedEncodingException;
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
		if(arg0 == account){
			if(predicate.check(account.getBalance())){
				sendEmail();
			}
		}
	}
	
	private void sendEmail(){
		Email email = new Email();
		email.setEmailTo(account.getCustomer().getAddress().getEmail());
		email.setEmailSubject("Email Notification");
		email.setEmailSubject(getSubject());
		email.setEmailBody(getBody());
		try {
			email.sendEmail();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Email to " + account.getCustomer()+ " has been sent");
	}
	
	public String getSubject(){
		return "Transaction has been performed";
	}
	
	public String getBody(){
		return "The transaction below has been performed\n";
	}
}