package day45;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	WebDriver driver;
	
	@BeforeClass
	void openBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(dataProvider="dp") // DataProvider name is required for connection
	void loginApp(String email, String pwd) throws InterruptedException 	// passing the details as parameters in the method
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		Thread.sleep(3000);
		boolean logo_img = driver.findElement(By.xpath("//img[@alt='client brand banner']")).isDisplayed();
		
		if(logo_img == true) 
		{
			System.out.println("Logo is available.");
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.fail();
		}
		
	}
	
	
	@AfterClass
	void tearDown() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.close();
	}
	
	
	@DataProvider(name="dp", indices= {2, 3}) //Name is mandatory and with indices, sending the value of 2, 3 indices
	Object[][] testData() 
	{
		Object[][] data = {
								{"abc@gmail.com", "test123"},
								{"xyz@gmail.com", "test012"},
								{"john@gmail.com", "test@123"},
								{"Admin", "admin123"}
						  };
		return data;
	}
	
		
	
}
