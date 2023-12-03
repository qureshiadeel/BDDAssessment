package base;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.ITestResult;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

public class BaseClass {
    protected static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    protected static ThreadLocal<Properties> threadLocalProperties = new ThreadLocal<>();

    protected WebDriver driver;
    protected Properties properties;


    //get thread-safe driver
    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    //get thread-safe properties
    public static Properties getProperties(){
        return threadLocalProperties.get();
    }

    public void Setup() {
        String browser="Chrome";
        driver = org.base.BrowserManager.doBrowserSetup(browser);
        threadLocalDriver.set(driver);
        properties = org.base.BrowserManager.loadPropertyFile();
        threadLocalProperties.set(properties);

        driver.get("https://www.saucedemo.com/");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void Teardown() {
        getDriver().quit();
        System.out.println("After Test Thread ID: "+Thread.currentThread().getId());
        threadLocalDriver.remove();
        threadLocalProperties.remove();
    }


    public void fluentWait(WebDriver driver, WebElement element, int timeOut) {
        try {
            Wait<WebDriver> wait;
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeOut))
                    .pollingEvery(Duration.ofMillis(100))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            System.out.println("Element not visible within the specified time: " + e.getMessage());
        }
    }
    public void fluentWait_Text(WebDriver driver, WebElement element,String text, int timeOut) {
        try {
            Wait<WebDriver> wait;
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeOut))
                    .pollingEvery(Duration.ofMillis(100))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.textToBePresentInElement(element,text));
        } catch (TimeoutException e) {
            System.out.println("Element not visible within the specified time: " + e.getMessage());
        }
    }

}
