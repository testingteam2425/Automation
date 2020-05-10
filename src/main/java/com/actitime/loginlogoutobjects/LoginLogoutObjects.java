package com.actitime.loginlogoutobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLogoutObjects {

	@FindBy(id="email")
	public WebElement username;

	@FindBy(xpath="//input[@name='pass']")
	public WebElement password;
	
	/*@FindBy(id="")
	public WebElement password1;*/

	@FindBy(id="loginButton")
	public WebElement loginbutton;
	
	
	
	/*@FindBy(xpath="")
	public WebElement titlename;
	
	@FindBy(xpath="")
	public WebElement sahitya;
	
	@FindBy(xpath="")
	public WebElement logoutbutton;*/
	
	}
