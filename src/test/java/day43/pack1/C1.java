package day43.pack1;

import org.testng.annotations.*;

public class C1 {
	
  @BeforeTest
  public void btest() 
  {
	  System.out.println("T1 - BeforeTest printing...");
  }
  
  
  @Test(priority=1)
	public void search()
	{
		System.out.println("T1 - Search function testing..");
	}
	  
  
}
