package com.actitime.loginlogoututils;

import com.actitime.loginlogoutobjects.LoginLogoutObjects;
import com.automation.base.BaseClass;
import com.automation.utils.SeleniumCore;

public class LoginLogoutUtils extends BaseClass {

	public SeleniumCore score;
	public LoginLogoutObjects loginlogoutobj;

	
	public LoginLogoutUtils()
	{
		score = new SeleniumCore();
		loginlogoutobj = new LoginLogoutObjects();
		
	}
	
	
	
	public void login(String uuname, String ppwd) {
			score.entertext(loginlogoutobj.username, uuname);
		score.entertext(loginlogoutobj.password, ppwd);
		score.clickonelement(loginlogoutobj.loginbutton);
	
	}
		
		

	}

	

	
	
	
	
	
	
	

