package TestScript;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Pages.AdminPage;
import Pages.LoginPage;
import Utilities.FakerUtility;

public class AdminTest extends Base{
	@Test
	public void adminuserinfo()
	{
	String username="admin";
	String password="admin";
	
	FakerUtility faker=new FakerUtility(); //faker use chyunath random ayite name varum
	String adminusername=faker.creatARandomFirstName();
	//String adminpassword=faker.creatARandomLastName();
	
		
	//String adminusername="asdgfhj";
	String adminpassword="adminads";

	LoginPage loginpage=new LoginPage(driver);
	
	loginpage.enterUsername(username);
	loginpage.enterPassword(password);
	loginpage.signIn();
	
	AdminPage adminpage=new AdminPage(driver);
	
	adminpage.adminuser();
	adminpage.newvalue();
	adminpage.usernamevalue(adminusername);
	adminpage.passwordvalue(adminpassword);
	adminpage.usertype();
	adminpage.save();
	boolean alertvalue=adminpage.alert();
	Assert.assertTrue(alertvalue, "User is not created");
	
	
	
	}

}
