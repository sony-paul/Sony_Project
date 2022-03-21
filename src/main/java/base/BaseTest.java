package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.Scenario;


public class BaseTest {

	protected static WebDriver driver;
	protected static Properties prop;
	
	public BaseTest() {
		
		prop=new Properties();
		try {
			FileInputStream fip=new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
			prop.load(fip);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	public static void initBrowser() {
		
	//	String browser="Chrome";
	//to read from command line
	//	String browser=System.getProperty("browser");
	//	to Read from Config file
		String browser=prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/src/main/resources/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICITLY_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));


	}
	
	public void teardown() {
		
		driver.quit();
	}


}
