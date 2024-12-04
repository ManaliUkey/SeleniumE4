package Basic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsingDataProvider {
	@DataProvider(name = "login")
	public Object[][] provider() throws EncryptedDocumentException, IOException{
		//Object[][] obj = new Object[2][2];
		/*
		 * one way but hardcoding 
		obj[0][0]="manaliukey70@gmail.com";
		obj[0][1]="123456";
		obj[1][0]="hena12@gmail.com";
		obj[1][1]="123456";
		
		//second way
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\DwsLogin.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("sheet1");
		obj[0][0]=sheet.getRow(0).getCell(0).toString();
		obj[0][1]=sheet.getRow(0).getCell(1).toString();
		obj[1][0]=sheet.getRow(1).getCell(0).toString();
		obj[1][1]=sheet.getRow(1).getCell(1).toString();
		*/
		//Third way
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\DwsLogin.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int row = sheet.getPhysicalNumberOfRows();
		int colom = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] obj = new Object[row][colom];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < colom; j++) {
				obj[i][j]= sheet.getRow(i).getCell(j).toString();
			}
		}
	
				return obj;
	}

	
	@Test(dataProvider = "login")
	public void reciver(String username,String password) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.get("https://demowebshop.tricentis.com/");
		 driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.id("Email")).sendKeys(username);
		 Thread.sleep(1000);
		 driver.findElement(By.id("Password")).sendKeys(password);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("//input[@value='Log in']")).click();
		 Thread.sleep(1000);
		 driver.close();
	}
}
