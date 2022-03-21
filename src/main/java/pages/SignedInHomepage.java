package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import base.BaseTest;


public class SignedInHomepage extends BaseTest {
	
    By manageyouraccount=By.xpath("//a[contains(@href,'account-dashboard')]//span");
	By OrderStatusLink=By.id("qa_headerLink_4");
		
	public void gotoOrderStatus() {
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		driver.findElement(OrderStatusLink);
		jse.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(OrderStatusLink));
		jse.executeScript("arguments[0].click();", driver.findElement(OrderStatusLink));
		
	}
	
	public String linkPresent() {
		return driver.findElement(manageyouraccount).getText();
		
	}

}
