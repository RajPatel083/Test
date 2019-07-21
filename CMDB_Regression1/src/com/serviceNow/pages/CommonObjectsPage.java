/**
 * 
 */
package com.serviceNow.pages;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.serviceNow.util.FrameHelper;

/**
 * @author k.narasimha.swamy
 *
 */
public class CommonObjectsPage extends BasePage 
{


	
	String ParentHandle="";
	Calendar cal = Calendar.getInstance();
	
	@FindBy(id="gsft_main") public WebElement gsft_main;
	
	@FindBy(xpath="(//iframe[contains(@src,'email_display')])[1]") public WebElement iframe_mail;
	
	@FindBy(xpath=".//*[text()='Creative Service Request']") public WebElement lnk_creativeServiceRequest;
	
	@FindBy(xpath="(.//a[text()='Data Privacy Policy 90'])[1]") public WebElement lnk_dataPrivacyPolicy;
	
	@FindBy(xpath=".//button[text()='Accept']") public WebElement btn_accept;
	
	@FindBy(xpath="//button[@id='cancel_facilities_request']") public WebElement btn_cancel;
	
	@FindBy(xpath=".//button[text()='Order Now']")public WebElement btn_orderNow;
	
	@FindBy(xpath=".//*[contains(@id,'DateTimePicker')]//*[text()='Go to Today']")
	public WebElement lnk_goToToday;
	
	@FindBy(xpath=".//*[@id='GwtDateTimePicker_ok']")
	public WebElement lnk_selectDate;
	
	@FindBy(xpath=".//*[contains(@id,'GwtDateTimePicker_day39')]") public WebElement lnk_lastButTwoDate;
	
	@FindBy(xpath=".//*[contains(@id,'GwtDateTimePicker_day40')]") public WebElement lnk_lastButOneDate;
	
	@FindBy(xpath=".//*[contains(@id,'GwtDateTimePicker_day41')]") public WebElement lnk_lastDate;
	
	@FindBy(xpath="(.//*[text()='Submit'])[1]") public WebElement btn_submit;
	
	@FindBy(xpath=".//button[@id='cntSub_submit_button']")
	public WebElement btn_submitSupportReq;
	
	@FindBy(xpath="//button[@id='readyForWork']") public WebElement btn_readyForWork;
	
	@FindBy(xpath="//button[@id='startWork']") public WebElement btn_startWork;
	
	@FindBy(xpath="//input[contains(@id,'facilities_request.u_category') and not(@type='hidden')]") public WebElement  txt_category;
	
	@FindBy(xpath="//button[@id='ok_button']") public WebElement btn_ok;
	
	@FindBy(xpath="//div[@id='output_messages']//button") public WebElement btn_closeErrorMessages;
	
	@FindBy(xpath=".//select[@id='sys_readonly.facilities_request.state']") public WebElement drpDn_reqState;
	
	
	@FindBy(xpath="(.//button[contains(text(),'Update')])[1]") public WebElement btn_update;
	
	@FindBy(xpath="//button[@id='reopen']") public WebElement btn_reOpen;

	@FindBy(xpath="(.//tbody//tr[1]//td[3]//a[@class='glide_ref_item_link'])[1]")
	public WebElement lnk_firstInTable;
	
	@FindBy(xpath=".//input[@class='form-control']") WebElement txt_search;
	
	@FindBy (xpath=".//*[@id='sys_readonly.hr_case.number']") public WebElement txt_number;
	
	@FindBy(xpath=".//select[@class='form-control']") public WebElement drpDn_selectSearch;

	@FindBy(xpath="//a[contains(@id,'filter_toggle_image')]") public WebElement btn_filter;
	
	@FindBy(xpath="(.//button[text()='AND'])[1]") public WebElement btn_and;
	
	
	
	//@FindBy(xpath="(.//select[@title='Choose Input'])[last()-1]") public WebElement drpDn_filterField;
	@FindBy(xpath=".//*[contains(text(),'choose field')]/ancestor::select[@title='Choose Input']") public WebElement drpDn_filterField;
	
	//@FindBy(xpath="(.//select[@title='choose operator'])[last()-1]") public WebElement drpDn_filterOperator;
	//@FindBy(xpath=".//*[contains(text(),'choose field')]/ancestor::td[2]//select[@title='choose operator']") public WebElement drpDn_filterOperator;
	@FindBy(xpath="(.//*[contains(text(),'choose field')]/ancestor::tr[1]/td[3]//select)[last()]") public WebElement drpDn_filterOperator;
			
			
			
			
	//@FindBy(xpath=".//*[contains(text(),'choose field')]/ancestor::td[2]//input[@title='input value']") public WebElement txt_filterValue;
	//@FindBy(xpath="(.//*[contains(text(),'choose field')]/ancestor::tr[1]/td[4]//input)[last()-1]") public WebElement txt_filterValue;
	@FindBy(xpath="(//td[@id='value']/ancestor::tr[1])[last()]//td[@id='value']//input[not(@type='hidden')]") public WebElement txt_filterValue;
	
