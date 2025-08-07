package day42;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
 1. Open application
 2. Check logo presence
 3. Login
 4. Close
 */


public class LoginOrangeHRM {

	WebDriver driver = new ChromeDriver();
	
	@Test(priority=0)
	public void openPage()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void checkLogo() throws InterruptedException
	{
		Thread.sleep(3000);
		boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		System.out.println("The logo is present? - " + status);
	}
	
	@Test(priority=2)
	public void userLogin()
	{
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}
	
	@Test(priority=3)
	public void closeApp() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
	}
	
}
