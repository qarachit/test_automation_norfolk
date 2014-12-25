package com.Norfolk.pagehelper;

import org.openqa.selenium.WebDriver;
import com.Norfolk.locators.LocatorReader;
import com.Norfolk.util.DriverHelper;

public class MyAccountHelper extends DriverHelper 
{
	private LocatorReader myAccountLocator;	
	
	public MyAccountHelper(WebDriver driver) {
		super(driver);
		myAccountLocator = new LocatorReader("MyAccount.xml");
	}
	
	public void clickClear()
	{
		String locator = myAccountLocator.getLocator("myaccount.ClearApplication");
		clickOn(locator);
	}	
	
	public void clickBegin()
	{
		String locator = myAccountLocator.getLocator("myaccount.BeginApp");
		clickOn(locator);
	}
}
