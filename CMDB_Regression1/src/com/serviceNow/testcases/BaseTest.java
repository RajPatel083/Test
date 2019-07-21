
package com.serviceNow.testcases;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import com.serviceNow.util.BrowserHelper;
import com.serviceNow.util.FrameHelper;
import com.serviceNow.util.Utility;
import com.serviceNow.xls.Xls_Reader;

/**
* @author k.narasimha.swamy
*
*/

public class BaseTest {
              
              public WebDriver driver;

              public BrowserHelper browserHelper;
              public Utility util;
              public FrameHelper frameHelper;

              
              //Variables for taking Data from Excel 
              public Map<String, Map<String, String>> inputData;
              public Xls_Reader xl;
              public int startRow=1;
              public int endRow=2;
              
              //Variable for reports
              public ExtentReports extent;      
              public DateFormat dateFormat;
              public Date date;
              static String currentPath = "";
              static String suiteFolderPath = ""; 
              
              //Constructor
              public BaseTest() throws IOException
              {
                             date = new Date();
                             dateFormat = new SimpleDateFormat("ddMMyyyy-HH_mm_ss");
                             
                             //Current Project Path
                             
                             currentPath = System.getProperty("user.dir");
                             
                             //Creating Map object for storing the Excel data
                             inputData = new HashMap<String, Map<String, String>>();  
                             
                             //Creating Object for Xls_Reader\
                             //xl = new Xls_Reader(System.getProperty("user.dir")+"//Input.xlsx");
                             
                             browserHelper = new BrowserHelper(); 
                             
                             util = new Utility();
                             
                             frameHelper = new FrameHelper();
                             
                             
                             
              }
              
              /**
              * Getting data from excel and storing into Map i.e inputData 
               * @author k.narasimha.swamy
              * @param sheetName
              */
              public void getInputDataFromExcel(String testcaseName)
              {             
                             System.out.println("----------------- This is "+testcaseName+" Data Info -----------------");
                             int rowCount = xl.getRowCount("Testdata");
                             int colCount = xl.getColumnCount("Testdata");
                             System.out.println("rowcount  :"+rowCount+"  colCount  :"+colCount);
                             for(int r=0;r<=rowCount;r++)
                             {
                                                          
                                           
                                           if(xl.getCellData("Testdata", 0, r).toString().equals(testcaseName))
                                                                        {
                                                          startRow = r + 1;
                                                          System.out.println("StartRow  : "+startRow);
                                                          break;
                                                                        }
                                           
                             }
                             
                             for(int e=startRow;e<=rowCount;e++)
                             {
                                           if(xl.getCellData("Testdata", 0, e).toString().equals("End"))
                                                                        {
                                                          endRow=e-1;
                                                          System.out.println("EndRow  :"+endRow);
                                                          break;
                                                                        }
                                           
                             }
                             
                             
                             Map<String, String> testCaseValues;
                             
                             for(int row = startRow; row<=endRow; row++)
                             {
                                           
                                                          testCaseValues = new HashMap<String, String >();
                                                          
                                                                        for(int colValue = 0; colValue< colCount; colValue++)
                                                                        {
                                                                                      if(!(xl.getCellData("Testdata",colValue,row).isEmpty()))
                                                                                      {
                                                                                                     
                                                                                                    testCaseValues.put(xl.getCellData("Testdata", colValue, 1), xl.getCellData("Testdata",colValue,row));
                                                                                       }
                                                                                      
                                                                                      inputData.put(xl.getCellData("Testdata", 0, row), testCaseValues);
                                                                        }

                             }
                             
                             System.out.println("Getting input data from  "+ "Testdata"+" sheet is SUCCESS");
                             System.out.println();
                             printMap(testcaseName);           
                             
              }
              
              /**
              * This method for displaying inputData map values
              * @author k.narasimha.swamy
              * @param testcaseName
              */
              
              public void printMap(String testcaseName)
              {
                            System.out.println("*************************************** "+testcaseName +"  test case INPUT DATA *************************************** ");
                             
                             for (Map.Entry entry : inputData.entrySet()) {
                                 System.out.println(entry.getKey() + ", " + entry.getValue());
                                 System.out.println();
                             }
              
                            System.out.println("*************************************** "+testcaseName +"  test case INPUT DATA *************************************** ");
              }
              
              
              /**
              * This method for creating a new folder with Suite name
              * @author k.narasimha.swamy
              * @param suiteName
              */
              public void suiteConfig(String suiteName)
              {
                             
                                 suiteFolderPath = currentPath+"//Reports//"+suiteName+"_"+ dateFormat.format(date);
                                           //Create new Directory for Reports with SuiteName
                                 new File(suiteFolderPath).mkdir();                    
                                           
              }
              
              /**
              * This method for creating reports file and reports related configurations
              * @author k.narasimha.swamy
              * @param testName
              */
              public void reportsConfig(String testName)
              {
                             try 
                             {                                          
                                           //Extent reports creation for every test
                                           extent = new ExtentReports(suiteFolderPath+"//"+testName+"_Report_"+dateFormat.format(date)+".html",NetworkMode.ONLINE);
                                           extent.addSystemInfo("Selenium Version", "2.46");
                                           extent.addSystemInfo("Environment", "Sbox2");              
              
                             } catch (Exception e) {
                                           e.printStackTrace();
                             }
                             
              }
              
              
              public void getinputsheetname(String inputsheet)
    {
           xl = new Xls_Reader(System.getProperty("user.dir")+"//"+inputsheet);    
    }

              
              /**
              * Opening New Browser and redirecting to Specified URL
              */
              public void navigate(ExtentTest logger)
              {                           
                             driver = browserHelper.startBrowser(logger,inputData.get("navigate").get("Browser").toString());
                             
              browserHelper.navigate(logger,inputData.get("navigate").get("URL").toString());
              }
              
              public void navigatesharedmail(ExtentTest logger)
              {                           
                             driver = browserHelper.startBrowser(logger,inputData.get("navigate").get("Browser").toString());
                             
                            browserHelper.navigate(logger,inputData.get("navigate").get("EMAIL URL").toString());
              }
              
              
              public void goToSharedMailBox( ExtentTest logger){
                     
        try
        {
              //open new tab
              driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
              frameHelper.switchToChildWindow(logger, driver, frameHelper.getParentWindowHandle(logger, driver));
              
              browserHelper.navigate(logger, inputData.get("navigate").get("EMAIL URL").toString());
              System.out.println("Navigated to the shared mail URL");
  
        }
        catch (Exception e)
        {
               util.screenShotAndErrorMsg(logger, e, driver, "Login");
               
        }
} 
              
              public void navigateDSRM(ExtentTest logger)
              {                           
                             driver = browserHelper.startBrowser(logger,inputData.get("navigate").get("Browser").toString());
                             
              browserHelper.navigate(logger,inputData.get("navigate").get("URL").toString());
              }
              
              
              public void navigateapproval(ExtentTest logger)
              {                           
                             driver = browserHelper.startBrowser(logger, inputData.get("navigate").get("Browser").toString());
                             
                             browserHelper.navigate(logger, inputData.get("navigate").get("navPage").toString());
              }
              
              
              public void goToDSRMHomePage(ExtentTest logger)
              {
              browserHelper.navigate(logger,inputData.get("navigate").get("DSRMURL").toString());
              }
}


