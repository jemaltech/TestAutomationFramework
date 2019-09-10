import core.BasePageTest;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjcts.HomePage;
import pageObjcts.LoginPage;


public class HomePageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;


    @Test(priority = 1)
    public void searchFriendsNameUsingFacebookSearch(){
        getDriver().get("https://www.facebook.com/login.php");
        loginPage = new LoginPage(getDriver());
        loginPage.submitUserNameAndPassWord(getDriver(),"jemalmfth@gmail.com ","Link@2019")
                .clickSignInButton();

        homePage = new HomePage(getDriver());
        homePage.setSearchBox("Ehan");


    }
    @Test(priority = 2)
    public void printInstanceID(){

        System.out.println("Facebook Home Page 's Page title is: " + getDriver().getTitle() +" " + "Thread Id: " +  Thread.currentThread().getId());
        Assert.assertEquals(getDriver().getTitle(), "Log into Facebook | Facebook");
        System.out.println("Facebook SEARCH Test Ended! " + "Thread Id: " +  Thread.currentThread().getId());

    }



}
