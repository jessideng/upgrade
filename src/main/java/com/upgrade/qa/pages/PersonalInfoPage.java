package com.upgrade.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.upgrade.qa.data.PersonalInfoBean;

public class PersonalInfoPage extends BasePage{
	
	@FindBy(name="borrowerFirstName")
	private WebElement borrowerFirstName;
	
	@FindBy(name="borrowerLastName")
	private WebElement borrowerLastName;
	
	@FindBy(name="borrowerStreet")
	private WebElement borrowerStreet;
	
	@FindBy(name="borrowerCity")
	private WebElement borrowerCity;
	
	@FindBy(name="borrowerState")
	private WebElement borrowerState;
	
	@FindBy(name="borrowerZipCode")
	private WebElement borrowerZipCode;
	
	@FindBy(name="borrowerDateOfBirth")
	private WebElement borrowerDateOfBirth;
	
	@FindBy(name="borrowerIncome")
	private WebElement borrowerIncome;
	
	@FindBy(name="borrowerAdditionalIncome")
	private WebElement borrowerAdditionalIncome;
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(css="div[class='sc-kfGgVZ sc-esjQYD fCisXT']")
	private WebElement agreements;
	
	@FindBy(css="[data-auto='submitPersonalInfo']")
	private WebElement checkYourRateButton;
	
	protected static final Logger Logger = LoggerFactory.getLogger(PersonalInfoPage.class);
	

	public PersonalInfoPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		waitForPageLoad("personal-information-1");
	}
	
	public OfferPage createAccount(PersonalInfoBean personalInfo,WebDriver driver) {
		enterFirstName(personalInfo.getFirstName());
		enterLastName(personalInfo.getLastName());
		enterHomeAddress(personalInfo.getStreetAddress());
		enterCity(personalInfo.getCity());
		enterState(personalInfo.getState());
		enterZip(personalInfo.getZipCode());
		enterDoB(personalInfo.getDateOfBirth());
		enterIncome(personalInfo.getIncome());
		enterAdditionalIncome(personalInfo.getAdditionalIncome());
		
		enterEmail(personalInfo.getEmail());
		enterPassWord(personalInfo.getPassword());
		
		click(agreements);
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		click(checkYourRateButton);
		
		waitForPageLoad("offer-page");
		return new OfferPage(driver);
	}
	
	public void enterFirstName(String firstName) {
		if(isDisplayed(borrowerFirstName)) {
			type(firstName,borrowerFirstName);
		}else {
			Logger.error("First Name Text field not displayed");
		}
	}
	
	public void enterLastName(String lastName) {
		if(isDisplayed(borrowerLastName)) {
			type(lastName,borrowerLastName);
		}else {
			Logger.error("Last Name Text field not displayed");
		}
	}
	
	public void enterHomeAddress(String address) {
		if(isDisplayed(borrowerStreet)) {
			type(address,borrowerStreet);
		}else {
			Logger.error("Home Address Text field not displayed");
		}
	}
	
	public void enterCity(String city) {
		if(isDisplayed(borrowerCity)) {
			type(city,borrowerCity);
		}else {
			Logger.error("City Text field not displayed");
		}
	}
	
	public void enterState(String state) {
		if(isDisplayed(borrowerState)) {
			type(state,borrowerState);
		}else {
			Logger.error("State Text field not displayed");
		}
	}
	
	public void enterZip(String zip) {
		if(isDisplayed(borrowerZipCode)) {
			type(zip,borrowerZipCode);
		}else {
			Logger.error("ZipCode Text field not displayed");
		}
	}
	
	public void enterDoB(String dob) {
		if(isDisplayed(borrowerDateOfBirth)) {
			type(dob,borrowerDateOfBirth);
		}else {
			Logger.error("Date of Birth field not displayed");
		}
	}
	
	public void enterIncome(String income) {
		if(isDisplayed(borrowerIncome)) {
			type(income,borrowerIncome);
		}else {
			Logger.error("Income Text field not displayed");
		}
	}
	
	public void enterAdditionalIncome(String additionalIncome) {
		if(isDisplayed(borrowerAdditionalIncome)) {
			type(additionalIncome,borrowerAdditionalIncome);
		}else {
			Logger.error("Income Text field not displayed");
		}
	}
	
	public void enterEmail(String email) {
			type(email,username);
	}
	
	public void enterPassWord(String passWord) {
		type(passWord,password);
		
	}
	
	
}
