package com.test.FreeCRMExample;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCRMTest1 {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		// driver.get("https://accounts.google.com/ServiceLogin/identifier?flowName=GlifWebSignIn&flowEntry=AddSession");
		driver.get("https://accounts.google.com/signin");
	}

	@Test
	public void verifyFreeCRMLogin() throws InterruptedException {

		driver.findElement(By.id("identifierId")).sendKeys("sinsy.sajeev@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys("sinsy1984");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='https://mail.google.com']")).click();

		// https://accounts.google.com/ServiceLogin/identifier?hl=en-GB&flowName=GlifWebSignIn&flowEntry=AddSession
	}

	
	 @AfterMethod
	 public void tearDown() { 
		 driver.close();
	  
	  }
	 

}
