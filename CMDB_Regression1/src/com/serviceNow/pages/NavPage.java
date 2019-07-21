/**
 * 
 */
package com.serviceNow.pages;




import java.awt.Frame;
import java.util.List;

import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.serviceNow.util.FrameHelper;

/**
 * @author k.narasimha.swamy
 *
 */
public class NavPage extends CommonObjectsPage
{

	

	
	@FindBy(id="filter")
	public	WebElement  filter;
	
	@FindBy(xpath="//span[@data-original-title='Filter navigator']") 
	public WebElement btn_expandFilter;
	
	
	@FindBy(linkText="My Approvals")
	WebElement  myApprovals;
	
	@FindBy(xpath="//div[text()='Create an EA Request']") 
	public WebElement lnk_createAnEaRequest;
	
	@FindBy(xpath="//span[text()='Facilities']/ancestor::li[1]//div[text()='My Requests']") 
	public WebElement lnk_myRequests;
	
	@FindBy(xpath="//span[text()='Facilities']/ancestor::li[1]//div[text()='Requires Review']") 
	public WebElement lnk_requiresReview;
	
	@FindBy(xpath="//span[text()='Facilities']/ancestor::li[1]//div[contains(text(), 'All')]") 
	public WebElement lnk_allRequests;

	@FindBy(xpath="//span[text()='Facilities']/ancestor::li[1]//div[contains(text(),'My Team')]") 
	public WebElement lnk_myTeamsRequests;
	
	@FindBy(xpath="//span[text()='Facilities']/ancestor::li[1]//div[contains(text(),'Executive EA Relationship')]") 
	public WebElement lnk_executiveEARelationship;
	
	
	@FindBy(xpath="//tr[@id='hdr_u_exsupp_md_ea_relationship']//*[contains(text(),'Supported Executive')]") 
	public WebElement hdr_supportedExecutive;
	
	@FindBy(xpath="//tr[@id='hdr_u_exsupp_md_ea_relationship']//*[contains(text(),'Managing Director')]") 
	public WebElement hdr_managingDirector;
	
	@FindBy(xpath="//*[contains(@id,'facilities_request') and contains(@id,'_breadcrumb')]//b[text()='All']") 
	public WebElement lnk_removeAllfilters;
	
	@FindBy(xpath="//*[@id='facilities_request_hide_search']//select")
	public WebElement  drpDn_search;
	
	@FindBy(xpath="//*[@id='facilities_request_hide_search']//input")
	public WebElement txt_search;
	
	@FindBy(xpath="//table[@id='facilities_request_table']//i[@role='button']")
	public List<WebElement> btn_columnOptions ;
	
	@FindBy(xpath="//div[text()='Sort (a to z)']")
	public WebElement lbl_sortAToZ ;
	
	@FindBy(xpath="(.//a[@class='btn btn-icon table-btn-lg icon-info list_popup'])[1]")
	public
	WebElement  resultFirstLink;

	@FindBy(id="sysapproval_approver.comments")
	WebElement  txt_approverComments;
	
	@FindBy(xpath="(.//button[@id='sysverb_update'])[1]")
	WebElement  updateButton;
	
	
	
	
	@FindBy(xpath="(.//input[@aria-label='Search approval for'])[2]") WebElement searchApprovalFor;
	
	
	@FindBy (xpath=".//*[@id='sys_display.sc_req_item.opened_by']") public WebElement txt_openedBy;
	
	@FindBy (xpath=".//*[@id='sys_display.sc_req_item.request']") public WebElement txt_request;
	
	@FindBy (xpath=".//*[@id='sc_req_item.due_date']") public WebElement txt_dueDate;
	

    @FindBy(xpath=".//*[text()='Opened Request']") WebElement lnk_openedRequest;
    
    @FindBy(xpath=".//*[text()='Service Management']") public WebElement lbl_serviceManagement;
    
    @FindBy(xpath=".//*[contains(text(),'Service Automation')]") public WebElement lbl_serviceAutomation;
  
    @FindBy(xpath=".//a[text()='List Users']") WebElement lnk_listUsers;

    
    @FindBy(xpath=".//overviewhelp//*") public WebElement img_serviceNowTour;
    
