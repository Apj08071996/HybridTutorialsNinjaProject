package com.tutorialsninja.qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.dataprovider.LoginDataprovider;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utility;

public class LoginTest extends Base
{
	public WebDriver driver;
	LoginPage loginPage;
	
	
	@BeforeMethod
	public void setup()
	{
		driver=initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyaccountDropMenu();
		loginPage=homePage.clickOnLoginOption();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority = 1,dataProvider ="loginDataSupplier",dataProviderClass =LoginDataprovider.class)
	public void verifyLoginWithValidCredentials(String email,String password)
	{
		
		
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		AccountPage accountPage=loginPage.clickOnLoginButton();
		boolean status =accountPage.displayStatusOfEditYourAccountInformationText();
		
		Assert.assertTrue(status);
		
		
	}
	
	
	
	@Test(priority=2)
	public void verifyLoginWithInvalidEmailAndValidPassword()
	{
		
		loginPage.enterEmailAddress(Utility.genrateEmailWithTimeStamp());
		loginPage.enterPassword(prop.getProperty("validPassword"));
		loginPage.clickOnLoginButton();
		
		String text =loginPage.getEmailAddressPasswordNotMatchingText(); 
		boolean status = text.contains(dataProp.getProperty("emailAddressAndPasswordNotMatchingText"));
		Assert.assertTrue(status);
		
		
	
	}
	
	@Test(priority=3)
	public void verifyLoginWithValidEmailAndInvalidPassword()
	{
		
		
		loginPage.enterEmailAddress("prop.getProperty(\"validEmail\")");
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		
		String text = loginPage.getEmailAddressPasswordNotMatchingText();
		boolean status = text.contains(dataProp.getProperty("emailAddressAndPasswordNotMatchingText"));
		Assert.assertTrue(status);
		
		
	}
	
	@Test(priority=4)
	public void verifyLoginWithInvalidEmailInvalidPassword()
	{
		
		
		loginPage.enterEmailAddress(Utility.genrateEmailWithTimeStamp());
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickOnLoginButton();
		
		String text = loginPage.getEmailAddressPasswordNotMatchingText();
		boolean status = text.contains(dataProp.getProperty("emailAddressAndPasswordNotMatchingText"));
		Assert.assertTrue(status);
		
		
	}
	
	@Test(priority =5)
	public void verifyLoginWithoutProvindingAnyCredentials()
	{
		
		loginPage.clickOnLoginButton();
		
		
		String text =loginPage.getEmailAddressPasswordNotMatchingText();
		boolean status = text.contains(dataProp.getProperty("emailAddressAndPasswordNotMatchingText"));
		Assert.assertTrue(status);
		
		
	}
	
	
}
