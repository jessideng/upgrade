package com.upgrade.qa.ui;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.upgrade.qa.data.LoanInfoBean;
import com.upgrade.qa.pages.NonDMFunnelPage;

public class LoanApplicationTest extends BaseTest{
	private NonDMFunnelPage nonDMFunnelPage;
	private LoanInfoBean loan;
	
	@BeforeTest
	public void setUp() {
		nonDMFunnelPage = new NonDMFunnelPage(getDriver());
		loan = new LoanInfoBean();
	}
	
	@Test
	public void verifyOffer() {
		nonDMFunnelPage.checkYourRate(loan, getDriver());
	}
	

}
