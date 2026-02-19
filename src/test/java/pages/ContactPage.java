package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {

    private WebDriver driver;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public By firstNameLocator = By.xpath("//*[@id=\"first_name\"]");
    public By lastNameLocator = By.id("last_name");
    public By emailLocator = By.id("email");
    public By subjectLocator = By.id("subject");
    public By messageLocator = By.id("message");
    public By attachmentLocator = By.id("attachment");
    public By sendButtonLocator = By.className("btnSubmit");
    public By alertLocator = By.className("alert");

    public void fillForm() {
        driver.findElement(firstNameLocator).sendKeys("John");
        driver.findElement(lastNameLocator).sendKeys("Smith");
        driver.findElement(emailLocator).sendKeys("John.Smith@sample.com");

        Select subjectSelect = new Select((driver.findElement(subjectLocator)));
        subjectSelect.selectByValue("webmaster");

        driver.findElement(messageLocator).sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");

    }

    public void submitForm() {
        driver.findElement(sendButtonLocator).click();
    }

}
