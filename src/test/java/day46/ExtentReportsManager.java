package day46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsManager implements ITestListener {

	public ExtentSparkReporter sparkReporter; // UI of the report
	public ExtentReports extent; // Populate common information on the report
	public ExtentTest test; // Creating test case entries in the report sand update status of the test methods
	
	

	  public void onStart(ITestContext context) {
		   
		  sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\testReport.html"); // The file name is hard coded as of now
		  
		  sparkReporter.config().setDocumentTitle("Automation Report");
		  sparkReporter.config().setReportName("Functional Testing");
		  sparkReporter.config().setTheme(Theme.STANDARD);
		  
		  extent = new ExtentReports();
		  extent.attachReporter(sparkReporter); // Connecting 'extent' with 'sparkReporter'
		  
		  // Below values are in key:value pair and it is hard coded as of now
		  extent.setSystemInfo("Computer Name", "localhost");
		  extent.setSystemInfo("Environment", "QA");
		  extent.setSystemInfo("Tester Name", "Shiva");
		  extent.setSystemInfo("OS", "Windows 10");
		  extent.setSystemInfo("Browser name", "Chrome");
		  
		  }
	
	  
	  public void onTestSuccess(ITestResult result) {

		  test = extent.createTest(result.getName()); // create a new entry in the report
		  test.log(Status.PASS, "Test cases PASSED is : " + result.getName()); // update status pass/fail/skip
	  }
	  
	  
	  public void onTestFailure(ITestResult result) {

		  test = extent.createTest(result.getName());
		  test.log(Status.FAIL, "Test cases FAILED is : " + result.getName());
		  test.log(Status.FAIL, "Test cases FAILED is : " + result.getThrowable());
	  }
	  
	  
	  public void onTestSkipped(ITestResult result) {

		  test = extent.createTest(result.getName());
		  test.log(Status.SKIP, "Test cases SKIPPED is : " + result.getName());
	  }
	
	  
	  public void onFinish(ITestContext context) {
		
		  extent.flush(); // Update OR Saving the report data at the end
	  }
	
}
