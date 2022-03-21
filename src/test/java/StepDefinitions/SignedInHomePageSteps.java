package StepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OrderStatusPage;
import pages.SignedInHomepage;

public class SignedInHomePageSteps extends BaseTest {
	
   SignedInHomepage signedinhomepage=new SignedInHomepage();
   OrderStatusPage orderstatuspage=new OrderStatusPage();
	
   @Then("user is in signedinhome page")
	public void user_is_in_landing_page() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(base.Constants.EXPLICITLY_WAIT));
		WebElement image=driver.findElement(By.xpath("//img[@alt='Accessibility Widget']"));
		wait.until(ExpectedConditions.visibilityOf(image));
		Assert.assertEquals("Manage Your Account",signedinhomepage.linkPresent());
		
	 
	}
 
	@When("he clicks on the order status link")
	public void he_clicks_on_the_order_status_link() throws IOException {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(base.Constants.EXPLICITLY_WAIT));
		WebElement image=driver.findElement(By.xpath("//img[@alt='Accessibility Widget']"));
		wait.until(ExpectedConditions.visibilityOf(image));
		signedinhomepage.gotoOrderStatus();
	   
	}

}
