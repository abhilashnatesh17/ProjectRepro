package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell; //no direct run libraries provided by JDK , so using third party libraries Apache
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Constant.Constants;

public class ExelUtilities {
	
	static FileInputStream f;
	static XSSFWorkbook wb;
	static XSSFSheet sh;
	
	public static String getStringData(int i, int j, String sheet) throws IOException  //Exel read chyuna cmmt
	{  
		String filepath = Constants.TESTDATAFILE;		//string data read chyn 
		f = new FileInputStream(filepath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();
	}
	public static String getIntegerData(int i, int j, String sheet) throws IOException
	{
		String filepath = Constants.TESTDATAFILE;		//integer data read chyune
		f = new FileInputStream(filepath);
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		int x = (int) c.getNumericCellValue();
		return String.valueOf(x);
	}
}	
