package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ParameterDemo {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void crmLogin(String un, String pd) throws Exception {
	  driver.findElement(By.id("txtUsername")).sendKeys(un);
	  driver.findElement(By.id("txtPassword")).sendKeys(pd);
	  driver.findElement(By.id("btnLogin")).click();
	  driver.findElement(By.id("welcome")).click();
	  Thread.sleep(100);
	  driver.findElement(By.linkText("Logout")).click();   
	  
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
      new Object[] { "Admin", "admin" },
      new Object[] { "linda.anderson", "linda.anderson" },
      new Object[] { "anthony.nolan", "anthony.nolan" }
    };
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
	  driver = new ChromeDriver();	
	  driver.get("http://professional.demo.orangehrmlive.com/");
	  	  
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
	  
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
