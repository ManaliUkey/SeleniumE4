package Assertion;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class HardAssert {
@Test
public void main() {
	String expected_url = "https://demowebshop.tricentis.com";
	ChromeDriver driver  = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demowebshop.tricentis.com/");
	String actual_url = driver.getCurrentUrl();
	//assertEquals(actual_url, expected_url);
	assertEquals(actual_url, expected_url, "Im not in dws page");
	Reporter.log("im in dws page");
	driver.findElement(By.className("ico-register")).click();
	driver.close();
}
}
