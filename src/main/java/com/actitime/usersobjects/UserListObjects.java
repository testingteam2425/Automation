package com.actitime.usersobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserListObjects {

	/*
	 * Header menu
	 */
	@FindBy(xpath="//div[text()='Users']")
	public WebElement usersmenu;

	/*
	 * User List Page
	 */
	@FindBy(xpath="//input[@value='Create New User']")
	public WebElement createNewUser;

	/*
	 * Login Information
	 */
	@FindBy(name="username")
	public WebElement username;

	@FindBy(name="passwordText")
	public WebElement password;

	@FindBy(name="passwordTextRetype")
	public WebElement retypepassword;

	@FindBy(name="active")
	public WebElement access;

	/*
	 * 	Contact Information
	 */
	@FindBy(name="firstName")
	public WebElement firstname;

	@FindBy(name="lastName")
	public WebElement lastname;

	/*
	 * 	Create User
	 */
	@FindBy(xpath="//input[@value='   Create User   ']")
	public WebElement createuserbutton;

}
