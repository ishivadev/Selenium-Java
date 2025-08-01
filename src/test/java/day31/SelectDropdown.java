package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * Dropdown box
 * i). select dropdown
 * ii). Bootstrap dropdown
 * iii). hidden dropdown
 * 
 * select methods:-
 * selectByVisibleText()
 * selectByValue()
 * selectByIndex()
 */

public class SelectDropdown {

	public static void main(String[] args) {
		
		String auto_page = "https://testautomationpractice.blogspot.com/";

		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(auto_page);
		driver.manage().window().maximize();

		// creating the object of the Select class to use inbuilt method
		WebElement dropCountry = driver.findElement(By.xpath("//select[@id='country']"));
		
		Select dropCountryObj = new Select(dropCountry);
		
		
		// Select a the drop down using built-in methods
		//dropCountryObj.selectByVisibleText("Canada");
		//dropCountryObj.selectByValue("uk");
		//dropCountryObj.selectByIndex(5)
		
		
		// Get all the elements from drop down
		// Approach 1
		List<WebElement> options = dropCountryObj.getOptions();
		
		// Approach 2
		/*
		List<WebElement> options = driver.findElements(By.xpath("//select[@id='country']//option"));
		System.out.println("No. of options available : " + options.size());
		*/
		
		
		// Print all the values or the drop down
		/*
		// Approach 1
		for(int i=0; i< options.size(); i++) {
			System.out.println(options.get(i).getText());
		}
		*/
		
		// Approach 2
		for(WebElement op: options) {
			System.out.println(op.getText());
		}
		
		
	}

}
