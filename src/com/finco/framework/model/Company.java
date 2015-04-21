package com.finco.framework.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Company extends Customer implements ICompany {

	private List<IPersonal> employees = new ArrayList<IPersonal>();
	
	public Company(String name, String street, String city, String state,
			String zip, String email) {
		super(name, street, city, state, zip, email);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addPersonal(IPersonal personal) {
		// TODO Auto-generated method stub
		employees.add(personal);
	}

	@Override
	public void deletePersonal(IPersonal personal) {
		// TODO Auto-generated method stub
		employees.remove(personal);
	}
	
}