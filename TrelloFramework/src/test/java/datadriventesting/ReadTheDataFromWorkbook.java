package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheDataFromWorkbook {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream file = new FileInputStream("./src/test/resource/data.xlsx");
	Workbook workbook = WorkbookFactory.create(file);
	Sheet sheet = workbook.getSheet("ratings");
	Row row = sheet.getRow(4);
	Cell cell = row.getCell(2);
	long cellValue = (long) cell.getNumericCellValue();
	System.out.println(cellValue);
	
}
}
