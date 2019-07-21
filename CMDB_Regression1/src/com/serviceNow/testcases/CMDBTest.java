package com.serviceNow.testcases;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jcp.xml.dsig.internal.dom.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;
import com.serviceNow.pages.HomePage;
import com.serviceNow.pages.LoginPage;
import com.serviceNow.pages.RegisterPage;
import com.serviceNow.pages.RetirePage;
import com.serviceNow.pages.SelfServicePage;
import com.serviceNow.pages.SurveyPage;
import com.serviceNow.pages.VerifyPage;
import com.sun.media.jfxmedia.logging.Logger;

public class CMDBTest extends BaseTest{
	
	String username, pwd;
	static StringBuilder visitedUsers = new StringBuilder(100);
	LoginPage loginPage;
	HomePage homepage;
	RegisterPage RegPage;
	RetirePage Retirepage;
	VerifyPage verpage;
	SurveyPage surveypage;
	String requestID="",TCNnumber; 
	String wbse="A6QWV001";
	String AppName = "", Desc="";
	String status,state,stage, str;
	public SelfServicePage sspage;

	public CMDBTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

			/**
			 * This is method for Getting Suite Name form XML 
			 * @param context
			 * @author k.narasimha.swamy
			 */
			
	@BeforeSuite
    public void getSuiteName(ITestContext context)
    {
        String suiteName = context.getCurrentXmlTest().getSuite().getName();
        //Calling suiteConfig() in BaseTest class
        suiteConfig(suiteName);
        //Print suite Name
        System.out.println("@@@ Suite Name : "+ suiteName);
    }
    
    /**
    * This method for Getting test name and Input data Name
    * @param testcaseName
    * @param context
    * @author k.narasimha.swamy
    */
    
    @Parameters({"inputsheetname"})
    @BeforeTest
    public void setInputSheetName(String testsheetName)
    {
           getinputsheetname(testsheetName);
    
        System.out.println("@@@ Test Sheet Name : "+ testsheetName);

    }

    @Parameters({"testcaseName"})
    @BeforeTest
    public void setUp(String testcaseName,ITestContext context)
    {
           //Reading Data from Excel
           getInputDataFromExcel(testcaseName);
           
           //Getting Test name from XML
           String testName = context.getName();
           
           //Reports configuration
           reportsConfig(testName);
    
           System.out.println("@@@ Test Case Name:" + testcaseName);
        System.out.println("@@@ Test  Name : "+ testName);

    } 

    
    
    
           
    @Test
    //Login Method
    public void login()
    {
           ExtentTest logger = extent.startTest("Login", "Login");
           try
           {
           
           navigate(logger);
           loginPage = PageFactory.initElements(driver, LoginPage.class);
           username=inputData.get("Requester").get("Username").toString();
           String pwd=inputData.get("Requester").get("Password").toString();
           System.out.println(username + "       "+pwd);
           
           loginPage.login(logger,username,pwd);
           
           driver.navigate().to(inputData.get("navigateportal").get("URL").toString());
           
          // driver.navigateCMDBlistpage().to(inputData.get("navigateportal").get("URL").toString());
          
           
			util.pause(logger, "10");
           }
           
           catch(Exception e)
           {
                   util.screenShotAndErrorMsg(logger, e, driver, "Login");
           }
           extent.endTest(logger);
           extent.flush();
             
    }
		
    /* Program Manager (Approver1) Login   */
    
    @Test
    //Login Method
    public void ProgramManagerApproverlogin()
    {
           ExtentTest logger = extent.startTest("ProgramManagerApproverlogin", "ProgramManagerApproverlogin");
           try
           {
           util.pause(logger, "10");
        	   verifyticketspage("Appl_Creation_Request");
        	   
           navigate(logger);
           loginPage = PageFactory.initElements(driver, LoginPage.class);
           username=inputData.get("Approver1").get("Username").toString();
           String pwd=inputData.get("Approver1").get("Password").toString();
           System.out.println(username + "       "+pwd);
           
           loginPage.login(logger,username,pwd);
           
           driver.navigate().to(inputData.get("navigateportal").get("URL").toString());
			util.pause(logger, "10");
			
			ApproveApplication();
			
			logger.log(LogStatus.INFO, "Program Manager Approved Request Successfully");	
			System.out.println("Program Manager Approved Request Successfully");
		
           }
           
           catch(Exception e)
           {
                   util.screenShotAndErrorMsg(logger, e, driver, "ProgramManagerApproverlogin");
           }
           extent.endTest(logger);
           extent.flush();
             
    }

    @Test
    //Program MD(Approver2) Login Method
    public void ProgramMDApproverlogin()
    {
           ExtentTest logger = extent.startTest("ProgramMDApproverlogin", "ProgramMDApproverlogin");
           try
           {
           
           navigate(logger);
           loginPage = PageFactory.initElements(driver, LoginPage.class);
           username=inputData.get("Approver2").get("Username").toString();
           String pwd=inputData.get("Approver2").get("Password").toString();
           System.out.println(username + "       "+pwd);
           
           loginPage.login(logger,username,pwd);
           
           driver.navigate().to(inputData.get("navigateportal").get("URL").toString());
			util.pause(logger, "10");
		
			ApproveApplication();
			
			logger.log(LogStatus.INFO, "Program MD Approved Request Successfully");	
			System.out.println("Program MD Approved Request Successfully");
			
			
			//Verifying Ticket Status by calling VerifyStatus method
			VerifyStatus();
			
           }
           
           catch(Exception e)
           {
                   util.screenShotAndErrorMsg(logger, e, driver, "ProgramMDApproverlogin");
           }
           extent.endTest(logger);
           extent.flush();
             
    }
  
    @Test
    //Login Method
    public void ServiceOperationsManagerApproverlogin()
    {
           ExtentTest logger = extent.startTest("ServiceOperationsManagerApproverlogin", "ServiceOperationsManagerApproverlogin");
           try
           {
           util.pause(logger, "10");
        	   verifyticketspage("Appl_Creation_Request");
        	   
           navigate(logger);
           loginPage = PageFactory.initElements(driver, LoginPage.class);
           username=inputData.get("ServOpsMgr").get("Username").toString();
           String pwd=inputData.get("ServOpsMgr").get("Password").toString();
           System.out.println(username + "       "+pwd);
           
           loginPage.login(logger,username,pwd);
           
           driver.navigate().to(inputData.get("navigateportal").get("URL").toString());
			util.pause(logger, "10");
			
			ApproveApplication();
			
			logger.log(LogStatus.INFO, "Service Operations Manager Approved Request Successfully");	
			System.out.println("Service Operations Manager Approved Request Successfully");
		
           }
           
           catch(Exception e)
           {
                   util.screenShotAndErrorMsg(logger, e, driver, "ServiceOperationsManagerApproverlogin");
           }
           extent.endTest(logger);
           extent.flush();
             
    }
    
    //
    @Test
    //Program MD(Approver2) Login Method
    public void ServiceOperationsMDApproverlogin()
    {
           ExtentTest logger = extent.startTest("ServiceOperationsMDApproverlogin", "ServiceOperationsMDApproverlogin");
           try
           {
           
           navigate(logger);
           loginPage = PageFactory.initElements(driver, LoginPage.class);
           username=inputData.get("Level2").get("Username").toString();
           String pwd=inputData.get("Level2").get("Password").toString();
           System.out.println(username + "       "+pwd);
           
           loginPage.login(logger,username,pwd);
           
           driver.navigate().to(inputData.get("navigateportal").get("URL").toString());
			util.pause(logger, "10");
		
			ApproveApplication();
			
			logger.log(LogStatus.INFO, "Service Operations MD Approved Request Successfully");	
			System.out.println("Service Operations MD Approved Request Successfully");
			
			
			//Verifying Ticket Status by calling VerifyStatus method
			VerifyStatus();
			
           }
           
           catch(Exception e)
           {
                   util.screenShotAndErrorMsg(logger, e, driver, "ServiceOperationsMDApproverlogin");
           }
           extent.endTest(logger);
           extent.flush();
             
    }
    
    
			/**
			 * This method for Getting test name and Input data Name
			 * @param testcaseName
			 * @param context
			 * @author k.narasimha.swamy
			 */
    
@Test
	
	public void RegisterAnApplication(){
	
	ExtentTest logger = extent.startTest("RegisterAnApplication", "RegisterAnApplication"); 

		try{
			
			homepage = PageFactory.initElements(driver, HomePage.class);
			
			util.waittillpageload(logger, driver);
			util.pause(logger, "15");
			util.verifyElementByXpath(logger, homepage.Aboutus);
			logger.log(LogStatus.INFO, "About Us header verified");	
			
			util.verifyElementByXpath(logger, homepage.MyActivities);
			util.waitTillElementIsClickable(logger, driver, homepage.MyActivities);
			
			util.clickByJavascriptExecutor(logger, driver, homepage.MyActivities);
			//util.clickOn(logger, homepage.MyActivities);
			util.pause(logger, "10");
					
			util.verifyElementByXpath(logger, homepage.MyApplication);
			logger.log(LogStatus.INFO, "My Application header verified");	
			
			util.verifyElementByXpath(logger, homepage.Search_Reports);
			logger.log(LogStatus.INFO, "Search/Reports header verified");
			
			util.verifyElementByXpath(logger, homepage.Surveys);
			logger.log(LogStatus.INFO, "Surveys header verified");
			
			util.verifyElementByXpath(logger, homepage.PendingActions);
			logger.log(LogStatus.INFO, "Pending Actions header verified");
			
			util.waitTillElementIsClickable(logger, driver, homepage.RegAnAppl);
			System.out.println("Login into ServiceNow navigation");
			util.clickByJavascriptExecutor(logger, driver, homepage.RegAnAppl);
			util.waittillpageload(logger, driver);
			util.pause(logger, "10");
			System.out.println("Swithing to Frame");
			util.pause(logger, "2");
				
			frameHelper.switchToFrame(logger, driver, homepage.Frame);
			homepage = PageFactory.initElements(driver, HomePage.class);
			System.out.println("Switched to Frame");
			
			double randNumber = Math.random();
			//System.out.println((int)(Math.random()*27) );
			
			AppName = inputData.get("ApplicationName").get("keywords").toString();
			util.waitTillElementIsClickable(logger, driver, homepage.ApplName);
			util.clickOn(logger, homepage.ApplName);
			System.out.println("Clicked on Application field");
			//AppName= AppName+(int)(Math.random()*27);	
			AppName= AppName+randNumber;	
			
			util.setTextWithEnter(logger, homepage.ApplName, AppName);
			System.out.println(AppName);
			
			Desc = inputData.get("Description").get("keywords").toString();
			util.setTextWithEnter(logger,homepage.Description, Desc);
			
			System.out.println("Switched to Frame-----------------");
			
			util.clickOn(logger, homepage.ServiceTier_none);
			util.pause(logger, "2");
			str = inputData.get("ServiceTier").get("keywords").toString();
			util.selectBoxByValue(logger, homepage.ServiceTier,str);
			
			util.pause(logger, "2");
			
			str = inputData.get("ParentApplication").get("keywords").toString();
			util.setTextWithEnter(logger, homepage.ParentAppl, str);
			
			str = inputData.get("UserLocations").get("keywords").toString();
			
			if(str.equalsIgnoreCase("Specific")){
			
				util.clickOn(logger, homepage.SpecificCheckbox);
				util.waitTillElementIsVisible(logger, driver, homepage.Country);
				str = inputData.get("Country").get("keywords").toString();
				util.setText(logger, homepage.Country, str);
				}
			
			if(str.equalsIgnoreCase("Global")){
				
				util.clickOn(logger, homepage.GlobalCheckbox);			
			}
			
			str = inputData.get("ResponEntity").get("keywords").toString();
			util.selectBoxByValue(logger, homepage.ResponEntity, str);
			
			str = inputData.get("NumberOfUsers").get("keywords").toString();
			util.selectBoxByValue(logger, homepage.NumOfUsersAtPeak, str);
			
			str = inputData.get("ComponentType").get("keywords").toString();
			util.selectBoxByValue(logger, homepage.ComponentType, str);
			
			str = inputData.get("Organization").get("keywords").toString();
			util.selectBoxByValue(logger, homepage.Orgnization, str);
			
			/*str = inputData.get("ApplType").get("keywords").toString();
			util.setTextWithEnter(logger, homepage.ApplType, str);*/
			
			str = inputData.get("ApplicationStatus").get("keywords").toString();
			util.selectBoxByValue(logger, homepage.ApplStatus, str);
			
			if(str.equalsIgnoreCase("Funded/Not Started")){
				
				util.clickOn(logger, homepage.AIMProgIDSearchLookUp);
				System.out.println("Clicked on Lookup");
				
				util.clickByJavascriptExecutor(logger, driver, homepage.AIMProgIDSearchLookUp);
				frameHelper.switchToChildWindow(logger, driver, frameHelper.getParentWindowHandle(logger, driver));
				
				str = inputData.get("AIMProgID").get("keywords").toString();
				str = str.replaceAll("k", "");
				util.setTextWithEnter(logger, homepage.AIMProgIDinput, str);
				util.pause(logger, "5");
				util.clickOn(logger, homepage.SelectAIMProgID);
				
				frameHelper.switchToParentWindowHandle(logger, driver, "");
				frameHelper.switchToDefaultFrame(logger, driver);
				
				frameHelper.switchToFrame(logger, driver, homepage.Frame);
				
				str = inputData.get("ProgramManager").get("keywords").toString();
				util.setTextWithEnter(logger, homepage.ProgManager, str);

			}
			
			
				if(str.equalsIgnoreCase("In Production")){
					
					/*str = inputData.get("AIMProgID").get("keywords").toString();
					str = str.replaceAll("k", "");
					util.setTextWithEnter(logger, RegPage.Reg_AIMProgID_Input, str);*/
				
				util.clickOn(logger, homepage.AIMServOpersLookUp);
				System.out.println("Clicked on Lookup");
				
				util.clickByJavascriptExecutor(logger, driver, homepage.AIMServOpersLookUp);
				frameHelper.switchToChildWindow(logger, driver, frameHelper.getParentWindowHandle(logger, driver));
				
				str = inputData.get("AIMServOperID").get("keywords").toString();
				str = str.replaceAll("k", "");
				util.setTextWithEnter(logger, homepage.AIMProgIDinput, str);
				util.pause(logger, "5");
				util.clickOn(logger, homepage.SelectAIMProgID);
				
				frameHelper.switchToParentWindowHandle(logger, driver, "");
				frameHelper.switchToDefaultFrame(logger, driver);
				
				frameHelper.switchToFrame(logger, driver, homepage.Frame);
				
				str = inputData.get("ServiceOperationManager").get("keywords").toString();
				util.setTextWithEnter(logger, homepage.ServiceOperationManager, str);
			}

			util.pause(logger, "4");
			
			str = inputData.get("ProdURL").get("keywords").toString();
			util.setTextWithEnter(logger, homepage.ProductionURL, str);
			
			str = inputData.get("DataClassification").get("keywords").toString();
			util.selectBoxByValue(logger, homepage.DataClass, str);
			
			str = inputData.get("PersonalInfo").get("keywords").toString();
			util.selectBoxByValue(logger, homepage.PersonalIdntifiableInfo, str);
			
			str = inputData.get("PossibleToIdentifyData").get("keywords").toString();
			util.selectBoxByValue(logger, homepage.possibleToIdentifyData, str);
			
			str = inputData.get("possibleToPreserveData").get("keywords").toString();
			util.selectBoxByValue(logger, homepage.possibleToPreserveData, str);
			
			str = inputData.get("possibleToSuspend").get("keywords").toString();
			util.selectBoxByValue(logger, homepage.possibleToSuspendroutine, str);
			
			str = inputData.get("possibleToSuspend").get("keywords").toString();
			util.selectBoxByValue(logger, homepage.possibleContractualRights, str);
			
			//util.pause(logger, "5");
		
			util.waitTillElementIsClickable(logger, driver, homepage.Submitbtn);
			
			//System.out.println("Submit button visible");
			//util.clickByJavascriptExecutor(logger, driver, homepage.Submitbtn);
			//util.pause(logger, "5");
			//util.clickOn(logger, homepage.Submitbtn);
			util.clickOn(logger, homepage.Ordernowbtn);
			util.pause(logger, "5");
			
			frameHelper.switchToDefaultFrame(logger, driver);
			util.pause(logger, "20");
			
			//verifyticketspage("Appl_Creation_Request");
		}
		catch(Exception e){
			
			logger.log(LogStatus.FAIL,  "Unable to Register an Application Request  due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
		extent.endTest(logger);
	  	extent.flush(); 
		
	}

/*The Below Method "Verify tickets page"is for storing Request id and Status*/

@Test
public void verifyticketspage(String Verify_Status)
{
       ExtentTest logger = extent.startTest("verifyticketspage", "verifyticketspage");
       try
       {
               sspage = PageFactory.initElements(driver, SelfServicePage.class);            
               driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
               util.pause(logger, "10");
               
               if (Verify_Status.equalsIgnoreCase("Appl_Creation_Request"))
               {
            	   util.waitTillElementIsClickable(logger, driver, sspage.requestnumberHeader_ApplCreationRequest);
                   util.clickOn(logger, sspage.requestnumberHeader_ApplCreationRequest); 
               	}
 	          
               if (Verify_Status.equalsIgnoreCase("CIOAppl_Oper_Requests"))
               {
            	   util.waitTillElementIsClickable(logger, driver, sspage.requestnumberHeader_CIOAppl_Oper_Request);
                   util.clickOn(logger, sspage.requestnumberHeader_CIOAppl_Oper_Request); 
               	}
               
              /* util.waitTillElementIsClickable(logger, driver, sspage.requestnumberHeader_ApplCreationRequest);
               util.clickOn(logger, sspage.requestnumberHeader_ApplCreationRequest);  */         
               util.waittillpageload(logger, driver);
               util.pause(logger, "20");
               //frameHelper.switchToFrame(logger, driver, homepage.Frame);
               util.waitTillElementIsVisible(logger, driver, sspage.requestnumber);
               requestID = sspage.requestnumber.getAttribute("value");
               System.out.println("Request number is "+ requestID);
               util.pause(logger, "10");
               util.pause(logger, "5");
             /*  status=sspage.txt_status.getAttribute("value");
               System.out.println("The Status of Ticket is: " + status);*/
               logger.log(LogStatus.INFO, "RequestNumber: " + requestID);
               
               
               
               /*if(value.equalsIgnoreCase("Yes"))
               {
       
                      if(status.equalsIgnoreCase("Waiting for Approval"))
                             logger.log(LogStatus.PASS, "Status displaying properly");
                      else
                             logger.log(LogStatus.FAIL, "Status not displaying as expected. Expected is Waiting for Approval");
               }
               if(value.equalsIgnoreCase("No"))
               {
       
                      if(status.equalsIgnoreCase("Fulfillment"))
                             logger.log(LogStatus.PASS, "Status displaying properly");
                      else
                             logger.log(LogStatus.FAIL, "Status not displaying as expected. Expected is Fulfillment");
               }
               */
                      
               frameHelper.switchToDefaultFrame(logger, driver);
       }
       catch(Exception e)
       {
               util.screenShotAndErrorMsg(logger, e, driver, "verifyticketspage");
       }
       extent.endTest(logger);
       extent.flush();
}
	@Test
	public void ApplicationDetailViewPage(){
		ExtentTest logger = extent.startTest("ApplicationDetailViewPage", "ApplicationDetailViewPage");
		
		try
		{
			/*driver=browserHelper.driversList.get(0);
			
			String reqwindow=browserHelper.driversList.get(0).getWindowHandle().toString();
			System.out.println("Status Verify - reqwindow id is "+reqwindow);
	        driver.switchTo().window(reqwindow);
			
	       driver.navigate().to(inputData.get("navigateportal").get("URL").toString());
	     
	        sspage = PageFactory.initElements(driver, SelfServicePage.class);
	        homepage = PageFactory.initElements(driver, HomePage.class);
	        

		util.waitTillElementIsClickable(logger, driver, homepage.ApplCard);
		
		if(homepage.ViewAllLink.isDisplayed()==true){
			util.clickOn(logger, homepage.ViewAllLink);
			util.pause(logger, "5");
		}
		
		util.clickOn(logger, driver.findElement(By.xpath("(.//div[@class='tile-title ApplicationNames']/b[contains(text(),'"+AppName+"')])[1]")));
		System.out.println("Specific application page is displayed");*/
			 sspage = PageFactory.initElements(driver, SelfServicePage.class);
		     homepage = PageFactory.initElements(driver, HomePage.class);	
			
		util.waittillpageload(logger, driver);
		util.pause(logger, "15");
		util.verifyElementByXpath(logger, homepage.PrimaryContactsSec);
		 logger.log(LogStatus.INFO, "Primary Contacts Section verified");
		util.verifyElementByXpath(logger, homepage.EmergencyContactsSec);
		logger.log(LogStatus.INFO, "Emergency Contacts Section verified");
		util.verifyElementByXpath(logger, homepage.SupportContactsSec);
		logger.log(LogStatus.INFO, "Support Contacts Section verified");
		util.verifyElementByXpath(logger, homepage.ApplInfoSection);
		logger.log(LogStatus.INFO, "ApplIcation informaion Section verified");
		util.verifyElementByXpath(logger, homepage.CommunicationSection);
		logger.log(LogStatus.INFO, "Communication Section verified");
		util.verifyElementByXpath(logger, homepage.ShortDetailsSection);
		logger.log(LogStatus.INFO, "Short Details Sectiontion verified");
		util.verifyElementByXpath(logger, homepage.TechnologyDetailsSection);
		logger.log(LogStatus.INFO, "Technology Details Section verified");
		util.verifyElementByXpath(logger, homepage.LegalSection);
		logger.log(LogStatus.INFO, "Legal Section verified");
		
		util.clickOn(logger, homepage.ApplInfoSec_SeeMore);
		util.pause(logger, "2");
		util.clickOn(logger, homepage.ApplInfoSec_SeeLess);
		
		/* Verifying Summary Section of Application */
		util.verifyElementByXpath(logger, homepage.Image_Icon);
		logger.log(LogStatus.INFO, "Image Icon verified");
		
		util.verifyElementByXpath(logger, homepage.AppName_AppID);
		logger.log(LogStatus.INFO, "Application Name and Application ID verified");
		
		str = homepage.AppName_AppID.getAttribute("innerText");
		
		if(str.contains(AppName)){
			logger.log(LogStatus.PASS, "Application Name Same as Input");
		}
		
		else{
			logger.log(LogStatus.FAIL, "Application Name Expected is " +AppName+" but it is displying as"+str);
		}

		util.verifyElementByXpath(logger, homepage.URL_Link);
		logger.log(LogStatus.INFO, "Summary URL Link verified");
		
		util.verifyElementByXpath(logger, homepage.Summary_Description);
		logger.log(LogStatus.INFO, "Summary Description verified");
		
		str = homepage.Summary_Description.getAttribute("innerText");
		if(str.contains(Desc)){
			logger.log(LogStatus.PASS, "Description Same as Input");
		}
		
		else{
			logger.log(LogStatus.FAIL, "Description Expected is " +Desc+" but it is displying as"+str);
		}
		
		util.verifyElementByXpath(logger, homepage.LastVerifiedBy);
		logger.log(LogStatus.INFO, "Last Verified By text verified");
		
		util.verifyElementByXpath(logger, homepage.LastVerifiedOn);
		logger.log(LogStatus.INFO, "Last Verified On text verified");
		
		/*Verifying Application Information Section details */
		logger.log(LogStatus.INFO, "Verifying Application Information Details Section details");
		System.out.println("Verifying Application Information Details Section details");
				
		util.clickOn(logger, homepage.ApplInfoSec_SeeMore);
		util.pause(logger, "5");
		
		util.verifyElementByXpath(logger, homepage.ApplicationStatus_Label);
		logger.log(LogStatus.INFO, "Application Status Lable present in Application Info Section");
		
		str = inputData.get("ApplicationStatus").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Application Status')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.ServTier_Label);
		logger.log(LogStatus.INFO, "Service Tier Lable present in Application Info Section");
		str = inputData.get("ServiceTier").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Service Tier')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.Org_Label);
		logger.log(LogStatus.INFO, " Organization Lable present in Application Info Section");
		str = inputData.get("Organization").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Organization')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.RegStatus_Label);
		logger.log(LogStatus.INFO, " Registration Status Lable present in Application Info Section");
		util.verifyElementByXpath(logger, homepage.RegStatus_RegCompleted);
		logger.log(LogStatus.INFO, "Registration Status is Registered Completed");		
		
		//Assignment Group label is not available in Application Details section during CMDB Q3 Release
		util.verifyElementByXpath(logger, homepage.SN_AssignmentGroup_Label);
		logger.log(LogStatus.INFO, " ServiceNow Assignment Group Lable present in Application Info Section");
		str = inputData.get("SN_Assignmentgroup").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'ServiceNow Assignment Groups')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.RespnEnty_Label);
		logger.log(LogStatus.INFO, " Responsible Entity Lable present in Application Info Section");
		str = inputData.get("ResponEntity").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Responsible Entity')]]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.Userlocation_Label);
		logger.log(LogStatus.INFO, "User Location Label present in Application Info Section");
		
		str = inputData.get("UserLocations").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'User Location')]/../parent::div/span[contains(text(),'"+str+"')]")));
		logger.log(LogStatus.INFO, "User Location value present in Application Info Section");
		
