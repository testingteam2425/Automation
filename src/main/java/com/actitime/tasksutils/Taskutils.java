package com.actitime.tasksutils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.actitime.tasksobjects.TaskObjects;
import com.automation.base.BaseClass;
import com.automation.utils.SeleniumCore;
import com.automation.utils.SeleniumUtils;

public class Taskutils extends BaseClass {

	public SeleniumCore seleniumcore;
	public SeleniumUtils seleniumutils;

	public TaskObjects tasksobjects;

	public Taskutils() {
		seleniumcore = PageFactory.initElements(driver, SeleniumCore.class);
		seleniumutils = PageFactory.initElements(driver, SeleniumUtils.class);
		tasksobjects = PageFactory.initElements(driver, TaskObjects.class);

	}

	public void tasksInput() throws Exception {
		/*
		 * seleniumcore.enterText(tasksobjects.USERXPATH,username);
		 * seleniumcore.enterText(tasksobjects.PASSXPATH,passwd);
		 * seleniumcore.getClick(tasksobjects.LOGINBTN);
		 */
		seleniumcore.elementNotClickable(tasksobjects.HeaderTasks);
		seleniumcore.clickonElement(tasksobjects.AddNewTaskButton, "clicking the button");
		seleniumcore.clickonElement(tasksobjects.AddNwTsk, "clicking new task");
		seleniumcore.clickonElement(tasksobjects.ChkBx, "clicking checjbox");

	}

}
