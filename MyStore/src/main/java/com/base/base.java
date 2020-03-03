package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class base {

	public static WebDriver driver;
	public static Properties prop;
	FileInputStream fis;

	public base() {
		prop = new Properties();
		String filePath = "C:\\Users\\saroj\\git\\AssignmentQA_MyStore\\MyStore\\src\\main\\java\\com\\config\\config.properties";
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		
		try {
			prop.load(fis);
		}catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	public void initialization(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\saroj\\git\\AssignmentQA_MyStore\\MyStore\\chromedriver.exe");
		driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
	}

}
