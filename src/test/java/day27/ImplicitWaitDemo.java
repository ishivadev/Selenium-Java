package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitDemo {

	public static void main(String[] args) throws InterruptedException {
		
		String login_page = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait will work for every element of the web page where it is needed
		
		driver.get(login_page);
		driver.manage().window().maximize();
		
		
		WebElement textusername =  driver.findElement(By.xpath("//input[@placeholder='Username']"));
		textusername.sendKeys("Admin");
		
		WebElement second_page = driver.findElement(By.xpath("//a[@target='_blank'][text()='OrangeHRM, Inc']"));
		second_page.click();
	
		//Thread.sleep(3000);
		//driver.close();
	}

}
