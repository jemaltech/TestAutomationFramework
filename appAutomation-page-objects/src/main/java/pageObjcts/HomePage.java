package pageObjcts;


import core.Base;
import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Base {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "q")
    private WebElement searchBox;




    public void setSearchBox(String searchText){
        searchBox.sendKeys(searchText);
        searchBox.sendKeys(Keys.ENTER);
    }

}
