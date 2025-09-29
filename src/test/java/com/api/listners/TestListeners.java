package com.api.listners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.api.reports.ExtentManager; // your utility class

public class TestListeners implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListeners.class);

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Suite Started.... !!");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed !!!!");
        extent.flush(); // generate extent report at the end
    }

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test Started !! " + result.getMethod().getMethodName());
        logger.info("Description !! " + result.getMethod().getDescription());

        ExtentTest test = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test Passed !! " + result.getMethod().getMethodName());
        extentTest.get().log(Status.PASS, "Test Passed");
    }

//    @Override
//    public void onTestFailure(ITestResult result) {
//        logger.error("Test Failed !! " + result.getMethod().getMethodName());
//        logger.error("Reason: " + result.getThrowable());
//        extentTest.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());
//    }
    
    
    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test Failed !! " + result.getMethod().getMethodName());
        logger.error("Reason: " + result.getThrowable());

        extentTest.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());

        // Capture screenshot if WebDriver is available
        Object testClass = result.getInstance();
        WebDriver driver = null;

        try {
            driver = (WebDriver) result.getTestClass().getRealClass()
                    .getDeclaredField("driver")
                    .get(testClass);

            if (driver != null) {
                String screenshotPath = captureScreenshot(driver, result.getMethod().getMethodName());
                extentTest.get().addScreenCaptureFromPath(screenshotPath);
                logger.info("Screenshot captured: " + screenshotPath);
            }
        } catch (Exception e) {
            logger.error("Exception while taking screenshot: ", e);
        }
    }
    

    private String captureScreenshot(WebDriver driver, String methodName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
    public void onTestSkipped(ITestResult result) {
        logger.info("Test Skipped !! " + result.getMethod().getMethodName());
        extentTest.get().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
       logger.info("Success Percentage for this Test -: " + result.getMethod().getSuccessPercentage());
    }
}
