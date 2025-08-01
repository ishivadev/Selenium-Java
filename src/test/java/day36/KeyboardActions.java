package day36;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) {
		
		String web_url = "https://text-compare.com/";
		
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(web_url);
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		
		// Selecting the text area
		
		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Welcome");
		
		// Performing the Select All -> Copy -> Tab -> Paste
		// Ctrl + A
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
		
		// Ctrl + C
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
		
		// Tab
		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		// Ctrl + V
		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();
		
		
	}

}
