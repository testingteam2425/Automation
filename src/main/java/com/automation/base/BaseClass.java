package com.automation.base;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

	public static WebDriver driver;
	public static String currDir=System.getProperty("user.dir");
	public static String currOS=System.getProperty("os.name").toLowerCase();
	public static String MYPATH = System.getProperty("user.dir");
	
	
	

	public Config config=Config.getInstance();
	Logger logger = Logger.getLogger(BaseClass.class);

	public static ExtentReports extent;
	public static ExtentTest testReportparent;
	public static ExtentTest testReportChild;

	public static String resultPath=resultPath();

	public static String PROP = System.setProperty("dynamic_property_location", resultPath); 
	
	@SuppressWarnings("rawtypes")
	@BeforeSuite(alwaysRun = true)
	public void initbrowser() {
        System.out.println("the path iss"+MYPATH);
		System.out.println("Current os is ::::: "+currOS);
		String ReportFile =resultPath+"/extendReport.html";
		extent = new ExtentReports(ReportFile, false, DisplayOrder.OLDEST_FIRST);
		testdataBackup();

		DesiredCapabilities capabilities;
		if("Firefox".equals(config.getBrowser())) {
			if(currOS.contains("mac")) {
				System.setProperty("webdriver.gecko.driver",currDir+config.getMacGeckoDriverPath());
				driver=new FirefoxDriver();
			}else if (currOS.contains("windows")) {
				System.setProperty("webdriver.gecko.driver",currDir+config.getWinGeckoDriverPath());
				driver=new FirefoxDriver();
			}else if (currOS.contains("linux")) {
				System.setProperty("webdriver.gecko.driver",currDir+config.getLinGeckoDriverPath());
				driver=new FirefoxDriver();
			}else {
				logger.info("Currnet OS Is not Avaliable in Firefox Browser");
			}
		}else if ("Chrome".equals(config.getBrowser())) {
			if(currOS.contains("mac")) {
				System.setProperty("webdriver.chrome.driver",currDir+config.getMacChromeDriverPath());
				driver=new ChromeDriver();
			}else if (currOS.contains("windows")) {
				System.setProperty("webdriver.chrome.driver",currDir+config.getWinChromeDriverPath());
				driver=new ChromeDriver();
			}else if (currOS.contains("linux")) {
				System.setProperty("webdriver.chrome.driver",currDir+config.getLinChromeDriverPath());
				driver=new ChromeDriver();
			}else {
				logger.info("Currnet OS Is not Avaliable in Chrome Browser");
			}
			driver.manage().window().maximize();
			logger.info("Window is maximize");
		}else if ("IE".equals(config.getBrowser())) {
			if(currOS.contains("windows")) {
				System.setProperty("webdriver.ie.driver",currDir+config.getWinIEDriverPath());
				driver=new FirefoxDriver();
			}else {
				System.out.println("Currnet OS Is not Avaliable in IE Browser");
			}
			driver.manage().window().maximize();
		}else if ("Safari".equals(config.getBrowser())) {
			if(currOS.contains("mac")) {
				driver=new SafariDriver();
			}else if (currOS.contains("windows")) {
				driver=new SafariDriver();
			}else if (currOS.contains("linux")) {
				driver=new SafariDriver();
			}else {
				logger.info("Currnet OS Is not Avaliable in Safari Browser");
			}
			driver.manage().window().maximize();
		}else if ("Android".equals(config.getBrowser())) {
			try {
				capabilities = new DesiredCapabilities();
				capabilities.setCapability("acceptSslCerts", true);
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("browserName", config.getDeviceBrowser());
				capabilities.setCapability("version", config.getDeviceVersion());
				capabilities.setCapability("deviceName",config.getDeviceName());
				capabilities.setCapability("app-package", config.getAppPackageName());
				capabilities.setCapability("app-activity", config.getAppActivityName());
				driver =new AndroidDriver(new URL("http://127.0.0.1:5565/wd/hub"),capabilities);
				driver.manage().timeouts().implicitlyWait(260, TimeUnit.SECONDS);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if ("IOS".equals(config.getBrowser())) {

		}else {
			new RuntimeException(" Invalid Browser Name ");
		}
		logger.info("Given browser maximize :: "+ config.getBrowser() +" :: lanuched sucessfully .....");
		driver.get(config.getProjectURL());
		logger.info("Given URL is :::: "+config.getProjectURL());

		BasicConfigurator.configure();

	}

	@AfterSuite(alwaysRun = true)
	public void quitBrowser() {
		driver.quit();
		logStatusPass("Closing Browser", "Browser closed");
		extent.endTest(testReportparent);	 
		extent.flush();
	}


	public void createChildTest(String moduleName,String testScenarioDescription) {
		testReportChild = extent.startTest(moduleName,testScenarioDescription);
	}

	public void logStatusFail(String testDescription,String errorMessage) {	
		testReportChild.log(LogStatus.FAIL, testDescription,errorMessage);
		testReportparent.getTest().setStatus(LogStatus.FAIL);
	}

	public void logStatusPass(String description,String result) {
		testReportChild.log(LogStatus.PASS, description, result);
		testReportparent.getTest().setStatus(LogStatus.PASS);
	}

	public void appendChildTest() 	{
		LogStatus currParentStatus = testReportparent.getRunStatus();
		LogStatus currChildStatus = testReportChild.getRunStatus();
		if(currParentStatus.toString().equals("unknown")) {
			testReportparent.getTest().setStatus(testReportChild.getRunStatus()); 
		} else if(currChildStatus.toString().equals("pass") && currParentStatus.toString().equals("pass")) {
			testReportparent.getTest().setStatus(LogStatus.PASS); 
		}else {
			testReportparent.getTest().setStatus(LogStatus.FAIL); 
		} 
		testReportparent.appendChild(testReportChild);
	}


	public static String getDateAndTime(String format) {
		String DateAndTime=null;
		try{
			Date date=new Date();
			SimpleDateFormat simple=new SimpleDateFormat(format);
			DateAndTime=simple.format(date);
		}catch(Exception e){
			e.printStackTrace();
		}
		return DateAndTime;
	}

	public static String resultPath(){
		String DateFolder;
		String DateValue;
		String TimeFolder = null;
		String TimeValue;
		String path=System.getProperty("user.dir")+"/Reports";

		try{
			DateValue=getDateAndTime("dd-MMMM-yyyy");
			TimeValue=getDateAndTime("hh.mm.ss a");
			DateFolder=path+"/"+DateValue;
			TimeFolder=DateFolder+"/"+TimeValue;
			File f1=new File(DateFolder);
			File f2=new File(TimeFolder);
			if (! f1.exists()){
				f1.mkdir();
			}
			f2.mkdir();

		}catch(Exception e){
			e.printStackTrace();
		}
		return TimeFolder;
	}

	public String getScreenshot(String fileName) throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyhhmmssSSS");
		Date curDate = new Date();
		String strDate = sdf.format(curDate);
		String newFileName = resultPath+"/screenshots/"+strDate+".png";
		FileUtils.copyFile(scrFile, new File(newFileName));
		String link="<a target='_blank' href='"+newFileName+"'><font color='red'> <u>"+fileName+"</u></font></a>";
		return link ;       
	}

	public void testdataBackup() {
		try {
			File sourceFile=new File(currDir+"/src/main/resources/TestDataFiles");
			File destFile =new File(resultPath+"/testdata/");
			FileUtils.copyDirectory(sourceFile,destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
