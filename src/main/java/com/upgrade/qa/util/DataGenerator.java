package com.upgrade.qa.util;

public class DataGenerator {
	public static int getRandomNumber(int minimum, int maximum) {
		return minimum + (int)(Math.random() * ((maximum - minimum) + 1));
	}

}
