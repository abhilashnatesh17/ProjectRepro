package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteUserPage {
	WebDriver driver;
	
	public DeleteUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@type='text']")private WebElement usernameField;
	@FindBy(xpath="//input[@name='password']")private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']")private WebElement signin;
	@FindBy(xpath="(//a[@class='small-box-footer'])[1]")private WebElement adminuser;
	@FindBy(xpath="(//i[@class='fas fa-trash-alt'])[7]")private WebElement deleteuser;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;
	
	public void adminuser()
	{
		adminuser.click();
	}
	public void deleteuser()
	{
		deleteuser.click();
		driver.switchTo().alert().accept();
	}
	public boolean alert()
	{
		return alert.isDisplayed();
	}

}
