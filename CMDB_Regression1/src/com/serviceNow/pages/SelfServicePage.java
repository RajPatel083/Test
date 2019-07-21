/**
 * 
 */
package com.serviceNow.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.serviceNow.util.BrowserHelper;
import com.serviceNow.util.FrameHelper;

/**
 * @author k.narasimha.swamy
 *
 */
public class SelfServicePage extends BasePage {
		//Ticket search
		
		@FindBy(xpath="(.//a[@class='ng-binding'][contains(text(),'Application Creation Request')])[1]")
		public WebElement requestnumberHeader_ApplCreationRequest;
		
		@FindBy(xpath="(.//a[@class='ng-binding'][contains(text(),'CIO Application/Operation Request')])[1]")
		public WebElement requestnumberHeader_CIOAppl_Oper_Request;
		
		/*@FindBy(xpath="//input[contains(@id,'sys_readonly.sc_req_item.number')]")
		public WebElement requestnumber;*/
		
		@FindBy(xpath="//input[contains(@id,'sp_formfield_number')]")
		public WebElement requestnumber;
		
		//input[contains(@id,'sp_formfield_number')]

		@FindBy(xpath="(//div[@class='ng-binding ng-scope'])[1]")
		public WebElement RequestCreationNewAppl;		
		
		/*@FindBy(xpath=".//select[@id='sc_req_item.state']")
		public WebElement txt_state;*/
		
		@FindBy(xpath=".//span[@id='select2-chosen-13']")
		public WebElement txt_state;
		
		/*@FindBy(xpath=".//input[@id='sc_req_item.u_state_portal']")
		public WebElement txt_status;*/
		
		@FindBy(xpath=".//input[@id='sp_formfield_u_state_portal']")
		public WebElement txt_status;		
		
		/*@FindBy(xpath="//select[@id='sys_readonly.sc_req_item.stage']")
		public WebElement txt_stage;*/
		
		@FindBy(xpath=".//span[@id='select2-chosen-12']")
		public WebElement txt_stage;
		
		@FindBy(xpath="(.//a[contains(text(),'VendorDetail')])[2]")
		public WebElement Technlogy_List;
		
		/*
		@FindBy(xpath="(//button[@class='btn btn-primary btn-margin'])[1]")
		public WebElement Tkt_Approvebtn;
		
		@FindBy(xpath="(//button[@class='btn btn-primary btn-margin'])[2]")
		public WebElement Tkt_Rejectbtn;*/
		
		@FindBy(xpath="(.//a[@class='user-card-detail-btn'])[3]")
		public WebElement View;		
		
		@FindBy(xpath="(.//button[@class='btn btn-primary btn-margin'])[1]")
		public WebElement Approver1lnk;		
		
		@FindBy(xpath="(//a[@class='user-card-detail-btn'])[3]")
		public WebElement Approver2lnk;
		
		@FindBy(xpath=" //textarea[@id='comments']")
		public WebElement Comments;
		
		@FindBy(xpath="(//button[@class='btn btn-primary'])[2]")
		public WebElement Approve_Submitbtn;
		
		@FindBy(xpath="(.//button[@class='btn btn-default'])[1]")
		public WebElement Approve_Cancelbtn;
		
		@FindBy(xpath="(//input[@placeholder='Search' and @aria-label='Search application name'])[2]")
		public WebElement AppnNameSearchTextBox;
			
		@FindBy(xpath="//td[text()='Registration In Progress']")
		public WebElement RegistrationStatus;
	
		String value ;
	
	
	public String parentHandler;
	
	//Header Link
	
	@FindBy(xpath=".//a[text()='Human Resources services']")
	public WebElement lnk_humanresources;
	
	//Constructor
	public SelfServicePage(WebDriver driver)
	{
		super(driver);
	}
	
	
}
//Testing1