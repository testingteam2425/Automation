package com.actitime.loginlogoututils;

import com.actitime.loginlogoutobjects.LoginLogoutObjects;
import com.automation.base.BaseClass;
import com.automation.utils.SeleniumCore;

public class LoginLogoutUtils extends BaseClass{

	public SeleniumCore seleniumCore;
	public LoginLogoutObjects loginLogoutObjects;

	public LoginLogoutUtils() {
		seleniumCore=new SeleniumCore();
		loginLogoutObjects=new LoginLogoutObjects();
	}


	public void applicationLogin(String username, String password) {
		seleniumCore.enterText(loginLogoutObjects.username, username);
		seleniumCore.enterText(loginLogoutObjects.password, password);
		seleniumCore.clickOnElement(loginLogoutObjects.loginbutton);


	}

}
