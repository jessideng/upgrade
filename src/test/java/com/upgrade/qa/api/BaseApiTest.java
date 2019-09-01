package com.upgrade.qa.api;

import static com.upgrade.qa.util.RestUtils.setBasePath;
import static com.upgrade.qa.util.RestUtils.setBaseURI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;

import com.upgrade.qa.config.Config;

public class BaseApiTest {
	
	private String baseURI = Config.getConfigs().getProperty("baseApiUri");
	private String basePath = Config.getConfigs().getProperty("baseApiPath");
	private static final Logger Logger = LoggerFactory.getLogger(BaseApiTest.class);
	
	
	@BeforeSuite
	public void setUp() {
		setBaseURI(baseURI);
		setBasePath(basePath);
		Logger.info("API endpoint: " + baseURI + basePath);
	}	
}
