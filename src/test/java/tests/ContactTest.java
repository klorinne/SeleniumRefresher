package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.ContactPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest extends BaseTest {

    @Test
    public void checkContactPageHeading() {
        driver.get("https://practicesoftwaretesting.com/contact");

        //implicit wait - not recommended since its flaky
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        ContactPage contactPagePom = new ContactPage(driver);
        String headingText = contactPagePom.getContactPageHeading();
        assertEquals("Contact", headingText,
                "Contact Page Heading Title is displaying the expected title");
    }

    @Test
    public void contactFormSubmitTest() {
        driver.get("https://practicesoftwaretesting.com/contact");

        ContactPage contactPagePom = new ContactPage(driver);

        //Fill the Form
        contactPagePom.fillForm();

        //Submit the Form
        contactPagePom.submitForm();
        assertEquals("Thanks for your message! We will contact you shortly.",
                contactPagePom.viewSuccesfulContactAlert(), "Successfully submitted contact inquiry");
    }
}
