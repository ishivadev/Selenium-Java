package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * driver.switchTo().frame(name)
 * driver.switchTo().frame(id)
 * driver.switchTo().frame(WebElement)
 * driver.switchTo().index()
 */

public class HandleFrames {

	public static void main(String[] args) {
		
		String frames_page = "https://ui.vision/demo/webtest/frames/";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(frames_page);
		driver.manage().window().maximize();
		
		// frame 1 - using WebElement
		
		WebElement frame1 = driver.findElement(By.xpath("//frame[@src='frame_1.html']")); 	// getting the frame1 and storing in WebElement
		driver.switchTo().frame(frame1);	// switching to frame1
		
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome");
		
		driver.switchTo().defaultContent();		// go back to page level
		
		
		// frame 3 -> inner frame
		
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(frame3);
		
		driver.findElement(By.xpath("//input[@name='mytext3']"));
		
		// switching to inner frame
		driver.switchTo().frame(0);		// using index value, as there is only one frame is available
		
		driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();
		
		driver.switchTo().defaultContent();
	}

}
