package core;


import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BasePageTest {

    public WebDriver driver;
    public String URL = "https://www.facebook.com/";


    @BeforeClass
    public void beforeClass() {
        System.setProperty("headless", "false"); // You can set this property elsewhere
        String headless = System.getProperty("headless");

        ChromeDriverManager.chromedriver().setup();
        if("true".equals(headless)) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            //Add chrome switch to disable notification - "**--disable-notifications**"
            chromeOptions.addArguments("--disable-notifications");
            driver = new ChromeDriver(chromeOptions);
        } else {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-notifications");
            driver = new ChromeDriver(chromeOptions);
            //driver = new ChromeDriver();
        }

        driver.get(URL);


    }

   @AfterClass
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }



}