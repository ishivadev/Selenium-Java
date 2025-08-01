package day28;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * getWindowHandle()
 * getWindowHandles()
 */

public class WindowHandleDemo {

	public static void main(String[] args) {
		
		String login_page = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(login_page);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement hr_page_link = driver.findElement(By.xpath("//a[@target='_blank'][text()='OrangeHRM, Inc']"));
		hr_page_link.click();
		
		Set<String> windowIDs = driver.getWindowHandles();
		
		/*
		//Approach 1
		List<String> winIdList = new ArrayList(windowIDs);
		
		String parent = winIdList.get(0);
		String child = winIdList.get(1);
		
		//switch to parent
		driver.switchTo().window(parent);
		System.out.println(driver.getCurrentUrl());
		
		//switch to child
		driver.switchTo().window(child);
		System.out.println(driver.getCurrentUrl());
		*/
		
		
		//Approach 2
		for(String winId:windowIDs) {
			
			String page_title = driver.switchTo().window(winId).getTitle();
			
			if(page_title.equals("OrangeHRM")) {
				
				System.out.println(driver.getCurrentUrl());
			
			}
			
		}
	}
}
