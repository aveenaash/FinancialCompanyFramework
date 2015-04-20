package com.finco.framework.model;

public interface ICustomer {
	public void addAccount(IAccount account);
	public void removeAccount(IAccount account);
	public void sendEmail();
}
