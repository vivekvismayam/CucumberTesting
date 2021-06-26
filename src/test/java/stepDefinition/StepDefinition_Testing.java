package stepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class StepDefinition_Testing {
	
	WebDriver driver;
	
	@Given("Open the Chrome and start the application")
	public void open_the_firefox_and_start_the_application() {
		System.out.println("Open the Chrome and start the application");
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://twitter.com/login");		
		
	}

	@When("I enter valid username and password")
	public void i_enter_valid_username_and_password() throws InterruptedException {
		System.out.println("Enter valid username and password");
		Thread.sleep(3000);
		driver.findElement(By.name("session[username_or_email]")).sendKeys("email.com");
		driver.findElement(By.name("session[password]")).sendKeys("twitterpassword");
		Thread.sleep(2000);
		
	    
	}

	@Then("User should be able to login")
	public void user_should_be_able_to_login() throws InterruptedException {

		driver.findElement(By.cssSelector(("div.css-1dbjc4n.r-13awgt0.r-12vffkv div.css-1dbjc4n.r-13awgt0.r-12vffkv div.css-1dbjc4n.r-13qz1uu.r-417010:nth-child(2) main.css-1dbjc4n.r-16y2uox.r-1wbh5a2 div.css-1dbjc4n.r-150rngu.r-16y2uox.r-1wbh5a2 div.css-1dbjc4n.r-1jgb5lz.r-1x0uki6.r-1ye8kvj.r-1j3t67a.r-13qz1uu div.css-1dbjc4n.r-13qz1uu div.css-1dbjc4n div.css-1dbjc4n:nth-child(8) div.css-18t94o4.css-1dbjc4n.r-urgr8i.r-42olwf.r-sdzlij.r-1phboty.r-rs99b7.r-1w2pmg.r-vlx1xi.r-zg41ew.r-1jayybb.r-17bavie.r-1ny4l3l.r-15bsvpr.r-o7ynqc.r-6416eg.r-lrvibr div.css-901oao.r-1awozwy.r-jwli3a.r-6koalj.r-18u37iz.r-16y2uox.r-1qd0xha.r-a023e6.r-b88u0q.r-1777fci.r-eljoum.r-dnmrzs.r-bcqeeo.r-q4m81j.r-qvutc0 span.css-901oao.css-16my406.css-bfa6kz.r-1qd0xha.r-ad9z0x.r-bcqeeo.r-qvutc0 > span.css-901oao.css-16my406.r-1qd0xha.r-ad9z0x.r-bcqeeo.r-qvutc0"))).click();
		//new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(login));
		String title=driver.getTitle();
		System.out.println("Title= "+title);
		System.out.println("User should be able to login");
		assertTrue((title=="Home / Twitter"),"Login failed");
	}
	@Then("logout of the application")
	public void logout_of_the_application() throws InterruptedException {
		System.out.println("logout of the application");
		Thread.sleep(20000);
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='react-root']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='react-root']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/span[1]/span[1]")).click();
		System.out.println("logged out Successfully");
		driver.close();
	}
}
