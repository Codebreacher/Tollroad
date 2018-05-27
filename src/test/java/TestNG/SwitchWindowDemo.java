package TestNG;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindowDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Driver/chromedriver.exe");
		WebDriver  driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		
		driver.findElement(By.xpath(".//*[@id='button1']")).click();
		driver.findElement(By.xpath(".//*[@id='content']/p[3]/button")).click();
		driver.findElement(By.xpath(".//*[@id='content']/p[4]/button")).click();
		
		Set<String> winids  =driver.getWindowHandles();
		Iterator<String> itr = winids.iterator();
		
		String mainwindow= itr.next();
		String childwindow = itr.next();
		
		System.out.println("title main window" + driver.getTitle());
		
		driver.switchTo().window(childwindow);
		
		System.out.println("title main window1" + driver.getTitle());
		
		childwindow = itr.next();
		driver.switchTo().window(childwindow);
		
		System.out.println("title main window2" + driver.getTitle());
		

	}

}
