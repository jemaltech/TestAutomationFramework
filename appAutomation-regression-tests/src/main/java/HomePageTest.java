import core.BasePageTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pageObjcts.HomePage;
import pageObjcts.LoginPage;


public class HomePageTest extends BasePageTest {
    HomePage homePage;
    LoginPage loginPage;

    @Test
    public void searchFriendsNameUsingFacebookSearch() throws InterruptedException {
        loginPage = new LoginPage(getDriver());
        loginPage.submitUserNameAndPassWord(getDriver()," "," ")
                .clickSignInButton();

        homePage = new HomePage(getDriver());
        homePage.setSearchBox("Ehan");


    }



}
