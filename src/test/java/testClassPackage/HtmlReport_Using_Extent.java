package testClassPackage;

import java.io.IOException;
import java.net.InetAddress;
import com.aventstack.extentreports.markuputils.Markup;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.model.Log;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.github.mkolisnyk.cucumber.runner.ExtendedTestNGRunner;

public class HtmlReport_Using_Extent {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	private static WebDriver driver;
	private static String ssPath;
	
	public static void main(String[] args) throws Exception {
		
		htmlReporter = new ExtentHtmlReporter(".//output//Extendreport.html");
		htmlReporter.config().setEncoding("UTF-8");
		htmlReporter.config().setDocumentTitle("Auto reports");
		htmlReporter.config().setReportName("Report name");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	
		extent=new ExtentReports();
		extent.setSystemInfo("Org 	   :  ","Internal Test Orgs");
		extent.setSystemInfo("Browser  :", "Chrome");
		extent.setSystemInfo("Test Lead:  ",InetAddress.getLocalHost().getHostName());
		
		extent.attachReporter(htmlReporter);
		
		testClass();	
		
		
		extentTest=extent.createTest("Test Extent Pass");
		extentTest.log(Status.PASS, "Pass 1");
		
		//ssPath=utilityClasses.ScreenshotUtility.getScreenshot(driver, "Screenshot");
		ssPath=utilityClasses.ScreenshotUtility.fullScreenshotUtility("test");
		System.out.println(ssPath);
		//extentTest.addScreenCaptureFromPath(ssPath,"Title");
		extentTest.log(Status.PASS,"Passed",MediaEntityBuilder.createScreenCaptureFromPath(ssPath).build());
		extentTest.log(Status.PASS, "Pass 2");
		extent.flush();
		
		extentTest=extent.createTest("Test Extent Fail");
		extentTest.log(Status.PASS, "Pass");
		extentTest.log(Status.PASS, "Pass");
		extentTest.log(Status.PASS, "Pass");
		extentTest.log(Status.FAIL, "Fail");

		//Assert.fail();
		extent.flush();
		
		
		extentTest=extent.createTest("Test Extent Skipped");
		extentTest.log(Status.PASS, "Pass");
		extentTest.log(Status.PASS, "Pass");
		extentTest.log(Status.PASS, "Pass");
		extentTest.log(Status.SKIP, "Skipped");
		//throw new SkipException("Skipping");
		extent.flush();
		System.out.println("Completed");
	}
	public static void testClass(){
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java_Dependencies\\Selenium\\Webdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://facebook.com/login");	
	}
}
