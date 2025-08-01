package day26;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * get methods:-
 * 
 * get()
 * getTitle()
 * getCurrentUrl()
 * getPageSource()
 * getWindowhandle()
 * getWindowHandles()
 */

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String login_page = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		
		WebDriver driver = new ChromeDriver();
		
		//get()
		driver.get(login_page);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		//getTitle()
		String title = driver.getTitle();
		System.out.println("Title is : " + title);
		
		//getCurrentUrl()
		String curr_url = driver.getCurrentUrl();
		System.out.println("Surrent URL is : " + curr_url);
		
		//getPageSource()
		/*
		String page_soruce = driver.getPageSource();
		System.out.println("------------ Page Source Starts ------------");
		System.out.println(page_soruce);
		System.out.println("------------ Page Source Ends ------------");
		*/
		
		//getWindowhandle()
		String tab_id = driver.getWindowHandle();
		System.out.println("Single tab Id :" + tab_id);
		
		//getWindowHandles()
		driver.findElement(By.xpath("//a[@target='_blank'][text()='OrangeHRM, Inc']")).click();
		
		Set<String> mul_tabs = driver.getWindowHandles();
		for(String tab:mul_tabs) {
			System.out.println("Tab Id : " + tab);
		}
		
	}

}
