import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.5.3");
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
		
		
		
		

	}

}
