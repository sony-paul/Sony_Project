package StepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OrderStatusPage;



public class OrderStatusPageSteps extends BaseTest {

	OrderStatusPage orderstatuspage=new OrderStatusPage();

	@When("clicks on the sign in again")
	public void clicks_on_the_sign_in_again() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(base.Constants.EXPLICITLY_WAIT));
		WebElement image=driver.findElement(By.xpath("//img[@alt='Accessibility Widget']"));
		wait.until(ExpectedConditions.visibilityOf(image));
		orderstatuspage.clicknewSignin();
	}

	@Given("user is in OrderStatus Page")
	public void user_is_in_order_status_page() {
		Assert.assertEquals("store1 orders - fishersci-co",orderstatuspage.getOSTitle());
	}
	
	@When("he clicks on the items tab")
	public void he_clicks_on_the_items_tab() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(base.Constants.EXPLICITLY_WAIT));
		WebElement image=driver.findElement(By.xpath("//img[@alt='Accessibility Widget']"));
		wait.until(ExpectedConditions.visibilityOf(image));
		orderstatuspage.clickItems();
	}
	@Then("he will get all items")
	public void he_will_get_all_items() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(base.Constants.EXPLICITLY_WAIT));
		WebElement image=driver.findElement(By.xpath("//img[@alt='Accessibility Widget']"));
		wait.until(ExpectedConditions.visibilityOf(image));
		Assert.assertEquals("No Search Results Found. Please try another search.",orderstatuspage.getOSItemstext());


	}




}
