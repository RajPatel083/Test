/**
 * 
 */
package com.serviceNow.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author k.narasimha.swamy
 *
 */
public class FrameHelper {
	
	public String parentHandleer;
	Utility util = new Utility();
	
	/**
	 * This method will Switch to Specified frame
	 * @author k.narasimha.swamy
	 * @param driver
	 * @param iFrame
	 */
	public  void switchToFrame(ExtentTest logger,WebDriver driver, WebElement iFrame)
	{
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
			logger.log(LogStatus.PASS,  "Switch to <b>"+iFrame+"</b> Success");
		} catch (Exception e)
		{
			util.screenShotAndErrorMsg(logger, e, driver, "switchToFrame");	
		}
		
	}
	
	/**
	 * This method will return Parent window handler
	 * @author k.narasimha.swamy
	 * @param logger
	 * @param driver
	 * @return
	 */
	public  String getParentWindowHandle(ExtentTest logger,WebDriver driver)
	{
		try
		{
			parentHandleer = driver.getWindowHandle();
			//System.out.println(parentHandleer);
			logger.log(LogStatus.PASS,  "The parent window handler is <b>"+parentHandleer+"</b> Success");
			return parentHandleer;
		}catch(Exception e)
		{
			util.screenShotAndErrorMsg(logger, e, driver, "getParentWindowHandle");	
		}
		return "";
	}
	
	/**
	 * This method will useful switching to child window
	 * @author k.narasimha.swamy
	 * @param logger
	 * @param driver
	 * @param parentHandle
	 */
	public  void switchToChildWindow(ExtentTest logger,WebDriver driver,String parentHandle)
    {
		try {			
			Thread.sleep(5000);
			for (String winHandle : driver.getWindowHandles())
			{	
				if (!winHandle.equals(parentHandle)) { 
					driver.switchTo().window(winHandle);
					logger.log(LogStatus.PASS,  "Swiching to child window is  Success");
				}
			}
		}			
		catch (Exception e) 
		{				
			util.screenShotAndErrorMsg(logger, e, driver, "switchToChildWindow");	
		}
    }
	
	/**
	 * 
	 * This method for switch back to parent window
	 * @author k.narasimha.swamy
	 * @param logger
	 * @param driver
	 * @param parentHandle
	 */
	
	public  void switchToParentWindowHandle(ExtentTest logger,WebDriver driver,String parentHandle)
	{
		try{	
			//System.out.println("Switching back to parent Window-----------");
			driver.switchTo().window(parentHandle);	
			logger.log(LogStatus.PASS,  "Swiching to parent window <b>"+parentHandle+"</b>is  Success");
			//System.out.println("Switching back to parent Window");
		}catch(Exception e)
		{
			util.screenShotAndErrorMsg(logger, e, driver, "switchToParentWindowHandle");
		}		
	}
	
	/**
	 * This method for Switch back to Default Frame 
	 * @author k.narasimha.swamy
	 * @param logger
	 * @param driver
	 */
	public static void switchToDefaultFrame(ExtentTest logger,WebDriver driver)
	{	
		try
		{
			driver.switchTo().defaultContent();
			logger.log(LogStatus.PASS,  "Swiching to Default frame is  Success");
			
		}catch(Exception e)
		{
			e.printStackTrace();
			logger.log(LogStatus.FAIL,  "Failed: Switch to default frame due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	

}
