package ExtentReports;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClass;
import com.crm.BaseClass.DwsBaseClass;
@Listeners(com.crm.Listeners.ListenersTakeScreenShort.class)
public class TakeScreenShort extends BaseClass{
@Test
public void main() throws InterruptedException {
	driver.findElement(By.xpath("//a[contains(text(),'Digital downloads')]")).click();
	List<WebElement> products = driver.findElements(By.cssSelector("//input[@value='Add to cart']"));
	for (WebElement web : products) {
		web.click();
		Thread.sleep(2000);
	}
	assertEquals("java", "selenium");
}
}
