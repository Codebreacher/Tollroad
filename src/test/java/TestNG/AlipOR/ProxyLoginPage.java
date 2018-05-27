package TestNG.AlipOR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProxyLoginPage {
	WebElement ob;
	public WebElement txt_Username (WebDriver driver) {
		WebElement ob = driver.findElement(By.id("username_entry"));
		return ob;
	}
	
	public WebElement txt_Passowrd (WebDriver driver) {
		ob = driver.findElement(By.id("password_entry"));
		return ob;
			}
	
	public WebElement btn_signin(WebDriver driver) {
		ob = driver.findElement(By.id("Submit"));
		return ob;
	}
	

}
