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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverInitializationLocal {

	public static WebDriver driver; //if you would like to run the test cases parallel, remove the static
	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
	
		prop= new Properties();
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		//NOTE= mvn test -Dbrowser=chrome
		//String browserName=System.getProperty("browser");
		String browserName=prop.getProperty("browser"); //Disabled, mvn chooses the browser type
		System.out.println(browserName);
		
		
		

		
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Driver\\chromedriver.exe");
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
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Driver\\geckodriver.exe");
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
			System.setProperty("webdriver.XXXX.driver", System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Driver\\XXXX.exe");
			ChromeOptions options = new ChromeOptions();
			//	IE code
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public void getScreenshot(String result) throws IOException
	{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C://test//"+result+"screenshot.png"));
	}


}
