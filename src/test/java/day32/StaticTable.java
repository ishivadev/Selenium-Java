package day32;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) throws InterruptedException {
		
		String auto_page = "https://testautomationpractice.blogspot.com/";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 	// Implicit wait
		
		driver.get(auto_page);
		driver.manage().window().maximize();
		
		
		// 1. Find total number of rows in a table
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		System.out.println("Total rows are : " + rows.size());
		
		
		// 2. Find total number of columns in a table
		List<WebElement> columns = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
		System.out.println("Total columns are : "+ columns.size());
		
		/*
		// 3. Read data from a specific row and column 9Ex: 5th row 1st column)
		String bookname = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]/td[1]")).getText();
		System.out.println("5th row's 1st columns value : " + bookname);
		*/
		
		/*
		// 4. Reading data from all the rows and columns
		for(int r = 2; r < rows.size(); r++) {
			
			for(int c = 1; c < columns.size(); c++ ) {
				
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td["+c+"]")).getText();
				System.out.print(value + "\t");
			}
			System.out.println(); // Works like a enter
		}
		*/
		
		/*
		// 5. Print book name of the author 'Mukesh'
		for(int r = 2; r < rows.size(); r++) {
			
			String authorName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[2]")).getText();
			
			if(authorName.equals("Mukesh")) {
				String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[1]")).getText();
				System.out.println("Aurthor's Mukesh bookname is : " + bookName);
			}
		}
		*/
		
		// 6. Print total amount of the books 
		int total = 0;
		for(int r = 2; r <= rows.size(); r++ ) {
			
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td[4]")).getText();
			total = total + Integer.parseInt(price);	// Converting the string to integer
		}
		
		System.out.println("Total price of the books are : " + total);
		
		
		// Closing the tab
		Thread.sleep(3000);
		driver.close();
		
	}

}
