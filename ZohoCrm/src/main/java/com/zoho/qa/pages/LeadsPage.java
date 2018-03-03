package com.zoho.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoho.qa.base.TestBase;
import com.zoho.qa.util.TestUtil;

public class LeadsPage extends TestBase {
	

	@FindBy(xpath = "//input[@class='newwhitebtn customPlusBtn ']")
	WebElement croosButton;

	@FindBy(xpath = "//input[@class='textField' and @id='Crm_Leads_COMPANY']")
	WebElement companyNameField;

	@FindBy(xpath = "//input[@class='textField' and @id='Crm_Leads_LASTNAME']")
	WebElement lastNameField;
	
	@FindBy(xpath="//input[@class='textField' and @id='Crm_Leads_FIRSTNAME']")
	WebElement firstNameField;
	
	@FindBy(xpath="//input[@id='saveLeadsBtn']")
	WebElement saveBtn;
	
	@FindBy(xpath="//tr[@id='3049724000000197001']")
	WebElement leadsRow;
	
	@FindBy(xpath="//tr[@id='3049724000000196001']")
	WebElement leadsRow1;
	
	@FindBy(xpath="//input[@id='editRecordbtn']")
	WebElement editBtn;
	
	@FindBy(xpath="//input[@id='Crm_Leads_EMAIL']")
	WebElement emailFld;
	
	@FindBy(xpath="//input[@id='Crm_Leads_MOBILE']")
	WebElement mobileFld;
	
	
	@FindBy(xpath="//span[@class=]")
	WebElement bckBtn;
	
	
	@FindBy(className="'backtoIcon dIB mT15'")
	WebElement hidenEmailEditBtn;
	
	@FindBy(xpath="'//input[@name='button__EMAIL']")
	WebElement hiddenSaveBtn;
	
	@FindBy(xpath="'//input[@name='button__PHONE']")
	WebElement hiddenphoneSaveBtn;
	
	
	@FindBy(className="'neweditIconSvg fR link alignright'")
	WebElement hidenMobileEditBtn;
	
	@FindBy(xpath="//span[@id='checkAll']")
	WebElement checkAllCheckbox;
	
	
	
	//span[@id='checkAll']
	
	
	
	
	
	
	// Its not compulsory to define page factory for all the elements
	// for checkbox we won't use page factory
	
	public LeadsPage(){
		PageFactory.initElements(driver, this);
	}

	public String verifyLeadsPageTitle() {
		return driver.getTitle();

	}

	public void selectLeadByName(String name) {

		WebElement clickCheckbox = driver.findElement(By.xpath(
				"a[contains(text(),'" + name + "')]" + "//parent::td[@class='mW100 scrollColun lv_data_textfield']//"
						+ "preceding-sibling::td[@class='lvCB fixedColumnLV LVSecondCol']//"
						+ "label//span[@class='customCheckBox']"));
		clickCheckbox.click();

	}
	
	public void createNewLead(String fstName,String lstName,String cmpName) {
		croosButton.click();
		firstNameField.sendKeys(fstName);
		companyNameField.sendKeys(lstName);
		lastNameField.sendKeys(cmpName);
		saveBtn.click();		
	}
	
	public void clickOnLeadRow(String email,String cmpName1,String mobile){
		leadsRow.click();
		editBtn.click();
		emailFld.sendKeys(email);
		companyNameField.sendKeys(cmpName1);
		mobileFld.sendKeys(mobile);
		saveBtn.click();
		bckBtn.click();
	}
	
	public void clickOnLeadRow1(String email,String mobile){
		leadsRow1.click();
		hidenEmailEditBtn.click();
		emailFld.sendKeys(email);
		hiddenSaveBtn.click();
		hidenMobileEditBtn.click();
		mobileFld.sendKeys(mobile);
		hiddenphoneSaveBtn.click();
		bckBtn.click();
	}
	
	public void clickOnCheckAllCheckbox(){
		checkAllCheckbox.click();
	}
}

// a[contains(text(),'Satya Nayak')]//parent::td[@class='mW100 scrollColun
// lv_data_textfield']//preceding-sibling::td[@class='lvCB fixedColumnLV
// LVSecondCol']//label//span[@class='customCheckBox']