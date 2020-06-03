package excelutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.functors.WhileClosure;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.Test;

//import static tests.BaseTest.testDataExcelFileName;

public class ExcelUtil {
	static File src;
	static FileInputStream fis;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	

	
	public static void getrowcount() throws IOException {

		src = new File("C:\\Users\\hitul\\git\\Selenium_Test1\\TestOrder\\TestData.xlsx");
		fis = new FileInputStream(src);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		int rowcount = sheet.getLastRowNum()+1;
		
		for(int i=0;i<rowcount;i++) {
			
			row= sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++) {
				System.out.print(row.getCell(j));				
			}
			System.out.println();
			fis.close();
			workbook.close();
		}
		
	}

	//@Test
	public static Object[] getcelldata() throws IOException {
		src = new File("C:\\Users\\hitul\\git\\Selenium_Test1\\TestOrder\\TestData.xlsx");
		fis = new FileInputStream(src);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();
		System.out.println(rowcount);
		return null;

	}
	
	
}
