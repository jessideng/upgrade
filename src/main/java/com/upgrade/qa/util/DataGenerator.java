package com.upgrade.qa.util;

import org.apache.commons.lang3.RandomStringUtils;

public class DataGenerator {
	public static int getRandomNumber(int minimum, int maximum) {
		return minimum + (int)(Math.random() * ((maximum - minimum) + 1));
	}
	
	public static String getRandomString(int length) {
	    boolean useLetters = true;
	    boolean useNumbers = false;
	    return RandomStringUtils.random(length, useLetters, useNumbers);		
	}

}
