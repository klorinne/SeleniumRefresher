package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtils;

public class ContactPage {

    private WebDriver driver;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public By contactPageTitleLocator = By.tagName("h3");
    public By firstNameLocator = By.xpath("//*[@id=\"first_name\"]");
    public By lastNameLocator = By.id("last_name");
    public By emailLocator = By.id("email");
    public By subjectLocator = By.id("subject");
    public By messageLocator = By.id("message");
    public By attachmentLocator = By.id("attachment");
    public By sendButtonLocator = By.className("btnSubmit");
    public By alertLocator = By.className("alert");

    public String getContactPageHeading() {
        WebElement contactPageTitle = WaitUtils.waitForVisible(driver, contactPageTitleLocator);
        return contactPageTitle.getText().trim();
    }

    public void fillForm() {
        WebElement firstNameInput = WaitUtils.waitForVisible(driver, firstNameLocator);
        WebElement lastNameInput = WaitUtils.waitForVisible(driver, lastNameLocator);
        WebElement emailInput = WaitUtils.waitForVisible(driver, emailLocator);
        WebElement subject = WaitUtils.waitForVisible(driver, subjectLocator);
        WebElement message = WaitUtils.waitForVisible(driver, messageLocator);

        firstNameInput.sendKeys("John");
        lastNameInput.sendKeys("Smith");
        emailInput.sendKeys("John.Smith@sample.com");

        Select subjectSelect = new Select(subject);
        subjectSelect.selectByValue("webmaster");

        message.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
    }

    public void submitForm() {
        WebElement sendButton = WaitUtils.waitForClickable(driver, sendButtonLocator);
        sendButton.click();
    }

    public String viewSuccesfulContactAlert() {
        WebElement contactMessage = WaitUtils.waitForVisible(driver, alertLocator);

        return contactMessage.getText().trim();
    }

}
