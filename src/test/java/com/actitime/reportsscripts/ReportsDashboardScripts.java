package com.actitime.reportsscripts;

import java.util.Map;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.actitime.loginlogoutscrips.LoginLogoutScripts;
import com.actitime.loginlogoututils.LoginLogoutUtils;
import com.automation.base.BaseClass;
import com.automation.utils.ExcelReader;
import com.automation.utils.SeleniumCore;
import com.automation.utils.SeleniumUtils;

public class ReportsDashboardScripts extends BaseClass{
	
	public SeleniumCore seleniumcore;
	public SeleniumUtils seleniumutils;
	public LoginLogoutUtils loginlogoutUtils;
	public static ExcelReader reader=ExcelReader.getInstance(currDir+"/src/main/resources/TestDataFiles/TestDataSheet.xls");
    Map<String, String> testdata;
    Logger logger = Logger.getLogger(LoginLogoutScripts.class);
	
	@BeforeClass
	public void loadObjectClasses() {
		seleniumcore=PageFactory.initElements(driver, SeleniumCore.class);
		seleniumutils=PageFactory.initElements(driver, SeleniumUtils.class);
		loginlogoutUtils=PageFactory.initElements(driver, LoginLogoutUtils.class);
		PropertyConfigurator.configure(currDir+"/src/main/resources/config/log4j.properties");
		BasicConfigurator.configure();
		testReportparent = extent.startTest("User List","Validate User List page");
	}
	
	@Test()
	public void userlist() throws Exception {
		createChildTest("userList ", " ");
		testdata=reader.getRowValue("ValidCredentilas", "ApplicationLogin");
		loginlogoutUtils.loginCredentials(testdata.get("username"), testdata.get("password"));
		appendChildTest();
	}
	

}
