package com.finco.framework.search;

import java.util.List;

import com.finco.framework.model.account.Account;

public interface ISearchAccount {
	public List<Account> search(String input);
}
