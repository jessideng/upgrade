package com.upgrade.qa.data;

public class StateInfo {
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
	private String label;
	private String abbreviation;
	private String minLoanAmount;
	private String minAge;
}
