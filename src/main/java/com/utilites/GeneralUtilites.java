package com.utilites;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilites {
	public String getTextOfAnElement(WebElement element) {
		String text =element.getText();
		return text;
	}
	public String getTextForAnElementFromDropDown(WebElement element,int value) {
		Select titleDropDown=new Select(element);
		titleDropDown.selectByIndex(value);
		String currentTitle =titleDropDown.getFirstSelectedOption().getText();
		return currentTitle;
	}
	public String getAttributeValue(WebElement element,String attribute) {
		String attributeValue =element.getAttribute(attribute);
		return attributeValue;
	}
}
