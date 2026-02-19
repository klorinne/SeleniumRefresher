package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    public WebDriver driver;

    By emailLocator = By.id("email");
    By passwordLocator = By.id("password");
    By loginButtonLocator = By.className("btnSubmit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginAs(String email, String password) {
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }
}
