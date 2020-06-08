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

public class ITTrainingPage {

	
	public WebDriver driver;
	//NOTE= modify the page objectsbelow
//	private By signin=By.cssSelector("a[href*='sign_in']");
//	private By title=By.cssSelector(".text-center>h2");
//	private By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
//	By dropMonth=By.id("month");
	By itTraining=By.xpath("/html/body/div[1]/div/header[1]/div/div/div/div[2]/div/nav/ul/li[5]/a/span/span[1]/span[2]");
	By imageITTraining=By.xpath("/html/body/div[1]/div/div[2]/div/div[1]");
	By radioButtonDataScience=By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div[4]/div/div[2]/nf-fields-wrap/nf-field[6]/div/div[2]/div/div[2]/ul/li[1]/input");
	By radioManualTesting=By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div[4]/div/div[2]/nf-fields-wrap/nf-field[6]/div/div[2]/div/div[2]/ul/li[2]/input");
	By radioAutomationTesting=By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div[4]/div/div[2]/nf-fields-wrap/nf-field[6]/div/div[2]/div/div[2]/ul/li[3]/input");
	By radioSAP=By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div[4]/div/div[2]/nf-fields-wrap/nf-field[6]/div/div[2]/div/div[2]/ul/li[4]/input");
//	By subjectBlank=By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/form/p[3]/label/span/input");
//	By yourMessageBlank=By.xpath("//*[@id=\"wpcf7-f6006-p5505-o1\"]/form/p[4]/label/span/textarea");
//	
	
	
	
	
	public ITTrainingPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	public  void openITTrainingNewWindow() throws AWTException {
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(itTraining)).contextClick().build().perform();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	public void switchToITTrainingWindow() {
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
	
	public WebElement  checkImageITTraining()
	{
		return driver.findElement(imageITTraining);
	}
	public void  clickRadioButtonDataScience()
	{
		driver.findElement(radioButtonDataScience).click();
	}
	public WebElement  checkRadioButtonDataScience()
	{
		return driver.findElement(radioButtonDataScience);
	}
	public void  clickRadioButtonManualTesting()
	{
		driver.findElement(radioManualTesting).click();
	}
	public WebElement  checkRadioButtonManualTesting()
	{
		return driver.findElement(radioManualTesting);
	}
	public void  clickRadioButtonAutomationTesting()
	{
		driver.findElement(radioAutomationTesting).click();
	}
	public WebElement  checkRadioButtonAutomationTesting()
	{
		return driver.findElement(radioAutomationTesting);
	}
	public void  clickRadioButtonSAP()
	{
		driver.findElement(radioSAP).click();
	}
	public WebElement  checkRadioButtonSAP()
	{
		return driver.findElement(radioSAP);
	}

	
	
}
