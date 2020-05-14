package com.actitime.timetrackerscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.actitime.loginlogoututils.LoginLogoutUtils;
import com.actitime.timetrackerutils.EnterTimeTrackUtils;
import com.automation.base.BaseClass;

public class EnterTimeTrackScripts extends BaseClass{
	
	public LoginLogoutUtils loginlogoutUtils;
	public EnterTimeTrackUtils enterTimeTrackUtils;

	
	@BeforeClass
	public void loading() {
		loginlogoutUtils=PageFactory.initElements(driver,LoginLogoutUtils.class );
		enterTimeTrackUtils=PageFactory.initElements(driver,EnterTimeTrackUtils.class );
	}


	@Test 
	public void enterTimeTrackDetails() throws Exception {
		loginlogoutUtils.applicationLogin("admin", "manager");
		enterTimeTrackUtils.selectValueEnterTimeTrackerDropdown("harshita");
		enterTimeTrackUtils.clickOnCreateNewTask();
		enterTimeTrackUtils.selectCustomerAndProjectDropdown("harshita", "actitime");
		enterTimeTrackUtils.enterFillIntaskInformation("harshita", "may 20, 2020", "");
		enterTimeTrackUtils.clickOnCreateTaskButton();

	}
	

}
