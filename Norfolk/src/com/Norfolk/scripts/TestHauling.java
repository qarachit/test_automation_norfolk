package com.Norfolk.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.Norfolk.pagehelper.LoginHelper;
import com.Norfolk.pagehelper.MyAccountHelper;
import com.Norfolk.pagehelper.ViewCartHelper;
import com.Norfolk.util.DriverTestCase;
import com.Norfolk.util.PropertyReader;
import com.Norfolk.util.ExecutionLog;

public class TestHauling extends DriverTestCase {
	@Test
	public void testHauling() throws Exception {
		// Initialize objects
		LoginHelper loginHelper = new LoginHelper(getWebDriver());
		MyAccountHelper myAccountHelper = new MyAccountHelper(getWebDriver());
		ViewCartHelper viewCartHelper = new ViewCartHelper(getWebDriver());
		
		PropertyReader propertyReader = new PropertyReader();
		String appUrl = propertyReader.readApplicationFile("Norfolk_URL");
		String username = propertyReader.readApplicationFile("Login_Email");
		String password = propertyReader.readApplicationFile("Login_Password");
		String feet = propertyReader.readApplicationFile("ft");
		String inch = propertyReader.readApplicationFile("inch");
		String heightft = propertyReader.readApplicationFile("heightft");
		String RountingFrom = propertyReader.readApplicationFile("RountingFrom");
		String Movedate = propertyReader.readApplicationFile("Movedate");
		String Load = propertyReader.readApplicationFile("Load");
		String grossweight = propertyReader.readApplicationFile("grossweight");
		String Axles = propertyReader.readApplicationFile("Axles");
		String trucklicensenumber = propertyReader.readApplicationFile("trucklicensenumber");
		
		ExecutionLog.LogAddClass(this.getClass().getName()
				+ " and Test method "
				+ Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			// Open application url
			getWebDriver().navigate().to(appUrl);
			ExecutionLog.Log("open application url");
			Thread.sleep(15000);
			// login to the application
			loginHelper.enterEmail(username);
			ExecutionLog.Log("enter the email address");
			loginHelper.enterPassword(password);
			ExecutionLog.Log("enter the password");
			loginHelper.clickSignin();
			ExecutionLog.Log("log-in into Application");
			Thread.sleep(5000);
			myAccountHelper.clickClear();
			ExecutionLog.Log("Clear the application");
			Thread.sleep(5000);
			myAccountHelper.clickBegin();
			ExecutionLog.Log("Begin the application");
			Thread.sleep(5000);
			viewCartHelper.selectPermitType();
			ExecutionLog.Log("Select Hauling");
			Thread.sleep(5000);
			viewCartHelper.clickSelect();
			ExecutionLog.Log("Click Select Button");
			Thread.sleep(5000);
			
			viewCartHelper.selectSize();
			ExecutionLog.Log("Select Size");
			Thread.sleep(5000);
			
			viewCartHelper.enterRoutingFrom(RountingFrom);
			ExecutionLog.Log("Enter routing from");
			Thread.sleep(5000);
			
			viewCartHelper.clickPreferredRoute();
			ExecutionLog.Log("Click Preferred Route");
			Thread.sleep(5000);
			
			viewCartHelper.enterMoveDate(Movedate);
			ExecutionLog.Log("Enter Move Date");
			Thread.sleep(5000);
			
			viewCartHelper.enterHauling(Load);
			ExecutionLog.Log("Enter Load");
			Thread.sleep(5000);
			
			viewCartHelper.enterLoadLengthfeet(feet);
			ExecutionLog.Log("Enter Length in feet");
			Thread.sleep(5000);
			
			viewCartHelper.enterLoadLengthInch(inch);
			ExecutionLog.Log("Enter Length in inch");
			Thread.sleep(5000);
			
			viewCartHelper.enterLoadWidthfeet(feet);
			ExecutionLog.Log("Enter Width in feet");
			Thread.sleep(5000);
			
			viewCartHelper.enterLoadWidthInch(inch);
			ExecutionLog.Log("Enter Width in inch");
			Thread.sleep(5000);
			
			viewCartHelper.enterLoadHeightFeet(heightft);
			ExecutionLog.Log("Enter Height in feet");
			Thread.sleep(5000);
			
			viewCartHelper.enterLoadHeightInch(inch);
			ExecutionLog.Log("Enter Height in inch");
			Thread.sleep(5000);
			
			viewCartHelper.enterVehicleWeight(grossweight);
			ExecutionLog.Log("Enter vehicle weigth");
			Thread.sleep(5000);
			
			viewCartHelper.enterNumberOfAxles(Axles);
			ExecutionLog.Log("Enter number of axles");
			Thread.sleep(5000);
			
			getWebDriver().findElement(By.xpath("String")).sendKeys(Keys.ENTER);

			viewCartHelper.enterAxles1Feet(feet);
			ExecutionLog.Log("Enter axel 1 feet");
			Thread.sleep(5000);
			
			viewCartHelper.enterAxles1Inch(inch);
			ExecutionLog.Log("Enter axel 1 inch");
			Thread.sleep(5000);
			
			viewCartHelper.enterAxles2Feet(feet);
			ExecutionLog.Log("Enter axel 2 feet");
			Thread.sleep(5000);
			
			viewCartHelper.enterAxles2Inch(inch);
			ExecutionLog.Log("Enter axel 2 inch");
			Thread.sleep(5000);
			
			viewCartHelper.enterWheelBaseFeet(feet);
			ExecutionLog.Log("Enter wheel base feet");
			Thread.sleep(5000);
			
			viewCartHelper.enterWheelBaseInch(inch);
			ExecutionLog.Log("Enter wheel base inch");
			Thread.sleep(5000);
			
			viewCartHelper.clickOverhang();
			ExecutionLog.Log("click overhang");
			Thread.sleep(5000);
			
			viewCartHelper.enterLicenseNumber(trucklicensenumber);
			ExecutionLog.Log("Enter license number");
			Thread.sleep(5000);
			
			viewCartHelper.clickAmount();
			ExecutionLog.Log("click amount");
			Thread.sleep(5000);
			
			viewCartHelper.clickSubmit();
			ExecutionLog.Log("click submit");
			Thread.sleep(5000);
		}
		catch (Error e) {
			ExecutionLog.LogErrorMessage(e);
			throw e;
		} catch (Exception e) {
			ExecutionLog.LogExceptionMessage(e);
			throw e;
		}
	}
	
	//@AfterMethod
	//public void endMethods() throws Exception {
	//	ExecutionLog.LogEndClass(this.getClass().getName());
	//}

}