		str = inputData.get("UserLocations").get("keywords").toString();
		if(str.equalsIgnoreCase("Specific")){
			
			util.verifyElementByXpath(logger, homepage.Country_Label);
			logger.log(LogStatus.INFO, "Country Label Present in Application Info Section");
			
			str = inputData.get("Country").get("keywords").toString();
			util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Country')]/../parent::div/span[contains(text(),'"+str+"')]")));
			}
		
		if(str.equalsIgnoreCase("Global")){
		
			util.verifyElementByXpath(logger, homepage.Country_Label);
			logger.log(LogStatus.INFO, "Country Label Present in Application Info Section");
		}	
		
		util.verifyElementByXpath(logger, homepage.SN_AssignmentGroup_Label);
		logger.log(LogStatus.INFO, " ServiceNow Assignment Group Lable present in Application Info Section");
		str = inputData.get("SN_AssignmentGroup").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'AssignmentGroup')]/../parent::div/span[contains(text(),'"+str+"')]")));

		util.verifyElementByXpath(logger, homepage.Acronym_Label);
		logger.log(LogStatus.INFO, " Acronym Lable present in Application Info Section");
		str = inputData.get("Acronym").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Acronym')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		
		//Application Type field is deleted
		
		/*util.verifyElementByXpath(logger, homepage.ApplicationType_Label);
		logger.log(LogStatus.INFO, " Application Type Lable present in Application Info Section");
		str = inputData.get("ApplType").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Application Type')]/../parent::div/span[contains(text(),'"+str+"')]")));
		*/
		util.verifyElementByXpath(logger, homepage.Applicationid_Label);
		logger.log(LogStatus.INFO, " Application ID Lable present in Application Info Section");
		str = homepage.Applicationid.getAttribute("innerText");
		if(str.isEmpty()==false){
			logger.log(LogStatus.PASS, "Application id is available");
		}
		
		else{
			logger.log(LogStatus.FAIL, "Application id is not available");
		}

		util.verifyElementByXpath(logger, homepage.ApplicationName_Label);
		
		logger.log(LogStatus.INFO, " Application Name Lable present in Application Info Section");
		
		str = homepage.ApplicationName.getAttribute("innerText");
	
		if(str.contains(AppName)){
			logger.log(LogStatus.PASS, "Application Name Same as Input");
		}
		
		else{
			logger.log(LogStatus.FAIL, "Application Name Expected is " +AppName+" but it is displying as"+str);
		}
		
		/*str= inputData.get("ApplicationName").get("keywords").toString();

		if(str.equals(homepage.ApplicationName)){
			
			logger.log(LogStatus.PASS, "Application Name Same as Input");
		}
		
		else{
			logger.log(LogStatus.FAIL, "Application Name is not Same as Input");
		}*/
		
		//Assignment group label or field not exists in Application Info section during CMDB Q3 release
		/*util.verifyElementByXpath(logger, homepage.AssignmentGroup_Label);
		logger.log(LogStatus.INFO, " Assignment group Lable present in Application Info Section");
		str = inputData.get("Assignmentgroup").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Assignment Group')]/../parent::div/span[contains(text(),'"+str+"')]")));*/
		
		//Category field is removed from Application info Section during CMDB Q3 Release
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Category')]")).size()==0)
		{
			logger.log(LogStatus.PASS, "Category Label does not exists in Application Info Section");
		}
		
		else
		{
 			logger.log(LogStatus.FAIL, "Category Label exists in Application Info Section");	
 		}
		
		/*
		if(homepage.Category_Label.isDisplayed()==false)
		{
			logger.log(LogStatus.PASS, "Category field does not exists in Application Info Section");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Category field exists in Application Info Section");
		}*/
		
		/*util.verifyElementByXpath(logger, homepage.Category_Label);
		logger.log(LogStatus.INFO, " Category Lable present in Application Info Section");*/
				
		util.verifyElementByXpath(logger, homepage.Class_Label);
		logger.log(LogStatus.INFO, " Class Lable present in Application Info Section");
		
		//util.verifyElementByXpath(logger, homepage.Class);
		//util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Class ')]/../parent::div/span[contains(text(),'Application')]")));
		
		str = homepage.Class.getAttribute("innerText");
		
		if(str.equalsIgnoreCase("Application"))
		{
			logger.log(LogStatus.PASS, "Class value contains Application as value");
		}
		
		else{
			logger.log(LogStatus.FAIL, "Class value does not contains Application as value");
		}
		
		util.verifyElementByXpath(logger, homepage.Company_Label);
		logger.log(LogStatus.INFO, " Company Lable present in Application Info Section");
		str = inputData.get("Company").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Company')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.CompType_Label);
		logger.log(LogStatus.INFO, " Component Type Lable present in Application Info Section");
		str = inputData.get("ComponentType").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Component Type')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.Created_On_Label);
		logger.log(LogStatus.INFO, " Created On Lable present in Application Info Section");
		
		str = homepage.Created_On.getAttribute("innerText");
		if(str.isEmpty()==false){
			logger.log(LogStatus.PASS, "Created On Date is available");
		}
		
		else{
			logger.log(LogStatus.FAIL, "Created On Date is not available");
		}

	
		util.verifyElementByXpath(logger, homepage.CreatedBy_Label);
		logger.log(LogStatus.INFO, " Created By Lable present in Application Info Section");
		str = inputData.get("Requester").get("Username").toString();
		
		if(str.equalsIgnoreCase(homepage.CreatedBy.getAttribute("innerText"))){
			logger.log(LogStatus.PASS, "Created By value is same as Requester");
		}
		
		else{
			logger.log(LogStatus.FAIL, "Created By value is not same as Requester");
		}
		
		//Description field is Removed from Application info Section during CMDB Q3 Release
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Description')]")).size()==0)
		{
			logger.log(LogStatus.PASS, "Description Label does not exists in Application Information Section");
		}
		else
		{
			logger.log(LogStatus.PASS, "Description Label exists in Application Information Section");
		}
		/*util.verifyElementByXpath(logger, homepage.description_Label);
		logger.log(LogStatus.INFO, " Description Lable present in Application Info Section");
		str = inputData.get("Description").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Description')]/../parent::div/span[contains(text(),'"+str+"')]")));*/
				
		util.verifyElementByXpath(logger, homepage.FirstGo_LiveDate_Label);
		logger.log(LogStatus.INFO, " First Go Live Date Lable present in Application Info Section");
		str = homepage.FirstGo_LiveDate.getAttribute("innerText");
		if(str.isEmpty()==false){
			logger.log(LogStatus.PASS, "First Go Live Date is available");
		}
		
		else{
			logger.log(LogStatus.FAIL, "First Go Live Date is not available");
		}
		
		util.verifyElementByXpath(logger, homepage.LastModifiedBy_Label);
		logger.log(LogStatus.INFO, " Last Modify By Lable present in Application Info Section");
		
		str = inputData.get("Requester").get("Username").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Last Modified By')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.LastModifiedOn_Label);
		logger.log(LogStatus.INFO, " Last Modified On Lable present in Application Info Section");
		str = homepage.LastModifiedOn.getAttribute("innerText");
		if(str.isEmpty()==false){
			
			logger.log(LogStatus.PASS, "Last Modified Date is available");
		}
		
		else{
			logger.log(LogStatus.FAIL, "Last Modifiede Date is not available");
		}
		
		//Location field is not exists in Application info sec during CMDB Q3 Release
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Location')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Location Lable does not exists in Application Info Section");
		}
		else
		{
			logger.log(LogStatus.FAIL, "Location Lable does exists in Application Info Section");
		}
		
		/*util.verifyElementByXpath(logger, homepage.Location_Label);
		logger.log(LogStatus.INFO, " Location Lable present in Application Info Section");
		str = inputData.get("Technology_Location").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Location')]/../parent::div/span[contains(text(),'"+str+"')]")));*/
				
		util.verifyElementByXpath(logger, homepage.Maintenanceschedule_Label);
		logger.log(LogStatus.INFO, " Maintenance Schedule Lable present in Application Info Section");
		
		//Maintenance Schedule field doesn't have any value during Register in CMDB Q3 Release
		/*str = inputData.get("MaintenanceSchedule").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Maintenance schedule')]/../parent::div/span[contains(text(),'"+str+"')]")));*/
				
		util.verifyElementByXpath(logger, homepage.NumberofEndUsers_Label);
		logger.log(LogStatus.INFO, " Number of End Users Lable present in Application Info Section");
		str = inputData.get("NumberOfUsers").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Number of End Users')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.ParentApplication_Label);
		logger.log(LogStatus.INFO, " Parent Application Lable present in Application Info Section");
		str = inputData.get("ParentApplication").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Parent Application')]/../parent::div/span[contains(text(),'"+str+"')]")));
				
		util.verifyElementByXpath(logger, homepage.ReportingEntity_Label);
		logger.log(LogStatus.INFO, " Reporting Entity Lable present in Application Info Section");
		str = inputData.get("ReportingEntity").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Reporting Entity')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.URL_Label);
		logger.log(LogStatus.INFO, " URL Lable present in Application Info Section");
		str = inputData.get("ProdURL").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'URL')]/../parent::div/span[contains(text(),'"+str+"')]")));

		util.verifyElementByXpath(logger, homepage.Verifiedby_Label);
		logger.log(LogStatus.INFO, " Verified By Lable present in Application Info Section");
		str = inputData.get("Requester").get("Username").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Verified By')]/../parent::div/span[contains(text(),'"+str+"')]")));

		util.verifyElementByXpath(logger, homepage.Verifiedon_Label);
		logger.log(LogStatus.INFO, " Verfified On Lable present in Application Info Section");
		str = homepage.Verifiedon.getAttribute("innerText");
		if(str.isEmpty()==false){
			
			logger.log(LogStatus.PASS, "Verified On Date is available");
		}
		
		else{
			logger.log(LogStatus.FAIL, "Verified On Date is not available");
		}

		util.clickOn(logger, homepage.ApplInfoSec_SeeLess);
		util.pause(logger, "2");
		
		/*Verifying Communication Section */
		logger.log(LogStatus.INFO, "Verifying Communication Details Section");
		System.out.println("Verifying Communication Details Section");
		
	
		util.clickOn(logger, homepage.Commu_SeeMore);
		util.pause(logger, "5");
		
		util.verifyElementByXpath(logger, homepage.PrimaryCommContactCIO_Label);
		logger.log(LogStatus.INFO, "Primary Communication Contact (CIO) Lable present in Communication Section");
		str = inputData.get("PrimaryCommuCont_CIO").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Primary Communication Contact (CIO)')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.ApplGoneFishingPage_Label);
		logger.log(LogStatus.INFO, "Does the application have a Gone Fishing page enabled? Lable present in Communication Section");
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Does the application have a Gone Fishing page enabled?')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Does the application have a Gone Fishing page enabled? has value Yes");
		}
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Does the application have a Gone Fishing page enabled?')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Does the application have a Gone Fishing page enabled? has value No");
			
		}
		
		util.verifyElementByXpath(logger, homepage.EndUserSuppSiteURL_Label);
		logger.log(LogStatus.INFO, "End User Support Site URL Lable present in Communication Section");
		str = inputData.get("EndUserSuppURL").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'End User Support Site URL')]/../parent::div/span[contains(text(),'"+str+"')]")));

		util.verifyElementByXpath(logger, homepage.PrimCommContactBusiness_Label);
		logger.log(LogStatus.INFO, "Primary Communication Contact (Business) Lable present in Communication Section");
		str = inputData.get("PrimaryCommuCont_busi").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Primary Communication Contact (Business)')]/../parent::div/span[contains(text(),'"+str+"')]")));

		util.verifyElementByXpath(logger, homepage.AppNotiTool_Label);
		logger.log(LogStatus.INFO, "What is the in-app notification tool? Lable present in Communication Section");
		str = inputData.get("AppNotifTool").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'What is the in-app notification tool?')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		//Need to check where this field need to enter
		util.verifyElementByXpath(logger, homepage.primaryUsergroup_Label);
		logger.log(LogStatus.INFO, "Who is your primary user group(s)? Lable present in Communication Section");
		str = inputData.get("Whoisyourprimaryusergroup").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Who is your primary user group(s)?')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.clickOn(logger, homepage.Commu_SeeLess);
		util.pause(logger, "2");
		
		/*Verifying Support Details Section */
		
		logger.log(LogStatus.INFO, "Verifying Support Details Section");
		System.out.println("Verifying Support Details Section");
		
		util.clickOn(logger, homepage.Support_SeeMore);
		util.pause(logger, "5");
		
		util.verifyElementByXpath(logger, homepage.SpecContactInstr_Label);
		logger.log(LogStatus.INFO, "Special Contact Instructions Lable present in Support Details Section");
		str = inputData.get("SpecialContactInstruction").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Special Contact Instructions')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.AIMProgID_Label);
		logger.log(LogStatus.INFO, "AIM Program ID Lable present in Support Details Section");
		str = inputData.get("AIMProgID").get("keywords").toString();
		str = str.replaceAll("k", "");
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'AIM Program ID')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		str = homepage.ApplicationStatus.getAttribute("innerText");
		
		if(str.equalsIgnoreCase("In Production"))
		{
		
			util.verifyElementByXpath(logger, homepage.AIMServiceOpsID_Label);
			logger.log(LogStatus.INFO, "AIM Service Operations ID Lable present in Support Details Section");
			str = inputData.get("AIMServOperID").get("keywords").toString();
			str = str.replaceAll("k", "");
			util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'AIM Service Operations ID')]/../parent::div/span[contains(text(),'"+str+"')]")));
			
			util.verifyElementByXpath(logger, homepage.SecOpsPortfolio_Label);
			logger.log(LogStatus.INFO, "Secondary Operations Portfolio Lable present in Support Details Section");
			util.verifyElementByXpath(logger, homepage.SecOpsPortfolio);
			
		}
		
		util.verifyElementByXpath(logger, homepage.DataBaseDelManager_Label);
		logger.log(LogStatus.INFO, "Database Delivery Manager Lable present in Support Details Section");
		str = inputData.get("DBDelManager").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Database Delivery Manager')]/../parent::div/span[contains(text(),'"+str+"')]")));

		util.verifyElementByXpath(logger, homepage.DevelopmentLead_Label);
		logger.log(LogStatus.INFO, "Development Lead Lable present in Support Details Section");
		str = inputData.get("DevLead").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Development Lead')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.EnviDelivMgr_Label);
		logger.log(LogStatus.INFO, "Environment Delivery Manager Lable present in Support Details Section");
		str = inputData.get("EnvironmentDelMgr").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Environment Delivery Manager')]/../parent::div/span[contains(text(),'"+str+"')]")));	
		
		util.verifyElementByXpath(logger, homepage.IntOpsSuppURL_Label);
		logger.log(LogStatus.INFO, "Internal Operations Support URL Lable present in Support Details Section");
		str = inputData.get("Internal_Oper_Supp_URL").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Internal Operations Support URL')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.LastDisasterRecTest_Label);
		logger.log(LogStatus.INFO, "Last Disaster Recovery Test Label present in Support Details Section");
		
		str = homepage.LastDisasterRecTest.getAttribute("innerText");
		if(str.isEmpty()==false){
			
			logger.log(LogStatus.PASS, "Last Disaster Recovery Test value is Present");
		}
		
		else{
			
			logger.log(LogStatus.FAIL, "Last Disaster Recovery Test value is not Present");
		}
		
		util.verifyElementByXpath(logger, homepage.NxtPlnDisaRCTest_Label);
		logger.log(LogStatus.INFO, "Next Planned Disaster Recovery Test Lable present in Support Details Section");
		str = homepage.NxtPlnDisaRCTest.getAttribute("innerText");
		if(str.isEmpty()==false){
			
			logger.log(LogStatus.PASS, "Next Planned Disaster Recovery Test value is present");
		}
		else
		{
			logger.log(LogStatus.PASS, "Next Planned Disaster Recovery Test value is not present");
		}
		
		util.verifyElementByXpath(logger, homepage.OverallCapaMD_Label);
		logger.log(LogStatus.INFO, "Overall Capability MD Lable present in Support Details Section");
		str = inputData.get("OverallCapababilityMD").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Overall Capability MD')]/../parent::div/span[contains(text(),'"+str+"')]")));

		util.verifyElementByXpath(logger, homepage.PrimDeplyMgr_Label);
		logger.log(LogStatus.INFO, "Primary Deployment Manager Lable present in Support Details Section");
		str = inputData.get("PrimaryDeplyManager").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Primary Deployment Manager')]/../parent::div/span[contains(text(),'"+str+"')]")));
	
		util.verifyElementByXpath(logger, homepage.ProgMD_Label);
		logger.log(LogStatus.INFO, "Program MD Lable present in Support Details Section");
		str = inputData.get("Approver2").get("Username").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Program MD')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.ProgramManager_Label);
		logger.log(LogStatus.INFO, "Program Manager Lable present in Support Details Section");
		str = inputData.get("Approver1").get("Username").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Program Manager')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.ProgramPortfolio_Label);
		logger.log(LogStatus.INFO, "Program Portfolio Lable present in Support Details Section");
		util.verifyElementByXpath(logger, homepage.ProgramPortfolio);

		util.verifyElementByXpath(logger, homepage.SOHMangAppl_Legal);
		logger.log(LogStatus.INFO, "SOH Management Application Lable present in Support Details Section");
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'SOH Management Application')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "SOH Management Application has value Yes");
		}
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'SOH Management Application')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "SOH Management Application has value No");
			
		}
		
		util.verifyElementByXpath(logger, homepage.SecDeployMgr_Label);
		logger.log(LogStatus.INFO, "Secondary Deployment Manager Lable present in Support Details Section");
		str = inputData.get("SecDeploymentMgr").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Secondary Deployment Manager')]/../parent::div/span[contains(text(),'"+str+"')]")));
	
		util.verifyElementByXpath(logger, homepage.TechArchLead_Label);
		logger.log(LogStatus.INFO, "Technology Architecture Lead Lable present in Support Details Section");
		str = inputData.get("TechArchLead").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Technology Architecture Lead')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.clickOn(logger, homepage.Support_SeeLess);
		util.pause(logger, "2");
		
		
		/*Verifying Technology Details Section */
		
		logger.log(LogStatus.INFO, "Verifying Technology Details Section");
		System.out.println("Verifying Technology Details Section");
		
		//see More button is removed in Technological Section during CMDB Q3 Release
		/*util.clickOn(logger, homepage.Tech_SeeMore);
		util.pause(logger, "5");*/
		
		util.verifyElementByXpath(logger, homepage.TechArchitecture_Header_sec);
		logger.log(LogStatus.INFO, "Technical Architecture Header Lable present in Technology Details Section");
		
		
		//Is this application web enabled? (accessed online) is removed in Technological Section during CMDB Q3 Release
		util.verifyElementByXpath(logger, homepage.AccessedOnline_Label);
		logger.log(LogStatus.INFO, "Is this application web enabled? (accessed online) Lable present in Technology Details Section");
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Is this application web enabled? (accessed online)')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Is this application web enabled? (accessed online) has value Yes");
		}
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Is this application web enabled? (accessed online)')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Is this application web enabled? (accessed online) has value No");
			
		}
		
		util.verifyElementByXpath(logger, homepage.WorkStation_Label);
		logger.log(LogStatus.INFO, "Is this application downloaded and run on workstations? Lable present in Technology Details Section");
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Is this application downloaded and run on workstations?')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Is this application downloaded and run on workstations? information has value Yes");
		}
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Is this application downloaded and run on workstations?')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Is this application downloaded and run on workstations? information has value No");
			
		}
		
		//Additional Details is removed in Technological Section during CMDB Q3 Release		
		/*util.verifyElementByXpath(logger, homepage.AdditionDetail_Label);
		logger.log(LogStatus.INFO, "Additonal Detail Lable present in Technology Details Section");
		str = inputData.get("Additional_Details").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Additonal Detail')]/../parent::div/span[contains(text(),'"+str+"')]")));*/
		
		//Environment field is removed in Technological Section during CMDB Q3 Release	
		/*util.verifyElementByXpath(logger, homepage.Environment_Label);
		logger.log(LogStatus.INFO, "Environment Lable present in Technology Details Section");
		str = inputData.get("Environment").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Environment')]/../parent::div/span[contains(text(),'"+str+"')]")));*/
		
		
		//The below code is commented due to CMDB Q3 Release:
		/*util.verifyElementByXpath(logger, homepage.LstModiOn_Label);
		logger.log(LogStatus.INFO, "Last Modified On Lable present in Technology Details Section");
		
		str = homepage.LstModiOn.getAttribute("innerText");
		
		if(str.isEmpty()==false){
			
			logger.log(LogStatus.PASS, "Last Modified On Date is available");
		}
		
		else{
			logger.log(LogStatus.FAIL, "Last Modified On Date is not available");
		}
		
		util.verifyElementByXpath(logger, homepage.LstModiby_Label);
		logger.log(LogStatus.INFO, "Last Modified By Lable present in Technology Details Section");
		str = inputData.get("Requester").get("Username").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'LastModified by')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.Loc_Label);
		logger.log(LogStatus.INFO, "Location Lable present in Technology Details Section");
		str = inputData.get("Technology_Location").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Location')]/../parent::div/span[contains(text(),'"+str+"')]")));*/
		
		util.verifyElementByXpath(logger, homepage.MobileCapability_Label);
		logger.log(LogStatus.INFO, "Mobile Capability Lable present in Technology Details Section");
		str = inputData.get("MobCapability").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath("//b[contains(text(),'Mobile capability')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.TechnologyArchitecture_Label);
		logger.log(LogStatus.INFO, "Technology Architecture Lable present in Technology Details Section");
		
		str = homepage.TechnologyArchitecture.getAttribute("innerText");
		
		if(str.isEmpty()==false){
			
			logger.log(LogStatus.PASS, "Technology Architecture values are available");
		}
		
		else{
			logger.log(LogStatus.FAIL, "Technology Architecture values are not available");
		}
		
		//Capturing TCN Number from Technology Details Sections
		
		System.out.println("Capturing TCN Number from Technology Details Sections");
		logger.log(LogStatus.INFO, "Capturing TCN Number from Technology Details Sections");
		TCNnumber = homepage.Techno_TCN_Num.getAttribute("innerText");
		System.out.println("Technology TCN number: "+ TCNnumber);
		logger.log(LogStatus.INFO, "Tehnology TCN Number: "+ TCNnumber);
		
		str = homepage.Techno_Appl_id.getAttribute("innerText");
		System.out.println("Application id is: " +str);
		logger.log(LogStatus.INFO, "Application id is: " +str);
		if(str.isEmpty()==false)
		{
			logger.log(LogStatus.PASS, "Application id is available");
		}
		
		else{
			logger.log(LogStatus.FAIL, "Application id is not available");
		}
		
		util.verifyElementByXpath(logger, homepage.Techno_Location_Label);
		logger.log(LogStatus.INFO, "Location Lable present in Technology Details Section");
		
		str = homepage.Techno_Number.getAttribute("innerText");
		System.out.println("Number is: " +str);
		logger.log(LogStatus.INFO, "Number is: " +str);
		if(str.equals(TCNnumber))
		{
			logger.log(LogStatus.PASS, "Number is matching with TCN Number");
		}
		
		else{
			logger.log(LogStatus.FAIL, "Number is not matching with TCN Number");
		}

		
		util.verifyElementByXpath(logger, homepage.Product_Label);
		logger.log(LogStatus.INFO, "Product Lable present in Technology Details Section");
		str = inputData.get("Reg_Product").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath("//b[contains(text(),'Product')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.Provisioning_Label);
		logger.log(LogStatus.INFO, "Provising Lable present in Technology Details Section");
		str = inputData.get("Reg_Provisioning").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath("//b[contains(text(),'Provisioning')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.Supplier_Label);
		logger.log(LogStatus.INFO, "Supplier Lable present in Technology Details Section");
		str = inputData.get("Reg_Supplier").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath("//b[contains(text(),'Supplier')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.Type_Label);
		logger.log(LogStatus.INFO, "Type Lable present in Technology Details Section");
		str = inputData.get("Reg_Type").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath("//b[contains(text(),'Type')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		/*util.verifyElementByXpath(logger, homepage.Techno_Appl_id_Label);
		logger.log(LogStatus.INFO, " Application ID Lable present in Technology Details Section");*/
		
		/*util.verifyElementByXpath(logger, homepage.Techno_Number_Label);
		logger.log(LogStatus.INFO, "Number Lable present in Technology Details Section");*/
		
		/*util.verifyElementByXpath(logger, homepage.VendorDetails);
		logger.log(LogStatus.INFO, "Vendor Details Lable present in Technology Details Section");*/
		
		/*util.clickOn(logger, homepage.Tech_SeeLess);
		util.pause(logger, "2");*/
		
		/*Verifying Legal Details Section details */
		
		logger.log(LogStatus.INFO, "Verifying Legal Details Section");
		System.out.println("Verifying Legal Details Section");
		
		util.clickOn(logger, homepage.Legal_SeeMore_Label);
		util.pause(logger, "5");
		
		util.verifyElementByXpath(logger, homepage.DataClassi_Label);
		logger.log(LogStatus.INFO, "Data Classification Lable present in Legal Details Section");
		str = inputData.get("DataClassification").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Data Classification')]/../parent::div/span[contains(text(),'"+str+"')]")));

		util.verifyElementByXpath(logger, homepage.PersIdentiInfo_Label);
		logger.log(LogStatus.INFO, "Personally identifiable information Lable present in Legal Details Section");
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Personally identifiable information')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Personally identifiable information has value Yes");
		}
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Personally identifiable information')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Personally identifiable information has value No");
			
		}
		
		util.verifyElementByXpath(logger, homepage.VIPEnabled_Label);
		logger.log(LogStatus.INFO, "VIP Enabled Label present in Legal Details Section");
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Web App Security (WAS) managed?')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "VIP Enabled? has value Yes");
		}
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Web App Security (WAS) managed?')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "VIP Enabled? has value No");
			
		}
		
		util.verifyElementByXpath(logger, homepage.WebAppSecManaged_Label);
		logger.log(LogStatus.INFO, "Web App Security (WAS) managed? Lable present in Legal Details Section");
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Web App Security (WAS) managed?')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Web App Security (WAS) managed? has value Yes");
		}
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Web App Security (WAS) managed?')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Web App Security (WAS) managed? has value No");
			
		}
		
		util.verifyElementByXpath(logger, homepage.SysContSensiData_Label);
		logger.log(LogStatus.INFO, "Does the System contain Sensitive Data Lable present in Legal Details Section");
		
		if(driver.findElements(By.xpath("//b[contains(text(),'Does the Ssystem contain Sensitive Data')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Does the System contain Sensitive Data has value Yes");
		}
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Does the Ssystem contain Sensitive Data')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Does the System contain Sensitive Data has value No");
			
		}
		
		util.verifyElementByXpath(logger, homepage.AFSEmployees_Lable);
		logger.log(LogStatus.INFO, "Does the system contain Accenture Federal Services (AFS) data and/or do AFS Employees use the system Lable present in Legal Details Section");
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Does the system contain Accenture Federal Services (AFS) data and/or do AFS Employees use the system')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Does the system contain Accenture Federal Services (AFS) data and/or do AFS Employees use the system has value Yes");
		}
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Does the system contain Accenture Federal Services (AFS) data and/or do AFS Employees use the system')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Does the system contain Accenture Federal Services (AFS) data and/or do AFS Employees use the system has value No");
			
		}
		
		util.verifyElementByXpath(logger, homepage.ClientOwnData_Label);
		logger.log(LogStatus.INFO, "Does the system contain Client Owned Data Lable present in Legal Details Section");
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Does the system contain Client Owned Data')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Does the system contain Client Owned Data has value Yes");
		}
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Does the system contain Client Owned Data')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Does the system contain Client Owned Data has value No");
			
		}
		
		util.verifyElementByXpath(logger, homepage.AIRLegal_Label);
		logger.log(LogStatus.INFO, "Has the AIR Legal Tab been completed? Lable present in Legal Details Section");
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Has the AIR Legal Tab been completed?')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Has the AIR Legal Tab been completed? has value Yes");
		}
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Has the AIR Legal Tab been completed?')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Has the AIR Legal Tab been completed? has value No");
			
		}
			
		util.verifyElementByXpath(logger, homepage.Archiving_Label);
		logger.log(LogStatus.INFO, "In the event of a Hold Notice, is it possible to suspend routine purging/archiving? Lable present in Legal Details Section");
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'In the event of a Hold Notice, is it possible to suspend routine purging/archiving?')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "In the event of a Hold Notice, is it possible to suspend routine purging/archiving? has value Yes");
		}
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'In the event of a Hold Notice, is it possible to suspend routine purging/archiving?')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "In the event of a Hold Notice, is it possible to suspend routine purging/archiving? has value No");
			
		}

		util.verifyElementByXpath(logger, homepage.ContractualHoldNotice_Label);
		logger.log(LogStatus.INFO, "Is it possible / within contractual rights to extract data that may be subject to a Hold Notice? Lable present in Legal Details Section");
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Is it possible / within contractual rights to extract data that may be subject to a Hold Notice?')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Is it possible / within contractual rights to extract data that may be subject to a Hold Notice? has value Yes");
		}
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Is it possible / within contractual rights to extract data that may be subject to a Hold Notice?')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Is it possible / within contractual rights to extract data that may be subject to a Hold Notice? has value No");
			
		}
		
		util.verifyElementByXpath(logger, homepage.HldNotice_Label);
		logger.log(LogStatus.INFO, "Is it possible to identify data relevant to a Hold Notice? Lable present in Legal Details Section");
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Is it possible to identify data relevant to a Hold Notice?')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Is it possible / within contractual rights to extract data that may be subject to a Hold Notice? has value Yes");
		}
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Is it possible to identify data relevant to a Hold Notice?')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Is it possible / within contractual rights to extract data that may be subject to a Hold Notice? has value No");
			
		}
		
		util.verifyElementByXpath(logger, homepage.PreserveData_Label);
		logger.log(LogStatus.INFO, "Is it possible to preserve data that may be subject to a Hold Notice? Lable present in Legal Details Section");
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Is it possible to preserve data that may be subject to a Hold Notice?')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Is it possible to preserve data that may be subject to a Hold Notice? has value Yes");
		}
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Is it possible to preserve data that may be subject to a Hold Notice?')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Is it possible to preserve data that may be subject to a Hold Notice? field has value No");
		}

		
		util.verifyElementByXpath(logger, homepage.PAMApplID_Label);
		logger.log(LogStatus.INFO, "PAM Managed - Application ID? Lable present in Legal Details Section");
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'PAM Managed - Application ID?')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "PAM Managed - Application ID? has value Yes");
		}
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'PAM Managed - Application ID?')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "PAM Managed - Application ID? has value No");
		}
		

		util.verifyElementByXpath(logger, homepage.Built_In_Label);
		logger.log(LogStatus.INFO, "PAM Managed - Built-in? Lable present in Legal Details Section");
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'PAM Managed - Built-in?')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "PAM Managed - Built-in? has value Yes");
		}

		if(driver.findElements(By.xpath(".//b[contains(text(),'PAM Managed - Built-in?')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "PAM Managed - Built-in? has value No");
		}

		util.verifyElementByXpath(logger, homepage.Firefighter_Label);
		logger.log(LogStatus.INFO, "PAM Managed - Firefighter? Lable present in Legal Details Section");
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'PAM Managed - Firefighter?')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "PAM Managed - Firefighter? has value Yes");
		}
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'PAM Managed - Firefighter?')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "PAM Managed - Firefighter? has value No");
		}
		
		
		util.verifyElementByXpath(logger, homepage.TeamAdmin_Label);
		logger.log(LogStatus.INFO, "PAM Managed - Tempadmin? Lable present in Legal Details Section");

		if(driver.findElements(By.xpath(".//b[contains(text(),'PAM Managed - Tempadmin?')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "PAM Managed - Tempadmin? has value No");
		}
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'PAM Managed - Tempadmin?')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "PAM Managed - Tempadmin? has value Yes");
		}
		
		util.verifyElementByXpath(logger, homepage.Sarbox_Label);
		logger.log(LogStatus.INFO, "Sarbox Application? Lable present in Legal Details Section");	
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Sarbox Application')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Sarbox Application has value Yes");
		}
		
		if(driver.findElements(By.xpath(".//b[contains(text(),'Sarbox Application')]/../parent::div/span[contains(text(),'No')]")).size()==1)
		{
			logger.log(LogStatus.PASS, "Sarbox Application has value no");
		}
		
		util.verifyElementByXpath(logger, homepage.ProductionSystem_Label);
		logger.log(LogStatus.INFO, "What country is the Production system(s) data stored in? Lable present in Legal Details Section");
		str = inputData.get("Country").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'What country is the Production system(s) data stored in?')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.DatainSys_Label);
		logger.log(LogStatus.INFO, "Who can see data in the system? Lable present in Legal Details Section");
		str = inputData.get("WhoCanSeeData").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Who can see data in the system?')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.verifyElementByXpath(logger, homepage.WhoUsesSystem_Label);
		logger.log(LogStatus.INFO, "Who uses the system? Lable present in Legal Details Section");
		str = inputData.get("WhoUsesSys").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Who uses the system?')]/../parent::div/span[contains(text(),'"+str+"')]")));
		
		util.clickOn(logger, homepage.Legal_SeeLess);
		util.pause(logger, "2");
		
		/*Verifying Primary Contact Details Section */
		
		logger.log(LogStatus.INFO, "Verifying Primary Contact Details Section");
		System.out.println("Verifying Primary Contact Details Section");
		
		util.verifyElementByXpath(logger, homepage.PrimaryContacts_Label);
		logger.log(LogStatus.INFO, "Primary Contacts Lable present in Primary Contacts Details Section");
		
		str = homepage.ApplicationStatus.getAttribute("innerText");
		if(str.equalsIgnoreCase("Funded/Not Started"))
		{
			util.verifyElementByXpath(logger, homepage.PrimProgLeadName_Label);
			logger.log(LogStatus.INFO, "Primary Program Lead Lable present in Primary Contacts Details Section");
			
			util.verifyElementByXpath(logger, homepage.PrimProgLead_Skypeimage);
			logger.log(LogStatus.INFO, "Primary Program Lead Skype Image is verified");
			
			util.verifyElementByXpath(logger, homepage.PrimProgLead_Outlookimage);
			logger.log(LogStatus.INFO, "Primary Program Lead Outlook Image is verified");
			
			util.verifyElementByXpath(logger, homepage.PrimProgMgrName_Label);
			logger.log(LogStatus.INFO, "Primary Program Manager Lable present in Primary Contacts Details Section");
			
			str = inputData.get("Approver1").get("Username").toString();
			util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]")));
			logger.log(LogStatus.INFO, "Primary Program Manager Name verified");
			
			util.verifyElementByXpath(logger, homepage.PrimProgMgr_Skypeimage);
			logger.log(LogStatus.INFO, "Primary Program Manager Skype Image is verified");
			
			util.verifyElementByXpath(logger, homepage.PrimProgMgr_Outlookimage);
			logger.log(LogStatus.INFO, "Primary Program Manager Outlook Image is verified");
			
			str = inputData.get("Approver2").get("Username").toString();
			util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]")));
			logger.log(LogStatus.INFO, "Primary Program MD Name present in Primary Contacts Details Section");
			
			util.verifyElementByXpath(logger, homepage.PrimProgMD_Label);
			logger.log(LogStatus.INFO, "Primary Program MD Lable present in Primary Contacts Details Section");
			
			str = homepage.PrimProgMDPHNumber.getAttribute("innerText");
			
			if(str.contains("+919811882419")){
				
				logger.log(LogStatus.PASS, "Primary Program MD phone number is available");
			}
			
			else{
				logger.log(LogStatus.FAIL, "Primary Program MD phone number is not available");
			}
			
			util.verifyElementByXpath(logger, homepage.PrimProgMD_Skypeimage);
			logger.log(LogStatus.INFO, "Primary Program MD Skype Image is verified");
			
			util.verifyElementByXpath(logger, homepage.PrimProgMD_Outlookimage);
			logger.log(LogStatus.INFO, "Primary Program MD Outlook Image is verified");
			
		}
		//Below code commented bcz Service Oprs Lead field is not exists in CMDB Q3 Release
		
		str = homepage.ApplicationStatus.getAttribute("innerText");
		if(str.equalsIgnoreCase("In Production"))
		{
			str = inputData.get("ServiceOpsLead").get("keywords").toString();
			util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]")));
			logger.log(LogStatus.INFO, "Primary Service Operations Lead Name present in Primary Contacts Details Section");
			
			
			util.verifyElementByXpath(logger, homepage.PrimServiceOperLead_Label);		
			logger.log(LogStatus.INFO, "Primary Service Operations Lead Lable present in Primary Contacts Details Section");	
			
			util.verifyElementByXpath(logger, homepage.PrimServiceOperLeadPHNumber);
			logger.log(LogStatus.INFO, "Primary Service Operations Lead phone present in Primary Contacts Details Section");

			//Below code commented bcz Servuce Oprs Ph num field is not exists in CMDB Q3 Release
			str = homepage.PrimServiceOperLeadPHNumber.getAttribute("innerText");
			
			if(str.isEmpty()==false){
				
				logger.log(LogStatus.PASS, "Primary Service Operations Lead phone number is available");
			}
			
			else{
				logger.log(LogStatus.FAIL, "Primary Service Operations Lead phone number is not available");
			}
			
			//Below code commented bcz Servuce Oprs Lead field is not exists in CMDB Q3 Release
			str = inputData.get("ServiceOpsLead").get("keywords").toString();
			util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]/parent::div/following-sibling::div/a/i[@class='fa fa-skype fa-lg']")));
			logger.log(LogStatus.INFO, "Primary Service Operations Lead Skype Image is verified");
			
			str = inputData.get("ServiceOpsLead").get("keywords").toString();
			util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]/parent::div/following-sibling::div/a/i[@class='fa fa-envelope fa-lg']")));
			logger.log(LogStatus.INFO, "Primary Service Operations Lead Outlook Image is verified");
						
			//Below code commented bcz Service Oprs manager field is not exists in CMDB Q3 Release
			str = inputData.get("ServiceOpsManager").get("keywords").toString();
			util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]")));
			logger.log(LogStatus.INFO, "Primary Service Operations Manager Name present in Primary Contacts Details Section");
			
			util.verifyElementByXpath(logger, homepage.PrimServOpsMgr_Label);
			logger.log(LogStatus.INFO, "Primary Service Operations Manager Lable present in Primary Contacts Details Section");
			
			//util.verifyElementByXpath(logger, homepage.PrimServiceOperMgrPHNumber);
			//logger.log(LogStatus.INFO, "Primary Service Operations Manager phone present in Primary Contacts Details Section");
			
			//Below code commented bcz Primary Service Oper Mgr PHNumbe field is not exists in CMDB Q3 Release
			str = homepage.PrimServiceOperMgrPHNumber.getAttribute("innerText");
			if(str.isEmpty()==false){
				
				logger.log(LogStatus.PASS, "Primary Service Operations Manager phone number is available");
			}
			
			else{
				logger.log(LogStatus.FAIL, "Primary Service Operations Manager phone number is not available");
			}
			
			
			//Below code commented bcz Service Oper Mgr Skype and putlook field is not exists in CMDB Q3 Release
			
			str = inputData.get("ServiceOpsManager").get("keywords").toString();
			util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]/../parent::div/div/a/i[@class='fa fa-skype fa-lg']")));
			logger.log(LogStatus.INFO, "Primary Service Operations Manager Skype Image is verified");
			
			str = inputData.get("ServiceOpsManager").get("keywords").toString();
			util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]/../parent::div/div/a/i[@class='fa fa-envelope fa-lg']")));
			logger.log(LogStatus.INFO, "Primary Service Operations Manager Outlook Image is verified");
			
			////////////////////////////////////////////////////////
			
			//Below code commented bcz secondary Service Oper MD Name, PHNumbe field is not exists in CMDB Q3 Release
			str = inputData.get("ServiceOpsMD").get("keywords").toString();
			util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]")));
			logger.log(LogStatus.INFO, "Primary Service Operations MD Name present in Primary Contacts Details Section");
			
			util.verifyElementByXpath(logger, homepage.PrimServOpsMD_Label);
			logger.log(LogStatus.INFO, "Primary Service Operations MD Lable present in Primary Contacts Details Section");
			
			str = homepage.PrimServOpsMDPhNumber.getAttribute("innerText");
			
			if(str.isEmpty()==false){
				
				logger.log(LogStatus.PASS, "Primary Service Operations MD phone number is available");
			}
			
			else{
				logger.log(LogStatus.FAIL, "Primary Service Operations MD phone number is not available");
			}
			
			str = inputData.get("ServiceOpsMD").get("keywords").toString();
			util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]/../parent::div/div/a/i[@class='fa fa-skype fa-lg']")));
			logger.log(LogStatus.INFO, "Primary Service Operations MD Skype Image is verified");
			
			str = inputData.get("ServiceOpsMD").get("keywords").toString();
			util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]/../parent::div/div/a/i[@class='fa fa-envelope fa-lg']")));
			logger.log(LogStatus.INFO, "Primary Service Operations MD Outlook Image is verified");
			
		}

		/*Verifying Emergency Contacts Details Section */
		
		logger.log(LogStatus.INFO, "Verifying Emergency Contacts Details Section");
		System.out.println("Verifying Emergency Contacts Details Section");
		
		util.verifyElementByXpath(logger, homepage.EmerContacts_Label);
		logger.log(LogStatus.INFO, "Emergency Contacts Lable present in Emergency Contacts Details Section");

		str = inputData.get("PrimaryEmergencyContactName").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]")));
		logger.log(LogStatus.INFO, "Primary Emergency Contact Name present in Emergency Contacts Details Section");
		
		util.verifyElementByXpath(logger, homepage.Emer_Primary_Label);
		logger.log(LogStatus.INFO, "Primary Lable present in Emergency Contacts Details Section");
			
		str = inputData.get("PrimaryContactNum").get("keywords").toString();
		str = str.replaceAll("k", "");
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//div[@class='col-xs-6 user-info']/label[contains(text(),'"+str+"')]")));
		logger.log(LogStatus.INFO, "Primary phone number present in Emergency Contacts Details Section");
		
		str = inputData.get("PrimaryEmergencyContactName").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]/parent::div/following-sibling::div/a/i[@class='fa fa-skype fa-lg disableicon']")));
		logger.log(LogStatus.INFO, "Emergency Contacts Primary Skype Image is verified");
		
		str = inputData.get("PrimaryEmergencyContactName").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]/parent::div/following-sibling::div/a/i[@class='fa fa-envelope fa-lg disableicon']")));
		logger.log(LogStatus.INFO, "Emergency Contacts Primary Outlook Image is verified");
		
		////////////////////////////////////////////////
		
		//util.verifyElementByXpath(logger, homepage.Emer_Secondary_Contact_Name);
		
		str = inputData.get("Sec_emer_Cont_Name").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]")));
		logger.log(LogStatus.INFO, "Secondary Emergency Contacts Name present in Emergency Contacts Details Section");
		
		util.verifyElementByXpath(logger, homepage.Emer_Secondary_Label);
		logger.log(LogStatus.INFO, "Secondary Lable present in Emergency Contacts Details Section");
		
		/*util.verifyElementByXpath(logger, homepage.Emer_Secondary_PHNumber);
		logger.log(LogStatus.INFO, "Emergency Contact Secondary phone number present in Emergency Contacts Details Section");*/
		
		str = inputData.get("Sec_Cont_Number").get("keywords").toString();
		str = str.replaceAll("k", "");
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//div[@class='col-xs-6 user-info']/label[contains(text(),'"+str+"')]")));
		logger.log(LogStatus.INFO, " Secondary phone number present in Emergency Contacts Details Section");
		
		str = inputData.get("Sec_emer_Cont_Name").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]/../parent::div/div/a/i[@class='fa fa-skype fa-lg disableicon']")));
		logger.log(LogStatus.INFO, "Emergency Contacts Secondary Skype Image is verified");
		
		str = inputData.get("Sec_emer_Cont_Name").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]/../parent::div/div/a/i[@class='fa fa-envelope fa-lg disableicon']")));
		logger.log(LogStatus.INFO, "Emergency Contacts Secondary Outlook Image is verified");
		
		/////////////////////////////////
		
		str = inputData.get("Tertiary_Emer_Cont_Name").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//div[@class='col-xs-6 user-info']/label[contains(text(),'"+str+"')]")));
		logger.log(LogStatus.INFO, "Tertiary Emergency Contacts Name present in Emergency Contacts Details Section");
		
		util.verifyElementByXpath(logger, homepage.Emer_Tertiary_Label);
		logger.log(LogStatus.INFO, "Tertiary Lable present in Emergency Contacts Details Section");
		
		str = inputData.get("Tertiary_Cont_Number").get("keywords").toString();
		str = str.replaceAll("k", "");
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//div[@class='col-xs-6 user-info']/label[contains(text(),'"+str+"')]")));
		logger.log(LogStatus.INFO, "Emergency Contact Tertiary phone number present in Emergency Contacts Details Section");
		
		str = inputData.get("Tertiary_Emer_Cont_Name").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]/../parent::div/div/a/i[@class='fa fa-skype fa-lg disableicon']")));
		logger.log(LogStatus.INFO, "Emergency Contacts Tertiary Skype Image is verified");
		
		str = inputData.get("Tertiary_Emer_Cont_Name").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]/../parent::div/div/a/i[@class='fa fa-envelope fa-lg disableicon']")));
		logger.log(LogStatus.INFO, "Emergency Contacts Tertiary Outlook Image is verified");
		
		/*Verifying Support Contacts Details Section */
		
		logger.log(LogStatus.INFO, "Verifying Support Contacts Details Section");
		System.out.println("Verifying Support Contacts Details Section");
		
		util.verifyElementByXpath(logger, homepage.SupportContacts_Lable);
		logger.log(LogStatus.INFO, "Support Contacts Lable present in Support Contacts Details Section");

		
		str = inputData.get("P1Contact").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]")));
		logger.log(LogStatus.INFO, " P1 Contact Support Name present in Support Contacts Details Section");
		
		util.verifyElementByXpath(logger, homepage.P1_Contact_Label);
		logger.log(LogStatus.INFO, "P1 Contact Lable present in Support Contacts Details Section");
		
		str = inputData.get("P1Contact").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]/../parent::div/div/a/i[@class='fa fa-envelope fa-lg disableicon']")));
		logger.log(LogStatus.INFO, "P1 Contact Outlook Image is verified");
		
		str = inputData.get("P2Contact").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]")));
		logger.log(LogStatus.INFO, " P2 Contact Support Name present in Support Contacts Details Section");
		
		util.verifyElementByXpath(logger, homepage.P2_Contact_Label);
		logger.log(LogStatus.INFO, "P2 Contact Lable present in Support Contacts Details Section");
		
		str = inputData.get("P2Contact").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]/../parent::div/div/a/i[@class='fa fa-envelope fa-lg disableicon']")));
		logger.log(LogStatus.INFO, "P2 Contact Outlook Image is verified");
		
		str = inputData.get("Operational_supp_email").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]")));
		logger.log(LogStatus.INFO, " General Ops Email present in Support Contacts Details Section");
		
		util.verifyElementByXpath(logger, homepage.Gen_Ops_Email_Label);
		logger.log(LogStatus.INFO, "General Ops Email Lable present in Support Contacts Details Section");
		
		str = inputData.get("Operational_supp_email").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]/../parent::div/div/a/i[@class='fa fa-envelope fa-lg disableicon']")));
		logger.log(LogStatus.INFO, "General Operations Email Outlook Image is verified");
		
		str = inputData.get("PrimaryContactNum").get("keywords").toString();
		str = str.replaceAll("k", "");
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]")));
		logger.log(LogStatus.INFO, " General Ops Phone Number (Optional) present in Support Contacts Details Section");
		
		/*util.verifyElementByXpath(logger, homepage.GeneralOpsPhoneNumber_Label);
		logger.log(LogStatus.INFO, "General Ops Phone Number (Optional) Lable present in Emergency Contacts Details Section");*/
		
		str = inputData.get("Chat_SkypeID").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]")));
		logger.log(LogStatus.INFO, " Chat_SkypeID Name present in Support Contacts Details Section");
		
		util.verifyElementByXpath(logger, homepage.Chat_SkypeID_Label);
		logger.log(LogStatus.INFO, "Chat_SkypeID Lable present in Emergency Contacts Details Section");
		
		str = inputData.get("Chat_SkypeID").get("keywords").toString();
		util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]/../parent::div/div/a/i[@class='fa fa-skype fa-lg disableicon']")));
		logger.log(LogStatus.INFO, "Chat and SkypeID Outlook Image is verified");
		}

		 catch(Exception e)
	       {
	               util.screenShotAndErrorMsg(logger, e, driver, "ApplicationDetailViewPage");
	       }
	       extent.endTest(logger);
	       extent.flush();
		
	}

	@Test
	public void  SearchApplicationRepository(){
		ExtentTest logger = extent.startTest("SearchApplicationRepository", "SearchApplicationRepository");
		
		try
		{
			homepage = PageFactory.initElements(driver, HomePage.class);
			
			util.waittillpageload(logger, driver);
			util.pause(logger, "30");
			util.waitTillElementIsClickable(logger, driver, homepage.SearchApplRepository);
			util.waittillpageload(logger, driver);
			util.pause(logger, "20");
			
			util.setText(logger, homepage.SearchApplRepository, "AutomationCMDB");
			
			util.pause(logger, "10");
			
		List<WebElement> list1= driver.findElements(By.xpath(".//ul[@id='ui-id-1']/li"));
			System.out.println(list1.size());
			for (int m=0; m<list1.size(); m++){
				String SearchResult = list1.get(m).getText();				
     			System.out.println(SearchResult);
     			logger.log(LogStatus.INFO, "Search Application Repository Results");
     			}
			
			util.pause(logger, "10");
			//Show More Results link
	
			if (driver.findElement(By.xpath(".//a[contains(text(),'Show More Results')]")).isDisplayed()==true){
			
				util.clickOn(logger, homepage.ShowMoreResults_Link);
				
				util.waittillpageload(logger, driver);
				util.pause(logger, "5");
				
				logger.log(LogStatus.INFO, "After Clicking on Show More Result List View Displayed sucessfully");
			}
		
				util.pause(logger, "5");
				util.verifyElementByXpath(logger, homepage.ListApplicationID);
	           logger.log(LogStatus.INFO, "Application Id column verified");
	           util.verifyElementByXpath(logger, homepage.List_ApplicationName);
	           logger.log(LogStatus.INFO, "Application Name column verified");
	           util.verifyElementByXpath(logger, homepage.List_RegistrationStatus);
	           logger.log(LogStatus.INFO, "Registration Status column verified");
	           util.verifyElementByXpath(logger, homepage.List_ApplicationStatus);
	           logger.log(LogStatus.INFO, "Application Status column verified");
	           util.verifyElementByXpath(logger, homepage.List_Description);
	           logger.log(LogStatus.INFO, "Description column verified");
	           util.verifyElementByXpath(logger, homepage.List_ServiceTier);
	           logger.log(LogStatus.INFO, "ServiceTier column verified");
	           
	           util.verifyElementByXpath(logger, homepage.List_ServiceOpLead);
	           logger.log(LogStatus.INFO, "Service Operations Lead column verified");
	           
	           util.verifyElementByXpath(logger, homepage.List_ServiceOpManager);
	           logger.log(LogStatus.INFO, "Service Operations Manager column verified");
	           
	           util.verifyElementByXpath(logger, homepage.List_ProjectLead);
	           logger.log(LogStatus.INFO, "Project Lead column verified");
	           
	           util.verifyElementByXpath(logger, homepage.List_ProjectManager);
	           logger.log(LogStatus.INFO, "Project Manager column verified");
	           
	           util.verifyElementByXpath(logger, homepage.List_ComponentType);
	           logger.log(LogStatus.INFO, "Component Type column verified");
	           
	           util.verifyElementByXpath(logger, homepage.List_Organization);
	           logger.log(LogStatus.INFO, "Organization column verified");
	           
	           util.verifyElementByXpath(logger, homepage.List_ReportingEntity);
	           logger.log(LogStatus.INFO, "Reporting Entity column verified");
	           
	           util.verifyElementByXpath(logger, homepage.List_VerifiedBy);
	           logger.log(LogStatus.INFO, "VerifiedBy column verified");
	           
	           util.verifyElementByXpath(logger, homepage.List_VerifiedOn);
	           logger.log(LogStatus.INFO, "VerifiedOn column verified");
	           
	           //Clicking on Search/Report Link
	           util.clickByJavascriptExecutor(logger, driver, homepage.MyActivities);
	           util.pause(logger, "2");
	           util.waitTillElementIsVisible(logger, driver, homepage.Search_Reports);
		       util.clickOn(logger, homepage.Search_Reports);
		       util.waittillpageload(logger, driver);
		       util.pause(logger, "10");
		       util.verifyElementByXpath(logger, homepage.SearchBy);
		       logger.log(LogStatus.INFO, "SEARCH BY Text displayed");
		       util.verifyElementByXpath(logger, homepage.Search_ServiceTier);
		       logger.log(LogStatus.INFO, "Searvice Tier Text displayed");
		       util.verifyElementByXpath(logger, homepage.Search_ComponentType);
		       logger.log(LogStatus.INFO, "Component Type Text displayed");
		       util.verifyElementByXpath(logger, homepage.Search_ApplicationStatus);
		       logger.log(LogStatus.INFO, "Application Status Text displayed");
		       util.verifyElementByXpath(logger, homepage.Search_Organization);
		       logger.log(LogStatus.INFO, "Organization Text displayed");
		       
		       util.pause(logger, "5");
		       util.clickOn(logger, homepage.Search_ServiceTier);
		       util.pause(logger, "5");
		       util.clickOn(logger, homepage.NearlyAlwaysOn_CheckBox);
		       util.pause(logger, "2");
		       util.clickOn(logger, homepage.Standard_CheckBox);
		       util.pause(logger, "2");
		       
		       util.clickOn(logger, homepage.Search_ComponentType);
		       util.pause(logger, "2");
		       util.clickOn(logger, homepage.Application_CheckBox);
		       util.pause(logger, "2");
		       util.clickOn(logger, homepage.NotAssigned_CheckBox);
		       util.pause(logger, "2");
		       //not present during CMDB Q3
		     /*  util.clickOn(logger, homepage.ITSuppServ_CheckBox);
		       util.pause(logger, "2");*/
		       util.clickOn(logger, homepage.SaaS_CheckBox);
		       
		       util.pause(logger, "2");
		       util.clickOn(logger, homepage.Search_ApplicationStatus);
		       util.pause(logger, "2");
		       util.clickOn(logger, homepage.Funded_NotStarted_CheckBox);
		       util.pause(logger, "2");
		       util.clickOn(logger, homepage.ToBeSunSet_CheckBox);
		       util.pause(logger, "2");
		     /*util.clickOn(logger, homepage.SunSet_CheckBox);
		       util.pause(logger, "2");
		       util.clickOn(logger, homepage.Withdrawn_CheckBox);*/
		       
		       util.pause(logger, "2");
		       util.clickOn(logger, homepage.Search_Organization);
		       util.pause(logger, "2");
		       util.clickOn(logger, homepage.CIO_CheckBox);
		       util.pause(logger, "2");
		      /* util.clickOn(logger, homepage.NON_CIO_CheckBox);
		       util.pause(logger, "2");*/
		       util.clickOn(logger, homepage.Search_btn);
		       util.waittillpageload(logger, driver);
		       util.pause(logger, "10");
		       
		       util.verifyElementByXpath(logger, homepage.ListApplicationID);
	           logger.log(LogStatus.INFO, "Application Id column verified");
	           util.verifyElementByXpath(logger, homepage.List_ApplicationName);
	           logger.log(LogStatus.INFO, "Application Name column verified");
	           util.verifyElementByXpath(logger, homepage.List_RegistrationStatus);
	           logger.log(LogStatus.INFO, "Registration Status column verified");
	           util.verifyElementByXpath(logger, homepage.List_ApplicationStatus);
	           logger.log(LogStatus.INFO, "Application Status column verified");
	           util.verifyElementByXpath(logger, homepage.List_Description);
	           logger.log(LogStatus.INFO, "Description column verified");
	           util.verifyElementByXpath(logger, homepage.List_ServiceTier);
	           logger.log(LogStatus.INFO, "ServiceTier column verified");
	           
	           util.verifyElementByXpath(logger, homepage.List_ServiceOpLead);
	           logger.log(LogStatus.INFO, "Service Operations Lead column verified");
	           
	           util.verifyElementByXpath(logger, homepage.List_ServiceOpManager);
	           logger.log(LogStatus.INFO, "Service Operations Manager column verified");
	           
	           util.verifyElementByXpath(logger, homepage.List_ProjectLead);
	           logger.log(LogStatus.INFO, "Project Lead column verified");
	           
	           util.verifyElementByXpath(logger, homepage.List_ProjectManager);
	           logger.log(LogStatus.INFO, "Project Manager column verified");
	           
	           util.verifyElementByXpath(logger, homepage.List_ComponentType);
	           logger.log(LogStatus.INFO, "Component Type column verified");
	           
	           util.verifyElementByXpath(logger, homepage.List_Organization);
	           logger.log(LogStatus.INFO, "Organization column verified");
	           
	           util.verifyElementByXpath(logger, homepage.List_ReportingEntity);
	           logger.log(LogStatus.INFO, "Reporting Entity column verified");
	           
	           util.verifyElementByXpath(logger, homepage.List_VerifiedBy);
	           logger.log(LogStatus.INFO, "VerifiedBy column verified successfully");
	           
	           util.verifyElementByXpath(logger, homepage.List_VerifiedOn);
	           logger.log(LogStatus.INFO, "VerifiedOn column verified successfully");
	           
	           util.waitTillElementIsVisible(logger, driver, homepage.Menu);
	           util.clickOn(logger, homepage.Menu);
	           util.pause(logger, "5");
	           util.verifyElementByXpath(logger, homepage.Export_PDF);
	           logger.log(LogStatus.INFO, "Export as PDF option is present");
	           util.pause(logger, "2");
	           util.verifyElementByXpath(logger, homepage.Export_Excel);
	           logger.log(LogStatus.INFO, "Export as Excel option is present");
	           util.pause(logger, "2");
	           util.verifyElementByXpath(logger, homepage.Export_CSV);
	           logger.log(LogStatus.INFO, "Export as CSV option is present");
		       
	           util.pause(logger, "2");
	           util.waitTillElementIsClickable(logger, driver, homepage.Reset_btn);
	           util.clickOn(logger, homepage.Reset_btn);
	           logger.log(LogStatus.INFO, "After clicking on Reset Button, Search category got Reset successfully");
		       System.out.println("After clicking on Reset Button, Search category got Reset successfully");
    
		}
		
		 catch(Exception e)
	       {
	               util.screenShotAndErrorMsg(logger, e, driver, "SearchApplicationRepository");
	       }
	       extent.endTest(logger);
	       extent.flush();
		
	}
	
	@Test
	public void ApproveApplication(){
		ExtentTest logger = extent.startTest("Approve", "Approve");
		try
		{
			
			sspage = PageFactory.initElements(driver, SelfServicePage.class);
			homepage = PageFactory.initElements(driver, HomePage.class);
			/*util.pause(logger, "40");
			util.waitTillElementIsClickable(logger, driver, homepage.MyStuff_link);
			util.clickByJavascriptExecutor(logger, driver, homepage.MyStuff_link);
			util.waitTillElementIsVisible(logger, driver, homepage.Approvals_link);
			util.clickByJavascriptExecutor(logger, driver, homepage.Approvals_link);
			util.pause(logger, "10");
			*/
			
			driver.navigate().to(inputData.get("MyApprovalPage").get("URL").toString());
			util.pause(logger, "40");
			
			frameHelper.switchToDefaultFrame(logger, driver);
			/*util.waitTillElementIsClickable(logger, driver, sspage.View);
			util.clickOn(logger, sspage.View);*/
			
			util.waittillpageload(logger, driver);
			util.pause(logger, "5");
			
			util.waitTillElementIsClickable(logger, driver, driver.findElement(By.xpath(".//*[contains(text(),'"+requestID+"')]/../../parent::div/div/div/button[text()='Approve']")));
			//util.pause(logger, "5");
			util.clickByJavascriptExecutor(logger, driver, driver.findElement(By.xpath(".//*[contains(text(),'"+requestID+"')]/../../parent::div/div/div/button[text()='Approve']")));
			
			//util.clickOn(logger, sspage.Approver1lnk);
			util.pause(logger, "5");
			str = inputData.get("Comments").get("keywords").toString();
			util.setTextWithEnter(logger, sspage.Comments, str);
			util.clickOn(logger, sspage.Approve_Submitbtn);
			util.pause(logger, "5");
			
		}
		
		catch(Exception e)
	       {
	               util.screenShotAndErrorMsg(logger, e, driver, "ApproveApplication");
	       }
	       extent.endTest(logger);
	       extent.flush();
		
	}
	
	
	@Test
    //Login Method
    public void Adminlogin()
    {
           ExtentTest logger = extent.startTest("Adminlogin", "Adminlogin");
           try
           {
           
        
           navigate(logger);
           sspage = PageFactory.initElements(driver, SelfServicePage.class);
           loginPage = PageFactory.initElements(driver, LoginPage.class);
           username=inputData.get("Admin").get("Username").toString();
           String pwd=inputData.get("Admin").get("Password").toString();
           System.out.println(username + "       "+pwd);
           
           loginPage.login(logger,username,pwd);
           
          driver.navigate().to(inputData.get("navigateCMDBlistpage").get("URL").toString());
          sspage = PageFactory.initElements(driver, SelfServicePage.class);
          
          util.waittillpageload(logger, driver);
          util.pause(logger, "5");
          
          frameHelper.switchToDefaultFrame(logger, driver);
          
          util.pause(logger, "5");
          
          str = inputData.get("ApplNameText").get("keywords").toString();
          util.clickOn(logger, sspage.AppnNameSearchTextBox);
        
          System.out.println("Clicked on field successfully");
    
          util.setTextWithEnter(logger, sspage.AppnNameSearchTextBox, str);
     
          util.pause(logger, "5");
          
          util.verifyElementByXpath(logger, sspage.RegistrationStatus);
          System.out.println("Registration Status Displayed as: Registration In Progress ");
          logger.log(LogStatus.INFO, "Registration Status displaying properly");
          util.pause(logger, "10");
           }
           
           catch(Exception e)
           {
                   util.screenShotAndErrorMsg(logger, e, driver, "Adminlogin");
           }
           extent.endTest(logger);
           extent.flush();
             
    }
		
	@Test
    //Login Method
    public void Card_ListView_Verification()
    {
           ExtentTest logger = extent.startTest("Card_ListView_Verification", "Card_ListView_Verification");
           try
           {
          
           navigate(logger);
           sspage = PageFactory.initElements(driver, SelfServicePage.class);
           loginPage = PageFactory.initElements(driver, LoginPage.class);
           username=inputData.get("Requester").get("Username").toString();
           String pwd=inputData.get("Requester").get("Password").toString();
           System.out.println(username + "       "+pwd);
           
           loginPage.login(logger,username,pwd);      
           driver.navigate().to(inputData.get("navigateportal").get("URL").toString());
           sspage = PageFactory.initElements(driver, SelfServicePage.class);
           homepage = PageFactory.initElements(driver, HomePage.class);
           util.waittillpageload(logger, driver);
           util.pause(logger, "15");          
           frameHelper.switchToDefaultFrame(logger, driver);
           util.pause(logger, "30");
          
           util.verifyElementByXpath(logger, homepage.MyActivities);
           logger.log(LogStatus.INFO, "My Application header verified");          
           util.verifyElementByXpath(logger, homepage.Search_Reports);
           logger.log(LogStatus.INFO, "Search/Reports header verified");			
           util.verifyElementByXpath(logger, homepage.Surveys);
           logger.log(LogStatus.INFO, "Surveys header verified");
           util.verifyElementByXpath(logger, homepage.CardViewIcon);
           logger.log(LogStatus.INFO, "Card View is Defaulted");
           util.verifyElementByXpath(logger, homepage.ListViewIcon);
           logger.log(LogStatus.INFO, "List view icon right side of card view");
           util.clickOn(logger, homepage.ListViewIcon);
           util.pause(logger, "5");
           util.verifyElementByXpath(logger, homepage.ListApplicationID);
           logger.log(LogStatus.INFO, "Application Id verified");
           util.verifyElementByXpath(logger, homepage.List_ApplicationName);
           logger.log(LogStatus.INFO, "Application Name verified");
           util.verifyElementByXpath(logger, homepage.List_RegistrationStatus);
           logger.log(LogStatus.INFO, "Registration Status verified");
           util.verifyElementByXpath(logger, homepage.List_ApplicationStatus);
           logger.log(LogStatus.INFO, "Application Status verified");
           util.verifyElementByXpath(logger, homepage.List_Description);
           logger.log(LogStatus.INFO, "Description verified");
           util.verifyElementByXpath(logger, homepage.List_ServiceTier);
           logger.log(LogStatus.INFO, "ServiceTier verified");
           
           util.verifyElementByXpath(logger, homepage.List_ServiceOpLead);
           logger.log(LogStatus.INFO, "Service Operations Lead verified");
           
           util.verifyElementByXpath(logger, homepage.List_ServiceOpManager);
           logger.log(LogStatus.INFO, "Service Operations Manager verified");
           
           util.verifyElementByXpath(logger, homepage.List_ProjectLead);
           logger.log(LogStatus.INFO, "Project Lead verified");
           
           util.verifyElementByXpath(logger, homepage.List_ProjectManager);
           logger.log(LogStatus.INFO, "Project Manager verified");
           
           util.verifyElementByXpath(logger, homepage.List_ComponentType);
           logger.log(LogStatus.INFO, "Component Type verified");
           
           util.verifyElementByXpath(logger, homepage.List_Organization);
           logger.log(LogStatus.INFO, "Organization verified");
           
           util.verifyElementByXpath(logger, homepage.List_ReportingEntity);
           logger.log(LogStatus.INFO, "Reporting Entity verified");
           
           util.verifyElementByXpath(logger, homepage.List_VerifiedBy);
           logger.log(LogStatus.INFO, "Verified By verified");
           
           util.verifyElementByXpath(logger, homepage.List_VerifiedOn);
           logger.log(LogStatus.INFO, "Verified On verified");
         
           util.clickOn(logger, homepage.CardViewIcon);
           util.pause(logger, "2");
           
           List<WebElement> list = driver.findElements(By.xpath("//div[@class='grid-item item-category']"));
           
           if(list.size()<=8){
        	  
        	   System.out.println("The Total number of Cards are less than or equal to 8");
        	   logger.log(LogStatus.PASS, "The Total number of Cards are less than or equal to 8");
           }
           
           else{
        	   
        	   System.out.println("Total Number of cards are more than 8: "+list.size());
        	   logger.log(LogStatus.FAIL, "Total Number of cards are more than 8: "+list.size());
           }
           
           util.clickOn(logger, homepage.ViewAllLink);
           util.pause(logger, "5");
           
           list = driver.findElements(By.xpath("//div[@class='grid-item item-category']"));
           
           if(list.size()>8){
        	  
        	   System.out.println("The Total number of Cards are greater than 8"); 
        	   logger.log(LogStatus.PASS, "The Total number of Cards are greater than 8");
           }
           
           else{
        	   
        	   System.out.println("Total Number cards are: "+list.size());
        	   logger.log(LogStatus.FAIL, "Total Number cards are: "+list.size());
           }
           
           /*List<WebElement> list1= driver.findElements(By.xpath(".//th[@class='ng-binding ng-scope']"));
           System.out.println(list1.size());			
			for (int m=0; m<list1.size(); m++){
				String SearchResult = list1.get(m).getText();				
    			System.out.println(SearchResult);
    			logger.log(LogStatus.INFO, "View List Columns displayed");
    			}*/
           
          util.pause(logger, "5");
          util.clickOn(logger, homepage.ListViewIcon);
          util.waittillpageload(logger, driver);
          util.pause(logger, "5");
          util.clickOn(logger, homepage.List_ApplicationID_link);
          util.waittillpageload(logger, driver);
          util.pause(logger, "5");
          logger.log(LogStatus.INFO, "Application View displayed successfully");
          System.out.println("Application View displayed successfully");
           }
           
           catch(Exception e)
           {
                   util.screenShotAndErrorMsg(logger, e, driver, "Card_ListView_Verification");
           }
           extent.endTest(logger);
           extent.flush();
             
    }
	
	@Test
	public void VerifyStatus(){
		
		 ExtentTest logger = extent.startTest("VerifyStatus", "VerifyStatus");
		
		try{
			
						driver=browserHelper.driversList.get(0);
						
						String reqwindow=browserHelper.driversList.get(0).getWindowHandle().toString();
						System.out.println("Status Verify - reqwindow id is "+reqwindow);
				        driver.switchTo().window(reqwindow);
				        driver.navigate().refresh(); 
				        sspage = PageFactory.initElements(driver, SelfServicePage.class);
				        homepage = PageFactory.initElements(driver, HomePage.class);
				        
				        //frameHelper.switchToFrame(logger, driver, homepage.Frame);
				        util.pause(logger, "15");
				        status=sspage.txt_status.getAttribute("value");
				        state=sspage.txt_state.getAttribute("value");
				        stage=sspage.txt_stage.getAttribute("value");
			            System.out.println("The Status of Ticket is: " + status);
			            logger.log(LogStatus.INFO, "RequestNumber: "+ requestID+"------Status: "+status +"The Ticket State is: " +state+"The Ticket Stage is: "+stage);
			            
		}
		
		catch(Exception e)
        {
                util.screenShotAndErrorMsg(logger, e, driver, "VerifyStatus()");
        }
        extent.endTest(logger);
        extent.flush();
	}
	
	@Test
	public void NonAdminLogin(){
		
		ExtentTest logger = extent.startTest("NonAdminLogin", "NonAdminLogin");
		
		try{
			
			   navigate(logger);
	           sspage = PageFactory.initElements(driver, SelfServicePage.class);
	           loginPage = PageFactory.initElements(driver, LoginPage.class);
	           username=inputData.get("NonAdmin").get("Username").toString();
	           String pwd=inputData.get("NonAdmin").get("Password").toString();
	           System.out.println(username + "       "+pwd);
	           
	           loginPage.login(logger,username,pwd);      
	           driver.navigate().to(inputData.get("navigateportal").get("URL").toString());
	           sspage = PageFactory.initElements(driver, SelfServicePage.class);
	           homepage = PageFactory.initElements(driver, HomePage.class);
	           util.waittillpageload(logger, driver);
	           util.pause(logger, "50");	           
	           util.verifyElementByXpath(logger, homepage.RegAnAppl);
	           logger.log(LogStatus.INFO, "Register An Application link verified");
	           
	           util.verifyElementByXpath(logger, homepage.SearchApplRepository);
	           logger.log(LogStatus.INFO, "Search Application Repository Text field verified");
	           util.pause(logger, "5");
	           util.verifyElementByXpath(logger, homepage.NonAdminCard);
	           logger.log(LogStatus.INFO, "There are no Cards exists in this login");
	           
	           List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='grid-item item-category']"));
	           if(list1.size()>=1){
	         	  
	        	   System.out.println("There are Cards exists for this user"); 
	        	   logger.log(LogStatus.FAIL, "There are Cards exists for this user");
	           }
	           
	           else{
	        	   
	        	   System.out.println("Total Number of cards are: "+list1.size());
	        	   logger.log(LogStatus.PASS, "Total Number of cards are: "+list1.size());
	           }
	           
	           
	         }
	
		catch(Exception e)
        {
                util.screenShotAndErrorMsg(logger, e, driver, "NonAdminLogin");
        }
        extent.endTest(logger);
        extent.flush();	
	}

	//Register
	@Test
	public void Register(){
		
		ExtentTest logger = extent.startTest("Register", "Register");
		try
		{
			   /*navigate(logger);
	           loginPage = PageFactory.initElements(driver, LoginPage.class);
	           username=inputData.get("Requester").get("Username").toString();
	           String pwd=inputData.get("Requester").get("Password").toString();
	           System.out.println(username + "       "+pwd);
	           loginPage.login(logger,username,pwd);
	           driver.navigate().to(inputData.get("navigateportal").get("URL").toString());*/
			   //login();
	           //util.pause(logger, "10");
			
	           /*

			util.waitTillElementIsClickable(logger, driver, homepage.ApplCard);
			
			if(homepage.ViewAllLink.isDisplayed()==true){
				util.clickOn(logger, homepage.ViewAllLink);
				util.pause(logger, "5");
			
			util.waittillpageload(logger, homepage.ApplCard);
			util.clickOn(logger, driver.findElement(By.xpath(".//div[@class='tile-title ApplicationNames']/b[contains(text(),'"+AppName+"')]/../parent::div//div[@class='tile-title highlight']/b[contains(text(),'Registration In Progress')]")));
			System.out.println("Clicked on Registration In Progress status Card");*/
			
			driver=browserHelper.driversList.get(0);
			
			String reqwindow=browserHelper.driversList.get(0).getWindowHandle().toString();
			System.out.println("Status Verify - reqwindow id is "+reqwindow);
	        driver.switchTo().window(reqwindow);
			
	       driver.navigate().to(inputData.get("navigateportal").get("URL").toString());
	       util.pause(logger, "15");
	     
	        sspage = PageFactory.initElements(driver, SelfServicePage.class);
	        homepage = PageFactory.initElements(driver, HomePage.class);
	 
		//util.waitTillElementIsClickable(logger, driver, homepage.ApplCard);
		
		if(homepage.ViewAllLink.isDisplayed()==true){
			util.clickOn(logger, homepage.ViewAllLink);
			util.pause(logger, "12");
		}
		
		util.clickOn(logger, driver.findElement(By.xpath("(.//div[@class='tile-title ApplicationNames']/b[contains(text(),'"+AppName+"')])[1]")));
		System.out.println("Specific application page is displayed");
		util.waittillpageload(logger, driver);
		util.pause(logger, "5");
			
				sspage = PageFactory.initElements(driver, SelfServicePage.class);
		       homepage = PageFactory.initElements(driver, HomePage.class);
		       RegPage = PageFactory.initElements(driver, RegisterPage.class);
		       
			util.waittillpageload(logger, driver);
			util.pause(logger, "10");
			
			//Verifying Edit button is not available when Registration Status = Registration In Progress
			
			if(driver.findElements(By.xpath(".//button[@ng-show='ShowEditButton']")).size()==0)
			{
				logger.log(LogStatus.PASS, "Edit button is not Displaying in Application Detail view page ");
			}
			
			else
			{
     			logger.log(LogStatus.FAIL, "Edit button is Displaying in Application Detail view page ");	
     		}
			
			/*if(homepage.Edit_button.isDisplayed()== false){
     			logger.log(LogStatus.PASS, "Edit button is not Displaying when Registration Status = Registration In Progress");	
     		}
     		
     		else{
     			logger.log(LogStatus.FAIL, "Edit button is Displaying when Registration Status = Registration In Progress");	
     		}*/
			
			//Verifying Retire button is not available when Registration Status = Registration In Progress
			
			
			
			if(driver.findElements(By.xpath(".//button[@ng-show='enablePopup'][@class='btn btn-primary ok-btn']")).size()==0)
			{
				logger.log(LogStatus.PASS, "Retire button is not Displaying when Registration Status = Registration In Progress ");
			}
			
			else
			{
     			logger.log(LogStatus.FAIL, "Retire button is Displaying when Registration Status = Registration In Progress ");	
     		}
			
			/*if(homepage.Retire_btn.isDisplayed()== false)
			{
     			logger.log(LogStatus.PASS, "Retire button is not Displaying when Registration Status = Registration In Progress");	
     		}
     		
     		else{
     			logger.log(LogStatus.FAIL, "Retire button is Displaying when Registration Status = Registration In Progress");	
     		}
			*/
			//Verifying Verify button is not available when Registration Status = Registration In Progress 
			
			if(driver.findElements(By.xpath(".//button[contains(text(),'Verify')][@aria-hidden='true']")).size()!=0)
			{
				logger.log(LogStatus.PASS, "Verify button is not Displaying when Registration Status = Registration In Progress ");
			}
			
			else
			{
     			logger.log(LogStatus.FAIL, "Verify button is Displaying when Registration Status = Registration In Progress ");	
     		}
     		
			
			//Verifying Pencil button is available before Register (Registration Status = Registration Inprogress)
			System.out.println("Verifying Pencil button before Registration");	
			
			VerifyPencilbtn_RegistrationInprogress();
			
			//Verifying Register button is available when Registration Status = Registration In Progress
			
			if(homepage.Registerbtn.isDisplayed()== true)
			{
				logger.log(LogStatus.PASS, "Register button Displayed only when Status = 'Registration In-Progress'");
				util.clickOn(logger, homepage.Registerbtn);
				//util.pause(logger, "2");
				
				
				/*str = RegPage.Techno_Popup_msg.getAttribute("innerText");
				
				logger.log(LogStatus.INFO, "The Pop up message displaying after clicking on Register button is: " +str);
				
				System.out.println(str);
				
				if(str.contains("Please add data in the technology section and then click on register."))
			
				{					
					logger.log(LogStatus.PASS, "Popup Dailog message matched successfully");
					util.pause(logger, "2");
					util.clickOn(logger, RegPage.Techno_Popup_msg_Close_btn);
					util.pause(logger, "2");
					util.clickOn(logger, RegPage.Plus_icon);
					util.pause(logger, "5");
					util.waittillpageload(logger, driver);
					frameHelper.switchToChildWindow(logger, driver, frameHelper.getParentWindowHandle(logger, driver));
					frameHelper.switchToFrame(logger, driver, RegPage.Techno_frame);
					util.pause(logger, "5");
					
					str = inputData.get("Reg_Provisioning").get("keywords").toString();
					util.selectBoxByValue(logger, RegPage.Reg_Provisioning, str);
					
					str = inputData.get("Type").get("keywords").toString();
					util.selectBoxByValue(logger, RegPage.Type, str);
					
					str = inputData.get("Reg_Supplier").get("keywords").toString();
					util.setTextWithEnter(logger, RegPage.Supplier, str);
					
					str = inputData.get("Product").get("keywords").toString();
					util.setTextWithEnter(logger, RegPage.Product, str);
					
					str = inputData.get("Additional_Details").get("keywords").toString();
					util.setTextWithEnter(logger, RegPage.Additional_Details, str);
					util.pause(logger, "5");
					util.clickOn(logger, RegPage.Submitbtn);
					util.pause(logger, "5");
					//util.clickByJavascriptExecutor(logger, driver, RegPage.Techno_Close_btn);
					
					
					frameHelper.switchToParentWindowHandle(logger, driver, "");
					frameHelper.switchToDefaultFrame(logger, driver);
					util.clickOn(logger, RegPage.Techno_Close_btn);
					
					//frameHelper.switchToFrame(logger, driver, homepage.Frame);
					
				}
				else
				{
					logger.log(LogStatus.FAIL, "Popup Dailog message not matched successfully");
				}*/
				
				//driver.navigate().refresh();
				//util.pause(logger, "30");
				//util.clickOn(logger, homepage.Registerbtn);
				util.waittillpageload(logger, driver);
				util.pause(logger, "20");
				str = inputData.get("Company").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Company, str);
				
				//This field is not available during Register in CMDB Q3 Release
				/*str = inputData.get("OperationalStatus").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.OperationalStatus, str);*/
				
				/*str = inputData.get("MaintenanceSchedule").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.MaintenanceSchedule, str);*/
				
				//Assignment group field removed from Register form 				
				/*str = inputData.get("Assignmentgroup").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Assignmentgroup, str);*/
				
				util.clickOn(logger, RegPage.SN_Assignmentgroup_Icon);
				util.pause(logger, "5");
								
				str = inputData.get("SN_Assignmentgroup").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.SN_Assignmentgroup, str);
				util.pause(logger, "3");
				
				str = inputData.get("Acronym").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Acronym, str);
				
				str = inputData.get("ReportingEntity").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.ReportingEntity, str);
				
				str = inputData.get("First_go_live_date").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.First_go_live_date, str);
				
				/*util.clickOn(logger, RegPage.AIMServiceOpsIDLookSearch);
				System.out.println("Clicked on Lookup");
				util.clickByJavascriptExecutor(logger, driver, RegPage.AIMServiceOpsIDLookSearch);
				frameHelper.switchToChildWindow(logger, driver, frameHelper.getParentWindowHandle(logger, driver));
				str = inputData.get("AIMServiceOpsID").get("keywords").toString();
				str = str.replaceAll("k", "");
				util.setTextWithEnter(logger, RegPage.AIMServiceOpsIDinput, str);
				util.pause(logger, "5");
				util.clickOn(logger, RegPage.SelectAIMServiceOpsID);
				util.pause(logger, "10");
				frameHelper.switchToParentWindowHandle(logger, driver, "");
				frameHelper.switchToDefaultFrame(logger, driver);*/
			
				//frameHelper.switchToFrame(logger, driver, homepage.Frame);
				
				//The below commented fields are not exists during Register in CMDB Q3 Release
			/*	str = inputData.get("ServiceOpsMD").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.ServiceOpsMD, str);
				
				str = inputData.get("ServiceOpsManager").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.ServiceOpsManager, str);
				
				str = inputData.get("ServiceOpsPortfolio").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.ServiceOpsPortfolio, str);
				
				str = inputData.get("ServiceOpsLead").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.ServiceOpsLead, str);*/
				
				//Program Portfolio field is defaulted value and non editable
				/*str = inputData.get("ProgramPortfolio").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.ProgramPortfolio, str);*/

				str = inputData.get("Operational_supp_email").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Operational_supp_email, str);
				
				str = inputData.get("SpecialContactInstruction").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.SpecialContactInstruction, str);
				
				str = inputData.get("WorkNumber").get("keywords").toString();
				str = str.replaceAll("k", "");
				util.setTextWithEnter(logger, RegPage.WorkNumber, str);
				
				str = inputData.get("OverallCapababilityMD").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.OverallCapababilityMD, str);
				
				str = inputData.get("TechArchLead").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.TechArchLead, str);
				
				str = inputData.get("DBDelManager").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.DBDelManager, str);
				
				str = inputData.get("SecDeploymentMgr").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.SecDeploymentMgr, str);
				
				str = inputData.get("SOHManagementAppl").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.SOHManagementAppl, str);
								
				str = inputData.get("P1Contact").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.P1Contact, str);
				
				str = inputData.get("P2Contact").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.P2Contact, str);
				
				str = inputData.get("PrimaryEmergencyContactName").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.PrimaryEmergencyContactName, str);
				
				str = inputData.get("PrimaryContactNum").get("keywords").toString();
				str = str.replaceAll("k", "");
				util.setTextWithEnter(logger, RegPage.PrimaryContactNum, str);
				
				str = inputData.get("PrimaryWorkNum").get("keywords").toString();
				str = str.replaceAll("k", "");
				util.setTextWithEnter(logger, RegPage.PrimaryWorkNum, str);
				
				//below field removed from Register form
				/*str = inputData.get("NextplanDisasteRecoTest").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.NextplanDisasteRecoTest, str);*/
				
				str = inputData.get("Chat_SkypeID").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Chat_SkypeID, str);
				
				str = inputData.get("Sec_emer_Cont_Name").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Sec_emer_Cont_Name, str);
				
				str = inputData.get("Sec_Cont_Number").get("keywords").toString();
				str = str.replaceAll("k", "");
				util.setTextWithEnter(logger, RegPage.Sec_Cont_Number, str);
				
				str = inputData.get("Sec_Work_Number").get("keywords").toString();
				str = str.replaceAll("k", "");
				util.setTextWithEnter(logger, RegPage.Sec_Work_Number, str);
				
				str = inputData.get("Tertiary_Emer_Cont_Name").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Tertiary_Emer_Cont_Name, str);
				
				str = inputData.get("Tertiary_Cont_Number").get("keywords").toString();
				str = str.replaceAll("k", "");
				util.setTextWithEnter(logger, RegPage.Tertiary_Cont_Number, str);
				
				str = inputData.get("EnvironmentDelMgr").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.EnvironmentDelMgr, str);
				
				str = inputData.get("DevLead").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.DevLead, str);
				
				str = inputData.get("PrimaryDeplyManager").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.PrimaryDeplyManager, str);
				
				//Below field removed from Register form
				/*str = inputData.get("Last_DisasterReco_Test").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Last_DisasterReco_Test, str);*/
				
				str = inputData.get("Internal_Oper_Supp_URL").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Internal_Oper_Supp_URL, str);
				
				str = inputData.get("ApplWebEnabled").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.ApplWebEnabled, str);
				
				str = inputData.get("Appldownloaded").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.Appldownloaded, str);
				
				str = inputData.get("MobCapability").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.MobCapability, str);
				
				//Type field is not exists during Register in CMDB Q3 Release
				str = inputData.get("Reg_Provisioning").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.Reg_Provisioning, str);
				
				str = inputData.get("Reg_Type").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.Reg_Type, str);
				
				str = inputData.get("Reg_Supplier").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Reg_Supplier, str);
				
				str = inputData.get("Reg_Product").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Reg_Product, str);
				
				str = inputData.get("Reg_Additional_Details").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Reg_Additional_Details, str);
				
				util.pause(logger, "2");
				util.clickOn(logger, RegPage.Reg_UserInterface_Icon);
				util.pause(logger, "5");
								
				str = inputData.get("Reg_UserInterface").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Reg_UserInterface, str);
				util.pause(logger, "3");
				
				//Product field in Technology section to be deleted in Q3, during Register
				/*str = inputData.get("Product").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Product, str);*/
				
				/*str = inputData.get("Technology_Location").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.Technology_Location, str);*/
				
				//Additional details field is not exists during Register in CMDB Q3
				/*str = inputData.get("Additional_Details").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Additional_Details, str);		*/		
				
				/*str = inputData.get("ApplWebEnabled").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.ApplWebEnabled, str);*/
				
				str = inputData.get("AFSEemployees").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.AFSEemployees, str);
				
				str = inputData.get("WhoCanSeeData").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.WhoCanSeeData, str);
				
				str = inputData.get("SysContainSenData").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.SysContainSenData, str);
				
				str = inputData.get("WhoUsesSys").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.WhoUsesSys, str);
				
				str = inputData.get("PAM_Managed_temp_Admin").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.PAM_Managed_temp_Admin, str);
				
				str = inputData.get("PAM_ManagedapplID").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.PAM_ManagedapplID, str);
				
				str = inputData.get("CountryProdSys").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.CountryProdSys, str);
				
				//Air Legal field is removed
				/*str = inputData.get("AIRLegalTab").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.AIRLegalTab, str);*/
				
				str = inputData.get("PAM_ManagedapplFighter").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.PAM_ManagedapplFighter, str);
				
				str = inputData.get("PAM_ManagedapplBuiltin").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.PAM_ManagedapplBuiltin, str);
				
				str = inputData.get("IdentifyDataRelevant").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.IdentifyDataRelevant, str);
				
				str = inputData.get("PreserveData").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.PreserveData, str);
				
				str = inputData.get("Archiving").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.Archiving, str);
				
				str = inputData.get("Multi_factor").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.Multi_factor, str);
				
				str = inputData.get("Sarbox").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.Sarbox, str);
				
				str = inputData.get("ClientOwnedData").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.ClientOwnedData, str);
				
				str = inputData.get("ContractualRights").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.ContractualRights, str);
				
				str = inputData.get("PrimaryCommContact").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.PrimaryCommContact, str);
				
				str = inputData.get("EndUserSuppURL").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.EndUserSuppURL, str);
				
				str = inputData.get("AppNotifTool").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.AppNotifTool, str);
				
				str = inputData.get("PrimaryCommuCont_CIO").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.PrimaryCommuCont_CIO, str);
				
				str = inputData.get("PrimaryCommuCont_busi").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.PrimaryCommuCont_busi, str);
				
				util.pause(logger, "2");
				util.clickOn(logger, RegPage.Reg_PrimaryUserGroups_Icon);
				util.pause(logger, "5");
				
				str = inputData.get("Reg_PrimaryUserGroups").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Reg_PrimaryUserGroups, str);
				util.pause(logger, "3");
				
				str = inputData.get("Reg_FishingPage").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.Reg_FishingPage, str);
				
				str = homepage.ApplicationStatus_InProd.getAttribute("value");
				if(str.equalsIgnoreCase("In Production"))
				{
					
					str = inputData.get("AIMProgID").get("keywords").toString();
					str = str.replaceAll("k", "");
					util.setTextWithEnter(logger, RegPage.Reg_AIMProgID_Input, str);
					/*util.clickOn(logger, homepage.AIMProgIDSearchLookUp);
					System.out.println("Clicked on Lookup");
					
					util.clickByJavascriptExecutor(logger, driver, homepage.AIMProgIDSearchLookUp);
					frameHelper.switchToChildWindow(logger, driver, frameHelper.getParentWindowHandle(logger, driver));
					
					str = inputData.get("AIMProgID").get("keywords").toString();
					str = str.replaceAll("k", "");
					util.setTextWithEnter(logger, homepage.AIMProgIDinput, str);
					util.pause(logger, "5");
					util.clickOn(logger, homepage.SelectAIMProgID);
					
					frameHelper.switchToParentWindowHandle(logger, driver, "");
					frameHelper.switchToDefaultFrame(logger, driver);
					
					frameHelper.switchToFrame(logger, driver, homepage.Frame);*/
					util.pause(logger, "3");
					str = inputData.get("ProgramManager").get("keywords").toString();
					util.setTextWithEnter(logger, RegPage.Reg_Program_Mgr, str);
					
				}
				
			/*	Select sel2 = new Select(RegPage.Available);
	     		List<WebElement> list2 = sel2.getOptions();
	     		
	     		for(int j=0; j<list2.size(); j++){
	     			System.out.println(list2.get(j).getText());
	     			if(list2.get(j).getText().equalsIgnoreCase("All Accenture Employees")){
	     				list2.get(j).click();
	     				break;
	     			}}
	     		util.pause(logger, "5");
	     		util.waitTillElementIsClickable(logger, driver, RegPage.RightArrowbtn);
	     		util.clickOn(logger, RegPage.RightArrowbtn);*/
				
	     		util.pause(logger, "5");
	     		util.clickOn(logger, RegPage.Submitbtn);
	     		util.pause(logger, "10");
	     		
	     		if(driver.findElements(By.xpath(".//button[@class='btn btn-primary ok-btn'][contains(text(),'Register')]")).size()==0){
	     			logger.log(LogStatus.PASS, "Register button is not Displaying when Registration Status = Registration Completed");	
	     		}
	     		
	     		else
	     		{
	     			logger.log(LogStatus.FAIL, "Register button is Displaying when Registration Status = Registration Completed");	
	     		}

			}
			
			else{
				logger.log(LogStatus.FAIL, "Register button Displayed when Status other than 'Registration  In-Progress'");
			}
			
			
			//frameHelper.switchToFrame(logger, driver, homepage.Frame);

		}

		catch(Exception e)
        {
                util.screenShotAndErrorMsg(logger, e, driver, "Register");
        }
        extent.endTest(logger);
        extent.flush();		  
	}
	
	@Test
	public void EditApplication(){
		
		ExtentTest logger = extent.startTest("EditApplication", "EditApplication");
		
		try
		{
				//navigate(logger);
			
	           /*loginPage = PageFactory.initElements(driver, LoginPage.class);
	           username=inputData.get("Requester").get("Username").toString();
	           String pwd=inputData.get("Requester").get("Password").toString();
	           System.out.println(username + "       "+pwd);
	           
	           loginPage.login(logger,username,pwd);
	           
	           driver.navigate().to(inputData.get("navigateportal").get("URL").toString());
	           util.pause(logger, "10");*/
			//login();
	           sspage = PageFactory.initElements(driver, SelfServicePage.class);
		       homepage = PageFactory.initElements(driver, HomePage.class);
		       RegPage = PageFactory.initElements(driver, RegisterPage.class);

			/*util.waitTillElementIsClickable(logger, driver, homepage.ApplCard);
			
			if(homepage.ViewAllLink.isDisplayed()==true){
				util.clickOn(logger, homepage.ViewAllLink);
				util.pause(logger, "5");
			}
			
			util.clickOn(logger, driver.findElement(By.xpath(".//div[@class='tile-title ApplicationNames']/b[contains(text(),'"+AppName+"')]/../parent::div//div[@class='tile-title highlight']/b[contains(text(),'Registration Completed')]")));
			
			//util.clickOn(logger, homepage.RegisterationCompleted_CardStatus);
			System.out.println("Clicked on Registeration Completed Status Card");*/
			util.waittillpageload(logger, driver);
			util.pause(logger, "5");
			util.waitTillElementIsVisible(logger, driver, homepage.Edit_button);
			util.clickOn(logger, homepage.Edit_button);
			System.out.println("Clicked on Edit Button");
			util.waittillpageload(logger, driver);
			util.pause(logger, "30");
			
			/*Select sel2 = new Select(RegPage.Available);
			
     		List<WebElement> list2 = sel2.getOptions();
     		for(int j=0; j<list2.size(); j++){
     			System.out.println(list2.get(j).getText());
     			if(list2.get(j).getText().equalsIgnoreCase("Internal IT (CIO, ISA)")){
     				list2.get(j).click();
     				break;
     			}}
     		util.pause(logger, "5");
     		util.waitTillElementIsClickable(logger, driver, RegPage.RightArrowbtn);
     		util.clickOn(logger, RegPage.RightArrowbtn);
     		util.pause(logger, "5");*/
			
			util.clickOn(logger, RegPage.Reg_PrimaryUserGroups_Icon);
			util.pause(logger, "5");
			
			str = inputData.get("Edit_PrimaryUserGroups").get("keywords").toString();
			util.setTextWithEnter(logger, RegPage.Reg_PrimaryUserGroups, str);
			util.pause(logger, "2");
     		
     		str = inputData.get("AIRLegalTab").get("keywords").toString();
			util.selectBoxByValue(logger, homepage.AIRLegalTab_Edit, str);
     		
     		util.clickOn(logger, RegPage.Submitbtn);
     		util.waittillpageload(logger, driver);
     		util.pause(logger, "10");
     		
     		//RetireApplication();
     		
		}	

		catch(Exception e)
        {
                util.screenShotAndErrorMsg(logger, e, driver, "EditApplication");
        }
        extent.endTest(logger);
        extent.flush();		  
	}
	
		@Test
		public void RetireApplication(){
			
			ExtentTest logger = extent.startTest("RetireApplication", "RetireApplication");
			
			try
			{
				   util.pause(logger, "5");
				   sspage = PageFactory.initElements(driver, SelfServicePage.class);
			       homepage = PageFactory.initElements(driver, HomePage.class);
			       RegPage = PageFactory.initElements(driver, RegisterPage.class);
			       Retirepage = PageFactory.initElements(driver, RetirePage.class);
/*
				util.waitTillElementIsClickable(logger, driver, homepage.ApplCard);
				
				if(homepage.ViewAllLink.isDisplayed()==true){
					util.clickOn(logger, homepage.ViewAllLink);
					util.pause(logger, "5");
				}
				
				
				util.clickOn(logger, driver.findElement(By.xpath(".//div[@class='tile-title ApplicationNames']/b[contains(text(),'"+AppName+"')]/../parent::div//div[@class='tile-title highlight']/b[contains(text(),'Registration Completed')]")));
				//util.clickOn(logger, homepage.RegisterationCompleted_CardStatus);
				System.out.println("Clicked on Registeration Completed Status Card");*/
			     //Syso
			    
				util.waittillpageload(logger, driver);
				util.pause(logger, "5");
				util.waitTillElementIsVisible(logger, driver, homepage.Retire_btn);
				util.clickOn(logger, homepage.Retire_btn);
				System.out.println("Clicked on Retire Button");
				util.waittillpageload(logger, driver);
				util.pause(logger, "15");
				/*util.waitTillElementIsVisible(logger, driver, Retirepage.No_btn);
				util.waitTillElementIsVisible(logger, driver, homepage.Retire_btn);
				util.clickOn(logger, homepage.Retire_btn);*/
				
				str = homepage.RetirePopUpMsg.getAttribute("innerText");
				
				logger.log(LogStatus.INFO, "The Pop up message displaying after clicking on Retire button is: " +str);
				
				System.out.println(str);
				
				if(str.contains("Decommissioning process will automatically be triggered, are you sure you want to continue?"))
			
				{
					logger.log(LogStatus.PASS, "Popup Dailog message matched successfully");
					
				}
				else
				{
					logger.log(LogStatus.FAIL, "Popup Dailog message not matched successfully");
				}
				
				util.waitTillElementIsVisible(logger, driver, Retirepage.No_btn);
				util.clickOn(logger, Retirepage.No_btn);
				logger.log(LogStatus.INFO, "The Popup dailog box closes after clicking on No button");
				util.pause(logger, "2");
				util.waitTillElementIsVisible(logger, driver, homepage.Retire_btn);
				util.clickOn(logger, homepage.Retire_btn);
				System.out.println("Clicked on Retire Button");
				
				util.waitTillElementIsVisible(logger, driver, Retirepage.Yes_btn);
				util.clickOn(logger, Retirepage.Yes_btn);
				util.pause(logger, "5");
				frameHelper.switchToDefaultFrame(logger, driver);
				frameHelper.switchToFrame(logger, driver, homepage.Frame);
				
				util.waittillpageload(logger, driver);
				util.pause(logger, "8");
				
				str = inputData.get("SAPCloseRelated").get("keywords").toString();
				util.selectBoxByValue(logger, Retirepage.SAPCloseRelated,str);
				
				util.pause(logger, "2");
				
				/*str = inputData.get("RequestCategory").get("keywords").toString();
				util.selectBoxByValue(logger, Retirepage.RequestCategory,str);*/
				
				str = inputData.get("TypeOfProject").get("keywords").toString();
				util.selectBoxByValue(logger, Retirepage.TypeOfProject,str);
				
				str = inputData.get("Environment").get("keywords").toString();
				util.selectBoxByValue(logger, Retirepage.Environment, str);
				
				/*str = inputData.get("RequestType").get("keywords").toString();
				util.selectBoxByValue(logger, Retirepage.RequestType,str);*/
			
				str = inputData.get("RequestActivityType").get("keywords").toString();
				util.selectBoxByValue(logger, Retirepage.RequestActivityType,str);
				
				util.pause(logger, "10");
				
				util.clickOn(logger, Retirepage.Production_Checkbox);
				util.clickOn(logger, Retirepage.Development_Checkbox);
				util.clickOn(logger, Retirepage.Performance_Checkbox);
				util.clickOn(logger, Retirepage.Sandbox_Checkbox);
				util.clickOn(logger, Retirepage.Staging_Checkbox);
				util.clickOn(logger, Retirepage.TechArch_Checkbox);
				util.clickOn(logger, Retirepage.Test_Checkbox);
				util.clickOn(logger, Retirepage.Training_Checkbox);
				
				str = inputData.get("RequestStartDate").get("keywords").toString();
				util.setTextWithEnter(logger, Retirepage.RequestStartDate, str);
				
				str = inputData.get("RequestEndDate").get("keywords").toString();
				util.setTextWithEnter(logger, Retirepage.RequestEndDate, str);
				
				str = inputData.get("WBSECollector").get("keywords").toString();
				util.setTextWithEnter(logger, Retirepage.WBSECollector, str);
				
				str = inputData.get("RequestPriority").get("keywords").toString();
				util.selectBoxByValue(logger, Retirepage.RequestPriority,str);

				/*str = inputData.get("ShortDesc").get("keywords").toString();
				util.setTextWithEnter(logger, Retirepage.ShortDesc, str);*/
				
				str = inputData.get("LongDesc").get("keywords").toString();
				util.setTextWithEnter(logger, Retirepage.LongDesc, str);
				
				util.pause(logger, "5");
				util.clickOn(logger, Retirepage.Submit_Retire_btn);
								
				util.waittillpageload(logger, driver);
				util.pause(logger, "5");
				
				verifyticketspage("CIOAppl_Oper_Requests");
				
                driver.navigate().to(inputData.get("navigateportal").get("URL").toString());
		        util.pause(logger, "20");
		        sspage = PageFactory.initElements(driver, SelfServicePage.class);
		        homepage = PageFactory.initElements(driver, HomePage.class);
		        

			//util.waitTillElementIsClickable(logger, driver, homepage.ApplCard);
			
			if(homepage.ViewAllLink.isDisplayed()==true){
				util.clickOn(logger, homepage.ViewAllLink);
				util.pause(logger, "5");
			}
			
			util.clickOn(logger, driver.findElement(By.xpath("(.//div[@class='tile-title ApplicationNames']/b[contains(text(),'"+AppName+"')])[1]")));
			System.out.println("Specific application page is displayed");
			util.waittillpageload(logger, driver);
			util.pause(logger, "20");
			
			//Verifying Application Status = To Be Sunset
			
			str = homepage.ApplStatus_Verification.getAttribute("innerText");
			System.out.println("The Application Status is: "+str);
			
	          if(str.equalsIgnoreCase("To Be Sunset"))
	          {
	        	  logger.log(LogStatus.PASS, "The Application Status = To Be Sunset");
	        		        	  
	        	}
	          else
	          {
	        	  logger.log(LogStatus.FAIL, "The Application Status is not equal to To Be Sunset"); 
	          }
	
			}
			
			catch(Exception e)
	        {
	                util.screenShotAndErrorMsg(logger, e, driver, "RetireApplication");
	        }
	        extent.endTest(logger);
	        extent.flush();		
		}
	
		@Test
		public void RunScheduledJob(String status_change){
			
			ExtentTest logger = extent.startTest("RunScheduledJob", "RunScheduledJob");
			
			try{
				
					navigate(logger);
		           sspage = PageFactory.initElements(driver, SelfServicePage.class);
		           loginPage = PageFactory.initElements(driver, LoginPage.class);
		           username=inputData.get("Admin").get("Username").toString();
		           String pwd=inputData.get("Admin").get("Password").toString();
		           System.out.println(username + "       "+pwd);
		           
		           loginPage.login(logger,username,pwd);
				
		           verpage = PageFactory.initElements(driver, VerifyPage.class);
				
	              util.waittillpageload(logger, driver);
	              util.pause(logger, "10");
	              util.waitTillElementIsClickable(logger, driver,verpage.FilterNavigator );
	              
	              util.setTextWithEnter(logger, verpage.FilterNavigator, "System Definition");
	              
	              util.waitTillElementIsVisible(logger, driver, verpage.ScheduledJobs);
	              
	              util.waitTillElementIsClickable(logger, driver, verpage.ScheduledJobs);
	              
	              util.clickOn(logger, verpage.ScheduledJobs);
	              
	              frameHelper.switchToFrame(logger, driver, verpage.Frame);
	            
	          util.waitTillElementIsClickable(logger, driver, verpage.ScheduledJob_NameInput);
	          
	          String jobName ="";
	          
	          if (status_change.equalsIgnoreCase("Verifybutton")){
	        	 
	        	  jobName = "cmdb_handleApplicationCIStatus";
	        	  
	        	  util.setTextWithEnter(logger, verpage.ScheduledJob_NameInput, jobName);
	       
	          }
	          
	          if (status_change.equalsIgnoreCase("Cancel")){
		        	 
	        	  jobName = "cmdb_reminderNotifications for Approval_1st&2nd-level";
	        	  
	        	  util.setTextWithEnter(logger, verpage.ScheduledJob_NameInput, jobName);
	       
	          }
        
	          util.waittillpageload(logger, driver);
	          util.pause(logger, "10");
	          
	          util.clickOn(logger, verpage.I_Searchresult_link);
	          util.waittillpageload(logger, driver);
	          util.pause(logger, "5");
	          str = verpage.Script_Name.getAttribute("value");
	          
	          if(str.equalsIgnoreCase(jobName)){
	         util.clickOn(logger, verpage.Execute_btn);
	        	 logger.log(LogStatus.PASS, "Scheduled Job Executed successfully");
	          }
			
			}
			
			catch(Exception e)
	        {
	                util.screenShotAndErrorMsg(logger, e, driver, "RunScheduledJob");
	        }
	        extent.endTest(logger);
	        extent.flush();

}
		
		
		@Test
		public void VerifyRequest(){
			
			ExtentTest logger = extent.startTest("VerifyRequest", "VerifyRequest");
			
			try{
				
				//Run the below Job to enable verify button after Registration Completed
				RunScheduledJob("Verifybutton");
				
				driver=browserHelper.driversList.get(0);
				
				String reqwindow=browserHelper.driversList.get(0).getWindowHandle().toString();
				System.out.println("Status Verify - reqwindow id is "+reqwindow);
		        driver.switchTo().window(reqwindow);
		        util.pause(logger, "80");
		        driver.navigate().refresh(); 
		        verpage = PageFactory.initElements(driver, VerifyPage.class);
		        
		        if(driver.findElements(By.xpath(".//button[contains(text(),'Verify')]")).size()==0){
	        	
	        	System.out.println("Waiting for 50 Secs");
	        	 util.pause(logger, "10");
			        driver.navigate().refresh();
			    }
		          
		          util.pause(logger, "20");
		          
		          str = homepage.VerificationStatus_Incomplete.getAttribute("innerText");
		          
		          if(str.equalsIgnoreCase("Verification Incomplete"))
		          	{		        	  
		        	  logger.log(LogStatus.PASS, "The Registration Status = Verification Incomplete");
		        	  
		        	}
		          else
		          {
		        	  logger.log(LogStatus.FAIL, "The Registration Status is not same as Verification Inomplete"); 
		          }
		          
		         /* util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Registration Status')]/../parent::div/span[contains(text(),'Verification Incomplete')]")));
		          System.out.println("The Registration Status = Verification Incomplete");*/
		         
		          util.pause(logger, "5");
		          		          		          
		        //verifying Verify button when the Registration Status = Verification Incomplete
		          
		        if(verpage.Verify_Button.isDisplayed()== true){
		        	
	     			logger.log(LogStatus.PASS, "Verify button is Displaying after Registration Status = Verification Inomplete");
	     			util.waitTillElementIsClickable(logger, driver, verpage.Verify_Button);
					util.clickByJavascriptExecutor(logger, driver, verpage.Verify_Button);
					util.waittillpageload(logger, driver);
					util.pause(logger, "10");
	     		}
	     		
	     		else{
	     			logger.log(LogStatus.FAIL, "Verify button is not Displaying");
	     		}
		        
		        //Codes are commented due to CMDB Q3 Release
				/*str = inputData.get("Ver_ApplicationStatus").get("keywords").toString();
				util.selectBoxByValue(logger, verpage.Ver_ApplicationStatus, str);
				
				//Operational Status field is removed in CMDB Q3 Release
				str = inputData.get("Ver_OperationalStatus").get("keywords").toString();
				util.selectBoxByValue(logger, verpage.Ver_OperationalStatus, str);*/
				
				//Application Type field is deleted
				
				/*Select sel1 = new Select(verpage.Ver_Appl_TypeAvailable);
				
	     		List<WebElement> list1 = sel1.getOptions();
	     		for(int j=0; j<list1.size(); j++){
	     			System.out.println(list1.get(j).getText());
	     			if(list1.get(j).getText().equalsIgnoreCase("Business)")){
	     				list1.get(j).click();
	     				break;
	     			}}
	     		util.pause(logger, "5");
	     		util.waitTillElementIsClickable(logger, driver, verpage.Ver_AppType_RightArrow_Appl);
	     		util.clickOn(logger, verpage.Ver_AppType_RightArrow_Appl);*/
				
	     		util.pause(logger, "5");
				
	     		//The below codes are commented due to CMDB Q3 Release
	     		/*str = inputData.get("Ver_Tech_Type").get("keywords").toString();
				util.selectBoxByValue(logger, verpage.Ver_Tech_Type, str);
		        
				str = inputData.get("Ver_Tech_Supplier").get("keywords").toString();
				util.selectBoxByValue(logger, verpage.Ver_Tech_Supplier, str);
				
				str = inputData.get("Ver_Provisioning").get("keywords").toString();
				util.selectBoxByValue(logger, verpage.Ver_Provisioning, str);

				str = inputData.get("Ver_Tech_Location").get("keywords").toString();
				util.selectBoxByValue(logger, verpage.Ver_Tech_Location, str);
				
				str = inputData.get("Ver_Legal_AirLegalTab").get("keywords").toString();
				util.selectBoxByValue(logger, verpage.Ver_Legal_AirLegalTab, str);
				
				str = inputData.get("Ver_IdentifyDataRelevant").get("keywords").toString();
				util.selectBoxByValue(logger, verpage.Ver_IdentifyDataRelevant, str);
				
				str = inputData.get("Ver_PreserveData").get("keywords").toString();
				util.selectBoxByValue(logger, verpage.Ver_PreserveData, str);
				
				str = inputData.get("Ver_Archiving").get("keywords").toString();
				util.selectBoxByValue(logger, verpage.Ver_Archiving, str);
				
				str = inputData.get("Ver_ClientOwnedData").get("keywords").toString();
				util.selectBoxByValue(logger, verpage.Ver_ClientOwnedData, str);
				
				str = inputData.get("Ver_ContractualRights").get("keywords").toString();
				util.selectBoxByValue(logger, verpage.Ver_ContractualRights, str);*/
				
				/*Select sel2 = new Select(verpage.Ver_Commu_Available);
				
	     		List<WebElement> list2 = sel2.getOptions();
	     		for(int i=0; i<list2.size(); i++){
	     			System.out.println(list2.get(i).getText());
	     			if(list2.get(i).getText().equalsIgnoreCase("All Accenture Employees")){
	     				list2.get(i).click();
	     				break;
	     			}}
	     		util.pause(logger, "5");
	     		util.waitTillElementIsClickable(logger, driver, verpage.Ver_Comm_RightArrow_Appl);
	     		util.clickOn(logger, verpage.Ver_Comm_RightArrow_Appl);*/
	     		util.pause(logger, "5");
				util.waitTillElementIsVisible(logger, driver, verpage.Verify_Submitbtn);
				util.clickOn(logger, verpage.Verify_Submitbtn);
				util.waittillpageload(logger, driver);
				util.pause(logger, "10");
				
				util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Registration Status')]/../parent::div/span[contains(text(),'Verification Completed')]")));
				System.out.println("The Registration Status = Verification Completed");
				
				util.pause(logger, "5");
			
				//verifying Verify button when the Registration Status = Verification Completed
				
				if(verpage.Verify_Button.isDisplayed()==true){
					
					logger.log(LogStatus.FAIL, "Verify Button is Displayed when Registration Status = Verification Completed");
				}
				
				else{
					logger.log(LogStatus.PASS, "Verify Button is not Displaying when Registration Status = Verification Completed");
				}

		         }
		
			catch(Exception e)
	        {
	                util.screenShotAndErrorMsg(logger, e, driver, "VerifyRequest");
	        }
	        extent.endTest(logger);
	        extent.flush();	
		}		
		
		@Test
		public void RegistrationCancel(){
			
			ExtentTest logger = extent.startTest("RegistrationCancel", "RegistrationCancel");
			
			try{
				
				//Below Job to enable verify button after Registration Completed
				RunScheduledJob("Verifybutton");
				
				driver=browserHelper.driversList.get(0);
				
				String reqwindow=browserHelper.driversList.get(0).getWindowHandle().toString();
				System.out.println("Status Verify - reqwindow id is "+reqwindow);
		        driver.switchTo().window(reqwindow);
		        util.pause(logger, "5");
		        driver.navigate().refresh(); 
		        driver.navigate().to(inputData.get("navigateportal").get("URL").toString());
		        util.pause(logger, "20");
		        sspage = PageFactory.initElements(driver, SelfServicePage.class);
		        homepage = PageFactory.initElements(driver, HomePage.class);
		        

			util.waitTillElementIsClickable(logger, driver, homepage.ApplCard);
			
			if(homepage.ViewAllLink.isDisplayed()==true){
				util.clickOn(logger, homepage.ViewAllLink);
				util.pause(logger, "5");
			}
			
			util.clickOn(logger, driver.findElement(By.xpath("(.//div[@class='tile-title ApplicationNames']/b[contains(text(),'"+AppName+"')])[1]")));
			System.out.println("Specific application page is displayed");
			util.waittillpageload(logger, driver);
			util.pause(logger, "5");
				
					sspage = PageFactory.initElements(driver, SelfServicePage.class);
			       homepage = PageFactory.initElements(driver, HomePage.class);
			       RegPage = PageFactory.initElements(driver, RegisterPage.class);
			       
				util.waittillpageload(logger, driver);
				util.pause(logger, "10");
				
				/*util.verifyElementByXpath(logger, homepage.RegStatus_RegCancelled);
				logger.log(LogStatus.PASS, "Registration Cancelled Status displayed successfully.");*/
				
				str = homepage.RegStatus_RegCancelled.getAttribute("innerText");
				if(str.equalsIgnoreCase("Registration Cancelled"))
				{
					logger.log(LogStatus.PASS, "Registration Status = Registration Cancelled displayed");
				}
				else
				{
					logger.log(LogStatus.FAIL, "Registration Status is not equal to Registration Cancelled");
				}
				
				str = homepage.ApplStatus_Verification.getAttribute("innerText");
				
				if(str.equalsIgnoreCase("Withdrawn"))
				{
					logger.log(LogStatus.PASS, "The Application Status = Withdrawn, when Registration Status = Registration Cancelled");
				}
				else
				{
					logger.log(LogStatus.FAIL, "The Application Status is not equal to Withdrawn, when Registration Status = Registration Cancelled");
				}
				
				/*util.verifyElementByXpath(logger, homepage.ApplStatus_Withdrawn);
				logger.log(LogStatus.INFO, "The Application Status = Withdrawn, when Registration Status = Registration Cancelled");*/
				
				//Verifying Edit button is not available when Registration Status = Registration Cancelled
				
				/*if(homepage.Edit_button.isDisplayed()== false){
	     			logger.log(LogStatus.PASS, "Edit button is not Displaying when Registration Status = Registration Cancelled");	
	     		}
	     		
	     		else
	     		{
	     			logger.log(LogStatus.FAIL, "Edit button is Displaying when Registration Status = Registration Cancelled");	
	     		}*/
				
				//Verifying Retire button is not available when Registration Status = Registration Cancelled
				
				if(homepage.Retire_btn.isDisplayed()== false){
	     			logger.log(LogStatus.PASS, "Retire button is not Displaying when Registration Status = Registration Cancelled");	
	     		}
	     		
	     		else{
	     			logger.log(LogStatus.FAIL, "Retire button is Displaying when Registration Status = Registration Cancelled");	
	     		}
	
				//Verifying Register button is available when Registration Status = Registration Cancelled
				
							
				if (driver.findElements(By.xpath(".//button[@class='btn btn-primary ok-btn'][contains(text(),'Register')]")).size()==0){
					
					logger.log(LogStatus.PASS, "Register button is not Displaying when Registration Status = Registration Cancelled");
				}
				
				else
				{
					logger.log(LogStatus.PASS, "Register button is Displaying when Registration Status = Registration Cancelled");
				}
				
				//Verifying Verify button is available when Registration Status = Registration In Progress
				
				
				if(driver.findElement(By.xpath(".//button[contains(text(),'Verify')]")).isDisplayed()== false)
				{
	     			logger.log(LogStatus.PASS, "Verify button is not Displaying when Registration Status = Registration Cancelled");	
	     		}
	     		
	     		else{
	     			logger.log(LogStatus.FAIL, "Verify button is Displaying when Registration Status = Registration Cancelled");	
	     		}
	

			}
		
			catch(Exception e)
	        {
	                util.screenShotAndErrorMsg(logger, e, driver, "RegistrationCancel");
	        }
	        extent.endTest(logger);
	        extent.flush();	
		}	
		
		
		@Test
		public void Decommissioned(){
			
			ExtentTest logger = extent.startTest("Decommissioned", "Decommissioned");
			
			try{
				
				/*util.pause(logger, "5");
				verifyticketspage("CIOAppl_Oper_Requests");*/
			
					navigate(logger);
		           sspage = PageFactory.initElements(driver, SelfServicePage.class);
		           loginPage = PageFactory.initElements(driver, LoginPage.class);
		           username=inputData.get("Admin").get("Username").toString();
		           String pwd=inputData.get("Admin").get("Password").toString();
		           System.out.println(username + "       "+pwd);
		           
		           loginPage.login(logger,username,pwd);
				
				
		        //driver.navigate().to(inputData.get("navpage").get("URL").toString());
		        
		        homepage = PageFactory.initElements(driver, HomePage.class);
		        util.waittillpageload(logger, driver);
		        util.pause(logger, "10");
		        util.waitTillElementIsVisible(logger, driver, homepage.GlobalSearch_Icon);
		        util.waitTillElementIsClickable(logger, driver, homepage.GlobalSearch_Icon);
		        util.clickOn(logger, homepage.GlobalSearch_Icon);
		        util.pause(logger, "2");
		        util.setTextWithEnter(logger, homepage.GlobalSearch, requestID);
		        util.waittillpageload(logger, driver);
		        util.pause(logger, "5");
		        frameHelper.switchToFrame(logger, driver, homepage.Frame);
				homepage = PageFactory.initElements(driver, HomePage.class);
				System.out.println("Switched to Frame");
		        util.clickOn(logger, homepage.TaskNumber_Link);
		        util.pause(logger, "10");
		        str = homepage.TaskNumber.getAttribute("value");
		        logger.log(LogStatus.INFO, "The Task Number is: " +str);
		        util.clickOn(logger, homepage.CloseTask_btn);
		        util.pause(logger, "10");
		        	        
		        driver=browserHelper.driversList.get(0);
				
				String reqwindow=browserHelper.driversList.get(0).getWindowHandle().toString();
				System.out.println("Status Verify - reqwindow id is "+reqwindow);
		     driver.switchTo().window(reqwindow);
		     
		        driver.navigate().refresh();
		        util.pause(logger, "20");
		        
		       /* driver.navigate().to(inputData.get("navigateportal").get("URL").toString());
		        
		        util.waittillpageload(logger, driver);
		        util.pause(logger, "20");
		        sspage = PageFactory.initElements(driver, SelfServicePage.class);
		        homepage = PageFactory.initElements(driver, HomePage.class);
		        

			util.waitTillElementIsClickable(logger, driver, homepage.ApplCard);
			
			if(homepage.ViewAllLink.isDisplayed()==true){
				util.clickOn(logger, homepage.ViewAllLink);
				util.pause(logger, "5");
			}*/
			
			//The below code is commented bcz, Decommissioned card is removed in QMDB Q3 Release:  
			/*util.clickOn(logger, driver.findElement(By.xpath("(.//div[@class='tile-title ApplicationNames']/b[contains(text(),'"+AppName+"')])[1]")));
			System.out.println("Specific application page is displayed");
			util.waittillpageload(logger, driver);
			util.pause(logger, "25");*/
		        
		    sspage = PageFactory.initElements(driver, SelfServicePage.class);
		    homepage = PageFactory.initElements(driver, HomePage.class);
		    
			util.verifyElementByXpath(logger, homepage.Decommissioned_Status);
			logger.log(LogStatus.INFO, "The Registration Status is Decommissioned");
			
			util.verifyElementByXpath(logger, homepage.ApplStatus_Verification);
			logger.log(LogStatus.INFO, "The Application Status = Sunset, when Registration Status = Decommissioned");
			
			//Verifying Edit button is not available when Registration Status = Decommissioned
			
			/*if(homepage.Edit_button.isDisplayed()== false)
			{
				logger.log(LogStatus.PASS, "Edit button is not Displaying when Registration Status = Decommissioned");
			}
     		
     		else{
     			logger.log(LogStatus.FAIL, "Edit button is Displaying when Registration Status = Decommissioned");	
     		}*/
			
			//Verifying Retire button is not available when Registration Status = Decommissioned
			
			if(driver.findElements(By.xpath(".//button[@ng-show='ShowRetireButton'][@class='btn btn-primary ok-btn']")).size()==0)
			
			{
				logger.log(LogStatus.PASS, "Retire button is not Displaying when Registration Status = Decommissioned");
			}
			
			else{
     			logger.log(LogStatus.FAIL, "Retire button is Displaying when Registration Status = Decommissioned");	
     		}
			
			/*if(homepage.Retire_btn.isDisplayed()== false){
     			logger.log(LogStatus.PASS, "Retire button is not Displaying when Registration Status = Decommissioned");	
     		}
     		
     		else{
     			logger.log(LogStatus.FAIL, "Retire button is Displaying when Registration Status = Decommissioned");	
     		}
*/
			//Verifying Register button is available when Registration Status = Decommissioned
			
						
			if (driver.findElements(By.xpath(".//button[@class='btn btn-primary ok-btn'][contains(text(),'Register')]")).size()==0){
				
				logger.log(LogStatus.PASS, "Register button is not Displaying when Registration Status = Decommissioned");
			}
			
			else
			{
				logger.log(LogStatus.PASS, "Register button is Displaying when Registration Status = Decommissioned");
			}
			
			//Verifying Verify button is available when Registration Status = Decommissioned
			
			
			if(driver.findElement(By.xpath(".//button[contains(text(),'Verify')]")).isDisplayed()== false)
			{
     			logger.log(LogStatus.PASS, "Verify button is not Displaying when Registration Status = Decommissioned");	
     		}
     		
     		else
     		{
     			logger.log(LogStatus.FAIL, "Verify button is Displaying when Registration Status = Decommissioned");	
     		}

			}

			catch(Exception e)
	        {
	                util.screenShotAndErrorMsg(logger, e, driver, "Decommissioned");
	        }
	        extent.endTest(logger);
	        extent.flush();	
		}	
		
		@Test
		public void CreateSurvey(){
			
			ExtentTest logger = extent.startTest("CreateSurvey", "CreateSurvey");
			
			try{
				
				navigate(logger);
		           sspage = PageFactory.initElements(driver, SelfServicePage.class);
		           loginPage = PageFactory.initElements(driver, LoginPage.class);
		           surveypage = PageFactory.initElements(driver, SurveyPage.class);
		           username=inputData.get("Admin").get("Username").toString();
		           String pwd=inputData.get("Admin").get("Password").toString();
		           System.out.println(username + "       "+pwd);
		           
		           loginPage.login(logger,username,pwd);
		           
		           driver.navigate().to(inputData.get("navigateportal").get("URL").toString());
		           homepage = PageFactory.initElements(driver, HomePage.class);
					
					util.waittillpageload(logger, driver);
					util.pause(logger, "15");
					
					util.verifyElementByXpath(logger, homepage.Aboutus);
					logger.log(LogStatus.INFO, "About Us header verified");	
		           
					util.verifyElementByXpath(logger, homepage.MyActivities);
					util.waitTillElementIsClickable(logger, driver, homepage.MyActivities);
					
					util.clickByJavascriptExecutor(logger, driver, homepage.MyActivities);
					//util.clickOn(logger, homepage.MyActivities);
					util.pause(logger, "10");
							
					util.verifyElementByXpath(logger, homepage.MyApplication);
					logger.log(LogStatus.INFO, "My Application header verified");	
					
					util.verifyElementByXpath(logger, homepage.Search_Reports);
					logger.log(LogStatus.INFO, "Search/Reports header verified");
					
					util.verifyElementByXpath(logger, homepage.Surveys);
					logger.log(LogStatus.INFO, "Surveys header verified");
					
					util.clickOn(logger, homepage.Surveys);
					util.waittillpageload(logger, driver);
					util.pause(logger, "10");
					
					if(homepage.RegAnAppl.isDisplayed()== true)
					{
						logger.log(LogStatus.PASS, "Register an Application button Displayed in Survey page");
						System.out.println("Register an Application button Displayed in Survey page");
					}
					else
					{
						logger.log(LogStatus.FAIL, "Register an Application button is not Displayed in Survey page");
					}
					
					if(surveypage.CreateSurveyLink.isDisplayed()== true)
					{
						logger.log(LogStatus.PASS, "Create/Manage Survey button Displayed in Survey page");
						System.out.println("Create/Manage Survey button Displayed in Survey page");
						util.clickOn(logger, surveypage.CreateSurveyLink);
						util.waittillpageload(logger, driver);
						util.pause(logger, "20");
					}
				
					else
					{
						logger.log(LogStatus.FAIL, "Create/Manage Survey button is not Displayed in Survey page");
					}
					
		        driver.navigate().to(inputData.get("SurveyDesigner").get("URL").toString());
		        
		        homepage = PageFactory.initElements(driver, HomePage.class);
		        surveypage = PageFactory.initElements(driver, SurveyPage.class);
		        util.waittillpageload(logger, driver);
		        util.pause(logger, "10");
		        
		        /*Actions act = new Actions(driver);
		        WebElement drag = driver.findElement(By.xpath("(.//div[@class='dc-field-type-content-inner'])[13]"));
		        WebElement drop	= driver.findElement(By.xpath(".//div[contains(text(),'Drag content, drop it here')]"));
		        
		        System.out.println("Action started");
		        act.clickAndHold(drag).build().perform();
		        act.moveToElement(drop).build().perform();
		        act.release(drop).build().perform();
		        System.out.println("Action ended");*/
		        
		        Actions act = new Actions(driver);
		        WebElement drag = driver.findElement(By.xpath("(.//div[@class='dc-field-type-content-inner'])[1]"));
		        WebElement drop	= driver.findElement(By.xpath(".//div[@class='sn-fd-column dd ng-isolate-scope sn-fd-column-single']"));
		        
		        System.out.println("Action started");
		       
		        Action dragAndDrop = act.clickAndHold(drag).moveToElement(drop).release(drop).build();
		        // Get the action
		        dragAndDrop.perform(); 
		        System.out.println("Action ended");
		        util.pause(logger, "5");
		        
		        System.out.print(driver.getCurrentUrl());
		        Actions act1 = new Actions(driver);
		        System.out.println("Action started1");
		        util.pause(logger, "5");
		        WebElement drop2 = driver.findElement(By.xpath(".//div[@class='sn-fd-column dd ng-isolate-scope sn-fd-column-single']"));
		        WebElement drag2 = driver.findElement(By.xpath("(.//div[@class='dc-field-type-content-inner'])[12]"));
		        
		        Action dragAndDrop2 = act1.clickAndHold(drag2).moveToElement(drop2).release(drop2).build();
      	      	// Get the action
		        dragAndDrop2.perform(); 
		    
			}
		
			catch(Exception e)
	        {
	                util.screenShotAndErrorMsg(logger, e, driver, "CreateSurvey");
	                e.printStackTrace();
	        }
	        extent.endTest(logger);
	        extent.flush();	
		}
		
		
		@Test
		public void EditTechnology(){
			
			ExtentTest logger = extent.startTest("EditTechnology", "EditTechnology");
			
			try{
				
				sspage = PageFactory.initElements(driver, SelfServicePage.class);
		        homepage = PageFactory.initElements(driver, HomePage.class);
		        RegPage = PageFactory.initElements(driver, RegisterPage.class);
				util.pause(logger, "10");
				util.clickOn(logger, homepage.Techno_Pencil_btn);
				util.waittillpageload(logger, driver);
				util.pause(logger, "5");
				frameHelper.switchToChildWindow(logger, driver, frameHelper.getParentWindowHandle(logger, driver));
				frameHelper.switchToFrame(logger, driver, homepage.Edit_Techno_Frame);
				util.pause(logger, "5");
				
				str = inputData.get("Edit_AccessOnline").get("keywords").toString();
				util.selectBoxByValue(logger, homepage.Edit_AccessOnline, str);
				
				str = inputData.get("Edit_workstations").get("keywords").toString();
				util.selectBoxByValue(logger, homepage.Edit_workstations, str);
				
				str = inputData.get("Edit_MobCap").get("keywords").toString();
				util.selectBoxByValue(logger, homepage.Edit_MobCap, str);
				//util.waitTillElementIsClickable(logger, driver, homepage.Edit_Techno_Submit_btn);
				util.pause(logger, "5");
				util.clickOn(logger, homepage.Edit_Techno_Submit_btn);
				//util.clickByJavascriptExecutor(logger, driver, homepage.Edit_Techno_Submit_btn);
				util.pause(logger, "5");				
				frameHelper.switchToParentWindowHandle(logger, driver, "");
				frameHelper.switchToDefaultFrame(logger, driver);
				util.pause(logger, "5");
				util.clickOn(logger, homepage.Edit_Techno_Close_btn);
				util.pause(logger, "5");
				
				util.verifyElementByXpath(logger, homepage.WorkStation_Label);
				logger.log(LogStatus.INFO, "Is this application downloaded and run on workstations? Lable present in Technology Details Section");
				
				if(driver.findElements(By.xpath(".//b[contains(text(),'Is this application downloaded and run on workstations?')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
				{
					logger.log(LogStatus.PASS, "Is this application downloaded and run on workstations? information has value Yes");
				}
				
				if(driver.findElements(By.xpath(".//b[contains(text(),'Is this application downloaded and run on workstations?')]/../parent::div/span[contains(text(),'No')]")).size()==1)
				{
					logger.log(LogStatus.PASS, "Is this application downloaded and run on workstations? information has value No");
					
				}
				
				/*util.verifyElementByXpath(logger, homepage.Verify_Techno_WebEnabled);
				logger.log(LogStatus.INFO, "Is this application web enabled Lable present in Technology Details Section");*/
				
				if(driver.findElements(By.xpath(".//b[contains(text(),'Is this application web enabled')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
				{
					logger.log(LogStatus.PASS, "Is this application web enabled has value Yes");
					System.out.println("Is this application web enabled has value Yes");
				}
				
				if(driver.findElements(By.xpath(".//b[contains(text(),'Is this application web enabled')]/../parent::div/span[contains(text(),'No')]")).size()==1)
				{
					logger.log(LogStatus.PASS, "Is this application web enabled has value No");
					System.out.println("Is this application web enabled has value No");
				}
				
				util.verifyElementByXpath(logger, homepage.MobileCapability_Label);
				logger.log(LogStatus.INFO, "Mobile Capability Lable present in Technology Details Section");
				str = inputData.get("Edit_MobCap").get("keywords").toString();
				util.verifyElementByXpath(logger, driver.findElement(By.xpath("//b[contains(text(),'Mobile capability')]/../parent::div/span[contains(text(),'"+str+"')]")));
				
				util.verifyElementByXpath(logger, homepage.TechnologyArchitecture_Label);
				logger.log(LogStatus.INFO, "Technology Architecture Lable present in Technology Details Section");
				
				str = homepage.TechnologyArchitecture.getAttribute("innerText");
				
				if(str.isEmpty()==false){
					
					logger.log(LogStatus.PASS, "Technology Architecture values are available");
				}
				
				else{
					logger.log(LogStatus.FAIL, "Technology Architecture values are not available");
				}
				
			}

			catch(Exception e)
	        {
	                util.screenShotAndErrorMsg(logger, e, driver, "EditTechnology");
	                e.printStackTrace();
	        }
	        extent.endTest(logger);
	        extent.flush();	
		}
		
		@Test
		public void EditApplicationInfoSec(){
			
			ExtentTest logger = extent.startTest("EditApplicationInfoSec", "EditApplicationInfoSec");
			
			try{
				
				sspage = PageFactory.initElements(driver, SelfServicePage.class);
		        homepage = PageFactory.initElements(driver, HomePage.class);
		        RegPage = PageFactory.initElements(driver, RegisterPage.class);
								
				util.pause(logger, "5");
				util.clickOn(logger, homepage.Appln_Pencil_btn);
				util.waittillpageload(logger, driver);
				util.pause(logger, "5");
				frameHelper.switchToChildWindow(logger, driver, frameHelper.getParentWindowHandle(logger, driver));
				frameHelper.switchToFrame(logger, driver, homepage.Edit_ApplnInfo_Frame);
				util.pause(logger, "5");
				
				str = inputData.get("Edit_AppInfo_ParAppln").get("keywords").toString();
				util.setTextWithEnter(logger, homepage.Edit_AppInfo_ParAppln, str);
				
				str = inputData.get("Edit_AppInfo_ProdUrl").get("keywords").toString();
				util.setTextWithEnter(logger, homepage.Edit_AppInfo_ProdUrl, str);
				
				util.waitTillElementIsClickable(logger, driver, homepage.Edit_AppInfo_Submit_btn);
				util.pause(logger, "5");
				util.clickOn(logger, homepage.Edit_AppInfo_Submit_btn);
				
				util.pause(logger, "5");
				frameHelper.switchToParentWindowHandle(logger, driver, "");
				frameHelper.switchToDefaultFrame(logger, driver);
				//need to update Close button
				util.clickOn(logger, homepage.Edit_AppInfo_Close_btn);
				util.pause(logger, "5");
				
				util.clickOn(logger, homepage.ApplInfoSec_SeeMore);
				util.pause(logger, "2");
				str = inputData.get("Edit_AppInfo_ParAppln").get("keywords").toString();
				util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Parent Application')]/../parent::div/span[contains(text(),'"+str+"')]")));
				
				str = inputData.get("Edit_AppInfo_ProdUrl").get("keywords").toString();
				util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'URL')]/../parent::div/span[contains(text(),'"+str+"')]")));
				util.clickOn(logger, homepage.ApplInfoSec_SeeLess);
			}

			catch(Exception e)
	        {
	                util.screenShotAndErrorMsg(logger, e, driver, "EditApplicationInfoSec");
	                e.printStackTrace();
	        }
	        extent.endTest(logger);
	        extent.flush();	
		}
		
		@Test
		public void EditCommunicationSec(){
			
			ExtentTest logger = extent.startTest("EditCommunicationSec", "EditCommunicationSec");
			
			try{
				
				sspage = PageFactory.initElements(driver, SelfServicePage.class);
		        homepage = PageFactory.initElements(driver, HomePage.class);
		        RegPage = PageFactory.initElements(driver, RegisterPage.class);
								
				util.pause(logger, "5");
				util.clickOn(logger, homepage.Commu_Pencil_btn);
				util.waittillpageload(logger, driver);
				util.pause(logger, "5");
				frameHelper.switchToChildWindow(logger, driver, frameHelper.getParentWindowHandle(logger, driver));
				frameHelper.switchToFrame(logger, driver, homepage.Edit_Commu_Frame);
				util.pause(logger, "5");
				
				str = inputData.get("Edit_Commu_PriCommCont_CIO").get("keywords").toString();
				util.setTextWithEnter(logger, homepage.Edit_Commu_PriCommCont_CIO, str);
				
				str = inputData.get("Edit_Commu_AppNotiTool").get("keywords").toString();
				util.selectBoxByValue(logger, homepage.Edit_Commu_AppNotiTool, str);
				
				str = inputData.get("Edit_Commu_PriCommCont_Business").get("keywords").toString();
				util.setTextWithEnter(logger, homepage.Edit_Commu_PriCommCont_Business, str);
				util.pause(logger, "3");
				
				util.clickOn(logger, homepage.Edit_Commu_Submit_btn);
				
				util.pause(logger, "5");
				frameHelper.switchToParentWindowHandle(logger, driver, "");
				frameHelper.switchToDefaultFrame(logger, driver);
				//need to update Close button
				util.clickOn(logger, homepage.Edit_Commu_Close_btn);
				util.pause(logger, "5");
				
				util.clickOn(logger, homepage.Commu_SeeMore);
				util.pause(logger, "2");
				
				str = inputData.get("Edit_Commu_PriCommCont_CIO").get("keywords").toString();
				util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Primary Communication Contact (CIO)')]/../parent::div/span[contains(text(),'"+str+"')]")));
				
				str = inputData.get("Edit_Commu_PriCommCont_Business").get("keywords").toString();
				util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Primary Communication Contact (Business)')]/../parent::div/span[contains(text(),'"+str+"')]")));
				
				str = inputData.get("Edit_Commu_AppNotiTool").get("keywords").toString();
				util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'What is the in-app notification tool?')]/../parent::div/span[contains(text(),'"+str+"')]")));
				
				util.clickOn(logger, homepage.Commu_SeeLess);
			}

			catch(Exception e)
	        {
	                util.screenShotAndErrorMsg(logger, e, driver, "EditCommunicationSec");
	                e.printStackTrace();
	        }
	        extent.endTest(logger);
	        extent.flush();	
		}	
		
		@Test
		public void EditSupportSec(){
			
			ExtentTest logger = extent.startTest("EditSupportSec", "EditSupportSec");
			
			try{
				
				sspage = PageFactory.initElements(driver, SelfServicePage.class);
		        homepage = PageFactory.initElements(driver, HomePage.class);
		        RegPage = PageFactory.initElements(driver, RegisterPage.class);
								
				util.pause(logger, "5");
				util.clickOn(logger, homepage.Support_Pencil_btn);
				util.waittillpageload(logger, driver);
				util.pause(logger, "5");
				frameHelper.switchToChildWindow(logger, driver, frameHelper.getParentWindowHandle(logger, driver));
				frameHelper.switchToFrame(logger, driver, homepage.Edit_Support_Frame);
				util.pause(logger, "5");
				
				str = inputData.get("Edit_Special_Cont_Instr").get("keywords").toString();
				util.setTextWithEnter(logger, homepage.Edit_Special_Cont_Instr, str);
				
				str = inputData.get("Edit_P1Cont").get("keywords").toString();
				util.setTextWithEnter(logger, homepage.Edit_P1Cont, str);
				
				str = inputData.get("Edit_P2Cont").get("keywords").toString();
				util.setTextWithEnter(logger, homepage.Edit_P2Cont, str);
				
				str = inputData.get("Edit_InterOperSuppUrl").get("keywords").toString();
				util.setTextWithEnter(logger, homepage.Edit_InterOperSuppUrl, str);
				
				str = inputData.get("Edit_PrimEmerContName").get("keywords").toString();
				util.setTextWithEnter(logger, homepage.Edit_PrimEmerContName, str);
				
				str = inputData.get("Edit_SecoEmerContName").get("keywords").toString();
				util.setTextWithEnter(logger, homepage.Edit_SecoEmerContName, str);
				
				util.pause(logger, "3");
				util.clickOn(logger, homepage.Edit_Supp_Submit_btn);
				util.pause(logger, "5");
				
				frameHelper.switchToParentWindowHandle(logger, driver, "");
				frameHelper.switchToDefaultFrame(logger, driver);
				
				util.clickOn(logger, homepage.Edit_Supp_Close_btn);
				util.pause(logger, "5");
				
				util.clickOn(logger, homepage.Support_SeeMore);
				util.pause(logger, "2");
				
				str = inputData.get("Edit_Special_Cont_Instr").get("keywords").toString();
				util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Special Contact Instructions')]/../parent::div/span[contains(text(),'"+str+"')]")));
				
				str = inputData.get("Edit_P1Cont").get("keywords").toString();
				util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]")));
				logger.log(LogStatus.INFO, " P1 Contact Support Name present in Support Contacts Details Section");
							
				str = inputData.get("Edit_P2Cont").get("keywords").toString();
				util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]")));
				logger.log(LogStatus.INFO, " P2 Contact Support Name present in Support Contacts Details Section");
				
				str = inputData.get("Edit_InterOperSuppUrl").get("keywords").toString();
				util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Internal Operations Support URL')]/../parent::div/span[contains(text(),'"+str+"')]")));
				
				str = inputData.get("Edit_PrimEmerContName").get("keywords").toString();
				util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]")));
				logger.log(LogStatus.INFO, "Primary Emergency Contact Name present in Emergency Contacts Details Section");
				
				str = inputData.get("Edit_SecoEmerContName").get("keywords").toString();
				util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//label[contains(text(),'"+str+"')]")));
				logger.log(LogStatus.INFO, "Secondary Emergency Contacts Name present in Emergency Contacts Details Section");
				
				util.clickOn(logger, homepage.Support_SeeLess);
			}

			catch(Exception e)
	        {
	                util.screenShotAndErrorMsg(logger, e, driver, "EditSupportSec");
	                e.printStackTrace();
	        }
	        extent.endTest(logger);
	        extent.flush();	
		}	
		
		
		@Test
		public void EditLegalSec(){
			
			ExtentTest logger = extent.startTest("EditLegalSec", "EditLegalSec");
			
			try{
				
				sspage = PageFactory.initElements(driver, SelfServicePage.class);
		        homepage = PageFactory.initElements(driver, HomePage.class);
		        RegPage = PageFactory.initElements(driver, RegisterPage.class);
								
				util.pause(logger, "5");
				util.clickOn(logger, homepage.Legal_Pencil_btn);
				util.waittillpageload(logger, driver);
				util.pause(logger, "5");
				frameHelper.switchToChildWindow(logger, driver, frameHelper.getParentWindowHandle(logger, driver));
				frameHelper.switchToFrame(logger, driver, homepage.Edit_Legal_Frame);
				util.pause(logger, "5");
				
				str = inputData.get("Edit_DataClass").get("keywords").toString();
				util.selectBoxByValue(logger, homepage.Edit_DataClass, str);
				
				str = inputData.get("Edit_Whocanseedata").get("keywords").toString();
				util.selectBoxByValue(logger, homepage.Edit_Whocanseedata, str);
				
				str = inputData.get("Edit_TempAdmin").get("keywords").toString();
				util.selectBoxByValue(logger, homepage.Edit_TempAdmin, str);
				
				str = inputData.get("Edit_AirLegal").get("keywords").toString();
				util.selectBoxByValue(logger, homepage.Edit_AirLegal, str);
				
				util.waitTillElementIsClickable(logger, driver, homepage.Edit_Legal_Submit_btn);
				util.pause(logger, "5");
				util.clickOn(logger, homepage.Edit_Legal_Submit_btn);
				
				util.pause(logger, "5");
				frameHelper.switchToParentWindowHandle(logger, driver, "");
				frameHelper.switchToDefaultFrame(logger, driver);
				//need to update Close button
				util.clickOn(logger, homepage.Edit_Legal_Close_btn);
				util.pause(logger, "5");
				
				util.clickOn(logger, homepage.Legal_SeeMore);
				util.pause(logger, "2");
				
				str = inputData.get("Edit_DataClass").get("keywords").toString();
				util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Data Classification')]/../parent::div/span[contains(text(),'"+str+"')]")));
				
				str = inputData.get("Edit_Whocanseedata").get("keywords").toString();
				util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Who can see data in the system?')]/../parent::div/span[contains(text(),'"+str+"')]")));
				
				if(driver.findElements(By.xpath(".//b[contains(text(),'PAM Managed - Tempadmin?')]/../parent::div/span[contains(text(),'No')]")).size()==1)
				{
					logger.log(LogStatus.PASS, "PAM Managed - Tempadmin? has value No");
				}
				
				if(driver.findElements(By.xpath(".//b[contains(text(),'PAM Managed - Tempadmin?')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
				{
					logger.log(LogStatus.PASS, "PAM Managed - Tempadmin? has value Yes");
				}
				
				if(driver.findElements(By.xpath(".//b[contains(text(),'Has the AIR Legal Tab been completed?')]/../parent::div/span[contains(text(),'Yes')]")).size()==1)
				{
					logger.log(LogStatus.PASS, "Has the AIR Legal Tab been completed? has value Yes");
				}
				
				if(driver.findElements(By.xpath(".//b[contains(text(),'Has the AIR Legal Tab been completed?')]/../parent::div/span[contains(text(),'No')]")).size()==1)
				{
					logger.log(LogStatus.PASS, "Has the AIR Legal Tab been completed? has value No");
					
				}
				
				util.clickOn(logger, homepage.Legal_SeeLess);
			}

			catch(Exception e)
	        {
	                util.screenShotAndErrorMsg(logger, e, driver, "EditLegalSec");
	                e.printStackTrace();
	        }
	        extent.endTest(logger);
	        extent.flush();	
		}
		
		
		@Test
		public void EditPrimaryContactsSec(){
			
			ExtentTest logger = extent.startTest("EditPrimaryContactsSec", "EditPrimaryContactsSec");
			
			try{
				
				sspage = PageFactory.initElements(driver, SelfServicePage.class);
		        homepage = PageFactory.initElements(driver, HomePage.class);
		        RegPage = PageFactory.initElements(driver, RegisterPage.class);
								
				util.pause(logger, "5");
				util.clickOn(logger, homepage.PrimaryCont_Pencil_btn);
				util.waittillpageload(logger, driver);
				util.pause(logger, "5");
				frameHelper.switchToChildWindow(logger, driver, frameHelper.getParentWindowHandle(logger, driver));
				frameHelper.switchToFrame(logger, driver, homepage.Edit_PrimaryCont_Frame);
				util.pause(logger, "10");
				
				str = inputData.get("Edit_ServOprMgr").get("keywords").toString();
				util.setTextWithEnter(logger, homepage.Edit_ServOprMgr, str);
				
				str = inputData.get("Edit_AIMProgID").get("keywords").toString();
				str = str.replaceAll("k", "");
				util.setTextWithEnter(logger, homepage.Edit_AIMProgID, str);
				
				str = inputData.get("Edit_Progm_Mgr").get("keywords").toString();
				util.setTextWithEnter(logger, homepage.Edit_Progm_Mgr, str);
				
				util.pause(logger, "3");
				util.waitTillElementIsClickable(logger, driver, homepage.Edit_PrimaryCont_Submit_btn);
				util.pause(logger, "5");
				util.clickOn(logger, homepage.Edit_PrimaryCont_Submit_btn);
				
				util.pause(logger, "5");
				frameHelper.switchToParentWindowHandle(logger, driver, "");
				frameHelper.switchToDefaultFrame(logger, driver);
				
				//need to update Close button
				util.clickOn(logger, homepage.Edit_PrimaryCont_Close_btn);
				util.pause(logger, "5");
			
				/*str = inputData.get("Edit_AppInfo_ParAppln").get("keywords").toString();
				util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'Parent Application')]/../parent::div/span[contains(text(),'"+str+"')]")));
				
				str = inputData.get("Edit_AppInfo_ProdUrl").get("keywords").toString();
				util.verifyElementByXpath(logger, driver.findElement(By.xpath(".//b[contains(text(),'URL')]/../parent::div/span[contains(text(),'"+str+"')]")));
				util.clickOn(logger, homepage.ApplInfoSec_SeeLess);*/
			}

			catch(Exception e)
	        {
	                util.screenShotAndErrorMsg(logger, e, driver, "EditPrimaryContactsSec");
	                e.printStackTrace();
	        }
	        extent.endTest(logger);
	        extent.flush();	
		}
		
		
		@Test
		public void AddTechnologyDetails_DataCenter(){
			
			ExtentTest logger = extent.startTest("AddTechnologyDetails_DataCenter", "AddTechnologyDetails_DataCenter");
			
			try{
				
				sspage = PageFactory.initElements(driver, SelfServicePage.class);
		        homepage = PageFactory.initElements(driver, HomePage.class);
		        RegPage = PageFactory.initElements(driver, RegisterPage.class);
								
		      //Adding Technology details by clicking on Plus (+) sign
				util.pause(logger, "5");
				util.clickOn(logger, RegPage.Plus_icon);
				util.pause(logger, "5");
				util.waittillpageload(logger, driver);
				frameHelper.switchToChildWindow(logger, driver, frameHelper.getParentWindowHandle(logger, driver));
				frameHelper.switchToFrame(logger, driver, RegPage.Techno_frame);
				util.pause(logger, "5");
				
				str = inputData.get("Reg_Provisioning").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.Technology_Provisioning, str);
				
				str = inputData.get("Technology_Type").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.Technology_Type, str);
				util.pause(logger, "5");
			
				Select sel1 = new Select(RegPage.Technology_Supplier);
	     		List<WebElement> list1 = sel1.getOptions();
	     		
	     		for(int j=0; j<list1.size(); j++){
	     			//System.out.println(list1.get(j).getText());
	     			if(list1.get(j).getText().equalsIgnoreCase("Not On List")){
	     				logger.log(LogStatus.FAIL, "Not on List value exists in Supplier drop down list");
						System.out.println("Not on List value exists in Supplier drop down list");
	     			}
	     			
	     			else
	     			{
						logger.log(LogStatus.PASS, "Not on List value does not exists in Supplier drop down list");
						System.out.println("Not on List value does not exists in Supplier drop down list");
					}
	     			
	     			}
				
				util.pause(logger, "5");
				str = inputData.get("Technology_Supplier").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.Technology_Supplier, str);
				
				/*str = inputData.get("Product").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Product, str);*/
				
				str = inputData.get("Technology_Additional_Details").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Technology_Additional_Details, str);
				
				str = inputData.get("Technology_Location").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.Technology_Location, str);
				
				util.pause(logger, "5");
				util.clickOn(logger, RegPage.Submitbtn);
				util.pause(logger, "5");
				//util.clickByJavascriptExecutor(logger, driver, RegPage.Techno_Close_btn);
				
				
				frameHelper.switchToParentWindowHandle(logger, driver, "");
				frameHelper.switchToDefaultFrame(logger, driver);
				util.clickOn(logger, RegPage.Techno_Close_btn);
				util.pause(logger, "5");
		
			}

			catch(Exception e)
	        {
	                util.screenShotAndErrorMsg(logger, e, driver, "AddTechnologyDetails_DataCenter");
	                e.printStackTrace();
	        }
	        extent.endTest(logger);
	        extent.flush();	
		}
		
		
		@Test
		public void AddTechnologyDetails_Saas(){
			
			ExtentTest logger = extent.startTest("AddTechnologyDetails_Saas", "AddTechnologyDetails_Saas");
			
			try{
				
				sspage = PageFactory.initElements(driver, SelfServicePage.class);
		        homepage = PageFactory.initElements(driver, HomePage.class);
		        RegPage = PageFactory.initElements(driver, RegisterPage.class);
								
		      //Adding Technology details by clicking on Plus (+) sign
				util.pause(logger, "5");
				util.clickOn(logger, RegPage.Plus_icon);
				util.pause(logger, "5");
				util.waittillpageload(logger, driver);
				frameHelper.switchToChildWindow(logger, driver, frameHelper.getParentWindowHandle(logger, driver));
				frameHelper.switchToFrame(logger, driver, RegPage.Techno_frame);
				util.pause(logger, "5");
				
				str = inputData.get("Technology_Provisioning_saas").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.Technology_Provisioning, str);
				
				str = inputData.get("Technology_Type_saas").get("keywords").toString();
				util.selectBoxByValue(logger, RegPage.Technology_Type, str);

				/*str = inputData.get("Product").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Product, str);*/
				
				str = inputData.get("Technology_Additional_Details_saas").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Technology_Additional_Details, str);
				
				str = inputData.get("Technology_Type_saas").get("keywords").toString();
				if(str.equalsIgnoreCase("SaaS"))
				{
				
				util.pause(logger, "2");
				str = inputData.get("Technology_Product_saas").get("keywords").toString();
				util.setTextWithEnter(logger, RegPage.Technology_Product, str);
				
				util.pause(logger, "5");
				str = inputData.get("Technology_supplier_reftype").get("keywords").toString();
				util.waitTillElementIsClickable(logger, driver, RegPage.Technology_supplier_reftype);
				util.clickOn(logger, RegPage.Technology_supplier_reftype);
				util.setTextWithEnter(logger, RegPage.Technology_supplier_reftype, str);
				util.pause(logger, "5");
				}	
					/*str = inputData.get("Technology_Location").get("keywords").toString();
					util.selectBoxByValue(logger, RegPage.Technology_Location, str);*/
				
				util.pause(logger, "5");
				util.clickOn(logger, RegPage.Submitbtn);
				util.pause(logger, "5");
				//util.clickByJavascriptExecutor(logger, driver, RegPage.Techno_Close_btn);
			
				frameHelper.switchToParentWindowHandle(logger, driver, "");
				frameHelper.switchToDefaultFrame(logger, driver);
				util.clickOn(logger, RegPage.Techno_Close_btn);
			}

			catch(Exception e)
	        {
	                util.screenShotAndErrorMsg(logger, e, driver, "AddTechnologyDetails_Saas");
	                e.printStackTrace();
	        }
	        extent.endTest(logger);
	        extent.flush();	
		}
		
		
		@Test
	    //Login Method
	    public void EditAssignedGroupUser()
	    {
	           ExtentTest logger = extent.startTest("EditAssignedGroupUser", "EditAssignedGroupUser");
	           try
	           {
	           
	        
	           navigate(logger);
	           sspage = PageFactory.initElements(driver, SelfServicePage.class);
	           loginPage = PageFactory.initElements(driver, LoginPage.class);
	           username=inputData.get("GroupUser").get("Username").toString();
	           String pwd=inputData.get("GroupUser").get("Password").toString();
	           System.out.println(username + "       "+pwd);
	           
	           loginPage.login(logger,username,pwd);
	           
	           driver.navigate().to(inputData.get("navigateportal").get("URL").toString());
		       sspage = PageFactory.initElements(driver, SelfServicePage.class);
		       homepage = PageFactory.initElements(driver, HomePage.class);
		       
	           util.waittillpageload(logger, driver);
		       util.pause(logger, "25");
		       
		       str = inputData.get("SearchApplRepocitory").get("keywords").toString();
		       util.waitTillElementIsClickable(logger, driver, homepage.SearchApplRepository);
		       util.setText(logger, homepage.SearchApplRepository, str);
		       
		       util.pause(logger, "5");
		       util.clickOn(logger, driver.findElement(By.xpath("(//li[@class='ui-menu-item'])[1]")));;
				util.pause(logger, "5");
				util.clickOn(logger, homepage.Search_Icon);
				util.waittillpageload(logger, driver);
				util.pause(logger, "20");

					util.waitTillElementIsClickable(logger, driver, homepage.Appln_Pencil_btn);
					logger.log(LogStatus.INFO, "Members Assignment Group user able to click on Application info Pencil icon");
					
					util.waitTillElementIsClickable(logger, driver, homepage.Commu_Pencil_btn);
					logger.log(LogStatus.INFO, "Members Assignment Group user able to click on Communication Pencil icon");
					
					util.waitTillElementIsClickable(logger, driver, homepage.Support_Pencil_btn);
					logger.log(LogStatus.INFO, "Members Assignment Group user able to click on Support detail Pencil icon");
					
					util.waitTillElementIsClickable(logger, driver, homepage.Techno_Pencil_btn);
					logger.log(LogStatus.INFO, "Members Assignment Group user able to click on Technology Architecture Pencil icon");
					
					util.waitTillElementIsClickable(logger, driver, homepage.TCN_Pencil_btn);
					logger.log(LogStatus.INFO, "Members Assignment Group user able to click on TCN Pencil icon");
					
					util.waitTillElementIsClickable(logger, driver, homepage.Legal_Pencil_btn);
					logger.log(LogStatus.INFO, "Members Assignment Group user able to click on Legal Pencil icon");
					
					util.waitTillElementIsClickable(logger, driver, homepage.PrimaryCont_Pencil_btn);
					logger.log(LogStatus.INFO, "Members Assignment Group user able to click on Primary Contacts Pencil icon");
	         
	           }
	           
	           catch(Exception e)
	           {
	                   util.screenShotAndErrorMsg(logger, e, driver, "EditAssignedGroupUser");
	           }
	           extent.endTest(logger);
	           extent.flush();
	             
	    }
		
		@Test
	    public void Vendordetail()
	    {
	           ExtentTest logger = extent.startTest("Vendordetail", "Vendordetail");
	           try
	           {
	           
	        
	           navigate(logger);
	           sspage = PageFactory.initElements(driver, SelfServicePage.class);
	           loginPage = PageFactory.initElements(driver, LoginPage.class);
	           username=inputData.get("Admin").get("Username").toString();
	           String pwd=inputData.get("Admin").get("Password").toString();
	           System.out.println(username + "       "+pwd);
	           
	           loginPage.login(logger,username,pwd);
	           
	          driver.navigate().to(inputData.get("navigateCMDBTechnologyListDB").get("URL").toString());
	          sspage = PageFactory.initElements(driver, SelfServicePage.class);
	          
	          util.waittillpageload(logger, driver);
	          util.pause(logger, "5");
	          
	          frameHelper.switchToDefaultFrame(logger, driver);
	          
	          util.pause(logger, "5");
	          	          
	          if(driver.findElements(By.xpath("(.//a[contains(text(),'Vendor Detail')])[2]")).size()==0)
				{
					logger.log(LogStatus.PASS, "Vendor Detail is removed from Custom table");
					System.out.println("Vendor Detail is removed from Custom table");
				}
	          
	          else
	          {
	        	  logger.log(LogStatus.FAIL, "Vendor Detail is not removed from Custom table");
	          }
	     
	   }
	           
	           catch(Exception e)
	           {
	                   util.screenShotAndErrorMsg(logger, e, driver, "Vendordetail");
	           }
	           extent.endTest(logger);
	           extent.flush();
	             
	    }
		
		@Test
	    public void VerifyPencilbtn_RegistrationInprogress()
	    {
	           ExtentTest logger = extent.startTest("VerifyPencilbtn_RegistrationInprogress", "VerifyPencilbtn_RegistrationInprogress");
	           try
	           {
				util.waittillpageload(logger, driver);
				util.pause(logger, "20");
				
				if(driver.findElements(By.xpath(".//span[contains(text(),'Application Information')]//following-sibling::span/i[@class='fa fa-pencil pull-right icon']")).size()==0)
				{
					logger.log(LogStatus.PASS, "Members Assignment Group user not able to click on Application info Pencil icon");
				}
				else
				{
					logger.log(LogStatus.FAIL, "Members Assignment Group user is able to click on Application info Pencil icon");
				}
					/*util.waitTillElementIsClickable(logger, driver, homepage.Appln_Pencil_btn);
					logger.log(LogStatus.INFO, "Members Assignment Group user not able to click on Application info Pencil icon");*/
				
				if(driver.findElements(By.xpath(".//span[contains(text(),'Communication')]//following-sibling::span/i[@class='fa fa-pencil pull-right icon']")).size()==0)
				{
					logger.log(LogStatus.PASS, "Members Assignment Group user not able to click on Communication Pencil icon");
				}
				else
				{
					logger.log(LogStatus.FAIL, "Members Assignment Group user is able to click on Communication Pencil icon");
				}
				
				
					/*util.waitTillElementIsClickable(logger, driver, homepage.Commu_Pencil_btn);
					logger.log(LogStatus.INFO, "Members Assignment Group user not able to click on Communication Pencil icon");
					*/
				if(driver.findElements(By.xpath(".//span[contains(text(),'Support Details')]//following-sibling::span/i[@class='fa fa-pencil pull-right icon']")).size()==0)
				{
					logger.log(LogStatus.PASS, "Members Assignment Group user not able to click on Support detail Pencil icon");
				}
				else
				{
					logger.log(LogStatus.FAIL, "Members Assignment Group user is able to click on Support detail Pencil icon");
				}
				
					/*util.waitTillElementIsClickable(logger, driver, homepage.Support_Pencil_btn);
					logger.log(LogStatus.INFO, "Members Assignment Group user not able to click on Support detail Pencil icon");*/
				if(driver.findElements(By.xpath(".//span[contains(text(),'Technology Architecture')]//following-sibling::span/i[@class='fa fa-pencil pull-right icon']")).size()==0)
				{
					logger.log(LogStatus.PASS, "Members Assignment Group user not able to click on Technology Architecture Pencil icon");
				}
				else
				{
					logger.log(LogStatus.FAIL, "Members Assignment Group user is able to click on Technology Architecture Pencil icon");
				}
					
					/*util.waitTillElementIsClickable(logger, driver, homepage.Techno_Pencil_btn);
					logger.log(LogStatus.INFO, "Members Assignment Group user not able to click on Technology Architecture Pencil icon");*/
				
				if(driver.findElements(By.xpath(".//span[contains(text(),'TCN')]//following-sibling::span/i[@class='fa fa-pencil pull-right icon']")).size()==0)
				{
					logger.log(LogStatus.PASS, "Members Assignment Group user not able to click on TCN Pencil icon");
				}
				else
				{
					logger.log(LogStatus.FAIL, "Members Assignment Group user is able to click on TCN Pencil icon");
				}
					
					/*util.waitTillElementIsClickable(logger, driver, homepage.TCN_Pencil_btn);
					logger.log(LogStatus.INFO, "Members Assignment Group user not able to click on TCN Pencil icon");*/
				
				if(driver.findElements(By.xpath(".//span[contains(text(),'Legal')]//following-sibling::span/i[@class='fa fa-pencil pull-right icon']")).size()==0)
				{
					logger.log(LogStatus.PASS, "Members Assignment Group user not able to click on Legal Pencil icon");
				}
				else
				{
					logger.log(LogStatus.FAIL, "Members Assignment Group user is able to click on Legal Pencil icon");
				}
				
					/*util.waitTillElementIsClickable(logger, driver, homepage.Legal_Pencil_btn);
					logger.log(LogStatus.INFO, "Members Assignment Group user not able to click on Legal Pencil icon");*/
				
				if(driver.findElements(By.xpath(".//div[@class='editIconDiv']/i[@class='fa fa-pencil pull-right icon']")).size()==0)
				{
					logger.log(LogStatus.PASS, "Members Assignment Group user not able to click on Primary Contacts Pencil icon");
				}
				else
				{
					logger.log(LogStatus.FAIL, "Members Assignment Group user is able to click on Primary Contacts Pencil icon");
				}
				
				/*	util.waitTillElementIsClickable(logger, driver, homepage.PrimaryCont_Pencil_btn);
					logger.log(LogStatus.INFO, "Members Assignment Group user not able to click on Primary Contacts Pencil icon");*/
	         
	           }
	           
	           catch(Exception e)
	           {
	                   util.screenShotAndErrorMsg(logger, e, driver, "VerifyPencilbtn_RegistrationInprogress");
	           }
	           extent.endTest(logger);
	           extent.flush();
	             
	    }
		
		@Test
	    //Login Method
	    public void Decomm_CancelledStatus()
	    {
	           ExtentTest logger = extent.startTest("Decomm_CancelledStatus", "Decomm_CancelledStatus");
	           try
	           {
	           
	           navigate(logger);
	           sspage = PageFactory.initElements(driver, SelfServicePage.class);
	           loginPage = PageFactory.initElements(driver, LoginPage.class);
	           username=inputData.get("Requester").get("Username").toString();
	           String pwd=inputData.get("Requester").get("Password").toString();
	           System.out.println(username + "       "+pwd);
	           
	           loginPage.login(logger,username,pwd);
	           
	          driver.navigate().to(inputData.get("navigateportal").get("URL").toString());
	          sspage = PageFactory.initElements(driver, SelfServicePage.class);
	          homepage = PageFactory.initElements(driver, HomePage.class);
	          
	          util.waittillpageload(logger, driver);
	          util.pause(logger, "20");
	          
	          //frameHelper.switchToDefaultFrame(logger, driver);
	          
	          if(homepage.ViewAllLink.isDisplayed()==true){
	  			util.clickOn(logger, homepage.ViewAllLink);
	  			util.pause(logger, "5");
	  			}
	          
	          if(driver.findElements(By.xpath(".//b[contains(text(),'Decommissioned')]")).size()==0)
	          {
	        	  logger.log(LogStatus.PASS, "Registration Status = Decommissioned, not displayed in card view");
	          }
	          else
	          {
	        	  logger.log(LogStatus.FAIL, "Registration Status = Decommissioned, displayed in card view");
	          }
	          
	          if(driver.findElements(By.xpath(".//b[contains(text(),'Registration Cancelled')]")).size()==0)
	          {
	        	  logger.log(LogStatus.PASS, "Registration Status = Registration Cancelled, not displayed in card view");
	          }
	          else
	          {
	        	  logger.log(LogStatus.FAIL, "Registration Status = Registration Cancelled, displayed in card view");
	          }
	          util.pause(logger, "5");
	          util.clickOn(logger, homepage.ListViewIcon);
	          util.pause(logger, "5");
	          
	          if(driver.findElements(By.xpath(".//td[contains(text(),'Decommissioned')]")).size()==0)
	          {
	        	  logger.log(LogStatus.PASS, "Registration Status = Decommissioned, not displayed in List view");
	          }
	          else
	          {
	        	  logger.log(LogStatus.FAIL, "Registration Status = Decommissioned, displayed in List view");
	          }
	          
	          if(driver.findElements(By.xpath(".//td[contains(text(),'Registration Cancelled')]")).size()==0)
	          {
	        	  logger.log(LogStatus.PASS, "Registration Status = Registration Cancelled, not displayed in List view");
	          }
	          else
	          {
	        	  logger.log(LogStatus.FAIL, "Registration Status = Registration Cancelled, displayed in List view");
	          }
	             
	     
	   }
	           
	           catch(Exception e)
	           {
	                   util.screenShotAndErrorMsg(logger, e, driver, "Decomm_CancelledStatus");
	           }
	           extent.endTest(logger);
	           extent.flush();
	             
	    }
		
		@Test
		public void MySurveyListview_cardview(){
			
			ExtentTest logger = extent.startTest("CreateSurvey", "CreateSurvey");
			
			try{
				
				navigate(logger);
		           sspage = PageFactory.initElements(driver, SelfServicePage.class);
		           loginPage = PageFactory.initElements(driver, LoginPage.class);
		           surveypage = PageFactory.initElements(driver, SurveyPage.class);
		           username=inputData.get("Mysurveyuser").get("Username").toString();
		           String pwd=inputData.get("Mysurveyuser").get("Password").toString();
		           System.out.println(username + "       "+pwd);
		           
		           loginPage.login(logger,username,pwd);
		           
		           driver.navigate().to(inputData.get("navigateportal").get("URL").toString());
		           homepage = PageFactory.initElements(driver, HomePage.class);
					
					util.waittillpageload(logger, driver);
					util.pause(logger, "15");
					
					util.verifyElementByXpath(logger, homepage.Aboutus);
					logger.log(LogStatus.INFO, "About Us header verified");	
		           
					util.verifyElementByXpath(logger, homepage.MyActivities);
					util.waitTillElementIsClickable(logger, driver, homepage.MyActivities);
					
					util.clickByJavascriptExecutor(logger, driver, homepage.MyActivities);
					//util.clickOn(logger, homepage.MyActivities);
					util.pause(logger, "10");
							
					util.verifyElementByXpath(logger, homepage.MyApplication);
					logger.log(LogStatus.INFO, "My Application header verified");	
					
					util.verifyElementByXpath(logger, homepage.Search_Reports);
					logger.log(LogStatus.INFO, "Search/Reports header verified");
					
					util.verifyElementByXpath(logger, homepage.Surveys);
					logger.log(LogStatus.INFO, "Surveys header verified");
					
					util.clickOn(logger, homepage.Surveys);
					util.waittillpageload(logger, driver);
					util.pause(logger, "10");
					
		        homepage = PageFactory.initElements(driver, HomePage.class);
		        surveypage = PageFactory.initElements(driver, SurveyPage.class);
		        util.waittillpageload(logger, driver);
		        util.pause(logger, "5");
		        
		        util.verifyElementByXpath(logger, homepage.CardViewIcon);
		        util.clickOn(logger, homepage.CardViewIcon);
		           util.pause(logger, "2");
		           
		           List<WebElement> list = driver.findElements(By.xpath("//div[@class='grid-item item-category']"));
		           
		           if(list.size()<=8){
		        	  
		        	   System.out.println("The Total number of Cards are less than or equal to 8");
		        	   logger.log(LogStatus.PASS, "The Total number of Cards are less than or equal to 8");
		           }
		           
		           else{
		        	   
		        	   System.out.println("Total Number of cards are more than 8: "+list.size());
		        	   logger.log(LogStatus.FAIL, "Total Number of cards are more than 8: "+list.size());
		           }
		           
		           if(homepage.ViewAllLink.isDisplayed()==true){
		   			util.clickOn(logger, homepage.ViewAllLink);
		   			util.pause(logger, "5");
		   			}
		           
		          /* util.clickOn(logger, homepage.ViewAllLink);
		           util.pause(logger, "5");*/
		           
		           list = driver.findElements(By.xpath("//div[@class='grid-item item-category']"));
		           
		           if(list.size()>8){
		        	  
		        	   System.out.println("The Total number of Cards are greater than 8"); 
		        	   logger.log(LogStatus.PASS, "The Total number of Cards are greater than 8");
		           }
		           
		           else{
		        	   
		        	   System.out.println("Total Number cards are: "+list.size());
		        	   logger.log(LogStatus.FAIL, "Total Number cards are: "+list.size());
		           }
		           
		           /*List<WebElement> list1= driver.findElements(By.xpath(".//th[@class='ng-binding ng-scope']"));
		           System.out.println(list1.size());			
					for (int m=0; m<list1.size(); m++){
						String SearchResult = list1.get(m).getText();				
		    			System.out.println(SearchResult);
		    			logger.log(LogStatus.INFO, "View List Columns displayed");
		    			}*/
		           
		          util.pause(logger, "5");
		          util.verifyElementByXpath(logger, homepage.ListViewIcon);
		          util.clickOn(logger, homepage.ListViewIcon);
		          util.waittillpageload(logger, driver);
		          util.pause(logger, "5");
		          util.verifyElementByXpath(logger, homepage.ListSurvey_SurveyName);
		          logger.log(LogStatus.INFO, "Survey Name column present in My survey List view");
		          util.verifyElementByXpath(logger, homepage.ListSurvey_ApplnName);
		          logger.log(LogStatus.INFO, "Application Name column present in My survey List view");
		          util.verifyElementByXpath(logger, homepage.ListSurvey_Expiry);
		          logger.log(LogStatus.INFO, "Expiry column present in My survey List view");
			}
		
			catch(Exception e)
	        {
	                util.screenShotAndErrorMsg(logger, e, driver, "CreateSurvey");
	                e.printStackTrace();
	        }
	        extent.endTest(logger);
	        extent.flush();	
		}	
		
		
}
//Testing