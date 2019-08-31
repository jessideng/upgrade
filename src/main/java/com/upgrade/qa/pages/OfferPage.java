package com.upgrade.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(css=".header-nav__toggle")
	private WebElement menu;
	
	@FindBy(partialLinkText="Sign Out")
	private WebElement signOut;


	public OfferPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		visit("https://www.credify.tech/phone/nonDMFunnel");
	}

}
