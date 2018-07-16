package com.Altimetrik.Framework.PageHelpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SalesforceLoginPage extends Util{
	
	protected static final String SERVER = readBuildProperties("sf.server");
	protected static final String USERNAME = readBuildProperties("sf.username");
	protected static final String PASSWORD = readBuildProperties("sf.password");
	
	//-------------------- ELEMENTS --------------------
	
	//Username
	@FindBy(how = How.ID, using = "username")
	private WebElement usernameField;
	
	//Password
	@FindBy(how = How.ID, using = "password")
	private WebElement passwordField;
	
	//Login Button
	@FindBy(how = How.ID, using = "Login")
	private WebElement loginButton;
	
	//-------------------- CONSTRUCTOR --------------------
	
	public SalesforceLoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	//-------------------- ACTIONS --------------------
	public void enterUsername(String username) {
		sendKeys(usernameField, username);
	}
	
	public void enterPassword(String password) {
		sendKeys(passwordField, password);
	}
	
	public void clickLoginButton() {
		click(loginButton);
	}
	
	public void openSalesforce() {
		this.driver.navigate().to(SERVER);
		enterUsername(USERNAME);
		enterPassword(PASSWORD);
		clickLoginButton();
	}

}
