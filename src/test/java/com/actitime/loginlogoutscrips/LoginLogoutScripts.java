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
	Map<String, String> testdata1;
 
	@BeforeClass
	public void loading() {
		loginlogoutUtils=PageFactory.initElements(driver,LoginLogoutUtils.class );
		testdata=reader.getRowValue("ValidCredentials", "ApplicationLogin");
		testdata1=reader.getRowValue("InvalidCredentials", "ApplicationLogin");
	}
	
	@Test
	public void loginPage() throws Exception {
		String username = testdata.get("username");
		String password = testdata.get("password");
		loginlogoutUtils.applicationLogin(username, password);
		
	}
	
	@Test
	public void inValidPasswordWithLogin() throws Exception {
		String username = testdata.get("username");
		String password = testdata1.get("password");
		loginlogoutUtils.applicationLogin(username, password);
		
	}
	
	@Test
	public void inValidUsernameWithLogin() throws Exception {
		String username = testdata1.get("username");
		String password = testdata.get("password");
		loginlogoutUtils.applicationLogin(username, password);
		
	}

	
}
