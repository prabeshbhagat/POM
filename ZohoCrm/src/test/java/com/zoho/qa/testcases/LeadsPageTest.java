package com.zoho.qa.testcases;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.zoho.qa.base.TestBase;
import com.zoho.qa.pages.Homepage;
import com.zoho.qa.pages.LeadsPage;
import com.zoho.qa.pages.LoginPage;
import com.zoho.qa.util.TestUtil;

public class LeadsPageTest extends TestBase {

	LoginPage loginpage;
	Homepage homepage;
	LeadsPage leadspage;
	ChromeOptions options;
	String sheetName="leads";
	String sheetName1="editleads";
	String sheetName2="edithiddenleads";
					   
	
	public LeadsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		intilization();
		loginpage=new LoginPage();
		leadspage= new LeadsPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage.clickOnLeadsLink();
	}
	
	@Test(priority=1)
	public void verifyLeadsPageTitleTest(){
		String leadsPageTitle=leadspage.verifyLeadsPageTitle();
		Assert.assertEquals(leadsPageTitle, "Zoho CRM - Leads","LeadsPage Title not matched");
	}
	
	@Test(priority=2)
	public void selectSingleLeadNameTest() throws InterruptedException{
		Thread.sleep(2000);
		leadspage.selectLeadByName("Satya Nayak");
	}
	
	@Test(priority=3)
	public void selectMultipleLeadNameTest() throws InterruptedException{
		Thread.sleep(2000);
		leadspage.selectLeadByName("Satya Nayak");
		leadspage.selectLeadByName("Ricky Ratan");
	}
	
	@DataProvider
	public Object[][] getLeadData(){
		Object [][] leadData=TestUtil.getTestData(sheetName);
		return leadData;
	}
	
	@DataProvider
	public Object[][] getLeadEditData(){
		Object [][] leadEditData=TestUtil.getTestData(sheetName1);
		return leadEditData;
	}
	
	@DataProvider
	public Object[][] getHidenLeadEditData(){
		Object [][] hiddenLeadEditData=TestUtil.getTestData(sheetName2);
		return hiddenLeadEditData;
	}
	
	@Test(priority=3,dataProvider="getLeadData")
	public void validateCreateNewLeadTest(String FirstName,String LastName,String CompanyName) throws InterruptedException {
		homepage.clickOnLeadsLink();
		Thread.sleep(3000);
		leadspage.createNewLead(FirstName, LastName, CompanyName);
		//if we want to validate we can use assertions & check whether the same got added or not
	}
	
	@Test(priority=4,dataProvider="getLeadEditData")
	public void verifyEditDataTest(String email,String CompanyName,String mobileNo) throws InterruptedException{
		homepage.clickOnLeadsLink();
		Thread.sleep(3000);
		leadspage.clickOnLeadRow(email, CompanyName, mobileNo);
	}
	
	@Test(priority=5,dataProvider="getHidenLeadEditData")
	public void verifyEditDataTest1(String email,String mobileNo) throws InterruptedException{
		homepage.clickOnLeadsLink();
		Thread.sleep(5000);
		leadspage.clickOnLeadRow1(email,mobileNo);
	}
	
	@Test(priority=6)
	public void verifyCheckAllCheckBoxTest() throws InterruptedException {
		homepage.clickOnLeadsLink();
		Thread.sleep(3000);
		leadspage.clickOnCheckAllCheckbox();
	}
	
	
	
	

//	@AfterMethod
//	public void tearDown() throws InterruptedException{
//		Thread.sleep(2000);
//		driver.quit();
//	}
}
