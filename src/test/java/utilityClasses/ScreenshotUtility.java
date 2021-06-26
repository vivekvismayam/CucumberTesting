package utilityClasses;

import java.awt.AWTException;
import java.awt.*;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/********************************************************************
 *  This is a test class for checking all classess under this package
 ********************************************************************/

public class ScreenshotUtility {

	public static String fullScreenshotUtility(String screenshotName) {
		 String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String filename=System.getProperty("user.dir") +"/output/"+screenshotName+dateName+".png";
		try {
			Robot robot=new Robot();
			Rectangle capture =  
		            new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
		            BufferedImage Image = robot.createScreenCapture(capture); 
		            ImageIO.write(Image, "jpg", new File(filename)); 
		            System.out.println("Screenshot saved"); 
			} catch (Exception e) {
			System.out.println("Error occured while capturing Screenshot :"+e);
			return null;
		}
		return filename;
		
	}
	// Below method is just copy pasted
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
        //below line is just to append the date format with the screenshot name to avoid duplicate names		
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") +"/output/"+screenshotName+dateName+".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        //Returns the captured file path
        return destination;
        }
	public static void clearScreenshotfromFolder(String filePath) {
		try  
			{         
				File fileToDelete= new File(filePath);           //file to be delete  
				if(fileToDelete.delete()){  
						System.out.println(fileToDelete.getName() + " deleted");   //getting and printing the file name  
				}  
				else  
				{  
					System.out.println("failed deletion of file");  
				}  
		}  
		catch(Exception e)  
		{  
		e.printStackTrace();  
		}  
		}  
	
}
