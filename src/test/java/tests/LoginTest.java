package tests;

import base.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AccountPage;
import pages.LoginPage;

import java.time.Duration;

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
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement alert = wait.until(
                ExpectedConditions.visibilityOfElementLocated((accountPagePom.pageTitleLocator))
        );

        String accountPageTitle = driver.findElement(accountPagePom.pageTitleLocator).getText();

        assertEquals("My account", accountPageTitle);

    }
}
