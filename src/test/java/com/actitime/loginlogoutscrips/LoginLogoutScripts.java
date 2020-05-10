package com.actitime.loginlogoutscrips;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.actitime.loginlogoututils.LoginLogoutUtils;
import com.automation.base.BaseClass;

public class LoginLogoutScripts extends BaseClass{
	
	LoginLogoutUtils loginlogoututil;
	
	@Test
	public void logintest() throws IOException, InterruptedException
	{
		initbrowser();
		Thread.sleep(3000);
		loginlogoututil.login("GOVIND","RAJA");
		
		
	}
	

	@BeforeClass
	public void loading()
	{
		loginlogoututil = new LoginLogoutUtils();
	}
	
	
	
	
}
