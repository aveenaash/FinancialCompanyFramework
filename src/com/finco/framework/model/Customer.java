package com.finco.framework.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.finco.framework.model.account.Account;
import com.finco.framework.model.account.IAccount;

public abstract class Customer implements ICustomer{

	private String name;
	private Address address;
	private Account account;
	
	public Customer(){
		
	}
		
	public Customer(String name, String street, String city, String state, String zip, String email){
		this.name = name;
		address = new Address(street, city, state, zip, email);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setAccount(Account account) {
		this.account = account;
		this.account.setCustomer(this);
	}

	@Override
	public Account getAccount() {
		return account;
	}

	@Override
	public void sendEmail() {
		
	}

	@Override
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", addresses=" + address + "]";
	}
	
}
