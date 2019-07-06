package com.actitime.loginlogoututils;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.actitime.loginlogoutobjects.LoginLogoutObjects;
import com.automation.base.BaseClass;
import com.automation.utils.SeleniumCore;

public class LoginLogoutUtils extends BaseClass{
	
	private SeleniumCore seleniumcore;
	private LoginLogoutObjects loginlogoutobjects;

	public LoginLogoutUtils() {
		seleniumcore=PageFactory.initElements(driver, SeleniumCore.class);
		loginlogoutobjects=PageFactory.initElements(driver, LoginLogoutObjects.class);
	}

	public void loginCredentials(String username,String password) throws Exception {
		seleniumcore.enterTextBoxValue(loginlogoutobjects.username, username);
		seleniumcore.enterTextBoxValue(loginlogoutobjects.password, password);
		seleniumcore.clickonElement(loginlogoutobjects.loginButton, "Login");
	}
	
	public void logoutApplication() throws IOException {
		seleniumcore.clickonElement(loginlogoutobjects.logoutButton, "Login");
	}
}