    @FindBy(xpath=".//button[@class='close icon-cross']") public WebElement btn_closeIcon;
    
    
    @FindBy(xpath=".//*[contains(text(),'Exact search match.')]") public WebElement txt_searchMatch;
    
 
    @FindBy(xpath=".//*[@data-original-title='Search']//span") public WebElement btn_navPageSearch;
    
    @FindBy(xpath=".//*[@id='sysparm_search']") public WebElement txt_navPageSearch;
    
    @FindBy(xpath=".//a[text()='Requested']") public WebElement lnk_requested;
    
    //Dashboard
    @FindBy(xpath="//select[@id='page_selector']") public WebElement drpDn_selectDashboardPage;
    
    @FindBy(xpath="//*[@id='s2id_page_selector']") public WebElement txt_dashBoardPage;
  
    @FindBy(xpath="//td[contains(text(),'Requests Assigned')]") public WebElement dB_assignedToMe;
  
    @FindBy(xpath="//td[contains(text(),'Unassigned Requests associated to my Groups')]") public WebElement dB_UnassignedInMyGroup;
  
    @FindBy(xpath="//td[contains(text(),'Assigned to me Requests with new customer response')]") public WebElement dB_newCustomerResponse;
   
    @FindBy(xpath="//td[contains(text(),'Requests Assigned To Me')]/ancestor::div[2]//table[@sort='u_facilities_request_sla.taskslatable_planned_end_time']") public WebElement dBSort_assignedToMe;
    
    @FindBy(xpath="//td[contains(text(),'Unassigned Requests associated to my Groups')]/ancestor::div[2]//table[@sort='facilities_request.opened_at']") public WebElement dBSort_UnassignedInMyGroup;
    
    @FindBy(xpath="//td[contains(text(),'Assigned to me Requests with new customer response')]/ancestor::div[2]//table[@sort='u_facilities_request_sla.taskslatable_planned_end_time']") public WebElement dBSort_newCustomerResponse;
    
    
    
    //filters
    @FindBy(xpath="//span[@id='facilities_request_breadcrumb']//b[contains(text(),'Assignment group')]") public WebElement lnk_filterAssignmentGroup;
  
    @FindBy(xpath="//span[@id='facilities_request_breadcrumb']//b[contains(text(),'Assigned to is empty')]") public WebElement lnk_filterAssignedIsEmpty;
  
    @FindBy(xpath="//span[@id='facilities_request_breadcrumb']//b[contains(text(),'Assigned to !=')]") public WebElement lnk_filterAssignedNotEquals;
  
    @FindBy(xpath="//span[@id='facilities_request_breadcrumb']//b[contains(text(),'Assigned to is') and not(contains(text(),'empty'))]") public WebElement lnk_filterAssignedToIs;
  
    @FindBy(xpath="//span[contains(text(),'choose field')]") public WebElement drpDn_newFilterRow;
	
    
    @FindBy(xpath="//*[text()='Facilities']/ancestor::li[1]//div[text()='Create New']")
	public WebElement lnk_createAnOSRequest;
  
    @FindBy(xpath="//span[text()='Facilities']/ancestor::li[1]//div[text()='Assigned to Me']")
	public WebElement lnk_assignedToMe;
  
    @FindBy(xpath="//span[text()='Facilities']/ancestor::li[1]//div[text()='Assigned to my Team']")
	public WebElement lnk_assignedToMyTeam;
    
    @FindBy(xpath="//span[text()='Facilities']/ancestor::li[1]//div[text()='Group Lookups']") public WebElement lnk_groupLookups;
    
    //emails
	@FindBy(linkText="Emails") WebElement  lnk_sysLogsEmails;
	
	@FindBy(xpath=".//b[text()='All']") public WebElement lnk_all;
    
	
	
	@FindBy(xpath="(//textarea[contains(@id,'sys_email.recipients')])[1]") public WebElement txt_mailRecipients;
	
	@FindBy(xpath="(//textarea[contains(@id,'sys_email.copied')])[1]") public WebElement txt_mailCopied;
	
	@FindBy(xpath="(//textarea[contains(@id,'sys_email.subject')])[1]") public WebElement txt_mailSubject;
	
