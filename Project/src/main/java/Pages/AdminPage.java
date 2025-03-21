package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.PageUtilities;

public class AdminPage {
WebDriver driver;
public AdminPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);	
}
//@FindBy(xpath="//input[@type='text']")private WebElement usernameField;
//@FindBy(xpath="//input[@name='password']")private WebElement passwordField;
//@FindBy(xpath="//button[@type='submit']")private WebElement signin;
@FindBy(xpath="(//a[@class='small-box-footer'])[1]")private WebElement adminuser;
@FindBy(xpath="//a[@onclick='click_button(1)']")private WebElement newvalue;
@FindBy(xpath="//input[@id='username']")private WebElement usernamevalue;
@FindBy(xpath="//input[@id='password']")private WebElement passwordvalue;
@FindBy(xpath="//select[@name='user_type']")private WebElement usertype;
@FindBy(xpath="//button[@name='Create']")private WebElement save;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;


public void adminuser()
{
	adminuser.click();
}
public void newvalue()
{
	newvalue.click();
}
public void usernamevalue(String adminusername)
{
	usernamevalue.sendKeys(adminusername);
}
public void passwordvalue(String adminpassword)
{
	passwordvalue.sendKeys(adminpassword);
}

public void usertype()
{
	Select select=new Select(usertype);
	select.selectByIndex(4);
	//PageUtilities pageutilities=new PageUtilities();
	//pageutilities.selectByIndex(usertype, 4);
	//pageutilities.selectByValue(usertype, "Staff");
	//pageutilities.selectByVisibleText(usertype, "Admin");
}
public void save()
{
	save.click();
}
public boolean alert()
{
	return alert.isDisplayed();
}
}
