package com.actitime.timetrackerobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnterTimeTrackObjects {
	
	@FindBy(xpath="//select[@name='usersSelector.selectedUser']")
	public WebElement enterTimeTrackerDropdown;
	
	//@FindBy(xpath="//a[text()='Create new tasks']")
	@FindBy(xpath="//img[@src='/img/default/add_new_tasks.gif?hash=1692528820']")
	public WebElement createNewtaskLink;
	
	@FindBy(name="customerId")
	public WebElement customerDropdown;
	
	@FindBy(name="projectId")
	public WebElement projectDropdown;
	
	@FindBy(name="task[0].name")
	public WebElement taskNameTextbox;
	
	@FindBy(name="task[0].deadline")
	public WebElement deadlineTextbox;
	
	@FindBy(name="task[0].billingType")
	public WebElement billingTypeDropdown;
	
	@FindBy(xpath="//input[@value='Create Tasks']")   //input[@type='button' and @value='Create Tasks']")
	public WebElement createTaskButton;
	
}
