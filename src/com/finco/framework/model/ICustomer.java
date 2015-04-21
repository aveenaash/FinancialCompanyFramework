package com.finco.framework.model;

import com.finco.framework.model.account.IAccount;

public interface ICustomer {
	public void addAccount(IAccount account);
	public void removeAccount(IAccount account);
	public void addAddress(IAddress address);
	public void removeAddress(IAddress address);
	public void sendEmail();
}
