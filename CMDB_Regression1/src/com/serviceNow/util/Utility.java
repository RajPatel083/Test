/**
 * 
 */
package com.serviceNow.util;


import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author k.narasimha.swamy
 *
 */
public class Utility {
	
	String requestId = "";
	String screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\";
	public String screenShotFileName;
	public DateFormat dateFormat;
	public Date date;
	
	public Utility(){
	
		screenShotPath = System.getProperty("user.dir") + "\\Screenshots\\";
		
		 dateFormat = new SimpleDateFormat("ddMMyyyy-HH_mm_ss");
		
		 date = new Date();
	}
	
	/**
	 * This method for wait or pause upto specified time
	 * @author k.narasimha.swamy
	 * @param waitTime
	 * @param logger
	 */
	public void pause(ExtentTest logger,String waitTime)
	{ 
        try
        {
              	long time = (long) Double.parseDouble(waitTime);
              	Thread.sleep(time * 1000L);
  				logger.log(LogStatus.PASS,  "Wait <b>"+waitTime+"</b> Seconds");
        } catch (Exception e){
			e.printStackTrace();
			logger.log(LogStatus.FAIL,  "Failed to wait <b>"+waitTime+" Seconds</b> due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");    
        }  
	}
	
	/**
	 *  The method waits till element is Clickable
	 * @author k.narasimha.swamy
	 * @param logger
	 * @param driver
	 * @param object
	 */
	public  void waitTillElementIsClickable(ExtentTest logger,WebDriver driver, WebElement object)
	{
		try
		{		
			WebDriverWait wait = new WebDriverWait(driver, 60);
			logger.log(LogStatus.INFO,  "Wait upto <b>60 Seconds </b>");
			wait.until(ExpectedConditions.elementToBeClickable(object));
			logger.log(LogStatus.PASS,  "Wait till <b>"+object+" </b>[Object] clikable is Success");
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			showScreenShotInLogger(logger, driver, "waitTillElementIsClickable-Failed");
			logger.log(LogStatus.FAIL,  "Failed: Wait till element is clickable <b>"+object+"</b> due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}	
	 }
	
	
	public void waittillpageload(ExtentTest logger, WebDriver driver)
	{
		try
		{
	driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			logger.log(LogStatus.FAIL, "Page not loaded in 1000 seconds");
	
		}	
		
	} 
	
	
	
	/**
	 * This method will verify the whether the element is displayed or not
	 * @author k.narasimha.swamy 
	 * @param logger
	 * @param object
	 * @return
	 */
	
	
	public  boolean verifyElementByXpath(ExtentTest logger,WebElement object)
	{ 
	    try{
	    	if(object.isDisplayed())
	    	{
	    		System.out.println("The Object is present "+object);
	    		logger.log(LogStatus.PASS,  "WebElement is displayed "+object);
	    		return true;
	    	}		
	      }catch(Exception e)
	    	{
				e.printStackTrace();
				logger.log(LogStatus.FAIL,  "Failed: Element  <b>"+object+"</b> not displayed due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
				
	        }
	    logger.log(LogStatus.FAIL,  "WebElement is not displayed "+object);
	    
		return false;
	}
	
	
	public  boolean isNotDisplayed(ExtentTest logger,WebElement object)
	{ 
	    try{
	    	if(!object.isDisplayed())
	    	{	
	    		logger.log(LogStatus.PASS,  "WebElement is Not displayed");
	    		return true;
	    	}
	    	else{
	    		logger.log(LogStatus.INFO,  "WebElement is displayed");
	    		return false;
	    	}
	      }catch(Exception e)
	    	{
	    	  logger.log(LogStatus.PASS,  "WebElement is not displayed");
	    	  return true;
	        }
	    
	}
	/**
	 * This method will take the screen shot
	 * @author k.narasimha.swamy
	 * @param logger
	 * @param driver
	 * @param fileName
	 */
	public  void captureScreenShot(ExtentTest logger,WebDriver driver,String fileName)
	{
		try 
		{
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			logger.log(LogStatus.PASS,  "Screen shot taken");
			
			//String path = System.getProperty("user.dir") + "\\Screenshots\\" + fileName + ".jpg";
			FileUtils.copyFile(scrFile, new File(fileName));
			
			logger.log(LogStatus.INFO,  "Screen shot Path : <b>"+fileName+"</b>");
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			logger.log(LogStatus.FAIL,  "Failed To take Screen shot due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
	}

	/**
	 * This method will return specified element value 
	 * @author k.narasimha.swamy
	 * @param logger
	 * @param element
	 * @return
	 */
    public String getElementValue(ExtentTest logger,WebElement element)
    {                                                         
        try 
        {	  
             requestId = element.getAttribute("value"); 
             logger.log(LogStatus.PASS,  "Element value taken : <b>"+requestId+"</b");
             //System.out.println(requestId);
                                                                     
        } catch (Exception e)
        {                                                                      
			e.printStackTrace();
			logger.log(LogStatus.FAIL,  "Failed to take Element <b>"+element+"</b>Value due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
        } 
        
      return requestId;	
    } 
    
	/**
	 * This method will return specified drop down[Select Box] Value
	 * @author k.narasimha.swamy
	 * @param logger
	 * @param element
	 * @return
	 */
    public String getSelectedValueFromDropdown(ExtentTest logger,WebElement element) 
    {                                                        
        try 
        {
        	  
        	 Select dropList = new Select(element);
             //System.out.println(dropList.getFirstSelectedOption());
             requestId = dropList.getFirstSelectedOption().getText();
             
             logger.log(LogStatus.INFO,  "Dropdown Value: <b>"+requestId+"</b");
             logger.log(LogStatus.PASS,  "Getting dropdown values is Success");
                                                                     
        } catch (Exception e) 
        {                                                                      
			e.printStackTrace();
			logger.log(LogStatus.FAIL,  "Failed to get Dropdown <b>"+element+"</b>value due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
        }  
      return requestId;	
    } 
    
   /**
    * This method for Mouse hover on Specified element 
    * @author k.narasimha.swamy
    * @param logger
    * @param driver
    * @param element
    */
    public void mouseHover(ExtentTest logger,WebDriver driver,WebElement element)
    {    
           try 
           {   
                 Actions builder = new Actions(driver);
                 // Move cursor to the Main Menu Element
                 builder.moveToElement(element).perform();
                 logger.log(LogStatus.PASS,  "Mouse Hover to "+element+" is success");
                 
           } catch (Exception e) 
           {
   			e.printStackTrace();
   			logger.log(LogStatus.FAIL,  "Failed:  Mouse hover on <b>"+element+"</b> element due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
           }
    }
    
    /**
     * Verifying Drop down[Select box] options
     * @author k.narasimha.swamy
     * @param object
     * @param optionsList
     * @return
     */
    public boolean verifyDropdownValues(ExtentTest logger,WebElement object, String optionsList)
    {
    	try 
    	{
    		List<WebElement> droplistContents = object.findElements(By.tagName("option"));
    		
    		String valuesList[] = optionsList.split("\\|");
    		
    		if (valuesList.length != droplistContents.size()) 
    		{	
    			logger.log(LogStatus.FAIL,  "Failed to verify dropdown list values due to <b>Dropdown list size and Options size are different</b>.Expected list size-"+valuesList.length+" ::Actual-"+droplistContents.size());
    			return false;
    		}
    		for (int i = 0; i < droplistContents.size(); i++) 
    		{
    			if (!droplistContents.get(i).getText().contains(valuesList[i])) {
    				logger.log(LogStatus.FAIL,  "Failed to verify dropdown list values due to <b>"+valuesList[i]+" option not avaliable in Dropdown list</b>");
    				return false;
    			}
    		}    
    		
    	} catch (Exception e) {
			e.printStackTrace();
			logger.log(LogStatus.FAIL,  "Failed:  to verify dropdown list values due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
    		return false;
    	}
    	logger.log(LogStatus.PASS,  "Verified all the dropdown options successfully");
    	return true;
    }
     

    	/**
    	 * This method for selecting a option in Drop down by Visible Text  
    	 * @author k.narasimha.swamy 
    	 * @param logger
    	 * @param we
    	 * @param value
    	 */
       public void selectBoxByValue(ExtentTest logger,WebElement element, String value)
       {        
         try
         {
             Select dropList = new Select(element);
             dropList.selectByVisibleText(value); 
             logger.log(LogStatus.PASS,  "<b>"+value+"</b> value is selected from Dropdown");
         } catch (Exception e) {
 			e.printStackTrace();
 			logger.log(LogStatus.FAIL,  "Failed to select value from drop down due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
         }           
      }
       
       
       /**
        * This method will verify whether the webelement is disabled or not
        * @param webelement
        * @return
        */
       
       public boolean isDisabled(ExtentTest logger,WebElement webelement)
       {   
    	   try 
    	   {
    		   if (webelement.isEnabled()) {
	        	   try{
	          			if(webelement.getAttribute("readonly").equals("true")){
	          				logger.log(LogStatus.PASS, webelement+"  is disabled");
	          				return true;
	          			}
	          			else{
	          				logger.log(LogStatus.FAIL, webelement+"  is not disabled");
	          				return false;
	          			}
	     		        
	        	   }catch(Exception e){
	        		   logger.log(LogStatus.FAIL, webelement+"  is not disabled");
	        		   return false;
	 		       }
	      		}else{
		        	 logger.log(LogStatus.PASS, webelement+"  is disabled");
		        	 return true;
	      		}
		           
    	   } catch (Exception e)
    	   {
   				e.printStackTrace();
   				logger.log(LogStatus.FAIL,  "Failed to check whether the element is Disabled or not due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
    	   }
    	   return true;
    	   
       }
       
       /**
        * This method will compare two strings and return true only if both strings are same 
        * @param webelement
        * @return
        */
       
       public boolean compareTwoStrings(ExtentTest logger,String actual,String excepted)
       {   
    	   try 
    	   {
    		   if(actual.equalsIgnoreCase(excepted))
    		   {
    			   logger.log(LogStatus.PASS,  "Comparing "+actual+"and "+excepted+" success");
    			   return true;
    		   }else{
    			   logger.log(LogStatus.FAIL,  "Comparing "+actual+"and "+excepted+" - failed");
    			   return false;
    		   }
   				
    	   } catch (Exception e)
    	   {
   			e.printStackTrace();
   			logger.log(LogStatus.FAIL,  "Failed to compare strings due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
    	   }
    	   return false;
       }

     /**
      * This method is useful for clicking Java Script enabled elements 
      * @author k.narasimha.swamy
      * @param driver
      * @param element
      * @return status[ boolean type]
      */
       public boolean clickByJavascriptExecutor(ExtentTest logger,WebDriver driver,WebElement element)
       {      
    	   try
    	   {
                    JavascriptExecutor executr = (JavascriptExecutor) driver;
                    executr.executeScript("arguments[0].click();", element);
                    logger.log(LogStatus.PASS,  "Clicking WebElement by using JavaScriptExecutor success");
                    return true;
           }catch (Exception e)
    	   {
   				e.printStackTrace();
   				logger.log(LogStatus.FAIL,  "Failed to click on web element due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
           }
           return false;
       }
    
       /**
        * This method will take print error Message and Screen Shot and also
        * screenShot will attached to report
        * @param logger
        * @param exception
        * @param driver
        * @param fileName
        */
    public void screenShotAndErrorMsg(ExtentTest logger,Exception exception,WebDriver driver,String fileName)
    {
		
    	exception.printStackTrace();
		screenShotFileName = screenShotPath+fileName+"_"+dateFormat.format(date)+".jpg";
		captureScreenShot(logger,driver, screenShotFileName);
		
		logger.log(LogStatus.FAIL, "HTML", "Failed due to <b style='color:red'> "+exception.getClass()+"<br>"+exception.getMessage()+" </b>");
		logger.log(LogStatus.INFO, "For reference Snapshot below: " + logger.addScreenCapture(screenShotFileName));
    }
       
    
  //Verifies a list of elements on a whole -Pavithran
  	public boolean verifyListOfElementsPresent(ExtentTest logger, WebElement[] ElementsList)
  	{
  	
  		Boolean status[] = new Boolean[ElementsList.length];
  		try{
  			logger.log(LogStatus.PASS, "Verifying the given list of elements are displayed" );
	  		for (int i = 0; i < ElementsList.length; i++) {
	  			if (ElementsList[i].isDisplayed()) {
	  				logger.log(LogStatus.PASS, ElementsList[i]+"  is displayed" );
	              	
	              	status[i] = true;
	              }else{
	              	
	              	logger.log(LogStatus.FAIL, ElementsList[i]+"  is not displayed" );
	              	status[i] = false;
	              }
	
	  		}
	  		for(int i=0;i<status.length;i++)
	  		{
	  			
	  			if(status[i] == false){
	  				
	  				return false;
	  			}
	  		}
	  		
  		}catch (Exception e)
 	  {
  			//e.printStackTrace();
			logger.log(LogStatus.FAIL,  "Unable to verifyListOfElementsPresent <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
			return false;
        }
  		
  		return true;
  		
  	}
  	
    //Verifies a list of elements on a whole -Pavithran
    public boolean verifyListOfElementsDisabled(ExtentTest logger, WebElement[] ElementsList){
    
           Boolean status[] = new Boolean[ElementsList.length];
           try{
	           for (int i = 0; i < ElementsList.length; i++) {
	               try{
	            	   if (ElementsList[i].isEnabled()) {
	               
	            	   try{
		          			if(ElementsList[i].getAttribute("readonly").equals("true")){
		          				logger.log(LogStatus.PASS, ElementsList[i]+"  is disabled");
		          				System.out.println(ElementsList[i]+"  is disabled" );
		          				status[i] = true;
		          			}
		          			else{
		          				logger.log(LogStatus.FAIL, ElementsList[i]+"  is not disabled");
		     		           
		 	            	   System.out.println(ElementsList[i]+"  is not disabled" );
		 		           
		 	            	   status[i] = false;
		          			}
	            	   }catch(Exception e){
	            		   logger.log(LogStatus.FAIL, ElementsList[i]+"  is not disabled");
	     		           
	 	            	   System.out.println(ElementsList[i]+"  is not disabled" );
	 		           
	 	            	   status[i] = false;
	            	   }
	          			
	            	   
			         }else{
			        	 logger.log(LogStatus.PASS, ElementsList[i]+"  is disabled");
			           System.out.println(ElementsList[i]+"  is disabled" );
			           status[i] = true;
			         }
	               }catch(Exception e){
	            	   logger.log(LogStatus.FAIL, ElementsList[i]+"  is not present");
     		           
 	            	   status[i] = false;
	               }
	
	           }
           }catch(Exception e){
                  e.printStackTrace();
                  logger.log(LogStatus.FAIL,  "Failed to verifyListOfElementsDisabled </b> due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
                  
           }
           
           for(int i=0;i<status.length;i++)
           {
                  
                  if(status[i] == false){
                        
                        return false;
                  }
           }
           
           return true;
           
    }
  	
 	//Verifies a list of elements on a whole -Pavithran
  	public boolean verifyListOfElementsEnabled(ExtentTest logger, WebElement[] ElementsList){
  	
  		Boolean status[] = new Boolean[ElementsList.length];
  		try{
  		for (int i = 0; i < ElementsList.length; i++) {
  			if (ElementsList[i].isEnabled()) {
              	
              	logger.log(LogStatus.PASS,  ElementsList[i]+"  is Enabled");
              	status[i] = true;
              }else{
              	
              	logger.log(LogStatus.FAIL,  ElementsList[i]+"  is not Enabled");
              	status[i] = false;
              }

  		}
  		for(int i=0;i<status.length;i++)
  		{
  			
  			if(status[i] == false){
  				
  				return false;
  			}
  		}
  		}catch (Exception e)
 	   {
				e.printStackTrace();
				logger.log(LogStatus.FAIL,  "Unable to verifyListOfElementsEnabledd  due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
				return false;
        }
  		
  		return true;
  		
  	}

      //verify the status of an element -Pavithran
  	public  Boolean verifyElementEnabled(ExtentTest logger, WebElement object)
  	{ 
  	    try{
  	    	if(object.isEnabled())
  	    	{
  	    		logger.log(LogStatus.PASS, object+ " is Enabled ");
  	    		
  	    		return true;
  	    	}
  	    	else{
  	    		logger.log(LogStatus.FAIL, object+ " is Disabled");
  	    		
  	    		return false;
  	    	}
  	    	
  	      }catch (Exception e)
 	   {
				e.printStackTrace();
				logger.log(LogStatus.FAIL,  "Unable to verifyElementEnabled due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
        }
  	    
  	    return null;
  		
  	}

      //verify alert message -Pavithran
  	public boolean verifyAlertMessage(ExtentTest logger, WebDriver driver, String msg){
  		try{
  			if(driver.switchTo().alert().getText().trim().equalsIgnoreCase(msg.trim())){
  				System.out.println("Expected Alert message is present ");
  				logger.log(LogStatus.PASS,  "Expected Alert message is present");
  				return true;
  			}
  			else{
  				System.out.println("Expected Alert message is not present ");
  				logger.log(LogStatus.FAIL,  "Expected Alert message is not present");
  				showScreenShotInLogger(logger, driver, "verifyAlertMessage-Failed");
  				return false;
  			}
  		}catch (Exception e)
 	   {
				e.printStackTrace();
				logger.log(LogStatus.FAIL,  "Unable to verifyAlertMessage due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
        }
  		System.out.println("Unable to verify alert message ");
  		return false;
  	}
  	
    //verify individual elements in a alert message -Pavithran
	public boolean verifyElementsPresentInAlertMessage(ExtentTest logger, WebDriver driver, String elements){
		try{
			String expElements[] = elements.split("\\|");
			Boolean status[] = new Boolean[expElements.length];
			for(int i=0; i<expElements.length; i++){
				if(driver.switchTo().alert().getText().trim().toLowerCase().contains(expElements[i].trim().toLowerCase())){
					logger.log(LogStatus.PASS, "Expected element "+expElements[i]+" is present in the alert text");
					System.out.println("Expected element "+expElements[i]+" is present in Alert message");
					status[i] = true;
				}else{
					logger.log(LogStatus.FAIL, "Expected element "+expElements[i]+" is not present in the alert text");
					System.out.println("Expected element "+expElements[i]+" is present in the alert text");
					status[i] = false;
				}
			}
			for(int i=0;i<status.length;i++)
	  		{
	  			if(status[i] == false){
	  			return false;
	  			}
	  		}
		}catch (Exception e){
				e.printStackTrace();
				logger.log(LogStatus.FAIL,  "Unable to verifyAlertMessage due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
				return false;
		}
		
		logger.log(LogStatus.PASS, "All expected elements are present in the alert text");
		return true;
	}
	
  	//accept alert -Pavithran
  	public void manageAlert(ExtentTest logger, WebDriver driver, String operation){
  		try{
  			if(operation.equalsIgnoreCase("accept")){
  			driver.switchTo().alert().accept();
  			logger.log(LogStatus.PASS,  "alert accepted successfully");
  			}
  			else if(operation.equalsIgnoreCase("dismiss")){
  				driver.switchTo().alert().dismiss();
  				logger.log(LogStatus.PASS,  "alert dismissed successfully");
  			}
  			else{
  				logger.log(LogStatus.FAIL,  "Invalid String Input");
  			}
  		}catch (Exception e)
 	   {
				e.printStackTrace();
				logger.log(LogStatus.FAIL,  "Unable to manageAlert  due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
        }
  		
  	}
  	
  
  	    //Pavithran
  	  	public void handleUnexpectedAlertIfAny(ExtentTest logger, WebDriver driver){
  	    		try 
  	    	    { 
  	    	        String alert = driver.switchTo().alert().getText(); 
  	    	      logger.log(LogStatus.FAIL,  "An UNexpected Alert displayed. Text= "+alert);
  	    	      manageAlert(logger, driver, "accept");
  	    	     
  	    	    }   // try 
  	    	    catch (NoAlertPresentException Ex) 
  	    	    { 
  	    	    	logger.log(LogStatus.PASS,  " No Unhandled Alert is present");
  	    	      
  	    	    }  
  	    	} 
  	

  	
  	public boolean isAlertPresent(ExtentTest logger, WebDriver driver){
  		try 
  	    { 
  	        driver.switchTo().alert(); 
  	      logger.log(LogStatus.PASS,  "Alert is displayed");
  	        return true; 
  	    }   // try 
  	    catch (NoAlertPresentException Ex) 
  	    { 
  	    	logger.log(LogStatus.INFO,  " No Alert is displayed");
  	        return false; 
  	    }  
  	}

     // Created by : Raghavendra YT
      public void waitTillElementIsVisible(ExtentTest logger, WebDriver driver, WebElement we){              
        try {
            WebDriverWait wait=new WebDriverWait(driver,60);
            System.out.println("waiting till visibility of "+we);
            wait.until(ExpectedConditions.visibilityOf(we));
            System.out.println("Element Visible "+we);
      } catch (Exception e)
 	   {
				e.printStackTrace();
				logger.log(LogStatus.FAIL,  "Unable to waitTillElementIsVisible  due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
        }  
            
      }

      //verify the value of an element to a string -Pavithran
      public boolean verifyElementValue(ExtentTest logger, WebElement we, String expValue){
      	
      	try{
      		if(we.getAttribute("value").trim().equalsIgnoreCase(expValue.trim())){
      			logger.log(LogStatus.PASS,"Expected value "+expValue+"is present in the object "+we);
      			
      			return true;
      		}else{
      			logger.log(LogStatus.FAIL,"Expected value "+expValue+"is not present in the object "+we+". Actual is -"+we.getAttribute("value"));
      			
      			return false;
      		}
      		
      	}catch (Exception e)
 	   {
				e.printStackTrace();
				logger.log(LogStatus.FAIL,  "Unable to verifyElementValue due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
        }
      	System.out.println("Unable to verify value present in the object "+we);
      	return false;
      }
      
   // Verify the value selected in a dropdown -Pavithran
     	public boolean verifyDropDownSelection(ExtentTest logger, WebElement we, String value) {
     		try {
     			String actual = new Select(we).getFirstSelectedOption().getText();
     			String expected = value;

     			if (actual.toLowerCase().trim().contains(expected.toLowerCase().trim())) {
     				logger.log(LogStatus.PASS, "Drop down Selection <b>verified</b>");
     				return true;
     			} else {
     				logger.log(LogStatus.FAIL, "Actual : "+actual+"Expected : "+expected+", Drop down Selection <b>Not verified</b>");
     				return false;
     			}
     		} catch (Exception e) {
     			e.printStackTrace();
     			logger.log(LogStatus.FAIL, "Failed:  to verify dropdown Selection due to <b style='color:red'>"
     					+ e.getClass() + "<br>" + e.getMessage() + "</b>");
     			return false;
     		}
     	}
      
      
    //Verifies if a list of elements is not present- Ritu
    	public boolean verifyListOfElementsNotPresent(ExtentTest logger, WebElement[] ElementsList)
    	{
    	
    		Boolean status[] = new Boolean[ElementsList.length];
    		try{
    			logger.log(LogStatus.PASS, "Verifying the given values" );
    		for (int i = 0; i < ElementsList.length; i++) {
    			if (!isNotDisplayed(logger, ElementsList[i])) {
    				logger.log(LogStatus.FAIL, ElementsList[i]+"  is displayed" );
                	//System.out.println(ElementsList[i]+"  is displayed" );
                	status[i] = true;
                }else{
                	//System.out.println(ElementsList[i]+"  is not displayed" );
                	logger.log(LogStatus.PASS, ElementsList[i]+"  is not displayed as expected" );
                	status[i] = false;
                }

    		}
    		for(int i=0;i<status.length;i++)
    		{
    			
    			if(status[i] == false){
    				
    				return false;
    			}
    		}
    		
    		}catch (Exception e){
    			//e.printStackTrace();
  			logger.log(LogStatus.PASS,  "The elements are not displayed");
  			return false;
          }
    		
    		return true;
    		
    	}
    	
    	//Ritu
    	public  boolean verifyElementNotPresentByXpath(ExtentTest logger, WebDriver driver, WebElement object)
    	{ 
    	    try{
    	    	if(object.isDisplayed())
    	    	{
    	    		System.out.println("The Object is present "+object.getText());
    	    		logger.log(LogStatus.FAIL,  "WebElement is displayed : "+object.getText());
    	    		showScreenShotInLogger(logger, driver, "verifyElementNotPresentByXpath-Failed");
    	    		return true;
    	    	}		
    	      }catch(Exception e)
    	    	{
    				//e.printStackTrace();
    				logger.log(LogStatus.PASS,  "Element is not displayed as expected");
    	        }
    		return false;
    	}

    	//To check a few options(a part of all options) present in the dropdown
    	  public boolean verifyFewOptionsInDropdown(ExtentTest logger,WebElement object, String optionsList)
    	    {
    	    	try 
    	    	{
    	    		List<WebElement> droplistContents = object.findElements(By.tagName("option"));
    	    		
    	    		String valuesList[] = optionsList.split("\\|");
    	    		logger.log(LogStatus.PASS,  "Verifying options avaliable in Dropdown list</b> "+object);
    	    		for (int i = 0; i < droplistContents.size(); i++) 
    	    		{
    	    			if (!droplistContents.get(i).getText().contains(valuesList[i])) {
    	    				logger.log(LogStatus.FAIL,  "Option "+valuesList[i]+" is not avaliable in Dropdown list</b>");
    	    				return false;
    	    			}
    	    		}    
    	    		
    	    	} catch (Exception e) {
    				e.printStackTrace();
    				logger.log(LogStatus.PASS,  "Failed:  to verify dropdown list values due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
    	    		return false;
    	    	}
    	    	return true;
    	    }
    	    
    	    //Sprint 3
    	    public void selectOptionFromRightClick(ExtentTest logger,WebDriver driver, WebElement we, WebElement option){
    	    	Actions oAction = new Actions(driver);
    	    	oAction.moveToElement(we);
    	    	oAction.contextClick(we).build().perform();  /* this will perform right click */
    	    	//WebElement elementOption = driver.findElement(By.linkText("Forward")); /*This will select menu after right click */
    	    	//elementOption.click();
    	    	option.click();
    	    }
    	  	
    	  	
    	
    		
    	    /** Select any Drop down option other than given
    	     * @author pavithran.rajendran
    	     * @param object
    	     * @param optionsList
    	     * @return
    	     **/
    	    public boolean selectAnyDropdownOptionOtherThanGiven(ExtentTest logger,WebElement object, String optionsList)
    	    {
    	    	try 
    	    	{
    	    		List<WebElement> droplistContents = object.findElements(By.tagName("option"));
    	    		Select dropList = new Select(object);
    	    		String valuesList[] = optionsList.split("\\|");
    	    		
    	    		for (int i = 1; i < droplistContents.size(); i++) 
    	    		{
    	    			for(int j=0; j<valuesList.length; j++){
    	 	   			if (!droplistContents.get(i).getText().toString().equalsIgnoreCase(valuesList[j])) {
    	 	   				dropList.selectByVisibleText(droplistContents.get(i).getText());
    	 	   				logger.log(LogStatus.PASS,  "Option <b>"+droplistContents.get(i).getText()+" is selected from Dropdown list</b>");
    	 	   				return true;
    	 	   			}
    	    			}
    	    		}    
    	    		logger.log(LogStatus.FAIL,  "No Options other than the given ones are preesnt in the dropdown");
    	    		return false;
    	    	} catch (Exception e) {
    	 			e.printStackTrace();
    	 			logger.log(LogStatus.FAIL,  "Failed:  to selectAnyDropdownOptionOtherThanGiven due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
    	    		return false;
    	    	}

    	    }
    	    
    	    // Created by : Raghavendra YT
    	   	public void clickOn(ExtentTest logger,WebElement we){
    	           try {
    	        	   logger.log(LogStatus.PASS, "Clicking on :<b>"+ we.getText() +"</b>");
    	        	   we.click();        
    	         } catch (Exception e) {
    	               e.printStackTrace();
    	               
    	               logger.log(LogStatus.FAIL,  "Failed </b> due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
    	         }		
    	   	}

    	   	
    	   	
    	       // Created by : Raghavendra YT
    	   	public void setText(ExtentTest logger,WebElement we, String data){
    	           try {
    	        	   we.clear();
    	       		we.sendKeys(data);    
    	       		logger.log(LogStatus.PASS, "Inputting text: <b>"+data+"</b>");
    	         } catch (Exception e) {
    	               e.printStackTrace();
    	               logger.log(LogStatus.FAIL,  "Failed </b> due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
    	         }
    	   	}
    	       
    	       // Created by : Raghavendra YT
    	   	public void setTextWithEnter(ExtentTest logger,WebElement we, String data){
    	        try{
    	        	we.clear();
    	       		we.sendKeys(data+Keys.ENTER);
    	       		//pause(logger, ".5");
    	       		//we.sendKeys(Keys.ENTER);
    	       		logger.log(LogStatus.PASS, " Inputting <b>"+ data +"</b> and pressing ENTER");
    	         } catch (Exception e) {
    	               e.printStackTrace();
    	               logger.log(LogStatus.FAIL,  "Failed  to input value '"+data+"' with enter </b> due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
    	         }
    	   	}
    	   	
    	   	//Pavithran
    		public void clearTextField(ExtentTest logger,WebElement we){
 	         try {
 	        	   we.clear();
 	       			logger.log(LogStatus.PASS, " Clearing the field--"+ we);
 	         } catch (Exception e) {
 	               e.printStackTrace();
 	               logger.log(LogStatus.FAIL,  "Failed  to clear field '"+we+"' </b> due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
 	         }
 	   	}
    	   	
    	   	//Pavithran
    	   	public void clickAllElementsFromList(ExtentTest logger, List<WebElement> list){
    			try {
    				//int i=0;
    				logger.log(LogStatus.INFO, "Expanding all the elements under the list --"+list);
    				for(WebElement btns:list)
    				{
    					try {
    						btns.click();
    						//logger.log(LogStatus.INFO, "Link "+i+" clicked");
    					} catch (Exception e) {
    						// TODO Auto-generated catch block
    						//e.printStackTrace();
    					}
    					//i++;
    				}
    			} catch (Exception e) {

    				e.printStackTrace();
    				logger.log(LogStatus.FAIL,  "Failed To clickAllElementsFromList due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
    			}
    		}
    	   	
    	
    	   	//Pavithran
    	   	public  String getAbsoluteXPath(WebElement element, WebDriver driver)
    	    {
    	        return (String) ((JavascriptExecutor) driver).executeScript(
    	                "function absoluteXPath(element) {"+
    	                        "var comp, comps = [];"+
    	                        "var parent = null;"+
    	                        "var xpath = '';"+
    	                        "var getPos = function(element) {"+
    	                        "var position = 1, curNode;"+
    	                        "if (element.nodeType == Node.ATTRIBUTE_NODE) {"+
    	                        "return null;"+
    	                        "}"+
    	                        "for (curNode = element.previousSibling; curNode; curNode = curNode.previousSibling)"+
    	                        "{"+
    	                        "if (curNode.nodeName == element.nodeName) {"+
    	                        "++position;"+
    	                        "}"+
    	                        "}"+
    	                        "return position;"+
    	                        "};"+

    	    "if (element instanceof Document) {"+
    	    "return '/';"+
    	    "}"+

    	    "for (; element && !(element instanceof Document); element = element.nodeType ==Node.ATTRIBUTE_NODE ? element.ownerElement : element.parentNode) {"+
    	    "comp = comps[comps.length] = {};"+
    	    "switch (element.nodeType) {"+
    	    "case Node.TEXT_NODE:"+
    	    "comp.name = 'text()';"+
    	    "break;"+
    	    "case Node.ATTRIBUTE_NODE:"+
    	    "comp.name = '@' + element.nodeName;"+
    	    "break;"+
    	    "case Node.PROCESSING_INSTRUCTION_NODE:"+
    	    "comp.name = 'processing-instruction()';"+
    	    "break;"+
    	    "case Node.COMMENT_NODE:"+
    	    "comp.name = 'comment()';"+
    	    "break;"+
    	    "case Node.ELEMENT_NODE:"+
    	    "comp.name = element.nodeName;"+
    	    "break;"+
    	    "}"+
    	    "comp.position = getPos(element);"+
    	    "}"+

    	    "for (var i = comps.length - 1; i >= 0; i--) {"+
    	    "comp = comps[i];"+
    	    "xpath += '/' + comp.name.toLowerCase();"+
    	    "if (comp.position !== null) {"+
    	    "xpath += '[' + comp.position + ']';"+
    	    "}"+
    	    "}"+

    	    "return xpath;"+

    	"} return absoluteXPath(arguments[0]);", element);
        }
    
	  	//Pavithran
	   	public String getElementLabel(ExtentTest logger, WebElement we, WebDriver driver){
			try {
				String label;
				if(we.getText()==null){
    				String xpath=getAbsoluteXPath(we, driver);
    				label=driver.findElement(ByXPath.xpath("("+xpath+"/preceding::*//title)[1]")).getText();
				}else
					label=we.getText();
				
				return label;
			} catch (Exception e) {

				e.printStackTrace();
				logger.log(LogStatus.FAIL,  "Failed To getElementLabel due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
			}
			return null;
		}
	   	  	
	   	public void scrollToElement(ExtentTest logger, WebElement element, WebDriver driver) {
			try{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			pause(logger, "2"); 
			element.getLocation();
	   		
			/*driver.manage().window().setPosition(element.getLocation());
			logger.log(LogStatus.INFO,  "Scrolled to the given element");*/
			}catch (Exception e) {

				e.printStackTrace();
				logger.log(LogStatus.FAIL,  "Failed To scrollToElement due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
			}
		} 
	   	
	   	public void doubleClickOnElement(ExtentTest logger, WebElement element, WebDriver driver) {
				try{
					Actions action = new Actions(driver);
					action.doubleClick(element).build().perform();
					logger.log(LogStatus.INFO,  "Double clicked on element-"+element);
				}catch (Exception e) {

					e.printStackTrace();
					logger.log(LogStatus.FAIL,  "Failed To doubleClickOnElement due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
				}
			} 
	   	
	   	//Clicks on element only if the element is visible.
	   	//Pavithran
		public void optionalClick(ExtentTest logger, WebElement element) {
			try{
				logger.log(LogStatus.INFO,  "Performing Optional Click on elementt-"+element);
				if(isNotDisplayed(logger, element)){
					logger.log(LogStatus.INFO,  "The element is not visible. Hence Skipping the step to click that element");
				}else{
					logger.log(LogStatus.PASS,  "The element is visible. clicking that element");
					clickOn(logger, element);
				}
			}catch (Exception e) {

				e.printStackTrace();
				logger.log(LogStatus.FAIL,  "Failed To optionalClick due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
			}
		} 
		
		/** Verify if a given option is present in the dropdown field
	     * @author pavithran.rajendran
	     * @param object
	     * @param option
	     * @return
	     **/
	    public void verifyIfOptionIsPresentInDropDown(ExtentTest logger,WebElement object, String option)
	    {
	    	try 
	    	{
	    		Select dropList = new Select(object);
	    		
	    		List<WebElement> allOptions=dropList.getOptions();
	    		
	    		for(WebElement i:allOptions){
		    		if(i.getText().toLowerCase().contains(option.toLowerCase())){
		    			logger.log(LogStatus.PASS,  "Required Options-"+option+" is present in the given dropdown-"+object);
		    			return;
		    		}
		    	}
	    		logger.log(LogStatus.FAIL,  "Required Options -"+option+" is not present in the given dropdown-"+object);
	    	} catch (Exception e) {
	 			e.printStackTrace();
	 			logger.log(LogStatus.FAIL,  "Failed:  to verifyIfOptionIsPresentInDropDown due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
	    		
	    	}

	    }
	    
	    //verify if an text field element is not filled -Pavithran
      public boolean verifyThatTextFieldIsNotFilled(ExtentTest logger, WebDriver driver,  WebElement we){
      	
      	try{
      		String actual=getElementValue(logger, we);
      		if(actual.equals("")){
      			logger.log(LogStatus.PASS,"Expected text field is not filled-"+we);
      			
      			return true;
      		}else{
      			logger.log(LogStatus.FAIL,"Expected text field-"+we+" is not left unfilled. The value present in it is-"+actual);
      			showScreenShotInLogger(logger, driver, "verifyThatTextFieldIsNotFilled-Failed");
      			return false;
      		}
      		
      	}catch (Exception e)
 	   {
				e.printStackTrace();
				logger.log(LogStatus.FAIL,  "Unable to verifyElementValue due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
				return false;
        }
      	
      }
      
      //verify if an text field element is not filled -Pavithran
      public boolean verifyThatTextFieldIsFilled(ExtentTest logger, WebDriver driver, WebElement we){
      	
      	try{
      		String actual=getElementValue(logger, we);
      		if(actual==null){
      			logger.log(LogStatus.FAIL,"Expected text field is not filled-"+we);
      			showScreenShotInLogger(logger, driver, "verifyThatTextFieldIsFilled-Failed");
      			return false;
      		}else{
      			logger.log(LogStatus.PASS,"Expected text field-"+we+" is not left unfilled. The value present in it is-"+actual);
      			
      			return true;
      		}
      		
      	}catch (Exception e)
 	   {
				e.printStackTrace();
				logger.log(LogStatus.FAIL,  "Unable to verifyThatTextFieldIsFilled due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
				return false;
        }
      	
      }
      
      //Pavithran
      public void showScreenShotInLogger(ExtentTest logger, WebDriver driver,String fileName)
      {
  		
      	screenShotFileName = screenShotPath+fileName+"_"+dateFormat.format(date)+".jpg";
  		captureScreenShot(logger,driver, screenShotFileName);
  		
  		logger.log(LogStatus.INFO, "For reference Snapshot below: " + logger.addScreenCapture(screenShotFileName));
      }
      
      
      
      
      public void scrollingToElementofAPage(ExtentTest logger, WebElement element, WebDriver driver) {
	  		logger.log(LogStatus.PASS, "Scrolling the window till the given element is visible"+element);
	  		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	  		pause(logger, "3");
	  	}
	      
	      
//Testing	   
}
