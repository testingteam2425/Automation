package com.actitime.usersscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.actitime.loginlogoututils.LoginLogoutUtils;
import com.actitime.usersutils.UserListUtils;
import com.automation.base.BaseClass;

public class UserListScripts extends BaseClass{
	
	public LoginLogoutUtils loginlogoutUtils;
	public UserListUtils userListUtils;
	
	@BeforeClass
	public void loading() {
		loginlogoutUtils=PageFactory.initElements(driver,LoginLogoutUtils.class );
		userListUtils=PageFactory.initElements(driver,UserListUtils.class );
	}


	@Test
	public void loginPage() throws Exception {	
		loginlogoutUtils.applicationLogin("admin", "manager");
		Thread.sleep(5000);
		userListUtils.clickOnUsersMenu();
		userListUtils.clickOnCreateNewUser();
		userListUtils.enterLoginInformation("harshita", "", "harshita25", "harshita25");
		userListUtils.enterContactInformation("harshita", "boppay");
		userListUtils.clickOnCreateUserButton();
	}
	
	

	
}
