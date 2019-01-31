package com.actitime.tasksobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskObjects {

	@FindBy(xpath="//a//div[text()='TASKS']")
	public WebElement HeaderTasks;

	@FindBy(xpath="//div[text()='Add New Task']")
	public WebElement AddNewTaskButton;

	@FindBy(xpath="//div[text()='Create new tasks']")
	public WebElement AddNwTsk;
	

	@FindBy(xpath="(//em[@unselectable='on'])[1]")
    public WebElement ChkBx;
		


}
