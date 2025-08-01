package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Xpath - Address of the element on the web page.
 * 
 * 2 types of Xpath - Absolute Xpath and Relative Xpath
 * Absolute Xpath syntax - /html[1]/body[1]/div[2]/div[5]/div[1]/div[1]/div[2]/a[1]
 * Relative Xpath syntax - //img[@title='Community Support']
 * 
 * Relative Xpath - We prefered Relative  Xpath.
 */

public class XpathLocator {

	public static void main(String[] args) {
	
		String url = "https://www.opencart.com/";
		String market_page = "https://www.opencart.com/index.php?route=marketplace/extension";
		
		WebDriver driver = new ChromeDriver();
		
		/*
		driver.get(url);
		driver.manage().window().maximize();
		
		// Relative Xpath - single attribute
		driver.findElement(By.xpath("//a[@data-toggle=\"dropdown\"]")).click(); //Resources dropdown
		//driver.findElement(By.xpath("//a[@class='btn btn-link navbar-btn']")).click();
		driver.navigate().back();
		*/
		
		// Relative Xpath - multiple attribute
		driver.get(market_page);
		driver.manage().window().maximize();
		
		boolean check_img = driver.findElement(By.xpath("//img[@alt='PayPal Checkout Integration'][@title='PayPal Checkout Integration']")).isDisplayed();
		System.out.println(check_img);
		
		
		// Relative Xpath - 'and' operators
		boolean displayImg = driver.findElement(By.xpath("//img[@alt='PayPal Checkout Integration' and @title='PayPal Checkout Integration']")).isDisplayed();
		System.out.println(displayImg);
		
		// Relative Xpath - 'or' operators
		boolean amzImg = driver.findElement(By.xpath("//img[@alt='Opencart Amazon Connector' or @title='Opencart Amazon Connector']")).isEnabled();
		System.out.println(amzImg);
		
		/*
		// Relative Xpath - text() method
		driver.findElement(By.xpath("//a[text()='Modules']")).click();
		String modules_page_url = driver.getCurrentUrl();
		System.out.println(modules_page_url);
		driver.navigate().back();
		driver.navigate().refresh();
		
		boolean header_text = driver.findElement(By.xpath("//h1[text()='Welcome to OpenCart Extension Store']")).isDisplayed();
		System.out.println(header_text);
		*/
		
		
		// Relative Xpath - contains(@attribute, 'value') method
		boolean header_img = driver.findElement(By.xpath("//img[contains(@title, 'Opencart extens')]")).isDisplayed();
		System.out.println("Header image available : " + header_img);
		
		// Relative Xpath - contains(@attribute, 'value') method
		boolean header_img2 = driver.findElement(By.xpath("//img[starts-with(@title, 'Opencart exte')]")).isDisplayed();
		System.out.println("Header image available : " + header_img2);
		
		/*
		// Relative Xpath - Handling Dynamic Attribute
		Ex-1 id = 'start'     id = 'stop'
		//*[@id='start' or @id='stop']
		//*[contains(@id, 'st')]
		//*[starts-with(@id, 'st')]		
		
		Ex-2 name=xyz001    xyz002    xyz 003    xyz004   xyz001    xyz002
		//*[contains(@name. 'xyz')]
		//*[starts-with(@name, 'xyz')]
		//*[sontains(@name, '00')]
		
		*/
		
		
		// Relative Xpath - Chained Xpath (We can find the xpath using the combination of Relative and Absolute Xpath) Like - //div[@class='extension-preview']/a/div/img
		boolean test_img = driver.findElement(By.xpath("//div[@class='extension-preview']/a/img[@title='Opencart Amazon Connector']")).isDisplayed();
		System.out.println(test_img);
		
		
	}
}
