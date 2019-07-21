package com.serviceNow.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
	

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath=".//iframe[contains(@ng-src,'27351372dbdcdb04e5e354545e961937')]")
	public WebElement Techno_frame;
	
	@FindBy(xpath="(.//div[@class='modal-body']/p)[2]")
	public WebElement Techno_Popup_msg;
	
	@FindBy(xpath="(.//button[@class='btn'])[2]")
	public WebElement Techno_Popup_msg_Close_btn;
	
	@FindBy(xpath=".//button[@class='btn btn-default ok-btn']")
	public WebElement Techno_Close_btn;
	
	@FindBy(xpath = ".//i[@class='fa fa-plus pull-right icon']")
	public WebElement Plus_icon;
		
	@FindBy(xpath = ".//input[contains(@id,'2e163ae1db630784f945f9a41d961976')][not(@type='hidden')]")
	public WebElement Company;
	
	@FindBy(xpath = ".//select[contains(@id,'e4b6ba25db630784f945f9a41d9619e1')]")
	public WebElement OperationalStatus;
	
	@FindBy(xpath = ".//input[contains(@id,'e6687a29db630784f945f9a41d961985')][not(@type='hidden')]")
	public WebElement MaintenanceSchedule;
	
	@FindBy(xpath = ".//input[contains(@id,'48d87a69db630784f945f9a41d9619b9')][not(@type='hidden')]")
	public WebElement Location;
	
	@FindBy(xpath = ".//button[@id='IO:02ef2229db230784f945f9a41d96197e_unlock']/span[@class='icon icon-locked']")
	public WebElement SN_Assignmentgroup_Icon;
	
	@FindBy(xpath = ".//input[contains(@id,'02ef2229db230784f945f9a41d96197e')][not(@type='HIDDEN')]")
	public WebElement SN_Assignmentgroup;
	
	@FindBy(xpath = ".//input[contains(@id,'7780b269db230784f945f9a41d961907')][@class='cat_item_option sc-content-pad form-control']")
	public WebElement Acronym;
	
	@FindBy(xpath = ".//select[contains(@id,'77dafe6ddb630784f945f9a41d9619b9')]")
	public WebElement ReportingEntity;
	
	@FindBy(xpath = ".//input[contains(@id,'9a3b7eaddb630784f945f9a41d961970')][@class='cat_item_option questionsettext form-control text-align-right-ltr element_reference_input']")
	public WebElement First_go_live_date;
	
	@FindBy(xpath = "//input[contains(@id,'12d2436ddba30784f945f9a41d96193f')][not(@type='hidden')]")
	public WebElement Reg_Program_Mgr;
	
	@FindBy(xpath = ".//input[contains(@id,'ae420fe9dba30784f945f9a41d961964')][not(@type='hidden')]")
	public WebElement Reg_AIMProgID_Input;
	
	@FindBy(xpath = ".//a[contains(@id,'a66fb2e5dba30784f945f9a41d961919')]/span[@class='icon icon-search']")
	public WebElement AIMServiceOpsIDLookSearch;
	
	@FindBy (xpath = "//input[@class='form-control'and @placeholder = 'Search']")
	public WebElement AIMServiceOpsIDinput;// Project id = 28908
	
	@FindBy(xpath = "(//a[@class='glide_ref_item_link'])[1]")
	public WebElement SelectAIMServiceOpsID;//Project id = 28908 (need to do indexing)
	
	@FindBy(xpath = ".//input[contains(@id,'82bf3ae5dba30784f945f9a41d9619fa')][not(@type='hidden')]")
	public WebElement ServiceOpsMD;
	
	@FindBy(xpath = ".//input[contains(@id,'40104329dba30784f945f9a41d9619cf')][not(@type='hidden')]")
	public WebElement ServiceOpsManager;
	
	@FindBy(xpath = ".//select[contains(@id,'ad60cb29dba30784f945f9a41d961943')][not(@type='hidden')]")
	public WebElement ServiceOpsPortfolio;
	
	@FindBy(xpath = ".//input[contains(@id,'16f143e9dba30784f945f9a41d9619d8')][not(@type='hidden')]")
	public WebElement ServiceOpsLead;
	
	@FindBy(xpath = ".//select[contains(@id,'f413876ddba30784f945f9a41d9619be')][not(@type='hidden')]")
	public WebElement ProgramPortfolio;
	
	@FindBy(xpath = ".//input[contains(@id,'7357875dbab4784f945f9a41d96198e')][not(@type='HIDDEN')]")
	public WebElement Operational_supp_email;
	
	@FindBy(xpath = ".//textarea[contains(@id,'2dc3b8f1dbab4784f945f9a41d961940')]")
	public WebElement SpecialContactInstruction;
	
	@FindBy(xpath = ".//input[contains(@id,'eaf205b5dbeb4784f945f9a41d961918')][not(@type='HIDDEN')]")
	public WebElement WorkNumber;
	
	@FindBy(xpath = ".//input[contains(@id,'9bb5347ddb6b4784f945f9a41d961928')][not(@type='HIDDEN')]")
	public WebElement P1Contact;
	
	@FindBy(xpath = ".//input[contains(@id,'6f46bc75dbab4784f945f9a41d961935')][not(@type='HIDDEN')]")
	public WebElement P2Contact;
	
	@FindBy(xpath = ".//input[contains(@id,'0b23c9b5dbeb4784f945f9a41d961985')][not(@type='hidden')]")
	public WebElement OverallCapababilityMD;
	
	@FindBy(xpath = ".//input[contains(@id,'b07389b5dbeb4784f945f9a41d96199e')][not(@type='hidden')]")
	public WebElement TechArchLead;
	
	@FindBy(xpath = ".//input[contains(@id,'18b489b5dbeb4784f945f9a41d9619ab')][not(@type='hidden')]")
	public WebElement DBDelManager;
	
	@FindBy(xpath = ".//input[contains(@id, 'eb15c9b5dbeb4784f945f9a41d9619d3')][not(@type='hidden')]")
	public WebElement SecDeploymentMgr;
	
	@FindBy(xpath = ".//select[contains(@id, '70260d39dbeb4784f945f9a41d961970')][not(@type='hidden')]")
	public WebElement SOHManagementAppl;
		
	@FindBy(xpath = ".//input[contains(@id,'dc48fc3ddb6b4784f945f9a41d96196b')][not(@type='HIDDEN')]")
	public WebElement PrimaryEmergencyContactName;
	
	@FindBy(xpath = ".//input[contains(@id,'f8f9f4f5dbab4784f945f9a41d9619ea')][not(@type='HIDDEN')]")
	public WebElement PrimaryContactNum;
	
	@FindBy(xpath = ".//input[contains(@id,'247189f1dbeb4784f945f9a41d9619a6')][not(@type='HIDDEN')]")
	public WebElement PrimaryWorkNum;
	
	@FindBy(xpath = ".//input[contains(@id, 'f4b6c539dbeb4784f945f9a41d9619f9')][not(@type='HIDDEN')]")
	public WebElement NextplanDisasteRecoTest;
	
	@FindBy(xpath = ".//input[contains(@id, 'ae07b0b5dbab4784f945f9a41d9619fc')][not(@type='HIDDEN')]")
	public WebElement Chat_SkypeID;
	
	@FindBy(xpath = ".//input[contains(@id, 'cfe8bcf5dbab4784f945f9a41d9619a3')][not(@type='HIDDEN')]")
	public WebElement Sec_emer_Cont_Name;
	
	@FindBy(xpath = ".//input[contains(@id, 'c6a1c5b9dbab4784f945f9a41d9619ee')][not(@type='HIDDEN')]")
	public WebElement Sec_Cont_Number;
	
	@FindBy(xpath = ".//input[contains(@id, '75a28979dbab4784f945f9a41d96190d')][not(@type='HIDDEN')]")
	public WebElement Sec_Work_Number;
	
	@FindBy(xpath = ".//input[contains(@id, '4a893439dbab4784f945f9a41d9619c1')][not(@type='HIDDEN')]")
	public WebElement Tertiary_Emer_Cont_Name;
	
	@FindBy(xpath = ".//input[contains(@id, '6dd24979dbab4784f945f9a41d9619fc')][not(@type='HIDDEN')]")
	public WebElement Tertiary_Cont_Number;
	
	@FindBy(xpath = ".//input[contains(@id,'26554db5dbeb4784f945f9a41d9619fa')][not(@type='hidden')]")
	public WebElement DevLead;
	
	@FindBy(xpath = ".//input[contains(@id, '26954db5dbeb4784f945f9a41d9619fe')][not(@type='hidden')]")
	public WebElement EnvironmentDelMgr;
	
	@FindBy(xpath = ".//input[contains(@id,'16d589b5dbeb4784f945f9a41d9619a5')][not(@type='hidden')]")
	public WebElement PrimaryDeplyManager;
	
	@FindBy(xpath = ".//input[contains(@id, 'cc070979dbeb4784f945f9a41d9619e6')][not(@type='HIDDEN')]")
	public WebElement Last_DisasterReco_Test;

	@FindBy(xpath = ".//input[contains(@id, '6937c579dbeb4784f945f9a41d961976')][not(@type='HIDDEN')]")
	public WebElement Internal_Oper_Supp_URL;
	
	@FindBy(xpath = ".//select[contains(@id,'81295b29dbab0784f945f9a41d96199d')][not(@type='HIDDEN')]")
	public WebElement MobCapability;
	
	@FindBy(xpath = ".//select[contains(@id,'1261eba9db6f0784f945f9a41d9619fe')][not(@type='HIDDEN')]")
	public WebElement Technology_Type;
	
	@FindBy(xpath = ".//select[contains(@id,'5c90fdfcdb499700e5e354545e961991')][not(@type='HIDDEN')]")
	public WebElement Reg_Type;
	
	@FindBy(xpath = ".//select[contains(@id,'9b546fe5dbef0784f945f9a41d9619f0')]")
	public WebElement Technology_Supplier;
	
	@FindBy(xpath = ".//input[contains(@id,'b60822aadb6bcb84f945f9a41d961937')][@class='questionsetreference form-control element_reference_input']")
	public WebElement Technology_supplier_reftype;
		
	@FindBy(xpath = ".//input[contains(@id,'6fd1f1f0db899700e5e354545e961928')][@class='questionsetreference form-control element_reference_input']")
	public WebElement Reg_Supplier;

	@FindBy(xpath = ".//select[contains(@id, '985367e1dbef0784f945f9a41d9619e8')][not(@type='HIDDEN')]")
	public WebElement Technology_Provisioning;

	@FindBy(xpath = ".//select[contains(@id,'4821bd30db899700e5e354545e9619ff')][not(@type='HIDDEN')]")
	public WebElement Reg_Provisioning;
	
	@FindBy(xpath = ".//input[contains(@id, 'c5882a2edb6bcb84f945f9a41d9619c2')][not(@type='hidden')]")
	public WebElement Technology_Product;
	
	@FindBy(xpath = ".//input[contains(@id,'94b13db0db899700e5e354545e96199d')][@class='questionsetreference form-control element_reference_input']")
	public WebElement Reg_Product;
	
	@FindBy(xpath = ".//select[contains(@id,'6a752e2edb2bcb84f945f9a41d961925')]")
	public WebElement Technology_Location;	
	
	@FindBy(xpath = ".//textarea[contains(@id, '13a5ea6edb2bcb84f945f9a41d9619dd')][not(@type='hidden')]")
	public WebElement Technology_Additional_Details;	
	
	@FindBy(xpath = ".//textarea[contains(@id, '87fe6138db499700e5e354545e961906')][not(@type='hidden')]")
	public WebElement Reg_Additional_Details;
	
	@FindBy(xpath = ".//button[@id='IO:1e03d870db551740a916d024ce96196b_unlock']/span[@class='icon icon-locked']")
	public WebElement Reg_UserInterface_Icon;
	
	@FindBy(xpath = ".//input[contains(@id,'1e03d870db551740a916d024ce96196b')][not(@type='HIDDEN')]")
	public WebElement Reg_UserInterface;
	
	@FindBy(xpath = ".//select[contains(@id,'6f045f21db6b0784f945f9a41d961908')][not(@type='HIDDEN')]")
	public WebElement ApplWebEnabled;
	
	@FindBy(xpath = ".//select[contains(@id,'eac81be9dbab0784f945f9a41d96190d')][not(@type='HIDDEN')]")
	public WebElement Appldownloaded;
	
	@FindBy(xpath = ".//select[contains(@id,'67d7bee5db630784f945f9a41d9619b7')]")
	public WebElement AFSEemployees;
	
	@FindBy(xpath = ".//select[contains(@id,'f3e63265db630784f945f9a41d96190f')]")
	public WebElement SysContainSenData;	 
	
	@FindBy(xpath = ".//select[contains(@id,'f1dbfeeddb630784f945f9a41d9619dd')]")
	public WebElement PAM_ManagedapplFighter;
	
	@FindBy(xpath = ".//select[contains(@id,'f4dcb2a1dba30784f945f9a41d961957')]")
	public WebElement PAM_ManagedapplBuiltin;
	
	@FindBy(xpath = ".//select[contains(@id,'f19fea5edbc45780dd3cf5951d96193d')]")
	public WebElement IdentifyDataRelevant;
	
	@FindBy(xpath = ".//select[contains(@id,'51ff629edbc45780dd3cf5951d96190a')]")
	public WebElement PreserveData;
	
	@FindBy(xpath = ".//select[contains(@id,'9320fa5edbc45780dd3cf5951d961933')]")
	public WebElement Archiving;
	
	@FindBy(xpath = ".//select[contains(@id,'8840ba29db230784f945f9a41d961965')]")
	public WebElement ClientOwnedData;
	
	@FindBy(xpath = ".//select[contains(@id,'7f403e9edbc45780dd3cf5951d96196b')]")
	public WebElement ContractualRights;
	
	
	@FindBy(xpath = ".//select[contains(@id,'8c1df2a1dba30784f945f9a41d9619a8')]")
	public WebElement PAM_ManagedapplID;
	
	@FindBy(xpath = ".//select[contains(@id,'7c3936a9db630784f945f9a41d96198d')][not(@type='HIDDEN')]")
	public WebElement WhoCanSeeData;
	
	@FindBy(xpath = ".//select[contains(@id,'9fc8ba69db630784f945f9a41d96198b')][not(@type='HIDDEN')]")
	public WebElement WhoUsesSys;
	
	@FindBy(xpath = ".//select[contains(@id, '6c5c7261dba30784f945f9a41d96191e')][not(@type='hidden')]")
	public WebElement PAM_Managed_temp_Admin;
	
	@FindBy(xpath = ".//input[contains(@id,'edca3e6ddb630784f945f9a41d961941')][not(@type='hidden')]")
	public WebElement CountryProdSys;
	
	@FindBy(xpath = ".//select[contains(@id, '9d28d3b1dbd81b40f945f9a41d961955')][not(@type='hidden')]")
	public WebElement AIRLegalTab;
	
	@FindBy(xpath = ".//select[contains(@id, '688e3665dba30784f945f9a41d961982')][not(@type='hidden')]")
	public WebElement Multi_factor;
	
	@FindBy(xpath = ".//select[contains(@id, 'c4ba26e9dbefc384f945f9a41d961956')][not(@type='hidden')]")
	public WebElement Sarbox;
	
	@FindBy(xpath = ".//input[contains(@id,'2b1fe148dbe78344dd3cf5951d9619e3')][not(@type='hidden')]")
	public WebElement PrimaryCommContact;
	
	@FindBy(xpath = ".//input[contains(@id,'4328f110dbe30744dd3cf5951d961955')][not(@type='HIDDEN')]")
	public WebElement EndUserSuppURL;
	
	@FindBy(xpath = ".//select[contains(@id,'7a343990dba30744dd3cf5951d961948')][not(@type='HIDDEN')]")
	public WebElement AppNotifTool;
	
