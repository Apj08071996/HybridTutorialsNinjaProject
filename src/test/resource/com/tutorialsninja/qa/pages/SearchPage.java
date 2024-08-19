package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage 
{
	public WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText ="HP LP3065")
	private WebElement validProduct;
	
	@FindBy(xpath ="//input[@id='button-search']/following-sibling::p")
	private WebElement noProductMatchSearchCriteria;
	
	public String getNoProductMatchSearchCriteriaText()
	{
		return noProductMatchSearchCriteria.getText();
	}
	
	public boolean displayStatusValidProduct()
	{
		return validProduct.isDisplayed();
	}
  
}
