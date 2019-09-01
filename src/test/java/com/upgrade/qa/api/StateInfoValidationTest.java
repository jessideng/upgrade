package com.upgrade.qa.api;


import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.upgrade.qa.data.StateInfo;

import io.restassured.response.Response;
import static com.upgrade.qa.util.RestUtils.sendHttpGet;

public class StateInfoValidationTest extends BaseApiTest{
	private static final Logger Logger = LoggerFactory.getLogger(StateInfoValidationTest.class);

	@Test()
	public void testGetStateInfo(){
		Map<String, String> expectedStateInfo = new HashMap<String, String>();
		expectedStateInfo.put("Alabama", "AL");
		expectedStateInfo.put("Alaska", "AK");
		expectedStateInfo.put("Arizona", "AZ");
		expectedStateInfo.put("Arkansas", "AR");
		expectedStateInfo.put("California", "CA");
		expectedStateInfo.put("Connecticut", "CT");
		expectedStateInfo.put("Delaware", "DE");
		expectedStateInfo.put("District of Columbia", "DC");
		expectedStateInfo.put("Florida", "FL");
		expectedStateInfo.put("Georgia", "GA");
		expectedStateInfo.put("Hawaii", "HI");
		expectedStateInfo.put("Idaho", "ID");
		expectedStateInfo.put("Illinois", "IL");
		expectedStateInfo.put("Indiana", "IN");
		expectedStateInfo.put("Kansas", "KS");
		expectedStateInfo.put("Kentucky", "KY");
		expectedStateInfo.put("Louisiana", "LA");
		expectedStateInfo.put("Maine", "ME");
		expectedStateInfo.put("Maryland", "MD");
		expectedStateInfo.put("Massachusetts", "MA");
		expectedStateInfo.put("Michigan", "MI");
		expectedStateInfo.put("Minnesota", "MN");
		expectedStateInfo.put("Mississippi", "MS");
		expectedStateInfo.put("Missouri", "MO");
		expectedStateInfo.put("Montana", "MT");
		expectedStateInfo.put("Nebraska", "NE");
		expectedStateInfo.put("Nevada", "NV");
		expectedStateInfo.put("New Hampshire", "NH");
		expectedStateInfo.put("New Jersey", "NJ");
		expectedStateInfo.put("New Mexico", "NM");
		expectedStateInfo.put("New York", "NY");
		expectedStateInfo.put("North Carolina", "NC");
		expectedStateInfo.put("North Dakota", "ND");
		expectedStateInfo.put("Ohio", "OH");
		expectedStateInfo.put("Oklahoma", "OK");
		expectedStateInfo.put("Oregon", "OR");
		expectedStateInfo.put("Pennsylvania", "PA");
		expectedStateInfo.put("Rhode Island", "RI");
		expectedStateInfo.put("South Carolina", "SC");
		expectedStateInfo.put("South Dakota", "SD");
		expectedStateInfo.put("Tennessee", "TN");
		expectedStateInfo.put("Texas", "TX");
		expectedStateInfo.put("Utah", "UT");
		expectedStateInfo.put("Vermont", "VT");
		expectedStateInfo.put("Virginia", "VA");
		expectedStateInfo.put("Washington", "WA");
		expectedStateInfo.put("Wisconsin", "WI");
		expectedStateInfo.put("Wyoming", "WY");

		Response response = sendHttpGet();
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
		
		String jsonString = response.asString();
		Logger.info(jsonString);
		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
		JsonArray jsonArray = jsonObject.getAsJsonArray("states");
		StateInfo[] states = gson.fromJson(jsonArray, StateInfo[].class);
		Assert.assertEquals(states.length, 48);
		
		Map<String, String> minAgeByState = new HashMap<String, String>();
		Map<String, String> minLoanAmountByState = new HashMap<String, String>();
		Map<String, String> stateNameAbrevation = new HashMap<String, String>();
		int minAgeStateCount = 0;
		String minAgeState = "";
		int minLoanAmtStateCount = 0;
		String minLoanAmtState = "";

		for(StateInfo st: states) {
			stateNameAbrevation.put(st.getLabel(),st.getAbbreviation());
			minAgeByState.put(st.getLabel(), st.getMinAge());
			minLoanAmountByState.put(st.getLabel(), st.getMinLoanAmount());	

			//check for state that has min age of 19
			if(st.getMinAge().equals("19")) {
				minAgeStateCount++;
				minAgeState = st.getLabel();
			}

			//check for state that has min loan amount of 3005
			if(st.getMinLoanAmount().equals("3005.00")) {
				minLoanAmtStateCount++;
				minLoanAmtState = st.getLabel();
			}
		}

		//check for state names
		Assert.assertEquals(stateNameAbrevation, expectedStateInfo, "Returned state names not match expected");
		Assert.assertEquals(minAgeStateCount, 1, "State count has min age of 19 should be 1");
		Logger.info("State has min age of 19: " + minAgeState);
		Assert.assertEquals(minLoanAmtStateCount, 1, "State count has min loan amount of 3005 should be 1");
		Assert.assertEquals(minLoanAmtState, "Georgia", "State has min loan amount of 3005 not match");
	}
}
