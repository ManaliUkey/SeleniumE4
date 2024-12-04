package BatchExecution;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestCase1 {
	@Test
	public void honda() {
			Reporter.log("Im honda", true);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.honda2wheelersindia.com/");
		driver.close();
	}
	
	@Test
	public void kawasaki() {
			Reporter.log("Im kawasaki", true);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://kawasaki-india.com/");
		driver.close();
	}
	
	@Test(dependsOnMethods = "kawasaki")
	public void royalEndfiled() {
			Reporter.log("Im in royalenfiled", true);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.royalenfield.com/");
		driver.close();
	}
}
