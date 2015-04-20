package com.finco.framework.model;

import java.util.Date;

public class CustomerFactory {
	
	public ICustomer getInstance(String customerType, String name, String street
			, String city, String state, String zip, Date birthdate, String email){

		if(customerType.equalsIgnoreCase("PERSONAL")){
			ICustomer customer = new Personal(name, street, city, state, zip, birthdate, email);
			return customer;
		}
		else if(customerType.equalsIgnoreCase("COMPANY")){
			ICustomer customer = new Company(name, street, city, state, zip, email);
			return customer;
		}
		
		return null;
	}
	
}
