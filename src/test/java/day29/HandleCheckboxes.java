package day29;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckboxes {

	public static void main(String[] args) throws InterruptedException {

		String auto_url = "https://testautomationpractice.blogspot.com/";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(auto_url);
		driver.manage().window().maximize();

		// 1. select specific check box
		//WebElement checkbox_el = driver.findElement(By.xpath("//input[@id='sunday']"));
		//checkbox_el.click();
		
		// 2. select all the check boxes
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
		//Approach 1
		/*
		for(int i=0; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}
		*/
		
		
		//Approach 2
		/*
		for(WebElement checkbox : checkboxes) {
			checkbox.click();
		}
		*/
		
		
		// 3. select last 3 check boxes
		/*
		for(int i = checkboxes.size()-3; i< checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}
		*/
		
		
		// 4. select first 3 check boxes
		/*
		for(int i = 0; i < 3; i++ ) {
			checkboxes.get(i).click();
		}
		*/
		
		
		// 5. unselect check boxes if they are selected
		
		for(int i = 0; i < 3; i++ ) {
			checkboxes.get(i).click();
		}
		
		Thread.sleep(5000);
		
		for(int i = 0; i < checkboxes.size(); i++) {
			
			if(checkboxes.get(i).isSelected()) {
				checkboxes.get(i).click();
			}
			
		}
		
		
	}

}
