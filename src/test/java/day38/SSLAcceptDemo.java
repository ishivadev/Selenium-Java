package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLAcceptDemo {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		
		options.setAcceptInsecureCerts(true);	// Accepting the SSL Certificate
		
		WebDriver driver = new ChromeDriver(options);
		
		String web_url = "https://wrong.host.badssl.com/";
		driver.get(web_url);
		System.out.println("The title is : " + driver.getTitle());
		
		
		Thread.sleep(3000);
		driver.close();
		
	}

}
