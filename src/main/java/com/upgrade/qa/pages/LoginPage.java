package com.upgrade.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.upgrade.qa.config.Config;
import com.upgrade.qa.data.PersonalInfoBean;


public class LoginPage extends BasePage{

	@FindBy(css="[data-auto='username']")
	private WebElement username;

	@FindBy(css="[data-auto='password']")
	private WebElement password;

	@FindBy(css="[data-auto='login']")
	private WebElement signInButton;

	private static final Logger Logger = LoggerFactory.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		visit(Config.getConfigs().getProperty("baseUrl") + "/portal/login");
		waitForPageLoad("login");
	}

	public OfferPage signIn(PersonalInfoBean personalInfo,WebDriver driver) {
		Logger.info("Login user: " + personalInfo.getEmail() + "/" + personalInfo.getPassword()) ;
		enterEmail(personalInfo.getEmail());
		enterPassWord(personalInfo.getPassword());
		click(signInButton);

		return new OfferPage(driver);
	}

	public void enterEmail(String email) {
		type(email,username);

	}

	public void enterPassWord(String passWord) {
		type(passWord,password);

	}

}
