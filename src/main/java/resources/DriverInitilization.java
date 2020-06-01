package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInitilization {
	
	public static WebDriver driver; //if you would like to run the test cases parallel, remove the static
	public Properties prop; 
	public WebDriver initializeDriver() throws IOException
	{
		//Initialization for the external parameters NO CHANGE needed
		prop= new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		
		//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		//String browserName=System.getProperty("browser");  //activate this for maven and jenkins selection //NOTE= mvn test -Dbrowser=chrome
		String browserName=prop.getProperty("browser"); //Data.properties--- When Disabled, mvn chooses the browser type
		System.out.println("Running on browser " +browserName);

		if(browserName.contains("chrome"))
		{	//WEbDriverManager install ALL browser drivers
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			
			if(browserName.contains("headless"))
			{
			//below is to define headless browser test
			options.addArguments("headless");
			}
			driver= new ChromeDriver(options);
		}
		else if (browserName.contains("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			if(browserName.contains("headless"))
			{
			//below is to define headless browser test
			options.addArguments("headless");
			}
			
			driver= new FirefoxDriver(options);
		}
		else if (browserName.contains("IE"))
		{
			WebDriverManager.iedriver().setup();
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless"))
			{
			//below is to define headless browser test
			options.addArguments("headless");
			}
			
			driver= new EdgeDriver();
		}
		else if (browserName.contains("edge"))
		{
			WebDriverManager.edgedriver().setup();
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless"))
			{
			//below is to define headless browser test
			options.addArguments("headless");
			}
			
			driver= new EdgeDriver();
		}
		//WebDriverManager.operadriver().setup();
		

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenshot(String result) throws IOException
	{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png")); //picture location can be changed
	}


}
