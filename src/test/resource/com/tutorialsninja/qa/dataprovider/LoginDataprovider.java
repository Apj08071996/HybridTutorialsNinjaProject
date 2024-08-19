package com.tutorialsninja.qa.dataprovider;

import org.testng.annotations.DataProvider;

import com.tutorialsninja.qa.utils.Utility;

public class LoginDataprovider 
{
	@DataProvider(name="loginDataSupplier")
	public Object[][] supplyLoginData()
	{
		Object [][] obj= Utility.readExcelFile("LoginData");
		return obj;
		
	}
}
