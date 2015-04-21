package com.finco.test;

import java.util.Date;

import com.finco.framework.model.CustomerFactory;
import com.finco.framework.model.ICustomer;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ICustomer personal = CustomerFactory.getInstance("Personal", "John Doe", "1000 N 4th Street", "Fairfield", "Iowa", "52557", new Date(1990, 8, 19), "john.doe@gmail.com");
		
		ICustomer company = CustomerFactory.getInstance("Company", "John Doe", "1000 N 4th Street", "Fairfield", "Iowa", "52557", null, "john.doe@gmail.com");
		
		
	}

}
