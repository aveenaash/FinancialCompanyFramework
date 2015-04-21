package com.finco.framework.model;

import com.finco.framework.model.account.Account;
import com.finco.framework.model.account.IAccount;

public interface ICustomer {
	public void setAccount(Account account);
	public Account getAccount();
	public void setAddress(Address address);
	public Address getAddress();
	public void sendEmail();
	public String getName();
	public String getType();
}
