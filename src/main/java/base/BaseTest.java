package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class BaseTest {

    protected static WebDriver driver;
    protected static Properties prop;

    static
    {
      try {
           FileInputStream fip=new FileInputStream("src/main/resources/config.properties");
            prop=new Properties();
            prop.load(fip);
            String ApplicationURL = null;
            if(System.getenv("ENV")==null)
            {
                ApplicationURL=prop.getProperty("URL").replace("###","www");
            }
            else
            {
                ApplicationURL=prop.getProperty("URL").replace("###",System.getenv("ENV"));
            }
            prop.setProperty("URL",ApplicationURL);
            prop.getProperty("browser");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };

    public void setUp()
    {
        if(prop.getProperty("browser").equals("Chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (System.getenv("CI") != null) {
                options.addArguments("--headless");
                System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
           }
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        else if(prop.getProperty("browser").equals("IE")) {
            driver = new InternetExplorerDriver();
        }
        else if(prop.getProperty("browser").equals("Firefox")) {
            driver = new FirefoxDriver();
        }
        else
        {
            throw new IllegalArgumentException("Input browser is invalid");
        }
    }


    public void tearDown()
    {
        if (driver!=null)
        {
            driver.quit();
        }
    }

}
