package com.upgrade.qa.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class Config {
//	public  static String baseUrl;
//
//	public static String getBaseUrl() {
//		
//
//		try{	
//			Properties prop = new Properties();
//			InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties");
//			prop.load(input);
//
//			//get the property value 
//			baseUrl = prop.getProperty("baseUrl");
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}finally {
//			baseUrl = "https://www.credify.tech";
//		}
//		return baseUrl;
//	}
	
	public static Properties getConfigs() {
		Properties prop = new Properties();
		
		try{	
			InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties");
			prop.load(input);

			//get the property value 
//			baseUrl = prop.getProperty("baseUrl");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return prop;
	}
}
