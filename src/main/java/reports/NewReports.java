package reports;

import base.BaseTest;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class NewReports extends BaseTest {
	
	public static ExtentReports reports;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentTest test;
	ITestResult result;
	
	public static void startReports()
	{
		reports=new ExtentReports();
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//test-output//extentreport.html");
		reports.attachReporter(htmlReporter);
		reports.setSystemInfo("machine", "sonys machine");
		test=reports.createTest("SampleTest");
		
	}
		
	
	public static void sendresult(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail(result.getName());
			test.fail(result.getThrowable());
		}
			else if(result.getStatus() == ITestResult.SUCCESS)
			{
				test.pass(result.getName());
				
			}
		else if (result.getStatus() == ITestResult.SKIP)
		{
			test.pass(result.getName() + "SKIPPED");
			
		}
		}
		
	
  public static void endTest()
	{
		reports.flush();
	}
}
