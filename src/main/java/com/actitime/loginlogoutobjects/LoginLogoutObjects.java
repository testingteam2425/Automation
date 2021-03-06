package com.actitime.loginlogoutobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLogoutObjects {

	@FindBy(name="username")
	public WebElement username;

	@FindBy(name="pwd") 
	public WebElement password;

	@FindBy(id="loginButton")
	public WebElement loginbutton;

}
