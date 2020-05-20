package com.actitime.loginlogoutscrips;

import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.actitime.loginlogoututils.LoginLogoutUtils;
import com.automation.base.BaseClass;
import com.automation.utils.ExcelReader;

public class LoginLogoutScripts extends BaseClass{

	public LoginLogoutUtils loginlogoutUtils;
	public static ExcelReader reader = ExcelReader.getInstance(currentDir+"\\src\\main\\resources\\TestDataFiles\\TestDataSheet.xls");
	Map<String, String> testdata;
 
	@BeforeClass
	public void loading() {
		loginlogoutUtils=PageFactory.initElements(driver,LoginLogoutUtils.class );
		testdata=reader.getRowValue("ValidCredentilas", "ApplicationLogin");
	}
	
	@Test
	public void loginPage() throws Exception {
		String username = testdata.get("username");
		String password = testdata.get("password");
		loginlogoutUtils.applicationLogin(username, password);
		
	}

	
}
