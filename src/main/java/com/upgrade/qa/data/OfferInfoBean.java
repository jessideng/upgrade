package com.upgrade.qa.data;

public class OfferInfoBean {
	private String loanAmount;
	private String monthlyPament;
	private String term;
	private String interestRage;
	private String apr;
	
	
	public OfferInfoBean() {
		super();
	}
	
	public OfferInfoBean(String loanAmount, String monthlyPament, String term, String interestRage, String apr) {
		super();
		this.loanAmount = loanAmount;
		this.monthlyPament = monthlyPament;
		this.term = term;
		this.interestRage = interestRage;
		this.apr = apr;
	}
	
	
	public String getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getMonthlyPament() {
		return monthlyPament;
	}
	public void setMonthlyPament(String monthlyPament) {
		this.monthlyPament = monthlyPament;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getInterestRage() {
		return interestRage;
	}
	public void setInterestRage(String interestRage) {
		this.interestRage = interestRage;
	}
	public String getApr() {
		return apr;
	}
	public void setApr(String apr) {
		this.apr = apr;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apr == null) ? 0 : apr.hashCode());
		result = prime * result + ((interestRage == null) ? 0 : interestRage.hashCode());
		result = prime * result + ((loanAmount == null) ? 0 : loanAmount.hashCode());
		result = prime * result + ((monthlyPament == null) ? 0 : monthlyPament.hashCode());
		result = prime * result + ((term == null) ? 0 : term.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OfferInfoBean other = (OfferInfoBean) obj;
		if (apr == null) {
			if (other.apr != null)
				return false;
		} else if (!apr.equals(other.apr))
			return false;
		if (interestRage == null) {
			if (other.interestRage != null)
				return false;
		} else if (!interestRage.equals(other.interestRage))
			return false;
		if (loanAmount == null) {
			if (other.loanAmount != null)
				return false;
		} else if (!loanAmount.equals(other.loanAmount))
			return false;
		if (monthlyPament == null) {
			if (other.monthlyPament != null)
				return false;
		} else if (!monthlyPament.equals(other.monthlyPament))
			return false;
		if (term == null) {
			if (other.term != null)
				return false;
		} else if (!term.equals(other.term))
			return false;
		return true;
	}

}
