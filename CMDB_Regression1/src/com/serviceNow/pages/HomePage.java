package com.serviceNow.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver)

	{
		super(driver);
	}

	
	/*@FindBy(xpath = ".//a[contains(text(),'My Activities')]")
	public WebElement MyActivities;
	
	@FindBy(xpath = ".//a[contains(text(),'My Applications')]")
	public WebElement MyApplication;
	
	@FindBy(xpath = ".//a[contains(text(),'Search/Reports')]")
	public WebElement Search_Reports;

	@FindBy(xpath = ".//a[contains(text(),'Surveys')]")
	public WebElement Surveys;
	
	@FindBy(xpath = ".//a[contains(text(),'Pending Actions')]")
	public WebElement PendingActions;
	
	@FindBy(xpath = ".//a[contains(text(),'About Us')]")
	public WebElement Aboutus;
	
	@FindBy(xpath = ".//a[contains(text(),'Register an Application')]")
	public WebElement RegAnAppl;

	@FindBy(xpath = "//iframe[@id='gsft_main']")
	public WebElement Frame;
	
	@FindBy(xpath = ".//input[contains(@id,'a3036c2a1322cfc00931fc04e144b09f')][not(@type='HIDDEN')]")
	public WebElement ApplName;

	@FindBy(xpath = "//select[contains(@id,'ac5664661366cfc00931fc04e144b07c')]")
	public WebElement ApplStatus;

	@FindBy(xpath = "//textarea[contains(@id,'feb3e8aa13a2cfc00931fc04e144b0b7')]")
	public WebElement Description;
	
	@FindBy(xpath = ".//select[contains(@id,'6296a4e61366cfc00931fc04e144b0df')]")
	public WebElement ServiceTier;
	@FindBy(xpath = ".//span[contains(@id,'select2-chosen-5')]")
	public WebElement ServiceTier_none;
	
	@FindBy(xpath = ".//input[contains(@id,'s2id_autogen5_search')]")
	public WebElement ServiceTier;

	@FindBy(xpath = ".//input[contains(@id,'635568e61326cfc00931fc04e144b01e')][not(@type='hidden')]")
	public WebElement ParentAppl;

	@FindBy(xpath = "//span[@class='icon icon-search']")
	public WebElement ParentApplSearchLookUp;

	@FindBy(xpath = "//input[@class='form-control'and @placeholder = 'Search']")
	public WebElement ParentApplSearchinput;

	@FindBy(xpath = "//a[@sys_id='a8c4224edb768b003c9a77e88c9619ff']")
	public WebElement SelectParentAppl;

	@FindBy(xpath = "//label[text()='Global']")
	public WebElement GlobalCheckbox;
	
	@FindBy(xpath = ".//label[text()='Specific']")
	public WebElement SpecificCheckbox;
	
	@FindBy(xpath = ".//select[contains(@id,'c61516b8db561f80f04c10825b9619d1')][not(@type='hidden')]")
	public WebElement ResponEntity;	
	
	@FindBy(xpath = ".//button[@id='oi_order_now_button']")
	public WebElement Ordernowbtn;	
	
	@FindBy(xpath = ".//input[contains(@id,'34975530dbf6074071c89447db96199c')][not(@type='hidden')]")
	public WebElement Country;

	@FindBy(xpath = ".//select[contains(@id,'762a11b4dbf6074071c89447db961988')]")
	public WebElement ComponentType;

	@FindBy(xpath = ".//select[contains(@id,'4d4724ee1366cfc00931fc04e144b021')]")
	public WebElement NumOfUsersAtPeak;

	@FindBy(xpath = ".//input[contains(@id,'9087202213a6cfc00931fc04e144b030')][not(@type='HIDDEN')]")
	public WebElement ProductionURL;

	@FindBy(xpath = "//select[contains(@id,'6ee564221366cfc00931fc04e144b073')]")
	public WebElement Orgnization;
	
	@FindBy(xpath = "//input[contains(@id,'a7b5646a1326cfc00931fc04e144b092')][not(@type='hidden')]")
	public WebElement ApplType;
	
	@FindBy(xpath = "//span[@class='icon icon-search']")//need to put index
	public WebElement ApplTypeSearchLookUp;

	@FindBy (xpath = "//input[@class='form-control'and @placeholder = 'Search']")
	static WebElement ApplTypeinput;

	@FindBy(xpath = "//a[@class='glide_ref_item_link']")
	public WebElement SelectApplType; //Value is Business
	
	@FindBy(xpath = "//select[@id='af0f412ddb1057086a1f5a78dc961970_select']")
	public WebElement GoToProjectID;
	
	@FindBy(xpath = "//a[contains(@id,'07b6124c133ec7000931fc04e144b061')]/span[@class='icon icon-search']")
	public WebElement AIMProgIDSearchLookUp;
	
	@FindBy(xpath = "//a[contains(@id,'6577d2cc133ec7000931fc04e144b0a2')]/span[@class='icon icon-search']")
	public WebElement AIMServOpersLookUp;

	@FindBy (xpath = "//input[@class='form-control'and @placeholder = 'Search']")
	public WebElement AIMProgIDinput;// Program id = 3124
	
	@FindBy (xpath = ".//input[contains(@id,'6577d2cc133ec7000931fc04e144b0a2')][not(@type='hidden')]")
	public WebElement AIMProgIDi;// Program id = 3124
	

	@FindBy(xpath = "(//a[@class='glide_ref_item_link'])[1]")
	public WebElement SelectAIMProgID;//Project id = 31245 (need to do indexing)
	
	@FindBy(xpath = "//input[contains(@id,'297d18da132e03c00931fc04e144b062')][not(@type='hidden')]")
	public WebElement ProgManager;
	
	@FindBy(xpath = ".//input[contains(@name,'2bc7b49a132e43c00931fc04e144b019')][@class='questionsetreference form-control element_reference_input']")
	public WebElement ServiceOperationManager;
	
	
	@FindBy(xpath = "//span[@class='icon icon-search']")//need to put index
	public WebElement ProgManagerSearchLookUp;
	
	@FindBy (xpath = "//input[@class='form-control'and @placeholder = 'Search']")
	static WebElement ProgManagerinput;//user id = srinivas.kk

	@FindBy(xpath = "//a[@sys_id='14d090840fd2f50035fde478b1050e6c']")
	public WebElement SelectProgManager;////user id = srinivas.kk

	@FindBy(xpath = ".//select[contains(@id,'abfea962132683040931fc04e144b032')]")
	public WebElement DataClass;
	
	@FindBy(xpath = ".//select[contains(@id,'a46fad66132683040931fc04e144b013')]")
	public WebElement PersonalIdntifiableInfo;
	
	@FindBy(xpath = "//select[contains(@id,'3274ee5adb845780dd3cf5951d9619b5')]")
	public WebElement possibleToIdentifyData;
	
	@FindBy(xpath = "//select[contains(@id,'bbd4669adb845780dd3cf5951d961921')]")
	public WebElement possibleToPreserveData;
	
	@FindBy(xpath = "//select[contains(@id,'6205aa1adb845780dd3cf5951d9619dd')]")
	public WebElement possibleToSuspendroutine;
	
	@FindBy(xpath = "//select[contains(@id,'7725a2dadb845780dd3cf5951d961932')]")
	public WebElement possibleContractualRights;

	@FindBy(xpath = ".//button[@id='order_now']")
	public WebElement Submitbtn;
	
	//Application Card elements
	@FindBy(xpath="(//div[@class='caption category-caption'])[2]")
	public WebElement ApplCard;
	
	@FindBy(xpath=".//span[text()='Application Information']")
	public WebElement ApplInfoSection;
	
	@FindBy(xpath=".//span[text()='Communication']")
	public WebElement CommunicationSection;
	
	@FindBy(xpath=".//span[text()='Support Details']")
	public WebElement ShortDetailsSection;
	
	@FindBy(xpath="//span[text()='Technology Details']")
	public WebElement TechnologyDetailsSection;
	
	@FindBy(xpath="//span[text()='Legal']")
	public WebElement LegalSection;
	
	@FindBy(xpath=".//h3[contains(text(),'Primary Contacts')]")
	public WebElement PrimaryContactsSec;
	
	@FindBy(xpath=".//h3[contains(text(),'Emergency Contacts')]")
	public WebElement EmergencyContactsSec;
	
	@FindBy(xpath=".//h3[contains(text(),'Support Contacts')]")
	public WebElement SupportContactsSec;
	
	@FindBy(xpath="//div[@ng-if = 'appDetailsList.length>5']/div[@class='btn btn-primary see-more-btn'][contains (text(), 'See More')]")
	public WebElement ApplInfoSec_SeeMore;
	
	@FindBy(xpath="//div[@ng-if = 'appDetailsList.length>5']/div[@class='btn btn-primary see-more-btn'][contains (text(), 'See Less')]")
	public WebElement ApplInfoSec_SeeLess;
	
	@FindBy(xpath=".//input[@id='searchapps']")
	public WebElement SearchApplRepository;
	
	@FindBy(xpath=".//ul[@id='ui-id-1']/li")
	public WebElement List_Search_Appl_Repo;
	
	@FindBy(xpath=".//a[contains(text(),'Show More Results')]")
	public WebElement ShowMoreResults_Link;
	
	@FindBy(xpath=".//i[@class='fa fa-search']")
	public WebElement Search_Icon;
	
	//Card and List view elements of My Survey
	
	@FindBy(xpath="//th[contains(text(),'Survey Name')]")
	public WebElement ListSurvey_SurveyName;
	
	@FindBy(xpath="//th[contains(text(),'Application Name')]")
	public WebElement ListSurvey_ApplnName;
	
	@FindBy(xpath="//th[contains(text(),'Expiry')]")
	public WebElement ListSurvey_Expiry;

	//Card View or List View Details	
	@FindBy(xpath="//div[@class='m-b fa fa-th-large fa-2x']")
	public WebElement CardViewIcon;

	@FindBy(xpath="//div[@class='m-b fa fa-th-list fa-2x']")
	public WebElement ListViewIcon;
	
	@FindBy(xpath=".//th[@class='ng-binding ng-scope']")
	public WebElement List_Table;
	
	@FindBy(xpath=".//th[contains (text(), 'Application ID')]")
	public WebElement ListApplicationID;
	
	@FindBy(xpath="(.//td/a[@class='ng-binding'])[1]")
	public WebElement List_ApplicationID_link;
	
	
	@FindBy(xpath=".//th[@class='ng-binding ng-scope'][contains (text(), 'Application Name')]")
	public WebElement List_ApplicationName;
	
	@FindBy(xpath=".//th[contains (text(), 'Application Name')]")
	public WebElement List_ApplicationName;
	
	@FindBy(xpath=".//th[@class='ng-binding ng-scope'][contains (text(), 'Registration Status')]")
	public WebElement List_RegistrationStatus;
	
	@FindBy(xpath=".//th[contains (text(), 'Registration Status')]")
	public WebElement List_RegistrationStatus;
	
	@FindBy(xpath=".//th[@class='ng-binding ng-scope'][contains (text(), 'Application Status')]")
	public WebElement List_ApplicationStatus;
	
	@FindBy(xpath=".//th[contains (text(), 'Application Status')]")
	public WebElement List_ApplicationStatus;
	
	@FindBy(xpath=".//th[@class='ng-binding ng-scope'][contains (text(), 'Description')]")
	public WebElement List_Description ;
	
	@FindBy(xpath=".//th[contains (text(), 'Description')]")
	public WebElement List_Description ;
	
	@FindBy(xpath=".//th[@class='ng-binding ng-scope'][contains (text(), 'Service Tier')]")
	public WebElement List_ServiceTier;
	
	@FindBy(xpath=".//th[contains (text(), 'Service Tier')]")
	public WebElement List_ServiceTier;

	@FindBy(xpath=".//th[@class='ng-binding ng-scope'][contains (text(), 'Service Operations Lead')]")
	public WebElement List_ServiceOpLead;
	
	@FindBy(xpath=".//th[contains (text(), 'Service Operations Lead')]")
	public WebElement List_ServiceOpLead;
	
	@FindBy(xpath=".//th[@class='ng-binding ng-scope'][contains (text(), 'Service Operations Manager')]")
	public WebElement List_ServiceOpManager;
	
	@FindBy(xpath=".//th[contains (text(), 'Service Operations Manager')]")
	public WebElement List_ServiceOpManager;
	
	@FindBy(xpath=".//th[@class='ng-binding ng-scope'][contains (text(), 'Project Lead')]")
	public WebElement List_ProjectLead;
	
	@FindBy(xpath=".//th[contains (text(), 'Project Lead')]")
	public WebElement List_ProjectLead;
	
	@FindBy(xpath=".//th[@class='ng-binding ng-scope'][contains (text(), 'Project Manager')]")
	public WebElement List_ProjectManager;
	
	@FindBy(xpath=".//th[contains (text(), 'Project Manager')]")
	public WebElement List_ProjectManager;
	
	@FindBy(xpath=".//th[@class='ng-binding ng-scope'][contains (text(), 'Component Type')]")
	public WebElement List_ComponentType;
	
	@FindBy(xpath=".//th[contains (text(), 'Component Type')]")
	public WebElement List_ComponentType;
	
	@FindBy(xpath=".//th[@class='ng-binding ng-scope'][contains (text(), 'Organization')]")
	public WebElement List_Organization;
	
	@FindBy(xpath=".//th[contains (text(), 'Organization')]")
	public WebElement List_Organization;
	
	@FindBy(xpath=".//th[@class='ng-binding ng-scope'][contains (text(), 'Reporting Entity')]")
	public WebElement List_ReportingEntity;
	
	@FindBy(xpath=".//th[contains (text(), 'Reporting Entity')]")
	public WebElement List_ReportingEntity;
	
	@FindBy(xpath=".//th[@class='ng-binding ng-scope'][contains (text(), 'Verified By')]")
	public WebElement List_VerifiedBy;
	
	@FindBy(xpath=".//th[contains (text(), 'Verified By')]")
	public WebElement List_VerifiedBy;
	
	@FindBy(xpath=".//th[@class='ng-binding ng-scope'][contains (text(), 'Verified On')]")
	public WebElement List_VerifiedOn;
	
	@FindBy(xpath=".//th[contains (text(), 'Verified On')]")
	public WebElement List_VerifiedOn;
	
	@FindBy(xpath=".//a[@class='view ng-binding']")
	public WebElement ViewAllLink;
	
	@FindBy(xpath=".//b[contains(text(),'Decommissioned')]")
	public WebElement Card_Decomm_Status;
	
	@FindBy(xpath=".//b[contains(text(),'Registration Cancelled')]")
	public WebElement Card_Cancel_Status;
	
	@FindBy(xpath="//div[@class='grid-item item-category']")
	public WebElement CardPage;
	
	@FindBy(xpath="//b[@class='ng-binding'][contains(text(),'Registration Completed')]")
	public WebElement RegCompleted;
	
	@FindBy(xpath="//span[contains(text(),'Registration Completed')]")
	public WebElement RegistrationStatus;
	
	@FindBy(xpath="(.//b[@class='ng-binding'][contains(text(),'Registration In Progress')])[1]")
	public WebElement RegInprogress;
	
	@FindBy(xpath=".//b[@class='ng-binding'][contains(text(),'Verification Completed')]")
	public WebElement VerificationCompl;
	
	@FindBy(xpath=".//span[@class='ng-binding'][contains(text(),'Decommissioned')]")
	public WebElement Decommissioned_Status;
	
	@FindBy(xpath=".//b[contains(text(),'Application Status')]/../parent::div/span[@class='ng-binding']")
	public WebElement ApplStatus_Verification;
	
	@FindBy(xpath="(.//b[@class='ng-binding'][contains(text(),'Registration Cancelled')])[1]")
	public WebElement RegCancelled;
	
	@FindBy(xpath="//a[contains(text(),'My Stuff')]")
	public WebElement MyStuff_link;
	
	@FindBy(xpath="//a[contains(text(),'Approvals')]")
	public WebElement Approvals_link;
	
	
	@FindBy(xpath=".//a[@class='linked formlink']")
	public WebElement ActionOnSelectedRow;
	
	@FindBy(xpath=".//input[@id='check_sc_req_item.sc_task.request_item_ea3c7505db6c134c89185058dc961917']")
	public WebElement TaskNumbercheckbox;
	
	//Closing Task Elements
	
	@FindBy(xpath=".//span[@class = 'input-group-addon-transparent icon-search sysparm-search-icon']")
	public WebElement GlobalSearch_Icon;
	
	@FindBy(xpath=".//input[@id = 'sysparm_search']")
	public WebElement GlobalSearch;
	
	@FindBy(xpath=".//a[@class='linked formlink']")
	public WebElement TaskNumber_Link;
	
	@FindBy(xpath=".//input[@id='sys_readonly.sc_task.number']")
	public WebElement TaskNumber;
	
	
	
	@FindBy(xpath="(.//button[contains(text(),'Close Task')])[1]")
	public WebElement CloseTask_btn;

	
	
	//NonAdmin WebElements
	
	@FindBy(xpath=".//div[@class='user-card-value']")
	public WebElement NonAdminCard;
	
	// Application Details view Page
	
	@FindBy(xpath=".//span[@class='glyphicon glyphicon-th logo ng-scope']")
	public WebElement Image_Icon;
	
	@FindBy(xpath=".//label[@class='labelforupload name ng-binding']")
	public WebElement AppName_AppID;
	
	@FindBy(xpath=".//div[@class='app-link']/a")
	public WebElement URL_Link;
	
	@FindBy(xpath="(.//div[@class='ng-binding'])[1]")
	public WebElement Summary_Description;
	
	@FindBy(xpath=".//div[@class='ng-binding'][contains(text(),'Last Verified By')]")
	public WebElement LastVerifiedBy;
	
	@FindBy(xpath=".//div[@class='ng-binding'][contains(text(),'Last Verified On')]")
	public WebElement LastVerifiedOn;
	
	 Application Information Section fields  
	
	@FindBy(xpath=".//b[contains(text(),'Application Status')]")
	public WebElement ApplicationStatus_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Application Status')]/../parent::div/span[@class='ng-binding']")
	public WebElement ApplicationStatus;
	
	@FindBy(xpath=".//select[contains(@id,'760aaa29dbefc384f945f9a41d961981')]")
	public WebElement ApplicationStatus_InProd;
	
	@FindBy(xpath=".//b[contains(text(),' Service Tier')]")
	public WebElement ServTier_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Service Tier')]/../parent::div/span[contains(text(),'Standard')]")
	public WebElement ServTier;
	
	@FindBy(xpath=".//b[contains(text(),'Organization')]")
	public WebElement Org_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Organization')]/../parent::div/span[contains(text(),'CIO')]")
	public WebElement Org;
	
	@FindBy(xpath=".//b[contains(text(),'Registration Status')]")
	public WebElement RegStatus_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Registration Status')]/../parent::div/span[contains(text(),'Registration Completed')]")
	public WebElement RegStatus_RegCompleted;
	
	@FindBy(xpath=".//b[contains(text(),'Registration Status')]/../parent::div/span[@class='ng-binding']")
	public WebElement RegStatus_RegCancelled;
	
	@FindBy(xpath=".//b[contains(text(),'Registration Status')]/../parent::div/span[@class='ng-binding']")
	public WebElement VerificationStatus_Completed;
	
	@FindBy(xpath=".//b[contains(text(),'Registration Status')]/../parent::div/span[@class='ng-binding']")
	public WebElement VerificationStatus_Incomplete;

	@FindBy(xpath=".//b[contains(text(),'ServiceNow Assignment Groups')]")
	public WebElement SN_AssignmentGroup_Label;
	
	@FindBy(xpath=".//b[contains(text(),'ServiceNow Assignment Groups')]/../parent::div/span[contains(text(),'A&P Initiatives')]")
	public WebElement SN_AssignmentGroup;
	
	@FindBy(xpath=".//b[contains(text(),'User Location')]")
	public WebElement Userlocation_Label;
	
	@FindBy(xpath=".//b[contains(text(),'User Location')]/../parent::div/span[contains(text(),'Specific')]")
	public WebElement Userlocation;
	
	@FindBy(xpath=".//b[contains(text(),'Country')]")
	public WebElement Country_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Country')]/../parent::div/span[contains(text(),'India')]")
	public WebElement Country_Loc;
	
	@FindBy(xpath=".//b[contains(text(),'Responsible Entity')]")
	public WebElement RespnEnty_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Responsible Entity')]/../parent::div/span[contains(text(),'CIO')]")
	public WebElement RespnEnty;	
	
	@FindBy(xpath=".//b[contains(text(),'Acronym')]")
	public WebElement Acronym_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Acronym')]/../parent::div/span[contains(text(),'FMT')]")
	public WebElement Acronym;
	
	@FindBy(xpath=".//b[contains(text(),'Application Type')]")
	public WebElement ApplicationType_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Application Type')]/../parent::div/span[contains(text(),'Business')]")
	public WebElement ApplicationType;
	
	@FindBy(xpath=".//b[contains(text(),'Application Id')]")
	public WebElement Applicationid_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Application Id')]/../parent::div/span[@class='ng-binding']")
	public WebElement Applicationid;
	
	@FindBy(xpath=".//b[contains(text(),'Application Name')]")
	public WebElement ApplicationName_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Application Name')]/../parent::div/span[@class='ng-binding']")
	public WebElement ApplicationName;
	
	@FindBy(xpath=".//b[contains(text(),'Assignment group')]")
	public WebElement Assignmentgroup_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Assignment group')]/../parent::div/span[contains(text(),'A&P Initiatives')]")
	public WebElement Assignmentgroup;
	
	@FindBy(xpath=".//b[contains(text(),'Category')]")
	public WebElement Category_Label;
	
	@FindBy(xpath="(.//b[contains(text(),'Class')])[1]")
	public WebElement Class_Label;
	
	@FindBy(xpath="(.//b[contains(text(),'Class')])[1]/../parent::div/span[@class='ng-binding']")
	public WebElement Class;
	
	@FindBy(xpath=".//b[contains(text(),'Company')]")
	public WebElement Company_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Company')]/../parent::div/span[contains(text(),'3M Company')]")
	public WebElement Company;
	
	@FindBy(xpath=".//b[contains(text(),'Component Type')]")
	public WebElement CompType_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Component Type')]/../parent::div/span[contains(text(),'IT Support Service')]")
	public WebElement CompType;
	
	@FindBy(xpath=".//b[contains(text(),'Created On')]")
	public WebElement Created_On_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Created On')]/../parent::div/span[@class='ng-binding']")
	public WebElement Created_On;
	
	@FindBy(xpath=".//b[contains(text(),'Created By')]")
	public WebElement CreatedBy_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Created By')]/../parent::div/span[@class='ng-binding']")
	public WebElement CreatedBy;
	
	@FindBy(xpath=".//b[contains(text(),'Description')]")
	public WebElement description_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Description')]/../parent::div/span[contains(text(),'RIoT')]")
	public WebElement description;
	
	@FindBy(xpath=".//b[contains(text(),'First Go-Live Date')]")
	public WebElement FirstGo_LiveDate_Label;
	
	@FindBy(xpath=".//b[contains(text(),'First Go-Live Date')]/../parent::div/span[@class='ng-binding']")
	public WebElement FirstGo_LiveDate;
	
	@FindBy(xpath=".//b[contains(text(),'Last Modified By')]")
	public WebElement LastModifiedBy_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Last Modified By')]/../parent::div/span[contains(text(),'jose.luis.o.domingo')]")
	public WebElement LastModifiedBy;
	
	@FindBy(xpath=".//b[contains(text(),'Last Modified On')]")
	public WebElement LastModifiedOn_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Last Modified On')]/../parent::div/span[@class='ng-binding']")
	public WebElement LastModifiedOn;
	
	@FindBy(xpath=".//b[contains(text(),'Location')]")
	public WebElement Location_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Location')]/../parent::div/span[contains(text(),'Bang 6')]")
	public WebElement Location;
	
	@FindBy(xpath=".//b[contains(text(),'Maintenance Schedule')]")
	public WebElement Maintenanceschedule_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Maintenance schedule')]/../parent::div/span[contains(text(),'(OS) 24x5 INDIA With Holidays')]")
	public WebElement Maintenanceschedule;
	
	@FindBy(xpath=".//b[contains(text(),'Number of End Users')]")
	public WebElement NumberofEndUsers_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Number of End Users')]/../parent::div/span[contains(text(),'1 - 1,000')]")
	public WebElement NumberofEndUsers;
	
	@FindBy(xpath=".//b[contains(text(),'Parent Application')]")
	public WebElement ParentApplication_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Parent Application')]/../parent::div/span[contains(text(),'Not Applicable')]")
	public WebElement ParentApplication;
	
	@FindBy(xpath=".//b[contains(text(),'Reporting Entity')]")
	public WebElement ReportingEntity_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Reporting Entity')]/../parent::div/span[contains(text(),'Billing/AR')]")
	public WebElement ReportingEntity;
	
	@FindBy(xpath=".//b[contains(text(),'URL')]")
	public WebElement URL_Label;
	
	@FindBy(xpath=".//b[contains(text(),'URL')]/../parent::div/span[contains(text(),'www.google.com')]")
	public WebElement URL;
		
	@FindBy(xpath=".//b[contains(text(),'Verified By')]")
	public WebElement Verifiedby_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Verified By')]/../parent::div/span[contains(text(),'kirthiga.tamilarasan.admin')]")
	public WebElement Verifiedby;
	
	@FindBy(xpath=".//b[contains(text(),'Verified On')]")
	public WebElement Verifiedon_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Verified On ')]/../parent::div/span[@class='ng-binding']")
	public WebElement Verifiedon;
	
	Communication Section fields
	
	@FindBy(xpath=".//b[contains(text(),'Primary Communication Contact (CIO)')]")
	public WebElement PrimaryCommContactCIO_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Primary Communication Contact (CIO)')]/../parent::div/span[contains(text(),'kirthi.chawla')]")
	public WebElement PrimaryCommContactCIO;
	
	@FindBy(xpath=".//b[contains(text(),'Does the application have a Gone Fishing page enabled?')]")
	public WebElement ApplGoneFishingPage_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Does the application have a Gone Fishing page enabled?')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement ApplGoneFishingPage_Yes;
	
	@FindBy(xpath=".//b[contains(text(),'Does the application have a Gone Fishing page enabled?')]/../parent::div/span[contains(text(),'No')]")
	public WebElement ApplGoneFishingPage_No;
	
	@FindBy(xpath=".//b[contains(text(),'End User Support Site URL')]")
	public WebElement EndUserSuppSiteURL_Label;
	
	@FindBy(xpath=".//b[contains(text(),'End User Support Site URL')]/../parent::div/span[contains(text(),'https://Testing.com')]")
	public WebElement EndUserSuppSiteURL;
	
	@FindBy(xpath=".//b[contains(text(),'Primary Communication Contact (Business)')]")
	public WebElement PrimCommContactBusiness_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Primary Communication Contact (Business)')]/../parent::div/span[contains(text(),'piyush.kumar.shukla')]")
	public WebElement PrimCommContactBusiness;
	
	@FindBy(xpath=".//b[contains(text(),'What is the in-app notification tool?')]")
	public WebElement AppNotiTool_Label;
	
	@FindBy(xpath=".//b[contains(text(),'What is the in-app notification tool?')]/../parent::div/span[contains(text(),'rebar')]")
	public WebElement AppNotiTool;
	
	@FindBy(xpath=".//b[contains(text(),'Who is your primary user group(s)?')]")
	public WebElement primaryUsergroup_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Who is your primary user group(s)?')]/../parent::div/span[contains(text(),'All Accenture Employees')]")
	public WebElement primaryUsergroup;
	
	@FindBy(xpath=".//div[@ng-if = 'communicationList.length>1']/div[@class='btn btn-primary see-more-btn']/p[contains (text(), 'See More')]")
	public WebElement Commu_SeeMore;
	
	@FindBy(xpath=".//div[@ng-if = 'communicationList.length>1']/div[@class='btn btn-primary see-more-btn']/p[contains (text(), 'See Less')]")
	public WebElement Commu_SeeLess;
	
	 Support Section fields  
	
	@FindBy(xpath=".//b[contains(text(),'Special Contact Instructions')]")
	public WebElement SpecContactInstr_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Special Contact Instructions')]/../parent::div/span[contains(text(),'test')]")
	public WebElement SpecContactInstr;
	
	@FindBy(xpath=".//b[contains(text(),'AIM Program ID')]")
	public WebElement AIMProgID_Label;
	
	@FindBy(xpath=".//b[contains(text(),'AIM Program ID')]/../parent::div/span[contains(text(),'31615')]")
	public WebElement AIMProgID;
	
	@FindBy(xpath=".//b[contains(text(),'AIM Service Operations ID')]")
	public WebElement AIMServiceOpsID_Label;
	
	@FindBy(xpath=".//b[contains(text(),'AIM Service Operations ID')]/../parent::div/span[contains(text(),'31361')]")
	public WebElement AIMServiceOpsID;
	
	@FindBy(xpath=".//b[contains(text(),'Database Delivery Manager')]")
	public WebElement DataBaseDelManager_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Database Delivery Manager')]/../parent::div/span[contains(text(),'gurunagaraj.algud')]")
	public WebElement DataBaseDelManager;
	
	@FindBy(xpath=".//b[contains(text(),'Development Lead')]")
	public WebElement DevelopmentLead_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Development Lead')]/../parent::div/span[contains(text(),'sandeep.tanwar')]")
	public WebElement DevelopmentLead;
	
	@FindBy(xpath=".//b[contains(text(),'Environment Delivery Manager')]")
	public WebElement EnviDelivMgr_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Environment Delivery Manager')]/../parent::div/span[contains(text(),'deepa.antony')]")
	public WebElement EnviDelivMgr;
	
	@FindBy(xpath=".//b[contains(text(),'Internal Operations Support URL')]")
	public WebElement IntOpsSuppURL_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Internal Operations Support URL')]/../parent::div/span[contains(text(),'https://abc.com')]")
	public WebElement IntOpsSuppURL;
	
	@FindBy(xpath=".//b[contains(text(),'Last Disaster Recovery Test')]")
	public WebElement LastDisasterRecTest_Label;
	
	@FindBy(xpath="//b[contains(text(),'Last Disaster Recovery Test')]/../parent::div/span[@class='ng-binding']")
	public WebElement LastDisasterRecTest;
	
	@FindBy(xpath=".//b[contains(text(),'Next Planned Disaster Recovery Test')]")
	public WebElement NxtPlnDisaRCTest_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Next Planned Disaster Recovery Test')]/../parent::div/span[@class='ng-binding']")
	public WebElement NxtPlnDisaRCTest;
	
	@FindBy(xpath=".//b[contains(text(),'Overall Capability MD')]")
	public WebElement OverallCapaMD_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Overall Capability MD')]/../parent::div/span[contains(text(),'ads.mkolli')]")
	public WebElement OverallCapaMD;
	
	@FindBy(xpath=".//b[contains(text(),'Program Capability Lead')]")
	public WebElement ProgCapaLead_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Program MD')]")
	public WebElement ProgMD_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Program MD')]/../parent::div/span[contains(text(),'saran.prasad')]")
	public WebElement ProgMD;
	
	@FindBy(xpath=".//b[contains(text(),'Program Manager')]")
	public WebElement ProgramManager_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Program Manager')]/../parent::div/span[contains(text(),'srinivas.kk')]")
	public WebElement ProgramManager;
	
	@FindBy(xpath=".//b[contains(text(),'Program Portfolio')]")
	public WebElement ProgramPortfolio_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Program Portfolio')]/../parent::div/span[contains(text(),'Sampat')]")
	public WebElement ProgramPortfolio;
	
	@FindBy(xpath=".//b[contains(text(),'Primary Deployment Manager')]")
	public WebElement PrimDeplyMgr_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Primary Deployment Manager')]/../parent::div/span[contains(text(),'krithi.anand')]")
	public WebElement PrimDeplyMgr;
	
	@FindBy(xpath=".//b[contains(text(),'SOH Management Application')]")
	public WebElement SOHMangAppl_Legal;
	
	@FindBy(xpath=".//b[contains(text(),'SOH Management Application')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement SOHMangAppl_Yes;
	
	@FindBy(xpath=".//b[contains(text(),'SOH Management Application')]/../parent::div/span[contains(text(),'No')]")
	public WebElement SOHMangAppl_No;
	
	@FindBy(xpath=".//b[contains(text(),'Secondary Deployment Manager')]")
	public WebElement SecDeployMgr_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Secondary Deployment Manager')]/../parent::div/span[contains(text(),'test1')]")
	public WebElement SecDeployMgr;
	
	@FindBy(xpath=".//b[contains(text(),'Service Operations Portfolio')]")
	public WebElement SecOpsPortfolio_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Service Operations Portfolio')]/../parent::div/span[contains(text(),'CIO Operations')]")
	public WebElement SecOpsPortfolio;
	
	@FindBy(xpath=".//b[contains(text(),'Technology Architecture Lead')]")
	public WebElement TechArchLead_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Technology Architecture Lead')]/../parent::div/span[contains(text(),'sandeep.tanwar')]")
	public WebElement TechArchLead;
	
	@FindBy(xpath=".//div[@ng-if = 'supportList.length>1']/div[@class='btn btn-primary see-more-btn']/p[contains (text(), 'See More')]")
	public WebElement Support_SeeMore;
	
	@FindBy(xpath=".//div[@ng-if = 'supportList.length>1']/div[@class='btn btn-primary see-more-btn']/p[contains (text(), 'See Less')]")
	public WebElement Support_SeeLess;
	
	Technology Sections WebElements
	
	@FindBy(xpath=".//span[contains(text(),'Technology Architecture')]")
	public WebElement TechArchitecture_Header_sec;
	
	@FindBy(xpath=".//b[contains(text(),'Technology Architecture')]")
	public WebElement TechArchitecture_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Technology Architecture')]/../parent::div/span[contains(text(),'https://ta357.accenture.com/Info/Applications/105')]")
	public WebElement TechArchitecture;
	
	@FindBy(xpath=".//b[contains(text(),'Is this application web enabled')]")
	public WebElement AccessedOnline_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Is this application web enabled')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement AccessedOnline_Yes;
	
	@FindBy(xpath=".//b[contains(text(),'Is this application web enabled? (accessed online)')]/../parent::div/span[contains(text(),'No')]")
	public WebElement AccessedOnline_No;
	
	@FindBy(xpath=".//b[contains(text(),'Is this application downloaded and run on workstations?')]")
	public WebElement WorkStation_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Is this application downloaded and run on workstations?')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement WorkStation_Yes;
	
	@FindBy(xpath=".//b[contains(text(),'Is this application downloaded and run on workstations?')]/../parent::div/span[contains(text(),'No')]")
	public WebElement WorkStation_No;
	
	@FindBy(xpath=".//b[contains(text(),'Additonal Detail')]")
	public WebElement AdditionDetail_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Additonal Detail')]/../parent::div/span[contains(text(),'test789')]")
	public WebElement AdditionDetail;
	
	@FindBy(xpath=".//b[contains(text(),'Environment')]")
	public WebElement Environment_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Environment')]/../parent::div/span[contains(text(),'Production')]")
	public WebElement Environment;
	
	@FindBy(xpath=".//b[contains(text(),'LastModified On')]")
	public WebElement LstModiOn_Label;
	
	@FindBy(xpath=".//b[contains(text(),'LastModified On')]/../parent::div/span[@class='ng-binding']")
	public WebElement LstModiOn;
	
	@FindBy(xpath=".//b[contains(text(),'LastModified by')]")
	public WebElement LstModiby_Label;
	
	@FindBy(xpath=".//b[contains(text(),'LastModified by')]/../parent::div/span[contains(text(),'kirthiga.tamilarasan.admin')]")
	public WebElement LstModiby;
	
	@FindBy(xpath=".//b[contains(text(),'Location')]")
	public WebElement Loc_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Location')]/../parent::div/span[contains(text(),'NTTA')]")
	public WebElement Loc;
	
	@FindBy(xpath=".//b[contains(text(),'Mobile capability')]/../parent::div/span[@class='ng-binding']")
	public WebElement MobileCapability;
	
	@FindBy(xpath=".//b[contains(text(),'Mobile capability')]")
	public WebElement MobileCapability_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Technical Architecture')]/../parent::div/span[@class='ng-binding']")
	public WebElement TechnologyArchitecture;
	
	@FindBy(xpath=".//b[contains(text(),'Technical Architecture')]")
	public WebElement TechnologyArchitecture_Label;
	
	@FindBy(xpath=".//span[@class='title ng-binding']")
	public WebElement Techno_TCN_Num;
	
	@FindBy(xpath="(.//b[contains(text(),'Application Id')])[2]")
	public WebElement Techno_Appl_id_Label;
	
	@FindBy(xpath="(.//b[contains(text(),'Application Id')])[2]//../parent::div/span[@class='ng-binding']")
	public WebElement Techno_Appl_id;
	
	@FindBy(xpath="//*[contains(text(),'TCN')][@class='title ng-binding']/parent::div/following-sibling::div/div/div/span/b[contains(text(),'Application Id')]/parent::span/following-sibling::span")
	public WebElement Techno_Appl_id;	
	
	@FindBy(xpath="(.//b[contains(text(),'Location')])[2]")
	public WebElement Techno_Location_Label;
	
	@FindBy(xpath="(.//b[contains(text(),'Location')])[2]//../parent::div/span[@class='ng-binding']")
	public WebElement Techno_Location;
	
	@FindBy(xpath="//*[contains(text(),'TCN')][@class='title ng-binding']/parent::div/following-sibling::div/div/div/span/b[contains(text(),'Location')]")
	public WebElement Techno_Location_Label;
	
	@FindBy(xpath="//*[contains(text(),'TCN')][@class='title ng-binding']/parent::div/following-sibling::div/div/div/span/b[contains(text(),'Number')]")
	public WebElement Techno_Number_Label;
	
	@FindBy(xpath="(.//b[contains(text(),'Number')])[2]//../parent::div/span[@class='ng-binding']")
	public WebElement Techno_Number;
	
	@FindBy(xpath="//*[contains(text(),'TCN')][@class='title ng-binding']/parent::div/following-sibling::div/div/div/span/b[contains(text(),'Number')]/parent::span/following-sibling::span")
	public WebElement Techno_Number;
	
	@FindBy(xpath=".//b[contains(text(),'Product')]")
	public WebElement Product_Label;
	
	@FindBy(xpath="//b[contains(text(),'Product')]/../parent::div/span[contains(text(),'test2')]")
	public WebElement Product;
	
	@FindBy(xpath=".//b[contains(text(),'Provisioning')]")
	public WebElement Provisioning_Label;
	
	@FindBy(xpath="//b[contains(text(),'Provisioning')]/../parent::div/span[contains(text(),'Supplier Direct')]")
	public WebElement Provisioning;
	
	@FindBy(xpath=".//b[contains(text(),'Supplier')]")
	public WebElement Supplier_Label;
	
	@FindBy(xpath="//b[contains(text(),'Supplier')]/../parent::div/span[contains(text(),'test1')]")
	public WebElement Supplier;
	
	@FindBy(xpath=".//b[contains(text(),'Type')]")
	public WebElement Type_Label;
	
	@FindBy(xpath="//b[contains(text(),'Type')]/../parent::div/span[contains(text(),'Software')]")
	public WebElement Type;
	
	@FindBy(xpath=".//b[contains(text(),'Vendor Details')]")
	public WebElement VendorDetails;
	
	@FindBy(xpath=".//div[@ng-if = 'technologyList.length>3']/div[@class='btn btn-primary see-more-btn']/p[contains (text(), 'See More')]")
	public WebElement Tech_SeeMore;
	
	@FindBy(xpath=".//div[@ng-if = 'technologyList.length>3']/div[@class='btn btn-primary see-more-btn']/p[contains (text(), 'See Less')]")
	public WebElement Tech_SeeLess;
	
	Legal Section WebElements
	
	@FindBy(xpath=".//b[contains(text(),'Data Classification')]")
	public WebElement DataClassi_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Data Classification')]/../parent::div/span[contains(text(),'Highly Confidential')]")
	public WebElement DataClassi;
	 
	@FindBy(xpath=".//b[contains(text(),'Personally identifiable information')]")
	public WebElement PersIdentiInfo_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Personally identifiable information')]/../parent::div/span[contains(text(),'No')]")
	public WebElement PersIdentiInfo_No;	
	
	@FindBy(xpath=".//b[contains(text(),'Personally identifiable information')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement PersIdentiInfo_Yes;
	
	@FindBy(xpath=".//b[contains(text(),'VIP Enabled?')]")
	public WebElement VIPEnabled_Label;
	
	@FindBy(xpath=".//b[contains(text(),'VIP Enabled?')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement VIPEnabled_Yes;
	
	@FindBy(xpath=".//b[contains(text(),'VIP Enabled?')]/../parent::div/span[contains(text(),'No')]")
	public WebElement VIPEnabled_No;
	
	@FindBy(xpath=".//b[contains(text(),'Web App Security (WAS) managed?')]")
	public WebElement WebAppSecManaged_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Web App Security (WAS) managed?')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement WebAppSecManaged_Yes;
	
	@FindBy(xpath=".//b[contains(text(),'Web App Security (WAS) managed?')]/../parent::div/span[contains(text(),'No')]")
	public WebElement WebAppSecManaged_No;
	
	@FindBy(xpath=".//b[contains(text(),'Does the system contain Sensitive Data')]")
	public WebElement SysContSensiData_Label;
	
	@FindBy(xpath="//b[contains(text(),'Does the system contain Sensitive Data')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement SysContSensiData_Yes;
	
	@FindBy(xpath="//b[contains(text(),'Does the system contain Sensitive Data')]/../parent::div/span[contains(text(),'No')]")
	public WebElement SysContSensiData_No;
	
	@FindBy(xpath=".//b[contains(text(),'Does the system contain Accenture Federal Services (AFS) data and/or do AFS Employees use the system')]")
	public WebElement AFSEmployees_Lable;
	
	@FindBy(xpath=".//b[contains(text(),'Does the system contain Accenture Federal Services (AFS) data and/or do AFS Employees use the system')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement AFSEmployees_Yes;
	
	@FindBy(xpath=".//b[contains(text(),'Does the system contain Accenture Federal Services (AFS) data and/or do AFS Employees use the system')]/../parent::div/span[contains(text(),'No')]")
	public WebElement AFSEmployees_No;
	
	@FindBy(xpath=".//b[contains(text(),'Does the system contain Client Owned Data')]")
	public WebElement ClientOwnData_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Does the system contain Client Owned Data')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement ClientOwnData_Yes;
	
	@FindBy(xpath=".//b[contains(text(),'Does the system contain Client Owned Data')]/../parent::div/span[contains(text(),'No')]")
	public WebElement ClientOwnData_No;
	
	@FindBy(xpath=".//b[contains(text(),'Has the AIR Legal Tab been completed?')]")
	public WebElement AIRLegal_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Has the AIR Legal Tab been completed?')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement AIRLegal_Yes;
	
	@FindBy(xpath=".//b[contains(text(),'Has the AIR Legal Tab been completed?')]/../parent::div/span[contains(text(),'No')]")
	public WebElement AIRLegal_No;
	
	@FindBy(xpath=".//b[contains(text(),'In the event of a Hold Notice, is it possible to suspend routine purging/archiving?')]")
	public WebElement Archiving_Label;
	
	@FindBy(xpath=".//b[contains(text(),'In the event of a Hold Notice, is it possible to suspend routine purging/archiving?')]/../parent::div/span[contains(text(),'No')]")
	public WebElement Archiving_No;	
	
	@FindBy(xpath=".//b[contains(text(),'In the event of a Hold Notice, is it possible to suspend routine purging/archiving?')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement Archiving_Yes;
	
	@FindBy(xpath=".//b[contains(text(),'Is it possible / within contractual rights to extract data that may be subject to a Hold Notice?')]")
	public WebElement ContractualHoldNotice_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Is it possible / within contractual rights to extract data that may be subject to a Hold Notice?')]/../parent::div/span[contains(text(),'No')]")
	public WebElement ContractualHoldNotice_No;
	
	@FindBy(xpath=".//b[contains(text(),'Is it possible / within contractual rights to extract data that may be subject to a Hold Notice?')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement ContractualHoldNotice_Yes;
	
	@FindBy(xpath=".//b[contains(text(),'Is it possible to identify data relevant to a Hold Notice?')]")
	public WebElement HldNotice_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Is it possible to identify data relevant to a Hold Notice?')]/../parent::div/span[contains(text(),'No')]")
	public WebElement HldNotice_No;
	
	@FindBy(xpath=".//b[contains(text(),'Is it possible to identify data relevant to a Hold Notice?')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement HldNotice_Yes;
	
	@FindBy(xpath=".//b[contains(text(),'Is it possible to preserve data that may be subject to a Hold Notice?')]")
	public WebElement PreserveData_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Is it possible to preserve data that may be subject to a Hold Notice?')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement PreserveData_Yes;
	
	@FindBy(xpath=".//b[contains(text(),'Is it possible to preserve data that may be subject to a Hold Notice?')]/../parent::div/span[contains(text(),'No')]")
	public WebElement PreserveData_No;
	
	@FindBy(xpath=".//b[contains(text(),'PAM Managed - Application ID?')]")
	public WebElement PAMApplID_Label;
	
	@FindBy(xpath=".//b[contains(text(),'PAM Managed - Application ID?')]/../parent::div/span[contains(text(),'No')]")
	public WebElement PAMApplID_No;
	
	@FindBy(xpath=".//b[contains(text(),'PAM Managed - Application ID?')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement PAMApplID_Yes;
	
	@FindBy(xpath=".//b[contains(text(),'PAM Managed - Built-in?')]")
	public WebElement Built_In_Label;
	
	@FindBy(xpath=".//b[contains(text(),'PAM Managed - Built-in?')]/../parent::div/span[contains(text(),'No')]")
	public WebElement Built_In_No;
	
	@FindBy(xpath=".//b[contains(text(),'PAM Managed - Built-in?')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement Built_In_Yes;
	
	@FindBy(xpath=".//b[contains(text(),'PAM Managed - Firefighter?')]")
	public WebElement Firefighter_Label;
	
	@FindBy(xpath=".//b[contains(text(),'PAM Managed - Firefighter?')]/../parent::div/span[contains(text(),'No')]")
	public WebElement Firefighter_No;
	
	@FindBy(xpath=".//b[contains(text(),'PAM Managed - Firefighter?')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement Firefighter_Yes;
	
	@FindBy(xpath=".//b[contains(text(),'PAM Managed - Tempadmin?')]")
	public WebElement TeamAdmin_Label;
	
	@FindBy(xpath=".//b[contains(text(),'PAM Managed - Tempadmin?')]/../parent::div/span[contains(text(),'No')]")
	public WebElement TeamAdmin_No;
	
	@FindBy(xpath=".//b[contains(text(),'PAM Managed - Tempadmin?')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement TeamAdmin_Yes;
	
	@FindBy(xpath=".//b[contains(text(),'Sarbox Application')]")
	public WebElement Sarbox_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Sarbox Application')]/../parent::div/span[contains(text(),'Yes')]")
	public WebElement Sarbox_Yes;
	
	@FindBy(xpath=".//b[contains(text(),'Sarbox Application')]/../parent::div/span[contains(text(),'No')]")
	public WebElement Sarbox_No;
	
	@FindBy(xpath=".//b[contains(text(),'What country is the Production system(s) data stored in?')]")
	public WebElement ProductionSystem_Label;
	
	@FindBy(xpath=".//b[contains(text(),'What country is the Production system(s) data stored in?')]/../parent::div/span[contains(text(),'Benin')]")
	public WebElement ProductionSystem;
	
	@FindBy(xpath=".//b[contains(text(),'Who can see data in the system?')]")
	public WebElement DatainSys_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Who can see data in the system?')]/../parent::div/span[contains(text(),'everyone')]")
	public WebElement DatainSys;
	
	@FindBy(xpath=".//b[contains(text(),'Who uses the system?')]")
	public WebElement WhoUsesSystem_Label;
	
	@FindBy(xpath=".//b[contains(text(),'Who uses the system?')]/../parent::div/span[contains(text(),'Specific Functions/Teams only')]")
	public WebElement WhoUsesSystem;
	
	@FindBy(xpath=".//div[@ng-if = 'legalList.length>4']/div[@class='btn btn-primary see-more-btn']/p[contains (text(), 'See More')]")
	public WebElement Legal_SeeMore;
	
	@FindBy(xpath=".//div[@ng-if = 'legalList.length>4']/div[@class='btn btn-primary see-more-btn']/p[contains (text(), 'See More')]")
	public WebElement Legal_SeeMore_Label;
	
	@FindBy(xpath=".//div[@ng-if = 'legalList.length>4']/div[@class='btn btn-primary see-more-btn']/p[contains (text(), 'See Less')]")
	public WebElement Legal_SeeLess;
	
	Primary Contacts WebElements 
	
	@FindBy(xpath=".//h3[contains(text(),'Primary Contacts')]")
	public WebElement PrimaryContacts_Label;
	
	@FindBy(xpath=".//label[contains(text(),'Program Lead')]")
	public WebElement PrimProgLeadName_Label;
	
	@FindBy(xpath=".//label[contains(text(),'Program Lead')]/parent::div/following-sibling::div/a/i[@class='fa fa-skype fa-lg disableicon']")
	public WebElement PrimProgLead_Skypeimage;
	
	@FindBy(xpath=".//label[contains(text(),'Program Lead')]/parent::div/following-sibling::div/a/i[@class='fa fa-envelope fa-lg disableicon']")
	public WebElement PrimProgLead_Outlookimage;
	
	@FindBy(xpath=".//label[contains(text(),'Program Manager')]")
	public WebElement PrimProgMgrName_Label;
	
	@FindBy(xpath=".//label[contains(text(),'srinivas.kk')]")
	public WebElement PrimProgMgrName;
	
	@FindBy(xpath=".//label[contains(text(),'Program Manager')]/parent::div/following-sibling::div/a/i[@class='fa fa-skype fa-lg']")
	public WebElement PrimProgMgr_Skypeimage;
	
	@FindBy(xpath=".//label[contains(text(),'Program Manager')]/parent::div/following-sibling::div/a/i[@class='fa fa-envelope fa-lg']")
	public WebElement PrimProgMgr_Outlookimage;
	
	@FindBy(xpath=".//label[contains(text(),'Program MD')]")
	public WebElement PrimProgMD_Label;
	
	@FindBy(xpath=".//label[contains(text(),'saran.prasad')]")
	public WebElement PrimProgMDName;
	
	@FindBy(xpath=".//label[contains(text(),'+919811882419')]")
	public WebElement PrimProgMDPHNumber;
	
	@FindBy(xpath=".//label[contains(text(),'Program MD')]/parent::div/following-sibling::div/a/i[@class='fa fa-skype fa-lg']")
	public WebElement PrimProgMD_Skypeimage;
	
	@FindBy(xpath=".//label[contains(text(),'Program MD')]/parent::div/following-sibling::div/a/i[@class='fa fa-envelope fa-lg']")
	public WebElement PrimProgMD_Outlookimage;
	
	@FindBy(xpath=".//label[contains(text(),'jooju.ramakrishnan.t')]")
	public WebElement PrimServOprsLeadName;
	
	@FindBy(xpath=".//label[contains(text(),'Service Operations Lead')]")
	public WebElement PrimServiceOperLead_Label;
	
	@FindBy(xpath=".//label[contains(text(),'+91 99 0087 2690')]")
	public WebElement PrimServiceOperLeadPHNumber;
	
	@FindBy(xpath=".//label[contains(text(),'jooju.ramakrishnan.t')]/parent::div/following-sibling::div/a/i[@class='fa fa-skype fa-lg']")
	public WebElement PrimServiceOperLead_Skypeimage;
	
	@FindBy(xpath=".//label[contains(text(),'jooju.ramakrishnan.t')]/parent::div/following-sibling::div/a/i[@class='fa fa-envelope fa-lg']")
	public WebElement PrimServiceOperLead_OutlookImage;
	
	@FindBy(xpath=".//label[contains(text(),'rajesh.marak')]")
	public WebElement PrimServOpsMgrName;
	
	@FindBy(xpath=".//label[contains(text(),'Service Operations Manager')]")
	public WebElement PrimServOpsMgr_Label;
	
	@FindBy(xpath=".//label[contains(text(),'+919717273945')]")
	public WebElement PrimServiceOperMgrPHNumber;
	
	@FindBy(xpath=".//label[contains(text(),'rajesh.marak')]/../parent::div/div/a/i[@class='fa fa-skype fa-lg']")
	public WebElement PrimServOpsMgr_SkypeImage;
	
	@FindBy(xpath=".//label[contains(text(),'rajesh.marak')]/../parent::div/div/a/i[@class='fa fa-envelope fa-lg']")
	public WebElement PrimServOpsMgr_OutLookImage;
	
	@FindBy(xpath=".//label[contains(text(),'rahul.maheshwari')]")
	public WebElement PrimServOpsMDName;
		
	@FindBy(xpath=".//label[contains(text(),'Service Operations MD')]")
	public WebElement PrimServOpsMD_Label;
	
	@FindBy(xpath=".//label[contains(text(),'+919845900486')]")
	public WebElement PrimServOpsMDPhNumber;
	
	@FindBy(xpath=".//label[contains(text(),'rahul.maheshwari')]/../parent::div/div/a/i[@class='fa fa-skype fa-lg']")
	public WebElement PrimServOpsMD_SkypeImage;
	
	@FindBy(xpath=".//label[contains(text(),'rahul.maheshwari')]/../parent::div/div/a/i[@class='fa fa-envelope fa-lg']")
	public WebElement PrimServOpsMD_OutLookImage;

	Emergency Contacts WebElements
	
	@FindBy(xpath=".//h3[contains(text(),'Emergency Contacts')]")
	public WebElement EmerContacts_Label;
	
	@FindBy(xpath=".//label[contains(text(),'Tom')]")
	public WebElement Emer_Primary_Contact_Name;
	
	@FindBy(xpath=".//label[contains(text(),'Primary')]")
	public WebElement Emer_Primary_Label;
	
	@FindBy(xpath=".//div[@class='col-xs-6 user-info']/label[contains(text(),'879878987')]")
	public WebElement Emer_Primary_PHNumber;
	
	@FindBy(xpath=".//label[contains(text(),'Tom')]/parent::div/following-sibling::div/a/i[@class='fa fa-skype fa-lg disableicon']")
	public WebElement Emer_Primary_Skypeimage;
	
	@FindBy(xpath=".//label[contains(text(),'Tom')]/parent::div/following-sibling::div/a/i[@class='fa fa-envelope fa-lg disableicon']")
	public WebElement Emer_Primary_OutlookImage;
	
	@FindBy(xpath=".//label[contains(text(),'Kinjal Algud')]")
	public WebElement Emer_Secondary_Contact_Name;
	
	@FindBy(xpath=".//label[contains(text(),'Secondary')]")
	public WebElement Emer_Secondary_Label;
	
	@FindBy(xpath=".//div[@class='col-xs-6 user-info']/label[contains(text(),' 990058794')]")
	public WebElement Emer_Secondary_PHNumber;
	
	@FindBy(xpath=".//label[contains(text(),'Kinjal Algud')]/../parent::div/div/a/i[@class='fa fa-skype fa-lg disableicon']")
	public WebElement Emer_Secondary_SkypeImage;
	
	@FindBy(xpath=".//label[contains(text(),'Kinjal Algud')]/../parent::div/div/a/i[@class='fa fa-envelope fa-lg disableicon']")
	public WebElement Emer_Secondary_OutLookImage;
	
	@FindBy(xpath=".//div[@class='col-xs-6 user-info']/label[contains(text(),'Richard')]")
	public WebElement Tertiary_Contact_Name;
	
	@FindBy(xpath=".//label[contains(text(),'Tertiary')]")
	public WebElement Emer_Tertiary_Label;
	
	@FindBy(xpath=".//div[@class='col-xs-6 user-info']/label[contains(text(),'9879654')]")
	public WebElement Emer_Tertiary_PHNumber;
	
	@FindBy(xpath=".//label[contains(text(),'Richard')]/../parent::div/div/a/i[@class='fa fa-skype fa-lg disableicon']")
	public WebElement Emer_Tertiary_SkypeImage;
	
	@FindBy(xpath=".//label[contains(text(),'Richard')]/../parent::div/div/a/i[@class='fa fa-envelope fa-lg disableicon']")
	public WebElement Emer_Tertiary_OutLookImage;
	
	Support Contacts WebElements
	@FindBy(xpath=".//h3[contains(text(),'Support Contacts')]")
	public WebElement SupportContacts_Lable;
	
	@FindBy(xpath=".//label[contains(text(),'P1 Contact')]")
	public WebElement P1_Contact_Label;
	
	@FindBy(xpath=".//label[contains(text(),'Rani')]")
	public WebElement P1_Contact;
	
	@FindBy(xpath=".//label[contains(text(),'Rani')]/../parent::div/div/a/i[@class='fa fa-envelope fa-lg disableicon']")
	public WebElement P1Contact_OutLookImage;
	
	@FindBy(xpath=".//label[contains(text(),'P2 Contact')]")
	public WebElement P2_Contact_Label;
	
	@FindBy(xpath=".//label[contains(text(),'Harshit')]")
	public WebElement P2_Contact;
	
	@FindBy(xpath=".//label[contains(text(),'Harshit')]/../parent::div/div/a/i[@class='fa fa-envelope fa-lg disableicon']")
	public WebElement P2Contact_OutLookImage;

	@FindBy(xpath=".//label[contains(text(),'General Ops Email')]")
	public WebElement Gen_Ops_Email_Label;
	
	@FindBy(xpath=".//label[contains(text(),'OperSupportEmail@abc.com')]/../parent::div/div/a/i[@class='fa fa-envelope fa-lg disableicon']")
	public WebElement GenOpersEmail_OutLookImage;

	@FindBy(xpath=".//label[contains(text(),'ghalgud@gmail.com ')]")
	public WebElement Gen_Ops_Email;
	
	@FindBy(xpath=".//label[contains(text(),'General Ops Phone Number (Optional)')]")
	public WebElement GeneralOpsPhoneNumber_Label;
	
	@FindBy(xpath=".//label[contains(text(),'234235353')]")
	public WebElement GeneralOpsPhoneNumber;
	
	@FindBy(xpath=".//label[contains(text(),'Chat/Skype ID')]")
	public WebElement Chat_SkypeID_Label;
	
	@FindBy(xpath=".//label[contains(text(),'guru.algud')]")
	public WebElement Chat_SkypeID;
	
	@FindBy(xpath=".//label[contains(text(),'gurutest123')]/../parent::div/div/a/i[@class='fa fa-skype fa-lg disableicon']")
	public WebElement ChatSkype_OutLookImage;
	
	//Register Page
	
	@FindBy(xpath="//div[@class='tile-title highlight']/b[contains(text(),'Registration In Progress')]")
	public WebElement RegisterationInprogress_CardStatus;
	
	@FindBy(xpath=".//button[@class='btn btn-primary ok-btn'][contains(text(),'Register')]")
	public WebElement Registerbtn;
	//Edit Page
	
	@FindBy(xpath="//div[@class='tile-title highlight']/b[contains(text(),'Registration Completed')]")
	public WebElement RegisterationCompleted_CardStatus;
	
	@FindBy(xpath=".//select[contains(@id,'9d28d3b1dbd81b40f945f9a41d961955')]")
	public WebElement AIRLegalTab_Edit;
	
	@FindBy(xpath = ".//button[@ng-show='ShowEditButton']")
	public WebElement Edit_button;
	
	// Technology Edit Section page
	
	@FindBy(xpath = ".//span[contains(text(),'Technology Architecture')]//following-sibling::span/i[@class='fa fa-pencil pull-right icon']")
	public WebElement Techno_Pencil_btn;
	
	@FindBy(xpath = ".//select[contains(@id,'6f045f21db6b0784f945f9a41d961908')]")
	public WebElement Edit_AccessOnline;
	
	@FindBy(xpath = ".//select[contains(@id,'81295b29dbab0784f945f9a41d96199d')]")
	public WebElement Edit_MobCap;
	
	@FindBy(xpath = ".//select[contains(@id,'eac81be9dbab0784f945f9a41d96190d')]")
	public WebElement Edit_workstations;
	
	@FindBy(xpath = ".//iframe[contains(@ng-src,'c3a1e548dbf09fc4bf0751735e9619b8')]")
	public WebElement Edit_Techno_Frame;
	
	@FindBy(xpath = "//button[contains(text(),'Submit')][not(@title='Submit')]")
	public WebElement Edit_Techno_Submit_btn;
	
	@FindBy(xpath = ".//table[@aria-label='AIR Technology- System Architecture Section']/tbody/tr/td/button[@id='submit_button']")
	public WebElement Edit_Techno_Submit_btn;
	
	@FindBy(xpath = ".//div[@class='modal-dialog comm-dialog']/div/div/button[contains(text(),'Close')][@ng-click='closeTechArchPopUp()']")
	public WebElement Edit_Techno_Close_btn;
	
	@FindBy(xpath = ".//b[contains(text(),'Is this application web enabled')]")
	public WebElement Verify_Techno_WebEnabled;
	
	//Application Info Section  Page
	
	@FindBy(xpath = ".//span[contains(text(),'Application Information')]//following-sibling::span/i[@class='fa fa-pencil pull-right icon']")
	public WebElement Appln_Pencil_btn;
	
	@FindBy(xpath = ".//iframe[contains(@ng-src,'bd9a8c23db5c9344e5e354545e961964')]")
	public WebElement Edit_ApplnInfo_Frame;
	
	@FindBy(xpath = ".//input[contains(@id,'dcc96ee5dbefc384f945f9a41d9619b2')][not(@type='hidden')]")
	public WebElement Edit_AppInfo_ParAppln;
	
	@FindBy(xpath = ".//input[contains(@id,'b58932e9db630784f945f9a41d96192c')][@class='cat_item_option sc-content-pad form-control']")
	public WebElement Edit_AppInfo_ProdUrl;
	
	@FindBy(xpath = ".//table[@aria-label='AIR Application & Contact Section']/tbody/tr/td/button[@id='submit_button']")
	public WebElement Edit_AppInfo_Submit_btn;
	
	@FindBy(xpath = ".//div[@class='modal-dialog app-dialog']/div/div/button[contains(text(),'Close')][@ng-click='closePopUp()']")
	public WebElement Edit_AppInfo_Close_btn;
	
	//Communication Section Edit Page
	
	@FindBy(xpath = ".//span[contains(text(),'Communication')]//following-sibling::span/i[@class='fa fa-pencil pull-right icon']")
	public WebElement Commu_Pencil_btn;
	
	@FindBy(xpath = ".//iframe[contains(@ng-src,'8e8593f2dbdcdb04e5e354545e961908')]")
	public WebElement Edit_Commu_Frame;
		
	@FindBy(xpath = ".//input[contains(@id,'2b1fe148dbe78344dd3cf5951d9619e3')][not(@type='hidden')]")
	public WebElement Edit_Commu_PriCommCont_CIO;
	
	@FindBy(xpath = ".//select[contains(@id,'7a343990dba30744dd3cf5951d961948')][not(@type='hidden')]")
	public WebElement Edit_Commu_AppNotiTool;
	
	@FindBy(xpath = ".//input[contains(@id,'7310f1c8dbe78344dd3cf5951d961957')][not(@type='hidden')]")
	public WebElement Edit_Commu_PriCommCont_Business;
	
	@FindBy(xpath = ".//table[@aria-label='AIR Communication Section']/tbody/tr/td/button[@id='submit_button']")
	public WebElement Edit_Commu_Submit_btn;
	
	@FindBy(xpath = ".//div[@class='modal-dialog comm-dialog']/div/div/button[contains(text(),'Close')][@ng-click='closePopUp()']")
	public WebElement Edit_Commu_Close_btn;
	
	//Support Section Edit Page
	
	@FindBy(xpath = ".//span[contains(text(),'Support Details')]//following-sibling::span/i[@class='fa fa-pencil pull-right icon']")
	public WebElement Support_Pencil_btn;
	
	@FindBy(xpath = ".//iframe[contains(@ng-src,'f705df7edb9cdb04e5e354545e96199f')]")
	public WebElement Edit_Support_Frame;
	
	@FindBy(xpath = ".//textarea[contains(@id,'2dc3b8f1dbab4784f945f9a41d961940')]")
	public WebElement Edit_Special_Cont_Instr;
	
	@FindBy(xpath = ".//input[contains(@id,'9bb5347ddb6b4784f945f9a41d961928')][@class='cat_item_option sc-content-pad form-control']")
	public WebElement Edit_P1Cont;
	
	@FindBy(xpath = ".//input[contains(@id,'6f46bc75dbab4784f945f9a41d961935')][@class='cat_item_option sc-content-pad form-control']")
	public WebElement Edit_P2Cont;
	
	@FindBy(xpath = ".//input[contains(@id,'6937c579dbeb4784f945f9a41d961976')][@class='cat_item_option sc-content-pad form-control']")
	public WebElement Edit_InterOperSuppUrl;
	
	@FindBy(xpath = ".//input[contains(@id,'dc48fc3ddb6b4784f945f9a41d96196b')][@class='cat_item_option sc-content-pad form-control']")
	public WebElement Edit_PrimEmerContName;
	
	@FindBy(xpath = ".//input[contains(@id,'cfe8bcf5dbab4784f945f9a41d9619a3')][@class='cat_item_option sc-content-pad form-control']")
	public WebElement Edit_SecoEmerContName;
	
	@FindBy(xpath = ".//table[@aria-label='AIR Support Section']/tbody/tr/td/button[@id='submit_button']")
	public WebElement Edit_Supp_Submit_btn;
	
	@FindBy(xpath = ".//div[@class='modal-dialog support-dialog']/div/div/button[contains(text(),'Close')][@ng-click='closePopUp()']")
	public WebElement Edit_Supp_Close_btn;
	
	//Legal Section Edit Page
	@FindBy(xpath = ".//span[contains(text(),'TCN')]//following-sibling::span/i[@class='fa fa-pencil pull-right icon']")
	public WebElement TCN_Pencil_btn;
	
	@FindBy(xpath = ".//span[contains(text(),'Legal')]//following-sibling::span/i[@class='fa fa-pencil pull-right icon']")
	public WebElement Legal_Pencil_btn;
	
	@FindBy(xpath = ".//iframe[contains(@ng-src,'3b451772dbdcdb04e5e354545e961968')]")
	public WebElement Edit_Legal_Frame;
	
	@FindBy(xpath = ".//select[contains(@id,'4ab9eae5dbefc384f945f9a41d96194b')]")
	public WebElement Edit_DataClass;
	
	@FindBy(xpath = ".//select[contains(@id,'7c3936a9db630784f945f9a41d96198d')]")
	public WebElement Edit_Whocanseedata;
	
	@FindBy(xpath = ".//select[contains(@id,'6c5c7261dba30784f945f9a41d96191e')]")
	public WebElement Edit_TempAdmin;
	
	@FindBy(xpath = ".//select[contains(@id,'9d28d3b1dbd81b40f945f9a41d961955')]")
	public WebElement Edit_AirLegal;
	
	@FindBy(xpath = ".//table[@aria-label='AIR Legal Section']/tbody/tr/td/button[@id='submit_button']")
	public WebElement Edit_Legal_Submit_btn;
	
	@FindBy(xpath = ".//div[@class='modal-dialog legal-dialog']/div/div/button[contains(text(),'Close')][@ng-click='closePopUp()']")
	public WebElement Edit_Legal_Close_btn;
	
	//Primary Contacts Edit Page
	@FindBy(xpath = ".//div[@class='editIconDiv']/i[@class='fa fa-pencil pull-right icon']")
	public WebElement PrimaryCont_Pencil_btn;
	
	@FindBy(xpath = ".//iframe[contains(@ng-src,'16c49372dbdcdb04e5e354545e96196d')]")
	public WebElement Edit_PrimaryCont_Frame;
	
	@FindBy(xpath = ".//input[contains(@id,'40104329dba30784f945f9a41d9619cf')][@class='questionsetreference form-control element_reference_input']")
	public WebElement Edit_ServOprMgr;
	
	@FindBy(xpath = ".//input[contains(@id,'ae420fe9dba30784f945f9a41d961964')][@class='questionsetreference form-control element_reference_input']")
	public WebElement Edit_AIMProgID;
	
	@FindBy(xpath = ".//input[contains(@id,'12d2436ddba30784f945f9a41d96193f')][@class='questionsetreference form-control element_reference_input']")
	public WebElement Edit_Progm_Mgr;	
	
	@FindBy(xpath = ".//table[@aria-label='AIR Contact Section']/tbody/tr/td/button[@id='submit_button']")
	public WebElement Edit_PrimaryCont_Submit_btn;
	
	@FindBy(xpath = ".//div[@class='modal-dialog contacts-dialog']/div/div/button[contains(text(),'Close')][@ng-click='closePopUp()']")
	public WebElement Edit_PrimaryCont_Close_btn;
	
	//Retire Page
	
	@FindBy(xpath = ".//button[@ng-show='ShowRetireButton'][@class='btn btn-primary ok-btn']")
	public WebElement Retire_btn;
	
	@FindBy(xpath = ".//div[@class='modal-body']/p")
	public WebElement RetirePopUpMsg;
	
	 Search or Reports WebElements
	
	@FindBy(xpath = ".//label[contains(text(),'SEARCH BY')]")
	public WebElement SearchBy;
	
	@FindBy(xpath = ".//span[contains(text(),'Service Tier')]")
	public WebElement Search_ServiceTier;
	
	@FindBy(xpath = ".//input[@id='Servicetiercheckbox0']")
	public WebElement AlwaysOn_CheckBox;
	
	@FindBy(xpath = ".//input[@id='Servicetiercheckbox1']")
	public WebElement NearlyAlwaysOn_CheckBox;
	
	@FindBy(xpath = ".//input[@id='Servicetiercheckbox2']")
	public WebElement Standard_CheckBox;
	
	@FindBy(xpath = ".//span[contains(text(),'Application Status')]")
	public WebElement Search_ApplicationStatus;
	
	@FindBy(xpath = ".//input[@id='appstatuscheckbox0']")
	public WebElement Funded_NotStarted_CheckBox;
	
	@FindBy(xpath = ".//input[@id='appstatuscheckbox1']")
	public WebElement InDevlopment_CheckBox;
	
	@FindBy(xpath = ".//input[@id='appstatuscheckbox2']")
	public WebElement InProduction_CheckBox;
	
	@FindBy(xpath = ".//input[@id='appstatuscheckbox5']")
	public WebElement SunSet_CheckBox;
	
	@FindBy(xpath = ".//input[@id='appstatuscheckbox3']")
	public WebElement ToBeSunSet_CheckBox;
	
	@FindBy(xpath = ".//input[@id='appstatuscheckbox4']")
	public WebElement Withdrawn_CheckBox;
	
	@FindBy(xpath = ".//span[contains(text(),'Organization')]")
	public WebElement Search_Organization;
	
	@FindBy(xpath = ".//input[@id='Organizationcheckbox0']")
	public WebElement  AccentureInteractive_CheckBox;
	
	@FindBy(xpath = ".//input[@id='Organizationcheckbox1']")
	public WebElement  AccentureTechnology_CheckBox;
	
	@FindBy(xpath = ".//input[@id='Organizationcheckbox2']")
	public WebElement BPO_CheckBox;
	
	@FindBy(xpath = ".//input[@id='Organizationcheckbox1']")
	public WebElement CIO_CheckBox;
	
	@FindBy(xpath = ".//input[@id='Organizationcheckbox4']")
	public WebElement NON_CIO_CheckBox;
	
	@FindBy(xpath = ".//input[@id='Organizationcheckbox5']")
	public WebElement OtherNON_CIO_CheckBox;
	
	@FindBy(xpath = ".//span[contains(text(),'Component Type')]")
	public WebElement Search_ComponentType;
	
	@FindBy(xpath = ".//input[@id='apptypecheckbox0']")
	public WebElement Application_CheckBox;
	
	@FindBy(xpath = ".//input[@id='apptypecheckbox1']")
	public WebElement Infra_CheckBox;
	
	@FindBy(xpath = ".//input[@id='apptypecheckbox2']")
	public WebElement Interface_CheckBox;
	
	@FindBy(xpath = ".//input[@id='apptypecheckbox3']")
	public WebElement ITSuppServ_CheckBox;
	
	@FindBy(xpath = ".//input[@id='apptypecheckbox3']")
	public WebElement NotAssigned_CheckBox;
	
	@FindBy(xpath = ".//input[@id='apptypecheckbox4']")
	public WebElement SaaS_CheckBox;
	
	@FindBy(xpath = ".//input[@id='apptypecheckbox6']")
	public WebElement WebService_CheckBox;
	
	@FindBy(xpath = ".//span[@class='btn btn-primary']")
	public WebElement Search_btn;
	
	@FindBy(xpath = ".//span[@class='btn btn-primary resetButton']")
	public WebElement Reset_btn;
	
	@FindBy(xpath = ".//span[@id='optionsMenu']")
	public WebElement Menu;
	
	@FindBy(xpath = ".//a[contains(text(),'Export as PDF')]")
	public WebElement Export_PDF;
	
	@FindBy(xpath = ".//a[contains(text(),'Export as Excel')]")
	public WebElement Export_Excel;
	
	@FindBy(xpath = ".//a[contains(text(),'Export as CSV')]")
	public WebElement Export_CSV;*/
	
	
//Testing	
	
	
	


}
