package TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		FileInputStream fi = new FileInputStream("C:/Users/Training_m5c.05.30/eclipse-workspace/SeleniumDemo/src/test/java/TestNG/NewTours.properties");
		Properties p = new Properties();
		p.load(fi);
		WebDriver driver = new ChromeDriver();
		driver.get(p.getProperty("url"));
		//Thread.sleep(3000);
		driver.findElement(By.name(p.getProperty("Uname"))).sendKeys(p.getProperty("Uvalue"));
		driver.findElement(By.name(p.getProperty("Pwd"))).sendKeys(p.getProperty("Pvalue"));
		driver.findElement(By.name(p.getProperty("Login"))).click();
		   
		   System.out.println("Login Done..");
		//   Thread.sleep(3000);
		   driver.close();
		
		
		

	}

}
