package core;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BasePageTest {

    private WebDriver driver;
    String URL = "https://www.facebook.com/";

    @BeforeSuite
    public void beforeSuite() {
        System.setProperty("headless", "false"); // You can set this property elsewhere
        String headless = System.getProperty("headless");

        ChromeDriverManager.chromedriver().setup();
        if("true".equals(headless)) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        } else {
            driver = new ChromeDriver();
        }
    }

    @BeforeClass
    public void navigateToURL(){
        driver.get(URL);

    }

    @AfterSuite
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            //driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }



}