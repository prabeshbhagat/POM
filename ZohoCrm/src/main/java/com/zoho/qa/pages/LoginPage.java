package com.zoho.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoho.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory- : OR
	
	@FindBy(id="lid")
	WebElement username;
	
	@FindBy(id="pwd")
	WebElement password;
	
	
	@FindBy(id="signin_submit")
	WebElement signBtn;
	

	@FindBy(xpath="//div[@class='logo-top']")
	WebElement zohoLogo;
	
	
	@FindBy(xpath="//a[contains(text(),'Sign Up Now')]")
	WebElement signUpBtn;
	
	// to intilize above elements/OR  we use  constructor
	//How to intize page factory --(By using PageFactory method)
	//this means current class variables
	
	
	//Intlization of page objects//OR//page factory
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String verifyLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateZohoImage(){
		return zohoLogo.isDisplayed();
	}
	
	public Homepage login(String un,String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		signBtn.click();
		
		return new Homepage();
	}

	

}
