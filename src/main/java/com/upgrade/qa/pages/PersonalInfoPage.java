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
		click(checkYourRateButton);

		waitForPageLoad("offer-page");
		return new OfferPage(driver);
	}

	public void enterFirstName(String firstName) {
		Logger.info("FirstName: " + firstName);
		type(firstName,borrowerFirstName);
	}

	public void enterLastName(String lastName) {
		Logger.info("LastName: " + lastName);
		type(lastName,borrowerLastName);
	}

	public void enterHomeAddress(String address) {
		type(address,borrowerStreet);
	}

	public void enterCity(String city) {
		type(city,borrowerCity);
	}

	public void enterState(String state) {
		type(state,borrowerState);
	}

	public void enterZip(String zip) {
		type(zip,borrowerZipCode);
	}

	public void enterDoB(String dob) {
		type(dob,borrowerDateOfBirth);
	}

	public void enterIncome(String income) {
		type(income,borrowerIncome);
	}

	public void enterAdditionalIncome(String additionalIncome) {
		type(additionalIncome,borrowerAdditionalIncome);
	}

	public void enterEmail(String email) {
		Logger.info("Email: " + email);
		type(email,username);
	}

	public void enterPassWord(String passWord) {
		Logger.info("Password: " + passWord);
		type(passWord,password);
	}


}
