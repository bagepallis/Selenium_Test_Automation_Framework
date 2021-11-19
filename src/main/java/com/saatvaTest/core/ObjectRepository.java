package com.saatvaTest.core;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.saatvaTest.pageObjects.CreateAccountConfirmPageObject;
import com.saatvaTest.pageObjects.CreateAccountPageObject;
import com.saatvaTest.pageObjects.HomePageObject;
import com.saatvaTest.pageObjects.LoginPageObject;

public class ObjectRepository {
	
	
	public static HomePageObject homepage;
	public static LoginPageObject loginpage;
	public static CreateAccountPageObject createaccpage;
	public static CreateAccountConfirmPageObject createaccconfirmpage;


	public static ExtentReports extent;
	public static ExtentTest extentTest;
	public static WebDriver driver;

}
