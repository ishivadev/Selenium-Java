package day43;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertion {
  
	
  //@Test
  public void hardAssertion() 
  {

	  System.out.println("test 1");
	  System.out.println("test 2");
	  
	  Assert.assertEquals("test", "testing"); // fail
	  
	  // The above Hard assertion fails and due to this the below statement will not execute
	  System.out.println("test 3"); 
	  System.out.println("test 4");
	  
	  //Assert.fail(); // intentionally fail the case
	  
  }
  
  
  @Test
  public void softAssertion()
  {
	  System.out.println("Sample 1");
	  System.out.println("Sample 2");
	  
	  SoftAssert sa = new SoftAssert();
	  sa.assertEquals("test", "testing demo"); // fail
	  
	  // The above Soft assertion fails and this will not stop the below statement
	  System.out.println("Sample 3");
	  System.out.println("Sample 4");
	  
	  sa.assertAll();
	  
  }
  
  
}
