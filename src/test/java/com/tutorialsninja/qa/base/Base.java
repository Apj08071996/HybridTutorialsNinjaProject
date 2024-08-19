package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorialsninja.qa.utils.Utility;

public class Base
{
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public Base()
	{
		FileInputStream fis;
		File file=new File("E:\\TutorialsNinjaHybridProj\\TutorialsNinjaHybridFramework\\src\\test\\resource\\com\\tutorialsninja\\qa\\config\\config.properties");
		
		
		try 
		{
			 fis=new FileInputStream(file);
			 prop=new Properties();
			 prop.load(fis);
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
		
		
		
		File dataFile=new File("E:\\TutorialsNinjaHybridProj\\TutorialsNinjaHybridFramework\\src\\test\\resource\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		FileInputStream dataFis;
		try {
			dataFis = new FileInputStream(dataFile);
			dataProp=new Properties();
			dataProp.load(dataFis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public WebDriver initializeBrowserAndOpenApplicationUrl(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) 
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("safari"))
		{
			driver=new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.implicit_Wait_time));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utility.page_Load_Timeout));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
}
