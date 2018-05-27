package TestNG.AlipOR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AlipLoginPage {
	WebElement ob;
	public WebElement txt_uname (WebDriver driver)
	{
		ob = driver.findElement(By.name("j_username"));
		return ob;
	}
	public WebElement txt_pword (WebDriver driver) {
		ob = driver.findElement(By.name("j_password"));
		return ob;
	}
	public WebElement btn_login (WebDriver driver) {
		ob = driver.findElement(By.name("B12"));
		return ob;		
	}
	
	

}
