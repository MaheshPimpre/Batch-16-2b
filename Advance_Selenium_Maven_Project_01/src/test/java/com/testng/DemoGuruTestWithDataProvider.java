package com.testng;

import java.io.File;
import java.io.IOException;
import java.util.Set;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.config.ReadDemoGuruProperties;
@Listeners(value = com.testng.TestNGISuiteListnner.class)
public class DemoGuruTestWithDataProvider {

	private static WebDriver driver;
	ReadDemoGuruProperties prop=new ReadDemoGuruProperties();
	static Logger log=LogManager.getLogger(DemoGuruTestWithDataProvider.class);
	@BeforeSuite
	public void oopenChrome() {
		log.info("before suite");

		System.setProperty("webdriver.chrome.driver",ReadDemoGuruProperties.getChromeExe());

		driver = new ChromeDriver();

	}

	@BeforeTest
	public void openUrl() {
		driver.get(ReadDemoGuruProperties.getLoginUrl());
		driver.manage().window().maximize();
	}

	@BeforeClass
	public void getCookies() {
		log.info("before class");
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies);
	}

	@BeforeMethod
	public void clickOnSignIn() {
		log.info("before method");
		try{
			driver.findElement(
		
				By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")).click();
		;
		}catch (Exception e) {
			log.error("Element is not visible ", new RuntimeException());
		}
		

	}

	
	@Test  
	public void loginOnDemoGuru() throws InterruptedException {
		//System.out.println(un + "  " + ps);
		driver.findElement(By.xpath("//input[@name=\"userName\"]")).sendKeys(ReadDemoGuruProperties.getUserName());
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(ReadDemoGuruProperties.getPassword());

		driver.findElement(By.xpath("//input[@name=\"submit\"]")).click();
		log.debug("Login success");
		Thread.sleep(2000);
	}

	@AfterMethod
	public void afterSuite() throws IOException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(file, new File(ReadDemoGuruProperties.getScreenShotDir()));
		log.warn("Captcher screenshot and store in mention location");
	}

	/*
	 * @DataProvider public Object[][] getData(){
	 * 
	 * Object [][]users=new Object[3][2]; users[0][0]="AAAA"; users[0][1]="aaaa";
	 * users[1][0]="QQQQ"; users[1][1]="qqqq"; users[2][0]="BBBB";
	 * users[2][1]="bbbb";
	 * 
	 * //return users;
	 * 
	 * return new Object[] []{ new Object[]{"AAAA","aaaa"}, new
	 * Object[]{"BBBB","bbbb"}, new Object[]{"QQQQ","qqqq"}, new
	 * Object[]{"CCCC","cccc"} }; }
	 */
	@AfterSuite
	public void afterMethod() {
		log.info("After Suite");
		driver.quit();
	}

}
