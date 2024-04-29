package com.elementrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilites.GeneralUtilites;

public class WorkersPage {
	WebDriver driver;

	GeneralUtilites generalUtilities = new GeneralUtilites();

	public WorkersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Workers']")
	WebElement workersBtn;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement searchText;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement resetBtn;

	@FindBy(xpath = "//a[text()='Create Worker']")
	WebElement createWorkerTab;

	@FindBy(xpath = "//select[@id='worker-title']")
	WebElement titleText;

	@FindBy(xpath = "//a[@title='Delete']")
	WebElement deleteBtn;

	public void clickWorkersBtn() {
		workersBtn.click();
	}

	public String workersSearchText() {
		return generalUtilities.getTextOfAnElement(searchText);
	}

	public String BgColorOfResetBtn() {
		String bgColor = resetBtn.getCssValue("background-color");
		return bgColor;
	}

	public void clickonCreateWorkers() {
		createWorkerTab.click();
	}
	
	public void clickonTitleText() {
		titleText.click();
	}

	public String titleDropDown() {
		return generalUtilities.getTextForAnElementFromDropDown(titleText, 3);
	}

	public String deleteToolTipValue() {

		return generalUtilities.getAttributeValue(deleteBtn, "title");

	}

}
