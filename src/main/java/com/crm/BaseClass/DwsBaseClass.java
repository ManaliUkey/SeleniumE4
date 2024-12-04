package com.crm.BaseClass;

//import org.testng.annotations.BeforeClass;
//
//public class DwsBaseClass {
//	@BeforeClass
//public void precondition() {
//	
//}
//}
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class DwsBaseClass {
	 public static WebDriver driver = null;
	 
	 @BeforeSuite
	 public void beforesuite() {
		 System.out.println("its before suite");
	 }
	 
	 @BeforeTest
	 public void beforetest() {
		 System.out.println("its before test");
	 }
	
	 @Parameters({"browser","url"})
	 @BeforeClass
	 public void PreCondition(String browser,String url) {
		 if(browser.equalsIgnoreCase("chrome")){
			 
		 driver = new ChromeDriver() ;
		 }
		 else if(browser.equalsIgnoreCase("firefox")) {
			 driver = new FirefoxDriver();
		 }
		 else if(browser.equalsIgnoreCase("edge")) {
		 }
		 else {
			 driver = new ChromeDriver() ;
		 }
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		 driver.get(url);
	 }
	 
	 @Parameters({"email","password"})
	 @BeforeMethod
	 public void Login(String email,String password) throws InterruptedException {
		 driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.id("Email")).sendKeys(email);
		 Thread.sleep(2000);
		 driver.findElement(By.id("Password")).sendKeys(password);
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@value='Log in']")).click();
		 Thread.sleep(2000);
	 }
	 @AfterMethod
	 public void Logout() {
		 driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
	 }
	 @AfterClass
	 public void PostCondition() {
		 driver.quit();

	 }
	 @AfterTest
	 public void aftertest() {
		 System.out.println("its After test");
	 }
	 
	 @AfterSuite
	 public void afterClass() {
		 System.out.println("After suite");
	 }


}