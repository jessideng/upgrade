package com.upgrade.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.upgrade.qa.common.TimeConstants;
import com.upgrade.qa.data.LoanInfoBean;
import com.upgrade.qa.data.PersonalInfoBean;


public class LoginPage extends BasePage{
	

	
	@FindBy(css="[data-auto='username']")
	private WebElement username;
	
	@FindBy(css="[data-auto='password']")
	private WebElement password;
	
	@FindBy(css="[data-auto='login']")
	private WebElement signInButton;

    protected static final Logger Logger = LoggerFactory.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		visit("https://www.credify.tech/portal/login");
		waitForPageLoad("login");
	}
	
	public OfferPage signIn(PersonalInfoBean personalInfo,WebDriver driver) {
		enterEmail(personalInfo.getEmail());
		enterPassWord(personalInfo.getPassword());
		click(signInButton);

		waitForPageLoad("personal-information-1");
		return new OfferPage(driver);
	}
	
	public void enterEmail(String email) {
		if(isDisplayed(username)) {
			type(email,username);
		}else {
			Logger.error("Email Text field not displayed");
		}
	}
	
	public void enterPassWord(String passWord) {
		if(isDisplayed(password)) {
			type(passWord,password);
		}else {
			Logger.error("Password Text field not displayed");
		}
	}

}
