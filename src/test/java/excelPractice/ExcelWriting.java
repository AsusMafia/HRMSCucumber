package excelPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriting {

	@Test
	public void write() throws IOException {
		
		String filePath = "./src/test/java/excelPractice/Hello.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		Workbook book=new XSSFWorkbook(fis);
		Sheet sheet=book.getSheet("Test");
		//if cell is not there you need to create one
		sheet.getRow(0).createCell(2).setCellValue("Language");
		//if cell is there--> grab the cell and update
		sheet.getRow(0).createCell(3).setCellValue("Instructor");
		//if row is not there you need to create one
		sheet.createRow(2).createCell(0).setCellValue("Syntax123");
		//once row is created you need to grab it
		sheet.getRow(2).createCell(1).setCellValue("TestNG");
		sheet.getRow(2).createCell(2).setCellValue("Java");
		sheet.getRow(2).createCell(3).setCellValue("Asel");
		sheet.getRow(2).createCell(2).setCellValue("Java Script");
		//bring object of FileOutputStream to write back into the Excel wile
		FileOutputStream fos=new FileOutputStream(filePath);
		book.write(fos);
		fos.close();
		book.close();
		fis.close();
	}
}