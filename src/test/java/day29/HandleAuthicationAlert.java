package day29;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAuthicationAlert {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//driver.get("https://the-internet.herokuapp.com/basic_auth"); // will ask for username and password
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth"); // we are injecting username and password with url
		
	}

}
