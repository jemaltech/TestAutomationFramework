package pageObjcts;


import core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#q")
    private WebElement searchBox;

    public void setSearchBox(String searchText){
        searchBox.sendKeys(searchText);
        searchBox.sendKeys(Keys.ENTER);
    }

}
