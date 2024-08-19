package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage
{
	public WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	@FindBy(id="input-firstname")
	private WebElement firstNameFeild;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameFeild;
	
	@FindBy(id="input-email")
	private WebElement emailAddressFeild;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneNumberFeild;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement passwordFeild;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordFeild;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private WebElement privacyPolicyCheckboxfeild;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement continueButtonFeild;
	
	@FindBy(xpath="//label[text()='Subscribe']/following-sibling::div//input[@value='1']")
	private WebElement yesNewsLetterOptionRadioButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailWarning;
	
	@FindBy(xpath ="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarningMessage;
	
	@FindBy(xpath ="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarningMessage;
	
	@FindBy(xpath ="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarningMessage ;
	
	@FindBy(xpath ="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarningMessage;
	
	@FindBy(xpath ="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarningMessage;
	
	@FindBy(xpath ="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarningMessage;
	
	
	//Actions
	
	public void enterFirstName(String firstName)
	{
		firstNameFeild.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName)
	{
		lastNameFeild.sendKeys(lastName);
	}
	
	public void enterEmailAddress(String email)
	{
		emailAddressFeild.sendKeys(email);
	}
	
	public void enterTelephoneNumber(String telephone)
	{
		telephoneNumberFeild.sendKeys(telephone);
	}
	
	public void enterPassword(String password)
	{
		passwordFeild.sendKeys(password);
	}
	
	public void enterConfirmPassword(String password)
	{
		confirmPasswordFeild.sendKeys(password);
	}
	
	public void clickOnPrivacyPolicyCheckBoxFeild()
	{
		privacyPolicyCheckboxfeild.click();
	}
	
	public AccountSucessPage clickOnContinueButton()
	{
		continueButtonFeild.click();
		return new AccountSucessPage(driver);
	}
	
	public void clickOnYesRadioButton()
	{
		yesNewsLetterOptionRadioButton.click();
	}
	
	public String displayStatusOfDuplicateEmailText()
	{
		return duplicateEmailWarning.getText();
	}
	
	public String actualPrivacyPolicyWarningMessageText()
	{
		return privacyPolicyWarningMessage.getText();
	}
	
	public String actualFirstNameWarningMessage()
	{
		return firstNameWarningMessage.getText();
	}
	
	public String actualLastNameWarningMessage()
	{
		return lastNameWarningMessage.getText();
	}
	
	public String actualEmailWarningMessage()
	{
		return emailWarningMessage.getText();
	}
	
	public String actualTelephoneWarningMessage()
	{
		return telephoneWarningMessage.getText();
	}
	
	public String actualPasswordWarningMessage()
	{
		return passwordWarningMessage.getText();
	}
}
