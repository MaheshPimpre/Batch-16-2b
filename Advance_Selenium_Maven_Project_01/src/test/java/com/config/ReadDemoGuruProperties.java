package com.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDemoGuruProperties {

	private static Properties properties;

	public ReadDemoGuruProperties() {
		try {
			FileInputStream stream = new FileInputStream(
					"C:\\Users\\Admin\\eclipse-workspace\\Automation Testing\\Advance_Selenium_Maven_Project_01\\src\\test\\resources\\DemoGuruDetails.properties");

			properties = new Properties();
			properties.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("File not found on provided location");
		}
	}

	public static String getChromeExe() {
		return properties.getProperty("chrome.exe");
	}

	public static String getLoginUrl() {
		return properties.getProperty("demoguru.login.url");
	}

	public static String getUserName() {
		return properties.getProperty("demoguru.username");
	}

	public static String getPassword() {
		return properties.getProperty("demoguru.password");
	}

	public static String getScreenShotDir() {
		return properties.getProperty("demoguru.screenshot.dir");
	}

}
