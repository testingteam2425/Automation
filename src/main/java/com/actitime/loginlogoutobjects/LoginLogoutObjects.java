package com.actitime.loginlogoutobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLogoutObjects {
	
	@FindBy(name="username")
	public WebElement username;
	
	@FindBy(name="pwd")
	public WebElement password;
	
	@FindBy(id="loginButton")
	public WebElement loginButton;
	
	@FindBy(id="Dashboard")
	public WebElement homepage;
	
	@FindBy(id="")
	public WebElement logoutButton;
	
	@FindBy(id="")
	public WebElement forgetPassword;
	
	@FindBy(id="")
	public WebElement VerifyHeader;
	
	@FindBy(xpath="//span[text()='Username or Password is invalid. Please try again.']")
	public WebElement errormessgae;
	
	@FindBy(id="")
	public WebElement VerifyFooter;

}
