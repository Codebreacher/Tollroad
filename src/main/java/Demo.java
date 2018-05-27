import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.className("gsfi")).sendKeys("Hello");
		
		driver.findElement(By.name("btnK")).click();
		
		
		driver.wait(10);
		driver.close();
		
		
		

	}

}
