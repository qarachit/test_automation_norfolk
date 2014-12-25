package com.Norfolk.pagehelper;

import org.openqa.selenium.WebDriver;
import com.Norfolk.locators.LocatorReader;
import com.Norfolk.util.DriverHelper;

public class LoginHelper extends DriverHelper 
{
	private LocatorReader loginLocator;	
	
	public LoginHelper(WebDriver driver) {
		super(driver);
		loginLocator = new LocatorReader("Login.xml");
	}

	public void enterEmail(String text)
	{
		String locator = loginLocator.getLocator("Login.Email");
		sendKeys(locator, text);		
	}
	
	public void enterPassword(String text)
	{
		String locator = loginLocator.getLocator("Login.Password");
		sendKeys(locator, text);		
	}
	
	public void clickSignin()
	{
		String locator = loginLocator.getLocator("Login.SignInButton");
		clickOn(locator);
	}	
	
	public void isLoggedIn()
	{
		String locator = loginLocator.getLocator("Login.profileMenu");
		isElementPresent(locator);
	}
	
	public void clickProfileMenu()
	{
		String locator = loginLocator.getLocator("Login.profileMenu");
		clickOn(locator);
	}
	
	public void clickSignout()
	{
		String locator = loginLocator.getLocator("Login.signout");
		clickOn(locator);
	}
	public void isLoggedOut()
	{
		String locator = loginLocator.getLocator("Login.UserName");
		isElementPresent(locator);
	}
	
}
