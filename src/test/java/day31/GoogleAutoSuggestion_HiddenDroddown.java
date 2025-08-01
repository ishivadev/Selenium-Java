package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleAutoSuggestion_HiddenDroddown {

	public static void main(String[] args) throws InterruptedException {
		
		String google = "https://www.google.com/";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(google);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium");
		
		List<WebElement> options = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		Thread.sleep(3000);
		
		for(WebElement op : options) {
			//System.out.println(op.getText());
			
			//String search = op.getText();
			
			if(op.getText().equals("selenium")) {
				op.click();
			}
		}
		
		
		
		
	}

}
