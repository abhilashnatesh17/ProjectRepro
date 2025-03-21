package TestScript;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Utilities.ScreenshotUtility;
import Utilities.WaitUtilities;

public class Base {
	public WebDriver driver;
	public ScreenshotUtility scrshot; //globally declared
	@BeforeMethod(alwaysRun=true) //always run= true, enn kodukunath group chyn mathram
	@Parameters("browser")
	public void browserInitilazation(String browser) throws Exception  //(String browser ) - cross browser , parameters parayuna annotation vechite ane cross browser use chyune
	{																				//parameters testng provide chyunath ane	
		if(browser.equalsIgnoreCase("chrome"))		//cross browser use chyunath ane
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			throw new Exception("Driver is not available");
		}
	//	driver=new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtilities.IMPLICIT_WAIT));
		driver.manage().window().maximize(); 	
	}
	@AfterMethod(alwaysRun=true)
	
	 public void browserQuit(ITestResult iTestResult) throws IOException { 
	 		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
	 			scrshot = new ScreenshotUtility(); 
	 			scrshot.getScreenShot(driver, iTestResult.getName()); 
	 		} 
	  
	 		 driver.quit(); 
	 	}

}
