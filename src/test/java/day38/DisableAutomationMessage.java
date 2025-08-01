package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableAutomationMessage {

	public static void main(String[] args) throws InterruptedException {
		
    	ChromeOptions options = new ChromeOptions();
    	options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});    	// Disable automation message    	
    	WebDriver driver = new ChromeDriver(options);
    	
    	String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    	String title = "OrangeHRM";

    	//Launching the browser
    	driver.get(url);
    	
    	//Getting the title
    	String newTitle = driver.getTitle();
    	//System.out.println(newTitle);
    	
    	//Comparing the title
    	if(newTitle.equals(title)) {
    		System.out.println("Test Passed. The title is : " + newTitle);
    	} else {
    		System.out.println("Test Failed.");
    	}
    
    	
    	Thread.sleep(3000);
    	//Closing the browser
    	//driver.close();
    	driver.quit();
		

	}

}
