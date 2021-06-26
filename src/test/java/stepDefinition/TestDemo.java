package stepDefinition;

import static org.testng.Assert.*;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.primitives.Bytes;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import utilityClasses.ScreenshotUtility;


public class TestDemo {
	WebDriver driver;
	Integer i=1;
	@Given("Open chrome and practice site is open.")
	public void open_chrome_and_practice_site_is_open() {
		System.out.println("Open chrome and practice site is open.");
	   System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Drivers\\chromedriver.exe");
	   driver= new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   
	   driver.get("http://automationpractice.com/index.php");
	   
	  // ScreenshotUtility.ScreenshotUtility(new Exception().getStackTrace()[0].getMethodName().toString());
	   //Screenshot name set to Step1_Methodname
	   ScreenshotUtility.fullScreenshotUtility("Step"+(i++).toString()+"-"+new Exception().getStackTrace()[0].getMethodName().toString());

	   String title = driver.getTitle();
	   System.out.println("title :"+ title);
	   assertTrue(title.equals("My Store"));
	   
	}
	
	@When("I fill details and click login")
	public void i_fill_details_and_click_login() throws Exception {
		System.out.println("I fill details and click login");
		Thread.sleep(4000);
		driver.findElement(By.className("login")).click();
		Thread.sleep(4000);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		
		driver.findElement(By.id("email")).sendKeys("alternateemailforlearning@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("passwd")).sendKeys("password1");
		Thread.sleep(2000);
		
	   //ScreenshotUtility.ScreenshotUtility(new Exception().getStackTrace()[0].getMethodName().toString());
	   //Screenshot name set to Step1_Methodname
	   ScreenshotUtility.fullScreenshotUtility("Step"+(i++).toString()+"-"+new Exception().getStackTrace()[0].getMethodName().toString());
	   
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(1000);
		System.out.println("Success");		
	}
	
	@Then("User logged in successfully")
	public void user_logged_in_successfully() throws Exception {
	   String title=driver.getTitle();
		Thread.sleep(1000);
		
		//ScreenshotUtility.ScreenshotUtility(new Exception().getStackTrace()[0].getMethodName().toString());
		//Screenshot name set to Step1_Methodname
		ScreenshotUtility.fullScreenshotUtility("Step"+(i++).toString()+"-"+new Exception().getStackTrace()[0].getMethodName().toString());
		   
		System.out.println("Title :"+title);
		assertTrue(title.equals("My account - My Store"), "Success");
	   
	}
	@Then("Logout")
	public void Logout() throws Exception {
		System.out.println("Logging out");
	    Thread.sleep(1000);
	    driver.findElement(By.className("logout")).click();
   	    //ScreenshotUtility.ScreenshotUtility(new Exception().getStackTrace()[0].getMethodName().toString());
	    //Screenshot name set to Step1_Methodname
		ScreenshotUtility.fullScreenshotUtility("Step"+(i++).toString()+"-"+new Exception().getStackTrace()[0].getMethodName().toString());	    System.out.println("Log out Success");
	}
	    
	@Then("Close browser")
	public void close_browser() throws Exception {
		System.out.println("Close browser");
		//ScreenshotUtility.ScreenshotUtility(new Exception().getStackTrace()[0].getMethodName().toString());
		//Screenshot name set to Step1_Methodname
		ScreenshotUtility.fullScreenshotUtility("Step"+(i++).toString()+"-"+new Exception().getStackTrace()[0].getMethodName().toString());
		   
		 Thread.sleep(1000);
	    driver.close();

	}
	@After
	public void if_Failed(Scenario scenario){
		if (scenario.isFailed()) {
			System.out.println("Failed");
			final byte[] screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot,"image/png","name");
			System.out.println("Screenshot done");
			
			
		}
	}
	
}