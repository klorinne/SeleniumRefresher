package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPage {
    public WebDriver driver;

    // common elements in pages
    public By checkoutStepsLocator = By.cssSelector("ul.steps-indicator");
    public By cartButtonLocator = By.cssSelector("a[data-test=\"nav-cart\"]");
    public By cartCountLocator = By.id("lblCartCount");

    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }
}
