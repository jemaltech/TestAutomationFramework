import core.BasePageTest;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjcts.HomePage;
import pageObjcts.LoginPage;
import utilities.PropertyManager;


public class HomePageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

   //Test Data
    String validUsername = PropertyManager.getInstance().getValidUsername();
    String validPassword = PropertyManager.getInstance().getValidPassword();
    String baseURL = PropertyManager.getInstance().getURL();

    @Test(priority = 0)
    public void initHomePage(){
        /*********Page Variables*********/
        // String baseURL = PropertyManager.getInstance().getURL();
         getDriver().get(baseURL);
    }

    @Test(priority = 1)
    public void searchFriendsNameUsingFacebookSearch() {
        loginPage = new LoginPage(getDriver());
        loginPage.submitUserNameAndPassWord(getDriver(),validUsername,validPassword)
                .clickSignInButton();

    }

    @Test(priority = 2)
    public void SearchText() throws InterruptedException {
        homePage = new HomePage(getDriver());
        homePage.setSearchBox("Ehan");

    }
    @Test(priority = 3)
    public void printInstanceID(){

        System.out.println("Facebook Home Page 's Page title is: " + getDriver().getTitle() +" " + "Thread Id: " +  Thread.currentThread().getId());
        Assert.assertEquals(getDriver().getTitle(), "Log into Facebook | Facebook");
        System.out.println("Facebook SEARCH Test Ended! " + "Thread Id: " +  Thread.currentThread().getId());

    }



}
