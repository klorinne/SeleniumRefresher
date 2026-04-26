package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class AccountPage {

    public WebDriver driver;

    public By pageTitleLocator = By.xpath("/html/body/app-root/div[2]/app-overview/h1");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAccountPageTitle() {
        WebElement accountPageTitle = WaitUtils.waitForVisible(driver, pageTitleLocator);

        return accountPageTitle.getText().trim();
    }
}
