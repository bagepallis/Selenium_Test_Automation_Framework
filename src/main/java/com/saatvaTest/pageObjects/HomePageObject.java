package com.saatvaTest.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saatvaTest.core.BaseClass;

public class HomePageObject extends BaseClass{
	
	@FindBy(name="account")
	WebElement account_button;

	//@FindBy(xpath="//div[@id='layout']/div[8]/button")
	
	@FindBy(xpath="/html/body/div[1]/div[8]/button")
	WebElement closeAdd;
	
	//@FindBy(id="lightbox-iframe-ff42f24c-8764-41ed-a4df-11ef952598f9")
	@FindBy(xpath = "//iframe[contains(@id, 'lightbox')]")
	WebElement adFrame;
	
	//create consturctor - to use iniElement method
	public HomePageObject() {
		PageFactory.initElements(driver, this);
	}
	

	public void clickAccountButton() {
		account_button.click();
	}
	
	public void closeAd() {
		driver.switchTo().frame(adFrame);
		closeAdd.click();
		driver.switchTo().parentFrame();
	}
	
}
