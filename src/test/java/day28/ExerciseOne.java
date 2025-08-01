package day28;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * http://testautomationpractice.blogspot.com

1. provide some string search of it
2. count number of links
3. click on each link using for loop
4. get window ID's for every browser window
5. close specific browser window
 */

public class ExerciseOne {

	public static void main(String[] args) {
		
		String auto_url = "http://testautomationpractice.blogspot.com";

		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(auto_url);
		driver.manage().window().maximize();
		
		String originalWindow = driver.getWindowHandle();
		
		
		// 1. provide some string search of it
		WebElement search_box = driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']"));
		search_box.sendKeys("Test");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		// 2. count number of links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Available links (a) on the webpage are : " + links.size());
		
		
		// 3. click on each link using for loop
		// 4. get window ID's for every browser window
		// 5. close specific browser window
		
		for(int i = 0; i < links.size(); i++ ) {
			
			WebElement link = links.get(i);
			System.out.println(link);
			
		    String openInNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN); 
			
		    try {
		    	
		        link.sendKeys(openInNewTab);
		        Thread.sleep(3000); // Wait for the new tab to load

		        // Switch to new tab
		        Set<String> windowHandles = driver.getWindowHandles();
		        
		        for ( String window : windowHandles ) {
		            if ( !window.equals(originalWindow) ) {
		                driver.switchTo().window(window);
		                break;
		            }
		        }

		        System.out.println("Opened tab title: " + driver.getTitle());

		        driver.close(); // Close new tab
		        driver.switchTo().window(originalWindow); // Back to original
		        
		    } catch ( Exception e ) {
		        System.out.println("Error on link #" + i + ": " + e.getMessage());
		    }
		}	
		
	}

}
