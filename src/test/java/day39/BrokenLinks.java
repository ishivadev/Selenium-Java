package day39;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 1. Link  href="https://xyz.com"
 * 
 * 2. href="https://xyz.com" ---> server ---> status code
 * 
 * 3. status code >= 400     Broken link
 *    status code < 400     Non Broken link
 */

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, URISyntaxException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		// Getting the total <a> link and storing into List 
		List<WebElement> links =  driver.findElements(By.tagName("a"));
		
		
		int brokenLinksCount = 0;
		int nonBrokenLinksCount = 0;
		
		// This required when relative path is available. 
		// Get the current page URL and convert it into a base URI
		// Example: "http://www.deadlinkcity.com/" → baseUri
		URI baseUri = URI.create(driver.getCurrentUrl());
		
		
		// Advance for..loop for checking the each link
		for(WebElement linkElement : links) {
			
			String hrefAttValue = linkElement.getDomAttribute("href");
			
			// checking if the href have null or empty
			if(hrefAttValue == null || hrefAttValue.isEmpty()) {
				System.out.println("href have no value, so not able to check.");
				continue;
			}
			
			try {	
				// Below 2 lines required when relative path is available. 
				URI uri = baseUri.resolve(hrefAttValue); // Resolve the relative or absolute href value to a complete URI. Example: "/error.asp" becomes "http://www.deadlinkcity.com/error.asp"
				URL newLink = uri.toURL();   // Convert the resolved URI into a URL object        
				
				//URL newLink = new URL(hrefAttValue); 	// This only works if hrefAttValue is an absolute URL, like 'http://www.example.com/page.html'
				HttpURLConnection connectEle = (HttpURLConnection) newLink.openConnection(); 	// opening the connection
				connectEle.connect();	// hitting the link
				
				// checking the response code
				if(connectEle.getResponseCode() >= 400) {
					System.out.println( newLink + " ===> It is a Broken Link");
					brokenLinksCount++;
				} else {
					System.out.println( newLink + " ===> It is NOT a Broken Link");
					nonBrokenLinksCount++;
				}
				
			} catch (Exception e) {
				System.out.println("Exception : " + e);
				System.out.println("Exception : " + e.getMessage());
			}
		}
		
		
		System.out.println("Total number of broken links : " + brokenLinksCount);
		System.out.println("Total number of non-broken links : " + nonBrokenLinksCount);
		

	}

}
