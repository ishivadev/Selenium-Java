package day35;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String[] args) throws InterruptedException {
		
		String web_url = "https://swisnl.github.io/jQuery-contextMenu/demo.html";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(web_url);
		driver.manage().window().maximize();

		WebElement rgt_btn = driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		WebElement copy_btn = driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-copy']"));
		
		Actions act = new Actions(driver);
		
		act.contextClick(rgt_btn).perform(); // performing right click
		
		copy_btn.click();
		
		Alert myalert = driver.switchTo().alert();
		
		Thread.sleep(3000);
		myalert.accept();
	}

}
