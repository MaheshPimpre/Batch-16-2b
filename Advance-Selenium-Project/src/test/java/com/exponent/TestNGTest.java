package com.exponent;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class TestNGTest {

	WebDriver driver;
	@BeforeSuite
	public void openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Auto-Se-Test\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		 driver = new ChromeDriver();
	}
	@BeforeTest
	public void manageWindow() {
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	@BeforeClass
	public void openWebPage() {
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().timeouts().implecitliwait(10, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void beforeMehod() {
		System.out.println("Before Method");
	}
	@Parameters({"username","password"})
	@Test//(dataProvider = "dataProvider")
	public void loginTest(String un,String ps) {
		driver.findElement(By.xpath("//input[@name=\"userName\"]")).sendKeys(un);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(ps);
		driver.findElement(By.cssSelector("input[name='submit']")).click();
	}
	@DataProvider
	public Object[][] dataProvider() {
		/*
		 * Object[][]object=new Object[3][2]; object[0][0]="QQQQ"; object[0][1]="qqqq";
		 * object[1][0]="AAAA"; object[1][1]="aaaa"; object[2][0]="MMMM";
		 * object[2][1]="mmmm"; return object;
		 */
		
		//lazy Loding
		return new Object[][] {
			new Object[] {"QQQQ","qqqq"},
			new Object[] {"AAAA","aaaa"}
		};
	}
	@AfterMethod
	public void takeScreenShot() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a")).click();
		Thread.sleep(5000);
	}
	@AfterClass
	public void deleteCookies() {
		Set<Cookie> cookies = driver.manage().getCookies();
		for(Cookie cookie:cookies) {
			System.out.println(cookie.getName());
		}
	}
	@AfterTest
	public void afterTest() {
		System.out.println("database connections closed");
	}
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
		System.out.println("Thank You");
	}
	
	
}
