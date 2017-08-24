package bgb.CommonProperties;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import Listener.Reporter;


public class BasePage {
	
	public static WebDriver browser = null;
	public static String reportdate;
	
	@BeforeClass
	public void systemdate()
	{
		DateFormat date1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		reportdate = date1.format(cal);
		System.out.println(reportdate);
	}
	
	public void verifyAndClickwithXpath(String value,String message)
	{
		WebElement Element;		
		Element = browser.findElement(By.xpath(value));
		
		if(Element.isDisplayed())
		{
			Reporter.addStepLog(message+ " clicked successfully");
		  browser.findElement(By.xpath(value)).click();
		}
		
		else
		{
			Reporter.addStepLog(message+" not clicked");
			Assert.assertTrue(false);
		}
	}
	
	public void verifyAndClickwithid(String value,String message)
	{
		WebElement Element;		
		Element = browser.findElement(By.id(value));
		
		if(Element.isDisplayed())
		{
			Reporter.addStepLog(message+ " entered successfully");
		  browser.findElement(By.id(value)).click();
		}
		
		else
		{
			Reporter.addStepLog(message+" not entered");
		}
	}
	
	public void verifyInputByID(String property, String value,String message)
	{
		WebElement Element;		
		Element = browser.findElement(By.id(property));
		
		if(Element.isDisplayed())
		{
			Reporter.addStepLog(message+ " entered successfully");
		  browser.findElement(By.id(property)).sendKeys(value);
		}
		
		else
		{
			Reporter.addStepLog(message+ " not entered");
		}
		
	}
	
	public void verifyInputByXpath(String property, String value,String message)
	{
		WebElement Element;		
		Element = browser.findElement(By.xpath(property));
		
		if(Element.isDisplayed())
		{
			Reporter.addStepLog(message+ " entered successfully");
		   browser.findElement(By.xpath(property)).sendKeys(value);
		  
		}
		
		else
		{
			Reporter.addStepLog(message+" not entered");
		}
		
	}
	
	public String verifyAndGetTextByXpath(String property)
	{
			
	    return browser.findElement(By.xpath(property)).getText();
	    
	}
	
	
	
	public void browserWait(int WaitTime)
	{
		try
		{
			Thread.sleep(WaitTime);
			}
		catch(Exception e)
		{
			
		}
	}
	
}