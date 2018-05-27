package TestNG;
//http://professional.demo.orangehrmlive.com/
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ExcelDemo {
	
	//File FRead; -----------to avoid selenium confusion for read write
	FileInputStream FRead;
	FileOutputStream FWrite;
	WebDriver driver;
	XSSFWorkbook wb;
	XSSFSheet sh;
	String d1,d2;
	String login,pwd,webmsg,xlmsg,wbstatus;
	
	
	
  @BeforeMethod
  public void beforeMethod() {
	  
	  login=sh.getRow(1).getCell(0).getStringCellValue();
	  pwd=sh.getRow(1).getCell(1).getStringCellValue();
	  xlmsg=sh.getRow(1).getCell(2).getStringCellValue();
	  
			  
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	  driver.findElement(By.id("welcome")).click();
	  Thread.sleep(200);
	  driver.findElement(By.linkText("Logout")).click();
	  
	  FWrite = new FileOutputStream("C:\\\\Users\\\\Training_m5c.05.30\\\\eclipse-workspace\\\\SeleniumDemo\\\\src\\\\test\\\\java\\\\RWExcel.xlsx");
	  sh.getRow(1).createCell(3).setCellValue(webmsg);
	  sh.getRow(1).createCell(4).setCellValue(wbstatus);
	  wb.write(FWrite);
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() throws Exception, Exception {
	  
	  System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
	  driver = new ChromeDriver();	
	  driver.get("http://professional.demo.orangehrmlive.com/");
	  FRead = new FileInputStream ("C:\\Users\\Training_m5c.05.30\\eclipse-workspace\\SeleniumDemo\\src\\test\\java\\RWExcel.xlsx");
	  
	  wb = new XSSFWorkbook(FRead);
	  sh = wb.getSheetAt(0);
	  
	  d1 = sh.getRow(0).getCell(0).getStringCellValue();
	  d2 = sh.getRow(0).getCell(1).getStringCellValue();
	  
  }

  @Test
  public void ReadWrite() throws Exception {
	  
	  //System.out.println(d1);
	  //System.out.println(d2);
	  driver.findElement(By.id("txtUsername")).sendKeys(login);
	  driver.findElement(By.id("txtPassword")).sendKeys(pwd);
	  driver.findElement(By.id("btnLogin")).click();
	  Thread.sleep(1000);
	  webmsg=driver.findElement(By.id("welcome")).getText();
	  
	  	System.out.println("Uid="+login);
	  	System.out.println("Pwd="+pwd);
	  	System.out.println("Webmsg="+webmsg);
	  	
	  	
	  	if (webmsg.equals(xlmsg))	{
	  	wbstatus="Test Pass"	;
	  	}
	  	else {
	  		wbstatus="Test Fail";
	  	}
  }
  @AfterTest
  public void afterTest() throws Exception {
	  
	  driver.close();
	  wb.close();
	  
	  
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
