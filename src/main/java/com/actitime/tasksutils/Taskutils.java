package com.actitime.tasksutils;

import org.openqa.selenium.support.PageFactory;

import com.automation.base.BaseClass;
import com.automation.utils.SeleniumCore;
import com.automation.utils.SeleniumUtils;

public class Taskutils extends BaseClass{
	
	public SeleniumCore seleniumcore;
	public SeleniumUtils seleniumutils;

	public Taskutils() {
		seleniumcore=PageFactory.initElements(driver, SeleniumCore.class);
		seleniumutils=PageFactory.initElements(driver, SeleniumUtils.class);
	}

}
