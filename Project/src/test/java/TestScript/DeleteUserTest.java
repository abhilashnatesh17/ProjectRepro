package TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.DeleteUserPage;
import Pages.LoginPage;

public class DeleteUserTest extends Base {
	@Test
	public void delete()
		{
		
		String username="admin";
		String password="admin";
		
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.signIn();
		
		DeleteUserPage deleteuserpage=new DeleteUserPage(driver);
		deleteuserpage.adminuser();
		deleteuserpage.deleteuser();		
		boolean alertdisplay=deleteuserpage.alert();
		Assert.assertTrue(alertdisplay, "Successfully Deleted");
	}

}
