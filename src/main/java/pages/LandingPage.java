package pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class LandingPage extends BaseTest {

	By signinbutton=By.xpath("//button[@class='sign-in-modal']");
	By userid=By.id("userid");
	By password=By.id("logonPassword");	
	By modalsigninbutton=By.xpath("//a[@class='signIn_text']");
	By title=By.id("qa_headerLink_4");

	public String getTitle() {

		return driver.findElement(title).getText();
	}

    @Test
	public void Signin() {
		driver.findElement(signinbutton).click();
		driver.findElement(userid).sendKeys(prop.getProperty("username"));
		driver.findElement(password).sendKeys(prop.getProperty("password"));
		driver.findElement(modalsigninbutton).click();

	}

}
