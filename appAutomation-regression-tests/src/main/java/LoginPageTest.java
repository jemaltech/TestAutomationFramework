import core.BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjcts.LoginPage;



public class LoginPageTest extends BaseTest {
    LoginPage loginPage;



    @Test(priority = 2)
    public void printInstanceID(){
        System.out.println("Facebook Test's Page title is: " + driver.get().getTitle() +" " + "Thread Id: " +  Thread.currentThread().getId());
        Assert.assertEquals(driver.get().getTitle(), "Log into Facebook | Facebook");
        System.out.println("Facebook Login page Test Ended! " + "Thread Id: " +  Thread.currentThread().getId());

    }


    @Test(priority = 1)
    public void SignInWithValidUserCredential() throws InterruptedException {
        getDriver().get("https://www.facebook.com/login.php");
        loginPage = new LoginPage(getDriver());
        loginPage.submitUserNameAndPassWord(getDriver(),"jemalmfth@gmail.com","Link@2019")
                .clickSignInButton();


    }


}
