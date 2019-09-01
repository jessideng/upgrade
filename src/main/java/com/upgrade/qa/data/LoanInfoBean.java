package com.upgrade.qa.data;

public class LoanInfoBean {
	
	private String loanAmount;
	private String loanPurpose;
	
	
	public LoanInfoBean(String loanAmount, String loanPurpose) {
		super();
		this.loanAmount = loanAmount;
		this.loanPurpose = loanPurpose;
	}
	
	public LoanInfoBean() {
		super();
		this.loanAmount = "2000";
		//this.loanPurpose = "Pay Off Credit Cards";
		this.loanPurpose = "CREDIT_CARD";
	}
	
	
	
	public String getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getLoanPurpose() {
		return loanPurpose;
	}
	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}
	
}
