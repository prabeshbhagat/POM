package com.zoho.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.zoho.qa.base.TestBase;
import com.zoho.qa.util.TestUtil;

public class LeadsPage extends TestBase {
	
	
	
	
	
	
	//Its not compulsory to define page factory for all the elements
	//for checkbox we won't use page factory
	
	
	public String verifyLeadsPageTitle(){
		return driver.getTitle();
		
	}
	
	public void selectLeadByName(String name){
		
		WebElement clickCheckbox=driver.findElement(By.xpath("a[contains(text(),'"+name+"')]"
				+ "//parent::td[@class='mW100 scrollColun lv_data_textfield']//"
				+ "preceding-sibling::td[@class='lvCB fixedColumnLV LVSecondCol']//"
				+ "label//span[@class='customCheckBox']"));	
		TestUtil.clickOn(driver,clickCheckbox, TestUtil.Timeouts);
		}

}




//a[contains(text(),'Satya Nayak')]//parent::td[@class='mW100 scrollColun lv_data_textfield']//preceding-sibling::td[@class='lvCB fixedColumnLV LVSecondCol']//label//span[@class='customCheckBox']