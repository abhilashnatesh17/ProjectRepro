package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitUtilities;


public class ManagePage {
	WebDriver driver;
public ManagePage(WebDriver driver)
{
	this.driver= driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//input[@type='text']")private WebElement usernameField;
@FindBy(xpath="//input[@name='password']")private WebElement passwordField;
@FindBy(xpath="//button[@type='submit']")private WebElement signin;
@FindBy(xpath="(//a[@class='small-box-footer'])[9]")private WebElement manageinfo;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")private WebElement newbutton;
@FindBy(xpath="//textarea[@id='news']")private WebElement text;
@FindBy(xpath="//button[@type='submit']")private WebElement save;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")private WebElement alert;

public void manageinfo()
{
	
	manageinfo.click();
}
public void newbutton()
{
	newbutton.click();
}
public void text(String textfield)
{
	text.sendKeys(textfield);
}
public void save()
{
	WaitUtilities waitutilities=new WaitUtilities();
	waitutilities.waitForElementToBeClickable(driver, save);  // wait 
	save.click();
}
public boolean alert()
{
	return alert.isDisplayed();
}

}
