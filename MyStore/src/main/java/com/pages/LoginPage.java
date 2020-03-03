package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.base;

public class LoginPage extends base {
	
	@FindBy(xpath="//a[@class='login']") WebElement signInLink;
	@FindBy(xpath="//input[@id='email']") WebElement emailAddressInput;
	@FindBy(xpath="//input[@id='passwd']") WebElement passwordInput;
	@FindBy(xpath="//button[@name='SubmitLogin']") WebElement signInButton;
	@FindBy(xpath="//a[@class='account']//span") WebElement usernameText;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickSigninLink(){
		signInLink.click();
	}
	
	public String verifyLoginPageTitle(){
		return driver.getTitle();
	}
	
	public void login(String emailId, String password){
		emailAddressInput.sendKeys(emailId);
		passwordInput.sendKeys(password);
		signInButton.click();
	}
	
	public boolean verifyLogin(){
		return usernameText.isDisplayed();
	}
	
	public String accountPageTitle(){
		return driver.getTitle();
	}

}
