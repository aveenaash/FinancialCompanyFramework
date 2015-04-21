package com.finco.framework.search;

public class SearchFunctor<String> implements IFunctor<String>{

	private String value;
	
	@Override
	public void compute(String input) {
		// TODO Auto-generated method stub
		if(value.equals(input)){
			
		}
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	
}
