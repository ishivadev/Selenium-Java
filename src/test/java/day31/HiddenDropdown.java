package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		String orange_hr = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String username = "Admin";
		String password = "admin123";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(orange_hr);
		driver.manage().window().maximize();
		
		// Login on portal
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(@class, 'oxd-button')]")).click();
		
		// Click on the PIM option
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Thread.sleep(3000);
		
		// Getting size of all the available elements of Job Title section
		driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//div[1]//div[1]")).click();
		Thread.sleep(3000);
		
		List<WebElement> options = driver.findElements(By.xpath("//div[@role='listbox']//span"));
		System.out.println(options.size());
		
		// Printing all the values
		/*
		// Approach 1 
		for(int i=0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
		}
		*/
		
		// Approach 2
		for(WebElement op : options) {
			System.out.println(op.getText());
		}
		
		
		// Select a single value
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Automation Tester']")).click();
		
		
		
		
	}

}
