package com.upgrade.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import com.upgrade.qa.common.TimeConstants;

public class BasePage {

	private WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void visit(String url) {
		driver.get(url);
	}

	public void click(WebElement locator) {
		locator.click();
	}

	public void type(String inputText, WebElement locator) {
		locator.sendKeys(inputText);
	}

	public Boolean isDisplayed(WebElement locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, TimeConstants.TIMEOUT);
			wait.until(ExpectedConditions.visibilityOf(locator));
		}catch(TimeoutException exception) {
			return false;
		}

		return true;
	}
	
	public void waitForPageLoad(String url) {
		WebDriverWait wait = new WebDriverWait(driver, TimeConstants.TIMEOUT);
		wait.until(ExpectedConditions.urlContains(url));
	}

}
