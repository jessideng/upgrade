package com.upgrade.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(name="agreements")
	private WebElement agreements;
	
	@FindBy(css="[data-auto='submitPersonalInfo']")
	private WebElement checkYourRateButton;
	
	


	public PersonalInfoPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		visit("https://www.credify.tech/phone/nonDMFunnel");
	}

}
