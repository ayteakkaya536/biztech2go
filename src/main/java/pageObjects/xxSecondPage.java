package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class xxSecondPage {

	
	public WebDriver driver;
	//NOTE= modify the page objectsbelow
	private By signin=By.cssSelector("a[href*='sign_in']");
	private By title=By.cssSelector(".text-center>h2");
	private By NavBar=By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	By dropMonth=By.id("month");
	
	
	
	
	
	public xxSecondPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	public WebElement getLogin()
	{
		System.out.println("Trying to LogIn");
		return driver.findElement(signin);
	}
	public WebElement getNavigationBar()
	{
		System.out.println("Verifiying NAvigation Bar");
		return driver.findElement(NavBar);
	}
	public WebElement getTitle()
	{
		System.out.println("Verifying Title");
		return driver.findElement(title);
	}
	
	//Example of DROP DOWN 
		public Select getDropMonth() {
			Select select=new Select(driver.findElement(dropMonth));
			return select;
		}
	
	
	
}
