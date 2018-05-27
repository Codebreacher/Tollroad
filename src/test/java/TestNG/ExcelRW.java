package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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

public class ExcelRW {
	WebDriver driver;
	FileInputStream Fread;
	FileOutputStream Fwrite;
	
	XSSFWorkbook wb;
	XSSFSheet sh;
	String d1,d2;
	
	String login,pwd,wbmsg,xlmsg,wbstatus;
	
	int rowcount,rowval;
	
	
	
  @Test(dataProvider = "dp")
  public void excelRW(Integer n, String s) throws Exception {
	  
	  for(rowval=1;rowval<rowcount;rowval++) {
		  
		  login = sh.getRow(rowval).getCell(0).getStringCellValue();
		  pwd = sh.getRow(rowval).getCell(1).getStringCellValue();
		  xlmsg = sh.getRow(rowval).getCell(2).getStringCellValue();
		  
		  driver.get("http://professional.demo.orangehrmlive.com/");
		  Thread.sleep(2000);
		  
		  driver.findElement(By.id("txtUsername")).sendKeys(login);
		  driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		  driver.findElement(By.id("btnLogin")).click();
		  Thread.sleep(1000);
		  wbmsg=driver.findElement(By.id("welcome")).getText();
		  
		  driver.findElement(By.id("welcome")).click();
		  Thread.sleep(200);
		  driver.findElement(By.linkText("Logout")).click();
		  
		  System.out.println(" ");
		  System.out.println(" ");
		  
		  System.out.println("Login id used is" + login);
		  System.out.println("Password id used is" + pwd);
		  System.out.println("User name is" + wbmsg);
		  
		  Fwrite = new FileOutputStream("C:\\\\Users\\\\Training_m5c.05.30\\\\eclipse-workspace\\\\SeleniumDemo\\\\src\\\\test\\\\java\\\\RWExcel.xlsx");
		  sh.getRow(rowval).createCell(3).setCellValue(wbmsg);
		  
		  if (wbmsg.equals(xlmsg)) {
			  wbstatus="test pass";
			  
		  }
		  else
		  {
			  wbstatus = "test fail";
		  }
		  
		  sh.getRow(rowval).createCell(3).setCellValue(wbstatus);
		  wb.write(Fwrite);
		  
		  
	  }
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
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
  public void beforeTest() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
	  driver = new ChromeDriver();
	  Fread = new FileInputStream("C:\\\\Users\\\\Training_m5c.05.30\\\\eclipse-workspace\\\\SeleniumDemo\\\\src\\\\test\\\\java\\\\RWExcel.xlsx");
	  
	  wb = new XSSFWorkbook(Fread);
	  sh = wb.getSheetAt(0);
	  
	  d1 = sh.getRow(0).getCell(0).getStringCellValue();
	  d2 = sh.getRow(0).getCell(1).getStringCellValue();
	  sh.getRow(0).getCTRow();
	  
	  rowcount = sh.getPhysicalNumberOfRows();
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
