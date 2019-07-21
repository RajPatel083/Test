package com.serviceNow.pages;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.serviceNow.util.FrameHelper;
import com.thoughtworks.selenium.Wait;
import com.thoughtworks.selenium.Wait.WaitTimedOutException;

@SuppressWarnings("deprecation")
public class SupportPortal extends CommonObjectsPage{

	public SupportPortal(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	FluentWait<WebDriver> Fwait = (FluentWait<WebDriver>) new FluentWait<WebDriver> (driver)    
		    .withTimeout(30, TimeUnit.SECONDS)    
		    .pollingEvery(200, TimeUnit.MILLISECONDS)   
		    .ignoring(NoSuchElementException.class);
		    
		    
		    
		    /*until(new Function<WebDriver, WebElement>() {
		    	public WebElement apply(WebDriver driver) {
		    	return driver.findElement(By.id("foo")); }
		    	}) ;
	*/
	
	@FindBy(xpath=".//a[contains(text(),'My Stuff')]") public WebElement lnk_myStuff;
	@FindBy(xpath=".//*[@class='fa fa-th-list fa-2x']") public WebElement lnk_ticketsview;
	@FindBy(xpath=".//a[@title='Card View']") public WebElement lnk_cardView;
	@FindBy(xpath=".//a[@title='List View']") public WebElement lnk_listView;
	
	//@FindBy(xpath=".//input[@class='form-control'][contains(@id,'text')]") public WebElement txt_reqnumber;
	@FindBy(xpath=".//a[starts-with(text(),'Open')]") public WebElement lnk_open;
	
	@FindBy(xpath=".//a[starts-with(text(),'Contributor Open')]") public WebElement lnk_contributorOpen;
	
	@FindBy(xpath=".//a[contains(text(),'Closed')]") public WebElement lnk_closed;
	
	
	@FindBy(xpath="(.//a[@class='btn btn-icon table-btn-lg icon-info list_popup'])[1]") public WebElement resultlnk; //clicking on first element in the search result
	

	  

		
		//@FindBy(xpath=".//select[contains(@id,'facilities_request.state')]") public WebElement drpDn_reqState;
	    @FindBy(xpath="//label[text()='State']/following-sibling::*[1]//span[starts-with(@id,'select')]") public WebElement drpDn_reqState;
	  
	    
	    
	  
	    @FindBy(xpath=".//textarea[@id='sc_req_item.comments']") public WebElement txt_additionalComments;
	    //@FindBy(xpath=".//textarea[@id='sp_formfield_comments']") public WebElement txt_additionalComments;
	    
	    
	    @FindBy(xpath=".//textarea[@id='post-input']") public WebElement txt_postComments;
	    
	    @FindBy(xpath=".//input[@value='Post']") public WebElement btn_post;
	    
	    @FindBy(xpath="//button[@title='Add attachment']") public WebElement btn_attach;
	    //@FindBy(xpath="//button[@id='sc_attachment_button']") public WebElement btn_attach;
	  
	    
	    @FindBy(xpath="//h2[text()='Attachments']") public WebElement header_attachments;
	    //@FindBy(xpath="//h4[@id='attachment_title']") public WebElement header_attachments;
	  
	    //@FindBy(xpath="//*[@id='adminMenu']") public WebElement btn_requestMenu;
	    @FindBy(xpath="//h2//span[contains(text(),'Requested')]") public WebElement btn_requestMenu;
	    
	    //@FindBy(xpath="//*[text()='Save']") public WebElement lnk_save;
	    @FindBy(xpath="//div[text()='Save']") public WebElement lnk_save;
	    
	    @FindBy(xpath="//button[@id='save_catalog_Items']") public WebElement btn_save;
	    @FindBy(xpath="//th//div[contains(text(),'Number')]") public WebElement column_number;
	 
	    //handover
	    @FindBy(xpath="//input[@id='attachFile']") public WebElement btn_browse;
	   
	    @FindBy (xpath=".//*[@id='attachment_title']/preceding-sibling::button") public WebElement btn_closeAttachment;
	    
		@FindBy (xpath="//input[@id='download_all_button']") public WebElement btn_downloadAllAttachments;
	  
		@FindBy(xpath="//button[text()='Contribute']") public WebElement btn_contribute;
		
		@FindBy(xpath="//span[contains(text(),'Recommendation')]/ancestor::div[2]//select") public WebElement drpDn_recommendation;
		
		@FindBy(xpath="//button[@id='submit_button']") public WebElement btn_submitContribution;
	    
		@FindBy(xpath="//span[contains(text(),'Notes')]/ancestor::div[2]//textarea") public WebElement txt_contributionNotes;
		
		@FindBy(xpath="//label[contains(text(),'Contribution Completed')]/ancestor::div[2]//input[@value='true']") public WebElement chkBx_contributionCompletedChecked;
		
		@FindBy(xpath="//label[contains(text(),'Contribution Completed')]") public WebElement chkBx_contributionCompleted;
		
		//Case creation
		@FindBy(xpath="//div[contains(text(),'Workplace and Office Services')]") public WebElement lnk_workplaceAndOfficeServices;
		@FindBy(xpath="//div[contains(text(),'Request Office Services')]") public WebElement lnk_requestOfficeServices;
		
		@FindBy(xpath="//*[contains(text(),'Opened for')]/ancestor::div[2]//input[not(@type='hidden')]") public WebElement txt_openedFor;
		


		
		
		
		
		@FindBy(xpath="//*[contains(text(), 'has been submitted')]") public WebElement msg_caseSubmitted; 
		 
		@FindBy(xpath="//*[contains(text(),'Opened By')]/ancestor::div[2]//input[not(@type='hidden')]") public WebElement txt_openedBy;
		
		@FindBy(xpath=".//button[@id='submit_button']") public WebElement btn_submit;
		
		@FindBy(xpath=".//a[contains(text(),'FCR')]") public WebElement lnk_requestnumber;
		
		@FindBy(xpath="//div[@id='contact_type']//select") public WebElement drpDn_contactType;
		
		    
		
		public void scrollToTop(ExtentTest logger, WebDriver driver){
		try 
	    { 
			
	      logger.log(LogStatus.INFO,  "Running Method for Scrolling the window up to HOME");
	      FrameHelper.switchToDefaultFrame(logger, driver);
	    
	      util.scrollingToElementofAPage(logger, lnk_open, driver);
	      logger.log(LogStatus.PASS,  "Scrolling the window up to HOME- ran successfully");
	      frameHelper.switchToFrame(logger, driver, gsft_main);
	    }   // try 
	    catch (Exception e) 
	    { 
	    	e.printStackTrace();
			logger.log(LogStatus.FAIL,  "Failed:  to scrollToTop due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
	    }  
	}
	
	
	
	

	


	
	
	//Use this method to find the RITM Number just after creating the request
		public String findRequestItemNumberCreated(ExtentTest logger){
			String RITMNumber= null;
			try{
				logger.log(LogStatus.INFO, "Getting the RITM of the request being created.");
				util.waitTillElementIsVisible(logger, driver, msg_caseSubmitted);
				String[] a=msg_caseSubmitted.getText().split(" ");
				RITMNumber=a[2];
				
				logger.log(LogStatus.PASS, "Request Number being created is <b>"+RITMNumber+"</b> ");
				return RITMNumber;
			}catch (Exception e){
				e.printStackTrace();
				util.screenShotAndErrorMsg(logger, e, driver, "findRequestItemNumberCreated");
				logger.log(LogStatus.FAIL,  "Failed to find the RequestItem NUmber created  due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
			}
			return RITMNumber;
			}
	
	
	public  boolean checkIfRequestPresentInCardView(ExtentTest logger,String reqNo)
	{ 
	    try{
	    	util.clickOn(logger, lnk_cardView);
			util.waitTillElementIsVisible(logger, driver, lbl_anyRequestedItem);
			
	    		if(driver.findElement(ByXPath.xpath("//*[contains(text(),'"+reqNo+"')]/ancestor::div[5]//a")).isDisplayed()){
	    			logger.log(LogStatus.PASS,  "The request is present in the card view");
	    			return true;
	    		}
	    		else{
	    			logger.log(LogStatus.FAIL,  "The request is not present in the card view");
	    			util.showScreenShotInLogger(logger, driver, "checkIfRequestPresentInCardView-Failed");
	    			return false;
	    		}
	    	
	      }catch(Exception e)
	    	{
	    	 logger.log(LogStatus.FAIL,  "The request is not present in the card view");
  			return false;
	        }
	    
	}
	
	public  boolean checkIfRequestPresentInListView(ExtentTest logger,String reqNo)
	{ 
	    try{
	    	util.clickOn(logger, lnk_listView);
			util.waitTillElementIsVisible(logger, driver, lbl_anyRequestedItem);
			
	    		sortColumnByDescendingOrder(logger, "Number");
	    		if(driver.findElement(ByXPath.xpath("//*[contains(@aria-label,'"+reqNo+"')]")).isDisplayed()){
	    			logger.log(LogStatus.PASS,  "The request is present in the List view");
	    			return true;
	    		}
	    		else{
	    			logger.log(LogStatus.FAIL,  "The request is not present in the List view");
	    			util.showScreenShotInLogger(logger, driver, "checkIfRequestPresentInListView-Failed");
	    			return false;
	    		}
	    	
	      }catch(Exception e)
	    	{
	    	 logger.log(LogStatus.FAIL,  "The request is not present in the List view");
  			return false;
	        }
	    
	}
	
	public  void sortColumnByDescendingOrder(ExtentTest logger,String columnName)
	{ 
	    try{
	    	util.clickOn(logger, column_number);
	    	try{
	    		//driver.findElement(ByXPath.xpath("//div[contains(@aria-label,'"+columnName+"')]/following-sibling::i[1][contains(@aria-label,'Ascending')]")).click();
	    		driver.findElement(ByXPath.xpath("//th//div[contains(text(),'Number')]/following-sibling::i[contains(@class,'up')]")).click();
	    		util.pause(logger, "3");
	    	}catch(Exception e){
	    		//if(driver.findElement(ByXPath.xpath("//div[contains(@aria-label,'"+columnName+"')]/following-sibling::i[1][contains(@aria-label,'Descending')]")).isDisplayed())
	    		if(driver.findElement(ByXPath.xpath("//th//div[contains(text(),'Number')]/following-sibling::i[contains(@class,'down')]")).isDisplayed())
	    			logger.log(LogStatus.PASS,  "The list is already sorted descending with -"+columnName);
	    		else
	    			logger.log(LogStatus.FAIL,  "Unable to sort the list descending with -"+columnName);
	    	}
	    		
	    	
	      }catch(Exception e)
	    	{
	    	 logger.log(LogStatus.FAIL,  "The list is not sorted successfully due to  <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
  			
	        }
	    
	}
	
	
	
	public  void selectRequestFromCardView(ExtentTest logger,String reqNo)
	{ 
	    try{
	    	
    		driver.findElement(ByXPath.xpath("//*[contains(text(),'"+reqNo+"')]/ancestor::div[5]//a")).click();
    		logger.log(LogStatus.PASS,  "Request link clicked successfully");
    		util.pause(logger, "3");
    		//frameHelper.switchToFrame(logger, driver, gsft_main);
    		util.waitTillElementIsVisible(logger, driver, drpDn_reqState);
    		logger.log(LogStatus.INFO,  "Verifying if the request page is opened");
    		util.verifyElementByXpath(logger, txt_reqnumber);
    		
	    	
	      }catch(Exception e)
	    	{
	    	logger.log(LogStatus.FAIL,  "The request is not present in the card view");
  		
	        }
	    
	}
	

	
	public  void selectRequestFromListView(ExtentTest logger,String reqNo)
	{ 
	    try{
	    	
    		driver.findElement(ByXPath.xpath("//*[contains(@aria-label,'"+reqNo+"')]")).click();
    		logger.log(LogStatus.PASS,  "Request link clicked successfully");
    		util.pause(logger, "3");
    		//frameHelper.switchToFrame(logger, driver, gsft_main);
    		util.waitTillElementIsVisible(logger, driver, drpDn_reqState);
    		logger.log(LogStatus.INFO,  "Verifying if the request page is opened");
    		util.verifyElementByXpath(logger, txt_reqnumber);
    		
	    	
	      }catch(Exception e)
	    	{
	    	logger.log(LogStatus.FAIL,  "The request is not present in the List view");
			util.screenShotAndErrorMsg(logger, e, driver, "checkIfRequestPresentInListView");
	    	 
	        }
	    
	}
	
	public  void verifyState(ExtentTest logger,String state)
	{ 
	    try{
	    	logger.log(LogStatus.INFO, "Verifying the state of the request");
    		if(state.equalsIgnoreCase(util.getSelectedValueFromDropdown(logger, drpDn_reqState)))
    			logger.log(LogStatus.PASS, "State of the request are displayed with expected values-"+state);
			else{
				logger.log(LogStatus.FAIL, "State of the request are not displayed with expected values-"+state+". Actual value is -"+drpDn_reqState.getText());
				util.showScreenShotInLogger(logger, driver, "verifyState-Failed");
			}
			
    		
    }catch(Exception e)
    	{
    	e.printStackTrace();
    	util.screenShotAndErrorMsg(logger, e, driver, "verifyState");
		logger.log(LogStatus.FAIL,  "Failed:  to verify State due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
	
        }
	    
	}
	
	

	
	
	public void attachFile(ExtentTest logger, String fileName){
		try{
			util.waitTillElementIsVisible(logger, driver, btn_attach);
			
			util.clickOn(logger, btn_attach);
			util.pause(logger, "4");
			//AutoIT script to attach file
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\FileAttach.exe"+" \""+System.getProperty("user.dir")+"\\"+fileName+"\"");
			logger.log(LogStatus.INFO,  "autoIT script is completely executed");
			//util.setText(logger, btn_browse, System.getProperty("user.dir")+"\\"+fileName);
		
			util.pause(logger, "5");
			verifyIfIndicatorForAttachmentIsPresent(logger, fileName);
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "attachFile");
			logger.log(LogStatus.FAIL,  "Unable to attachFile  due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
	}
	


	
	public  void provideAdditionalComments(ExtentTest logger, String comments)
	{ 
	    try{
	    	/*util.scrollingToElementofAPage(logger, txt_additionalComments, driver);
	    	util.setText(logger, txt_additionalComments, comments);
		
		//	util.selectOptionFromRightClick(logger, driver, btn_requestMenu, lnk_save);
	    	util.clickOn(logger, btn_save);
			util.pause(logger, "3");
			*/
			//Adding comments under Activity section
			util.setText(logger, txt_postComments,comments);
			util.clickOn(logger, btn_post);
			util.pause(logger, "2");
			logger.log(LogStatus.PASS, "Provided additional comments");
    }catch(Exception e)
    	{
    	  e.printStackTrace();
			logger.log(LogStatus.FAIL,  "Failed:  to verify provide additional comments due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
	
        }
	    
	}
	
	
	
	public boolean OpenRequestFromSelfServicePage(ExtentTest logger, String ReqNo){
		try{
			FrameHelper.switchToDefaultFrame(logger, driver);
			util.waitTillElementIsVisible(logger, driver, lnk_myStuff);
			util.clickOn(logger, lnk_myStuff);
			logger.log(LogStatus.PASS, "Tickets link clicked");
			
			util.clickOn(logger, lnk_open);
			util.waitTillElementIsClickable(logger, driver, lnk_cardView);
			
			if(checkIfRequestPresentInCardView(logger, ReqNo)){
				selectRequestFromCardView(logger, ReqNo);
				logger.log(LogStatus.PASS, ReqNo+" is opened");
				return true;
			}else if(checkIfRequestPresentInListView(logger, ReqNo)){
				selectRequestFromListView(logger, ReqNo);
				logger.log(LogStatus.PASS, ReqNo+" is opened");
				return true;
			}
			else{
				logger.log(LogStatus.FAIL, "Exact match for the request number is not found");
				logger.log(LogStatus.FAIL, ReqNo+" is not found");
				util.showScreenShotInLogger(logger, driver, "OpenRequestFromSelfServicePage-Failed");
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "ITG_AIR");
			logger.log(LogStatus.FAIL,  "Unable to open request from selfservice page due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		return false;
	}
	
	
	public boolean OpenClosedRequestFromSelfServicePage(ExtentTest logger, String ReqNo){
		try{
			FrameHelper.switchToDefaultFrame(logger, driver);
			util.waitTillElementIsVisible(logger, driver, lnk_myStuff);
			util.clickOn(logger, lnk_myStuff);
			logger.log(LogStatus.PASS, "Tickets link clicked");
			
			util.clickOn(logger, lnk_closed);
			util.waitTillElementIsClickable(logger, driver, lnk_cardView);
			
			if(checkIfRequestPresentInCardView(logger, ReqNo)){
				selectRequestFromCardView(logger, ReqNo);
				logger.log(LogStatus.PASS, ReqNo+" is opened");
				return true;
			}else if(checkIfRequestPresentInListView(logger, ReqNo)){
				selectRequestFromListView(logger, ReqNo);
				logger.log(LogStatus.PASS, ReqNo+" is opened");
				return true;
			}
			else{
				logger.log(LogStatus.FAIL, "Exact match for the request number is not found");
				logger.log(LogStatus.FAIL, ReqNo+" is not found");
				util.showScreenShotInLogger(logger, driver, "OpenClosedRequestFromSelfServicePage-Failed");
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "OpenClosedRequestFromSelfServicePage");
			logger.log(LogStatus.FAIL,  "Unable to open request from selfservice page due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		return false;
	}
	
	
	public void verifyIfIndicatorForAttachmentIsPresent(ExtentTest logger, String fileName){
		try{
			logger.log(LogStatus.INFO,  "Verifying if the attachment indicator is displayed for attachment-"+fileName);
			try{
				if(driver.findElement(ByXPath.xpath("//*[@aria-label='Attachments']//a[contains(text(),'"+fileName+"')]")).isDisplayed())
					logger.log(LogStatus.PASS, "Indicator is present for the required attachment-"+fileName);
				else{
					logger.log(LogStatus.FAIL, "Indicator is not present for the required attachment-"+fileName);
					util.showScreenShotInLogger(logger, driver, "verifyIfIndicatorForAttachmentIsPresent-Failed");
				}
			}catch(Exception e){
				logger.log(LogStatus.FAIL, "Indicator is not present for the required attachment-"+fileName);
				util.showScreenShotInLogger(logger, driver, "verifyIfIndicatorForAttachmentIsPresent-Failed");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyIfIndicatorForAttachmentIsPresent");
			logger.log(LogStatus.FAIL,  "Unable to verifyIfIndicatorForAttachmentIsPresent due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	public void verifyThatIndicatorForAttachmentIsRemoved(ExtentTest logger, String fileName){
		try{
			logger.log(LogStatus.INFO,  "Verifying if the attachment indicator is removed for-"+fileName);
			try{
				if(driver.findElement(ByXPath.xpath("//*[@aria-label='Attachments']//a[contains(text(),'"+fileName+"')]")).isDisplayed()){
					logger.log(LogStatus.FAIL, "Indicator is not removed for the required attachment");
					util.showScreenShotInLogger(logger, driver, "verifyThatIndicatorForAttachmentIsRemoved-Failed");
				}
				else{
					logger.log(LogStatus.PASS, "Indicator is removed for the required attachment");
					
				}
			}catch(Exception e){
				logger.log(LogStatus.PASS, "Indicator is removed for the required attachment");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyIfIndicatorForAttachmentIsPresent");
			logger.log(LogStatus.FAIL,  "Unable to verifyIfIndicatorForAttachmentIsPresent due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	public void verifyIfMessageIsPresentUnderActivities(ExtentTest logger, String message){
		try{
			logger.log(LogStatus.INFO,  "Verifying if the given message is displayed in the activities timeline-"+message);
			try{
				if(driver.findElement(ByXPath.xpath("//div[contains(@class,'timeline')]//*[contains(text(),'"+message+"')]")).isDisplayed())
					logger.log(LogStatus.PASS, "the given message is displayed in the activities timeline-"+message);
				else{
					logger.log(LogStatus.FAIL, "the given message is not displayed in the activities timeline-"+message);
					util.showScreenShotInLogger(logger, driver, "verifyIfIndicatorForAttachmentIsPresent-Failed");
				}
			}catch(Exception e){
				logger.log(LogStatus.FAIL, "the given message is not displayed in the activities timeline-"+message);
				util.showScreenShotInLogger(logger, driver, "verifyIfIndicatorForAttachmentIsPresent-Failed");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyIfMessageIsPresentUnderActivities");
			logger.log(LogStatus.FAIL,  "Unable to verifyIfMessageIsPresentUnderActivities due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	
	
	
	
	public void verifyIfMailIsDocumentedInRequest(ExtentTest logger, String content){
		try{
			logger.log(LogStatus.INFO,  "Verifying if the given outbound mail is documented in the request page-"+content);
			util.pause(logger, "10");
			try{
				if(driver.findElement(ByXPath.xpath("//*[contains(text(),'Outgoing Email') ]//*[contains(text(),'"+content+"')]")).isDisplayed())
					logger.log(LogStatus.PASS,  "The given outbound mail is documented in the request page-"+content);
				else{
					logger.log(LogStatus.FAIL,  "The given outbound mail is not documented in the request page-"+content);
					util.showScreenShotInLogger(logger, driver, "verifyIfOutBoundMailIsDocumentedInRequest-Failed");
				}
			}catch(Exception e){
				logger.log(LogStatus.FAIL,  "The given outbound mail is not documented in the request page-"+content);
				util.showScreenShotInLogger(logger, driver, "verifyIfOutBoundMailIsDocumentedInRequest-Failed");
			}
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyIfOutBoundMailIsDocumentedInRequest");
			logger.log(LogStatus.FAIL,  "Unable to verifyIfOutBoundMailIsDocumentedInRequest due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	
	
	
	/************************DSRM2.0 Itr3 additions*****************************/
	@FindBy(xpath="//*[contains(text(),'RITM')]") public WebElement lbl_anyRequestedItem;
	
	
	public String getRequestNumberFromGridView(ExtentTest logger){
		String ReqNo=null;
		try 
	    { 	
			util.waitTillElementIsClickable(logger, driver, lnk_requestnumber);
			util.clickOn(logger, lnk_requestnumber);
			
			ReqNo=getValueOfReqField(logger);
	    }   // try 
	    catch (Exception e) 
	    { 
	    	e.printStackTrace();
			logger.log(LogStatus.FAIL,  "Failed:  to getRequestNumber due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
	    }  
		return ReqNo;
	}
	
	
	public String getValueOfReqField(ExtentTest logger){
		String ReqNo=null;
		try 
	    { 	
			FrameHelper.switchToDefaultFrame(logger, driver);
			frameHelper.switchToFrame(logger, driver, gsft_main);
			util.waitTillElementIsVisible(logger, driver, txt_reqnumber);;
			ReqNo=util.getElementValue(logger, txt_reqnumber);
	    }   // try 
	    catch (Exception e) 
	    { 
	    	e.printStackTrace();
			logger.log(LogStatus.FAIL,  "Failed:  to getValueOfReqField due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
	    }  
		return ReqNo;
	}
	
	
	
	
	
	
	
	
}
