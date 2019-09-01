package com.upgrade.qa.data;

import com.upgrade.qa.util.DataGenerator;

public class PersonalInfoBean {
	
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String dateOfBirth;
	private String income;
	private String additionalIncome;
	private String email;
	private String password;
	
	public PersonalInfoBean() {
		super();
		this.firstName = DataGenerator.getRandomString(6)+"First";
		this.lastName = DataGenerator.getRandomString(6)+"Last";
		this.streetAddress = "123 Market Street";
		this.city = "San Francisco";
		this.state = "CA";
		this.zipCode = "94941";
		this.dateOfBirth = "02/02/1980";
		this.income = "120000";
		this.additionalIncome = "5000";
		this.email = "candidate" + DataGenerator.getRandomNumber(1, 10000) +"@upgrade-challenge.com";
		this.password = "Welcome123";
	}
	
	public PersonalInfoBean(String firstName, String lastName, String streetAddress, String city, String state,
			String zipCode, String dateOfBirth, String income, String additionalIncome, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.dateOfBirth = dateOfBirth;
		this.income = income;
		this.additionalIncome = additionalIncome;
		this.email = email;
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getAdditionalIncome() {
		return additionalIncome;
	}
	public void setAdditionalIncome(String additionalIncome) {
		this.additionalIncome = additionalIncome;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
