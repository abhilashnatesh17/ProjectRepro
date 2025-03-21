package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) //parameterized constructor
	{
		this.driver= driver;
		PageFactory.initElements(driver, this); // PageFactory is a class , initelement is a method and use cheyunath initilaze chyn ane
	}
	@FindBy(xpath="//input[@type='text']")private WebElement usernameField;
	@FindBy(xpath="//input[@name='password']")private WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']")private WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']")private WebElement dashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")private WebElement alert;
	
	public void enterUsername(String username)
	{
		usernameField.sendKeys(username);
	}
	public void enterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	public void signIn()
	{
		signin.click();
	}
	public boolean redAlert()
	{
		return alert.isDisplayed();
	}
	public boolean isHomePageLoaded()
	{
		return dashboard.isDisplayed();
	}  
	public boolean incorrectUsername()
	{
		return alert.isDisplayed();
	}
	public boolean IncorrectUsernameAndPassword()
	{
		return alert.isDisplayed();
	}
}
