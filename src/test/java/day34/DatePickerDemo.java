package day34;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo {
	
	// Selecting the future date method
	static void selectFutureDate(WebDriver driver, String year, String month, String date) {
	
		// Matching the year and month
		while(true) {
					
		String curr_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		String curr_month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
				
		if(curr_year.equals(year) && curr_month.equals(month))
			{			
				break;
			}		
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); // Clicks on the next icon
			}
				
		// Selecting the dates
		List<WebElement> all_dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td/a"));
			
		for(WebElement dt : all_dates) {
				
			if(dt.getText().equals(date)) {
					dt.click();
				}
			}
	}
	
	
	// Selecting the past date method
		static void selectPastDate(WebDriver driver, String year, String month, String date) {
		
			// Matching the year and month
			while(true) {
						
			String curr_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String curr_month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
					
			if(curr_year.equals(year) && curr_month.equals(month))
				{			
					break;
				}		
				
					driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); // Clicks on the previous icon		
				}
					
			// Selecting the dates
			List<WebElement> all_dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td/a"));
				
			for(WebElement dt : all_dates) {
					
				if(dt.getText().equals(date)) {
						dt.click();
					}
				}
		}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		String datepicker_url = "https://jqueryui.com/datepicker/";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(datepicker_url);
		driver.manage().window().maximize();
		
		// Switch to iframe
		WebElement frame_t = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame_t);
		
		
		// Click on date picker and send value
		driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("05/02/2024");

		
		/*
		WebElement date_field = driver.findElement(By.xpath("//input[@id='datepicker']"));
		//date_field.click();
		date_field.sendKeys("05/02/2024");
		*/
		
		String year = "2026";
		String month = "May";
		String date = "10";
		
		
		selectFutureDate(driver, year, month, date);
		//selectPastDate(driver, year, month, date);
		
		
		
		
		Thread.sleep(5000);
		driver.close();
		
	}

}
