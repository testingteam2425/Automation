package com.actitime.timetrackerobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnterTimeTrackObjects {
	
	
	
	@FindBy(name="usersSelector.selectedUser")
	public WebElement enterTimeTrackerDropdown;
	
	@FindBy(xpath="//a[text()='Create new tasks']")
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
	
	@FindBy(xpath="//input[@value='Create Tasks']")
	public WebElement createTaskButton;
	
	
	

}
