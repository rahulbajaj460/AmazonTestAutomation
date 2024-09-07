package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {

	static public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	//@BeforeClass
	@BeforeSuite
	public void setup() throws IOException
	{
	
		//loading properties file
		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);
		 
		//loading log4j file
		logger=LogManager.getLogger(this.getClass());//Log4j
		
		driver=new ChromeDriver(); 
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	

	//@AfterClass
	@AfterSuite
	public void tearDown()
	{
		driver.close();
	}
	
	
	public String getEmail() throws IOException
	{
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		return p.getProperty("mobile");
	}
	
	public String getPassword() throws IOException
	{
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		return p.getProperty("password");
	}
	
	public String getSearchProduct() throws IOException
	{
		FileReader file=new FileReader(".//src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		return p.getProperty("searchProductName");
	}
}
