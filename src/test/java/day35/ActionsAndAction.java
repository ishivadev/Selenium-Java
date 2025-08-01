package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsAndAction {

	public static void main(String[] args) throws InterruptedException {
	

		String web_url = "https://www.w3schools.com/TAgs/tryit.asp?filename=tryhtml5_ev_ondblclick3";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(web_url);
		driver.manage().window().maximize();

		// Switching to iframe
		driver.switchTo().frame("iframeResult");
		
		WebElement field1 = driver.findElement(By.xpath("//input[@id='field1']"));
		field1.clear();
		field1.sendKeys("welcome");
		
		
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		Actions act = new Actions(driver);
		
		
		Action myaction = act.doubleClick(button).build(); // building the action only
		
		Thread.sleep(3000);
		myaction.perform(); // performing the action


	}

}
