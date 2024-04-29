package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClassNew;
import com.constant.Constant;
import com.elementrepo.LoginPage;
import com.elementrepo.WorkersPage;

public class NewTestCases extends BaseClassNew{
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
}
