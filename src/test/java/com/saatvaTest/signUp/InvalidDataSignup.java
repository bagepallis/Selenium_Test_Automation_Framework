package com.saatvaTest.signUp;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.saatvaTest.core.BaseClass;

public class InvalidDataSignup extends BaseClass {
	
	@Test(enabled=true)
	public void errorEmailMsgVerification() throws InterruptedException  {
		//open browser and load URL - baseclass
		//click on account icon
	
		Thread.sleep(5000);
		homepage.closeAd();
		homepage.clickAccountButton();
		
		//click on createAccount button 
		loginpage.clickCreateAccountButton();
		Thread.sleep(3000);
		
		//enter 1 character in email field
		createaccpage.enterEmail("e");
		Thread.sleep(5000);
		createaccpage.enterPassword(" ");
		extentTest.log(Status.PASS, "email entered with invalid data: e");
		
		//verify the error message
		String actualEmailErrMsg = createaccpage.getEmailErrorMsg();
		String expectedEmailErrMsg = "Invalid Email";
		
		AssertJUnit.assertEquals(expectedEmailErrMsg,actualEmailErrMsg);
	}

	@Test(enabled=false)
	public void errorPasswdMsgVerification() throws InterruptedException  {
		//open browser and load URL-baseclass
		//click on account icon
		Thread.sleep(5000);
		homepage.closeAd();
		homepage.clickAccountButton();
		
		//click on createAccount button 
		loginpage.clickCreateAccountButton();
		Thread.sleep(3000);
		createaccpage.enterPassword("123Test12#jjjjjjjjjjjjjj8888888888888");
		
		createaccpage.enterEmail(" ");
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "enter more than 25 chars in password field");
		
		//verify the error message
		String actualPasswdErrMsg = createaccpage.getPasswdErrorMsg();
		String expectedPasswdErrMsg = "Invalid Password entered";
		
		AssertJUnit.assertEquals(expectedPasswdErrMsg,actualPasswdErrMsg);
	}
	
	@Test
	
	public void createAccountwithExistingAccEmail() throws InterruptedException {
		
		homepage.closeAd();
		homepage.clickAccountButton();
		loginpage.clickCreateAccountButton();
		
		Thread.sleep(3000);
		
		createaccpage.enterFirstName("Jobn");
		createaccpage.enterLastName("Listna");
		createaccpage.enterEmail("simpled112bnb@mailinator.com");
		createaccpage.enterPassword("123Test12#");
		createaccpage.clickCreateAccBtn();
		Thread.sleep(5000);
		extentTest.log(Status.PASS, "email entered already has an account");
		String actualMsg = createaccpage.getExistingEmailErrMsg();
		String expectedMsg = "An account with that email address already exists."
				+ "\n"
				+ "Please try again or contact us at 1-877-672-2882 for more assistance.";
		
		Assert.assertEquals(actualMsg, expectedMsg);
		}
}
