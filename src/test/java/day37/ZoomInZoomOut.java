package day37;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomInZoomOut {

	public static void main(String[] args) throws InterruptedException {
		
		String web_url = "https://testautomationpractice.blogspot.com/";
		
		WebDriver driver = new ChromeDriver();
		//ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(web_url);
		
		Thread.sleep(5000);
		driver.manage().window().minimize();

		Thread.sleep(3000);
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Thread.sleep(3000);
		js.executeScript("document.body.style.zoom='50%'"); 	// setting the page zoom 50%
		
		Thread.sleep(3000);
		js.executeScript("document.body.style.zoom='80%'");		// setting the page zoom 80%
	}

}
