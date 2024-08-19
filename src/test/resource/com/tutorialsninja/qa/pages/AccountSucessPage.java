package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSucessPage
{
	public WebDriver driver;
	 
	public AccountSucessPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//objects
	
	@FindBy(xpath ="//h1[text()='Your Account Has Been Created!']")
	private WebElement yourAccountHasBeenCreated;
	
	//actions
	public boolean displayStatusOfAccountHasBeenCreatedText()
	{
		return yourAccountHasBeenCreated.isDisplayed();
	}
}
