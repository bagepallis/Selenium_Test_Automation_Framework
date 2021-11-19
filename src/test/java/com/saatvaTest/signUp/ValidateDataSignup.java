package com.saatvaTest.signUp;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.saatvaTest.Utils.saatvaExcelUtils;
import com.saatvaTest.core.BaseClass;


public class ValidateDataSignup extends BaseClass {
	
	saatvaExcelUtils excelData = new saatvaExcelUtils("SaatvaCreateAccount");

	
	@Test(enabled=true)
	public void signupAcc()  {
		System.out.println(driver.getTitle());
	}

	@Test(enabled=false)
	public void signupAcc_longName()  {
		System.out.println(driver.getCurrentUrl());
	}

   @Test(dataProvider="createAccData", enabled=false)
	public void createAccountwithValidData(Object obj1) throws InterruptedException {
		
		@SuppressWarnings("unchecked")
		HashMap<String, String> testData = (HashMap<String, String>) obj1;

		extentTest.log(Status.INFO, "Test Data in HashMap: " + testData );
		homepage.closeAd();
		homepage.clickAccountButton();
		loginpage.clickCreateAccountButton();

		Thread.sleep(3000);

		createaccpage.enterCreateAccountData(testData);
		extentTest.log(Status.PASS, "Data to create account entered for all manadatory fields");
		createaccpage.clickCreateAccBtn();
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "Account create confirmation page displayed");
		String actualMsg = createaccconfirmpage.getCreateAccConfirmMessage();
		String expectedMsg = "Activate your account. Please click the link in the email we sent to simpled112xx@gmail.com to confirm your email address.";

		Assert.assertEquals(actualMsg, expectedMsg);
	}
	
	
   @DataProvider(name="createAccData")
   // return object array
   public Object[][] createData1() throws Exception {

	   Object[][] retObjArr = new Object[excelData.getRowCnt()][excelData.getColCnt()];
	   for (int i = 1; i<= excelData.getRowCnt(); i++) {
		   HashMap<String, String> testData = excelData.getTestDataFromFile(i);
		   retObjArr[i-1][0] = testData;
	   }
	   return(retObjArr);
   }
}
