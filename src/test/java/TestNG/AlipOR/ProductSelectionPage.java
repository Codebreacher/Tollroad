package TestNG.AlipOR;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ProductSelectionPage {
	
	WebElement ob;
	public Select dd_FormNumber(WebDriver driver) {
		//WebDriverWait wait = new WebDriverWait(driver,30); 
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("5:/XML/ApplicationDetail/FormNumber"))));
		ob = driver.findElement(By.xpath(".//*[contains(@name,'/XML/ApplicationDetail/FormNumber')]"));
		//By.xpath(".//*[contains(@name,'/XML/ApplicationDetail/PolicyDateOption')]")
		//ob = driver.findElement(By.cssSelector("select[name$='FormNumber']"));
		//ob = driver.findElement(By.name("5:/XML/ApplicationDetail/FormNumber"));
		//ob =(WebElement)driver.findElement(By.xpath(".//*[name='5:/XML/ApplicationDetail/FormNumber']"));
		Select dd = new Select(ob);
		return dd;
	}
	public WebElement op_FormNumber(WebDriver driver,String value)
	{
		String path = ".//*[@id='test']/option[contains(@value,'"+value+"')]";
		ob = driver.findElement(By.xpath(path));
		return ob;
	}
	public WebElement txt_AppReceivedDate_MM (WebDriver driver)
	{//By.cssSelector("[id$=//ApplicationDetail//RecvdDate")
		ob = driver.findElement(By.name("FormattedDate1:/XML/ApplicationDetail/RecvdDate"));
		return ob;
	}	
	public WebElement txt_AppReceivedDate_DD (WebDriver driver) {
		ob = driver.findElement(By.name("FormattedDate2:/XML/ApplicationDetail/RecvdDate"));
		return ob;
	}
	public WebElement txt_AppReceivedDate_YYYY (WebDriver driver) {
		ob = driver.findElement(By.name("FormattedDate3:/XML/ApplicationDetail/RecvdDate"));
		return ob;
	}
	public WebElement txt_AppSignedDate_MM (WebDriver driver)
	{
		ob = driver.findElement(By.name("FormattedDate1:/XML/ApplicationSummary/SignatureDate"));
		return ob;
	}
	public WebElement txt_AppSignedDate_DD (WebDriver driver)
	{
		ob = driver.findElement(By.name("FormattedDate2:/XML/ApplicationSummary/SignatureDate"));
		return ob;
	}
	public WebElement txt_AppSignedDate_YYYY (WebDriver driver)
	{
		ob = driver.findElement(By.name("FormattedDate3:/XML/ApplicationSummary/SignatureDate"));
		return ob;
	}
	public WebElement rb_PolicyEffectiveDateOp(WebDriver driver,String option) {
		
		String path = ".//*[contains(@value,'}"+option+"')]";
		ob = driver.findElement(By.xpath(path));
		//List<WebElement> rb = driver.findElements(By.xpath("//*[contains(@name,'/XML/ApplicationDetail/PolicyDateOption')]"));
		return ob;
	}
	
	public Select dd_ApplicationState(WebElement driver) {
		ob = driver.findElement(By.xpath(".//*[contains(@name,'ApplicationDetail/ApplicationState')]"));
		Select dd = new Select(ob);
		return dd;
	}
	public WebElement rb_IsAdditionalCase(WebDriver driver,String option) {
		ob = driver.findElement(By.xpath(".//*[contains(@name,'ApplicationDetail/AdditionalCaseInd')] [contains(@value,'}Yes')]"));
		return ob;
	}

}
