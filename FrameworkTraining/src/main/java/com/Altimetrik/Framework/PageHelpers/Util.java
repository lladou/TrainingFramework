package com.Altimetrik.Framework.PageHelpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	
	protected WebDriver driver;
	
	protected static final int EXPLICIT_WAIT_TIME = 15;

	//-------------------- CONSTRUCTOR --------------------
	
	public Util(WebDriver driver) {
		this.driver = driver;
	}
	
	//-------------------- WAITS --------------------
	
	public void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(this.driver, EXPLICIT_WAIT_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	//-------------------- ACTIONS --------------------
	
	/**
	 * <h1>readBuildProperties</h1>
	 * Reads properties from buildAutomation.properties file
	 * @param property
	 * @return property value
	 */
	public static String readBuildProperties(String property) {
		
		Properties prop = new Properties();

		String fileName = System.getProperty("user.dir")+"\\buildAutomation.properties";

		try {
		
			InputStream input = new FileInputStream(fileName);
			prop.load(input);
			input.close();

			return prop.getProperty(property);
			
		} catch (IOException io) {
			io.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * <h1>click</h1>
	 * Clicks element
	 * @param element
	 */
	public void click(WebElement element) {
		explicitWait(element);
		element.click();
	}

	/**
	 * <h1>sendKeys</h1>
	 * Types text into element
	 * @param element
	 * @param text
	 */
	public void sendKeys(WebElement element, String text) {
		explicitWait(element);
		element.sendKeys(text);
	}
	
	/**
	 * <h1>selectByValue</h1>
	 * Selects value from element
	 * @param element
	 * @param value
	 */
	public void selectByValue(WebElement element, String value) {
		explicitWait(element);
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	/**
	 * <h1>getText</h1>
	 * @param element
	 * @return text from element
	 */
	public String getText(WebElement element) {
		explicitWait(element);
		return element.getText();
	}
	
	/**
	 * <h1>isDisplayed</h1>
	 * @param element
	 * @return true if element is displayed
	 * 	else return false
	 */
	public boolean isDisplayed(WebElement element) {
		explicitWait(element);
		return element.isDisplayed();
	}
	
	/**
	 * <h1>switchToFrame</h1>
	 * Switches to frame
	 * @param element
	 */
	public void switchToFrame(WebElement element) {
		WebDriverWait wait = new WebDriverWait(this.driver, EXPLICIT_WAIT_TIME);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	
	/**
	 * <h1>isEnabled</h1>
	 * @param element
	 * @return true if element is enabled
	 * 	else return false
	 */
	public boolean isEnabled(WebElement element) {
		explicitWait(element);
		return element.isEnabled();
	}
	
	/**
	 * <h1>getAttribute</h1>
	 * @param element
	 * @param attribute
	 * @return attribute value
	 */
	public String getAttribute(WebElement element, String attribute) {
		explicitWait(element); 
		return element.getAttribute(attribute);
	}
	
	/**
	 * <h1>acceptAlert</h1>
	 * Accepts emerging alert
	 */
	public void acceptAlert() {
		WebDriverWait wait = new WebDriverWait(this.driver, EXPLICIT_WAIT_TIME);
		wait.until(ExpectedConditions.alertIsPresent());
		this.driver.switchTo().alert().accept();
	}
	
}
