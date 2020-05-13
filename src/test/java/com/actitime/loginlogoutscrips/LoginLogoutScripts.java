package com.actitime.loginlogoutscrips;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.actitime.loginlogoututils.LoginLogoutUtils;
import com.automation.base.BaseClass;

public class LoginLogoutScripts extends BaseClass{

	public LoginLogoutUtils loginlogoutUtils;


	@Test
	
	public void loginPage() throws Exception {
		
		loginlogoutUtils.applicationLogin("admin", "manager");

	}

	@BeforeClass
	public void loading() {
		loginlogoutUtils=PageFactory.initElements(driver,LoginLogoutUtils.class );

	}
}
