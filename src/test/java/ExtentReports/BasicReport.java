package ExtentReports;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BasicReport {
	@Test
public void main() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		
	//create Extent Spark Report
	File path = new File("./src/main/resources/sample.html");
	ExtentSparkReporter spark = new ExtentSparkReporter(path);
	//set configration
	spark.config().setDocumentTitle("main");
	spark.config().setReportName("Manali");
	spark.config().setTheme(Theme.DARK);
	//create extent report
	ExtentReports report = new ExtentReports();
	report.setSystemInfo("os", "window10");
	report.setSystemInfo("browser", "chrome-11");
	//attach spark to extent report
	report.attachReporter(spark);
	//create extent test
	ExtentTest test = report.createTest("main");
	//flush
	report.flush();
	driver.close();
	
}
}
