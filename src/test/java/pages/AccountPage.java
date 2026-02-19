package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    public WebDriver driver;

    public By pageTitleLocator = By.xpath("/html/body/app-root/div[2]/app-overview/h1");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }
}
