package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionsTest extends BaseTest {

    @Test
    public void testSuccessfulPurchaseFlow() {
        driver.get("https://practicesoftwaretesting.com/");

        HomePage homePagePom = new HomePage(driver);
        ProductPage productPagePom = new ProductPage(driver);
        CheckoutPage checkoutPagePom = new CheckoutPage(driver);

        homePagePom.searchProduct("Bolt Cutters");
        homePagePom.clickBoltCutterProduct();

        // assert productname
        assertEquals("Bolt Cutters", productPagePom.getProductName());
        assertEquals("Bolt Cutters - Practice Software Testing - Toolshop - v5.0",
                driver.getTitle(), "Page Title is expected");

        //add to cart flow
        productPagePom.addBoltCutterToCart();
        String addToCartMessage = productPagePom.viewAddedToCartAlert();
        assertEquals("Product added to shopping cart.",
                addToCartMessage, "Product added to cart alert was visible");

        String cartCount = productPagePom.viewCartCount();
        assertEquals("3", cartCount);

        // checkout flow
        homePagePom.clickCart();
        assertEquals("https://practicesoftwaretesting.com/checkout",
                driver.getCurrentUrl(), "Redirected to Checkout Page");
        assertEquals("Checkout - Practice Software Testing - Toolshop - v5.0",
                driver.getTitle(), "Page Title is expected");

        checkoutPagePom.checkoutBoltCutter();

        String checkoutMessage = checkoutPagePom.viewSuccessfulPurchaseAlert();
        assertEquals("Payment was successful",
                checkoutMessage, "Payment was successful");
    }
}
