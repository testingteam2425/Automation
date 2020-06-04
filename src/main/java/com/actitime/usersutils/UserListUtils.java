package com.actitime.usersutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

	public void clickOnTableLink(String user) {
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'"+user+"')]"));
		seleniumcore.clickOnElement(element);
	}

	public void clickOnSavechangesButton() {
		seleniumcore.clickOnElement(userListObjects.Savechangesbutton);
	}
	
	public void clickOnDeleteuserButton() {
		seleniumcore.clickOnElement(userListObjects.Deleteuserbutton);
	}
	
	
	public void verifyCreatedUserDetails(String username,String firstname,String lastname) {
		String fetchUsername = userListObjects.username.getAttribute("value");
		if (fetchUsername.equalsIgnoreCase(username)) {
			System.out.println(fetchUsername+" and "+username+" both is same ");
		} else {
			System.out.println(fetchUsername+" and "+username+" both is not same ");
		}
		
		
		String fetchFirstname = userListObjects.firstname.getAttribute("value");
		if (fetchFirstname.equalsIgnoreCase(firstname)) {
			System.out.println(fetchFirstname+" and "+firstname+" both is same ");
		} else {
			System.out.println(fetchFirstname+" and "+firstname+" both is not same ");
		}
		
		
		String fetchLastname = userListObjects.lastname.getAttribute("value");
		if (fetchLastname.equalsIgnoreCase(lastname)) {
			System.out.println(fetchLastname+" and "+lastname+" both is same ");
		} else {
			System.out.println(fetchLastname+" and "+lastname+" both is not same ");
		}
	}
}
