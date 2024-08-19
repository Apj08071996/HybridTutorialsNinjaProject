package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//objects
	
	@FindBy(id="input-email")
	private WebElement emailAddressFeild;
	
	@FindBy(id="input-password")
	private WebElement passwordFeild;
	
	@FindBy(xpath ="//input[@type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath ="//div[contains(@class,'alert-dismissible')]")
	private WebElement emailAddressPasswordNotMatcingWarning;
	
	//actions
	
	public void enterEmailAddress(String email)
	{
		emailAddressFeild.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		passwordFeild.sendKeys(password);
	}
	
	public AccountPage clickOnLoginButton()
	{
		loginButton.click();
		return new AccountPage(driver);
	}
	
	
	public String getEmailAddressPasswordNotMatchingText()
	{
		return emailAddressPasswordNotMatcingWarning.getText();
	}
}
