package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	
	/* WebDriver
	 * Properties
	 * Logs
	 * ExtentReports
	 * DB
	 * Excel
	 * Mail
	 */
	
	public static WebDriver driver;
	public static Properties config= new Properties();
	public static Properties OR= new Properties();
	public static FileInputStream fis;

	@BeforeSuite
	public void setUp() {
		
		if(driver==null) {
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(config.getProperty("browser").equalsIgnoreCase("chrome"))
				driver= new ChromeDriver();
			
			if(config.getProperty("browser").equalsIgnoreCase("firefox"))
				driver= new FirefoxDriver();
			
			driver.get(config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait"),TimeUnit.SECONDS));
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@AfterSuite
	public void tearDown() {
		
		//if(driver!=null)
		//driver.close();
		
	}

}
