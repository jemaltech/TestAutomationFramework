import core.BasePageTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjcts.HomePage;
import pageObjcts.LoginPage;


public class HomePageTest extends BasePageTest {
    HomePage homePage;
    LoginPage loginPage;


    @Test
    public void searchFriendsNameUsingFacebookSearch() throws InterruptedException {
        loginPage = new LoginPage(getDriver());
        loginPage.submitUserNameAndPassWord(getDriver(),"jemalmfth@gmail.com ","Link@2019")
                .clickSignInButton();


        //Actions actions = new Actions(getDriver());
        //actions.sendKeys(Keys.ESCAPE).build().perform();

        homePage = new HomePage(getDriver());
        Thread.sleep(7000);
        homePage.setSearchBox("Ehan");


    }



}
