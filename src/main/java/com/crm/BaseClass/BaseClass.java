package com.crm.BaseClass;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
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

public class BaseClass {
public static WebDriver driver = null;	
	
	@BeforeSuite
	public void  beforeSuite()
	{
		System.out.println("BeforeSuite");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("BeforeTest");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("AfterTest");
	}
	@BeforeClass
	public static void preCondition() {
	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
	}
	
	
	@BeforeMethod
	public static void login() throws InterruptedException, EncryptedDocumentException, IOException
	{
		driver.findElement(By.className("ico-login")).click();
		
		driver.findElement(By.id("Email")).sendKeys("manaliukey70@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("123456");
		driver.findElement(By.id("RememberMe")).click();
		driver.findElement(By.className("login-button")).click();
	}
	
	@AfterMethod
	public static void logout()
	{
		driver.findElement(By.className("ico-logout")).click();
	}
	@AfterClass
	public static void postCondition()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void  afterSuite()
	{
		System.out.println("AfterSuite");
	}
}


	
	

