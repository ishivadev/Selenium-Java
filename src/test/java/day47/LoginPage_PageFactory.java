package day47;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PageFactory {

	WebDriver driver;
	
	// Constructor - Initiate the driver 
	// What ever the driver is passed it will assign it to the class driver.
	
	LoginPage_PageFactory(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); //Mandatory // 'initElements' will automatically apply internally in all the '@FindBy' annotation.
	}
	
	
	// Locators
	
	//@FindBy(xpath = "//input[@placeholder='Username']")
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Username']")
	WebElement txt_username;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement txt_password;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement btn_login;
	
	
	// Actions
	
	public void setUsername(String user)
	{
		txt_username.sendKeys(user);
	}
	
	public void setPassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void manageLogin()
	{
		btn_login.click();
	}
	
	
}
