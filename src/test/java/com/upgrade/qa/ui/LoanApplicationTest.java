package com.upgrade.qa.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.upgrade.qa.data.LoanInfoBean;
import com.upgrade.qa.data.OfferInfoBean;
import com.upgrade.qa.data.PersonalInfoBean;
import com.upgrade.qa.pages.LoginPage;
import com.upgrade.qa.pages.NonDMFunnelPage;
import com.upgrade.qa.pages.OfferPage;
import com.upgrade.qa.pages.PersonalInfoPage;

public class LoanApplicationTest extends BaseTest{
	private LoanInfoBean loan;
	private PersonalInfoBean personalInfo;
	private static final Logger Logger = LoggerFactory.getLogger(LoanApplicationTest.class);
	
	@BeforeTest
	public void setUp() {
		loan = new LoanInfoBean();
		personalInfo = new PersonalInfoBean();
		Logger.info("Email: " + personalInfo.getEmail());
	}
	
	@Test
	public void verifyOffer() {
		NonDMFunnelPage nonDMFunnelPage = new NonDMFunnelPage(getDriver());
		PersonalInfoPage personalInfoPage = nonDMFunnelPage.checkYourRate(loan, getDriver());
		OfferPage offerPage = personalInfoPage.createAccount(personalInfo,getDriver());
		
		//Get offer information from offer page
		OfferInfoBean expectedOffer = new OfferInfoBean();
		expectedOffer.setLoanAmount(offerPage.getLoanAmout());
		expectedOffer.setMonthlyPament(offerPage.getMonthlyPayment());
		expectedOffer.setTerm(offerPage.getTerm());
		expectedOffer.setInterestRage(offerPage.getInterest());
		expectedOffer.setApr(offerPage.getApr());
				
		offerPage.signOut(getDriver());
		
		//Log in, get offer information as returned user
		LoginPage loginPage= new LoginPage(getDriver());
		OfferPage returnedOfferPage = loginPage.signIn(personalInfo, getDriver());
		
		if(returnedOfferPage.verifyOfferPageLoad()) {
			OfferInfoBean actualOffer = new OfferInfoBean();
			
			actualOffer.setLoanAmount(returnedOfferPage.getLoanAmout());
			actualOffer.setMonthlyPament(returnedOfferPage.getMonthlyPayment());
			actualOffer.setTerm(returnedOfferPage.getTerm());
			actualOffer.setInterestRage(returnedOfferPage.getInterest());
			actualOffer.setApr(returnedOfferPage.getApr());
			
			//verify offer information matches
			Assert.assertEquals(actualOffer, expectedOffer, "Offers not match");
		}else {
			Assert.fail("Offer page not load propertly within specified time");
		}
			
		
	}
}
