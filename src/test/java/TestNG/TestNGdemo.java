package TestNG;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGdemo {
	private static final Class[] Exception = null;
	WebDriver driver;
  
  public void search() {
	  driver.findElement(By.className("gsfi")).sendKeys("Hello");
	  driver.findElement(By.name("btnK")).click();
	  	  
  }
  
  @Test (priority=1)
  public void anews() {
	  System.out.println("news");
	  	  
	  driver.findElement(By.linkText("News")).click();
  }
  

  @Test (priority=2)
  public void bimages() {
	  System.out.println("images");
	  driver.findElement(By.linkText("Images")).click();
  }
  
  @Test (expectedExceptions = ArithmeticException.class)
  public void avideos() {
	  System.out.println("videos");
	  driver.findElement(By.linkText("Videos")).click();
  }
  
  @Test 
  public void dmore() {
	  System.out.println("More");
	  driver.findElement(By.linkText("More")).click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  
	  System.out.println("Before test");
	  System.out.println(driver.getTitle());
	  System.out.println("");
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After test");
	  System.out.println(driver.getTitle());
	  System.out.println("");
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  //System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();	
	  driver.get("https://www.google.co.in/");
	  search();
	  
	  
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
