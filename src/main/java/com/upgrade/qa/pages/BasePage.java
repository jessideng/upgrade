package com.upgrade.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;

import com.upgrade.qa.common.TimeConstants;


public class BasePage {

	private WebDriver driver;
	private static final Logger Logger = LoggerFactory.getLogger(BasePage.class);

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void visit(String url) {
		Logger.info("Navigate to url: " + url);
		driver.get(url);
	}

	public void click(WebElement locator) {
		if(isDisplayed(locator)) {
			try {	
				WebDriverWait wait = new WebDriverWait(driver, TimeConstants.TIMEOUT);
				wait.until(ExpectedConditions.elementToBeClickable(locator));
				JavascriptExecutor ex=(JavascriptExecutor) driver;
				ex.executeScript("arguments[0].click()", locator);
			}catch(ElementClickInterceptedException e) {
				Logger.info("Try click again");
				JavascriptExecutor ex=(JavascriptExecutor) driver;
				ex.executeScript("arguments[0].click()", locator);
			}
			
		}else {
			Logger.error(locator.toString() + " not present");
			Assert.fail("Click failed, " + locator.toString() + " not present");
		}	
	}

	public void type(String inputText, WebElement locator) {
		if(isDisplayed(locator)) {
			locator.sendKeys(inputText);
		}else {
			Logger.error(locator.toString() + " not present");
			Assert.fail();
		}
		
	}
	
	public String getText(WebElement locator) {
		if(isDisplayed(locator)) {
			return locator.getText();
		}else {
			Assert.fail();
			return "";
		}
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
		WebDriverWait wait = new WebDriverWait(driver, TimeConstants.LONG_TIMEOUT);
		wait.until(ExpectedConditions.urlContains(url));
	}

}
