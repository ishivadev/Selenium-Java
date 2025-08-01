package day38;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshots {

	public static void main(String[] args) throws InterruptedException {
		
		String web_url = "https://demo.nopcommerce.com/";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(web_url);
		driver.manage().window().maximize();
		
		/*
		// 1. Full page screenshot using 'TakesScreenshot' interface 
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);		// taking the screenshot and storing in the memory
		File targetfile = new File(System.getProperty("user.dir") + "\\screenshots\\fullpage.jpg"); 	// output location
		
		sourcefile.renameTo(targetfile);	// saving the screenshot to target location
		*/
		
		/*
		// 2. Taking screenshot of a specific section 		[From Selenium 4, the 'getScreenshotAs' is also available now in WebElement class
		WebElement featureSection = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		
		File sourcefile = featureSection.getScreenshotAs(OutputType.FILE);
		File targetfile = new File(System.getProperty("user.dir") + "\\screenshots\\features.jpg");
		
		sourcefile.renameTo(targetfile);
		*/
		
		
		// 3. Taking screenshot of a element
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		
		File sourcefile = logo.getScreenshotAs(OutputType.FILE);
		File targetfile = new File(System.getProperty("user.dir") + "\\screenshots\\logo.png");
		
		sourcefile.renameTo(targetfile);
		
		
		
		
		Thread.sleep(3000);
		driver.close();
		
	}

}
