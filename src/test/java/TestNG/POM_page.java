package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POM_page {
	
	public WebElement un (WebDriver driver)
	{
		WebElement we1 = driver.findElement(By.id("txtUsername"));
		return we1;
	}
	
	public WebElement pwd (WebDriver driver)
	{
		WebElement we2 = driver.findElement(By.id("txtPassword"));
		return we2;
	}
	
	public WebElement login (WebDriver driver)
	{
		WebElement we3 = driver.findElement(By.id("btnLogin"));
		return we3;
	}
	
	public WebElement welcome (WebDriver driver)
	{
	WebElement w = driver.findElement(By.id("welcome"));
	return w;
	}
	
	public WebElement logout (WebDriver driver)
	{
		WebElement w = driver.findElement(By.linkText("Logout"));
		return w;
	}
	
	

}
