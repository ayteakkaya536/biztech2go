package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.ui.Select;

public class AboutUsPage {

	
	public WebDriver driver;
	//NOTE= modify the page objectsbelow
//	private By signin=By.cssSelector("a[href*='sign_in']");
//	private By title=By.cssSelector(".text-center>h2");
//	private By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
//	By dropMonth=By.id("month");
	By aboutUS=By.xpath("/html/body/div[1]/div/header[1]/div/div/div/div[2]/div/nav/ul/li[2]/a/span/span[1]/span[2]");
	By headerVision=By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[1]/div/div[1]/div/div/div/div/div/div/h3[1]");
	By headerMission=By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[1]/div/div[1]/div/div/div/div/div/div/h3[2]");
	By headerOurValues=By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[1]/div/div[1]/div/div/div/div/div/div/h3[3]");
	By textFontSize=By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div[1]/div/div[1]/div/div/div/div/div/div/p[4]");
	By backGround=By.xpath("/html/body/div[1]/div/div[2]/div/div");
//	By subjectBlank=By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/p[3]/label/span/input");
//	By yourMessageBlank=By.xpath("//*[@id=\"wpcf7-f6006-p5505-o1\"]/form/p[4]/label/span/textarea");
//	
	
	
	
	
	public AboutUsPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	public  void openAboutUSNewTab() throws AWTException {
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(aboutUS)).contextClick().build().perform();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	public void switchToAboutUSTab() {
		Set<String> windowIDs=driver.getWindowHandles();
		Iterator<String> windowIterator=windowIDs.iterator(); //initilize iterator at beginning, thus next is needed for the first one
		String parentID=windowIterator.next();
		String childID=windowIterator.next();
		driver.switchTo().window(childID);
	}
	public void switchToMainPage() {
		Set<String> windowIDs=driver.getWindowHandles();
		Iterator<String> windowIterator=windowIDs.iterator(); //initilize iterator at beginning, thus next is needed for the first one
		String parentID=windowIterator.next();
		String childID=windowIterator.next();
		driver.switchTo().window(parentID);
	}
	
	public WebElement  checkHeaderVision()
	{
		return driver.findElement(headerVision);
	}
	public WebElement  checkHeaderMission()
	{
		return driver.findElement(headerMission);
	}
	public WebElement  checkHeaderOurValues()
	{
		return driver.findElement(headerOurValues);
	}
	public String checkPraphFontSize() 
	{
		return driver.findElement(textFontSize).getCssValue("font-size");
	}
	public String checkBackgroundColor() 
	{
		return driver.findElement(backGround).getCssValue("background-color");
	}
	
	
}
