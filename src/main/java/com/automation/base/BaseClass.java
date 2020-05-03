package com.automation.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prob;
	public static Properties  testDataProb;


	public void initbrowser() throws IOException{

		loadConfigFile("C:\\Users\\talla\\eclipse-workspace\\NEW_MAVEN\\src\\test\\resources\\config\\config.properties");
		loadConfigTestDataFile("C:\\Users\\talla\\eclipse-workspace\\NEW_MAVEN\\src\\test\\resources\\config\\testData.properties");

		if (prob.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\talla\\Downloads\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else if(prob.getProperty("browser").equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\Users\\talla\\Downloads\\Drivers\\geckodriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else {
			System.out.println("Browser is not implemented");
		}
		driver.get(prob.getProperty("applicationURL"));
	}


	public void loadConfigFile(String filepath) throws IOException {
		FileInputStream fls=new FileInputStream(filepath);
		prob=new Properties();
		prob.load(fls);
	}

	public void loadConfigTestDataFile(String filepath) throws IOException {
		FileInputStream fls=new FileInputStream(filepath);
		testDataProb=new Properties();
		testDataProb.load(fls);
	}

}