package com.finco.framework.model;

import java.util.Date;

public class Personal extends Customer implements IPersonal{

	private Date birthDate;
	private Company company;
	
	public Personal(String name, String street, String city, String state,
			String zip, Date birthdate, String email) {
		super(name, street, city, state, zip, email);
		// TODO Auto-generated constructor stub
		this.birthDate = birthDate;
	}
	
	public Personal(String name, String street, String city, String state,
			String zip, Date birthdate, String email, Company company) {
		super(name, street, city, state, zip, email);
		// TODO Auto-generated constructor stub
		this.birthDate = birthDate;
		this.company = company;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
