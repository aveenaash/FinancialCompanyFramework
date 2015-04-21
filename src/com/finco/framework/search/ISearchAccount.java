package com.finco.framework.search;

import java.util.List;

import com.finco.framework.model.account.IAccount;

public interface ISearchAccount {
	public List<IAccount> search(String input);
}
