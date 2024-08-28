package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLReader {
	//filepath.-.fileinput obj-.diff obj from diff classes
	
	String filePath;
	
	public XLReader(String filePath) {
		this.filePath=filePath;
	}
	
	public FileInputStream fileInput;	//input stream obj
	public XSSFWorkbook workbok; //for entire file.workbook
	public XSSFSheet sheet; //for sheet
	public XSSFRow row; //for row
	public XSSFCell cell; //for entire file.workbook
	
	
	//method to get total row
	public int getRowcount(String sheetName) throws IOException {
		fileInput=new FileInputStream(filePath);
		workbok=new XSSFWorkbook(fileInput);
		sheet=workbok.getSheet(sheetName);
		int	totalRow=sheet.getLastRowNum();
		
		fileInput.close();
		workbok.close();
		return totalRow;
	}
	
	//method to get Cellcount
	public int getCellcount(String sheetName, int rowNum) throws IOException {
		fileInput=new FileInputStream(filePath);
		workbok=new XSSFWorkbook(fileInput);
		sheet=workbok.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		int totalCell=row.getLastCellNum();
		
		fileInput.close();
		workbok.close();
		return totalCell;
	}
	
	
	//to read cellValue
	public String getCellValue(String sheetName, int rowNum, int colNum) throws IOException {
		fileInput=new FileInputStream(filePath);
		workbok=new XSSFWorkbook(fileInput);
		sheet=workbok.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		cell=row.getCell(colNum);
		
		DataFormatter formatter=	new DataFormatter();
		String data=formatter.formatCellValue(cell);
		return data;
	}
	

}
