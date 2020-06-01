package com.biztech2go;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.xxSecondPage;
import pageObjects.MainPage;
import resources.DriverInitilization;

public class xxValidateTitle extends DriverInitilization{
	public static Logger log =LogManager.getLogger(DriverInitilization.class.getName());
	xxSecondPage scndPage;
	 
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 log.info("Driver is initialized");
			
		 driver.get(prop.getProperty("url"));
		 log.info("Navigated to Home page");
	}
	@Test
	
	public void validateAppTitle() throws IOException
	{
		//one is inheritance
		// creating object to that class and invoke methods of it
		scndPage=new xxSecondPage(driver);
		//compare the text from the browser with actual text.- Error..
		Assert.assertEquals(scndPage.getTitle().getText(), "FEATURED CO123URSES");
		 log.info("Successfully validated Text message");
		 System.out.println("Test completed");
		 
		}
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}

	

	
}