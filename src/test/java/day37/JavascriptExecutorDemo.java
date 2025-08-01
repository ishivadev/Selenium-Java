package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorDemo {

	public static void main(String[] args) {
		
		String web_url = "https://testautomationpractice.blogspot.com/";
		
		//WebDriver driver = new ChromeDriver();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(web_url);
		driver.manage().window().maximize();
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;	// we need to type cast the 'JavascriptExecutor' for the 'driver' if WebDriver is used.
		
		JavascriptExecutor js = driver;
		
		WebElement input_field = driver.findElement(By.xpath("//input[@id='name']"));
		
		// Sending the data into input field 	-	'Alternative of sendKeys()'
		js.executeScript("arguments[0].setAttribute('value', 'Data from Editor')", input_field); 
		
		WebElement radio_btn = driver.findElement(By.xpath("//input[@id='female']"));
		
		// Select the radio button 	-	'Alternative of click()'
		js.executeScript("arguments[0].click()", radio_btn);
		
		
	}

}
