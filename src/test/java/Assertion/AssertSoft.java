package Assertion;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertSoft {
@Test
public void main() {
	EdgeDriver d = null;
	String expected_url = "https://demowebshop.tricentis.com/";
	ChromeDriver driver  = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demowebshop.tricentis.com/");
	String actual_url = driver.getCurrentUrl();
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(actual_url, expected_url);
	Reporter.log("im in dws page");
	WebElement register = driver.findElement(By.className("ico-register"));
	sa.assertTrue(register.isEnabled());
	register.click();
	sa.assertNull(d);
	driver.close();
	sa.assertAll();
}


}
