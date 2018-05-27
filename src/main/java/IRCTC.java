



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;





public class IRCTC {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(".//*[@id='loginFormId']/div[1]/div[2]/table[1]/tbody/tr[1]/td[3]/a")).click();
		
		driver.findElement(By.id("userRegistrationForm:userName")).sendKeys("Abhishek");
		
		driver.findElement(By.id("userRegistrationForm:checkavail")).click();
		
		driver.findElement(By.id("userRegistrationForm:password")).sendKeys("Hello");
		
		driver.findElement(By.name("userRegistrationForm:confpasword")).sendKeys("Hello");
		
		//driver.findElement(By.id("userRegistrationForm:securityQ"))
		
				//Or it can be also written as
		 
		Select oSelect = new Select(driver.findElement(By.id("userRegistrationForm:securityQ")));
		
		oSelect.selectByValue("0");
		
		driver.findElement(By.id("userRegistrationForm:securityAnswer")).sendKeys("Dog");
		
		Select lSelect = new Select (driver.findElement(By.id("userRegistrationForm:prelan")));
		
		lSelect.selectByVisibleText("हिन्दी");
		
		driver.findElement(By.id("userRegistrationForm:firstName")).sendKeys("Abhishek");;
		
		driver.findElement(By.id("userRegistrationForm:middleName")).sendKeys("Balkrishna");;
		
		driver.findElement(By.id("userRegistrationForm:lastName")).sendKeys("Kesarkar");;
		
		List<WebElement> rList = (List<WebElement>) driver.findElements(By.name("userRegistrationForm:gender"));
		
		int m = rList.size();
		String gender;
		
		
		for (int i = 0;i < m;i++)
		{			
			gender = rList.get(i).getAttribute("value");	
			
			if (gender =="M")
			{
				rList.get(i).click();
				break;
			}
		}
		
		List<WebElement> mList = (List<WebElement>) driver.findElements(By.name("userRegistrationForm:maritalStatus"));
		
		int g = mList.size();
		String mStatus;
		
		
		for (int i = 0;i < g;i++)
		{			
			mStatus = mList.get(i).getAttribute("value");	
			if (mStatus =="U")
			{
				rList.get(i).click();
				break;
			}			
		}
		
		//DOB
		
		//Date
		
		Select dSelect = new Select(driver.findElement(By.id("userRegistrationForm:dobDay")));
		
		dSelect.selectByVisibleText("24");
		
		//month
		
		Select mSelect  = new Select(driver.findElement(By.id("userRegistrationForm:dobMonth")));
		
		mSelect.selectByVisibleText("FEB");
		
		//year
		
		Select ySelect  = new Select(driver.findElement(By.id("userRegistrationForm:dateOfBirth")));
		
		ySelect.selectByVisibleText("1993");
		
		//occupation
		
		Select occSelect  = new Select(driver.findElement(By.id("userRegistrationForm:occupation")));
		
		occSelect.selectByVisibleText("Private");
		
		//Country
		Select cSelect  = new Select(driver.findElement(By.id("userRegistrationForm:countries")));
		cSelect.selectByVisibleText("India");
		
		//pin
		driver.findElement(By.id("userRegistrationForm:pincode")).sendKeys("401303");
		driver.findElement(By.id("userRegistrationForm:statesName")).click();
		Thread.sleep(3000);
		//city
		Select citySelect  = new Select(driver.findElement(By.id("userRegistrationForm:cityName")));
		citySelect.selectByVisibleText("Thane");
		
		//driver.findElement(By.id(id))
		//WebDriverWait wait = new WebDriverWait(driver,20);
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.))
		
		
		
		
		
		

	}

}
