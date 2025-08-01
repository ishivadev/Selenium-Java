package day35;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AssignmentOne {

	public static void main(String[] args) {
		
		String web_url = "https://demo.nopcommerce.com/";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(web_url);
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		WebElement reg_btn = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		
		// Opening Register option in new tab using keyboard action 'CCtrl + Click'
		act.keyDown(Keys.CONTROL).click(reg_btn).keyUp(Keys.CONTROL).perform();
		
		// Get the Window ID
		Set<String> ids = driver.getWindowHandles();
		
		List<String> windowId = new ArrayList(ids);
		
		String child = windowId.get(1);
		System.out.println(child);
		driver.switchTo().window(child);
		

	}

}
