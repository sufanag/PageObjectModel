package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class Util extends TestBase{
	
	public static final int IMPLICITWAIT = 10;
	public static String TEST_DATA_PATH = "C:\\Selenium\\TestData\\FreeCrm.xlsx";
	public static Workbook wb;
	public static Sheet sheet;
	//public static String sheetName="contacts";
	
	public static Object[][] getTestData(String sheetN) {
		FileInputStream fin = null;
		
		
		try {
			 fin = new FileInputStream(TEST_DATA_PATH);
				System.out.println(TEST_DATA_PATH);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();			
		}
		try {
			 wb = WorkbookFactory.create(fin);
		}
		catch(IllegalFormatException e) {
			e.printStackTrace();}
			
		 catch (IOException e) {
			e.printStackTrace();
		}
		
		sheet = wb.getSheetAt(0);
		System.out.println(sheet.getSheetName());
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			
			for(int j=0;j<sheet.getRow(i).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				//System.out.println(data[i][j]);
			}
		}
		return data;
		
		
	}
	

}
