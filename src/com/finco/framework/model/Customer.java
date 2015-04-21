package com.finco.framework.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.finco.framework.model.account.IAccount;

public class Customer implements ICustomer{

	private String name;
	private List<IAddress> addresses = new ArrayList<IAddress>();
	private List<IAccount> accounts = new ArrayList<IAccount>();
	
	private IAccount account;
		
	public Customer(String name, String street, String city, String state, String zip, String email){
		this.name = name;
		addresses.add(new Address(street, city, state, zip, email));
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void addAccount(IAccount account) {
		accounts.add(account);
		account.setCustomer(this);
	}

	@Override
	public void removeAccount(IAccount account) {
		accounts.remove(account);
	}

	@Override
	public void sendEmail() {
		
	}

	@Override
	public void addAddress(IAddress address) {
		addresses.add(address);
	}

	@Override
	public void removeAddress(IAddress address) {
		addresses.remove(address);
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", addresses=" + addresses + "]";
	}

	
	
	

}
