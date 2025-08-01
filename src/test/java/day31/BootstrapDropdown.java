package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		String multiselect_page = "https://admirhodzic.github.io/multiselect-dropdown/demo.html";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(multiselect_page);
		driver.manage().window().maximize();
		
		//Clicking on the drop down section
		driver.findElement(By.xpath("//span[@class='placeholder']//parent::div")).click();
		Thread.sleep(3000);
		
		//Size of all the values
		List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class, 'multiselect')]//label"));
		System.out.println(options.size());
		
		
		//Getting all the values
		/*
		// Approach 1
		for(int i=0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
		}
		*/
		
		// Approach 2
		/*
		for(WebElement op : options) {
			System.out.println(op.getText());
		}
		*/
		
		
		// Selecting multiple values
		for(WebElement op : options) {
			
			String value = op.getText();
			
			if( value.equals("Abarth") || value.equals("Audi") || value.equals("BMW") ) {
				op.click();
			}
			
		}
		
		
		
	}

}
