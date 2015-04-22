package com.finco.framework.model.account;

import com.finco.framework.search.IPredicate;

public class EmailPredicate implements IPredicate<Double>{

	private double value;
	
	public EmailPredicate(Double value){
		this.value = value;
	}
	
	@Override
	public boolean check(Double input) {
		// TODO Auto-generated method stub
		if(input > value){
			return true;
		}
		return false;
	}
	
}
