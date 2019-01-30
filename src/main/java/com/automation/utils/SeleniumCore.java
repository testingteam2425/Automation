package com.automation.utils;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.automation.base.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class SeleniumCore extends BaseClass{

	Logger logger = Logger.getLogger(SeleniumCore.class);

	/* 
	 * Enter text in text box 
	 */
	public void enterTextBoxValue(WebElement element, String value) throws Exception {
		try {
			element.clear();
			element.sendKeys(value);
			logger.info("Enter value is :::: "+value);
			testReportChild.log(LogStatus.PASS, "Entering Value "+value, value+" Entered successfully");
		}catch (Exception e) {
			logStatusFail("Entering Value "+value,getScreenshot("Error while entering value "));
		}
	}

	/*
	 * Click on element 
	 */
	public void clickonElement(WebElement element, String elementName) throws IOException {
		try {
			element.click();
			logger.info(elementName+ " element is  cliecked sucessfully....... ");
			logStatusPass("Clicking on "+elementName, elementName+" Clicked Successfully");
		} catch (Exception e) {
			logStatusFail("Clicking on "+elementName,getScreenshot("Error  While clicking on "+elementName));
		}
	}
	

}