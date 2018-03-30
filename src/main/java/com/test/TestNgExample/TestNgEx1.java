package com.test.TestNgExample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgEx1 {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com");

	}

	
	

	@Test(priority = 3, groups = { "links" })
	public void verifyGmailLink() {
		boolean b = driver.findElement(By.linkText("Gmail")).isDisplayed();
		Assert.assertTrue(b, "Link is present");

	}
	
	@Test
	public void googleSearchTest(){
		
	driver.findElement(By.id("lst-ib")).sendKeys("news");
	driver.findElement(By.name("btnK")).click();
		
		
		
		String title=driver.getTitle();
		System.out.println(title);
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
