package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static WebElement waitforElementVisible(WebDriver driver, By locator, int timeOut)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        return (wait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
    }

    public static void waitforframeToBeAvailable(WebDriver driver, By locator,int timeOut)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }
    public static void waitforelementToBeClickable(WebDriver driver, By locator,int timeOut)
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
