package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class HomePage extends CommonPage {

    public By searchBarLocator = By.id("search-query");
    public By searchButtonLocator = By.cssSelector("button[data-test='search-submit']");
    public By searchResultsLocator = By.cssSelector("div[data-test='search_completed']");
    public By boltCutterCardLocator = By.xpath("//h5[normalize-space()='Bolt Cutters']/ancestor::a");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String productName) {
        WebElement searchBar = WaitUtils.waitForVisible(driver, searchBarLocator);
        WebElement searchButton = WaitUtils.waitForClickable(driver, searchButtonLocator);
        searchBar.sendKeys(productName);
        searchButton.click();
    }

    public void clickBoltCutterProduct() {
        WaitUtils.waitForVisible(driver, searchResultsLocator);
        WebElement product = WaitUtils.waitForClickable(driver, boltCutterCardLocator);
        product.click();
    }

    public void clickCart() {
        WebElement cartButton = WaitUtils.waitForClickable(driver, cartButtonLocator);
        cartButton.click();
        WaitUtils.waitForVisible(driver, checkoutStepsLocator);
    }
}
