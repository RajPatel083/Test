package com.serviceNow.pages;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;

import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.serviceNow.util.FrameHelper;
import com.sun.glass.ui.View;


public class FulfillerView extends CommonObjectsPage {

	public FulfillerView(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//button[@id='toggleMoreOptions']") public WebElement btn_toggleMoreOptions;
	
	@FindBy(xpath="//button[@id='email_client_open']") public WebElement btn_emailClient;
	
	@FindBy(id="message.text_ifr") public WebElement iframe_mailToClient;
	
	@FindBy(xpath="//body[@id='tinymce']//p") public WebElement txt_clientMailContent;
	@FindBy(xpath="//body[@id='tinymce']") public WebElement txt_clientMailContentUnfilled;
	
	@FindBy(xpath="//button[@id='send_button']") public WebElement btn_sendClientMail;
	
	@FindBy(xpath="//input[@id='sys_display.to_block']") public WebElement txt_mailTo;
	
	@FindBy(xpath="//input[@id='sys_display.cc_block']") public WebElement txt_mailCc;
	
	@FindBy(xpath="//input[@id='sys_display.bcc_block']") public WebElement txt_mailBcc;
	
	@FindBy(xpath="//input[@id='MsgReplyTo']") public WebElement txt_mailFrom;
	
	@FindBy(xpath="//select[@id='canned']") public WebElement drpDn_mailTemplate;
	
	@FindBy(xpath="//button[@id='header_add_attachment']") public WebElement btn_reqAttachment;
	
	@FindBy(xpath="//button[@id='paperclip_button']") public WebElement btn_mailAttachment;
	
	@FindBy(xpath="//input[@id='subject']") public WebElement txt_mailSubject;
	
	
	
	
	@FindBy(id="attachFile")
	public WebElement btn_browse;
	
	@FindBy (xpath=".//*[@id='removeButton']")
	public WebElement btn_removeAttachment;
	
	@FindBy (xpath="//input[@id='download_all_button']")
	public WebElement btn_downloadAllAttachments;
	
	@FindBy (xpath="//input[@id='encrypt_checkbox']") public WebElement btn_encryptAttachment;
	
	@FindBy (xpath=".//*[@id='attachment_title']/preceding-sibling::button")
	public WebElement btn_closeAttachment;
	
	@FindBy (xpath="//button[starts-with(@id,'pending')]")
	public WebElement btn_pending;
	
	@FindBy (xpath="//select[@id='pending_reason']")
	public WebElement drpDn_pendingReason;
	
	@FindBy (xpath="//textarea[@id='work_notes_update']")
	public WebElement txt_pendingWorkNotes;
	
	@FindBy (xpath="//button[@id='resume']")
	public WebElement btn_resume;
	
	@FindBy (xpath="//button[@id='resolve']")
	public WebElement btn_resolve;
	
	@FindBy (xpath="//button[@id='agreeToClose']")
	public WebElement btn_close;
	
	@FindBy (xpath="//button[@id='agreeToCompletion']")
	public WebElement btn_agreeToCompletion;
	
	@FindBy(xpath="//span[contains(text(),'Please select a complete category path')]") public WebElement msg_completeCategoryError;
	
	
	

	
	@FindBy(xpath="(.//*[@tab_caption='Approvers']//a/ancestor::td[1]/preceding-sibling::td//a[contains(text(),'Requested')])[1]")
	public WebElement lnk_requestedUnderApprovers; 
	
	@FindBy(xpath="(.//button[contains(text(),'Approve')])[1]") public  WebElement btn_approve;
	
	@FindBy(xpath="(.//button[contains(text(),'Reject')])[1]") public WebElement btn_reject;
	
	
	
    //@FindBy(xpath="(.//*[text()='Show email details'])[1]") public WebElement lnk_showFirstEmailDetails;
    @FindBy(xpath="(.//*[@data-original-title='Show email details'])[1]") public WebElement lnk_showFirstEmailDetails;
	
    
	@FindBy(xpath="(.//*[text()='Assign'])[1]") public WebElement btn_assign;
	
	@FindBy(xpath="//*[contains(@id,'affected')]") public WebElement txt_affected;
	
	
	@FindBy(xpath=".//input[contains(@id,'facilities_request') and contains(@id,'resolution_date') and not(@type='hidden')]") public WebElement txt_resolutionDate;
	
	@FindBy(xpath="(.//button[text()='FCR'])[1]") public WebElement btn_FCR;
	@FindBy(xpath=".//select[contains(@id,'facilities_request') and contains(@id,'u_fcr') and not(@type='hidden')]") public WebElement drpDn_FCR;
	@FindBy(xpath="//input[@id='ni.facilities_request.u_do_not_notify']") public WebElement chkBx_DNNInputBox;
	
	
	//Task
	@FindBy(xpath=".//*[contains(text(),'Tasks')]/ancestor::a/following-sibling::button[@id='sysverb_new']") public WebElement btn_newTask;
	@FindBy(xpath=".//div[@id='tabs2_list']//span[contains(text(),'Tasks')]") public WebElement tab_fRTasks;
	@FindBy(xpath="//*[@id='sys_display.facilities_request_task.assignment_group']") public WebElement txt_taskAssignmentGroup;
	@FindBy(xpath="//*[@id='sys_display.facilities_request_task.assigned_to']") public WebElement txt_taskAssignedTo;
	@FindBy(xpath="//*[@id='lookup.facilities_request_task.assigned_to']") public WebElement btn_taskAssignedTo;
	@FindBy (xpath=".//*[@id='sys_readonly.facilities_request_task.number']") public WebElement txt_taskNumber;
	@FindBy (xpath=".//*[@id='sys_display.facilities_request_task.u_category_ref']") public WebElement txt_taskCategory;
	//Activity filter
	@FindBy (xpath="//div[starts-with(@id,'activity_table')]//span[text()='Filter activity']/ancestor::button[1]") public WebElement btn_activityFilter;
	@FindBy (xpath="//input[@id='activity_filter.u_email_journal']") public WebElement chkBx_emailJournal;
	@FindBy (xpath="//div[@name='u_email_journal']") public WebElement lbl_emailJournalActivity;
	
	//message
	
	@FindBy(xpath=".//*[contains(text(),'New information was added')]") public WebElement msg_newInfoAdded;
	
	//tags
	@FindBy(xpath="//button[@id='tags_menu']") public WebElement btn_addTags;
	@FindBy(xpath="//div[@id='form_tags']//input[not(@type='hidden')]") public WebElement txt_addTags;
	
	public void fillMailContent(ExtentTest logger, String content){
		try{
			frameHelper.switchToFrame(logger, driver, iframe_mailToClient);
			util.setText(logger, txt_clientMailContentUnfilled, content);
			FrameHelper.switchToDefaultFrame(logger, driver);
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "sendMailToRequestorFromRequest");
			logger.log(LogStatus.FAIL,  "Unable to sendMailToRequestorFromRequest due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	public void VerifyMailContentIsNotEmpty(ExtentTest logger){
		try{
			frameHelper.switchToFrame(logger, driver, iframe_mailToClient);
			logger.log(LogStatus.INFO,  "Verifying if the mail content is enabled and filled");
			util.verifyElementEnabled(logger, txt_clientMailContent);
			//util.verifyThatTextFieldIsFilled(logger, driver, txt_clientMailContent);
			if(txt_clientMailContent.getText()==null){
				logger.log(LogStatus.FAIL,  "The email content is not filled");
				util.showScreenShotInLogger(logger, driver, "VerifyMailContentIsNotEmpty-Failed");
			}
			FrameHelper.switchToDefaultFrame(logger, driver);
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "VerifyMailContentIsNotEmpty");
			logger.log(LogStatus.FAIL,  "Unable to VerifyMailContentIsNotEmpty due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	
	
	public void saveRequest(ExtentTest logger){
		try{
			util.clickOn(logger, btn_save);
			if(util.isNotDisplayed(logger, btn_save)){
				logger.log(LogStatus.FAIL,  "Request is not saved successfully");
				util.showScreenShotInLogger(logger, driver, "saveRequest-Failed");
			}else
				logger.log(LogStatus.PASS,  "Request is saved");
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "saveRequest");
			logger.log(LogStatus.FAIL,  "Unable to saveRequest due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	
	
	public void verifyFCRFieldAndOption(ExtentTest logger, String option){
		try{
			logger.log(LogStatus.INFO,  "Verifying if the dropdown FCR is readonly");
			util.isDisabled(logger, drpDn_FCR);
			
			logger.log(LogStatus.INFO,  "Verifying the options present in the FCR field");
			if(util.verifyDropdownValues(logger, drpDn_FCR, "No|Yes")){
				logger.log(LogStatus.INFO,  "Verifying if the option selected in FCR field is-"+option);
				util.verifyDropDownSelection(logger, drpDn_FCR, option);
			}else{
				util.clickOn(logger, drpDn_FCR);
				util.showScreenShotInLogger(logger, driver, "verifyFCRField-Failed");
			}
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyFCRField");
			logger.log(LogStatus.FAIL,  "Unable to verifyFCRField due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	
	public void verifyThatNoFCROptionIsPresent(ExtentTest logger){
		try{
			logger.log(LogStatus.INFO,  "Verifying That neither FCR button nor FCR dropdown is Present");
			WebElement[] FCRFields={btn_FCR, drpDn_FCR};
			if(!util.verifyListOfElementsNotPresent(logger, FCRFields))
				util.showScreenShotInLogger(logger, driver, "verifyThatNoFCROptionIsPresent-Failed");
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyThatNoFCROptionIsPresent");
			logger.log(LogStatus.FAIL,  "Unable to verifyThatNoFCROptionIsPresent due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	
	
	public void sendMailToRequestorFromRequest(ExtentTest logger, String mailContent){
		try{
			logger.log(LogStatus.INFO,  "Sending OutBound mail from the request page");
			util.clickOn(logger, btn_toggleMoreOptions);
			util.clickOn(logger, btn_emailClient);
			String parentHandle=frameHelper.getParentWindowHandle(logger, driver);
			
			frameHelper.switchToChildWindow(logger, driver, parentHandle);
			util.pause(logger, "4");
			util.waitTillElementIsClickable(logger, driver, btn_sendClientMail);
			fillMailContent(logger, mailContent);
			util.clickOn(logger, btn_sendClientMail);
			util.pause(logger, "3");
			frameHelper.switchToParentWindowHandle(logger, driver, parentHandle);
			logger.log(LogStatus.PASS,  "Successfully sent OutBound mail from the request page");
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "sendMailToRequestorFromRequest");
			logger.log(LogStatus.FAIL,  "Unable to sendMailToRequestorFromRequest due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	public void verifyFieldsInOutBoundMailWindow(ExtentTest logger){
		try{
			logger.log(LogStatus.INFO,  "Opening OutBound mail creation window from the request page");
			util.clickOn(logger, btn_toggleMoreOptions);
			util.clickOn(logger, btn_emailClient);
			String parentHandle=frameHelper.getParentWindowHandle(logger, driver);
			
			frameHelper.switchToChildWindow(logger, driver, parentHandle);
			logger.log(LogStatus.INFO,  "Verifying if the mail fields are enabled");
			WebElement[] mailFields={txt_mailBcc, txt_mailCc, txt_mailTo, txt_mailSubject, txt_mailFrom};
			util.verifyListOfElementsEnabled(logger, mailFields);
			
						
			fillMailContent(logger, "Adding sample text");
			
			driver.close();
			util.pause(logger, "3");
			frameHelper.switchToParentWindowHandle(logger, driver, parentHandle);
			frameHelper.switchToFrame(logger, driver, gsft_main);
			
			logger.log(LogStatus.PASS,  "Successfully verifyied fields in OutBound mail form.");
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyFieldsInOutBoundMailWindow");
			logger.log(LogStatus.FAIL,  "Unable to verifyFieldsInOutBoundMailWindow due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	
	public void verifyTemplatesInOutBoundMailWindow(ExtentTest logger){
		try{
			logger.log(LogStatus.INFO,  "Opening OutBound mail creation window from the request page");
			util.clickOn(logger, btn_toggleMoreOptions);
			util.clickOn(logger, btn_emailClient);
			String parentHandle=frameHelper.getParentWindowHandle(logger, driver);
			frameHelper.switchToChildWindow(logger, driver, parentHandle);
			logger.log(LogStatus.INFO,  "Verifying if the mail template dropdown is visible");
			util.verifyElementByXpath(logger, drpDn_mailTemplate);
			logger.log(LogStatus.INFO,  "Selecting random value for Template");
			util.selectAnyDropdownOptionOtherThanGiven(logger, drpDn_mailTemplate, "-- None --");
			
			VerifyMailContentIsNotEmpty(logger);
			logger.log(LogStatus.INFO,  "Verifying if the user is able to send mail after selecting template");
			util.verifyElementEnabled(logger, btn_sendClientMail);
			
			driver.close();
			util.pause(logger, "3");
			frameHelper.switchToParentWindowHandle(logger, driver, parentHandle);
			frameHelper.switchToFrame(logger, driver, gsft_main);
			
			logger.log(LogStatus.PASS,  "Successfully verifyied templates in OutBound mail form.");
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyFieldsInOutBoundMailWindow");
			logger.log(LogStatus.FAIL,  "Unable to verifyFieldsInOutBoundMailWindow due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	
	public void verifyTemplatesOptionsInOutBoundMailWindow(ExtentTest logger, String optionsList){
		try{
			logger.log(LogStatus.INFO,  "Opening OutBound mail creation window from the request page and verifying the required options to be present under templates");
			util.clickOn(logger, btn_toggleMoreOptions);
			util.clickOn(logger, btn_emailClient);
			String parentHandle=frameHelper.getParentWindowHandle(logger, driver);
			frameHelper.switchToChildWindow(logger, driver, parentHandle);
			logger.log(LogStatus.INFO,  "Verifying if the mail template dropdown is visible");
			util.verifyElementByXpath(logger, drpDn_mailTemplate);
			util.verifyFewOptionsInDropdown(logger, drpDn_mailTemplate, optionsList);
		
			driver.close();
			util.pause(logger, "3");
			frameHelper.switchToParentWindowHandle(logger, driver, parentHandle);
			frameHelper.switchToFrame(logger, driver, gsft_main);
			
			logger.log(LogStatus.PASS,  "Successfully verifyied template options in OutBound mail form.");
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyFieldsInOutBoundMailWindow");
			logger.log(LogStatus.FAIL,  "Unable to verifyFieldsInOutBoundMailWindow due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	
	
	public void attachFile(ExtentTest logger, String fileName){
		try{
			if(util.isNotDisplayed(logger, btn_reqAttachment)){
				util.clickOn(logger, btn_mailAttachment);
			}else{
				util.clickOn(logger, btn_reqAttachment);
			}
				
			util.pause(logger, "3");
			util.clickOn(logger, btn_browse);
			util.pause(logger, "4");
			//AutoIT script to attach file
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\FileAttach.exe"+" \""+System.getProperty("user.dir")+"\\"+fileName+"\"");
			logger.log(LogStatus.INFO,  "autoIT script is completely executed");
			/*util.setTextWithEnter(logger, btn_browse, System.getProperty("user.dir")+"\\"+fileName);
		
			util.pause(logger, "3");*/
			util.waitTillElementIsClickable(logger, driver, btn_downloadAllAttachments);
			util.clickOn(logger, btn_closeAttachment);
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "attachFile");
			logger.log(LogStatus.FAIL,  "Unable to attachFile  due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
	}
	
	public void attachEncryptedFile(ExtentTest logger, String fileName){
		try{
			if(util.isNotDisplayed(logger, btn_reqAttachment)){
				util.clickOn(logger, btn_mailAttachment);
			}else{
				util.clickOn(logger, btn_reqAttachment);
			}
			logger.log(LogStatus.INFO,  "selecting encryption checkbox");
			util.waitTillElementIsClickable(logger, driver, btn_encryptAttachment);
			util.clickOn(logger, btn_encryptAttachment);
			
			util.pause(logger, "3");
			util.clickOn(logger, btn_browse);
			util.pause(logger, "4");
			//AutoIT script to attach file
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\FileAttach.exe"+" \""+System.getProperty("user.dir")+"\\"+fileName+"\"");
			logger.log(LogStatus.INFO,  "autoIT script is completely executed");
			/*util.setTextWithEnter(logger, btn_browse, System.getProperty("user.dir")+"\\"+fileName);
		
			util.pause(logger, "3");*/
			util.waitTillElementIsClickable(logger, driver, btn_downloadAllAttachments);
			util.clickOn(logger, btn_closeAttachment);
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "attachEncryptedFile");
			logger.log(LogStatus.FAIL,  "Unable to attachEncryptedFile  due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
	}
	
	public void sendOutBoundMailWithAttachment(ExtentTest logger, String fileName){
		try{
			logger.log(LogStatus.INFO,  "Sending OutBound mail from the request page");
			util.clickOn(logger, btn_toggleMoreOptions);
			util.clickOn(logger, btn_emailClient);
			String parentHandle=frameHelper.getParentWindowHandle(logger, driver);
			
			frameHelper.switchToChildWindow(logger, driver, parentHandle);
			util.selectAnyDropdownOptionOtherThanGiven(logger, drpDn_mailTemplate, "-- None --");
			attachFile(logger, fileName);
			verifyIfIndicatorForAttachmentIsPresent(logger, fileName);
			
			util.clickOn(logger, btn_sendClientMail);
			util.pause(logger, "3");
			frameHelper.switchToParentWindowHandle(logger, driver, parentHandle);
			logger.log(LogStatus.PASS,  "Successfully sent OutBound mail with attachment from the request page");
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "sendMailToRequestorFromRequest");
			logger.log(LogStatus.FAIL,  "Unable to sendMailToRequestorFromRequest due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	public void verifyIfOutBoundMailIsPossible(ExtentTest logger){
		try{

			util.clickOn(logger, btn_toggleMoreOptions);
			logger.log(LogStatus.INFO,  "Verifying if OutBound mail option is present in request page");
			util.verifyElementByXpath(logger, btn_emailClient);
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyIfOutBoundMailIsPossible");
			logger.log(LogStatus.FAIL,  "Unable to verifyIfOutBoundMailIsPossible due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	public void verifyThatOutBoundMailIsNotPossible(ExtentTest logger){
		try{

			util.clickOn(logger, btn_toggleMoreOptions);
			logger.log(LogStatus.INFO,  "Verifying that OutBound mail option should not be present in request page");
			util.verifyElementNotPresentByXpath(logger, driver, btn_emailClient);
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyThatOutBoundMailIsNotPossible");
			logger.log(LogStatus.FAIL,  "Unable to verifyThatOutBoundMailIsNotPossible due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	public void verifyIfIndicatorForAttachmentIsPresent(ExtentTest logger, String fileName){
		try{
			logger.log(LogStatus.INFO,  "Verifying if the attachment indicator is displayed for attachment-"+fileName);
			try{
				if(driver.findElement(ByXPath.xpath("//*[@id='header_attachment_list']//*[contains(text(),'"+fileName+"')]")).isDisplayed())
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
				if(driver.findElement(ByXPath.xpath("//*[@id='header_attachment_list']//*[contains(text(),'"+fileName+"')]")).isDisplayed()){
					logger.log(LogStatus.FAIL, "Indicator is not removed for the required attachment");
					util.showScreenShotInLogger(logger, driver, "verifyThatIndicatorForAttachmentIsRemoved-Failed");
				}else{
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
	
	public void removeAttachmentAndValidate(ExtentTest logger, String fileName){
		try{
			logger.log(LogStatus.INFO,  "Verifying if the attachment removable-"+fileName);
			util.clickOn(logger, btn_reqAttachment);
			util.waitTillElementIsClickable(logger, driver, btn_downloadAllAttachments);
			try{
				driver.findElement(ByXPath.xpath("//a[contains(text(),'"+fileName+"')]/preceding-sibling::input[@type='checkbox']")).click();
				//driver.findElement(ByXPath.xpath("//a[contains(text(),'"+fileName+"')]/ancestor::tr[1]//input[@type='checkbox']")).click();
				util.clickOn(logger, btn_removeAttachment);
				util.pause(logger, "2");
				util.clickOn(logger, btn_closeAttachment);
			}catch(Exception e){
				logger.log(LogStatus.FAIL, "No Attachment(Or No option to remove an attachment) is displayed in the attachment popup");
				util.showScreenShotInLogger(logger, driver, "removeAttachmentAndValidate-Failed");
			}
			verifyThatIndicatorForAttachmentIsRemoved(logger, fileName);
			
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyIfIndicatorForAttachmentIsPresent");
			logger.log(LogStatus.FAIL,  "Unable to verifyIfIndicatorForAttachmentIsPresent due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	
	
	public void verifyAttachmentsAreNotRemovable(ExtentTest logger, String fileName){
		try{
			logger.log(LogStatus.INFO,  "Verifying if the attachment is not removable-"+fileName);
			util.clickOn(logger, btn_reqAttachment);
			util.waitTillElementIsClickable(logger, driver, btn_browse);
			try{
				if(driver.findElement(ByXPath.xpath("//a[contains(text(),'"+fileName+"')]/preceding-sibling::input[@type='checkbox']")).isDisplayed()){
					logger.log(LogStatus.FAIL,  "User is given an option to remove attachment");
					util.showScreenShotInLogger(logger, driver, "verifyAttachmentsAreNotRemovable-Failed");
				}
				else
					logger.log(LogStatus.PASS,  "User is not given an option to remove attachment");
				
			}catch(Exception e){
				logger.log(LogStatus.PASS,  "User is not given an option to remove attachment");
			}
			util.clickOn(logger, btn_closeAttachment);
			
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyIfIndicatorForAttachmentIsPresent");
			logger.log(LogStatus.FAIL,  "Unable to verifyIfIndicatorForAttachmentIsPresent due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	public void verifyRequestClosureFieldsArePresent(ExtentTest logger){
		try{
			logger.log(LogStatus.INFO,  "Verifying if the Cancel button is present");
			WebElement[] closureFields={btn_cancel};
			util.verifyListOfElementsPresent(logger, closureFields);
			
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyRequestClosureFieldsArePresent");
			logger.log(LogStatus.FAIL,  "Unable to verifyRequestClosureFieldsArePresent due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	public void verifyFieldsToBeHiddenInRequestForm(ExtentTest logger){
		try{
			logger.log(LogStatus.INFO,  "Verifying if the required fields are not displayed in the Request form");
			WebElement[] hiddenFields={txt_affected};
			util.verifyListOfElementsNotPresent(logger, hiddenFields);
			
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyFieldsToBeHiddenInRequestForm");
			logger.log(LogStatus.FAIL,  "Unable to verifyFieldsToBeHiddenInRequestForm due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	
	
	public void verifyAttachmentsAreRemovable(ExtentTest logger, String fileName){
		try{
			logger.log(LogStatus.INFO,  "Verifying if the attachment is removable-"+fileName);
			util.clickOn(logger, btn_reqAttachment);
			util.waitTillElementIsClickable(logger, driver, btn_browse);
			
			try{
				if(driver.findElement(ByXPath.xpath("//a[contains(text(),'"+fileName+"')]/preceding-sibling::input[@type='checkbox']")).isDisplayed())
					logger.log(LogStatus.PASS,  "User is given an option to select attachment");
				else{
					logger.log(LogStatus.FAIL,  "User is not given an option to select/remove attachment");
					util.showScreenShotInLogger(logger, driver, "verifyAttachmentsAreRemovable-Failed");
					return;
				}
				driver.findElement(ByXPath.xpath("//a[contains(text(),'"+fileName+"')]/preceding-sibling::input[@type='checkbox']")).click();
				logger.log(LogStatus.INFO,  "Verifying if  Remove option is accessible");
				util.verifyElementEnabled(logger, btn_removeAttachment);
				
			}catch(Exception e){
				logger.log(LogStatus.FAIL,  "User is not given an option to select/remove attachment");
			}
			util.clickOn(logger, btn_closeAttachment);
			
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyAttachmentsAreRemovable");
			logger.log(LogStatus.FAIL,  "Unable to verifyAttachmentsAreRemovable due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	

	public void verifyCompleteCategoryPathIsRequiredForProceeding(ExtentTest logger, String catLevel0, String catLevel1, String catLevel2, String assignmentGroup){
		try{
			logger.log(LogStatus.INFO,  "Verifying if Compelte catagory path is required to make the request resolved.");
			WebElement option;
			/*if(util.isNotDisplayed(logger, btn_agreeToCompletion)){
				if(util.isNotDisplayed(logger, btn_resolve)){
					logger.log(LogStatus.FAIL,  "The request is neither in 'Work In Progress' nor in 'Resolved' state.");
					return;
				}else{
					option=btn_resolve;
				}
			}else{
				option=btn_agreeToCompletion;
			}*/
			if(!util.isNotDisplayed(logger, btn_agreeToCompletion)){
				option=btn_agreeToCompletion;
				logger.log(LogStatus.INFO,  "Verfying the category level requirement for request Completion");
			}else if(!util.isNotDisplayed(logger, btn_resolve)){
				option=btn_resolve;
				logger.log(LogStatus.INFO,  "Verfying the category level requirement for request resolving");
			}else if(!util.isNotDisplayed(logger, btn_FCR)){
				option=btn_FCR;
				logger.log(LogStatus.INFO,  "Verfying the category level requirement for marking request as FCR");
			}else{
				logger.log(LogStatus.FAIL,  "The request is neither in 'Work In Progress' nor in 'Resolved' state nor 'FCR' option is present.");
				util.showScreenShotInLogger(logger, driver, "verifyCompleteCategoryPathIsRequiredForProceeding-Failed");
				return;
			}
			
			
			enterCategory(logger, catLevel0, "", "");
			util.setTextWithEnter(logger, txt_assignmentGroup, assignmentGroup);
			util.setText(logger, txt_assignedTo, "");
			util.pause(logger, "10");
			logger.log(LogStatus.INFO,  "Verifying if Error message is displayed when trying to proceed with Just Cat level0");
			util.clickOn(logger, option);
			if(util.verifyElementByXpath(logger, msg_completeCategoryError))
					util.clickOn(logger, btn_closeErrorMessages);
			else{
				util.scrollingToElementofAPage(logger, txt_reqnumber, driver);
				util.showScreenShotInLogger(logger, driver, "verifyCompleteCategoryPathIsRequiredForProceeding-Failed");
			}
			
			logger.log(LogStatus.INFO,  "Verifying that Error message is not displayed when trying to proceed with Cat level0 and level1");
			enterCategory(logger, catLevel0, catLevel1, "");
			util.pause(logger, "2");
			util.clickOn(logger, option);
			if(!util.verifyElementNotPresentByXpath(logger, driver, msg_completeCategoryError))
				util.showScreenShotInLogger(logger, driver, "verifyCompleteCategoryPathIsRequiredForProceeding-Failed");
			
			//The below lines of code are not applicable fot the application as the current scenario in the application has only 2 Cat levels 
			/*util.clickOn(logger, btn_closeErrorMessages);
			
			logger.log(LogStatus.INFO,  "Verifying if Error message is displayed when trying to proceed with complete Cat path");
			enterCategory(logger, catLevel0, catLevel1, catLevel2);
			util.pause(logger, "2");
			util.clickOn(logger, option);
			util.verifyElementByXpath(logger, msg_completeCategoryError);
			
			*/
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyCompleteCategoryPathIsRequiredForResolve");
			logger.log(LogStatus.FAIL,  "Unable to verifyCompleteCategoryPathIsRequiredForResolve due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	
	
 	public boolean verifyNotification(ExtentTest logger, String Subject, String MailContent){
		try{
			
			
			util.pause(logger, "10");
			driver.navigate().to(driver.getCurrentUrl());
			frameHelper.switchToFrame(logger, driver, gsft_main);
			if(!util.isNotDisplayed(logger, driver.findElement(ByXPath.xpath(".//*[contains(text(),'"+Subject+"')]")))){
				System.out.println("The email notification with subject "+Subject+" is displayed");
				logger.log(LogStatus.PASS,  "The email notification with subject "+Subject+" is displayed");
			}else{
				System.out.println("No Email notification is  present");
				logger.log(LogStatus.FAIL,  "The email notification with <b> subject "+Subject+" </b>is not displayed");
				return false;
			}
			
			logger.log(LogStatus.INFO,  "verifying mail content");
			driver.findElement(ByXPath.xpath(".//*[contains(text(),'"+Subject+"')]/ancestor::div[1]/following-sibling::div[1]//*[@data-original-title='Show email details']")).click();
			//lnk_showFirstEmailDetails.click();
			util.pause(logger, "2");
			
			frameHelper.switchToFrame(logger, driver, iframe_mail);
			boolean b=util.verifyElementByXpath(logger, driver.findElement(ByXPath.xpath(".//*[contains(text(),'"+MailContent+"')]")));
			if(b){
				System.out.println("Expected Mail content is displayed");
				logger.log(LogStatus.PASS,  "The expected mail content <b>"+MailContent+"</b>is displayed");
				FrameHelper.switchToDefaultFrame(logger, driver);
				frameHelper.switchToFrame(logger, driver, gsft_main);
				return b;
			}else{
				System.out.println("Expected Mail content is not displayed");
				logger.log(LogStatus.FAIL,  "The expected mail content <b>"+MailContent+"</b>is not displayed");
				FrameHelper.switchToDefaultFrame(logger, driver);
				frameHelper.switchToFrame(logger, driver, gsft_main);
				return b;
			}
		}catch(Exception e){
				e.printStackTrace();
				util.screenShotAndErrorMsg(logger, e, driver, "verifyNotification");
				logger.log(LogStatus.FAIL,  "Unable to verify email notification due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
			}
			return false;
		}
 	
 	
 
	
	
	
	public void verifyStateOfRequest(ExtentTest logger, String state){
		try{
			logger.log(LogStatus.INFO, "Verifying if the state of the request is "+state);
			
			util.verifyDropDownSelection(logger, drpDn_reqState, state);
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyStateOfRequest");
			logger.log(LogStatus.FAIL,  "Unable to verifyStateOfRequest due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	
	public void verifySaveButton(ExtentTest logger){
		try{
			logger.log(LogStatus.INFO,  "Verifying if the save button is present in the request page");
			util.verifyElementEnabled(logger, btn_save);
			logger.log(LogStatus.INFO,  "Verifying if the request saved successfully");
			saveRequest(logger);
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifySaveButton");
			logger.log(LogStatus.FAIL,  "Unable to verifySaveButton due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}	
	
	
	public void verifyWorkNotesUpdate(ExtentTest logger){
		try{
			logger.log(LogStatus.INFO,  "Verifying if the worknotes are added to the request successfully");
			util.setText(logger, txt_workNotes, "test Worknotes");
			saveRequest(logger);
			try{
				if(driver.findElement(ByXPath.xpath("//span[contains(text(),'Work notes')]/ancestor::div[1]/following-sibling::div[1]//*[contains(text(),'test Worknotes')]")).isDisplayed())
					logger.log(LogStatus.PASS, "WorkNotes is added successfully");
				else
					logger.log(LogStatus.FAIL, "WorkNotes is not added successfully");
			}catch(Exception e){
				logger.log(LogStatus.FAIL, "WorkNotes is not added successfully");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyWorkNotesUpdate");
			logger.log(LogStatus.FAIL,  "Unable to verifyWorkNotesUpdate due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	
	
	public void verifyIfOutBoundMailIsDocumentedInRequest(ExtentTest logger, String content){
		try{
			logger.log(LogStatus.INFO,  "Verifying if the given outbound mail is documented in the request page-"+content);
			util.pause(logger, "10");
			driver.navigate().to(driver.getCurrentUrl());
			frameHelper.switchToFrame(logger, driver, gsft_main);
			util.scrollingToElementofAPage(logger, txt_description, driver);
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
	
	public void verifyThatNoMailIsDocumentedInRequest(ExtentTest logger){
		try{
			logger.log(LogStatus.INFO,  "Verifying that no mail is documented in the request page.");
			util.pause(logger, "10");
			driver.navigate().to(driver.getCurrentUrl());
			frameHelper.switchToFrame(logger, driver, gsft_main);
			util.scrollingToElementofAPage(logger, txt_description, driver);
			try{
				if(driver.findElement(ByXPath.xpath("//*[contains(text(),'Outgoing Email') ]")).isDisplayed()){
					logger.log(LogStatus.FAIL,  "A mail is documented in the request page.");
					util.showScreenShotInLogger(logger, driver, "verifyThatNoMailIsDocumentedInRequest-Failed");
				}
				else{
					logger.log(LogStatus.PASS,  "No mail is documented in the request page.");
					
				}
			}catch(Exception e){
				logger.log(LogStatus.PASS,  "No mail is documented in the request page.");
				
			}
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyThatNoMailIsDocumentedInRequest");
			logger.log(LogStatus.FAIL,  "Unable to verifyThatNoMailIsDocumentedInRequest due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	public void verifyThatNoMailOtherThanTheCretionMailIsDocumentedInRequest(ExtentTest logger){
		try{
			logger.log(LogStatus.INFO,  "Verifying that no mail is documented in the request page except the creation mail.");
			util.pause(logger, "10");
			driver.navigate().to(driver.getCurrentUrl());
			frameHelper.switchToFrame(logger, driver, gsft_main);
			util.scrollingToElementofAPage(logger, txt_description, driver);
			try{
				if(driver.findElement(ByXPath.xpath("//*[not(contains(text(),' has been created'))]/ancestor::*[contains(text(),'Outgoing Email') ]")).isDisplayed()){
					logger.log(LogStatus.FAIL,  "A mail is documented in the request page.");
					util.showScreenShotInLogger(logger, driver, "verifyThatNoMailOtherThanTheCretionMailIsDocumentedInRequest-Failed");
				}
				else{
					logger.log(LogStatus.PASS,  "No mail is documented in the request page other than the creation mail.");
					
				}
			}catch(Exception e){
				logger.log(LogStatus.PASS,  "No mail is documented in the request page other than the creation mail");
				
			}
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyThatNoMailOtherThanTheCretionMailIsDocumentedInRequest");
			logger.log(LogStatus.FAIL,  "Unable to verifyThatNoMailOtherThanTheCretionMailIsDocumentedInRequest due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	public void verifyIfMessageIsPresentUnderActivities(ExtentTest logger, String message){
		try{
			logger.log(LogStatus.INFO,  "Verifying if the given message is displayed in the activities timeline-"+message);
			try{
				if(driver.findElement(ByXPath.xpath("//div[contains(@id,'activity')]//*[contains(text(),'"+message+"')]")).isDisplayed())
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
	
	public void goToCreateTaskPageFromRequest(ExtentTest logger){
		try{
			util.optionalClick(logger, tab_fRTasks);
			util.clickOn(logger, btn_newTask);
			logger.log(LogStatus.INFO,  "Verifying if create task page is opened successfully by verifying the  submit button");
			if(!util.verifyElementByXpath(logger, btn_submit))
				util.showScreenShotInLogger(logger, driver, "goToCreateTaskPageFromRequest-Failed");
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "goToCreateTaskPageFromRequest");
			logger.log(LogStatus.FAIL,  "Unable to goToCreateTaskPageFromRequest to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
			
		}
	}
	
	
	public String createTask(ExtentTest logger, String assignmentGroup){
		String taskNumber=null;
		try{
			logger.log(LogStatus.INFO,  "Creating task");
			util.setTextWithEnter(logger, txt_taskAssignmentGroup, assignmentGroup);
			util.pause(logger, "3");
			taskNumber=util.getElementValue(logger, txt_taskNumber);
			util.clickOn(logger, btn_submit);
			logger.log(LogStatus.PASS,  "The task number created is "+taskNumber);
			
			return taskNumber;
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "createTask");
			logger.log(LogStatus.FAIL,  "Unable to createTask to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
			
		}
		logger.log(LogStatus.FAIL,  "Failed to create the task ");
		util.showScreenShotInLogger(logger, driver, "createTask-Failed");
		return taskNumber;
	}
	
	
	
	
	public void verifyTaskCategoryValue(ExtentTest logger, String level0, String level1, String level2){
		String path;
		try{
			
			if(level1==null||level1.equals("")){
				path=level0;
			}else if(level2==null||level2.equals("")){
				path=level0+" > "+level1;
			}else{
				path=level0+" > "+level1+" > "+level2;
			}
			logger.log(LogStatus.PASS,  "Verifying if the category value is "+path);
			util.verifyElementValue(logger, txt_taskCategory, path);
			
		
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyCategoryValue");
			logger.log(LogStatus.FAIL,  "Unable to verify category path due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	
	public void addTagToTheRequest(ExtentTest logger, String tag){
		
		try{
			util.clickOn(logger, btn_toggleMoreOptions);
			util.clickOn(logger, btn_addTags);
			util.setTextWithEnter(logger, txt_addTags, tag);
			util.waitTillElementIsClickable(logger, driver, btn_addTags);
			saveRequest(logger);
		
		
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "addTagToTheRequest");
			logger.log(LogStatus.FAIL,  "Unable to addTagToTheRequest due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	
	/************************Package 3 additions*****************************/
	
	
	public void markRequestForFCR(ExtentTest logger, String additionalComments){
		try{
			util.setText(logger, txt_additionalComments, additionalComments);
			util.clickOn(logger, btn_FCR);
			if(util.isNotDisplayed(logger, btn_agreeToCompletion)){
				logger.log(LogStatus.FAIL,  "Request is not marked FCR Successfully");
				util.showScreenShotInLogger(logger, driver, "markRequestForFCR-Failed");
				
			}else
				logger.log(LogStatus.PASS,  "Request is marked FCR Successfully");
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "markRequestForFCR");
			logger.log(LogStatus.FAIL,  "Unable to markRequestForFCR due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
		
}
