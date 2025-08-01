package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * conditional methods
 * 
 * isDisplayed()
 * isEnabled()
 * isSelected()
 */

public class ConditionalMethods {

	public static void main(String[] args) {
		
		String nopcomm_register_page = "https://demo.nopcommerce.com/register?returnUrl=%2F";

		WebDriver driver = new ChromeDriver();
		
		driver.get(nopcomm_register_page);
		driver.manage().window().maximize();
		
		//isDisplayed()
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		System.out.println("Logo is displayed? - " + logo.isDisplayed());
		 
		//isEnabled()
		WebElement search_bar = driver.findElement(By.xpath("//button[@class='button-1 search-box-button']"));
		System.out.println("Search bar is enabled? : " + search_bar.isEnabled()); 
		
		//isSelected()
		WebElement male_val = driver.findElement(By.xpath("//input[@value='M' and @id='gender-male']"));
		WebElement female_val = driver.findElement(By.xpath("//input[@value='F' and @id=\"gender-female\"]")); 
		 
		System.out.println("----- Before Selection -----");
		System.out.println("Male checkbox selected? : " + male_val.isSelected());
		System.out.println("Female checkbox selected? : " + female_val.isSelected());
		
		System.out.println("----- After Male Checkbox Selection -----");
		male_val.click();
		System.out.println("Male checkbox selected? : " + male_val.isSelected());
		System.out.println("Female checkbox selected? : " + female_val.isSelected());
		
		System.out.println("----- After Female Checkbox Selection -----");
		female_val.click();
		System.out.println("Male checkbox selected? : " + male_val.isSelected());
		System.out.println("Female checkbox selected? : " + female_val.isSelected());
		
		
		
	}

}
