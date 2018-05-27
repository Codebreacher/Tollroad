import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelData {

		FileInputStream Fread;
		FileOutputStream Fwrite;
		
		XSSFWorkbook wb;
		XSSFSheet sh;
		XSSFRow row;
		String d1,d2;
		
		
		public String[][] readFromExcel(XSSFWorkbook wb,String sheetname,String ControlVariable) throws Exception, IOException{
		String[][] testData;	
		
		sh = wb.getSheet(sheetname);
		row = sh.getRow(0);
		String CVinSheet;
		
		
		testData = new String[sh.getPhysicalNumberOfRows()][row.getPhysicalNumberOfCells()];
		for (int j = 0;j<(row.getLastCellNum()-row.getFirstCellNum());j++) {
			testData[0][j] = sh.getRow(0).getCell(j).getStringCellValue();
		}
		int a=1,check=0;
		for (int i = 1; i<sh.getPhysicalNumberOfRows();i++) {
			
			if (sh.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(ControlVariable) ) {
				for (int j = 0;j<(row.getLastCellNum()-row.getFirstCellNum());j++) {
					
					testData[a][j] = sh.getRow(i).getCell(j).getStringCellValue();
					System.out.println("Inloop "+testData[a][j]);
					
				}
				check=1;
			}
			if (check==1){
				a++;
				check=0;
			}
					
		}
		System.out.println(testData);
		return testData;
		}
		
		public HashMap<String,String> DataDictionary(String[][] table, int iRow){
			HashMap<String, String> dictionary = new HashMap<String,String>();
			
			int colcount = table[0].length;
			
			for (int i = 0; i<colcount;i++) {
				System.out.println(table[0][i]+table[iRow][i]);
				dictionary.put(table[0][i], table[iRow][i]);
				
			}
			
			return dictionary;
		}

		
}	
		
		
	
