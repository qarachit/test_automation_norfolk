package com.Norfolk.scripts;

import org.testng.annotations.Test;

import com.Norfolk.pagehelper.LoginHelper;
import com.Norfolk.util.DriverTestCase;
import com.Norfolk.util.PropertyReader;
import com.Norfolk.util.ExecutionLog;

public class Login extends DriverTestCase {
	@Test
	public void testLogin() throws Exception {
		// Initialize objects
		LoginHelper loginHelper = new LoginHelper(getWebDriver());
		
		PropertyReader propertyReader = new PropertyReader();
		String appUrl = propertyReader.readApplicationFile("Norfolk_URL");
		String username = propertyReader.readApplicationFile("Login_Email");
		String password = propertyReader.readApplicationFile("Login_Password");
		
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
			/*
			ExecutionLog.Log("Validate if you are logged in");
			loginHelper.isLoggedIn();
			ExecutionLog.Log("Make Signout");
			ExecutionLog.Log("Expand the profile menu");
			loginHelper.clickProfileMenu();
			Thread.sleep(5000);
			ExecutionLog.Log("Click Signout");
			loginHelper.clickSignout();
			Thread.sleep(5000);
			ExecutionLog.Log("Validate if you are logged out");
			loginHelper.isLoggedOut();
			Thread.sleep(20000);
			*/
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
