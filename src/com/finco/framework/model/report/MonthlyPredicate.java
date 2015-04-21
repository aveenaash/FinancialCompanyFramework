package com.finco.framework.model.report;

import java.util.Date;

import com.finco.framework.model.account.TransactionEntry;
import com.finco.framework.search.IPredicate;

public class MonthlyPredicate implements IPredicate<TransactionEntry>{

	private Date date;
	
	public MonthlyPredicate(Date date){
		this.date = date;
	}
	
	@Override
	public boolean check(TransactionEntry input) {
		// TODO Auto-generated method stub
		return input.getDate().getMonth() == date.getMonth();
	}
}