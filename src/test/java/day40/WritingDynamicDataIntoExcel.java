package day40;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet("SampleSheet");
		
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("How many rows required? Enter here --> ");
		int noOfRows = sc.nextInt();	// Getting rows no from user
		
		System.out.println("How many rows required? Enter here --> ");
		int noOfCells = sc.nextInt();	// Getting cells no from user
		
		
		for(int r = 0; r <= noOfRows; r++) 
		{
			XSSFRow row = sheet.createRow(r);			
			
			for(int c = 0; c < noOfCells; c++) 
			{
				XSSFCell cell = row.createCell(c);
				cell.setCellValue(sc.next());	// Getting input from user of any data type
			}
		}
		
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testData\\Dynamic Data File.xlsx");
		
		workbook.write(file);	// writing data into file
		
		workbook.close();
		file.close();
		
		System.out.println("Data saved in the filed.");

	}

}
