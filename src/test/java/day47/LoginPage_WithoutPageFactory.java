package day47;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_WithoutPageFactory {

	WebDriver driver;
	
	// Constructor - Initiate the driver 
	// What ever the driver is passed it will assign it to the class driver. Then it will use in other places.
	LoginPage_WithoutPageFactory(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	// Locators
	
	By txt_username_loc =	By.xpath("//input[@placeholder='Username']");
	By txt_password_loc = By.xpath("//input[@placeholder='Password']");
	By btn_login_loc = By.xpath("//button[normalize-space()='Login']");
	
	
	// Actions
	
	public void setUsername(String user)
	{
		driver.findElement(txt_username_loc).sendKeys(user);
	}
	
	public void setPassword(String pwd)
	{
		driver.findElement(txt_username_loc).sendKeys(pwd);
	}
	
	public void manageLogin()
	{
		driver.findElement(btn_login_loc).click();
	}
	
	
}
