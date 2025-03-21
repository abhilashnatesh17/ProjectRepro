package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Utilities.ExelUtilities;
import retry.Retry;

public class LoginTest extends Base {
	@Test(groups={"Regression"},retryAnalyzer=retry.Retry.class,description="verify The User Is Able To Login Using Valid Credentials")  // for grouping - regression testing chyn vendite ane, eth method ane regression testing chyano athine @test ( groups=" Eth name ano kodukune ah name koduknm") 
													//retry - package name ,Retry - Class name 
													// description - use chyunath enth ane output kitune enn details ayite kodukn vendite 	
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws IOException
	{
		//String username="admin";	//orginal username "admin"
		//String password="admin";  //orginal password "admin" 
		
		String username=ExelUtilities.getStringData(1,0,"loginpage"); //excel file nine username get chyunath 
		String password=ExelUtilities.getStringData(1,1,"loginpage");// password get chyunath
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.signIn();
		boolean isloaded=loginPage.isHomePageLoaded();
		Assert.assertTrue(isloaded, "Home Page is not loaded when user is entering correct credential");
	}
	@Test(groups={"Regression"}) //evideyum group=name kodutha ee method run akum 
	public void verifyTheUserIsAbleToLoginUsingCorrectUsernameAndWrongPassword() throws IOException
	{
		String username=ExelUtilities.getStringData(2,0,"loginpage");  
		String password=ExelUtilities.getStringData(2,1,"loginpage");
		
		//String username="admin";
		//String password="wrongpassword"; 
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.signIn();
		boolean alertValue=loginPage.redAlert();
		Assert.assertTrue(alertValue, "Password MisMatch");
	} 
	@Test(retryAnalyzer=retry.Retry.class)
	public void verifyTheUserIsAbleToLoginUsingInCorrectUsernameAndCorrectPassword() throws IOException
	{
		String username=ExelUtilities.getStringData(3,0,"loginpage");  
		String password=ExelUtilities.getStringData(3,1,"loginpage");
		
		//String username="wrongusername";
		//String password="admin";  
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.signIn();
		boolean inCorrect=loginPage.incorrectUsername();
		Assert.assertTrue(inCorrect, "Incoorect Username");
	}	
	@Test
	public void verifyTheUserIsAbleToLoginUsingInCorrectUsernameAndInCorrectPassword() throws IOException
	{
		String username=ExelUtilities.getStringData(4,0,"loginpage");  
		String password=ExelUtilities.getStringData(4,1,"loginpage");
		
		//String username="wrongusername";
		//String password="wrongpassword";  
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.signIn();
		boolean inCorrectUserandPass=loginPage.IncorrectUsernameAndPassword();
		Assert.assertTrue(inCorrectUserandPass, "InCorrect Username and Password ");
	}
}	
