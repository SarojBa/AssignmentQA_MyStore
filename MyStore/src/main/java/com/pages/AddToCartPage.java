package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.base;

public class AddToCartPage extends base {

	@FindBy(xpath="//a[@title='Women']") WebElement womenMenuLink;
	@FindBy(xpath="//img[@title='Blouse']") WebElement quickViewLink;	
	@FindBy(xpath="//label[text()='Quantity']//following::a[2]") WebElement plusIconButton;	
	@FindBy(xpath="//button[@name='Submit']") WebElement addToCartButton;
	@FindBy(xpath="//span[@class='ajax_cart_quantity']") WebElement productQuantityText;
	@FindBy(xpath="//span[@id='layer_cart_product_price']") WebElement totalValueText1;
	@FindBy(xpath="//strong[contains(text(),'Total products')]//following-sibling::span") WebElement totalValueText2;
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]") WebElement checkoutButton;
	
	public AddToCartPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickWomenMenu(){
		womenMenuLink.click();
	}
	
	public String womenStorePageTitle(){
		return driver.getTitle();
	}

	public void addProductToCart(){
		quickViewLink.click();
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		System.out.println("Switched to iframe");
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		plusIconButton.click();
		addToCartButton.click();
		String quantity = productQuantityText.getText();
		if(quantity.equals("2")){
			System.out.println("2 products are successfully added to cart");
		}
		else{
			System.out.println(quantity+ " products are added to cart");
		}
		
	}
	
	public CheckoutProcessPage clickCheckoutButton(){
		checkoutButton.click();
		System.out.println("User navigated on checkout page");
		return new CheckoutProcessPage();		
	}
	
}