	//@FindBy(xpath="(.//select[@title='choose operator'])[last()-1]/ancestor::td[1]/following-sibling::td//select") public WebElement drpDn_filterValue;
	//@FindBy(xpath=".//*[contains(text(),'choose field')]/ancestor::td[1]/following-sibling::td[2]//select") public WebElement drpDn_filterValue;
	//@FindBy(xpath=".//*[contains(text(),'choose field')]/ancestor::tr[1]/td[4]//select") public WebElement drpDn_filterValue;
	@FindBy(xpath="(//td[@id='value']/ancestor::tr[1])[last()]//td[@id='value']//select") public WebElement drpDn_filterValue;
	
	
	//@FindBy(xpath="(.//*[contains(text(),'choose field')]/ancestor::tr[1]/td[4]//textarea)[last()-1]") public WebElement txt_filterValueArea;
	@FindBy(xpath="(//td[@id='value']/ancestor::tr[1])[last()]//td[@id='value']//textarea") public WebElement txt_filterValueArea;
	
	@FindBy(xpath=".//*[contains(text(),'Order results')]/ancestor::table[1]//tr[2]//td[@id='field']//select") public WebElement drpDn_sortField;
	
	@FindBy(xpath=".//*[contains(text(),'Order results')]/ancestor::table[1]//tr[2]//td[@id='oper']//select") public WebElement drpDn_sortOperator;
	
	@FindBy(xpath=".//button[text()='Add Sort']") public WebElement btn_addSort;
	
	@FindBy(xpath="(.//button[text()='Run'])[1]") public WebElement btn_run;		
	
	@FindBy(xpath="//button[@id='sysverb_insert_and_stay' or @id='sysverb_update_and_stay']") public WebElement btn_save;

	@FindBy(xpath="(.//button[text()='Print'])[1]") public WebElement btn_print;
	

	
	@FindBy(xpath=".//textarea[@id='sysapproval_approver.comments']") public WebElement txt_approverComment;
	
 	@FindBy (xpath="//div[starts-with(@id,'toggleButton')]//button[contains(@class,'close')]")
	public List<WebElement> btns_expandToggle;
 	
 	@FindBy(xpath="(.//button[@id='approve'])[1]")
	WebElement  approveButton;

	@FindBy(xpath="(.//button[@id='reject'])[1]")
	WebElement  rejectButton;
	
