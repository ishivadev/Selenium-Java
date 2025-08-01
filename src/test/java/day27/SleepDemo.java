package day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SleepDemo {

	public static void main(String[] args) throws InterruptedException {
		
		String login_page = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(login_page);
		driver.manage().window().maximize();
		
		Thread.sleep(5000); //will stop here for 5 seconds
		
		WebElement textusername =  driver.findElement(By.xpath("//input[@placeholder='Username']"));
		textusername.sendKeys("Admin");
		
	
		Thread.sleep(3000);
		driver.close();
	}

}
