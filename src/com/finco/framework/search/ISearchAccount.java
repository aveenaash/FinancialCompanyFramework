package com.finco.framework.search;

import java.util.List;

import com.finco.framework.model.account.Account;
import com.finco.framework.model.account.IAccount;

public interface ISearchAccount {
	public List<Account> search(String input);
}
