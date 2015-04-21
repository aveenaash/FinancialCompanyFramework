package com.finco.framework.model;

public class Address{

	private String street;
	private String city;
	private String state;
	private String zip;
	private String email;
	
	public Address(){
		
	}
	
	public Address(String street, String city, String state, String zip
			, String email){
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", state="
				+ state + ", zip=" + zip + ", email=" + email + "]";
	}

}
