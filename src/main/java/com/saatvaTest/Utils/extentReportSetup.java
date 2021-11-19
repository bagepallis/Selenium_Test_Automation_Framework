package com.saatvaTest.Utils;

import java.util.Date;
import java.text.SimpleDateFormat;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.saatvaTest.core.ObjectRepository;

public class extentReportSetup extends ObjectRepository{
	
	public static ExtentReports setUpExtentReport() {
		
		//get current date
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date newDate = new Date();
		
		String actualDate = format.format(newDate);
		
		
		String reportPath = System.getProperty("user.dir") + "/Reports/ExecutionReport_"+actualDate +".html";
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		sparkReporter.config().setDocumentTitle("DocumentTitle");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("ReportName");
		
		return extent;
	}
}
