package com.trello.qsp.genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
public String readTheStringDataFromWorkbook(String sheetname, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("");
	Workbook workbook = WorkbookFactory.create(fis);
	 org.apache.poi.ss.usermodel.Sheet sheet=workbook.getSheet(sheetname);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	String cellValue = cell.getStringCellValue();
	return cellValue;
	}
public double readTheNumericDataFromWorkbook(String sheetname, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream("");
	Workbook workbook = WorkbookFactory.create(fis);
	org.apache.poi.ss.usermodel.Sheet sheet=workbook.getSheet(sheetname);
	
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	double cellValue = cell.getNumericCellValue();
	return cellValue;
	
}
}


