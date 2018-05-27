package TestNG.AlipOR;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import junit.framework.Assert;

public class GenericOb {
	WebElement ob;
	public WebElement btn_Application (WebDriver driver) {
		ob = driver.findElement(By.xpath(".//*[@id='a_applications']"));	
		return ob;		
	}
	
	public WebElement btn_NewApplication (WebDriver driver) {
		ob = driver.findElement(By.id("a_new_application"));
		return ob;
	}
	
	public List<WebElement> getRow(WebElement wb,int col,String colData)throws ElementNotFoundException {
		List<WebElement> row =  wb.findElements(By.xpath("/tbody/tr/td[text()='"+colData+"']/parent::*"));
		
		return row;
	}

}

////table[@class="dataTable"]/tbody/tr/parent::td[text()="998.55"]

//table[@class="dataTable"]/tbody/tr/td[text()='585.10']/parent::*