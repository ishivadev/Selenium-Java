package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * CSS Selector
 * tag id					tag#id
 * tag class				tag.class
 * tag attribute			tag[attribute="value"]
 * tag class attribute		tag.class[attribute="value"]
 */

public class CssSelector {

	public static void main(String[] args) {
		
		String url = "https://www.demoblaze.com/";
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		driver.manage().window().maximize(); //Maximize the window
		
		try { 
			
			//tag id	tag#id
			//driver.findElement(By.cssSelector("a#login2")).click();
			
			//Thread.sleep(1000);
			//driver.findElement(By.cssSelector("input#loginusername")).sendKeys("testing");
			//driver.findElement(By.cssSelector("input#loginusername")).sendKeys("testing");
			
			//tag class		tag.class
			//Thread.sleep(2000);
			//driver.findElement(By.cssSelector("img.card-img-top")).click();
			
			
			//tag attribute		tag[attribute="value"]
			//Thread.sleep(2000);
			//driver.findElement(By.cssSelector("a[onclick='addToCart(1)']")).click();
			//driver.navigate().back();
			
			
			//tag class attribute		tag.class[attribute="value"]
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("a.nav-link[data-toggle='modal']")).click();
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}

}
