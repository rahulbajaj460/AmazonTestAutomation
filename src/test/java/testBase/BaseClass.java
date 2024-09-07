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
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException
	{
	
		//loading properties file
		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);
		 
		//loading log4j file
		logger=LogManager.getLogger(this.getClass());//Log4j
		
		System.out.println(p.getProperty("execution_env"));
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
	 	{	
		
			DesiredCapabilities capabilities=new DesiredCapabilities();
		
			//OS
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else
			{
				System.out.println("No matching os..");
				return;
			}
		
			//Browser
			switch(br.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome"); break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No matching browser.."); return;
			}
		
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		
	    }
		else if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//launching browser based on condition - locally
			switch(br.toLowerCase())
			{
				case "chrome": 
					driver=new ChromeDriver(); 
					break;
					
				case "edge": 
					driver=new EdgeDriver(); 
					break;
					
				default: 
					System.out.println("No matching browser..");
					return;
			}
		}
		
		
		//driver=new ChromeDriver(); 
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
