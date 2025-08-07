package day44;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependecyDemo {

	@Test(priority=1)
	public void openapp()
	{
		Assert.assertTrue(true);
		System.out.println("Open app first...");
	}
	
	
	@Test(priority=1, dependsOnMethods= {"openapp"})
	public void login()
	{
		Assert.assertTrue(true);
		System.out.println("Login on the app...");
	}
	
	
	@Test(priority=1, dependsOnMethods= {"login"})
	public void search()
	{
		Assert.assertTrue(false);
		System.out.println("Search some data...");
	}
	
	
	@Test(priority=1, dependsOnMethods= {"login", "search"})
	public void advanceSearch()
	{
		Assert.assertTrue(true);
		System.out.println("Open advance serach and search data...");
	}
	
	
	@Test(priority=1, dependsOnMethods= {"login"})
	public void logout()
	{
		Assert.assertTrue(true);
		System.out.println("Logout from the app...");
	}
	
	
}
