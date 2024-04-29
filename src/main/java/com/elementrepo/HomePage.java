package com.elementrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilites.GeneralUtilites;

public class HomePage {
	
	WebDriver driver;
	
	GeneralUtilites generalUtilities=new GeneralUtilites();
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement loginUser;

	public String verifyLoginUser() {
		return generalUtilities.getTextOfAnElement(loginUser);
	}
}
