package com.base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.utilites.CaptureScreenshotOnFailure;

public class BaseClass {
	public WebDriver driver;

	/*
	 * public static Properties prop; //Properties ->Java class used to handle
	 * complete property activities
	 * 
	 * public static void testBasic() throws IOException { prop = new Properties();
	 * //create property class object //FileInputStream -> java class used to read
	 * and write data in external files //System.getProperty("user.dir") ->used to
	 * automatically generate path of property FileInputStream ip = new
	 * FileInputStream(System.getProperty("user.dir") +
	 * "src//main//resources//Config.properties"); prop.load(ip);// load ->method
	 * used to read the data in key-value pair }
	 * 
	 * @BeforeMethod public void beforeMethod() throws IOException { testBasic();
	 * driver = new ChromeDriver(); driver.get(prop.getProperty("baseUrl"));
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); }
	 */
	@BeforeMethod
	public void beforeMethod() throws IOException {

		driver = new ChromeDriver();
		driver.get("https://www.qabible.in/payrollapp/site/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) // Listner -->
		{
			CaptureScreenshotOnFailure capScreenshot = new CaptureScreenshotOnFailure();
			capScreenshot.captureScreenshotFailedTestCase(driver, iTestResult.getName());
		}
		driver.close();
	}
}
