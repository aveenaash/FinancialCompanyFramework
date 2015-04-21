package com.finco.framework.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.finco.framework.model.account.IAccount;

public class SearchAccount implements ISearchAccount{

	private List<IAccount> accounts;
	
	public SearchAccount(List<IAccount> accounts){
		this.accounts = accounts;
	}
	
	@Override
	public List<IAccount> search(String input) {
		// TODO Auto-generated method stub
		
		SearchPredicate predicate = new SearchPredicate(input);
		
		List<IAccount> searchResult = new ArrayList<IAccount>();
		Iterator<IAccount> accIterator = accounts.iterator();
		
		
		while(accIterator.hasNext()){
			if(predicate.check(accIterator.next())){
				searchResult.add(accIterator.next());
			}
		}
		
		return searchResult;
	}


}
 