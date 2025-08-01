package day22;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 * Basic Locators
 * id,
 * name,
 * linkText
 * partialLinkText
 * className
 * tagName
 */



public class LocatorDemo {

    public static void main(String[] args) {
    	
    	//String contact_url = "https://www.opencart.com/index.php?route=support/contact";
    	String url = "https://www.opencart.com/index.php?route=common/home";
    	
    	//Can use this portal also "https://www.demoblaze.com/"
    	
    	//ChromeDriver drive = new ChromeDriver();
    	WebDriver driver = new ChromeDriver();
 
    	driver.get(url);
    	driver.manage().window().maximize();
    	
    	//locate by 'id'
    	//driver.findElement(By.id("input-reason")).sendKeys("Testing");;
    	
    	//locate by name
    	//driver.findElement(By.name("navbar-brand")).click();
    	
    	//locate by linkText
    	//driver.findElement(By.linkText("Features")).click();
    	
    	//locate by partialLinktext
    	//driver.findElement(By.partialLinkText("Feature")).click();
    	
    	//locate by className
    	//List<WebElement> headerLinks = driver.findElements(By.className("container"));
    	//System.out.println("Total number of links : " + headerLinks.size());
    	
    	//locate by tagName
    	List<WebElement> a = driver.findElements(By.tagName("a"));
    	System.out.println(a.size());
    	
    }
}