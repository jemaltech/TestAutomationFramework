package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base {

    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;
    public WebDriverWait wait;

    //Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public CapabilityFactory capabilityFactory = new CapabilityFactory();


    public Base(WebDriver driver) {
        wait  = new WebDriverWait(driver, TIMEOUT, POLLING);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }


    protected void waitForElementToAppear(By locator) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }

    protected void waitForEelementToBeClickable(By locator){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
