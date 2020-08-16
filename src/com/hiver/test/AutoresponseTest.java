package com.hiver.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AutoresponseTest extends BaseClass
{
	public WebElement userName = driver.findElement(By.id("identifierId"));
	public WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
	public WebElement btn_Next = driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
	public WebElement hiversIcon = driver.findElement(By.xpath("//div[contains(@class,'hiver-nonLogged-state')]"));
	public WebElement hiversLogin = driver.findElement(By.xpath("//a[text()='Login to Hiver']"));
	public WebElement hiversSetup = driver.findElement(By.xpath("//div[@data-tooltip='Hiver settings']"));
	public WebElement hiversAdmin = driver.findElement(By.xpath("//div[@data-linktype='admin_panel']"));
	public WebElement hiversSharedmailboxicon = driver.findElement(By.xpath("//li[@name='sharedmailbox']"));
	public WebElement hiversFolder = driver.findElement(By.xpath("//span[text()='Bhuvana.90.gowda']"));
	public WebElement hiversAutoResponder = driver.findElement(By.xpath("//span[text()='Auto Responder']"));
	public WebElement hiversToggle =  driver.findElement(By.xpath("//div/input[@type='checkbox']"));
	public WebElement hiversTostMsg =  driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
	
	public AutoresponseTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	

	@Test
	public void automailResponse()
	{
		driver.get("https://accounts.google.com/signin");
		waittill(5);
		enter(userName, "bhuvana.90.gowda@gmail.com");
		click(btn_Next);
		waittill(2);
		explicitwait(password);
		enter(password, "Bhuvana@1234");
		click(btn_Next);
		waittill(5);
		driver.get("https://mail.google.com/mail/u/1/#hiver");
		waittill(5);
		click(hiversIcon);
		waittill(5);
		click(hiversLogin);
		waittill(8);
		click(hiversSetup);
		click(hiversAdmin);
		waittill(8);
		click(hiversSharedmailboxicon);
		waittill(8);
		click(hiversFolder);
		waittill(8);
		click(hiversAutoResponder);
		if(hiversToggle.getAttribute("class").equals("h-switch h-slider-on"))
		{
			click(hiversToggle);
			waittill(8);
		}
		else
		{
			click(hiversToggle);
		}
		verifyElement(hiversTostMsg);
	}

	public void verifyElement(WebElement element)
	{
		try
		{
			element.isDisplayed();
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}

	public void waittill(int sec)
	{
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void click(WebElement element)
	{
		try
		{
			element.click();
		}
		catch(Exception e)
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", element);
		}
	}

	public void enter(WebElement element, String value)
	{
		element.sendKeys(value);
	}

	public void explicitwait(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);      
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
}
