package day43.pack1;

import org.testng.annotations.*;

public class C2 {
	
  
	  @AfterTest
	  public void atest() 
	  {
		  System.out.println("T1 - AfterTest printing...");
	  }
	  
	
	@Test(priority=2)
	public void advSearch()
	{
		System.out.println("T1 - Advance Search function testing..");
	}
  
  
  
}
