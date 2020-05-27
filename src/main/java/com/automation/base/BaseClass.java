package com.automation.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prob;
	public static Properties testDataProb;

	public static String currentDir = System.getProperty("user.dir");
	
	@BeforeSuite
	public void initbrowser() throws IOException{

		loadConfigFile(currentDir+"\\src\\main\\resources\\config\\config.properties");

		if (prob.getProperty("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",currentDir+"\\src\\main\\resources\\browserDetails\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else if(prob.getProperty("Browser").equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver",currentDir+"/src/main/resources/browserDetails/geckodriver.exe");
			//driver = new FirefoxDriver();
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
	
	public String getCurrentTimeStamp(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyHHmmss");
        return  sdf.format(date);
    } 

}