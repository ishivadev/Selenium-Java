package day40;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Excel File --> Work book --> Sheet --> Sheet --> Cell 

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testData\\Sample Data.xlsx");	// opening the file
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);		// opening the workbook
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");		// accessing the 'Sheet1'
		
		int totalRows = sheet.getLastRowNum();		
		int totalCells = sheet.getRow(0).getLastCellNum();
		
		System.out.println("Total no of rows : " + totalRows);
		System.out.println("Total no of cells : " + totalCells);
		
		
		// Accessing all the cells from all rows 
		for(int r = 0; r <= totalRows; r++) 
		{
			XSSFRow row = sheet.getRow(r);	// Getting the row
			
			for(int c = 0; c < totalCells; c++) 
			{
				XSSFCell cell = row.getCell(c);		// Getting the cell
				System.out.print(cell.toString() + "\t");	// Getting the cell value
			}
			System.out.println();
		}
		
		
		// Closing the workbook and file
		workbook.close();
		file.close();
		
		
	}

}
