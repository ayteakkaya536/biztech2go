package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class TelecomServicesPage {

	
	public WebDriver driver;
	//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
	//Modify all necessary locators below
//	By icon=By.cssSelector("body > div.qodef-wrapper > div > header.qodef-page-header > div > div > div > div.qodef-position-left > div > div > a > img.qodef-light-logo");
	By telecomServices=By.xpath("/html/body/div[1]/div/header[1]/div/div/div/div[2]/div/nav/ul/li[8]/a/span/span[1]/span[2]");
	By phoneNumber=By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/span[1]");
	By address=By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/span[2]");
	By requestQuote=By.xpath("/html/body/div[2]/div[6]/div[2]/div/div/div[3]/div[2]/div/div/a");
	By imageVerizon=By.xpath("/html/body/div[2]/div[6]/div[2]/div/div/div[3]/div[4]/div/div/div/div[1]/div/div[1]/div");
//	By dynamicMenuBack=By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div/div[3]/a[1]/span/span");
////	By dropMonth=By.id("month");
//	By bottomCopyRigth=By.xpath("/html/body/div[1]/div/footer/div/div[2]/div/div/div/div/p");
//	By scrollHowWOperate=By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[6]/div/div/div/div/div/div[1]/h4");
//	By newPageAboutUs=By.xpath("/html/body/div[1]/div/header[1]/div/div/div/div[2]/div/nav/ul/li[2]/a");
//	By newPageContactUs=By.xpath("/html/body/div[1]/div/header[1]/div/div/div/div[2]/div/nav/ul/li[7]/a/span/span[1]/span[2]");
//	By newPageOurServices=By.xpath("/html/body/div[1]/div/header[1]/div/div/div/div[2]/div/nav/ul/li[3]/a");
//	By newPageITTraining=By.xpath("/html/body/div[1]/div/header[1]/div/div/div/div[2]/div/nav/ul/li[5]/a/span/span[1]/span[2]");
////	
	
	
	//CONSTRUCTOR
	public TelecomServicesPage(WebDriver driver)
	{
		this.driver=driver;
	}
	//Web Element driver operations
	public void clickTelecomServices()
	{
		driver.findElement(telecomServices).click();
	}
	public WebElement checkPhoneNumber()
	{
		return driver.findElement(phoneNumber);
	}
	public WebElement checkAddress()
	{
		return driver.findElement(address);
	}
	public WebElement checkRequestQuote()
	{
		return driver.findElement(requestQuote);
	}
	public WebElement checkImageVerizon()
	{
		return driver.findElement(imageVerizon);
	}
	
	
	
//	public WebElement gethoveredITPartner()
//	{
//		return driver.findElement(hoveredITStaff);
//	}
//	public WebElement getDynamicFirstProposal() throws InterruptedException 
//	{
////		Actions action=new Actions(driver);
////		action.sendKeys(Keys.HOME).perform();
////		Thread.sleep(1000);
////		driver.findElement(dynamicMenuBack).click();
////		Thread.sleep(1000);
//		return driver.findElement(dymamicMenuFirstMotto);
//	}
//
////	public WebElement getLogin()
////	{
////		return driver.findElement(login);
////	}
////	//Example of DROP DOWN -SELECT
////	public Select getDropMonth()
////	{
////		Select select=new Select(driver.findElement(dropMonth));
////		return select;
////	}
////	//Example of Action- HOVER
//	public Actions gethoverITStaff() throws InterruptedException
//	{
//		Actions action=new Actions(driver);
//		return action.moveToElement(driver.findElement(hoverITStaffing));
//		 
//	}
//
////	//Actions-SCROLL
//	public WebElement getbottomCopyRigth()
//	{
//		Actions action=new Actions(driver);
//		action.sendKeys(Keys.END).perform();
//		return driver.findElement(bottomCopyRigth);
//	}
//	
//	public WebElement getScrollHowWOperate() 
//	{
//		Actions action=new Actions(driver);
//		action.moveToElement(driver.findElement(scrollHowWOperate));
//		return driver.findElement(scrollHowWOperate);
//	}
//	public void returnToMainPage()
//	{
//		driver.navigate().back();
//	}
//	public void getNewPageAboutUs()
//	{
//		driver.findElement(newPageAboutUs).click();
//	}
//	public void getNewPageContactUs()
//	{
//		driver.findElement(newPageContactUs).click();
//	}
//	public void getNewPageOurServices()
//	{
//		driver.findElement(newPageOurServices).click();
//	}
//	public void getNewPageItTraining()
//	{
//		driver.findElement(newPageITTraining).click();
//	}
//	
	
}
