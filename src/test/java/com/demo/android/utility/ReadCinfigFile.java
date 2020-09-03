package com.demo.android.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadCinfigFile {
	File file ; 
	FileInputStream fis;
	Properties pro;
	
	
	public ReadCinfigFile() 
	{
		
	try {
		file = new File("./Configuration/config.properties");
		fis = new FileInputStream(file);
		pro = new Properties();
		pro.load(fis);
	
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
		
		
	}
	
	
	public String getDeviceName()
	{
		String deviceName = pro.getProperty("deviceName");
		
		return deviceName;
	
	}
	public String getUdid()
	{
		String Udid = pro.getProperty("UDID");
		
		return Udid;
	
	}
	
	public String getPlatformName()
	{
		String platformName = pro.getProperty("platformName");
		
		return platformName;
	
	}
	
	public String getplatformVersion()
	{
		String platformVersion = pro.getProperty("platformVersion");
		
		return platformVersion;
	
	}
	
	public String getAppPackage()
	{
		String appPackage = pro.getProperty("appPackage");
		
		return appPackage;
	
	}
	
	public String getAppActivity()
	{
		String appActivity = pro.getProperty("appActivity");
		
		return appActivity;
	
	}
	
	


}
