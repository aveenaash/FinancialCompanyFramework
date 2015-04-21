package com.bank;

import com.finco.framework.model.account.Account;

public class SavingAccount extends Account {

	public SavingAccount() {
		super();
	}
	
	public SavingAccount(String accountNumber) {
		super(accountNumber);
	}

	@Override
	public String getType() {
		return "S";
	}
}
