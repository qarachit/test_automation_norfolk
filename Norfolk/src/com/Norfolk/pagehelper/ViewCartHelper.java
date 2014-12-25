package com.Norfolk.pagehelper;

import org.openqa.selenium.WebDriver;
import com.Norfolk.locators.LocatorReader;
import com.Norfolk.util.DriverHelper;

public class ViewCartHelper extends DriverHelper 
{
	private LocatorReader viewCartLocator;	
	
	public ViewCartHelper(WebDriver driver) {
		super(driver);
		viewCartLocator = new LocatorReader("ViewCart.xml");
	}
	
	public void clickSelect()
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_1.SelectButton");
		clickOn(locator);
	}
	
	public void selectPermitType()
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_1.PermitType");
		String targetValue = viewCartLocator.getLocator("ViewCart_Step_1.HaulingOption");
		selectDropDown(locator,targetValue);
	}
	
	public void selectSize()
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.HaulingType");
		String targetValue = viewCartLocator.getLocator("ViewCart_Step_4.Option1");
		selectDropDown(locator,targetValue);
	}
	
	public void enterRoutingFrom(String text)
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.RoutingFrom");
		sendKeys(locator, text);		
	}
	
	public void clickPreferredRoute()
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.PreferredRoute");
		clickOn(locator);
	}
	
	public void enterMoveDate(String text)
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.MoveDate");
		sendKeys(locator, text);		
	}
	
	public void enterHauling(String text)
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.Hauling");
		sendKeys(locator, text);		
	}
	
	public void enterLoadLengthfeet(String text)
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.LoadLength_ft");
		sendKeys(locator, text);		
	}
	
	public void enterLoadLengthInch(String text)
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.LoadLength_inch");
		sendKeys(locator, text);		
	}
	
	public void enterLoadWidthfeet(String text)
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.LoadWidth_ft");
		sendKeys(locator, text);		
	}
	
	public void enterLoadWidthInch(String text)
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.LoadWidth_inch");
		sendKeys(locator, text);		
	}
	
	public void enterLoadHeightFeet(String text)
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.LoadHeight_ft");
		sendKeys(locator, text);		
	}
	
	public void enterLoadHeightInch(String text)
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.LoadHeight_inch");
		sendKeys(locator, text);		
	}
	
	public void enterVehicleWeight(String text)
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.VehicleWeight");
		sendKeys(locator, text);		
	}
	
	public void enterNumberOfAxles(String text)
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.Axles");
		sendKeys(locator, text);		
	}
	
	public void enterAxles1Feet(String text)
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.axles_1_ft");
		sendKeys(locator, text);		
	}
	public void enterAxles1Inch(String text)
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.axles_1_inch");
		sendKeys(locator, text);		
	}
	
	public void enterAxles2Feet(String text)
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.axles_2_ft");
		sendKeys(locator, text);		
	}
	public void enterAxles2Inch(String text)
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.axles_2_inch");
		sendKeys(locator, text);		
	}
	
	public void enterWheelBaseFeet(String text)
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.wheelbaseft");
		sendKeys(locator, text);		
	}
	
	public void enterWheelBaseInch(String text)
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.wheelbaseinch");
		sendKeys(locator, text);		
	}
	
	public void clickOverhang()
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.Overhang");
		clickOn(locator);
	}
	
	public void enterLicenseNumber(String text)
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.LicenseNumber");
		sendKeys(locator, text);		
	}
	
	public void clickAmount()
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.InsuranceAmount");
		clickOn(locator);
	}
	
	public void clickSubmit()
	{
		String locator = viewCartLocator.getLocator("ViewCart_Step_4.Submit");
		clickOn(locator);
	}
}
