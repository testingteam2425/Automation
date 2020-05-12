package com.actitime.loginlogoututils;

import org.openqa.selenium.support.PageFactory;

import com.actitime.loginlogoutobjects.LoginLogoutObjects;
import com.automation.base.BaseClass;
import com.automation.utils.SeleniumCore;

public class LoginLogoutUtils extends BaseClass{

	public SeleniumCore seleniumCore;
	public LoginLogoutObjects loginLogoutObjects;

	public LoginLogoutUtils() {
		seleniumCore =PageFactory.initElements(driver, SeleniumCore.class);
		loginLogoutObjects=PageFactory.initElements(driver,LoginLogoutObjects.class );
		
	}


	public void applicationLogin(String username, String password) throws Exception {
		seleniumCore.enterText(loginLogoutObjects.username, username);
		Thread.sleep(3000);
		seleniumCore.enterText(loginLogoutObjects.password, password);
		seleniumCore.clickOnElement(loginLogoutObjects.loginbutton);


	}

}
