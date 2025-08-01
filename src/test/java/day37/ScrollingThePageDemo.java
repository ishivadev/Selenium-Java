package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingThePageDemo {

	public static void main(String[] args) throws InterruptedException {

		String web_url = "https://testautomationpractice.blogspot.com/";
		
		WebDriver driver = new ChromeDriver();
		//ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(web_url);
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// 1. Scroll down page by pixel number
		/*
		js.executeScript("window.scrollBy(0, 1500)", "");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		*/
		
		// 2. Scroll the page till element is visible
		/*
		WebElement element = driver.findElement(By.xpath("//h2[normalize-space()='Dynamic Web Table']"));
		js.executeScript("arguments[0].scrollIntoView();", element);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		*/
		
		// 3. Scroll the page till end of the page
		
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		Thread.sleep(5000);
		
		// 4. Scrolling up to initial position
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		
		
		
		
		
		
	}

}
