package day25;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Xpath Axes
 * 
 * self
 * parent::
 * child::
 * ancestor::
 * descendant::
 * following::
 * preceding::
 * following-sibling::
 * preceding-sibling::
 */

public class XpathAxes {

	public static void main(String[] args) {
		
		String home_page = "https://www.opencart.com/index.php?route=common/home";
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(home_page);
		driver.manage().window().maximize();
		
		//self
		boolean cs_img = driver.findElement(By.xpath("//img[@alt='Community Support']")).isDisplayed();
		System.out.println("Self : " +cs_img);
		
		//parent:: 
		String test = driver.findElement(By.xpath("//a[text()='Features']/parent::li/a")).getText();
		System.out.println("Parent : " +test);
		
		//child:: 
		boolean img = driver.findElement(By.xpath("//a[@class='navbar-brand']/child::img")).isDisplayed();
		System.out.println("Child : " +img);
		
		//following:: 
		List<WebElement> a = driver.findElements(By.xpath("//p[contains(text(),'Everything you need to create, scale and run your ')]//following::a"));
		System.out.println("No of Following : " + a.size());
		
		//preceding::
		a = driver.findElements(By.xpath("//a[@class=\"btn btn-black navbar-btn\"]/preceding::a"));
		System.out.println("No of Preceding : " +a.size());
		
		//ancestor::	
		boolean text1 = driver.findElement(By.xpath("//a[@class='navbar-brand']/child::img")).isEnabled();
		System.out.println("Ancestor : " +text1);
		
		//descendant::	
		img = driver.findElement(By.xpath("//div[@class=\"collapse navbar-collapse\"]/descendant::li/a[text()='Demo']")).isDisplayed();
		System.out.println("Descendant : " +img);
		
		//following-sibling::	
		text1 = driver.findElement(By.xpath("//a[text()=\"Showcase\"]/parent::li/following-sibling::li/a[text()='Contact Us']")).isEnabled();
		System.out.println("following-sibling : " +text1);
		
		//following-preceding::		
		img = driver.findElement(By.xpath("//a[text()=\"Demo\"]/parent::li/preceding-sibling::li/a")).isDisplayed();
		System.out.println("following-preceding : " +img);
		
	}
	
}
