import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Stringtest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		FileInputStream Fread;
		FileOutputStream Fwrite;
		HashMap<String,String> dictionary=null;
		
		XSSFWorkbook wb;
		XSSFSheet sh;
		String d1,d2;
		Fread = new FileInputStream("C:\\Users\\Training_m5c.05.30\\eclipse-workspace\\SeleniumDemo\\src\\test\\java\\LoginData.xlsx");
		wb = new XSSFWorkbook(Fread);
		
		ExcelData ed = new ExcelData();
		String dataTable[][] = ed.readFromExcel(wb, "Sheet1", "Test1");
		
		
		
		driver.get("https://www.contentstack.com/");
		driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li/a[contains(text(),'Log')]")).click();
		Set<String> winds = driver.getWindowHandles();
		Iterator<String> itr = winds.iterator();
		itr.next();
		driver.switchTo().window(itr.next());
		
		//System.out.print("parent"+driver.getTitle());
		for (int i = 1;i<dataTable.length;i++) {
			if (dataTable[i][0]!= null)
			dictionary = ed.DataDictionary(dataTable, i);
		System.out.println(dictionary.values());	
		System.out.println(dictionary.get("UserName"));
		
	driver.findElement(By.id("email")).sendKeys(dictionary.get("UserName"));
		
		}
		
		}
		

	}


