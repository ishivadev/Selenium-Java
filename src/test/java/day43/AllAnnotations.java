package day43;

import org.testng.annotations.*;


public class AllAnnotations {

	@BeforeSuite
	public void bsuite()
	{
		System.out.println("BeforeSuite test...'");
	}
	
	@BeforeTest
	public void btest()
	{
		System.out.println("BeforeTest...");
	}
	
	@BeforeClass
	public void blass()
	{
		System.out.println("BeforeClass Test..");
	}

	@BeforeMethod
	public void bmethod() 
	{
		System.out.println("BeforeMethod test...");
	}
	
	@Test(priority=1)
	public void search()
	{
		System.out.println("Test - Search function testing..");
	}
	
	@Test(priority=2)
	public void advSearch()
	{
		System.out.println("Test - Advance Search function testing..");
	}
	
	@AfterMethod
	public void amethod() 
	{
		System.out.println("AfterMethod test...");
	}
	
	
	@AfterClass
	public void aclass()
	{
		System.out.println("AfterClass Test..");
	}
	
	@AfterTest
	public void atest()
	{
		System.out.println("AfterTest...");
	}
	
	@AfterSuite
	public void asuite()
	{
		System.out.println("AfterSuite test...'");
	}

}
