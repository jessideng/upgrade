package com.upgrade.qa.util;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestUtils {
	public static void setBaseURI (String baseURI){
		RestAssured.baseURI = baseURI;
	}

	public static void setBasePath(String basePath){
		RestAssured.basePath = basePath;
	}

	public static Response sendHttpGet() {
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET);
		return response;
	}
}
