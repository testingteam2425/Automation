package com.actitime.reportsutils;

import org.openqa.selenium.support.PageFactory;

import com.automation.base.BaseClass;
import com.automation.utils.SeleniumCore;
import com.automation.utils.SeleniumUtils;

public class ReportsDashboardUtils extends BaseClass{
	
	public SeleniumCore seleniumcore;
	public SeleniumUtils seleniumutils;

	public ReportsDashboardUtils() {
		seleniumcore=PageFactory.initElements(driver, SeleniumCore.class);
		seleniumutils=PageFactory.initElements(driver, SeleniumUtils.class);
	}

}
