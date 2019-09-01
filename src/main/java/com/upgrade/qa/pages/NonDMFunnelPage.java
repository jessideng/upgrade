package com.upgrade.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.upgrade.qa.config.Config;
import com.upgrade.qa.data.LoanInfoBean;


public class NonDMFunnelPage extends BasePage{
	
	@FindBy(name="desiredAmount")
	private WebElement desiredAmount;
	
	@FindBy(css="[data-auto='dropLoanPurpose']")
	private WebElement loanPurpose;
	
	@FindBy(css="[data-auto='CheckYourRate']")
	private WebElement checkYourRateButton;

    protected static final Logger Logger = LoggerFactory.getLogger(NonDMFunnelPage.class);

	public NonDMFunnelPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		visit(Config.getBaseUrl() + "/phone/nonDMFunnel");
		waitForPageLoad("nonDMFunnel");
	}
	
	public PersonalInfoPage checkYourRate(LoanInfoBean loan,WebDriver driver) {
		enterLoanAmount(loan.getLoanAmount());
		selectLoanPurpose(loan.getLoanPurpose());
		click(checkYourRateButton);
		
		waitForPageLoad("personal-information-1");
		return new PersonalInfoPage(driver);
		
		
	}
	
	private void enterLoanAmount(String amount) {
		if(isDisplayed(desiredAmount)) {
			type(amount,desiredAmount);
		}else {
			Logger.error("Loan Amount Text field not displayed");
		}
	}
	
	private void selectLoanPurpose(String purpose) {
		if(isDisplayed(loanPurpose)) {
			Select dropdown  = new Select(loanPurpose);
			dropdown.selectByValue(purpose);
		}else {
			Logger.error("Loan Purpose dropdown not displayed");
		}
	}

}
