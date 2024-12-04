package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DwsPageLogin {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	String expectedUrl = "https://demowebshop.tricentis.com/";
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://demowebshop.tricentis.com/");
	String actualUrl = driver.getCurrentUrl();
	if(expectedUrl.equals(actualUrl)) {
		FileInputStream fis = new FileInputStream("D:\\ExcelSelenium\\DwsLogin.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		String email1 = sheet.getRow(0).getCell(0).toString();
		String password1 = sheet.getRow(0).getCell(1).toString();
		String serachdata = sheet.getRow(0).getCell(2).toString();
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.id("Email")).sendKeys(email1);
		driver.findElement(By.id("Password")).sendKeys(password1);
		driver.findElement(By.id("RememberMe")).click();
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		driver.findElement(By.id("small-searchterms")).sendKeys(serachdata);
		driver.findElement(By.linkText("Log out"));

		
	}
	else {
		System.out.println("not in dws page");
		driver.close();
	}
	driver.close();
}
}
