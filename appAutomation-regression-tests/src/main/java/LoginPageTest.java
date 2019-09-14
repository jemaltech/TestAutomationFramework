import core.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjcts.LoginPage;
import utilities.PropertyManager;


public class LoginPageTest extends BaseTest {
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

    @Test(priority = 2)
    public void printInstanceID(){
        System.out.println("Facebook Test's Page title is: " + driver.get().getTitle() +" " + "Thread Id: " +  Thread.currentThread().getId());
        Assert.assertEquals(driver.get().getTitle(), "Log into Facebook | Facebook");
        System.out.println("Facebook Login page Test Ended! " + "Thread Id: " +  Thread.currentThread().getId());

    }


    @Test(priority = 1)
    public void SignInWithValidUserCredential() {
        loginPage = new LoginPage(getDriver());
        loginPage.submitUserNameAndPassWord(getDriver(),validUsername,validPassword)
                .clickSignInButton();


    }


}
