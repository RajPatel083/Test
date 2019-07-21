package com.serviceNow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UserMailPage extends BasePage {


	@FindBy(xpath=".//input[@name='UserName']") public WebElement mailID;
	
	@FindBy(xpath=".//input[@name='Password']") public WebElement mailPassword;
	
	@FindBy(xpath=".//*[@id='submitButton']") public WebElement btn_signIn;
	
	@FindBy(xpath=".//button[@aria-label='Activate Search Textbox']") public WebElement btn_searchMail;
	
	@FindBy(xpath=".//button/following-sibling::div//input") public WebElement txt_searchMail;
		
		

	@FindBy(xpath=".//*[text()='New']/ancestor::button[contains(@title,'Write a new message')]") public WebElement btn_newMail;
	
	@FindBy(xpath="(.//*[text()='Send']/ancestor::button)[1]") public WebElement btn_sendMail;
	
	@FindBy(xpath=".//*[text()='To']/ancestor::div[1]//input") public WebElement txt_mailTo;
	
	@FindBy(xpath=".//*[text()='Cc']/ancestor::div[1]//input") public WebElement txt_mailCc;
	
	//@FindBy(xpath=".//*[text()='Reply all']/ancestor::button[1]") public WebElement btn_moreActions;
	@FindBy(xpath=".//*[text()='Reply all']/ancestor::button[1]/following-sibling::button[@title='More actions']") public WebElement btn_moreActions;
	
	@FindBy(xpath=".//*[text()='Forward']/ancestor::button[1]") public WebElement btn_forwardMail;
	
	@FindBy(id="manifestLoaderFrame") public WebElement iframe_mailOptions;
	
	@FindBy(xpath=".//input[contains(@aria-label,'Subject')]") public WebElement txt_mailSubject;
	
	@FindBy(xpath=".//div[contains(@aria-label,'Message body')]") public WebElement txt_mailBody;
	
	
	
		//Constructor
		public UserMailPage(WebDriver driver) {
			super(driver);
		}
		
		
		public void loginToMail(ExtentTest logger, String uname, String userPassword)
		{
			
			try{
					util.setText(logger, mailID, uname);
					
					util.setText(logger,mailPassword, userPassword);
					
					util.clickOn(logger, btn_signIn);
					
					util.waitTillElementIsClickable(logger, driver, btn_searchMail);
					
					logger.log(LogStatus.PASS,"Login to User mailbox is successful");
					
				}
				catch(Exception e){
					e.printStackTrace();
								
				}
		}
		

		public void sendRequestCreationMail(ExtentTest logger, String to, String subject, String content)
		{
			
			try{
				
					
				util.waitTillElementIsClickable(logger, driver, btn_newMail);
				util.clickOn(logger, btn_newMail);
				
				util.pause(logger, "60");
				//sharedMailBoxPage.btn_newMail.click();
				util.setTextWithEnter(logger, txt_mailTo, to);
				
				
				logger.log(LogStatus.PASS,"Filling Suject and Mail Body");
				 driver.findElement(By.cssSelector("body")).sendKeys(Keys.TAB);
				util.pause(logger, "2");
				util.setText(logger, txt_mailSubject, subject);
				util.pause(logger, "2");
				util.setText(logger, txt_mailBody, content);
				logger.log(LogStatus.PASS,"Clicking on send button");
				util.clickOn(logger, btn_sendMail);
				util.pause(logger, "4");
				if(util.isNotDisplayed(logger, btn_newMail))
					logger.log(LogStatus.FAIL,"Mail Not sent Successfully");
				else
					logger.log(LogStatus.PASS,"Mail sent Successfully");
				util.pause(logger, "3");
			
				
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}
		
}
