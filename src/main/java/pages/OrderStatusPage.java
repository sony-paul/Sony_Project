package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import base.BaseTest;

public class OrderStatusPage extends BaseTest {
	By newSignIn=By.xpath("//a[text()='Sign In']");
	By userid=By.id("userid");
	By password=By.id("logonPassword");
	By modalsigninbutton=By.xpath("//a[@class='signIn_text']");
	By itemstab=By.xpath("//a[@id='items_tab']");
	By orderstatusTitle=By.xpath("//title[@data-uw-rm-title='gn']");
	By OSItemsText=By.xpath("//div[@id='resultsErrorMessageContainer']//p");
	
	public void clicknewSignin() {
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(newSignIn));
		jse.executeScript("arguments[0].click();",driver.findElement(newSignIn));
		driver.findElement(userid).sendKeys(prop.getProperty("username"));
		driver.findElement(password).sendKeys(prop.getProperty("password"));
		driver.findElement(modalsigninbutton).click();
	}

	public void clickItems() {
		driver.findElement(itemstab).click();
	}
	
	public String getOSTitle()
	{
		return driver.findElement(orderstatusTitle).getText();
	}
	
	public String getOSItemstext() {
		
		return driver.findElement(OSItemsText).getText();
				
		
	}
	

}
