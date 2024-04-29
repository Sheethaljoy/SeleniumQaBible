package com.testcase;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.elementrepo.LoginPage;
import com.elementrepo.WorkersPage;

public class AssignmentTestCase extends BaseClass {

	@Test
	public void VerifyTextOfSearch() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.inputUserName("carol");
		loginPage.inputPassword("1q2w3e4r");
		loginPage.clickLoginBtn();

		WorkersPage workersSearch = new WorkersPage(driver);

		workersSearch.clickWorkersBtn();
		String actual = workersSearch.workersSearchText();
		String expected = "Search";
		Assert.assertEquals(actual, expected, "Verification of search button text is failed");
	}

	@Test
	public void verifyBgColorOfResetBtn() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.inputUserName("carol");
		loginPage.inputPassword("1q2w3e4r");
		loginPage.clickLoginBtn();

		WorkersPage workersPage = new WorkersPage(driver);

		workersPage.clickWorkersBtn();
		String bgColor = workersPage.BgColorOfResetBtn();
		String actual = Color.fromString(bgColor).asHex();
		String expected = "#ffffff";
		Assert.assertEquals(actual, expected, "Verification of Reset Button background color is failed");
	}
	
	@Test
	public void verifyValueInTitleDropdown() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.inputUserName("carol");
		loginPage.inputPassword("1q2w3e4r");
		loginPage.clickLoginBtn();

		WorkersPage workersPage = new WorkersPage(driver);

		workersPage.clickWorkersBtn();
		workersPage.clickonCreateWorkers();
		workersPage.clickonTitleText();

		String actualResult = workersPage.titleDropDown();
		String expectedResult = "Mrs";
		Assert.assertEquals(actualResult, expectedResult, "Failed, selected value doesn't match expected");
	}
	
	@Test
	public void verifyIncorrectUsernameandPassword() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.inputUserName("carol");
		loginPage.inputPassword("1q2w3e4rsf");
		loginPage.clickLoginBtn();

		loginPage.clickLoginBtn();

		String actual = driver.getCurrentUrl();
		String expected = "https://www.qabible.in/payrollapp/site/login";
		Assert.assertEquals(actual, expected, "Verification failed,Incorrect username or password.");
	}
	
	@Test
	public void verifyDeleteIconTooltip() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.inputUserName("carol");
		loginPage.inputPassword("1q2w3e4r");
		loginPage.clickLoginBtn();

		WorkersPage workersPage = new WorkersPage(driver);
		workersPage.clickWorkersBtn();
		workersPage.deleteToolTipValue();
		String actual = workersPage.deleteToolTipValue();
		String expected = "Delete";
		Assert.assertEquals(actual, expected, "Verification failed,Tooltip value is incorrect");
}
}