	@FindBy(xpath="(//textarea[contains(@id,'sys_email.body')])[1]") public WebElement txt_mailBody;
	
    
	@FindBy(xpath=".//a[@id='lookup.u_facilities_group_lookup.u_assignment_group']") public WebElement btn_groupLookupAssignmentGroup;
    
	@FindBy(xpath=".//input[@id='ni.u_facilities_group_lookup.u_tier_2']") public WebElement chkBx_tier2;
	@FindBy(xpath=".//button[@id='sysverb_new']") public WebElement btn_new;
	
	public NavPage(WebDriver driver) {
		super(driver);
	
	}
	
	//Pavithran
	public void openCreateEARequestPage(ExtentTest logger){
		try{
			FrameHelper.switchToDefaultFrame(logger, driver);
			filter.clear();
			util.setText(logger, filter, "facilities");
			util.pause(logger, "2");
			util.clickOn(logger, lnk_createAnEaRequest);
			frameHelper.switchToFrame(logger, driver, gsft_main);
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "openCreateEARequestPage");
			logger.log(LogStatus.FAIL,  "Unable to openCreateEARequestPage due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
	
	}
	
	
	
	
	

	
	

	
	public void verifyNewMailIindicatorForRequest(ExtentTest logger, String reqNo){
		try{
			//openAssignedToMeList(logger);
			removeAllAppliedFilters(logger);
			addFilterToList(logger, "Number(fcr_number)", "is", reqNo);
			util.pause(logger, "4");
			addFilterToList(logger, "New email", "is", "Yes");
			if(!verifyIfAnyCaseIsPresentInPage(logger)){
				logger.log(LogStatus.FAIL,  "Expected request is not displayed with indicator for new email");
			}else{
				logger.log(LogStatus.PASS,  "Expected request is displayed with indicator for new email");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "openRequestFromMyRequests");
			logger.log(LogStatus.FAIL,  "Unable to openRequestFromMyRequests due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
	
	}
	
	public void verifyNewMailIindicatorDeactivatedOnceRequestIsOpened(ExtentTest logger, String reqNo){
		try{
			
			//openAssignedToMeList(logger);
			removeAllAppliedFilters(logger);
			addFilterToList(logger, "Number(fcr_number)", "is", reqNo);
			util.pause(logger, "4");
			addFilterToList(logger, "New email", "is", "Yes");
			if(verifyThatNoCaseIsPresentInPage(logger)){
				logger.log(LogStatus.PASS,  "New Mail Indicator is removed after the request is opened");
			}else{
				logger.log(LogStatus.FAIL,  "New Mail Indicator is not removed after the request is opened");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyNewMailIindicatorDeactivatedOnceRequestIsOpened");
			logger.log(LogStatus.FAIL,  "Unable to verifyNewMailIindicatorDeactivatedOnceRequestIsOpened due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
	
	}
	
	

	
	
	public void verifySortOptionForAllAvailableColumns(ExtentTest logger){
		try{
			Actions action=new Actions(driver);
			
			for(WebElement i:btn_columnOptions){
				util.clickOn(logger, i);
				util.verifyElementByXpath(logger, lbl_sortAToZ);
				action.sendKeys(Keys.ESCAPE).perform();
			}
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "openCreateEARequestPage");
			logger.log(LogStatus.FAIL,  "Unable to openCreateEARequestPage due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
	
	}
	
	
	/**
	 * This method for approving  or rejecting specific request
	 * if you provide mode as APPROVE it will approve the specified request
	 * if you provide mode as REJECT it will reject the specified request
	 * if you provide mode as UPDATE it will update the specified request
	 * @author pavithran.rajendran
	 * @param reqNo  = RITM********
	 * @param mode = APPROVE, REJECT
	 * @return
	 */
	public void manageApprovalRequest(ExtentTest logger, String reqNo, String mode){
		try{
			//Switching to default frame
			FrameHelper.switchToDefaultFrame(logger, driver);
			// Enter My Approval in filter
			filter.sendKeys("My Approvals");
			
			//Wait 2 sec
			util.pause(logger,"2");
			
			//Click on My Approval link
			myApprovals.click();
			
			//Switch to main frame
			frameHelper.switchToFrame(logger,driver, gsft_main);
			
			util.selectBoxByValue(logger, drpDn_search, "Approval for");
			//Enter request Number in search box and press ENTER
			txt_search.sendKeys(reqNo + Keys.ENTER);
			
			//Wait 3 sec
			util.pause(logger,"3");
			if(util.isNotDisplayed(logger, lnk_requested))
				logger.log(LogStatus.FAIL, "Request is not displayed under my approvals-"+reqNo);
			//Right Click on first link in result list
			util.clickOn(logger, lnk_requested);

			//Wait 3 sec
			util.pause(logger,"3");
			
			//Add Comments 
			txt_approverComments.sendKeys("Automation Testing.....");
			
			//if you provide mode as APPROVE it will approve 
			if(mode.equalsIgnoreCase("APPROVE"))
			{
				util.clickOn(logger, approveButton);
				logger.log(LogStatus.INFO, "Valdating: If approval alert is displayed");
				if(util.verifyAlertMessage(logger, driver, "Are you sure you want to approve this record?"))
					util.manageAlert(logger, driver, "accept");
			}
			//if you provide mode as REJECT it will reject
			else if (mode.equalsIgnoreCase("REJECT")) {
				util.clickOn(logger, rejectButton);
				logger.log(LogStatus.INFO, "Valdating: If rejection alert is displayed");
				if(util.verifyAlertMessage(logger, driver, "Are you sure you want to reject this record?"))
					util.manageAlert(logger, driver, "accept");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "manageApprovalRequest");
			logger.log(LogStatus.FAIL,  "Unable to manageApprovalRequest due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
	
	}
	
		

	public void addFilterToList(ExtentTest logger, String field, String Operator, String value){
		try{
			logger.log(LogStatus.INFO,  "Adding filter:::"+field+"--"+Operator+"--"+value);
			util.waitTillElementIsClickable(logger, driver, btn_filter);
			util.clickOn(logger, btn_filter);
			util.waitTillElementIsClickable(logger, driver, btn_and);
			if(util.isNotDisplayed(logger, drpDn_newFilterRow))
				btn_and.click();
			util.pause(logger, "3");
			util.selectBoxByValue(logger, drpDn_filterField, field);
			util.pause(logger, "2");
			util.selectBoxByValue(logger, drpDn_filterOperator, Operator);
			util.pause(logger, "4");
			
			if(!util.isNotDisplayed(logger, txt_filterValue)){
				txt_filterValue.sendKeys(value);
			}else if(!util.isNotDisplayed(logger, drpDn_filterValue)){
				util.selectBoxByValue(logger, drpDn_filterValue, value);
			}else if(!util.isNotDisplayed(logger,txt_filterValueArea)){
				txt_filterValueArea.sendKeys(value);
			}else{
				logger.log(LogStatus.FAIL, "The filter operation doesnot contain either text box or a dropdown");
			}
			btn_run.click();
			util.pause(logger, "3");
			logger.log(LogStatus.PASS, "The filter values are entered and run button is clicked successfully");
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "ERCM Wave2");
			logger.log(LogStatus.FAIL,  "Unable to add filter to list due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
	}
	

		
	public boolean verifyIfAnyCaseIsPresentInPage(ExtentTest logger){
		try{
			if(util.isNotDisplayed(logger, resultFirstLink)){
				logger.log(LogStatus.FAIL,  "No Case is present in the Current Page");
				util.showScreenShotInLogger(logger, driver, "verifyIfAnyCaseIsPresentInPage-Failed");
				return false;
			}else{
				logger.log(LogStatus.PASS,  "Cases are present in the Current Page");
				return true;
			}
				
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyIfAnyCaseIsPresentInPage");
			logger.log(LogStatus.FAIL,  "Unable to overifyIfAnyCaseIsPresentInPage due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		return false;
	
	}
	
	public boolean verifyThatNoCaseIsPresentInPage(ExtentTest logger){
		try{
			if(util.isNotDisplayed(logger, resultFirstLink)){
				logger.log(LogStatus.PASS,  "No Case is present in the Current Page");
				return true;
			}else{
				logger.log(LogStatus.FAIL,  "Cases are present in the Current Page");
				return false;
			}
				
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyThatNoCaseIsPresentInPage");
			logger.log(LogStatus.FAIL,  "Unable to verifyThatNoCaseIsPresentInPage due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		return false;
	
	}
	
	public boolean verifyRequestIsNotDisplayedInTheList(ExtentTest logger, String reqNo){
		try{
			addFilterToList(logger, "Number", "is", reqNo);
			if(util.isNotDisplayed(logger, resultFirstLink)){
				logger.log(LogStatus.PASS,  "No Request is present in the List");
				return true;
			}else{
				logger.log(LogStatus.FAIL,  "Request is present in the List");
				return false;
			}
				
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyRequestIsNotDisplayedInTheList");
			logger.log(LogStatus.FAIL,  "Unable to verifyRequestIsNotDisplayedInTheList due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		return false;
	
	}
	
	
	public boolean searchForRequestInNavPage(ExtentTest logger, String reqNo){
		try{
			logger.log(LogStatus.INFO, "Searching for the request in application -"+reqNo);
			FrameHelper.switchToDefaultFrame(logger, driver);
			util.clickOn(logger, btn_navPageSearch);
			util.setTextWithEnter(logger, txt_navPageSearch, reqNo);
			
			util.pause(logger, "5");
			frameHelper.switchToFrame(logger, driver, gsft_main);
		
			if(!util.isNotDisplayed(logger, lnk_dataPrivacyPolicy))
				util.clickOn(logger, btn_accept);
			if(!util.isNotDisplayed(logger, txt_searchMatch)){
				logger.log(LogStatus.PASS, "Exact match for the request number is found -"+reqNo);
				
				return true;
			}else{
				logger.log(LogStatus.INFO, "Exact match for the request number is not found-"+reqNo+". Verifying if the request number field in the page");
				if(util.verifyElementByXpath(logger, txt_reqnumber)){
					logger.log(LogStatus.PASS, "Request Page is opened for the request number-"+reqNo);
					return true;	
				}else{
					logger.log(LogStatus.FAIL, "Request Page is not opened for the request number-"+reqNo);
					util.showScreenShotInLogger(logger, driver, "searchForRequestInNavPage-Failed");
					return false;
				}
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.log(LogStatus.FAIL,  "Unable to search for the request number due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
			return false;
		}
	}
	
		
	
	
	
	public void removeAllAppliedFilters(ExtentTest logger){
		try{
			logger.log(LogStatus.INFO,  "Removing all the filters applied to the list by selecting 'All' link");
			util.clickOn(logger, lnk_removeAllfilters);
			util.pause(logger, "4");
			util.waitTillElementIsClickable(logger, driver, lnk_removeAllfilters);
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "openRequestAssignedToMyTeam");
			logger.log(LogStatus.FAIL,  "Unable to openRequestAssignedToMyTeam due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
	
	}
	
	
	
	//Pavithran
	public boolean openEmailsUnderSystemLogs(ExtentTest logger,String subject, String sentTo)
	{
		try 
		{
			if(searchForMailsUnderSystemLogs(logger, subject)){
				logger.log(LogStatus.PASS, "Opening the mail with subject <b>"+subject+"</b>.");
				util.clickOn(logger, resultFirstLink);
				return true;
			}
			else{
				logger.log(LogStatus.FAIL, "<b>"+subject+"</b>-Emails are not present with this subject line ");
				util.showScreenShotInLogger(logger, driver, "openEmailsUnderSystemLogs");
				return false;
			}
			

					
		} catch (Exception e) {
			util.screenShotAndErrorMsg(logger, e, driver, "openEmailsUnderSystemLogs");
			logger.log(LogStatus.FAIL,  "Unable to open mail from Admin login due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
			e.printStackTrace();
			return false;
		}
		
	}
	
	//Pavithran
	public boolean verifyThatEmailIsNotPresentUnderSystemLogs(ExtentTest logger,String subject)
	{
		try 
		{
			if(searchForMailsUnderSystemLogs(logger, subject)){
				logger.log(LogStatus.FAIL, "There are mails matching with subject <b>"+subject+"</b> .");
				util.showScreenShotInLogger(logger, driver, "verifyThatEmailIsNotPresentUnderSystemLogs");	
				return false;
			}
			else{
				logger.log(LogStatus.PASS, "There are no mails matching with subject <b>"+subject+"</b>.");
				return true;
			}
		} catch (Exception e) {
			util.screenShotAndErrorMsg(logger, e, driver, "verifyThatEmailIsNotPresentUnderSystemLogs");
			logger.log(LogStatus.FAIL,  "Unable to verifyThatEmailIsNotPresentUnderSystemLogs due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
			e.printStackTrace();
			return true;
		}
		
	}
		
	
	//Pavithran
	public boolean searchForMailsUnderSystemLogs(ExtentTest logger,String subject)
		{
			try 
			{
				logger.log(LogStatus.INFO, "searhing Emails from  the System Logs tab");
				FrameHelper.switchToDefaultFrame(logger, driver);
				
				util.setText(logger, filter, "Emails");
				
				util.waitTillElementIsClickable(logger, driver, lnk_sysLogsEmails);
				
				//Click on My Approval link
				util.clickOn(logger, lnk_sysLogsEmails);
				
				//Switch to main frame
				frameHelper.switchToFrame(logger,driver, gsft_main);
				
				//lnk_all.click();
				util.pause(logger, "5");
				logger.log(LogStatus.INFO, "Removing existing filter, by clickin on 'All'");
				util.clickOn(logger, lnk_all);
				util.pause(logger, "3");
				addFilterToList(logger, "Subject", "is", subject);
				/*util.pause(logger, "3");
				addFilterToList(logger, "To", "contains", sentTo);
				*/
				//Wait 3 sec
				util.pause(logger,"3");
				if(!util.isNotDisplayed(logger, resultFirstLink)){
					logger.log(LogStatus.INFO, "Search Completed");
					logger.log(LogStatus.PASS, "<b>"+subject+"</b>-Emails are present with this subject line ");
					return true;
				}
				else{
					logger.log(LogStatus.INFO, "Search Completed");
					logger.log(LogStatus.INFO, "<b>"+subject+"</b>-Emails are not present with this subject line ");
					return false;
				}
				

						
			} catch (Exception e) {
				util.screenShotAndErrorMsg(logger, e, driver, "searchForMailsUnderSystemLogs");
				logger.log(LogStatus.FAIL,  "Unable to searchForMailsUnderSystemLogs due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
				e.printStackTrace();
				return false;
			}
			
		}
		
	
	public void verifyTheAttributesOfMailInTheMailLogsPage(ExtentTest logger, String subject, String content, String To, String Cc){
		try{			
			logger.log(LogStatus.INFO,  "Verifying the Mail Subject, Body, To, Cc");
			if(util.compareTwoStrings(logger, txt_mailSubject.getText(), subject))
				logger.log(LogStatus.PASS,  "Subject is displayed as expected");
			else{
				logger.log(LogStatus.FAIL,  "Subject is not as expected");
				util.showScreenShotInLogger(logger, driver, "verifyTheAttributesOfMailInTheMailLogsPage-Failed");	
			}
			logger.log(LogStatus.INFO,  "Verifying the Body Content");
			if(txt_mailBody.getText().contains(content))
				logger.log(LogStatus.PASS,  "content is displayed as expected");
			else{
				logger.log(LogStatus.FAIL,  "content is not as expected");
				util.showScreenShotInLogger(logger, driver, "verifyTheAttributesOfMailInTheMailLogsPage-Failed");
			}
			logger.log(LogStatus.INFO,  "Verifying the Mail To Address");
			if(txt_mailRecipients.getText().contains(To))
				logger.log(LogStatus.PASS,  "To is displayed as expected");
			else{
				logger.log(LogStatus.FAIL,  "To is not as expected");
				util.showScreenShotInLogger(logger, driver, "To_notAsExpected");
			}
			
			logger.log(LogStatus.INFO,  "Verifying the Mail Copied Address");
			if(util.compareTwoStrings(logger, txt_mailCopied.getText(), Cc))
				logger.log(LogStatus.PASS,  "Cc is displayed as expected");
			else
				logger.log(LogStatus.FAIL,  "Cc is not as expected");
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "verifyTheAttributesOfMailInTheMailLogsPage");
			logger.log(LogStatus.FAIL,  "Unable to verifyTheAttributesOfMailInTheMailLogsPage due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
	}
	

	
	/************************DSRM2.0 Itr3 additions*****************************/
	
	
	
	
}
