package com.actitime.usersscripts;

import java.util.Map;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.actitime.loginlogoututils.LoginLogoutUtils;
import com.actitime.usersutils.UserListUtils;
import com.automation.base.BaseClass;
import com.automation.utils.ExcelReader;

public class UserListScripts extends BaseClass{
	
	public LoginLogoutUtils loginlogoutUtils;
	public UserListUtils userListUtils;
	public static ExcelReader reader = ExcelReader.getInstance(currentDir+"\\src\\main\\resources\\TestDataFiles\\TestDataSheet.xls");
	Map<String, String> applicationLoginSheet;
	Map<String, String> userListSheet;
	String updatedUsername;
	String newUserName;
	
	@BeforeClass
	public void loading() {
		loginlogoutUtils=PageFactory.initElements(driver,LoginLogoutUtils.class );
		userListUtils=PageFactory.initElements(driver,UserListUtils.class );
	}


	@Test(priority=1)
	public void createUser() throws Exception {	
		
		/*
		 * Data coming from ApplicationLogin sheet
		 */
		applicationLoginSheet=reader.getRowValue("ValidCredentials", "ApplicationLogin");
		String username = applicationLoginSheet.get("username");
		String password = applicationLoginSheet.get("password");
		
		/*
		 * Data coming from UserList sheet 
		 */
		userListSheet=reader.getRowValue("CreateNewUser", "UserList");
		newUserName = userListSheet.get("NewUserName")+getCurrentTimeStamp();
		String newPassWord = userListSheet.get("NewPassword");
		String newReTypepassWord = userListSheet.get("NewReTypepassWord");
		String firstName = userListSheet.get("FirstName")+getCurrentTimeStamp();
		String lastName = userListSheet.get("LastName")+getCurrentTimeStamp();
		
		/*
		 * Enter Username and Password with valid data
		 */
		loginlogoutUtils.applicationLogin(username, password);
		Thread.sleep(5000);
		
		/*
		 * Creating newUser with new data
		 */
		userListUtils.clickOnUsersMenu();
		userListUtils.clickOnCreateNewUser();
		userListUtils.enterLoginInformation(newUserName, "", newPassWord, newReTypepassWord);
		userListUtils.enterContactInformation(firstName, lastName);
		userListUtils.clickOnCreateUserButton();
		Thread.sleep(5000);
		userListUtils.clickOnLogoutButton();		
	}
	
	@Test(priority=2)
	public void readUser() throws Exception {	
		
		/*
		 * Data coming from ApplicationLogin sheet
		 */
		applicationLoginSheet=reader.getRowValue("ValidCredentials", "ApplicationLogin");
		String username = applicationLoginSheet.get("username");
		String password = applicationLoginSheet.get("password");
		
		/*
		 * Data coming from UserList sheet 
		 */
		userListSheet=reader.getRowValue("CreateNewUser", "UserList");
		String firstName = userListSheet.get("FirstName")+getCurrentTimeStamp();
		String lastName = userListSheet.get("LastName")+getCurrentTimeStamp();
		
		/*
		 * Enter Username and Password with valid data
		 */
		loginlogoutUtils.applicationLogin(username, password);
		Thread.sleep(5000);
		
		/*
		 * Creating newUser with new data
		 */
		userListUtils.clickOnUsersMenu();
		userListUtils.clickOnTableLink(newUserName);
		userListUtils.verifyCreatedUserDetails(newUserName, firstName, lastName);
		Thread.sleep(5000);
		userListUtils.clickOnLogoutButton();			
	}
	
	@Test(priority=3)
	public void updateUser() throws Exception {	
		
		/*
		 * Data coming from ApplicationLogin sheet
		 */
		applicationLoginSheet=reader.getRowValue("ValidCredentials", "ApplicationLogin");
		String username = applicationLoginSheet.get("username");
		String password = applicationLoginSheet.get("password");
		
		/*
		 * Data coming from UserList sheet 
		 */
		userListSheet=reader.getRowValue("CreateNewUser", "UserList");
		String newPassWord = userListSheet.get("NewPassword");
		String newReTypepassWord = userListSheet.get("NewReTypepassWord");
		String firstName = userListSheet.get("FirstName")+getCurrentTimeStamp();
		String lastName = userListSheet.get("LastName")+getCurrentTimeStamp();
		updatedUsername = "auto"+userListSheet.get("NewUserName");
		
		/*
		 * Enter Username and Password with valid data
		 */
		loginlogoutUtils.applicationLogin(username, password);
		Thread.sleep(5000);
		
		/*
		 * Creating newUser with new data
		 */
		userListUtils.clickOnUsersMenu();
		userListUtils.clickOnTableLink(newUserName);
		userListUtils.enterLoginInformation(updatedUsername, "", newPassWord, newReTypepassWord);
		userListUtils.enterContactInformation("update"+firstName,"update"+lastName);
		userListUtils.clickOnSavechangesButton();
		Thread.sleep(5000);
		userListUtils.clickOnLogoutButton();
	}
	
	@Test(priority=4)
	public void deleteUser() throws Exception {	
		
		/*
		 * Data coming from ApplicationLogin sheet
		 */
		applicationLoginSheet=reader.getRowValue("ValidCredentials", "ApplicationLogin");
		String username = applicationLoginSheet.get("username");
		String password = applicationLoginSheet.get("password");
		
		/*
		 * Data coming from UserList sheet 
		 */
		userListSheet=reader.getRowValue("CreateNewUser", "UserList");
		
		
		/*
		 * Enter Username and Password with valid data
		 */
		loginlogoutUtils.applicationLogin(username, password);
		Thread.sleep(5000);
		
		/*
		 * Creating newUser with new data
		 */
		userListUtils.clickOnUsersMenu();
		userListUtils.clickOnTableLink(updatedUsername);
		userListUtils.clickOnDeleteuserButton();
		
	}
	
}
