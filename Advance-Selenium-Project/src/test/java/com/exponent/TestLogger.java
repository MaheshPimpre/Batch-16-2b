package com.exponent;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestLogger {

	public static WebDriver driver;
	public static Logger log;
	public static void main(String[] args) {

		log= LogManager.getLogger(TestLogger.class);

		System.setProperty("webdriver.chrome.driver", "D:\\Auto-Se-Test\\chromedriver-win64\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
		log.info("Logged into Myntra");
		try {
			boolean text= driver.findElement(By.xpath("//a[contains(text(),'Women')]")).isDisplayed();
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
			log.error("Exception occured", new Exception("Element Not Found"));
		}
		finally {
			driver.quit();
			log.info("Quitting the driver");
			log.debug("Debug log");
			log.warn("Warning log");
			log.trace("trace");
			log.fatal("Fatal log");
		}
	}	
}
