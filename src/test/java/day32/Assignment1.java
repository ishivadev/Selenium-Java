package day32;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * Open the booking form based on lowest price
 */

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {
		
		String demo = "https://www.blazedemo.com/";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(demo);
		driver.manage().window().maximize();
		
		// Creating object for Select class
		// fromPort
		WebElement departure_city = driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select deptCity = new Select(departure_city);
		
		deptCity.selectByVisibleText("Paris");
		
		// toPort
		WebElement destination_city = driver.findElement(By.xpath("//select[@name='toPort']"));
		Select destCity = new Select(destination_city);
		
		destCity.selectByValue("London");
		
		// searching the flight
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		
		// Flights table rows 
		Thread.sleep(3000);
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']//tr"));
		System.out.println("No of rows : " + rows.size());
		
		// Flights table columns
		List<WebElement> columns = driver.findElements(By.xpath("//table[@class='table']//th"));
		System.out.println("No of columns : " + columns.size());
		
		// Getting the 'price' from table
		List<Double> arr = new ArrayList<>(); // Creating a double list of array, because price have decimal values like 222.43
		
		for(int r = 1; r < rows.size(); r++) {
			
			String price = driver.findElement(By.xpath("//table[@class='table']//tbody/tr["+r+"]/td[6]")).getText(); // Getting the price
			String cleanPrice = price.replace("$", "");
		    double value = Double.parseDouble(cleanPrice);
			System.out.println(value);
			
			arr.add(value);
		}
		
		// Sorting of array in ascending order
		Collections.sort(arr);
		
		
		// Open the register form based on lowest price
		for(int r = 1; r <= rows.size(); r++ ) {
			
			String checkPrice = driver.findElement(By.xpath("//table[@class='table']//tbody/tr["+r+"]/td[6]")).getText(); // Getting the price
			String cleanCheckPrice = checkPrice.replace("$", "");
		    double fetchPrice = Double.parseDouble(cleanCheckPrice);
		    
		    Double lowPrice = arr.get(0);	// Accessing the '0' index from arr array.
		    
		    if( fetchPrice == lowPrice ) {
		    	
		    	driver.findElement(By.xpath("//table[@class='table']//tbody/tr["+r+"]/td[1]/input")).click();
		    	break;
		    }
		
		}
	}

}
