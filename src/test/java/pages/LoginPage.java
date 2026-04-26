package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class LoginPage {

    public WebDriver driver;

    By emailLocator = By.id("email");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.className("btnSubmit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginAs(String email, String password) {
        WebElement emailInput = WaitUtils.waitForVisible(driver, emailLocator);
        WebElement passwordInput = WaitUtils.waitForVisible(driver, passwordLocator);
        WebElement loginButton = WaitUtils.waitForClickable(driver, loginButtonLocator);

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
