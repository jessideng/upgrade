package com.upgrade.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class OfferPage extends BasePage{
	
	@FindBy(css="[data-auto='userLoanAmount']")
	private WebElement userLoanAmount;
	
	@FindBy(css="[data-auto='defaultMonthlyPayment']")
	private WebElement defaultMonthlyPayment;
	
	@FindBy(css="[data-auto='defaultLoanTerm']")
	private WebElement defaultLoanTerm;
	
	@FindBy(css="[data-auto='defaultLoanInterestRate']")
	private WebElement defaultLoanInterestRate;
	
	@FindBy(css="[data-auto='defaultMoreInfoAPR']")
	private WebElement defaultLoanApr;

	@FindBy(css="label[class='header-nav__toggle']")
	private WebElement menu;
	
	@FindBy(partialLinkText="Sign Out")
	private WebElement signOut;

	private static final Logger Logger = LoggerFactory.getLogger(OfferPage.class);


	public OfferPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		waitForPageLoad("offer-page");
	}
	
	public String getLoanAmout() {
		return getText(userLoanAmount);
	}
	
	public String getMonthlyPayment() {
		return getText(defaultMonthlyPayment);
	}
	
	public String getTerm() {
		return getText(defaultLoanTerm);
	}
	
	public String getInterest() {
		return getText(defaultLoanInterestRate);
	}
	
	public String getApr() {
		return getText(defaultLoanApr);
	}
	
	public void signOut(WebDriver driver) {
		click(menu);
		click(signOut);	
		waitForPageLoad("logout");
	}
}
