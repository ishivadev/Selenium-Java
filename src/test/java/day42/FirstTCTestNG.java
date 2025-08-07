package day42;

import org.testng.annotations.Test;

public class FirstTCTestNG {
	
	
	  @Test(priority=3)
	  public void logout()
	  {
		  System.out.println("Logout......");
	  }
	  
  

	  @Test(priority=2)
	  public void login()
	  {
		  System.out.println("Login.....");
	  }
  
	  @Test(priority=1)
	  public void openpage() 
	  {
		System.out.println("Page Open......");  
	  }
	  

}
