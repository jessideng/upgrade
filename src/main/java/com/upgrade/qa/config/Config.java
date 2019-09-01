package com.upgrade.qa.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	public static Properties getConfigs() {
		Properties prop = new Properties();
		
		try{	
			InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties");
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return prop;
	}
}
