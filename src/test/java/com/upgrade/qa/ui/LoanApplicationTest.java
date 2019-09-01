package com.upgrade.qa.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.upgrade.qa.data.LoanInfoBean;
import com.upgrade.qa.data.OfferInfoBean;
import com.upgrade.qa.data.PersonalInfoBean;
import com.upgrade.qa.pages.LoginPage;
import com.upgrade.qa.pages.NonDMFunnelPage;
import com.upgrade.qa.pages.OfferPage;
import com.upgrade.qa.pages.PersonalInfoPage;
import com.upgrade.qa.util.DataGenerator;

public class LoanApplicationTest extends BaseTest{
	private LoanInfoBean loan;
	private PersonalInfoBean personalInfo;
	private int randnumber;
	private String email;
	private static final Logger Logger = LoggerFactory.getLogger(LoanApplicationTest.class);
	
	@BeforeTest
	public void setUp() {
		loan = new LoanInfoBean();
		randnumber = DataGenerator.getRandomNumber(1, 10000);
		email = "candidate" + randnumber +"@upgrade-challenge.com";
		personalInfo = new PersonalInfoBean(email);
		Logger.info("Email: " + email);
	}
	
	@Test
	public void verifyOffer() {
		NonDMFunnelPage nonDMFunnelPage = new NonDMFunnelPage(getDriver());
		PersonalInfoPage personalInfoPage = nonDMFunnelPage.checkYourRate(loan, getDriver());
		OfferPage offerPage = personalInfoPage.createAccount(personalInfo,getDriver());
		System.out.println("loan amount: " + offerPage.getLoanAmout());
		
		OfferInfoBean expected = new OfferInfoBean();
		expected.setLoanAmount(offerPage.getLoanAmout());
		expected.setMonthlyPament(offerPage.getMonthlyPayment());
		expected.setTerm(offerPage.getTerm());
		expected.setInterestRage(offerPage.getInterest());
		expected.setApr(offerPage.getApr());
		
		System.out.println(expected.getApr());
		
		offerPage.signOut();
		
		LoginPage loginPage= new LoginPage(getDriver());
		OfferPage returnedOfferPage = loginPage.signIn(personalInfo, getDriver());
	}
	

}
