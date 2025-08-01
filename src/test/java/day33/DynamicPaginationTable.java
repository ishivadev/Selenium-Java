package day33;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTable {

	public static void main(String[] args) throws InterruptedException {
		
		String demo_admin = "https://demo3x.opencartreports.com/admin/index.php?route=common/login";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(demo_admin);
		driver.manage().window().maximize();
		
		
		// Login on portal
		WebElement username = driver.findElement(By.xpath("//input[@id='input-username']"));
		username.clear();
		username.sendKeys("demo");
		
		WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
		password.clear();
		password.sendKeys("demo");
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		// Navigation to customers table
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[@id='menu-system']//a[normalize-space()='System']")).click();		// click on  System
		//driver.findElement(By.xpath("//li[@class='active']//a[@class='parent'][text()='Localisation']")).click();	// click on Localisation
		driver.findElement(By.xpath("//a[normalize-space()='Localisation']")).click();	// click on Localisation
		
		driver.findElement(By.xpath("//ul[@class='collapse in']//a[text()='Zones']")).click();		// click on Zones
		
		// Getting the page numbers
		String text = driver.findElement(By.xpath("//div[contains(text(), 'Showing 1 to 20')]")).getText(); // Showing 1 to 20 of 4108 (206 Pages)
		
		int total_pages = Integer.parseInt( text.substring( text.indexOf("(")+1, text.indexOf("Pages")-1 ) );
		Thread.sleep(2000);
		System.out.println(total_pages);
		
		
		// for loop to click on pages and fetching the data
		
		for(int r = 1; r <= total_pages; r++) {
			Thread.sleep(2000);
			
			if(r == 1) { // Getting the first page data
				
				List<WebElement> no_rows_p1 = driver.findElements(By.xpath("//table[contains(@class,'table')]//tr"));
				
				System.out.println();
				System.out.println("------- First page data -------");
				
				for(int row=1; row < no_rows_p1.size(); row++) {
				
					String country = driver.findElement(By.xpath("//table[contains(@class,'table')]//tbody/tr["+row+"]/td[2]")).getText();
					String zone = driver.findElement(By.xpath("//table[contains(@class,'table')]//tbody/tr["+row+"]/td[3]")).getText();
					System.out.println(country+ "\t" +zone);
				}
			}
			
			if(r > 1) { // Getting the next page data
				
				WebElement active_page = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+r+"]"));
				active_page.click();

				// table rows
				List<WebElement> no_rows = driver.findElements(By.xpath("//table[contains(@class,'table')]//tr"));
				
				System.out.println();
				System.out.println("------- Next page data -------");
				
				for(int row=1; row < no_rows.size(); row++) {
					
					String country = driver.findElement(By.xpath("//table[contains(@class,'table')]//tbody/tr["+row+"]/td[2]")).getText();
					String zone = driver.findElement(By.xpath("//table[contains(@class,'table')]//tbody/tr["+row+"]/td[3]")).getText();
					System.out.println(country+ "\t" +zone);
				}
				
			}	
			
		}
		
	}

}
