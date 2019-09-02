package com.upgrade.qa.data;

public class StateInfoBean {
	
	private String label;
	private String abbreviation;
	private String minLoanAmount;
	private String minAge;
	
	
	public StateInfoBean() {
		super();
	}
	public StateInfoBean(String label, String abbreviation, String minLoanAmount, String minAge) {
		super();
		this.label = label;
		this.abbreviation = abbreviation;
		this.minLoanAmount = minLoanAmount;
		this.minAge = minAge;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getMinLoanAmount() {
		return minLoanAmount;
	}
	public void setMinLoanAmount(String minLoanAmount) {
		this.minLoanAmount = minLoanAmount;
	}
	public String getMinAge() {
		return minAge;
	}
	public void setMinAge(String minAge) {
		this.minAge = minAge;
	}
}
