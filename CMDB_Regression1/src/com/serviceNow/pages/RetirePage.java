package com.serviceNow.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RetirePage extends BasePage{

	public RetirePage(WebDriver driver) {
		super(driver);
		
	}

	//Retire Page WebElements
	
	@FindBy(xpath = "//select[contains(@id,'92385ce513ea2600380ddbf18144b0b3')]")
	public WebElement SAPCloseRelated;
	
	@FindBy(xpath = "//select[contains(@id,'ddd5106513ea2600380ddbf18144b03f')]")
	public WebElement RequestCategory;
	
	@FindBy(xpath = "//select[contains(@id,'6508d4e513ea2600380ddbf18144b08c')]")
	public WebElement TypeOfProject;
	
	@FindBy(xpath = "//select[contains(@id,'a58adca913ea2600380ddbf18144b005')]")
	public WebElement Environment;
	
	@FindBy(xpath = "//select[contains(@id,'7746d46513ea2600380ddbf18144b048')]")
	public WebElement RequestActivityType;
	
	@FindBy(xpath = "//select[contains(@id,'3c16dc2513ea2600380ddbf18144b05a')]")
	public WebElement RequestType;
	
	@FindBy(xpath = "//label[text()='Production']")
	public WebElement Production_Checkbox;
	
	@FindBy(xpath = "//label[text()='Development']")
	public WebElement Development_Checkbox;
	
	@FindBy(xpath = "//label[text()='Staging']")
	public WebElement Staging_Checkbox;
	
	@FindBy(xpath = "//label[text()='Test']")
	public WebElement Test_Checkbox;
	
	@FindBy(xpath = "//label[text()='Sandbox']")
	public WebElement Sandbox_Checkbox;
	
	@FindBy(xpath = "//label[text()='Tech Arch']")
	public WebElement TechArch_Checkbox;
	
	@FindBy(xpath = "//label[text()='Performance']")
	public WebElement Performance_Checkbox;
	
	@FindBy(xpath = "//label[text()='Training']")
	public WebElement Training_Checkbox;
	
	@FindBy(xpath = ".//input[contains(@id,'a8685ce513ea2600380ddbf18144b01a')][not(@type='HIDDEN')]")
	public WebElement RequestStartDate;
	
	@FindBy(xpath = ".//input[contains(@id,'ab7898e513ea2600380ddbf18144b042')][not(@type='HIDDEN')]")
	public WebElement RequestEndDate;
	
	@FindBy(xpath = "//input[contains(@id,'3e61f75f136aa6001b2730128144b08e')][not(@type='HIDDEN')]")
	public WebElement WBSECollector;
	
	@FindBy(xpath = "//select[contains(@id,'3b98142913ea2600380ddbf18144b0a7')]")
	public WebElement RequestPriority;
	
	@FindBy(xpath = "//textarea[contains(@id,'67fa7eb613fea200380ddbf18144b0fc')]")
	public WebElement LongDesc;
	
	@FindBy(xpath = "//input[@id='IO:d8b790e513ea2600380ddbf18144b0ca'][not(@type='HIDDEN')]")
	public WebElement ShortDesc;
	
	@FindBy(xpath = "//button[@id='order_now']")
	public WebElement Submit_Retire_btn;
	
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	public WebElement Yes_btn;

	@FindBy(xpath = "//button[contains(text(),'No')]")
	public WebElement No_btn;
	
}
//Testing