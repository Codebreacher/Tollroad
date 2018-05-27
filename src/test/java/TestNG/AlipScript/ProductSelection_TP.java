package TestNG.AlipScript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestNG.AlipOR.ProductSelectionPage;

public class ProductSelection_TP {
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	ProductSelection_TP(WebDriver driver) throws Exception{
		driver.switchTo().frame("containerIframe");
		file = new FileInputStream("C:\\Users\\Training_m5c.05.30\\eclipse-workspace\\SeleniumDemo\\src\\test\\java\\TestNG\\AlipScript\\PoductSelection.xlsx");
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheetAt(0);
	}
	
	public void execute(WebDriver driver) throws Exception
	{
		ProductSelectionPage prdSelectPage = new ProductSelectionPage();
		prdSelectPage.dd_FormNumber(driver).selectByVisibleText(sheet.getRow(2).getCell(2).getStringCellValue());
		//WebDriverWait wait = new WebDriverWait(driver,5);
		//wait.until(ExpectedConditions.elementToBeClickable(prdSelectPage.txt_AppReceivedDate_MM(driver)));
		//driver.switchTo().frame("containerIframe");
		//prdSelectPage.op_FormNumber(driver, "6420-CA").click();
		Thread.sleep(1000);
		prdSelectPage.txt_AppReceivedDate_MM(driver).sendKeys("01");
		prdSelectPage.txt_AppReceivedDate_DD(driver).sendKeys("20");
		prdSelectPage.txt_AppReceivedDate_YYYY(driver).sendKeys("2017");
		Thread.sleep(100);
		//wait.until(ExpectedConditions.elementToBeClickable(prdSelectPage.txt_AppSignedDate_MM(driver)));
		//driver.switchTo().frame("containerIframe");
		prdSelectPage.txt_AppSignedDate_MM(driver).sendKeys("01");
		prdSelectPage.txt_AppSignedDate_DD(driver).sendKeys("20");
		prdSelectPage.txt_AppSignedDate_YYYY(driver).sendKeys("2017");
		Thread.sleep(100);
		prdSelectPage.rb_PolicyEffectiveDateOp(driver,"Specified Date").click();
		//.get(2).click();
		
		
	}

}
