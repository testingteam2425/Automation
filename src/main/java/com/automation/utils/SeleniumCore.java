package com.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.automation.base.BaseClass;


public class SeleniumCore extends BaseClass{

	public void enterText(String locator,String value) {
		driver.findElement(By.xpath(locator)).sendKeys(value);	

	}
	
	public void enterText(String locatortype,String locator,String value) {
		driver.findElement(By.xpath(locator)).sendKeys(value);	

	}
	
	public void clickOnElement(String locator) {
		driver.findElement(By.xpath(locator)).click();
	}

	public void SelectVisibleText(String locator,String visibleText) {
		WebElement element=driver.findElement(By.xpath(locator));
		Select select=new Select(element);
		select.selectByVisibleText(visibleText);
	}

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


