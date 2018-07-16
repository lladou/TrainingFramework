package com.Altimetrik.Framework.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Altimetrik.Framework.PageHelpers.SalesforceLoginPage;
import com.Altimetrik.Framework.PageHelpers.Util;

public class ParentTestCase {
	
	public WebDriver driver;
	protected Util classUtil;
	protected SalesforceLoginPage classSalesforceLoginPage;

	public WebDriver getDriver() {
		return this.driver;
	}
	
	protected void generateTestEnvironment() throws InterruptedException {
		this.classUtil = new Util(getDriver());
		this.classSalesforceLoginPage = new SalesforceLoginPage(getDriver());
	}
	
	@BeforeClass
	public void initDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		generateTestEnvironment();
		
		classUtil = PageFactory.initElements(driver, Util.class);
		classSalesforceLoginPage = PageFactory.initElements(driver, SalesforceLoginPage.class);
		
		classSalesforceLoginPage.openSalesforce();
	}
	
	@AfterClass
	public void quit(){
		this.driver.quit();
	}

}
