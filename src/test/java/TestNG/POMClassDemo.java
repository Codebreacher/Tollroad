package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class POMClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		 System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
		  driver = new ChromeDriver();
		  
		  driver.get("http://professional.demo.orangehrmlive.com/");
		  
		  POM_page po = new POM_page();
		  
		  po.un(driver).sendKeys("admin");
		  po.pwd(driver).sendKeys("admin");
		  po.login(driver).click();
		  
		  System.out.println(driver.getTitle());
		  
		  driver.close();
		  
		  
		  
		  

	}

}
