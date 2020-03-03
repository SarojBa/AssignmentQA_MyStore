package com.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.base;

public class TestUtil extends base{

public static void takeScreenshotAtEndOfTest() throws IOException{
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
        Date date = new Date();
        
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + dateFormat.format(date)+ ".png"));
	}
}
