package com.actitime.reportsscripts;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.automation.base.BaseClass;
import com.automation.utils.ExcelReader;
import com.automation.utils.SeleniumCore;

public class ReportsDashboardScripts extends BaseClass{

	public static ExcelReader reader = ExcelReader.getInstance(currentDir+"\\src\\main\\resources\\TestDataFiles\\TestDataSheetRegister.xls");
	SeleniumCore seleniumCore;
	@BeforeClass
	public void loading() {
		reader.gettingdata("Register");
		seleniumCore=PageFactory.initElements(driver,SeleniumCore.class );
	}

	@Test
	public void loginPage() throws Exception {
		System.out.print(reader.rowData);
		for(Map.Entry<Integer, String> entry : reader.rowData.entrySet()) {
			String value=entry.getValue().substring(1, entry.getValue().length()-1);
			String[] temp = value.split(",");
				driver.findElement(By.name("firstname")).sendKeys(temp[2].trim());
				driver.findElement(By.name("lastname")).sendKeys(temp[3].trim());
				driver.findElement(By.name("reg_email__")).sendKeys(temp[1].trim());
				driver.findElement(By.name("reg_passwd__")).sendKeys(temp[4].trim());
				driver.get("https://www.facebook.com/");
			
		}

	}




}
