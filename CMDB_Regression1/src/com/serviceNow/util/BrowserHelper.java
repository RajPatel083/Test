/**
* 
 */
package com.serviceNow.util;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
* @author k.narasimha.swamy
*
*/
public class BrowserHelper {

              public  WebDriver driver;
              
              public List <WebDriver> driversList= new LinkedList<WebDriver>();
              /**
              * This method will open New Browser based on broswerName Parameter
              * @param browserName
              * @return WebDriver
              * @author k.narasimha.swamy
              */
              public WebDriver startBrowser(ExtentTest logger,String browserName)
              {
                             try
                             {
                                           if(browserName.equalsIgnoreCase("chrome"))
                                           {                           
                                                          System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                             HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                             chromePrefs.put("profile.default_content_settings.popups", 0);
                             ChromeOptions options = new ChromeOptions();
                             options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
                             options.setExperimentalOption("prefs", chromePrefs);
                           //options.addExtensions(new File(System.getProperty("user.dir") + "\\symantec.crx"));
                             DesiredCapabilities cap = DesiredCapabilities.chrome();
                             cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                             cap.setCapability(ChromeOptions.CAPABILITY, options);
                             cap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true); 
                             driver = new ChromeDriver(cap);
                            /* SessionId session = ((ChromeDriver)driver).getSessionId();
                             sessionList.add(session);
                             System.out.println(session);*/
                             driver.manage().deleteAllCookies(); 
                             driver.manage().window().maximize();
                                           
                                               //PageFactory.initElements(driver, this);
                                               logger.log(LogStatus.PASS,  "<b>Chrome </b>browser is started ");           
                                               
                                           }
                                           else if(browserName.equalsIgnoreCase("firefox"))                             
                                           {
                                                          FirefoxBinary binary = new FirefoxBinary();  
                                                           File firefoxProfileFolder = new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); 
                                                           FirefoxProfile profile = new FirefoxProfile(firefoxProfileFolder);
                                                          profile.setAcceptUntrustedCertificates(true);
                                                          driver = new FirefoxDriver(binary, profile);
                                           
                                                          logger.log(LogStatus.PASS, "HTML", "<b>Firefox </b>browser is started ");    
                                           }
                                           else if(browserName.equalsIgnoreCase("ie")){
                                                          driver = new InternetExplorerDriver();
                                           
                                                          logger.log(LogStatus.PASS, "HTML", "<b>IE </b>browser is started ");           
                                           }
                                           
                                 //************************
                                 System.out.println("Browser Id :::" + driver);
                                 driversList.add(driver);
                                 //*******************************
                                           
                                           
                                           driver.manage().window().maximize();
                                           
                                           logger.log(LogStatus.PASS, "Browser is maximized ");              
                             
                                           return driver;
                             }
                             catch(Exception e)
                             {
                                           e.printStackTrace();
                                           
                                           logger.log(LogStatus.FAIL,  "Failed to lunch browser due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");              
                                           
                                           return null;

                             }
                             
              }
              
              /**
              * This method will used to navigate to given URL
              * @param url
              * @author k.narasimha.swamy
              */
              
              public  void navigate(ExtentTest logger,String url)
              {
                             try
                             {                                          
                                           driver.navigate().to(url);
                                           logger.log(LogStatus.PASS,  "Navigating to <b>"+url+"</b>");
                                           
                             }
                             catch(Exception e)
                             {
                                           e.printStackTrace();
                                           logger.log(LogStatus.FAIL,  "Failed to Navigate <b>"+url+"</b> due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");                           
                             }
              }
              
              /**
              * This method will used to Close Browser
              * @param driver
              * @author k.narasimha.swamy
              */
              public  void closeBrowser(ExtentTest logger, WebDriver driver)
              {

                             try 
                             {
                                           driver.quit();
                                           logger.log(LogStatus.PASS, "Browser closed");
                             
                             } 
                             catch (Exception e)
                             {
                                           e.printStackTrace();
                                           logger.log(LogStatus.FAIL,  "Unable to close Browser due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
                             }
              }
              
              /**
              * This method for Closing Current Tab
              * @author k.narasimha.swamy
              * @param logger
              * @param driver
              */
              public  void closeCurrentTab(ExtentTest logger,WebDriver driver)
              {
                             try {
                                     driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
                                     logger.log(LogStatus.PASS, "Current Tab is closed.");
                                     Thread.sleep(5000L);
                                  }
                             catch (Exception e) 
                              {
                                           e.printStackTrace();
                                           logger.log(LogStatus.FAIL,  "Unable to close Browser due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
                             }
              }  
              
              
              /**
              * This method for Opening New Tab
              * @author k.narasimha.swamy
              * @param logger
              * @param driver
              */
              public  void openNewTab(ExtentTest logger,WebDriver driver)
              {
                             try {
                                     driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
                                     logger.log(LogStatus.PASS, "Opening new tab .");
                                     Thread.sleep(5000L);
                                  }
                             catch (Exception e) 
                              {
                                           e.printStackTrace();
                                           logger.log(LogStatus.FAIL,  "Unable to open new tab due to <b style='color:red'>"+e.getClass()+"<br>"+e.getMessage()+"</b>");
                             }
              }  


}

