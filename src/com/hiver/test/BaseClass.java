package com.hiver.test;

import java.io.File;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass 
{
	ChromeDriver driver;
	static String projectPath = System.getProperty("user.dir");
	public static  final String driverpath=projectPath+"/Driver/chromedriver.exe";
	public static  final String extension=projectPath+"/Driver/extension.crx";
	
	@BeforeMethod
	public void Startframework()
	{
		System.setProperty("webdriver.chrome.driver", driverpath);
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File(extension));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void Teardown()
	{
		driver.quit();
		
	}
}
