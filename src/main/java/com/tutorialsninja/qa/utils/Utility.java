package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Utility
{
	public static final int  implicit_Wait_time=10;
	public static final int page_Load_Timeout=10;
	
	public static String genrateEmailWithTimeStamp()
	{
		Date date=new Date();
		return "ajinkya"+date.toString().replace(" ","_").replace(":","_")+"@gmail.com";
		
	}
	
	public static Object[][] readExcelFile(String sheetName)
	{
		FileInputStream fis=null;
		XSSFWorkbook workbook=null;
		File excelfile=new File("E:\\TutorialsNinjaHybridProj\\TutorialsNinjaHybridFramework\\src\\test\\resource\\com\\tutorialsninja\\qa\\testdata\\logindata.xlsx");
		try {
			 fis=new FileInputStream(excelfile);
			 workbook=new XSSFWorkbook(fis);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int r=sheet.getLastRowNum();
	
		int c=sheet.getRow(0).getLastCellNum();
		
		
		Object [][] obj=new Object [r][c];
		
	
		for(int i=0;i<r;i++)
		{
			XSSFRow row = sheet.getRow(i+1);
			
			for(int j=0;j<c;j++)
			{
				XSSFCell cell = row.getCell(j);
				
				
				CellType celltype = cell.getCellType();
				
				switch(celltype)
				{
				    case STRING:
				    	obj[i][j]=cell.getStringCellValue();
				    	break;
				    
				    case BOOLEAN:
				    	obj[i][j]=cell.getBooleanCellValue();
				    	break;
				    case NUMERIC:
				    	obj[i][j]=Integer.toString((int)cell.getNumericCellValue());
				    	
			
				}
			}
			
			
		}
		return obj;
		
	}
	
	public static ExtentReports genrateExtentReport()
	{
		ExtentReports extentReports=new ExtentReports();
		
		File file=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extentReport.html");
				
		ExtentSparkReporter sparkReport=new ExtentSparkReporter(file);
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("TutorialsNinja Test Automation Result");
		sparkReport.config().setDocumentTitle("TN AUTOMATION REPORT");
		sparkReport.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss");
		
		extentReports.attachReporter(sparkReport);
		
	
		Properties prop=null;
		File f=new File("E:\\TutorialsNinjaHybridProj\\TutorialsNinjaHybridFramework\\src\\test\\resource\\com\\tutorialsninja\\qa\\config\\config.properties");
		
		try 
		{
		  FileInputStream fis=new FileInputStream(f);
		  prop=new Properties();
		  prop.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		extentReports.setSystemInfo("Application URL",prop.getProperty("url"));
		extentReports.setSystemInfo("Browser Name", prop.getProperty("browserName"));
		extentReports.setSystemInfo("Email",prop.getProperty("validEmail"));
		extentReports.setSystemInfo("Password", prop.getProperty("validPassword"));
		extentReports.setSystemInfo("Oprating System", System.getProperty("os.name"));
		extentReports.setSystemInfo("UserName",System.getProperty("user.name"));
		extentReports.setSystemInfo("Java Version",System.getProperty("java.version"));
	
		return extentReports;
	}
}
