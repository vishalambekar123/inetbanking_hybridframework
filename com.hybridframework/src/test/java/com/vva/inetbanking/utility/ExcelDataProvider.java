package com.vva.inetbanking.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	static XSSFWorkbook wb;

	public ExcelDataProvider(String fname) {

		try {
			File fs = new File(fname);
			FileInputStream fins = new FileInputStream(fs);
			wb = new XSSFWorkbook(fins);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getStringCellValue(String sheetname, int row, int column) {

		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	}

	public String getStringCellValue(int sheetindex, int row, int column) {

		return wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
	}

	public int getNumericCellValue(String sheetname, int row, int column) {

		return (int)wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	}
	
	public int getNumericCellValue(int sheetindex, int row, int column) {
		
		return (int)wb.getSheetAt(sheetindex).getRow(row).getCell(column).getNumericCellValue();
	}
	
	
	public Object[][] getExcelTestData(String sheetname) {
		
		XSSFSheet sheet = wb.getSheet(sheetname);
		int row_count = sheet.getLastRowNum();
		int column_count = sheet.getRow(0).getLastCellNum();
		
		System.out.println("Total number of Rows are: "+row_count);
		System.out.println("Total number of column are: "+column_count);
		
		Object [][] data = new Object[row_count][column_count];
		
		for(int i=0; i<row_count;i++) {
			for(int j=0; j<column_count; j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
	
}








