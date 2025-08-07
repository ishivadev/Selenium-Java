package day43;

import org.testng.annotations.*;

/*
 * BeforeClass
 * AfterClass
 */

/*
1. Login
2. Check search function
3. Check Advance search function
4. Logout
*/

public class AnnotationDemo2 {

	@BeforeClass
	public void login()
	{
		System.out.println("Login Test..");
	}
	
	@AfterClass
	public void logout()
	{
		System.out.println("Logout Test..");
	}
	
	@Test(priority=1)
	public void search()
	{
		System.out.println("Search function testing..");
	}
	
	@Test(priority=2)
	public void advSearch()
	{
		System.out.println("Advance Search function testing..");
	}
	

}
