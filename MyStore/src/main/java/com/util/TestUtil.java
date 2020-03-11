package com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.base;

public class TestUtil extends base{

	static String sheetPath = "C:\\Users\\saroj\\git\\AssignmentQA_MyStore\\MyStore\\src\\main\\java\\com\\testData\\userCredentials.xlsx";
	
	static XSSFWorkbook book;
	static XSSFSheet sheet;
	
	public static void takeScreenshotAtEndOfTest() throws IOException{
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
        Date date = new Date();
        
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + dateFormat.format(date)+ ".png"));
	}
	
	public static String getSheetData(int rowNum, int colNum){
		
		FileInputStream file = null;
		try{
			file = new FileInputStream(sheetPath);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		try{
			book = new XSSFWorkbook(file);
		}catch(IOException e){
			e.printStackTrace();
		}
		
		sheet = book.getSheetAt(0);
		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		
		//String data = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		System.out.println(data);
		return data;
		
	}
}
