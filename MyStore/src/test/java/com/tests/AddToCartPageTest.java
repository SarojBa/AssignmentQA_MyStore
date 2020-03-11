package com.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.base;
import com.pages.AddToCartPage;
import com.pages.CheckoutProcessPage;
import com.pages.LoginPage;

public class AddToCartPageTest extends base {

	AddToCartPage addToCartPage;
	LoginPage loginPage;
	CheckoutProcessPage checkoutProcessPage;
	
	public AddToCartPageTest(){
		super();		
	}
	
	@BeforeClass
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		addToCartPage = new AddToCartPage();
		loginPage.clickSigninLink();
		loginPage.login(prop.getProperty("emailId"), prop.getProperty("password"));
	}
	
	@Test(priority=0)
	public void verifyLoginTest(){
		boolean flag = loginPage.verifyLogin();
		Assert.assertTrue(flag,"Username not displayed");
	}
	
	@Test(priority=1)
	public void verifyWomenStorePageTitle(){
		addToCartPage.clickWomenMenu();
		String title = addToCartPage.womenStorePageTitle();
		Assert.assertEquals(title, "Women - My Store..");
	}
	
	@Test(priority=2)
	public void verifyaddProductToCartTest(){
		addToCartPage.addProductToCart();
	}
	
	@Test(priority=3)
	public void navigateToCheckoutPageTest() throws InterruptedException{
		checkoutProcessPage = addToCartPage.clickCheckoutButton();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
}
