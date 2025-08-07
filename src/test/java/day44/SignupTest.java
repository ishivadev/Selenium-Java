package day44;

import org.testng.annotations.*;

public class SignupTest {

	@Test(priority=1, groups="regression")
	public void signUpEmail()
	{
		System.out.println("Signup passed using Email.");
	}
	
	
	@Test(priority=2, groups="regression")
	public void signUpFacebook()
	{
		System.out.println("Signup passed using Facebook.");
	}
	
	
	@Test(priority=3, groups="regression")
	public void signUpTwitter()
	{
		System.out.println("Signup passed using Twitter.");
	}
	
	
}
