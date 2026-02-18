package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.RevenueCalculatorPage;
import reports.NewReports;
import utils.WaitUtils;

public class RevenueCalculatorSteps extends BaseTest {

	RevenueCalculatorPage revenueCalculator;
	NewReports newreports;

	@Before("@ui")
	public void OpenBrowser()
	{
		setUp();
	}

	@After("@ui")
	public void TearDown(Scenario scenario) 
	{
		tearDown();
	}

	@Given("user is in check motor vehicle stamp duty page")
	public void user_is_in_check_motor_vehicle_stamp_duty_page() {
		revenueCalculator=new RevenueCalculatorPage();
		driver.manage().window().maximize();
		String URL=prop.getProperty("URL");
		driver.get(URL);
	}

	@When("clicks on the Check Online Button")
	public void clicks_on_the_check_online_button() {
		newreports=new NewReports();
		WaitUtils.waitforelementToBeClickable(driver, By.xpath("//a[@role='button' and normalize-space()='Check online']"),base.Constants.EXPLICITLY_WAIT);
		driver.findElement(By.xpath("//a[@role='button' and normalize-space()='Check online']")).click();
	}

	@Then("user will see Revenue NSW calculator page")
	public void user_will_see_revenue_nsw_calculator_page() {
		Assert.assertEquals(revenueCalculator.getHeading(),"Motor vehicle registration duty calculator");
	}

	@Given("user click yes and enters vehicle amount")
	public void user_click_yes_and_vehicle_amount() {
		WaitUtils.waitforelementToBeClickable(driver, By.cssSelector("label[for='passenger_Y']"),base.Constants.EXPLICITLY_WAIT);
		revenueCalculator.selectRadioButton();
		revenueCalculator.enterAmount(String.valueOf(50000));
	}

	@When("click the calculate button")
	public void click_the_calculate_button() {
		revenueCalculator.clickCalculateButton();
	}

	@Then("user will see valid contents in a pop up window")
	public void user_will_see_valid_contents_in_a_pop_up_window() {

		WebElement modal =WaitUtils.waitforElementVisible(driver,By.className("confirm-modal"),5);
		String expectedTitle = "Calculation";
		WebElement modalTitle = modal.findElement(By.className("modal-title"));
		Assert.assertEquals(modalTitle.getText(), expectedTitle);

		WebElement calculationPopup = driver.findElement(By.xpath("//h4[normalize-space()='Motor vehicle registration']"));
		Assert.assertEquals(calculationPopup.getText(), "Motor vehicle registration");

		WebElement passengerValue = modal.findElement(By.xpath("//td[text()='Is this registration for a passenger vehicle?']/following-sibling::td[@class='focus right']"));
		Assert.assertEquals(passengerValue.getText(), "Yes");

		WebElement purchaseValue = modal.findElement(By.xpath("//td[text()='Purchase price or value']/following-sibling::td[@class='focus right']"));
		Assert.assertEquals(purchaseValue.getText(), "$50,000.00");

		WebElement dutyValue = modal.findElement(By.xpath("//td[text()='Duty payable ']/following-sibling::td"));
		Assert.assertEquals(dutyValue.getText(), "$1,600.00");
	}
}
