package day46;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



//@Listeners(day46.MyListener.class)
public class OrangeHRM {

	WebDriver driver;
	
	@BeforeClass
	void openApp() throws InterruptedException
	{
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	
	@Test(priority=1)
	void getLogo()
	{
		boolean logo_status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertTrue(logo_status);
	}
	
	
	@Test(priority=2)
	void getUrl()
	{
		Assert.assertEquals(driver.getCurrentUrl(), "Wrong - https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	
	@Test(priority=3, dependsOnMethods= {"getUrl"})
	void getTitle()
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	
	@AfterClass
	void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}

	
	
}
