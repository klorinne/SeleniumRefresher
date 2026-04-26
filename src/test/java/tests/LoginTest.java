package tests;

import base.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.AccountPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {
    // Data Driven Testing
    @ParameterizedTest
    @CsvFileSource(resources = "/login-data.csv", numLinesToSkip = 0)
    public void multipleLoginTest(String email, String password) {
        driver.get("https://practicesoftwaretesting.com/auth/login");

        //Login Form
        LoginPage loginPagePom = new LoginPage(driver);
        loginPagePom.loginAs(email, password);

        //Verify Account Page
        AccountPage accountPagePom = new AccountPage(driver);
        assertEquals("My account", accountPagePom.getAccountPageTitle(),
                "Account Page Heading Title is displaying the expected title");
    }
}
