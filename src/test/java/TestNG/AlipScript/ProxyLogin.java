package TestNG.AlipScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import TestNG.AlipOR.ProxyLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProxyLogin {

	public void pxyLogin(WebDriver driver) {
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		
		driver.get("https://alip-proxy.asw.accenture.com/onfscon1/en/Login.jsp");
		
		ProxyLoginPage pl = new ProxyLoginPage();
		pl.txt_Username(driver).sendKeys("hchaudhari");
		pl.txt_Passowrd(driver).sendKeys("Airoli#04");
		pl.btn_signin(driver).click();
		
		
		
		
		// TODO Auto-generated method stub

	}

}
