package com.sikuli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.config.ReadDemoGuruProperties;

public class SikuliExample {

	@Test
	public void selectPdfFile() {
		try {
		ReadDemoGuruProperties r=new ReadDemoGuruProperties();
		System.setProperty("webdriver.chrome.driver","D:\\Automation Testing Softeares\\chrome driver\\chromedriver-win64\\chromedriver.exe");
		ChromeDriverService service = new ChromeDriverService.Builder().withLogOutput(System.out).build();
		WebDriver driver = new ChromeDriver(service);
		driver.get("https://www.ilovepdf.com/pdf_to_word");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"pickfiles\"]/span")).click();
			
			  Screen screen=new Screen();
			  
			  Pattern fileName=new
			  Pattern("C:\\Users\\Admin\\eclipse-workspace\\Automation Testing\\Advance_Selenium_Maven_Project_01\\src\\test\\resources\\SikuliDoc\\inpuFileName.png"
			  ); Pattern openButton=new
			  Pattern("C:\\Users\\Admin\\eclipse-workspace\\Automation Testing\\Advance_Selenium_Maven_Project_01\\src\\test\\resources\\SikuliDoc\\openButton.png"
			  );
			  
			  
			  screen.wait(fileName,10); screen.type(
			  fileName,"D:\\Automation Testing Softeares\\Automation Testing Notes\\Automation Testing - Day 10(Java Script).pdf"
			  ); screen.click(openButton);
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
