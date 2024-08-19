package com.tutorialsninja.qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSucessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utility;

public class RegisterTest extends Base
{
	public WebDriver driver;
	RegisterPage registerPage;
	AccountSucessPage accountSucessPage;
	
	
	@BeforeMethod
	public void setup()
	{
		driver=initializeBrowserAndOpenApplicationUrl("Chrome");
		
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyaccountDropMenu();
		registerPage=homePage.clickOnRegisterOption();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyRegisterAccountWithMandatoryFeild()
	{
		
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(Utility.genrateEmailWithTimeStamp());
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPassword(dataProp.getProperty("password"));
		registerPage.enterConfirmPassword(dataProp.getProperty("confirmPassword"));
		registerPage.clickOnPrivacyPolicyCheckBoxFeild();
		accountSucessPage=registerPage.clickOnContinueButton();
		
		Assert.assertTrue(accountSucessPage.displayStatusOfAccountHasBeenCreatedText());
		
		
	}
	
	@Test(priority=2)
	public void verifyRegisterAccountWithAllFeild()
	{
	
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(Utility.genrateEmailWithTimeStamp());
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPassword(dataProp.getProperty("password"));
		registerPage.enterConfirmPassword(dataProp.getProperty("confirmPassword"));
		registerPage.clickOnYesRadioButton();
		registerPage.clickOnPrivacyPolicyCheckBoxFeild();
		accountSucessPage=registerPage.clickOnContinueButton();
		
		Assert.assertTrue(accountSucessPage.displayStatusOfAccountHasBeenCreatedText());
		
	
		
	}
	
	@Test(priority =3)
	public void registerAccountWithDuplicateEmailAddressFeild()
	{
		
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmailAddress(prop.getProperty("validEmail"));
		registerPage.enterTelephoneNumber(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPassword(dataProp.getProperty("password"));
		registerPage.enterConfirmPassword(dataProp.getProperty("confirmPassword"));;
		registerPage.clickOnPrivacyPolicyCheckBoxFeild();
		registerPage.clickOnContinueButton();
		
		String actualEmailWarningText = registerPage.displayStatusOfDuplicateEmailText();
		Assert.assertTrue(actualEmailWarningText.contains(dataProp.getProperty("emailAddressAlreadyRegisterWarningText")));
		
	}
	
	@Test(priority = 4)
	public void registerAccountWithoutUsingAnyFeild()
	{
		
		
		registerPage.clickOnContinueButton();
		Assert.assertEquals(registerPage.actualPrivacyPolicyWarningMessageText(),dataProp.getProperty("privacyPolicyWarningText"));
		Assert.assertEquals(registerPage.actualFirstNameWarningMessage(),dataProp.getProperty("firstNameWarningText"));
		Assert.assertEquals(registerPage.actualLastNameWarningMessage(),dataProp.getProperty("lastNameWarnigText"));
		Assert.assertEquals(registerPage.actualEmailWarningMessage(),dataProp.getProperty("emailWarningText"));
		Assert.assertEquals(registerPage.actualTelephoneWarningMessage(),dataProp.getProperty("telephoneWarningText"));
		Assert.assertEquals(registerPage.actualPasswordWarningMessage(),dataProp.getProperty("passwordWarningText"));
		
		
	
	}
	
	
}
