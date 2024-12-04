package com.crm.Listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.BaseClass.BaseClass;
import com.crm.BaseClass.DwsBaseClass;

public class ListenersTakeScreenShort extends BaseClass implements ITestListener{

	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test = report.createTest(name);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.INFO, "OnTestSuccess");
		test.log(Status.PASS, name+ " is Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.INFO, "OnTestFailure");
		test.log(Status.FAIL, name+ " is failure");
		TakesScreenshot ts = (TakesScreenshot) driver;
		String from = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(from);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getMethod().getMethodName();
		test.log(Status.INFO, "OnTestSkipped");
		test.log(Status.SKIP, name+ " is Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		//create ExtentReportSparkReporter
		spark = new ExtentSparkReporter("./src/main/resources/Testcase.html");
		spark.config().setDocumentTitle("screenshort for report");
		spark.config().setReportName("Manali");
		spark.config().setTheme(Theme.DARK);
		//create ExtentReports
		report = new ExtentReports();
		report.setSystemInfo("Os", "Linux");
		report.setSystemInfo("browser", "chrome-11");
		//attach spark
		report.attachReporter(spark);
		//create extent test
	}
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	

}