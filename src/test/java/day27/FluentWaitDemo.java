package day27;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class FluentWaitDemo {

	public static void main(String[] args) throws InterruptedException {
		
		String login_page = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(login_page);
		driver.manage().window().maximize();
		
		Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(30))
			       .pollingEvery(Duration.ofSeconds(3))
			       .ignoring(NoSuchElementException.class);
		
		
			
			WebElement textusername = mywait.until(new Function<WebDriver, WebElement>() {
				     public WebElement apply(WebDriver driver) {
				       return driver.findElement(By.xpath("//input[@placeholder='Username']"));
				     }
				   });
					
			textusername.sendKeys("Admin");		
			
	}

}
