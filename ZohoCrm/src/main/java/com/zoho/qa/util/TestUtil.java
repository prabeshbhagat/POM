package com.zoho.qa.util;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
	
	
	public static long Page_Load_Timeouts=50;
	public static long Implicitly_Wait=50;
	public static int  Timeouts=50;
	
	public static void clickOn(WebDriver driver ,WebElement element,int timeout){
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).
		until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}

	

}
