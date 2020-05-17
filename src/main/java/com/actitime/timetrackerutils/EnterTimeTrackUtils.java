package com.actitime.timetrackerutils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.PageFactory;

import com.actitime.timetrackerobjects.EnterTimeTrackObjects;
import com.automation.base.BaseClass;
import com.automation.utils.SeleniumCore;
import com.automation.utils.SeleniumUtils;

public class EnterTimeTrackUtils extends BaseClass{

	public SeleniumCore seleniumcore;
	public SeleniumUtils seleniumutils;
	public EnterTimeTrackObjects enterTimeTrackObjects;

	public EnterTimeTrackUtils() {
		seleniumcore=PageFactory.initElements(driver, SeleniumCore.class);
		seleniumutils=PageFactory.initElements(driver, SeleniumUtils.class);
		enterTimeTrackObjects=PageFactory.initElements(driver, EnterTimeTrackObjects.class);
	}

	public void selectValueEnterTimeTrackerDropdown(String value) {
		seleniumcore.SelectVisibleText(enterTimeTrackObjects.enterTimeTrackerDropdown, value); 
	}

	public void clickOnCreateNewTask() {
		seleniumcore.clickOnElement(enterTimeTrackObjects.createNewtaskLink);
	}

	public void enterFillIntaskInformation(String taskname, String deadlinevalue, String billingtype) {
		
		seleniumcore.enterText(enterTimeTrackObjects.taskNameTextbox, taskname);
		seleniumcore.enterText(enterTimeTrackObjects.deadlineTextbox, deadlinevalue);
		seleniumcore.SelectVisibleText(enterTimeTrackObjects.billingTypeDropdown, billingtype); 
	}

	public void selectCustomerAndProjectDropdown(String customerId, String projectId) {
		seleniumcore.SelectVisibleText(enterTimeTrackObjects.customerDropdown, customerId); 
		seleniumcore.SelectVisibleText(enterTimeTrackObjects.projectDropdown, projectId); 
	}

	public void clickOnCreateTaskButton() {
		//seleniumcore.clickOnElement(enterTimeTrackObjects.createTaskButton);
		seleniumutils.javascriptclickmethod(enterTimeTrackObjects.createTaskButton);
	}

	public void windowhandles()  {
		Set<String> allwindows = driver.getWindowHandles();
		Iterator<String> it = allwindows.iterator();
		String parent=it.next();
		String child=it.next();
		driver.switchTo().window(child);
	}
		
}	
