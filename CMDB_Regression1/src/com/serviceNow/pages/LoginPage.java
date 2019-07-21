/**
 * 
 */
package com.serviceNow.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author k.narasimha.swamy
 *
 */
public class LoginPage extends BasePage {

	//WebElemnts 
	@FindBy(id="user_name") public  WebElement userName;
	@FindBy(xpath=".//input[@id='user_password']") WebElement password;
	@FindBy(id="sysverb_login") WebElement loginButton;
	@FindBy(xpath=".//*[@id='output_messages']/div/div") WebElement loginErrorMSG;	
	@FindBy(xpath=".//*[contains(text(),'Self')]")
	public WebElement selfService;
	
	//Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	/**
	 * This Method is used to login sand box (Sbox1)
	 * @param extent
	 * @param login
	 * @return
	 */
	public void login(ExtentTest logger, String uname, String userPassword)
	{
		
		try{
				userName.sendKeys(uname);
				logger.log(LogStatus.PASS, "Entered Uname is :<b>"+uname+"</b>");
				
				password.sendKeys(userPassword);
				logger.log(LogStatus.PASS, "Entered Password **** ");
				
				loginButton.click();
				logger.log(LogStatus.PASS, "Login button clicked");
				
			}
			catch(Exception e){
				
				util.screenShotAndErrorMsg(logger, e, driver, "login");			
			}
	}
	
	
	public boolean invalidLogin(ExtentTest logger){
		
		boolean status = util.verifyElementByXpath(logger , loginErrorMSG);
		
		return status;
		
	}
	
	
}
