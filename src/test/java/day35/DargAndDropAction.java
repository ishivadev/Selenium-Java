package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DargAndDropAction {

	public static void main(String[] args) throws InterruptedException {
		
		String web_url = "https://demoapps.qspiders.com/ui/dragDrop/dragToCorrect?sublist=2";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(web_url);
		driver.manage().window().maximize();
		
		
		WebElement box1 = driver.findElement(By.xpath("//div[normalize-space()='Laptop Charger']"));
		
		WebElement dest = driver.findElement(By.xpath("//body/div/div/div/section/main/section/article/aside/div/aside/div/div/div/section[2]/div[1]"));
		
		Actions act = new Actions(driver);
		
		Thread.sleep(2000);
		act.dragAndDrop(box1, dest).perform(); // drag and drop
		
		
		
	}

}
