package com.saatvaTest.pageObjects;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saatvaTest.core.BaseClass;

public class CreateAccountPageObject extends BaseClass{
	
	
	@FindBy(id="signup-first-name-input")
	WebElement createAccFirstName;
	
	@FindBy(id="signup-last-name-input")
	WebElement createAccLastName;
	
	@FindBy(id="nav-login-email")
	WebElement createAccEmail;
	
	@FindBy(id="nav-login-password")
    WebElement createAccPassword;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[2]/div/div/div/form/button[1]")
	WebElement createAccBtn;
	
	@FindBy(xpath= "//label[@for='nav-login-email']//following-sibling::div")
//	@FindBy(xpath= "//*[@id=\"app\"]/div[2]/div/div/div/form/div[2]/div/div/div")
	WebElement emailErrorMsg;
	
	@FindBy(xpath= "//label[@for='nav-login-password']//following-sibling::div")
	WebElement passwdErrorMsg;
	
	//@FindBy(xpath= "//div[@role='dialog']/div/div/div/div/p")
	@FindBy(xpath="//div[@role='dialog']//div[contains(@class, 'errorMessage')]/p[@class='t-bodySm']")
	WebElement existingEmailErrMsg1;
	
	//@FindBy(xpath= "//div[@role='dialog']/div/div/div/div/span")
	@FindBy(xpath="//div[@role='dialog']//div[contains(@class, 'errorMessage')]/span")
	WebElement existingEmailErrMsg2;
	
	
	
	public CreateAccountPageObject() {
		PageFactory.initElements(driver, this);
	}

	public void enterFirstName(String fname) {
		
		createAccFirstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		
		createAccLastName.sendKeys(lname);
	}
	
	public void enterEmail(String email) {
		createAccEmail.sendKeys(email);
	}
	
	public void enterPassword(String passwd) {
		createAccPassword.sendKeys(passwd);
	}
	
	public String getEmailErrorMsg() {
		
		//WebElement errmsg = driver.findElement(By.xpath("//*[@id='app']/div[2]/div/div/div/form/div[2]/div/div/div[1]"));
		//String err = errmsg.getAttribute("textContent");
		
		
//		WebElement hiddenDiv = driver.findElement(By.xpath("//*[@id='app']/div[2]/div/div/div/form/div[2]/div/div/div[1]"));
//		String n = hiddenDiv.getText();
//		String script = "return document.getElementsByClassName('formError accountFlow__formFieldError u-textLeft').innerHTML";
//		n = (String) ((JavascriptExecutor) driver).executeScript(script, hiddenDiv);
		
		String err = emailErrorMsg.getText();
		System.out.println("error: " + err);
	
		return err;
	}
	
	public String getPasswdErrorMsg() {
		String err = passwdErrorMsg.getText();
		return err;
	
	}
	
	public String getExistingEmailErrMsg() {
		return (existingEmailErrMsg1.getText() +"\n" + existingEmailErrMsg2.getText());
	}
	
	
	public void clickCreateAccBtn() {
		createAccBtn.click();
	}
	
	public void enterCreateAccountData(HashMap<String,String> testData) {
			createaccpage.enterFirstName(testData.get("FirstName"));
			createaccpage.enterLastName(testData.get("LastName"));
			createaccpage.enterEmail(testData.get("Email"));
			createaccpage.enterPassword(testData.get("Password"));
	}
}
