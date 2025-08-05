package day41;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculation {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		String web_url = "https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html";

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(web_url);
		driver.manage().window().maximize();
		
		// Sample data file path
		String filePath = System.getProperty("user.dir")+"\\testData\\SampleAmounts.xlsx"; 
		
		// Getting row number
		int rows = ExcelUtility.getRowCount(filePath, "Sheet1");
		
		
		for(int r = 1; r <= rows; r++)
		{
			// 1. Reading the data from excel
			String principal_amount = ExcelUtility.getCellData(filePath, "Sheet1", r, 0);
			String rate = ExcelUtility.getCellData(filePath, "Sheet1", r, 1);
			String period1_no = ExcelUtility.getCellData(filePath, "Sheet1", r, 2);
			String period2_time = ExcelUtility.getCellData(filePath, "Sheet1", r, 3);
			String frequency = ExcelUtility.getCellData(filePath, "Sheet1", r, 4);
			String expectedMaturity_amount = ExcelUtility.getCellData(filePath, "Sheet1", r, 5);
			
			
			// 2. Sending the data to application 
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principal_amount);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rate);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1_no);
			
			WebElement periodSelect = driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
			Select periodDropdown = new Select(periodSelect);
			periodDropdown.selectByVisibleText(period2_time); // Select value from drop down
			
			WebElement frequencySelect = driver.findElement(By.xpath("//select[@id='frequency']"));
			Select freqDropdown = new Select(frequencySelect);
			freqDropdown.selectByVisibleText(frequency);  // Select value from drop down
			
			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click(); // Clicked on 'calculate' button
			
			
			// 3. Validate the data and update the excel with result
			String actual_Amount = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			if(Double.parseDouble(expectedMaturity_amount) == Double.parseDouble(actual_Amount))
			{
				System.out.println("Test Passed.");
				ExcelUtility.setCellData(filePath, "Sheet1", r, 7, "Passed");
				ExcelUtility.fileGroundColor(filePath, "Sheet1", r, 7);
			}
			else 
			{
				System.out.println("Test Failed.");
				ExcelUtility.setCellData(filePath, "Sheet1", r, 7, "Failed");
				ExcelUtility.fileRedColor(filePath, "Sheet1", r, 7);
			}
			
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//img[@class='PL5']")).click(); // Clicked on 'clear' button
			
		} // Ending of for loop
		
		
		Thread.sleep(2000);
		driver.close();
		
	}
}

