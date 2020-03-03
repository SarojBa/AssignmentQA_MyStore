package com.tests;

import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.base;
import com.pages.AddToCartPage;
import com.pages.CheckoutProcessPage;
import com.pages.LoginPage;

public class CheckoutProcessPageTest extends base {
	
	AddToCartPage addToCartPage;
	LoginPage loginPage;
	CheckoutProcessPage checkoutProcessPage;

	public CheckoutProcessPageTest(){
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
	public void verifyaddProductToCartTest() throws InterruptedException{
		addToCartPage.clickWomenMenu();
		addToCartPage.addProductToCart();
	}
	
	@Test(priority=1)
	public void navigateToCheckoutPageTest() throws InterruptedException{
		checkoutProcessPage = addToCartPage.clickCheckoutButton();
	}
	
	@Test(priority=2)
	public void verifyOrderPageTitleTest() throws InterruptedException{
		String title = checkoutProcessPage.orderPageTitle();
		Assert.assertEquals(title, "Order - My Store"," title not matched");
	}
	
	@Test(priority=3)
	public void verifySummaryTab() throws InterruptedException, ParseException{
		checkoutProcessPage.summaryTab();
	}
	
	@Test(priority=4)
	public void checkTermsOfService() throws InterruptedException, ParseException{
		checkoutProcessPage.acceptTermsOfService();
	}
	
	@Test(priority=5)
	public void verifyPaymentTab() throws InterruptedException, ParseException{
		checkoutProcessPage.paymentTab();
	}
	
	@Test(priority=6)
	public void paymentProcessTest(){
		checkoutProcessPage.paymentProcess();
	}
	
	@Test(priority=7)
	public void verifyOrderConfirmationPageTitleTest(){
		String title = checkoutProcessPage.orderConfirmationPageTitle();
		Assert.assertEquals(title, "Order confirmation - My Store"," title not matched");
	}
	
	@Test(priority=8)
	public void verifyorderConfirmationMsgTest(){
		String text = checkoutProcessPage.orderConfirmationMsg();
		System.out.println(text);
		Assert.assertEquals(text, "Your order on My Store is complete."," text not matched");
	}
	
	@Test(priority=9)
	public void verifyAmountOrderHistoryTest(){
		checkoutProcessPage.amountOrderHistory();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	
}
