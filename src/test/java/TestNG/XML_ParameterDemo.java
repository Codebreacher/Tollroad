package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class XML_ParameterDemo {
	
	WebDriver driver;
	@Parameters({"un","pwd"})
  @Test
  public void demo(String un, String pwd) throws Exception {
		driver.findElement(By.id("txtUsername")).sendKeys(un);
		  driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		  driver.findElement(By.id("btnLogin")).click();
		  Thread.sleep(1000);
		 // wbmsg=driver.findElement(By.id("welcome")).getText();
		  
		  driver.findElement(By.id("welcome")).click();
		  Thread.sleep(200);
		  driver.findElement(By.linkText("Logout")).click();
		
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://professional.demo.orangehrmlive.com/");
	  driver.manage().window().maximize();
	  
	  
	  
	  
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
  }

}
