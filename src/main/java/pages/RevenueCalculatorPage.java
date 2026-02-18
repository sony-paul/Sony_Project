package pages;

import base.BaseTest;
import org.openqa.selenium.By;

public class RevenueCalculatorPage extends BaseTest {

	By heading=By.xpath("//h2[normalize-space()='Motor vehicle registration duty calculator']");
	By yesOption = By.cssSelector("label[for='passenger_Y']");
	By purchasePriceInput = By.id("purchasePrice");
	By calculateBtn = By.xpath("//button[normalize-space()='Calculate']");

	public String getHeading() {
		return driver.findElement(heading).getText();
	}

    public void selectRadioButton() {
		driver.findElement(yesOption).click();
	}

	public void enterAmount(String num) {
		driver.findElement(purchasePriceInput).sendKeys(num);
	}

	public void clickCalculateButton() {
		driver.findElement(calculateBtn).click();
	}

	}


