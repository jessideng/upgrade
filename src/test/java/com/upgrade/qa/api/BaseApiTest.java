package com.upgrade.qa.api;

import static io.restassured.RestAssured.get;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;

import com.upgrade.qa.config.Config;

public class BaseApiTest {
	
	private String baseURI = Config.getConfigs().getProperty("baseApiUri");
	private static final Logger Logger = LoggerFactory.getLogger(BaseApiTest.class);
	
	
	@BeforeSuite
	public void setUp() {
		RestAssured.baseURI = baseURI;
	}

	public Response sendHttpGet(String path) {
		Logger.info("API get endpoint: " + baseURI + path);
		Response response = get(path);
		return response;
	}
}
