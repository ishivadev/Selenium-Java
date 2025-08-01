package day21;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

/*
Test case
---------
1. Launch browser(Chrome)
2. Open URL "https://www.opencart.com/"
3. Validate title should be "OpenCart - Open Source Shopping Cart Solution"
4. Close the browser
*/
//Can use this portal also "https://www.demoblaze.com/"

public class FirstTestCase {
    public static void main(String[] args) {       
  
    	String url = "https://www.opencart.com/";
    	String title = "OpenCart - Open Source Shopping Cart Solution";
    	
        // Initialize WebDriver
    	//ChromeDriver driver = new ChromeDriver();
    	WebDriver driver = new ChromeDriver();
    	//WebDriver driver = new EdgeDriver();
    	//WebDriver driver = new FirefoxDriver();
    	
    	//Launching the browser
    	driver.get(url);
    	
    	//Getting the title
    	String newTitle = driver.getTitle();
    	//System.out.println(newTitle);
    	
    	//Comparing the title
    	if(newTitle.equals(title)) {
    		System.out.println("Test Passed. The title is" + newTitle);
    	} else {
    		System.out.println("Test Failed.");
    	}
    
    	
    	//Closing the browser
    	//driver.close();
    	driver.quit();
    }
}