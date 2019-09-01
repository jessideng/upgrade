package com.upgrade.qa.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	protected WebDriver driver;
	private static final Logger Logger = LoggerFactory.getLogger(BaseTest.class);

	@BeforeSuite
	public void before() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/drivers/chromedriver");
		System.out.println("driver path" + System.getProperty("user.dir"));
		driver = new ChromeDriver();
		
//		System.setProperty("webdriver.gecko.driver",
//				System.getProperty("user.dir") + "/drivers/geckodriver");
//				driver = new FirefoxDriver();
	}
	
	@AfterSuite
	public void after() {
		Logger.info("cleaning up driver");
		driver.quit();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
}
