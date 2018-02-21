package com.zoho.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.zoho.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		// Read properties
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("/Users/prabesh/Documents/workspace/POM/ZohoCrm/src/"
					+ "main/java/com/zoho/qa/config/config.properties");
			

			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void intilization(){
		//read property
		String browserType=prop.getProperty("browser");
		if(browserType.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/prabesh/Downloads/chromedriver");
			driver = new ChromeDriver();
			
		}else if(browserType.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "/Users/prabesh/Downloads/geckodriver");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeouts, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	
	
	
	
	
	}
	

}
