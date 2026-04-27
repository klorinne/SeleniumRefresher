package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtils;

public class CheckoutPage extends CommonPage {

    // checkout step 1
    public By proceedStep1ButtonLocator = By.cssSelector("button[data-test=\"proceed-1\"]");

    // checkout step 2 - guest
    public By continueAsGuestLocator = By.cssSelector("a[href='#guest-tab']");
    public By guestEmailLocator = By.id("guest-email");
    public By guestFirstNameLocator = By.id("guest-first-name");
    public By guestLastNameLocator = By.id("guest-last-name");
    public By guestSubmitButtonLocator = By.cssSelector("input[data-test='guest-submit']");
    public By proceedStep2GuestButtonLocator = By.cssSelector("button[data-test=\"proceed-2-guest\"]");

    // checkout step 3 - billing form
    public By countryLocator = By.id("country");
    public By postalCodeLocator = By.id("postal_code");
    public By houseNumberLocator = By.id("house_number");
    public By streetLocator = By.id("street");
    public By stateLocator = By.id("state");
    public By proceedStep3GuestButtonLocator = By.cssSelector("button[data-test=\"proceed-3\"]");

    // checkout step 4 - choose payment method
    public By selectPaymentMethodLocator = By.id("payment-method"); // choose cash on delivery
    public By submitPurchaseButtonLocator = By.cssSelector("button[data-test=\"finish\"]");
    public By paymentSuccessMessageLocator = By.cssSelector("div[data-test=\"payment-success-message\"]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void checkoutBoltCutter() {
        WebElement proceedStep1Button = WaitUtils.waitForClickable(driver, proceedStep1ButtonLocator);
        proceedStep1Button.click();
        WebElement continueAsGuestLink = WaitUtils.waitForVisible(driver, continueAsGuestLocator);
        continueAsGuestLink.click();

        fillUpGuestForm();
        WebElement proceedStep2GuestButton = WaitUtils.waitForClickable(driver, proceedStep2GuestButtonLocator);
        proceedStep2GuestButton.click();

        fillUpBillingForm();
        selectPaymentMethod("Cash on Delivery");
    }

    public void fillUpGuestForm() {
        WebElement guestEmail = WaitUtils.waitForVisible(driver, guestEmailLocator);
        WebElement guestFirstName= WaitUtils.waitForVisible(driver, guestFirstNameLocator);
        WebElement guestLastName = WaitUtils.waitForVisible(driver, guestLastNameLocator);
        WebElement guestSubmitButton = WaitUtils.waitForClickable(driver, guestSubmitButtonLocator);

        guestEmail.sendKeys("sample@123.com");
        guestFirstName.sendKeys("Alessia");
        guestLastName.sendKeys("Sample Test");
        guestSubmitButton.click();
    }

    public void fillUpBillingForm() {
        WebElement country = WaitUtils.waitForVisible(driver, countryLocator);
        WebElement postalCode = WaitUtils.waitForVisible(driver, postalCodeLocator);
        WebElement houseNumber = WaitUtils.waitForVisible(driver, houseNumberLocator);
        WebElement street = WaitUtils.waitForVisible(driver, streetLocator);
        WebElement state = WaitUtils.waitForVisible(driver, stateLocator);

        Select countrySelect = new Select(country);
        countrySelect.selectByValue("US");

        postalCode.sendKeys("1800");
        houseNumber.sendKeys("1230");
        street.sendKeys("John Smith Street");
        state.sendKeys("Philadelphia");

        WebElement proceedStep3GuestButton = WaitUtils.waitForClickable(driver, proceedStep3GuestButtonLocator);
        proceedStep3GuestButton.click();
    }

    public void selectPaymentMethod(String paymentMethod) {
        WebElement selectPaymentMethod = WaitUtils.waitForVisible(driver, selectPaymentMethodLocator);
        Select paymentMethodSelect = new Select(selectPaymentMethod);
        paymentMethodSelect.selectByVisibleText(paymentMethod);

        WebElement submitPurchaseButton = WaitUtils.waitForClickable(driver, submitPurchaseButtonLocator);
        submitPurchaseButton.click();
    }

    public String viewSuccessfulPurchaseAlert() {
        WebElement paymentSuccessMessage = WaitUtils.waitForVisible(driver, paymentSuccessMessageLocator);
        return paymentSuccessMessage.getText().trim();
    }
}
