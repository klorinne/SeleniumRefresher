package tests;

import base.BaseTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AccountPage;
import pages.ContactPage;
import pages.LoginPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class FirstSeleniumTest extends BaseTest {

    @Test
    @Tag("smoke") // config to run only test with smoke tags
    public void checkPageTitle() {
        driver.get("https://practicesoftwaretesting.com");
        assertEquals("Practice Software Testing - Toolshop - v5.0", driver.getTitle());
    }

}
