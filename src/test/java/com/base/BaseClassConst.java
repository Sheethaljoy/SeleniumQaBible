package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.utilites.CaptureScreenshotOnFailure;

public class BaseClassConst {
	public WebDriver driver;
	public static Properties prop; // Properties ->Java class used to handle complete property activities

	public static void testBasic() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/Config.properties");
		prop.load(ip);// load ->method used to read the data in key-value pair }
	}

	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String name) throws IOException {
		testBasic();
		driver=new ChromeDriver();
		driver.get(prop.getProperty("baseUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			CaptureScreenshotOnFailure capScreenshot = new CaptureScreenshotOnFailure();
			capScreenshot.captureScreenshotFailedTestCase(driver, iTestResult.getName());
		}
		driver.close();
	}

}
