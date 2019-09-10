package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest{
    //Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public CapabilityFactory capabilityFactory = new CapabilityFactory();


    @BeforeClass
    @Parameters(value={"browser"})
    public void setup (String browser) throws MalformedURLException {
        //Set Browser to ThreadLocalMap
        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
    }

    public static WebDriver getDriver() {
        //Get driver from ThreadLocalMap
        return driver.get();
    }

    @AfterClass
    public void tearDown() {
        getDriver().quit();
    }

    @AfterSuite
    void terminate () {
        //Remove the ThreadLocalMap element
        driver.remove();
    }
}
