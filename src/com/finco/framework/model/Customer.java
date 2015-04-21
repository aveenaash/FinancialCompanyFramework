package com.finco.framework.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Customer implements ICustomer{

	private String name;
	private List<IAddress> addresses = new ArrayList<IAddress>();
	private List<IAccount> accounts = new ArrayList<IAccount>();
	
	
	public Customer(String name, String street, String city, String state, String zip
			, String email){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void addAccount(IAccount account) {
		// TODO Auto-generated method stub
		accounts.add(account);
	}

	@Override
	public void removeAccount(IAccount account) {
		// TODO Auto-generated method stub
		accounts.remove(account);
	}

	@Override
	public void sendEmail() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAddress(IAddress address) {
		// TODO Auto-generated method stub
		addresses.add(address);
	}

	@Override
	public void removeAddress(IAddress address) {
		// TODO Auto-generated method stub
		addresses.remove(address);
	}

}
