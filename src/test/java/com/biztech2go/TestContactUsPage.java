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

import pageObjects.ContactUsPage;
import pageObjects.MainPage;
import resources.DriverInitilization;

public class TestContactUsPage extends DriverInitilization{
	
	public static Logger log =LogManager.getLogger(DriverInitilization.class.getName());
	public static ContactUsPage page;
	 
	@BeforeTest
	public void initialize() throws IOException, AWTException, InterruptedException
	{
		driver =initializeDriver();
		driver.get(prop.getProperty("url"));
	
		driver.manage().window().maximize();
		
		
		page=new ContactUsPage(driver);
		page.openContactNewTab();
		Thread.sleep(2000);
		page.switchToContactUSTab();
	}
	
	@Test
	public void validateEmptyNameEmailError() throws IOException, InterruptedException
	{
		
		page.clickSend();
		Thread.sleep(2000);
		Assert.assertEquals(page.nameEmptyError(), "The field is required.");
		log.info("ContactUS page name error is verified");
		System.out.println("passed ContactUS page name error");
		Assert.assertEquals(page.emailEmptyError(), "The field is required.");
		log.info("ContactUS page empty email error is verified");
		System.out.println("passed ContactUS page empty email error");
		
	}
	@Test
	public void validateNameBlankTyping() throws IOException, InterruptedException
	{
		page.getNameBlank().sendKeys("AAA");
		Assert.assertEquals(page.getNameBlank().getAttribute("value"), "AAA");
		log.info("ContactUS page name blank typing is verified");
		System.out.println("passed ContactUS page name blank typing");
		page.getNameBlank().clear();
		
	}
	@Test
	public void validateEmailBlankTyping() throws IOException, InterruptedException
	{
		page.getEmailBlank().sendKeys("BBB");
		Assert.assertEquals(page.getEmailBlank().getAttribute("value"), "BBB");
		log.info("ContactUS page email blank typing is verified");
		System.out.println("passed ContactUS page email blank typing");
		page.getEmailBlank().clear();
		
	}
	@Test
	public void validateSubjectBlankTyping() throws IOException, InterruptedException
	{
		page.getSubjectBlank().sendKeys("CCC");
		Assert.assertEquals(page.getSubjectBlank().getAttribute("value"), "CCC");
		log.info("ContactUS page subject blank typing is verified");
		System.out.println("passed ContactUS page subject blank typing");
		page.getSubjectBlank().clear();
		
	}
	@Test
	public void validateMessageBlankTyping() throws IOException, InterruptedException
	{
		page.getyourMessageBlank().sendKeys("DDD");
		Assert.assertEquals(page.getyourMessageBlank().getAttribute("value"), "DDD");
		log.info("ContactUS page message blank typing is verified");
		System.out.println("passed ContactUS page message blank typing");
		page.getyourMessageBlank().clear();
		
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.quit();
		driver=null;
		
	}
}
