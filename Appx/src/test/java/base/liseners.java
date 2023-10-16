package base;





import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;




import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.init;
import test.reporting;




public class liseners extends init implements ITestListener {
	
    ExtentReports extent = reporting.generateReports();
    ExtentTest test;
    private static Logger logger=LogManager.getLogger(liseners.class);
    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestStart(result);
         test    =extent.createTest(result.getName());
         logger.info("Starting the test ... "+result.getName());
    }




   @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestSuccess(result);
         test.pass("this testcase got pass :"+result.getName());
         System.out.println("this testcase got pass :"+result.getName());
    }




   @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailure(result);
        test.fail("this testcase is fail :"+result.getName());
        System.out.println("this testcase is fail :"+result.getName());
        logger.info("this testcase is fail :"+result.getName());
        String screenshotname = "";
        WebDriver driver=null;
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            screenshotname = screenshot(driver,result.getName());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        test.addScreenCaptureFromPath(screenshotname);
    }




   @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestSkipped(result);
    }




   @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }




   @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        // TODO Auto-generated method stub
        ITestListener.super.onTestFailedWithTimeout(result);
    }




   @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
        ITestListener.super.onStart(context);
    }




   @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        ITestListener.super.onFinish(context);
         extent.flush();
         logger.error("Test Completed");
    }




   




}