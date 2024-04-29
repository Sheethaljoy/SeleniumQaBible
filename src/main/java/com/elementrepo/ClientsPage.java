package com.elementrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilites.GeneralUtilites;

public class ClientsPage {
	WebDriver driver;

	GeneralUtilites generalUtilities = new GeneralUtilites();

	public ClientsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href='/payrollapp/client/index']")
	WebElement clientsBtn;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement searchText;
	
	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement resetBtn;
	
	@FindBy(xpath = "//a[text()='Create Client']") 
	WebElement createClientTab;
	
	@FindBy(xpath = "//a[@href='/payrollapp/client/view?id=1']")
			WebElement viewTab;
	
	public void clickClientsBtn() {
		clientsBtn.click();
	} 
	

}
