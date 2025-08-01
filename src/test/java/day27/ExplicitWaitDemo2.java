package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo2 {

	public static void main(String[] args) throws InterruptedException {
		
		String login_page = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get(login_page);
		driver.manage().window().maximize();
		
		
		WebElement textusername = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
		textusername.sendKeys("Admin");
		
		WebElement textpassword = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		textpassword.sendKeys("admin123");
		
		
		//WebElement link = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@target='_blank'][text()='OrangeHRM, Inc']")));
		//link.click();
		
	
		//Thread.sleep(3000);
		//driver.close();
	}

}
