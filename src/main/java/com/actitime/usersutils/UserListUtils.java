package com.actitime.usersutils;

import org.openqa.selenium.support.PageFactory;

import com.actitime.usersobjects.UserListObjects;
import com.automation.base.BaseClass;
import com.automation.utils.SeleniumCore;
import com.automation.utils.SeleniumUtils;

public class UserListUtils extends BaseClass{

	public SeleniumCore seleniumcore;
	public SeleniumUtils seleniumutils;
	public UserListObjects userListObjects;

	public UserListUtils() {
		seleniumcore=PageFactory.initElements(driver, SeleniumCore.class);
		seleniumutils=PageFactory.initElements(driver, SeleniumUtils.class);
		userListObjects=PageFactory.initElements(driver, UserListObjects.class);
	}

	public void clickOnUsersMenu() {
	//	seleniumcore.clickOnElement(userListObjects.usersmenu);
		seleniumutils.javascriptclickmethod(userListObjects.usersmenu);
	}
	
	public void clickOnCreateNewUser() {
		seleniumcore.clickOnElement(userListObjects.createNewUser);
	}

	public void enterLoginInformation(String username, String access, String password, String retypepassword) {
		seleniumcore.enterText(userListObjects.username, username);
		seleniumcore.enterText(userListObjects.password, password);
		seleniumcore.enterText(userListObjects.retypepassword, retypepassword);
	}
	
	public void enterContactInformation(String firstname, String lastname) {
		seleniumcore.enterText(userListObjects.firstname, firstname);
		seleniumcore.enterText(userListObjects.lastname, lastname);
	}
	
	public void clickOnCreateUserButton() {
		seleniumcore.clickOnElement(userListObjects.createuserbutton);
	}

}
