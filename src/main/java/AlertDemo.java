import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		
		driver.manage().window().maximize();

		driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("56464164");
		driver.findElement(By.name("submit")).click();
		
		Thread.sleep(1000);	
		
		Alert a = driver.switchTo().alert();
		String s = a.getText();
		a.accept();
		//a.dismiss();
		
		System.out.println(s);
		
		//a = driver.switchTo().alert();
		s=a.getText();
		a.accept();
		System.out.println(s);
		
		driver.close();
		
	}

}
