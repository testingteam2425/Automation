package com.automation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Config {
	
	public static String proFilePath=System.getProperty("user.dir")+"/src/main/resources/config/config.properties";
	public static Properties props;
	public static Config  config;
	
	public Config() throws FileNotFoundException, IOException {
		props=new Properties();
		props.load(new FileInputStream(proFilePath));
	}

	public static Config getInstance() {
		try {
			config=new Config();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return config;
	}
	
	/*
	 * @return - Project URL
	 */
	public String getTestDataSheet() {
		return props.getProperty("TestDataPath");
	}
	
	/*
	 * @return - Project URL
	 */
	public String getProjectURL() {
		return props.getProperty("URL");
	}
	
	/*
	 * @return - Running Browser
	 */
	public String getBrowser() {
		return props.getProperty("Browser");
	}
	
	/*
	 * @ return - Mac Chrome driver Path
	 */
	public String getMacChromeDriverPath() {
		return props.getProperty("MacChromeDriver");
	}
	
	/*
	 * @ return - Win Chrome driver Path
	 */
	public String getWinChromeDriverPath() {
		return props.getProperty("WinChromeDriver");
	}
	
	/*
	 * @ return - Linx Chrome browser Path
	 */
	public String getLinChromeDriverPath() {
		return props.getProperty("LinChromeDriver");
	}
	
	/*
	 * @ return - Mac Gecko driver Path
	 */
	public String getMacGeckoDriverPath() {
		return props.getProperty("MacGeckoDriver");
	}
	
	/*
	 * @ return - Win Gecko driver Path
	 */
	public String getWinGeckoDriverPath() {
		return props.getProperty("WinGeckoDriver");
	}
	
	/*
	 * @ return - Linx Gecko browser Path
	 */
	public String getLinGeckoDriverPath() {
		return props.getProperty("LinGeckoDriver");
	}
	
	/*
	 * @ return - Win IE driver Path
	 */
	public String getWinIEDriverPath() {
		return props.getProperty("WinIEDriver");
	}
	
	/*
	 * @ return - Win IE driver Path
	 */
	public String getDeviceVersion() {
		return props.getProperty("DeviceVersion");
	}
	
	/*
	 * @ return - Win IE driver Path
	 */
	public String getDeviceName() {
		return props.getProperty("DeviceName");
	}
	
	/*
	 * @ return - Win IE driver Path
	 */
	public String getAppPackageName() {
		return props.getProperty("AppPackageName");
	}
	
	/*
	 * @ return - Win IE driver Path
	 */
	public String getAppActivityName() {
		return props.getProperty("AppActivityName");
	}
	
	/*
	 * @ return - Win IE driver Path
	 */
	public String getDeviceBrowser() {
		return props.getProperty("DeviceBrowser");
	}
}
