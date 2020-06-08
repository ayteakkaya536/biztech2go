package com.biztech2go;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ContactUsPage;
import pageObjects.MainPage;
import resources.DriverInitializationLocal;
import resources.DriverInitilization;


public class TestHomePage extends DriverInitilization{
	
	public static Logger log =LogManager.getLogger(DriverInitilization.class.getName());
	MainPage mainPage;
	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 log.info("Driver is initialized");
			
		 driver.get(prop.getProperty("url"));
		 log.info("Navigated to Home page");
		 
		 driver.manage().window().maximize();
		 

	}
	
	@Test
	
	public void validateIcon() throws IOException, InterruptedException
	{
		//one is inheritance
		// creating object to that class and invoke methods of it
		mainPage=new MainPage(driver);
		//compare the text from the browser with actual text.- Error..
		
		Assert.assertTrue(mainPage.getIcon().isDisplayed());
		
		log.info("Successfully validated icon");
		System.out.println("Icon validation completed");
		 
	}
	
	@Test
	public void bottomCopyRigth() throws IOException, InterruptedException
	{
		mainPage=new MainPage(driver);
		Assert.assertTrue(mainPage.getbottomCopyRigth().isDisplayed());
		
		log.info("Successfully validated bottom of the page");
		System.out.println("Copy right at bottom of page validation completed");
	}
	@Test
	public void hoverITStaffMenu() throws IOException, InterruptedException
	{
		mainPage=new MainPage(driver);
		mainPage.gethoverITStaff().build().perform();
		Thread.sleep(2000);
		Assert.assertTrue(mainPage.gethoveredITPartner().isDisplayed());
		
		log.info("Successfully validated ITStaffing hovermenu");
		System.out.println("ITStaffing hovermenu validation completed");
	}
	@Test
	public void verifyMainPageTitle() throws IOException, InterruptedException
	{
		
		Assert.assertEquals(driver.getTitle(), "BizTech2go | Technology on the Go");
		
		log.info("Successfully validated Main page title");
		System.out.println("Main page title validation completed");
	}
	@Test(dependsOnMethods= {"validateIcon"})
	public void verifyMainPageDynamicProposal()  throws IOException, InterruptedException
	{
		mainPage=new MainPage(driver);
		
		Assert.assertTrue(mainPage.getDynamicFirstProposal().isDisplayed());
		log.info("Successfully validated Main page first dynamic post");
		System.out.println("Main page first dynamic post validation completed");
	}
	@Test void verifyMainHowWOperate()
	{
		mainPage=new MainPage(driver);
//		Assert.assertEquals(mainPage.getScrollHowWOperate().toString(), "How we Operate");
		Assert.assertTrue(mainPage.getScrollHowWOperate().isDisplayed());
		
		log.info("Successfully validated Main page scroll How we Operate");
		System.out.println("Main page scroll How we Operate validation completed");
	}
	@Test void verifyAboutUsPage() throws InterruptedException
	{
		mainPage= new MainPage(driver);
		mainPage.getNewPageAboutUs();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(),"About US | BizTech2go");
		mainPage.returnToMainPage();
	}
	@Test void verifyContactUsPage() throws InterruptedException
	{
		mainPage= new MainPage(driver);
		mainPage.getNewPageContactUs();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(),"Contact Us | BizTech2go");
		mainPage.returnToMainPage();
	}
	@Test void verifyOurServicesPage() throws InterruptedException
	{
		mainPage= new MainPage(driver);
		mainPage.getNewPageOurServices();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(),"SAP services | BizTech2go");
		mainPage.returnToMainPage();
	}
	@Test void verifyItServicesPage() throws InterruptedException
	{
		mainPage= new MainPage(driver);
		mainPage.getNewPageItTraining();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(),"IT Training | BizTech2go");
		mainPage.returnToMainPage();
	}


	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		
	}

	

	
}
