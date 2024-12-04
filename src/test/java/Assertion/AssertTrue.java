package Assertion;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AssertTrue {
	@Test
	public void main() {
		EdgeDriver d = null;
		String expected_url = "https://demowebshop.tricentis.com/";
		ChromeDriver driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		String actual_url = driver.getCurrentUrl();
		//assertEquals(actual_url, expected_url);
		assertEquals(actual_url, expected_url, "Im not in dws page");
		Reporter.log("im in dws page");
		WebElement register = driver.findElement(By.className("ico-register"));
		assertTrue(register.isEnabled(), "register button is not enabled..");
		register.click();
		assertNull(d);
		driver.close();
		 }
}
