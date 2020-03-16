package com.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.base;
import com.pages.LoginPage;

public class LoginPageTest extends base {

	LoginPage loginPage;
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");

	}
	
	@Test(priority=0, retryAnalyzer=com.util.RetryAnalyzer.class)
	public void verifyLoginPageTitleTest(){
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** verifyLoginPageTitleTest *****************************************");
		loginPage.clickSigninLink();
		String title = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(title, "Login - My Store.");	
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** verifyLoginPageTitleTest *****************************************");

	}
	
	@Test(priority=1)
	public void loginTest(){
		loginPage.login(prop.getProperty("emailId"), prop.getProperty("password"));
	}
	
	@Test(priority=2)
	public void verifyLoginTest(){
		boolean flag = loginPage.verifyLogin();
		Assert.assertTrue(flag,"Username not displayed");
	}
	
	@Test(priority=3)
	public void verifyAccountPageTitleTest(){
		String title = loginPage.accountPageTitle();
		Assert.assertEquals(title, "My account - My Store","page title is not matched");
		
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
}
