package com.testcase;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseCrossBrowser;
import com.constant.Constant;
import com.elementrepo.LoginPage;
import com.elementrepo.WorkersPage;

public class CrossBrowser extends BaseCrossBrowser {

	@Test
	public void VerifyTextOfSearch() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.inputUserName("carol");
		loginPage.inputPassword("1q2w3e4r");
		loginPage.clickLoginBtn();

		WorkersPage workersSearch = new WorkersPage(driver);

		workersSearch.clickWorkersBtn();
		String actual = workersSearch.workersSearchText();
		String expected = "search";
		Assert.assertEquals(actual, expected, Constant.errorMessageForVerifyTextOfSearch);
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
		Assert.assertEquals(actual, expected, Constant.errorMessageForVerifyBgColorOfResetBtn);
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
		Assert.assertEquals(actualResult, expectedResult, Constant.errorMessageForVerifyValueInTitleDropdown);
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
		Assert.assertEquals(actual, expected, Constant.errorMessageForVerifyIncorrectUsernameandPassword);
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
		Assert.assertEquals(actual, expected, Constant.errorMessageForVerifyDeleteIconTooltip);
	}
}