/*	@FindBy(xpath = ".//select[@id='RP_ur_pri_user_grps_select_0']")
	public WebElement Available;*/
	
/*	@FindBy(xpath = ".//span[@class='icon icon-locked']")
	public WebElement Reg_PrimaryUserGroups_Icon;*/
	
	@FindBy(xpath = ".//button[@id='IO:bedb1d1edb674b84f945f9a41d961927_unlock']/span[@class='icon icon-locked']")
	public WebElement Reg_PrimaryUserGroups_Icon;
	
	@FindBy(xpath = ".//input[contains(@id,'bedb1d1edb674b84f945f9a41d961927')][not(@type='HIDDEN')]")
	public WebElement Reg_PrimaryUserGroups;
	
	@FindBy(xpath = ".//select[contains(@id, 'a0013d0cdbe78344dd3cf5951d9619c4')][not(@type='hidden')]")
	public WebElement Reg_FishingPage;

	@FindBy(xpath = ".//a[@class='btn btn-default icon-chevron-right'][not(@type='hidden')]")
	public WebElement RightArrowbtn;
	
	@FindBy(xpath = ".//input[contains(@id, '7310f1c8dbe78344dd3cf5951d961957')][not(@type='hidden')]")
	public WebElement PrimaryCommuCont_busi;

	@FindBy(xpath = ".//input[contains(@id,'2b1fe148dbe78344dd3cf5951d9619e3')][not(@type='hidden')]")
	public WebElement PrimaryCommuCont_CIO;

	@FindBy(xpath = ".//button[@id='submit_button']")
	public WebElement Submitbtn;
	
//Testing
	
	
	
	
}
