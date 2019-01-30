package com.actitime.usersutils;

import org.openqa.selenium.support.PageFactory;

import com.automation.base.BaseClass;
import com.automation.utils.SeleniumCore;
import com.automation.utils.SeleniumUtils;

public class UserListUtils extends BaseClass{
	
	public SeleniumCore seleniumcore;
	public SeleniumUtils seleniumutils;

	public UserListUtils() {
		seleniumcore=PageFactory.initElements(driver, SeleniumCore.class);
		seleniumutils=PageFactory.initElements(driver, SeleniumUtils.class);
	}

}
