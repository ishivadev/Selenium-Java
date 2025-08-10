package day47;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTC {

	WebDriver driver;
	
	@BeforeClass
	void setApp() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Thread.sleep(2000);
	}
	
	
	@Test(priority=1)
	void loginTest()
	{
		
		LoginPage_PageFactory pl = new LoginPage_PageFactory(driver);
		pl.setUsername("Admin");
		pl.setPassword("admin123");
		pl.manageLogin();
		
		
		/*
		LoginPage_WithoutPageFactory pl = new LoginPage_WithoutPageFactory(driver);
		pl.setUsername("Admin");
		pl.setPassword("admin123");
		pl.manageLogin();
		*/ 
		
		Assert.assertEquals(driver.getTitle(), "OrangeHR");
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
	
}
