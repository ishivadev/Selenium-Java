package day41;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	// Getting total row count
	public static int getRowCount(String xlfile, String xlsheet ) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;   // returning the total row count
	}
	
	
	// Getting total cell count of a row
	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount; // returning the total cell count
	}
	
	
	// Getting the value of cell
	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		
		String data;
		
		try {
			//data = cell.toString();
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell); // Return the formatted value of a cell as a String regardless of the cell type.
		} 
		catch(Exception e) {
			data = "";
		}
		
		wb.close();
		fi.close();
		return data;  // returning the value of cell
	}
	
	
	// Setting the value of a cell
	public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data) throws IOException
	{
		// Reading the file and row
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		
		// Setting the value into cell
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlfile);
		wb.write(fo); // writing the data into excel
		
		wb.close();
		fi.close();
		fo.close();
	}
	
	
	// Marking the cell color as 'GREEN'
	public static void fileGroundColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = wb.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		
		wb.close();
		fi.close();
		fo.close();
		
	}
	
	
	// Marking the cell color as 'GREEN'
		public static void fileRedColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException
		{
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlsheet);
			row = ws.getRow(rownum);
			cell = row.getCell(colnum);
			
			style = wb.createCellStyle();
			
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			
			cell.setCellStyle(style);
			fo = new FileOutputStream(xlfile);
			wb.write(fo);
			
			wb.close();
			fi.close();
			fo.close();
			
		}
	
}
