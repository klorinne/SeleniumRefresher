package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtils;

public class ProductPage extends CommonPage {

    public By increaseQuantityLocator = By.id("btn-increase-quantity");
    public By addToCartButtonLocator = By.id("btn-add-to-cart");
    public By addedToCartMessageLocator = By.cssSelector("div[role='alert'].toast-message");
    public By productNameLocator = By.cssSelector("h1[data-test='product-name']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        WebElement product = WaitUtils.waitForVisible(driver, productNameLocator);
        return product.getText().trim();
    }

    public void addBoltCutterToCart() {
        // add 3 bolt cutters
        WebElement increaseQuantityButton = WaitUtils.waitForClickable(driver, increaseQuantityLocator);
        increaseQuantityButton.click();
        increaseQuantityButton.click();

        WebElement addToCartButton = WaitUtils.waitForClickable(driver, addToCartButtonLocator);
        addToCartButton.click();
    }

    public String viewAddedToCartAlert() {
        WebElement addToCartMessage = WaitUtils.waitForVisible(driver, addedToCartMessageLocator);
        return addToCartMessage.getText().trim();
    }

    public String viewCartCount() {
        WaitUtils.waitForInvisibility(driver, addedToCartMessageLocator);
        WebElement cartCount = WaitUtils.waitForVisible(driver, cartCountLocator);

        return cartCount.getText().trim();
    }
}
