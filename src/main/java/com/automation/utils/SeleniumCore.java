package com.automation.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.automation.base.BaseClass;


public class SeleniumCore extends BaseClass{

	
	public void enterText(WebElement locator,String value) {
		locator.sendKeys(value);

	}
	public void clickOnElement(WebElement locator) {
		locator.click();
	}

	public void SelectVisibleText(WebElement locator,String visibleText) {
		Select select=new Select(locator);
		select.selectByVisibleText(visibleText);
	}

}


