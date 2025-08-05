package day40;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel File --> Work book --> Sheet --> Sheet --> Cell 

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("Data1");
		
		// Adding 1st row and adding data into cells
		XSSFRow row1 = sheet.createRow(0);	
			row1.createCell(0).setCellValue(12);
			row1.createCell(1).setCellValue(false);
			row1.createCell(2).setCellValue("Test");
			row1.createCell(3).setCellValue("21/Apr/22");
			row1.createCell(4).setCellValue(20.1);
		
		// Adding 2nd row and adding data into cells
		XSSFRow row2 = sheet.createRow(1);
			row2.createCell(0).setCellValue(20);
			row2.createCell(1).setCellValue(true);
			row2.createCell(2).setCellValue("Sample");
			row2.createCell(3).setCellValue("1/Jun/23");
			row2.createCell(4).setCellValue(40.20);
			
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testData\\Created Data File.xlsx");
		
		workbook.write(file);	// writing data into file
		
		workbook.close();
		file.close();
		
		System.out.println("Data saved in the filed.");
	}

}
