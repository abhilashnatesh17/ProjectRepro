package TestScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ManagePage;
import Utilities.ExelUtilities;

public class ManageTest extends Base {
	@Test
	public void userLogin() throws IOException 
	{
		String username="admin";
		String password="admin";
		//String textfield="HELLO WORLD";
		
		String textfield=ExelUtilities.getStringData(1, 0, "managenews");
		
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.enterUsername(username); // already methods loginpage create chythite ond so obj create chythite method call chythe mathi
		loginpage.enterPassword(password);
		loginpage.signIn();
		
		ManagePage managepage=new ManagePage(driver); 
		
		managepage.manageinfo();
		managepage.newbutton();
		managepage.text(textfield);
		managepage.save();
		boolean alertvalue=managepage.alert();
		Assert.assertTrue(alertvalue, "TestCase is Fail");
		
		
	}
}
