package com.app.login;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.connection.HasNetworkConnection;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class LoginTest extends BaseClass
{
	@Test(priority = 1)
	
	public void enterInvalidPassword() throws InterruptedException 
	{
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/btnLogin")));
		WebElement clickonLoginButton = driver.findElement(By.id("com.shireburn.indigo:id/btnLogin"));
		clickonLoginButton.click();
		
		//Entering incorrect login credentials
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etUsername")));
		WebElement userName = driver.findElement(By.id("com.shireburn.indigo:id/etUsername"));
		userName.sendKeys("Demo03");
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etPassword")));
		WebElement userPassword = driver.findElement(By.id("com.shireburn.indigo:id/etPassword"));
		userPassword.sendKeys("Demo_123");
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/btnLogin")));
		WebElement login = driver.findElement(By.id("com.shireburn.indigo:id/btnLogin"));
		login.click();
		
		Thread.sleep(8000);
		
		if (driver.findElements(By.id("android:id/message")).size() != 0)
		{
			WebElement errorText = driver.findElement(By.id("android:id/message"));
			System.out.println("Error Message==>" + "  " + errorText.getText());
			Assert.assertEquals(errorText.getText(), "Invalid username or password");
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1")));
			WebElement clickonOk = driver.findElement(By.id("android:id/button1"));
			clickonOk.click();
		}
		else 
		{
			Assert.assertFalse(false);
		}
	}

	@Test(priority = 2)
	
	public void enterInvalidUsername() throws InterruptedException 
	{
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/btnLogin")));

		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etUsername")));
		WebElement userName = driver.findElement(By.id("com.shireburn.indigo:id/etUsername"));
		userName.clear();
		
		userName.sendKeys("Demo44");
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etPassword")));
		WebElement userPassword = driver.findElement(By.id("com.shireburn.indigo:id/etPassword"));
		userPassword.clear();
		
		userPassword.sendKeys("Demo_1234");
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/btnLogin")));
		WebElement login = driver.findElement(By.id("com.shireburn.indigo:id/btnLogin"));
		login.click();
		
		Thread.sleep(8000);
		
		if (driver.findElements(By.id("android:id/message")).size() != 0) 
		{
			WebElement errorText = driver.findElement(By.id("android:id/message"));
			System.out.println("Error Message==>" + "  " + errorText.getText());
			Assert.assertEquals(errorText.getText(), "Invalid username or password");
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1")));
			WebElement clickonOk = driver.findElement(By.id("android:id/button1"));
			clickonOk.click();
		}
		else
		{
			Assert.assertFalse(false);
		}
	}

	@Test(priority = 3)
	
	public void validateFields() throws InterruptedException 
	{
		String[] username = new String[6];
		username[0] = "D";
		username[1] = "De";
		username[2] = "Dem";
		username[3] = "Demo";
		username[4] = "Demoo";
		username[5] = "Demooo";

		String[] password = new String[6];
		password[0] = "A";
		password[1] = "Ab";
		password[2] = "Abc";
		password[3] = "Abcd";
		password[4] = "Abcde";
		password[5] = "Abcdef";

		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/btnLogin")));

		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etUsername")));
		WebElement userName = driver.findElement(By.id("com.shireburn.indigo:id/etUsername"));

		for (int i = 0; i < 6; i++)
		{
			userName.clear();
			userName.sendKeys(username[i]);
			Thread.sleep(4000);
			WebElement error = driver.findElement(By.id("com.shireburn.indigo:id/etUsername"));
			System.out.println("Entered Username Is ==>" + " " + error.getText() + " :=>"+ "Username Must caontain at least 6 character");
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/btnLogin")));
			WebElement login = driver.findElement(By.id("com.shireburn.indigo:id/btnLogin"));
			login.click();
			
			Thread.sleep(3000);
			
			if (driver.findElements(By.id("android:id/message")).size() != 0)
			{
				WebElement errorText = driver.findElement(By.id("android:id/message"));

				new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1")));
				WebElement clickonOk = driver.findElement(By.id("android:id/button1"));
				clickonOk.click();
				
				if (username[i].length() == 6) 
				{
					System.out.println("Enter Password");

					for (int j = 0; j < 6; j++)
					{
						new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etPassword")));
						WebElement userPassword = driver.findElement(By.id("com.shireburn.indigo:id/etPassword"));
						userPassword.clear();
						
						userPassword.sendKeys(password[j]);
						
						Thread.sleep(4000);
						
						WebElement passworderror = driver.findElement(By.id("com.shireburn.indigo:id/etPassword"));
						System.out.println("Entered Password Is ==>" + " " + passworderror.getText() + " :=>"+ "Password Must caontain at least 6 character");
						new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/btnLogin")));
						WebElement loginn = driver.findElement(By.id("com.shireburn.indigo:id/btnLogin"));
						loginn.click();
						
						Thread.sleep(3000);
						
						if (driver.findElements(By.id("android:id/message")).size() != 0)
						{
							WebElement errorTextt = driver.findElement(By.id("android:id/message"));
							System.out.println("Error Message==>" + "  " + errorText.getText());
							Assert.assertEquals(errorTextt.getText(), "Invalid username or password");
							new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1")));
							WebElement clickonOkk = driver.findElement(By.id("android:id/button1"));
							clickonOkk.click();
						}

					}

				}
			}
		}
	}

	@Test(priority = 4)

	public void loginWithInvalidUser() throws InterruptedException 
	{
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etUsername")));
		WebElement userName = driver.findElement(By.id("com.shireburn.indigo:id/etUsername"));
		userName.clear();
		
		userName.sendKeys("Demo01");
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etPassword")));
		WebElement userPassword = driver.findElement(By.id("com.shireburn.indigo:id/etPassword"));
		userPassword.clear();
		
		userPassword.sendKeys("Demo_1234");
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/btnLogin")));
		WebElement login = driver.findElement(By.id("com.shireburn.indigo:id/btnLogin"));
		login.click();
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/txtContent1")));
		WebElement accept = driver.findElement(By.id("com.shireburn.indigo:id/txtContent1"));
		accept.click();
		
		Thread.sleep(5000);
		if (driver.findElements(By.id("android:id/message")).size() != 0)
		{
			WebElement errorTextMsg = driver.findElement(By.id("android:id/message"));
			System.out.println(errorTextMsg.getText());
			Assert.assertEquals(errorTextMsg.getText(), "User does not have permission [TA_PersonalPunchesDevice]");
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1")));
			WebElement clickonOk = driver.findElement(By.id("android:id/button1"));
			clickonOk.click();
		} 
		else 
		{
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 5)
                         
	// Entering Correct login Credentials
	
	public void loginTestScenario() throws InterruptedException 
	{
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etUsername")));
		WebElement userName = driver.findElement(By.id("com.shireburn.indigo:id/etUsername"));
		userName.clear();
		userName.sendKeys("Demo03");
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etPassword")));
		WebElement userPassword = driver.findElement(By.id("com.shireburn.indigo:id/etPassword"));
		userPassword.clear();
		userPassword.sendKeys("Demo_1234");
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/btnLogin")));
		WebElement login = driver.findElement(By.id("com.shireburn.indigo:id/btnLogin"));
		login.click();
		Thread.sleep(8000);
			
		// back button 
		((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.BACK));
		
	    // again click on app icon
		
		((StartsActivity) driver).startActivity(new Activity("com.shireburn.indigo", "com.shireburn.indigo.ui.activity.LoginActivity")); 
		
		// Entering Access code
		
		if (driver.findElements(By.id("com.shireburn.indigo:id/txtContent1")).size() != 0) 
		{
			WebElement accept = driver.findElement(By.id("com.shireburn.indigo:id/txtContent1"));
			accept.click();
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etCode1")));
			WebElement setaccesscodeone = driver.findElement(By.id("com.shireburn.indigo:id/etCode1"));
			setaccesscodeone.sendKeys("0");
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etCode2")));
			WebElement setaccesscodetwo = driver.findElement(By.id("com.shireburn.indigo:id/etCode2"));
			setaccesscodetwo.sendKeys("0");
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etCode3")));
			WebElement setaccesscodethree = driver.findElement(By.id("com.shireburn.indigo:id/etCode3"));
			setaccesscodethree.sendKeys("0");
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etCode4")));
			WebElement setaccesscodefour = driver.findElement(By.id("com.shireburn.indigo:id/etCode4"));
			setaccesscodefour.sendKeys("0");
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/btnSetAccessCode")));
			WebElement setaccessdonebutton = driver.findElement(By.id("com.shireburn.indigo:id/btnSetAccessCode"));
			setaccessdonebutton.click();
			
			/// Loction
			
			/*((AndroidDriver) driver).openNotifications();
	        ((AndroidDriver) driver).toggleLocationServices();
	        ((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.BACK));*/
						
		}

		else 
			
		{
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etCode1")));
			WebElement setaccesscodeone = driver.findElement(By.id("com.shireburn.indigo:id/etCode1"));
			setaccesscodeone.sendKeys("0");
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etCode2")));
			WebElement setaccesscodetwo = driver.findElement(By.id("com.shireburn.indigo:id/etCode2"));
			setaccesscodetwo.sendKeys("0");
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etCode3")));
			WebElement setaccesscodethree = driver.findElement(By.id("com.shireburn.indigo:id/etCode3"));
			setaccesscodethree.sendKeys("0");
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etCode4")));
			WebElement setaccesscodefour = driver.findElement(By.id("com.shireburn.indigo:id/etCode4"));
			setaccesscodefour.sendKeys("0");
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/btnSetAccessCode")));
			WebElement setaccessdonebutton = driver.findElement(By.id("com.shireburn.indigo:id/btnSetAccessCode"));
			setaccessdonebutton.click();
			Thread.sleep(8000);
			
			
			// Login the app by access code dial page
			
			((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.BACK));
			
			((StartsActivity) driver).startActivity(new Activity("com.shireburn.indigo", "com.shireburn.indigo.ui.activity.LoginActivity"));
					
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/txt1")));
			WebElement setaccesscodfive = driver.findElement(By.id("com.shireburn.indigo:id/txt1"));
			setaccesscodfive.click();
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/txt3")));
			WebElement setaccesscodesix = driver.findElement(By.id("com.shireburn.indigo:id/txt3"));
			setaccesscodesix.click();
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/txt5")));
			WebElement setaccesscodeseven = driver.findElement(By.id("com.shireburn.indigo:id/txt5"));
			setaccesscodeseven.click();
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/txt6")));
			WebElement setaccesscodeeight = driver.findElement(By.id("com.shireburn.indigo:id/txt6"));
			setaccesscodeeight.click();
			Thread.sleep(2000);
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1")));
			WebElement ok = driver.findElement(By.id("android:id/button1"));
		    ok.click();
		    Thread.sleep(2000);
		    new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/txt0")));
			WebElement setaccesscodnine = driver.findElement(By.id("com.shireburn.indigo:id/txt0"));
			setaccesscodnine.click();
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/txt0")));
			WebElement setaccesscodeten = driver.findElement(By.id("com.shireburn.indigo:id/txt0"));
			setaccesscodeten.click();
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/txt0")));
			WebElement setaccesscodeeleven = driver.findElement(By.id("com.shireburn.indigo:id/txt0"));
			setaccesscodeeleven.click();
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/txt0")));
			WebElement setaccesscodeetwelve = driver.findElement(By.id("com.shireburn.indigo:id/txt0"));
			setaccesscodeetwelve.click();
			
			Thread.sleep(8000);
	
	     //   ((AndroidDriver) driver).toggleLocationServices();
		}
	}

	@Test(priority = 6)
	
           // Logout from the app
	
	public void logouttest() throws InterruptedException
	{
		Thread.sleep(8000);
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/imgMenu")));
		WebElement clickonMenu = driver.findElement(By.id("com.shireburn.indigo:id/imgMenu"));
		clickonMenu.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/txtMenu")));
		List<MobileElement> menuwindow = (List<MobileElement>) driver.findElementsById("com.shireburn.indigo:id/txtMenu");
		System.out.println("Menuwindow Burron size ==>" + "  " + menuwindow.size());
		for (int i = 0; i < menuwindow.size(); i++) 
		{
			if (menuwindow.get(i).getText().equals("Manage accounts"))
			{
				menuwindow.get(i).click();
				break;
			}
			else 
			{
				System.out.println("Not found");
			}
		}
		
		Thread.sleep(6000);

		try
		{
			((HasNetworkConnection) driver).setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
			System.out.println("Switching OFF the connection : " + ((HasNetworkConnection) driver).getConnection());
			Thread.sleep(10000);
		} 
		catch (Exception e) 
		{
			System.out.println("Connection could not be switch OFF");
		}

		Thread.sleep(10000);

		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/btnLogout")));
		WebElement log = driver.findElement(By.id("com.shireburn.indigo:id/btnLogout"));
		log.click();
		Thread.sleep(10000);
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1")));
		WebElement clickonLogOut = driver.findElement(By.id("android:id/button1"));
		clickonLogOut.click();

		try 
		{
			((HasNetworkConnection) driver).setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
			System.out.println("Switching On the connection: " + ((HasNetworkConnection) driver).getConnection());
		} 
		catch (Exception e)
		{
			System.out.println("Connection could not be switch ON");
		}
		
		Thread.sleep(10000);
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/btnLogout")));
		WebElement logone = driver.findElement(By.id("com.shireburn.indigo:id/btnLogout"));
		logone.click();
		Thread.sleep(10000);
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("android:id/button1")));
		WebElement clickonLogOutone = driver.findElement(By.id("android:id/button1"));
		clickonLogOutone.click();
		Thread.sleep(10000);
	}
		
	@Test(priority = 7)

		public void loginTest() throws InterruptedException 
	{
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.shireburn.indigo:id/etUsername")));
			WebElement userName = driver.findElement(By.id("com.shireburn.indigo:id/etUsername"));
			userName.clear();
			userName.sendKeys("Demo05");
			
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
	

