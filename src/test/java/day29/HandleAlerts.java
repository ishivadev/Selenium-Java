package day29;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Normal alert with - OK button
 * Confirmation alert - Ok and Cancel buttons
 * Prompt Alert - Input box
 */

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		
		String sample_alert_site = "https://the-internet.herokuapp.com/javascript_alerts";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(sample_alert_site);
		driver.manage().window().maximize();
		
		/*
		// 1. Normal alert with - OK button
		WebElement js_alert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		js_alert.click();
		
		driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		*/
		
		/*
		// 2. Confirmation alert - OK and Cancel buttons
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		*/
		
		
		// 3. Prompt Alert - Input box
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		// Approach 1
		/*
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("Sample input data");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		*/
		
		// Approach 2
		Alert myalert = driver.switchTo().alert();
		
		System.out.println(myalert.getText());
		myalert.sendKeys("Sample input data");
		Thread.sleep(2000);
		myalert.accept();
		
	}

}
