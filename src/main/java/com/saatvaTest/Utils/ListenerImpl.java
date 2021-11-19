package com.saatvaTest.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.saatvaTest.core.ObjectRepository;

public class ListenerImpl extends ObjectRepository implements ITestListener{

	public void onTestStart(ITestResult result) {
		// before each test
		extentTest = extent.createTest(result.getMethod().getMethodName());
		
		System.out.println("extentTest");
		
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test case: " + result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
	
		extentTest.log(Status.FAIL, "Failed Test case: " + result.getMethod().getMethodName());
		extentTest.log(Status.FAIL, result.getThrowable());
		
		//add screenshot for failed test
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date newDate = new Date();	
		String actualDate = format.format(newDate);
		
		String screenShotPath = System.getProperty("user.dir") + "Reports/ScreenShots/" + actualDate +".jpeg";
		File dest = new File(screenShotPath);
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//add the screenshot to the extentTest report
		extentTest.addScreenCaptureFromPath(screenShotPath, "Test case failure screenshot");
		
		}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		//call setup Method
		extent = extentReportSetup.setUpExtentReport();
		
	}

	public void onFinish(ITestContext context) {
		//close extent
		extent.flush();
	}

}
