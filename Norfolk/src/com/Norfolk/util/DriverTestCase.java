package com.Norfolk.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.Norfolk.pagehelper.LoginHelper;
import com.thoughtworks.selenium.Selenium;

public abstract class DriverTestCase {

	enum DriverType {
		Firefox, IE, Chrome, Saucelab
	}

	// Define objects
	private WebDriver driver;
	//private WebDriver RemoteWebDriver;
	private Selenium selenium;
	protected LoginHelper loginHelper;
	//protected HeaderHelper headerHelper;
	//protected EditColumnHelper editColumn;

	// Initialize objects
	protected PropertyReader propertyReader = new PropertyReader();

	// Define variables
	protected String applicationUrl = propertyReader
			.readApplicationFile("URLFront");

	@BeforeClass
	public void setUp() {
		String driverType = propertyReader.readApplicationFile("BROWSER");

		if (DriverType.Firefox.toString().equals(driverType)) {
			driver = new FirefoxDriver();
			// Maximize window
			driver.manage().window().maximize();
			// Delete cookies
			driver.manage().deleteAllCookies();
		} else if (DriverType.IE.toString().equals(driverType)) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new InternetExplorerDriver(capabilities);
			// Maximize window
			driver.manage().window().maximize();
			// Delete cookies
			driver.manage().deleteAllCookies();
		} else if (DriverType.Chrome.toString().equals(driverType)) {
			String ChromeType = propertyReader
					.readApplicationFile("ChromeExePath");
			System.setProperty("webdriver.chrome.driver", ChromeType);
			driver = new ChromeDriver();
			// Maximize window
			driver.manage().window().maximize();
			// Delete cookies
			driver.manage().deleteAllCookies();
		} else if (DriverType.Saucelab.toString().equals(driverType)) {
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("version", "25");
			capabilities.setCapability("platform", Platform.WIN8);
			capabilities.setCapability ("name", "TranslationJob");
			try {
				driver = new RemoteWebDriver(new URL("http://darianhickman:a68dc30e-133a-4d5f-935f-d8de46bf2a78@ondemand.saucelabs.com:80/wd/hub"),capabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			driver = new FirefoxDriver();
			// Maximize window
			driver.manage().window().maximize();
			// Delete cookies
			driver.manage().deleteAllCookies();
		}
	}

	@AfterClass
	public void afterMainMethod() {
		driver.quit();
	}

	// login to the application
	public void login(String userType) {

		loginHelper = new LoginHelper(this.getWebDriver());

		String userName = propertyReader
				.readApplicationFile(userType + "_User");
		String password = propertyReader.readApplicationFile(userType
				+ "_Password");
		loginHelper.enterEmail(userName);
		loginHelper.enterPassword(password);
		loginHelper.clickSignin();

	}

	// log out from application
	public void logOut() {
		//headerHelper = new HeaderHelper(getWebDriver());
		//headerHelper.clickLogout();
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public Selenium getSelenium() {
		return selenium;
	}

	// Handle child windows
	public String switchPreviewWindow() {
		Set<String> windows = getWebDriver().getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parent = iter.next();
		getWebDriver().switchTo().window(iter.next());
		return parent;
	}

	// Get random integer
	public int getRandomInteger(int aStart, int aEnd) {
		Random aRandom = new Random();
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		// get the range, casting to long to avoid overflow problems
		long range = (long) aEnd - (long) aStart + 1;
		// compute a fraction of the range, 0 <= frac < range
		long fraction = (long) (range * aRandom.nextDouble());
		int randomNumber = (int) (fraction + aStart);
		return randomNumber;
	}

	// Get random string
	public String randomString(int len) {
		String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

	// Get absolute path
	public String getPath() {
		String path = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
		return path;
	}

	// Get absolute path
	public String getPathUpload() {
		String path = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("/", "//");
		return path;
	}

	// Switch frame
	public void switchFrame(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			getWebDriver().switchTo().frame(arr[i]);
		}
	}
}
