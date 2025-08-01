package day29;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Handling alert without using switchTo().alert()
 * by using explicit wait
 */

public class HandleAlertUsingExplicitWait {

	public static void main(String[] args) throws InterruptedException {

		String sample_alert_site = "https://the-internet.herokuapp.com/javascript_alerts"; //will ask for username and password
		
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10)); // declaration of Explicit wait
		
		driver.get(sample_alert_site);
		driver.manage().window().maximize();
		
		WebElement js_alert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		js_alert.click();
		
		Alert myalert = mywait.until(ExpectedConditions.alertIsPresent()); // implementation
		
		Thread.sleep(5000);
		myalert.getText();
		myalert.accept();
		

	}

}
