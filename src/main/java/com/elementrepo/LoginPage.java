package com.elementrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "loginform-username")
	WebElement username;

	@FindBy(id = "loginform-password")
	WebElement password;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement loginbtn;

	public void inputUserName(String name) {
		username.sendKeys(name);

	}

	public void inputPassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickLoginBtn() {
		loginbtn.click();
	}

}
