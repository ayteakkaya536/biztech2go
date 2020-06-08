//NOTE=Modify package name
package com.biztech2go;

import java.awt.AWTException;
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

import pageObjects.AboutUsPage;
import pageObjects.ContactUsPage;
import pageObjects.MainPage;
import resources.DriverInitilization;

public class TestAboutUsPage extends DriverInitilization{
	
	public static Logger log =LogManager.getLogger(DriverInitilization.class.getName());
	public static AboutUsPage page;
	 
	@BeforeTest
	public void initialize() throws IOException, AWTException, InterruptedException
	{
		driver =initializeDriver();
		driver.get(prop.getProperty("url"));
	
		driver.manage().window().maximize();
		
		
		page=new AboutUsPage(driver);
		page.openAboutUSNewTab();
		Thread.sleep(2000);
		page.switchToAboutUSTab();
	}
	
	@Test
	public void validateHeaderVision()
	{
		
		Assert.assertTrue(page.checkHeaderVision().isDisplayed());
		log.info("AboutUS page Vision header is displayed");
		System.out.println("passed AboutUS page Vision header display");
		
		
	}
	@Test
	public void validateHeaderMission()
	{
		
		Assert.assertTrue(page.checkHeaderMission().isDisplayed());
		log.info("AboutUS page Mission header is displayed");
		System.out.println("passed AboutUS page Mission header display");
		
		
	}
	@Test
	public void validateHeaderOurValues()
	{
		
		Assert.assertTrue(page.checkHeaderOurValues().isDisplayed());
		log.info("AboutUS page OurValues header is displayed");
		System.out.println("passed AboutUS page OurValues header display");
		
		
	}
	@Test
	public void validatePraphFontSize()
	{
		
		Assert.assertEquals(page.checkPraphFontSize(), "14px");
		log.info("AboutUS page PraphFontSize validated");
		System.out.println("passed AboutUS page PraphFontSize");
		
		
	}
	@Test
	public void validatePraphBackgroundColor()
	{
		System.out.println(page.checkBackgroundColor());
		Assert.assertEquals(page.checkBackgroundColor(), "rgba(255, 255, 255, 1)");
		log.info("AboutUS page PraphBackgroundColor validated");
		System.out.println("passed AboutUS page PraphBackgroundColor");
		
		
	}

	
	@AfterTest
	public void teardown()
	{
		
		driver.quit();
		driver=null;
		
	}
}
