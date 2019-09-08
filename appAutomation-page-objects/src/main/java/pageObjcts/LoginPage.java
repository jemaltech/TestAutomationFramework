package pageObjcts;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;


public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) { super(driver); }

    @FindBy(css = "#email")
    private WebElement username;

    @FindBy(css = "#pass")
    private WebElement password;

    @FindBy(css = "#u_0_2")
    private WebElement signInButton;

    @FindBy(css = ".fb_logo.img.sp_gJxAbgutw8p_2x.sx_afed44")
    private WebElement titleText;



    public LoginPage submitUserNameAndPassWord(WebDriver driver,String userName,String passWord) {
       //waitForElementToAppear($(locators.username));
       // $(locators.USERNAME).sendKeys(userName);
       // $(locators.PASSWORD).sendKeys(passWord);
        username.sendKeys(userName);

        password.sendKeys(passWord);

        return new LoginPage(driver); }

    public HomePage clickSignInButton() {
        signInButton.click();

       //$(locators.SIGN_IN_BUTTON).click();
        return new HomePage(driver);
    }


/*
    public  interface locators {

        By USERNAME = By.cssSelector("#email");
        By PASSWORD = By.cssSelector("#pass");
        By SIGN_IN_BUTTON = By.cssSelector(".fb_logo.img.sp_gJxAbgutw8p_2x.sx_afed44");


    }

*/

}
