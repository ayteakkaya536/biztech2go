package com.biztech2go;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ContactUsPage;
import pageObjects.MainPage;
import pageObjects.TelecomServicesPage;
import resources.DriverInitializationLocal;
import resources.DriverInitilization;


public class TestTelecomServicesPage extends DriverInitilization{
	
	public static Logger log =LogManager.getLogger(DriverInitilization.class.getName());
	TelecomServicesPage page;
	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 driver.get(prop.getProperty("url"));
		
		 
		 driver.manage().window().maximize();
		 page=new TelecomServicesPage(driver);
		 page.clickTelecomServices();
		 
		
	}
	
	@Test
	public void verifyTelecomServicesTitle() 
	{
		
		Assert.assertEquals(driver.getTitle(), "Telecom Infrastructure and Construction Services – Tower Solutions – Installation, Maintenance and Deconstruction");
		
		log.info("Successfully validated TelecomServices title");
		System.out.println("TelecomServices title validation completed");
	}
	
	@Test
	
	public void validateAddressPresence()
	{

		
		Assert.assertTrue(page.checkAddress().isDisplayed());
		
		log.info("Successfully validated address presence");
		System.out.println("Address presence validation completed");
		 
	}
	
	@Test
	public void validatePhoneNumber()
	{
		
		Assert.assertEquals(page.checkPhoneNumber().getText(), "4054920362");
		
		log.info("Successfully validated phone number");
		System.out.println("Phone Number validation completed");
	}
	@Test
	public void verifyRequestQuotePresence() 
	{
		
		Assert.assertTrue(page.checkRequestQuote().isDisplayed());
		
		log.info("Successfully verified RequestQuotePresence");
		System.out.println("RequestQuotePresence verification completed");
	}
	@Test
	public void verifyImageVerizonPresence() 
	{
		
		Assert.assertTrue(page.checkImageVerizon().isDisplayed());
		
		log.info("Successfully verified ImageVerizonPresence");
		System.out.println("ImageVerizonPresence verification completed");
	}




	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}

	

	
}
