package com.finco.framework.search;

import com.finco.framework.model.account.Account;

public class SearchPredicate implements IPredicate<Account>{

	private String keyword;
	
	public SearchPredicate(String keyword){
		this.keyword = keyword;
	}
	
	@Override
	public boolean check(Account input) {
		// TODO Auto-generated method stub
		return input.getAccountNumber().contains(keyword) 
				|| input.getCustomer().getName().contains(keyword);
	}

}
