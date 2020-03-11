package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.base;
import com.util.TestUtil;

public class CreateAccountPage extends base  {
	
	@FindBy(xpath="//a[@class='login']") WebElement signInLink;
	@FindBy(xpath="//input[@id='email_create']") WebElement emailCreateInput;
	@FindBy(xpath="//button[@id='SubmitCreate']") WebElement createAccountButton;
	@FindBy(xpath="//div[@id='create_account_error']//li") WebElement errorMsg;
	@FindBy(xpath="//input[@name='customer_firstname']") WebElement firstName;
	@FindBy(xpath="//input[@name='customer_lastname']") WebElement lastName;
	@FindBy(xpath="//input[@id='passwd']") WebElement password;
	@FindBy(xpath="//input[@id='firstname']") WebElement addrFirstName;
	@FindBy(xpath="//input[@id='lastname']") WebElement addrLastName;
	@FindBy(xpath="//input[@id='address1']") WebElement address;
	@FindBy(xpath="//input[@name='city']") WebElement city;
	@FindBy(xpath="//select[@id='id_state']") WebElement state;
	@FindBy(xpath="//input[@name='postcode']") WebElement postalCode;
	@FindBy(xpath="//input[@name='phone_mobile']") WebElement mobilePhone;
	@FindBy(xpath="//input[@id='alias']") WebElement aliasAddress;
	@FindBy(xpath="//button[@name='submitAccount']") WebElement registerButton;
	@FindBy(xpath="//a[@class='account']//span") WebElement usernameText;
	
	public CreateAccountPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickSigninLink(){
		signInLink.click();
	}
	public String verifyLoginPageTitle(){
		return driver.getTitle();
	}
	
	public void enterAccountDetails(){
		
		//emailCreateInput.sendKeys(prop.getProperty("emailId"));
		
		emailCreateInput.sendKeys(TestUtil.getSheetData(1, 0));
		createAccountButton.click();	
		firstName.sendKeys(TestUtil.getSheetData(1, 1));
		lastName.sendKeys(TestUtil.getSheetData(1, 2));
		password.sendKeys(TestUtil.getSheetData(1, 3));
		address.sendKeys(TestUtil.getSheetData(1, 4));
		city.sendKeys(TestUtil.getSheetData(1, 7));
		state.sendKeys(TestUtil.getSheetData(1, 8));
		postalCode.sendKeys(TestUtil.getSheetData(1, 9));
		mobilePhone.sendKeys(TestUtil.getSheetData(1, 10));
		aliasAddress.clear();
		aliasAddress.sendKeys(TestUtil.getSheetData(1, 11));
		registerButton.click();
		System.out.println("User is created successfully...");
		
	}
	public String verifyAccount(){
		String user = usernameText.getText();
		return user;
	}

}
