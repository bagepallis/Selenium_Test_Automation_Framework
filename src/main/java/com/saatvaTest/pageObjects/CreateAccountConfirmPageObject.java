package com.saatvaTest.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saatvaTest.core.BaseClass;

public class CreateAccountConfirmPageObject extends BaseClass {
	
	@FindBy(xpath="//div[@class='accountFlow accountSignIn']/h2")
	WebElement createAccConfirmMsg;
	
	@FindBy(xpath="//div[@class='auth__accountMessage']/div/div/div/p")
	WebElement createAccConfirmAuthMsg;
	
	
	public CreateAccountConfirmPageObject() {
		PageFactory.initElements(driver, this);
	}
	
	public String getCreateAccConfirmMessage() {
		return (createAccConfirmMsg.getText() + ". " + createAccConfirmAuthMsg.getText());
	}
	

}
