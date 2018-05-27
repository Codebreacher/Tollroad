package TestNG.AlipScript;

import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import TestNG.AlipOR.GenericOb;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleScript {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ProxyLogin pl = new ProxyLogin();
		pl.pxyLogin(driver);
		Thread.sleep(1000);
		AlipLogin alo = new AlipLogin();
		alo.login("a", driver, "SUPERVIS", "123456");
		Thread.sleep(3000);
		GenericOb go = new GenericOb();
		
		 Point coordinates = go.btn_Application(driver).getLocation();
		  Robot robot = new Robot();
		  robot.mouseMove(coordinates.getX(),coordinates.getY()+120);
		  
		  go.btn_NewApplication(driver).click();
			Thread.sleep(3000);
			driver.findElement(By.className("mainContent")).click();
			 driver.switchTo().frame("containerIframe");
			driver.findElement(By.xpath(".//*[@id='qcontent_8378_-1_5']/select")).click();
			driver.findElement(By.name("FormattedDate1:/XML/ApplicationDetail/RecvdDate")).sendKeys("01");
	}
}
		


