package com.Norfolk.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.thoughtworks.selenium.Selenium;

public abstract class DriverHelper {

	// Define objects
	private WebDriver driver;
	private Selenium selenium;

	// Declare objects
	public DriverHelper(WebDriver webdriver) {
		driver = webdriver;
		// selenium = new WebDriverBackedSelenium(driver, "");
	}

	// Return web driver object
	public WebDriver getWebDriver() {
		return driver;
	}

	// Return selenium object
	public Selenium getSelenium() {
		return selenium;
	}

	// Print message on screen
	public void Log(String logMsg) {
		System.out.println(logMsg);
	}

	// Handle locator type
	public By ByLocator(String locator) {
		By result = null;

		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("#")) {
			result = By.name(locator.replace("#", ""));
		} else if (locator.startsWith("Link=")) {
			result = By.linkText(locator.replace("Link=", ""));
		} else {
			result = By.id(locator);
		}
		return result;
	}

	// Assert element present
	public Boolean isElementPresent(String locator) {
		Boolean result = false;
		try {
			getWebDriver().findElement(ByLocator(locator));
			result = true;
		} catch (Exception ex) {
		}
		return result;
	}

	// Wait for element present
	public void WaitForElementPresent(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Wait for element not present
	public void WaitForElementNotPresent(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (!isElementPresent(locator)) {
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Wait for element enabled
	public void WaitForElementEnabled(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				if (getWebDriver().findElement(ByLocator(locator)).isEnabled()) {
					break;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Wait for element not enabled
	public void WaitForElementNotEnabled(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				if (!getWebDriver().findElement(ByLocator(locator)).isEnabled()) {
					break;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Wait for element visible
	public void WaitForElementVisible(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				if (getWebDriver().findElement(ByLocator(locator))
						.isDisplayed()) {
					break;
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Wait for element not visible
	public void WaitForElementNotVisible(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				if (!getWebDriver().findElement(ByLocator(locator))
						.isDisplayed()) {
					break;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Wait for text present
	public void WaitForTextPresent(String locator, String text, int timeout) {
		WaitForElementPresent(locator, timeout);
		for (int i = 0; i < timeout; i++) {
			if (isTextPresent(locator, text)) {
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Handle mouse over action
	public void mouseOver(String locator) {
		this.WaitForElementPresent(locator, 50);
		WebElement el = getWebDriver().findElement(ByLocator(locator));

		// build and perform the mouseOver with Advanced User Interactions API
		Actions builder = new Actions(getWebDriver());
		builder.moveToElement(el).build().perform();
	}

	// Handle mouse double click action
	public void mouseDoubleClick(String locator) {
		this.WaitForElementPresent(locator, 50);
		WebElement el = getWebDriver().findElement(ByLocator(locator));

		// build and perform the mouse click with Advanced User Interactions API
		Actions builder = new Actions(getWebDriver());
		builder.doubleClick(el).perform();
	}

	// Handle drag and drop action
	public void dragAndDrop(String draggable, String to) {
		this.WaitForElementPresent(draggable, 50);
		this.WaitForElementPresent(to, 50);
		WebElement elDraggable = getWebDriver().findElement(
				ByLocator(draggable));
		WebElement todrag = getWebDriver().findElement(ByLocator(to));

		// build and perform drag and drop with Advanced User Interactions API
		Actions builder = new Actions(getWebDriver());
		builder.dragAndDrop(elDraggable, todrag).perform();
	}

	// Handle click action
	public void clickOn(String locator) {
		this.WaitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		WebElement el = getWebDriver().findElement(ByLocator(locator));
		el.click();
	}

	// Handle send keys action
	public void sendKeys(String locator, String text) {
		this.WaitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"+ locator + " Not found");
		WebElement el = getWebDriver().findElement(ByLocator(locator));
		//WebElement el = getWebDriver().findElement(By.xpath("//input[@id='email_input']"));
		el.clear();
		el.sendKeys(text);
	}

	// Select value from drop down
	public void selectDropDown(String locator, String targetValue) {
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		this.WaitForElementPresent(locator, 20);
		new Select(getWebDriver().findElement(ByLocator(locator)))
				.selectByVisibleText(targetValue);

	}

	// Assert text present
	public boolean isTextPresent(String locator, String str) {
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		String message = getWebDriver().findElement(ByLocator(locator))
				.getText();
		if (message.contains(str)) {
			return true;
		} else {
			return false;
		}
	}

	// Store text from a locator
	public String getText(String locator) {
		WaitForElementPresent(locator, 20);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		String text = getWebDriver().findElement(ByLocator(locator)).getText();
		return text;
	}

	// Assert check box selected
	public boolean isChecked(String locator) {
		boolean checkStatus = false;
		WaitForElementPresent(locator, 20);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		WebElement el = getWebDriver().findElement(ByLocator(locator));
		checkStatus = el.isSelected();
		return checkStatus;
	}

	// Get attribute value
	public String getAttribute(String locator, String attribute) {
		WaitForElementPresent(locator, 20);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :"
				+ locator + " Not found");
		String text = getWebDriver().findElement(ByLocator(locator))
				.getAttribute(attribute);
		return text;
	}

	// Get integer value
	public Integer getInt(String strString) {
		Pattern intsOnly = Pattern.compile("\\d+");
		String input = strString;
		Matcher makeMatch = intsOnly.matcher(input);
		makeMatch.find();
		String digitStr = makeMatch.group();
		Integer digit = Integer.parseInt(digitStr);
		return digit;
	}

	// Execute java script
	public void javaScriptExecute(String javascrpt) {
		JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
		js.executeScript(javascrpt);
	}

	public void acceptAlert() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert = getWebDriver().switchTo().alert();
		alert.accept();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void validateTask(String Text)
	{
		//String a = Text;
		//outerLoop://Label
		for (int i=1; i<10; i++)
		{
			getWebDriver().findElement(By.xpath("//table[@id='grid']/tbody/tr["+i+"]/td[4]/div")).click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (selenium.isElementPresent("//span[@class='autogrow-textarea']/div[contains(.,'10438177')])"))
			{
				System.out.println("Job ID is same in Asana");
			}
			
			/*
			String text = getWebDriver().findElement(By.id("details_property_sheet_title")).getText();
			System.out.println(text);
			String[] words1 = text.split(" ");
			for (int j = 0; j < words1.length; j++) 
			{
				System.out.println(words1[j]);
				if (a.equals(words1[j]))
				{
					System.out.println ("Job ID is Same");
					break;
				}
			}
			*/
		}
		
	}
}
