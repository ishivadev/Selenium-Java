package day43;

import org.testng.annotations.*;

/*
 * BeforeMehtod
 * AfterMethod
 */

/*
 1. Login
 2. Check search function
 3. Logout
 4. Login
 5. Check Advance search function
 6. Logout
 */


public class AnnotationDemo1 {

	@BeforeMethod
	public void login()
	{
		System.out.println("Login..");
	}
	
	@AfterMethod
	public void logout()
	{
		System.out.println("Logout..");
	}
	
	@Test(priority=1)
	public void search()
	{
		System.out.println("Search function..");
	}
	
	@Test(priority=2)
	public void advSearch()
	{
		System.out.println("Advance Search function..");
	}
	

}
