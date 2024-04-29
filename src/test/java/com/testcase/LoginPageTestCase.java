package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClassConst;
import com.constant.Constant;
import com.elementrepo.HomePage;
import com.elementrepo.LoginPage;

public class LoginPageTestCase extends BaseClassConst {

	@Test
	public void verifyLoginWithValidUser() {  //-->failed the login take screenshot and stored
		LoginPage loginPage = new LoginPage(driver);
		loginPage.inputUserName("carol");
		loginPage.inputPassword("1q2w3e4r");
		loginPage.clickLoginBtn();

		HomePage homePage = new HomePage(driver);
		String actual = homePage.verifyLoginUser();
		String expected = "CAROL THOMAS";

		Assert.assertEquals(actual, expected,Constant.errorMessageForFailedLogin);

	}

}
