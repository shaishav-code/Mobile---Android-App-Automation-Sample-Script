package com.app.login;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.demo.android.utility.ReadCinfigFile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	public static AppiumDriver<MobileElement> driver;
	ReadCinfigFile readconfig  = new ReadCinfigFile();
	public String deviceName =readconfig.getDeviceName();
	public String Udid =readconfig.getUdid();
	public String platformName =readconfig.getPlatformName();
	public String platformVersion =readconfig.getplatformVersion();
	public String appPackage =readconfig.getAppPackage();
	public String appActivity =readconfig.getAppActivity();
	
	
	 DesiredCapabilities caps;
	
	@BeforeClass
	public void setup()
	{
		caps = new DesiredCapabilities();
		caps.setCapability("deviceName", deviceName);  //  Device name:  – I am using Your Device Name
		caps.setCapability("udid", Udid);  //Give Device ID of your mobile phone
		caps.setCapability("platformName", platformName); // Name of the OS: Android
		caps.setCapability("platformVersion",platformVersion);	// Mobile OS version –  Device Android Version
		//caps.setCapability("noReset", true);
		// An activity name for the Android activity you want to run from your package.
		caps.setCapability("appPackage", appPackage);
		caps.setCapability("appActivity", appActivity);		
		caps.setCapability("adbExecTimeout", "50000");
			caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
		caps.setCapability("autoAcceptAlerts","true");
		
	     try
	     {
	    	 driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
				
		 }
	     catch (MalformedURLException e) 
	     {
				System.out.println(e.getMessage());
				
		 }
	}
public void loginWithDemo02User() throws InterruptedException
{
	      new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/btnLogin")));
	       WebElement clickonLoginButton = driver.findElement(By.id("com.shireburn.indigo:id/btnLogin"));
	      clickonLoginButton.click();
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etUsername")));
			WebElement userName = driver.findElement(By.id("com.shireburn.indigo:id/etUsername"));
			userName.clear();
			userName.sendKeys("Demo02");
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etPassword")));
			WebElement userPassword = driver.findElement(By.id("com.shireburn.indigo:id/etPassword"));
			userPassword.clear();
			userPassword.sendKeys("Demo_1234");
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/btnLogin")));
			WebElement login = driver.findElement(By.id("com.shireburn.indigo:id/btnLogin"));
			login.click();
			Thread.sleep(30000);
						
			if (driver.findElements(By.id("com.shireburn.indigo:id/txtContent1")).size() != 0)
			{
				new WebDriverWait(driver, 70).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/txtContent1")));
				WebElement accept = driver.findElement(By.id("com.shireburn.indigo:id/txtContent1"));
				accept.click();
				Thread.sleep(2000);
			}
			
			else 
				
			{
			    System.out.println("Elememt Not Found");
			}
			
			if(driver.findElements(By.id("com.shireburn.indigo:id/etCode1")).size() != 0)
				
			{
				
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etCode1")));
			WebElement setaccesscodeone = driver.findElement(By.id("com.shireburn.indigo:id/etCode1"));
			setaccesscodeone.sendKeys("0");
			
			}
			
			else 
				
			{
			    System.out.println("Elememt Not Found");
			}	
			
			if(driver.findElements(By.id("com.shireburn.indigo:id/etCode2")).size() != 0)
				
			{
				
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etCode2")));
			WebElement setaccesscodetwo = driver.findElement(By.id("com.shireburn.indigo:id/etCode2"));
			setaccesscodetwo.sendKeys("0");
			
			}
			
			else 
				
			{
			    System.out.println("Elememt Not Found");
			}
			
			if(driver.findElements(By.id("com.shireburn.indigo:id/etCode3")).size() != 0)
				
			{
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etCode3")));
			WebElement setaccesscodethree = driver.findElement(By.id("com.shireburn.indigo:id/etCode3"));
			setaccesscodethree.sendKeys("0");
			
			}
			
			else 
				
			{
			    System.out.println("Elememt Not Found");
			}
			
			if(driver.findElements(By.id("com.shireburn.indigo:id/etCode4")).size() != 0)
				
			{
				
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etCode4")));
			WebElement setaccesscodefour = driver.findElement(By.id("com.shireburn.indigo:id/etCode4"));
			setaccesscodefour.sendKeys("0");
			
			}
			
			else 
				
			{
			    System.out.println("Elememt Not Found");
			}
			
			if(driver.findElements(By.id("com.shireburn.indigo:id/btnSetAccessCode")).size() != 0)
				
			{
				
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/btnSetAccessCode")));
			WebElement setaccessdonebutton = driver.findElement(By.id("com.shireburn.indigo:id/btnSetAccessCode"));
			setaccessdonebutton.click();
			
			}
			
			else 
				
			{
			    System.out.println("Elememt Not Found");
			}					
	}
	}

