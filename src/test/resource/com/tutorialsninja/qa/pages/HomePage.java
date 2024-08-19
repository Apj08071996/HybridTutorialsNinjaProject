package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//OBJECTS
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myaccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText ="Register")
	private WebElement registerOption;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchBoxFeild;
	
	@FindBy(xpath ="//div[@id='search']//button")
	private WebElement searchButton;
	
	//ACTIONS
	
	public void clickOnMyaccountDropMenu()
	{
		myaccountDropMenu.click();
	}
	
	public LoginPage clickOnLoginOption()
	{
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage clickOnRegisterOption()
	{
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public void enterProductIntoSearchBoxFeild(String productName)
	{
		searchBoxFeild.sendKeys(productName);
	}
	
	public SearchPage clickOnSearchButton()
	{
		searchButton.click();
		return new SearchPage(driver);
	}
	
}
