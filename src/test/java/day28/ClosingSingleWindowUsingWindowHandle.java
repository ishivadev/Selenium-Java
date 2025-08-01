package day28;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ClosingSingleWindowUsingWindowHandle {

	public static void main(String[] args) {
		
		String login_page = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(login_page);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement hr_page_link = driver.findElement(By.xpath("//a[@target='_blank'][text()='OrangeHRM, Inc']"));
		hr_page_link.click();
		
		Set<String> windowIDs = driver.getWindowHandles();
				
		
		for(String winId:windowIDs) {
			
			String page_title = driver.switchTo().window(winId).getTitle();
			
			if(page_title.equals("OrangeHRM") || page_title.equals("Human Resources Management Software | OrangeHRM HR Software") ) { //iterate 2 times and close both window
				
				driver.close();
			
			}
			
		}
	}
}
