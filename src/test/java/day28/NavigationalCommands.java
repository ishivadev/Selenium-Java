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
 * navigate().to()
 * navigate().forward()
 * navigate().back()
 * navigate().refresh()
 */

public class NavigationalCommands {

	public static void main(String[] args) {
		
		String login_page = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		String reg_page = "https://www.orangehrm.com/";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//navigate().to()
		driver.navigate().to(login_page);
		driver.manage().window().maximize();
		
		driver.navigate().to(reg_page);
		
		
		//navigate().back()
		driver.navigate().back();
		
		//navigate().forward()
		driver.navigate().forward();
		
		//navigate().refresh()
		driver.navigate().refresh();

		
	}
}
