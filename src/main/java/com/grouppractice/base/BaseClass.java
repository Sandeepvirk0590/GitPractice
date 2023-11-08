package com.grouppractice.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeClass;
//
//import com.naveenautomation.Utils.WebdriverEvents;
import com.grouppractice.base.Browsers;
//import com.naveenautomation.base.ManageOptions;
//import com.naveenautomation.base.NavigationBarOnEveryPage;
//import com.naveenautomation.base.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver wd;

	private final Browsers BROWSER = Browsers.CHROME;
	private final String URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";

//	public static Logger logger;
//	public WebdriverEvents events;
	public EventFiringWebDriver e_driver;

	private static final boolean RUN_ON_GRID = true;


	public void intialisation() {

	
			switch (BROWSER.getBrowserName()) {
			case "CHROME":
				wd = WebDriverManager.chromedriver().create();
				break;
			case "EDGE":
				wd = WebDriverManager.edgedriver().create();
				break;
			case "FIREFOX":
				wd = WebDriverManager.firefoxdriver().create();
				break;
			default:
				throw new IllegalArgumentException();
			}
		

		// Wrap the instance
		e_driver = new EventFiringWebDriver(wd);

		// Events which need to be captured
//		events = new WebdriverEvents();
//		e_driver.register(events);

		// Assigning back the value to Web driver
		wd = e_driver;

		wd.get(URL);

		wd.manage().window().maximize();

		wd.manage().deleteAllCookies();

		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
//
//	public MutableCapabilities getOptions() {
//		return new ManageOptions().getOption(BROWSER);
//	}

//	public void sideNavBarMenu(NavigationBarOnEveryPage sideMenuSelected) {
//		List<WebElement> navBar = wd.findElements(By.cssSelector("#column-right>div>a"));
//
//		for (int i = 0; i < navBar.size(); i++) {
//			if (navBar.get(i).getText().toString().equals(sideMenuSelected.getSideBar())) {
//				navBar.get(i).click();
//				break;
//			}
//		}
//	}

	public void tearDown() {
		try {
			wd.quit();
		} catch (Exception e) {
			wd.quit();
		}
	}

	public static void failedTestScreenShot(String testMethodName) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		File screenShotFfile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenShotFfile,
					new File("./FailedTestCasesScreenShot\\" + "_" + testMethodName + "_" + timeStamp + ".jpg"));
		} catch (IOException e) {

			System.out.println("................................The IO Exception is ...... " + e);
			e.printStackTrace();
		}

	}

}
