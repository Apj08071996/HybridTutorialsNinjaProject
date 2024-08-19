package com.tutorialsninja.qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends Base
{
	public WebDriver driver;
	SearchPage searchPage;
	
	@BeforeMethod
	public void setup()
	{
		driver=initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void searchValidProduct()
	{
		HomePage homePage=new HomePage(driver);
		homePage.enterProductIntoSearchBoxFeild(dataProp.getProperty("validProduct"));
		searchPage=homePage.clickOnSearchButton();
		
		Assert.assertTrue(searchPage.displayStatusValidProduct());
	
	}
	
	@Test(priority = 2)
	public void searchInvalidProduct()
	{
		HomePage homePage=new HomePage(driver);
		homePage.enterProductIntoSearchBoxFeild(dataProp.getProperty("invalidProduct"));
		searchPage=homePage.clickOnSearchButton();
	
		
		Assert.assertEquals(searchPage.getNoProductMatchSearchCriteriaText(),dataProp.getProperty("NoProductMatchText"));
	}
	
	@Test(priority =3)
	public void seachProductWithoutAnyProduct()
	{
		HomePage homePage=new HomePage(driver);
	    searchPage=homePage.clickOnSearchButton();
	
		
		Assert.assertEquals(searchPage.getNoProductMatchSearchCriteriaText(),dataProp.getProperty("NoProductMatchText"));
	}
}
	
	
	