	@FindBy(xpath=".//textarea[@id='facilities_request.work_notes']") public WebElement  txt_workNotes;
	
	
	@FindBy(xpath=".//*[@id='facilities_request.description']") public WebElement txt_description ;
	
	
	public void selectRandomValueUsingLookUpButton(ExtentTest logger, WebElement we){
		logger.log(LogStatus.INFO, "Selecting a random value from the lookup button -"+we);
		util.clickOn(logger, we);
		ParentHandle=frameHelper.getParentWindowHandle(logger, driver);
		frameHelper.switchToChildWindow(logger, driver, ParentHandle);
		util.pause(logger, "2");
		driver.manage().window().maximize();
		if(util.verifyElementByXpath(logger, lnk_firstInTable)){
			//lnk_firstInTable.click();
			util.clickOn(logger, lnk_firstInTable);
			frameHelper.switchToParentWindowHandle(logger, driver, ParentHandle);
			frameHelper.switchToFrame(logger, driver, gsft_main);
			logger.log(LogStatus.PASS, "Selected random <b>"+we+"</b> Successfuly");
		}else{
			System.out.println("No link is present in the child window for "+we);
			browserHelper.closeCurrentTab(logger, driver);
			frameHelper.switchToParentWindowHandle(logger, driver, ParentHandle);
			frameHelper.switchToFrame(logger, driver, gsft_main);
			logger.log(LogStatus.FAIL, "No link is present in the child window for <b> "+we+"</b> ");
			util.showScreenShotInLogger(logger, driver, "selectRandomValueUsingLookUpButton-Failed");
		}
		
	}
	
	
	
	
	public void enterCategory(ExtentTest logger, String level0, String level1, String level2){
		String path;
		try{
			
			if(level1==null||level1.equals("")){
				path=level0;
			}else if(level2==null||level2.equals("")){
				path=level0+" > "+level1;
			}else{
				path=level0+" > "+level1+" > "+level2;
			}
			util.setTextWithEnter(logger, txt_category, path);
			util.setText(logger, txt_additionalComments, "");
			util.pause(logger, "5");
		
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "enterCategory");
			logger.log(LogStatus.FAIL,  "Unable to enter category path due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
		
	}
	
	
	public void expandAllSections(ExtentTest logger){
		try{
			logger.log(LogStatus.INFO, "Expanding all the available setions in the create form");
			util.clickAllElementsFromList(logger, btns_expandToggle);
			
		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "expandAllSections");
			logger.log(LogStatus.FAIL,  "Following error encountered while Expanding all the available setions in the create form :::: <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
			
		}
	}
	

	/**
	 * @param driver
	 */
	public CommonObjectsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/************************Package 3 additions*****************************/
	
	@FindBy(xpath="//input[contains(@id,'request.assignment_group') and not(@type='hidden')]") public WebElement  txt_assignmentGroup;
	
	@FindBy(xpath="//input[contains(@id,'request.assigned_to') and not(@type='hidden')]") public WebElement  txt_assignedTo;
	
	@FindBy (xpath=".//input[contains(@id,'.number') or contains(@id,'_number')]") public WebElement txt_reqnumber;
	
	@FindBy(xpath="//textarea[contains(@id,'request.comments')]") public WebElement txt_additionalComments;
	
	
	
	public void selectGivenValueUsingLookUpButton(ExtentTest logger, WebElement we, String option){
		try{
			logger.log(LogStatus.INFO, "Selecting a value -'"+option+"' from the lookup button -"+we);
			 ParentHandle=frameHelper.getParentWindowHandle(logger, driver);
			util.clickOn(logger, we);
			frameHelper.switchToChildWindow(logger, driver, ParentHandle);
			util.pause(logger, "2");
			driver.manage().window().maximize();
				if(util.verifyElementByXpath(logger, lnk_firstInTable)){
					//util.selectBoxByValue(logger, drpDn_selectSearch, "for text");
					txt_search.sendKeys(option+Keys.ENTER);
					util.pause(logger, "2");
					if(util.verifyElementByXpath(logger, driver.findElement(ByXPath.xpath(".//*[contains(text(),'"+option+"')]/preceding-sibling::td//a")))){
						driver.findElement(ByXPath.xpath(".//*[contains(text(),'"+option+"')]/preceding-sibling::td//a")).click();
						frameHelper.switchToParentWindowHandle(logger, driver, ParentHandle);
						//FrameHelper.switchToDefaultFrame(logger, driver);
						frameHelper.switchToFrame(logger, driver, gsft_main);
						logger.log(LogStatus.PASS, "Selected "+option+" under <b>"+we+"</b> Successfuly");
						util.pause(logger, "3");
					}else if(util.verifyElementByXpath(logger, driver.findElement(By.xpath("//a[text()='"+option.trim()+"']")))){
					driver.findElement(By.xpath("//a[text()='"+option+"']")).click();
					frameHelper.switchToParentWindowHandle(logger, driver, ParentHandle);
					//FrameHelper.switchToDefaultFrame(logger, driver);
					frameHelper.switchToFrame(logger, driver, gsft_main);
					logger.log(LogStatus.PASS, "Selected "+option+" under <b>"+we+"</b> Successfuly");
					util.pause(logger, "3");
					}else{
						browserHelper.closeCurrentTab(logger, driver);
						frameHelper.switchToParentWindowHandle(logger, driver, ParentHandle);
						//FrameHelper.switchToDefaultFrame(logger, driver);
						frameHelper.switchToFrame(logger, driver, gsft_main);
						logger.log(LogStatus.FAIL, "No Link has either Name or Email as the specified option in the child window for <b> "+we+"</b> Please check Cases and INtervals in the input option ");
					}
					
					
				}else{
					System.out.println("No link is present in the child window for "+we);
					browserHelper.closeCurrentTab(logger, driver);
					frameHelper.switchToParentWindowHandle(logger, driver, ParentHandle);
					//FrameHelper.switchToDefaultFrame(logger, driver);
					frameHelper.switchToFrame(logger, driver, gsft_main);
					logger.log(LogStatus.FAIL, "No link is present in the child window for <b> "+we+"</b> ");
				}

		}catch(Exception e){
			e.printStackTrace();
			util.screenShotAndErrorMsg(logger, e, driver, "selectGivenValueUsingLookUpButton");
			logger.log(LogStatus.FAIL,  "Unable to select option under given lookup  due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
		}
	}
	
}
