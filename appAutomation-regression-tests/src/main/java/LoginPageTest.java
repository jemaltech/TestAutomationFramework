import core.BasePageTest;
import org.testng.annotations.Test;
import pageObjcts.LoginPage;



public class LoginPageTest extends BasePageTest{
    LoginPage loginPage;

    @Test
    public void SignInWithValidUserCredential() {
        loginPage = new LoginPage(getDriver());
        loginPage.submitUserNameAndPassWord(getDriver()," "," ")
                .clickSignInButton();


    }
}
