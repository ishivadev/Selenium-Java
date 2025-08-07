package day44;

import org.testng.annotations.*;

public class LoginTest {

	@Test(priority=1, groups="sanity")
	public void loginUsingEmail()
	{
		System.out.println("Login passed using Email.");
	}
	
	
	@Test(priority=2, groups="sanity")
	public void loginUsingFacebook()
	{
		System.out.println("Login passed using Facebook.");
	}
	
	
	@Test(priority=3, groups="sanity")
	public void loginUsingTwitter()
	{
		System.out.println("Login passed using Twitter.");
	}
	
	
}
