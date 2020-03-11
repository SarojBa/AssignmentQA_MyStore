package com.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.base;
import com.pages.CreateAccountPage;

public class CreateAccountPageTest extends base {

	CreateAccountPage createAccountPage;	
	
	public CreateAccountPageTest(){
		super();	
	}
	
	@BeforeClass
	public void setUp(){
		initialization();
		createAccountPage = new CreateAccountPage();	
	}
	
	@Test(priority=0)
	public void verifyLoginPageTitleTest(){
		createAccountPage.clickSigninLink();
		String title = createAccountPage.verifyLoginPageTitle();
		Assert.assertEquals(title, "Login - My Store");	
	}
	
	@Test(priority=1)
	public void createAccountTest(){
		createAccountPage.enterAccountDetails();		
	}
	
	@Test(priority=2)
	public void verifyAccountTest(){
		String actualUser = createAccountPage.verifyAccount();
		String expectedUser = prop.getProperty("fName")+ " " + prop.getProperty("lName");
		Assert.assertEquals(actualUser, expectedUser, "user not matched");
		System.out.println("User verified");
	}
	
	@AfterClass
	public void tearDown(){
		//driver.quit();
	}
	
}
