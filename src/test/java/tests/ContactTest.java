package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ContactPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest extends BaseTest {

    @Test
    public void checkContactPageHeading() {
        driver.get("https://practicesoftwaretesting.com/contact");

        //implicit wait - not recommended since its flaky
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //explicit wait
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement heading = wait.until(d -> driver.findElement(By.tagName("h3")));
        String headingText = heading.getText();
        assertEquals("Contact", headingText);
    }

    @Test
    public void contactFormSubmitTest() {
        driver.get("https://practicesoftwaretesting.com/contact");

        ContactPage contactPagePom = new ContactPage(driver);

        //Fill the Form
        contactPagePom.fillForm();

        //Submit the Form
        contactPagePom.submitForm();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement alert = wait.until(
                ExpectedConditions.visibilityOfElementLocated((contactPagePom.alertLocator))
        );

        String alertText = alert.getText().trim();

        assertEquals("Thanks for your message! We will contact you shortly.", alertText);

    }
}
