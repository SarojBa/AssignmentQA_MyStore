package com.pages;

import java.text.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.base;

public class CheckoutProcessPage extends base {
	
	@FindBy(xpath="//td[@data-title='Unit price']") WebElement unitPrice;
	@FindBy(xpath="//td[@data-title='Total']") WebElement totalPrice;
	@FindBy(xpath="//span[@id='total_price']") WebElement finalPrice;
	@FindBy(xpath="//input[@id='cgv']") WebElement termsOfServiceCheckbox;
	@FindBy(xpath="//a[contains(@class,'checkout button') and @title='Proceed to checkout']") WebElement checkoutButtonSummary;	
	@FindBy(xpath="//button[@name='processAddress']") WebElement checkoutButtonAddress;
	@FindBy(xpath="//button[@name='processCarrier']") WebElement checkoutButtonShipping;
	@FindBy(xpath="//a[@title='Pay by bank wire']") WebElement paymentByBankWireButton;
	@FindBy(xpath="//a[@title='Pay by check.']") WebElement paymentByCheckButton;
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]") WebElement confirmOrderButton;
	@FindBy(xpath="//strong[contains(text(),'Your order on My Store is complete.')]") WebElement orderConfirmMessage;
	@FindBy(xpath="//a[@class='account']//span") WebElement usernameText;
	@FindBy(xpath="//span[contains(text(),'Order history and details')]") WebElement orderHistoryButton;
	@FindBy(xpath="(//td[@class='history_price'])[1]") WebElement priceText;
 
	String totalPriceProductText="";
	String finalPriceProductText="";
	
	public CheckoutProcessPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String orderPageTitle(){
		return driver.getTitle();
	}
	
	public void summaryTab() throws ParseException{
		String unitPriceText = unitPrice.getText();
		String unitPrice = unitPriceText.replace("$", "");
	
		double unitPriceInDouble = Double.parseDouble(unitPrice);
		int unitPriceProduct = (int) unitPriceInDouble;
		System.out.println("Unit Price: "+unitPriceProduct);
		
		int totalPriceProduct = unitPriceProduct*2;
		totalPriceProductText = "$" + totalPriceProduct +".00";
		System.out.println("Total Price: "+totalPriceProductText);
		
		if(totalPrice.getText().equals(totalPriceProductText)){
			System.out.println("Total price is correct and verified on Summary tab");
		}
		else{
			System.out.println("Total price is incorrect on Summary tab");
		}
		
		int finalPriceProduct = totalPriceProduct+2;
		finalPriceProductText = "$" + finalPriceProduct +".00"; 
		System.out.println("Final Price: "+finalPriceProductText);
		
		if(finalPrice.getText().equals(finalPriceProductText)){
			System.out.println("Final price is correct and verified on Summary tab");
		}
		else{
			System.out.println("Final price is incorrect on Summary tab");
		}	
	}
	
	public void acceptTermsOfService(){
		checkoutButtonSummary.click();
		System.out.println("user is on address tab");
		checkoutButtonAddress.click();
		System.out.println("user is on shipping tab");
		termsOfServiceCheckbox.click();
		System.out.println(" Terms of service accepted by user");	
		checkoutButtonShipping.click();
		System.out.println("user is on Payment tab");
	}
	
	public void paymentTab(){
		System.out.println("text: "+totalPrice.getText());
		System.out.println(totalPriceProductText);
		if(totalPrice.getText().equals(totalPriceProductText)){
			System.out.println("Total price is correct and verified on Payment tab");
		}
		else{
			System.out.println("Total price is incorrect on Payment tab");
		}
		System.out.println("text: "+finalPrice.getText());
		System.out.println(finalPriceProductText);
		if(finalPrice.getText().equals(finalPriceProductText)){
			System.out.println("Final price is correct and verified on Payment tab");
		}
		else{
			System.out.println("Final price is incorrect on Payment tab");
		}	
	}
	
	public void paymentProcess(){
		if(prop.getProperty("payBy").equals("bank wire")){
			paymentByBankWireButton.click();
			
		}
		else if(prop.getProperty("payBy").equals("check")){
			paymentByCheckButton.click();
		}
		
		confirmOrderButton.click();
		System.out.println("Confirm order button is clicked");
		
	}
	
	public String orderConfirmationPageTitle(){
		return driver.getTitle();
	}
	
	public String orderConfirmationMsg(){
		return orderConfirmMessage.getText();
		
	}
	
	public void amountOrderHistory(){
		usernameText.click();
		orderHistoryButton.click();
		if(priceText.getText().equals(finalPriceProductText)){
			System.out.println("Amount verified on order history page");
		}
		else{
			System.out.println("Amount not verified on order history page");
		}
	}
		
}
