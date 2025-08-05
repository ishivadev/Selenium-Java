package day41;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesOfConfigFile {

	public static void main(String[] args) throws IOException {
		
		// Opening the file
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testData\\config.properties");
		
		// Loading the file
		Properties propertyObj = new Properties();
		propertyObj.load(file);
		
		// reading the data from file
		String url = propertyObj.getProperty("appurl"); // 'appurl' is the key
		String emailID = propertyObj.getProperty("email"); // 'email' is the key
		String password = propertyObj.getProperty("password");
		String orderID = propertyObj.getProperty("orderid");
		String customerID = propertyObj.getProperty("customerid");
		
		System.out.println(url +" "+ emailID +" "+ password +" "+ orderID +" "+ customerID);
		
		
		// Reading keys from the file
		// Approach 1
		//Set<String> keys = propertyObj.stringPropertyNames();
		//System.out.println(keys);
		
		// Approach 2
		//Set<Object> keys = propertyObj.keySet();
		//System.out.println(keys);
		
		
		// Reading value from the file
		Collection<Object> values = propertyObj.values();
		System.out.println(values);
		
		file.close();
		
	}

}
