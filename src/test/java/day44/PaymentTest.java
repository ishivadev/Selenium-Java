package day44;

import org.testng.annotations.Test;

public class PaymentTest {

	@Test(priority=1, groups= {"sanity", "regression", "functional"})
	public void paymentUsingRupee()
	{
		System.out.println("Payment done using Rupee.");
	}
	
	
	@Test(priority=1, groups= {"sanity", "regression", "functional"})
	public void paymentUsingDollare()
	{
		System.out.println("Payment done using Dollar.");
	}
	
}
