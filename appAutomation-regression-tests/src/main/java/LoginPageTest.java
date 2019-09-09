import core.BasePageTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjcts.LoginPage;



public class LoginPageTest extends BasePageTest{
    LoginPage loginPage;


    @Test
    public void SignInWithValidUserCredential() throws InterruptedException {
        loginPage = new LoginPage(getDriver());
        loginPage.submitUserNameAndPassWord(getDriver(),"jemalmfth@gmail.com","Link@2019")
                .clickSignInButton();


    }
}
