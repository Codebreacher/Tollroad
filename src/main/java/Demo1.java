import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://opensource.demo.orangehrmlive.com/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.name("txtPassword")).sendKeys("admin");

		driver.findElement(By.id("btnLogin")).click();
		
		driver.findElement(By.linkText("Admin")).click();
		
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("john.smith");
		
		driver.findElement(By.xpath("//form[@id='search_form']/fieldset/p/input")).click();
		
		driver.findElement(By.cssSelector("#btnAdd")).click();;
		
		
		
	}

}
