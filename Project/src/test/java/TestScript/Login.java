package TestScript;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends Base{
	@Test
	public void userLogin()
	{
		String username="admin";
		String password="admin";															
		WebElement usernameField=driver.findElement(By.name("username"));
		WebElement passwordField=driver.findElement(By.name("password"));
		WebElement signin=driver.findElement(By.xpath("//button[text()='Sign In']"));
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		signin.click();
		
		WebElement dashboard=driver.findElement(By.xpath("//p[text()='Dashboard']")); 	// evda dashboard locate chythethe , dashboardileke pokundo enn check chyn vendi
		boolean homepageavailable=dashboard.isDisplayed(); 	//dashboardileke display akunundo nokan
		Assert.assertTrue(homepageavailable); 	// dashboard poyath true ano enn nokan assert use chyune
											  	// Assert.assertTrue(homepageavailable,"fail "); - evda testcase fail ayankil engane koduthenkil fail enn parayuna msg display akum
	}

}
