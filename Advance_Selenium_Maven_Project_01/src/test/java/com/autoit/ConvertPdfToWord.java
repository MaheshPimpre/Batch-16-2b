package com.autoit;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.config.ReadDemoGuruProperties;

public class ConvertPdfToWord {

	public static void selectFileToConvertWord() {
		try {
			Thread.sleep(3000);
			Runtime.getRuntime().exec("D:\\Automation Testing Softeares\\PdfToWord2.exe");
		} catch (IOException  e) {
			e.printStackTrace();
		}
		catch (InterruptedException  e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void convertPdfToWordFile() {
		ReadDemoGuruProperties r=new ReadDemoGuruProperties();
		System.setProperty("webdriver.chrome.driver",ReadDemoGuruProperties.getChromeExe());

		WebDriver driver = new ChromeDriver();
		driver.get("https://smallpdf.com/pdf-to-word");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/header/div[2]/div/div/label/form/label/div/div[2]/div[2]/button[1]/span"))
		.click();
		selectFileToConvertWord();
				System.out.println("Select File success");
	}
}
