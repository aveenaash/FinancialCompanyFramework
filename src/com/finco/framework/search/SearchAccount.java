package com.finco.framework.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.finco.framework.model.account.Account;

public class SearchAccount implements ISearchAccount{

	private List<Account> accounts;
	
	public SearchAccount(List<Account> accounts){
		this.accounts = accounts;
	}
	
	@Override
	public List<Account> search(String input) {
		// TODO Auto-generated method stub
		
		SearchPredicate predicate = new SearchPredicate(input);
		
		List<Account> searchResult = new ArrayList<Account>();
		Iterator<Account> accIterator = accounts.iterator();
		
		
		while(accIterator.hasNext()){
			if(predicate.check(accIterator.next())){
				searchResult.add(accIterator.next());
			}
		}
		
		return searchResult;
	}


}
 