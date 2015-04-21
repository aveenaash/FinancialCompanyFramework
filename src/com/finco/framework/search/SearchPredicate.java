package com.finco.framework.search;

import com.finco.framework.model.account.IAccount;

public class SearchPredicate implements IPredicate<IAccount>{

	private String keyword;
	
	public SearchPredicate(String keyword){
		this.keyword = keyword;
	}
	
	@Override
	public boolean check(IAccount input) {
		// TODO Auto-generated method stub
		return input.getAccountNumber().contains(keyword) 
				|| input.getCustomer().getName().contains(keyword);
	}

}
