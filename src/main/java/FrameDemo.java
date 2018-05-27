import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.web-wise-wizard.com/html-tutorials/support/frames-website/index.html");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.switchTo().frame(0);
		
		System.out.println(driver.findElement(By.id("title")).getText());
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		System.out.println(driver.findElement(By.id("title")).getText());
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(2);
		System.out.println(driver.findElement(By.id("title")).getText());
		
		driver.close();
		
		

	}

}
