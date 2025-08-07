package day43.pack1;

import org.testng.annotations.*;

public class C3 {
	
	  @BeforeTest
	  public void btest() 
	  {
		  System.out.println("T2 - BeforeTest printing...");
	  }
		  
	
	  @AfterTest
	  public void atest() 
	  {
		  System.out.println("T2 - AfterTest printing...");
	  }
	  
	
	@Test(priority=2)
	public void advSearch()
	{
		System.out.println("T2 - Advance Search function testing..");
	}
  
	@Test(priority=1)
	public void search()
	{
		System.out.println("T2 - Search function testing..");
	}
  
  
}
