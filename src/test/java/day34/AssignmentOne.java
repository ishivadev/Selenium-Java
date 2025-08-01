package day34;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentOne {

	public static void main(String[] args) throws InterruptedException {
		
		String dummy_ticket = "https://dummy-tickets.com/";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(dummy_ticket);
		driver.manage().window().maximize();
		
		String from_location = "netaji subhash";
		String to_location = "bagdogra";
		
		// Source location selection
		driver.findElement(By.xpath("//form[@id='flight_oneway']//div[contains(@class, 'col-sm-12 p-0')]//input[@name='source[]']")).sendKeys(from_location);
		Thread.sleep(3000);
		
		List<WebElement> from_loc = driver.findElements(By.xpath("//form[@id='flight_oneway']//ul/li//div[text()='Kolkata']"));
		
		
		for(WebElement op : from_loc) {
			System.out.println(op.getText());
		
			if(op.getText().equals("Kolkata")) {
				op.click();
			}
		}
		
		
		
		// Destination location selection
		driver.findElement(By.xpath("//form[@id='flight_oneway']//div[contains(@class,'col-sm-12 p-0')]//input[@name='destination[]']")).sendKeys("bagdogra");
		Thread.sleep(3000);
		
		List<WebElement> to_loc = driver.findElements(By.xpath("//form[@id='flight_oneway']//ul/li//div[text()='Bagdogra']"));
		
		
		for(WebElement el2 : to_loc) {
			System.out.println(el2.getText());
		
			if(el2.getText().equals("Bagdogra")) {
				el2.click();
			}
		}
		
		String year = "2025";
		String month = "Jun";
		String date = "6";
		
		// Clicking on date section
		Thread.sleep(2000);
		WebElement date_section = driver.findElement(By.xpath("//label[text()='Departure']//input[@id='dp1752414897343']"));
		date_section.click();
		
		
		// Selecting year using Select class
		WebElement yearSelect = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select yearObj = new Select(yearSelect);
		
		yearObj.selectByVisibleText(year);
		
		// Selecting month using Select class
		WebElement monthSelect = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select monthObj = new Select(monthSelect);
		
		monthObj.selectByVisibleText(month);
		
		List<WebElement> dates = driver.findElements(By.xpath("//tbody//td/a"));
		
		for(WebElement dt : dates) {
			
			if(dt.getText().equals(date)) {
				dt.click();
			}
		}
		
		
	}	
}
