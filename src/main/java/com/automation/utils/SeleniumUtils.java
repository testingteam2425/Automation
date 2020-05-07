package com.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.automation.base.BaseClass;



public class SeleniumUtils extends BaseClass{
	Actions actions;

	public void pressEnterKey() {
		actions=new Actions(driver);
		actions.sendKeys(Keys.ENTER).build().perform();
	}

	public void pressTab() {
		actions=new Actions(driver);
		actions.sendKeys(Keys.TAB).build().perform();
	}

	public void moveToSubElement(String menulocator,String submenulocator, String subssubmenulocator) {
		actions=new Actions(driver);
		WebElement menuelement=driver.findElement(By.xpath(menulocator));
		actions.moveToElement(menuelement).build().perform();
		WebElement subelement=driver.findElement(By.xpath(submenulocator));
		actions.moveToElement(subelement).build().perform();
		WebElement subsubElement=driver.findElement(By.xpath(subssubmenulocator));
		actions.click(subsubElement).build().perform();
	}

	public void moveToSubSubElement(String menulocator,String submenulocator, String subssubmenulocator) {
		actions=new Actions(driver);
		WebElement menuelement=driver.findElement(By.xpath(menulocator));
		actions.moveToElement(menuelement).build().perform();
		WebElement subelement=driver.findElement(By.xpath(submenulocator));
		actions.moveToElement(subelement).build().perform();
		WebElement subsubElement=driver.findElement(By.xpath(subssubmenulocator));
		actions.click(subsubElement).build().perform();
	}
}
