package com.saatvaTest.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.saatvaTest.Utils.parsePropertyfile;
import com.saatvaTest.pageObjects.CreateAccountConfirmPageObject;
import com.saatvaTest.pageObjects.CreateAccountPageObject;
import com.saatvaTest.pageObjects.HomePageObject;
import com.saatvaTest.pageObjects.LoginPageObject;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends ObjectRepository{
	
	//driver = null;
	
	public void LaunchBrowserAndOpenURL() throws Exception {
		
		//read property file for browser and URL
		String browser = parsePropertyfile.getPropertyValueByKey("browser");
		String url = parsePropertyfile.getPropertyValueByKey("url");
		
		if (browser.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup(); //use this instead of system.setProperty
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup(); //use this instead of system.setProperty
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		
		driver.get(url);
	}
	

	@BeforeMethod
	public void setUp() throws Exception{

		LaunchBrowserAndOpenURL();
		homepage = new HomePageObject();
		loginpage = new LoginPageObject();
		createaccpage = new CreateAccountPageObject();
		createaccconfirmpage = new CreateAccountConfirmPageObject();
		//getSaatvaCreateAccData = new saatvaExcelUtils();
	}
	
	@AfterMethod
	public void cleanup() {
		driver.quit();
	}

}
