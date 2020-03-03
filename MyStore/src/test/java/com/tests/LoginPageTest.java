package com.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.base;
import com.pages.CreateAccountPage;
import com.pages.LoginPage;

public class LoginPageTest extends base {

	LoginPage loginPage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initialization();
		loginPage = new LoginPage();		
	}
	
	@Test(priority=0)
	public void verifyLoginPageTitleTest(){
		loginPage.clickSigninLink();
		String title = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(title, "Login - My Store.");	
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
		Assert.assertEquals(title, "My account - My Store","page title not matched");
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
}
