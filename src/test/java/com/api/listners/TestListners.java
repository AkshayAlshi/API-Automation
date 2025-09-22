package com.api.listners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListners  implements ITestListener{

	private static final Logger looger=LogManager.getLogger(TestListners.class);
	
	
	public void onStart(ITestContext context) {
		looger.info(" Test Suite Started.... !!");
	  }
	
	
	
	public void onFinish(ITestContext context) {
		looger.info("Test Suite Complated  !!!!");
	  }
	
	
	
	public void onTestStart(ITestResult result) {
		looger.info("Test Started !!"+ result.getMethod().getMethodName());
		looger.info("Description !!"+ result.getMethod().getDescription());
	  }

	
	
	
	public void onTestSuccess(ITestResult result) {
		looger.info("Test Passed !!"+ result.getMethod().getMethodName());
		looger.info("Description !!"+ result.getMethod().getDescription());
	  }
	
	
	public void onTestFailure(ITestResult result) {
		looger.error("Test Failed !!"+ result.getMethod().getMethodName());
		looger.info("Description !!"+ result.getMethod().getDescription());

	  }
	
	
	
	public void onTestSkipped(ITestResult result) {
		looger.info("Test Skipped !!"+ result.getMethod().getMethodName());
		
	  }
	
	public  void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		looger.info("Success Percentage for this Test -:  !!"+ result.getMethod().getSuccessPercentage());
		  }

}
