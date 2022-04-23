package com.vva.inetbanking.testbase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.internal.annotations.ITest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vva.inetbanking.utility.ConfigDataProvider;
import com.vva.inetbanking.utility.ExcelDataProvider;
import com.vva.inetbanking.utility.Helper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;
	static String configdatapath = "./config/config.properties";
	static String excelDataProviderPath = "./TestData/Data.xlsx";

	public ConfigDataProvider configdataprovider;
	public ExcelDataProvider excelDataProvider;
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReport;
	public ExtentTest extentTest;

	@BeforeSuite
	public void init() {
		configdataprovider = new ConfigDataProvider(configdatapath);
		excelDataProvider = new ExcelDataProvider(excelDataProviderPath);
		
		String extentReporterpath = System.getProperty("user.dir")+"//Reports//inetbanking_"+Helper.getCurrentDateTime()+".html"; 
		htmlReporter = new ExtentHtmlReporter(extentReporterpath); 
		
		htmlReporter.config().setDocumentTitle("Automation Test Reports");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
		
		extentReport.setSystemInfo("HostName", "Local Host");
		extentReport.setSystemInfo("OS", "Windows10");
		extentReport.setSystemInfo("Browser", "Chrome");
		extentReport.setSystemInfo("Environment", "Regression");
		extentReport.setSystemInfo("Tester Name", "Vishal");
	}

	@BeforeMethod
	@Parameters({ "browser" })
	public void setup(@Optional("Chrome") String brwname) {

		if (brwname.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (brwname.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else {
			System.out.println("if browser not match please check with expected browser");
		}

		driver.manage().window().maximize();
		driver.get(configdataprovider.getUrl());
	}

	@AfterMethod
	public void teardown(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			extentTest.fail("Test case Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "Test case Skipped");
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Test case Passed");
		}
		driver.quit();
	}
	
	@AfterTest
	public void flushReport() {
		
		extentReport.flush();
		driver.quit();
	}

}
