import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class IEBrowserDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.ie.driver", "C:/Driver/IEDriverServer.exe");
		
				
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("http://www.google.com");
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
		
		

	}

}
