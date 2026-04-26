package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.TransactionPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionsTest extends BaseTest {

    @Test
    public void testSuccessfulPurchaseFlow() {
        driver.get("https://practicesoftwaretesting.com/");

        TransactionPage transactionPom = new TransactionPage(driver);

        transactionPom.searchProduct("Bolt Cutters");
        transactionPom.clickBoltCutterProduct();

        // assert productname
        assertEquals("Bolt Cutters", transactionPom.getProductName());
        assertEquals("Bolt Cutters - Practice Software Testing - Toolshop - v5.0",
                driver.getTitle(), "Page Title is expected");

        //add to cart flow
        transactionPom.addBoltCutterToCart();
        String addToCartMessage = transactionPom.viewAddedToCartAlert();
        assertEquals("Product added to shopping cart.",
                addToCartMessage, "Product added to cart alert was visible");

        String cartCount = transactionPom.viewCartCount();
        assertEquals("3", cartCount);

        // checkout flow
        transactionPom.clickCart();
        assertEquals("https://practicesoftwaretesting.com/checkout",
                driver.getCurrentUrl(), "Redirected to Checkout Page");
        assertEquals("Checkout - Practice Software Testing - Toolshop - v5.0",
                driver.getTitle(), "Page Title is expected");

        transactionPom.checkoutBoltCutter();

        String checkoutMessage = transactionPom.viewSuccessfulPurchaseAlert();
        assertEquals("Payment was successful",
                checkoutMessage, "Payment was successful");
    }
}
