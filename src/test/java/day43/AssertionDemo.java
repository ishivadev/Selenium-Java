package day43;

import org.testng.Assert;
import org.testng.annotations.*;

public class AssertionDemo {
  
  @Test
  public void hardAssertion() 
  {
	  String expt_str = "OrangeDemo";
	  String act_str = "Orange";
	  
	  /*
	  if(expt_str.equals(act_str))
	  {
		  System.out.println("Test passed");
	  }
	  else 
	  {
		  System.out.println("Test failed.");
	  }
	  */
	  
	  Assert.assertEquals(act_str, expt_str); // fail
	  //Assert.assertEquals("123", "123"); // true
	  //Assert.assertSame("test", "test");
	  
	  //Assert.assertNotEquals("test", "testing"); // true
	  //Assert.assertNotEquals(123, 234.00); // true
	  
	 //Assert.assertTrue(false); // false
	 //Assert.assertFalse(true); // false
	  //Assert.assertTrue(1==1); // true
	  //Assert.assertFalse(1 != 1); // true
	  
	  //Assert.fail();
	  
  }
  
  
}
