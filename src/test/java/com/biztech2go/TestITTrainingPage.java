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
import pageObjects.ITTrainingPage;
import pageObjects.MainPage;
import resources.DriverInitilization;

public class TestITTrainingPage extends DriverInitilization{
	
	public static Logger log =LogManager.getLogger(DriverInitilization.class.getName());
	public static ITTrainingPage page;
	 
	@BeforeTest
	public void initialize() throws IOException, AWTException, InterruptedException
	{
		driver =initializeDriver();
		driver.get(prop.getProperty("url"));
	
		driver.manage().window().maximize();
		
		
		page=new ITTrainingPage(driver);
		page.openITTrainingNewWindow();
		Thread.sleep(2000);
		page.switchToITTrainingWindow();
	}
	@Test
	public void verifyITTrainingPageTitle() throws IOException, InterruptedException
	{
		
		Assert.assertEquals(driver.getTitle(), "IT Training | BizTech2go");
		
		log.info("Successfully validated IT Training page title");
		System.out.println("IT Training page title validation completed");
	}
	
	@Test
	public void validateImageITTraining()
	{
		
		Assert.assertTrue(page.checkImageITTraining().isDisplayed());
		log.info("IT Training page imageITTraining is displayed");
		System.out.println("passed IT Training page imageITTraining display");
		
		
	}
	@Test
	public void validateDataScienceSelection()
	{
		page.clickRadioButtonDataScience();
		Assert.assertTrue(page.checkRadioButtonDataScience().isSelected());
		log.info("IT Training page DataScienceSelection is verified");
		System.out.println("passed IT Training page DataScienceSelection verified");
	}
	@Test
	public void validateManuelTestingSelection()
	{
		page.clickRadioButtonManualTesting();
		Assert.assertTrue(page.checkRadioButtonManualTesting().isSelected());
		log.info("IT Training page ManuelTestingSelection is verified");
		System.out.println("passed IT Training page ManuelTestingSelection verified");
	}
	@Test
	public void validateAutomationTestingSelection()
	{
		page.clickRadioButtonAutomationTesting();
		Assert.assertTrue(page.checkRadioButtonAutomationTesting().isSelected());
		log.info("IT Training page AutomationTestingSelection is verified");
		System.out.println("passed IT Training page AutomationTestingSelection verified");
	}
	@Test
	public void validateSAPSelection()
	{
		page.clickRadioButtonSAP();
		Assert.assertTrue(page.checkRadioButtonSAP().isSelected());
		log.info("IT Training page SAPSelection is verified");
		System.out.println("passed IT Training page SAPSelection verified");
	}


	
	@AfterTest
	public void teardown()
	{
		
		driver.quit();
		driver=null;
		
	}
}
