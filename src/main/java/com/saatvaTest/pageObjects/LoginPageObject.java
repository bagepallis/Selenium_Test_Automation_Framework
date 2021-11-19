package com.saatvaTest.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saatvaTest.core.BaseClass;

public class LoginPageObject extends BaseClass{
	
	@FindBy(id="account-login-email")
	WebElement username;
	
	@FindBy(id="account-login-password")
	WebElement password;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement sigin;
	
	@FindBy(xpath="//*[@id='app']/div[2]/div/div/div/form/button[3]")
	WebElement createAccount;
	
	public LoginPageObject() {
		PageFactory.initElements(driver, this);
	}

	public void clickCreateAccountButton() {
		createAccount.click();
	}
}
