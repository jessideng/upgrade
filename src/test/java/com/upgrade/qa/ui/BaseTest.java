package com.upgrade.qa.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	protected WebDriver driver;
	
	@BeforeSuite
	public void before() {
		   System.setProperty("webdriver.chrome.driver",
                   System.getProperty("user.dir") + "/drivers/chromedriver");
           driver = new ChromeDriver();
//		driver = new FirefoxDriver();
	}
	
	@AfterSuite
	public void after() {
		driver.quit();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
