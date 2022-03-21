package StepDefinitions;

import java.time.Duration;
import org.junit.Assert;
import org.junit.runners.Parameterized.BeforeParam;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
//import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandingPage;
import reports.NewReports;

public class LandingPageSteps extends BaseTest {
	
LandingPage landingpage;	
NewReports newreports;
   
	@Before
   	public void OpenBrowser() 
	{
		initBrowser();
	}
	@After
	public void TearDown(Scenario scenario) 
	{
		
		if (scenario.isFailed())
		{
			final byte[] scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(scr, "image/png", scenario.getId());

		}
		
		teardown();
		
	}
    
	
	@Given("user is in Landing page")
	public void user_is_in_landing_page() {
		landingpage=new LandingPage();
		String URL=prop.getProperty("ApplicationURL");
		driver.get(URL);
		WebElement frameElement=driver.findElement(By.xpath("//iframe[@class='truste_popframe']"));
		driver.switchTo().frame(frameElement);	
		driver.findElement(By.xpath("//a[text()='Agree and Proceed']")).click();
		driver.findElement(By.xpath("//a[@class='close']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(base.Constants.EXPLICITLY_WAIT));
		WebElement image=driver.findElement(By.xpath("//img[@alt='Accessibility Widget']"));
		wait.until(ExpectedConditions.visibilityOf(image));

	}

	@Then("the title of the page will be correct")
	public void the_title_of_the_page_will_be_correct() {
		String ExpectedTitle="Order Status1";
		newreports=new NewReports();
		Assert.assertEquals(ExpectedTitle, landingpage.getTitle());
	}	
	

	@When("clicks on the sign in")
	public void clicks_on_the_sign_in() {
		landingpage.Signin();
	}
	
	@Then("user sign in will be a success")
	public void user_sign_in_will_be_a_success() {
		
	}
	
	
}
