package day38;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableExtensionAtRunTime {

	public static void main(String[] args) {

		// Setup ChromeOptions
		ChromeOptions options = new ChromeOptions();
		File file = new File("D:\\Automation\\SelectorsHub.crx");
		
		if (file.exists()) {
		    System.out.println( "✅ Extension file found: " + file.getAbsolutePath() );
		    options.addExtensions(file);
		    
		} else {
		    System.out.println( "❌ CRX file not found." );
		    return;
		}


		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

	}

}
