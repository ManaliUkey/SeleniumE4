package PageObjectModel;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.pom.DwsLogin;

public class Login {
	@Test
public void main() {
	WebDriver driver  = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demowebshop.tricentis.com/");
	assertEquals("https://demowebshop.tricentis.com/",driver.getCurrentUrl());
	DwsLogin pom =  new DwsLogin(driver);
	pom.login("manaliukey70@gmail.com", "123456");
}
}
