package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * browser methods
 * 
 * close()
 * quit()
 */

public class BrowserMethods {

	public static void main(String[] args) throws InterruptedException {
		
		String login_page = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(login_page);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[@target='_blank'][text()='OrangeHRM, Inc']")).click();
		Thread.sleep(7000);
		
		//driver.close();	// close single browser window where ever the driver is focused
		driver.quit();	// close all the browser windows
		
	}

}
