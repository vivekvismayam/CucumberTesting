package utilityClasses;

/********************************************************************
 *  This is a test class for checking all classess under this package
 ********************************************************************/

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Open chrome and practice site is open.");
		
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Selenium\\Drivers\\chromedriver.exe"); WebDriver driver= new
		 * ChromeDriver(); driver.manage().window().maximize();
		 * driver.manage().deleteAllCookies();
		 * driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 * 
		 * driver.get("https://google.com"); Thread.sleep(2000);
		 * ScreenshotUtility.ScreenshotUtility("Step1"); driver.quit();
		 */
		System.out.println(new Exception().getStackTrace()[0].getMethodName().toString());
	}

}
