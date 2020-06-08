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

public class ContactUsPage {

	
	public WebDriver driver;
	//NOTE= modify the page objectsbelow
//	private By signin=By.cssSelector("a[href*='sign_in']");
//	private By title=By.cssSelector(".text-center>h2");
//	private By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
//	By dropMonth=By.id("month");
	By contactUS=By.xpath("/html/body/div[1]/div/header[1]/div/div/div/div[2]/div/nav/ul/li[7]/a/span/span[1]/span[2]");
	By send=By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/p[5]/input");
	By nameEmptyError=By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/p[1]/label/span/span");
	By emailEmptyError=By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/p[2]/label/span/span");
	By nameBlank=By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/p[1]/label/span/input");
	By emailBlank=By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/p[2]/label/span/input");
	By subjectBlank=By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/p[3]/label/span/input");
	By yourMessageBlank=By.xpath("//*[@id=\"wpcf7-f6006-p5505-o1\"]/form/p[4]/label/span/textarea");
	
	
	
	
	
	public ContactUsPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	public  void openContactNewTab() throws AWTException {
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(contactUS)).contextClick().build().perform();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	public void switchToContactUSTab() {
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
	
	public void  clickSend()
	{
		driver.findElement(send).click();
	}
	public String nameEmptyError() {
		return driver.findElement(nameEmptyError).getText();
	}
	public String emailEmptyError() {
		return driver.findElement(emailEmptyError).getText();
	}
	
	public WebElement getNameBlank() {
		return driver.findElement(nameBlank);
	}
	public WebElement getEmailBlank() {
		return driver.findElement(emailBlank);
	}
	public WebElement getSubjectBlank() {
		return driver.findElement(subjectBlank);
	}
	public WebElement getyourMessageBlank() {
		return driver.findElement(yourMessageBlank);
	}	
}
