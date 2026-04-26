package base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@ExtendWith({ScreenShooterExtension.class})
public class BaseTest {

    public WebDriver driver;

    @BeforeEach //will run before every test
    public void setUp() {
        //pageload strategy - normal, eager, none
        //options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        setBrowser("chrome");
        driver.manage().window().maximize();
        //setSeleniumGrid(browser);

    }

    @AfterEach //will run after every test
    public void tearDown(){
        driver.quit();
    }

    public void setSeleniumGrid(String browser) throws MalformedURLException {
        //selenium grid
        URL gridURL = new URL("http://localhost:4444/");

        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        if (browser.equals("firefox")) {
            //headless mode - will not open the browser when running the test
            firefoxOptions.addArguments("--headless=new");
            driver = new RemoteWebDriver(gridURL, firefoxOptions);
        } else {
            chromeOptions.addArguments("--headless=new");
            driver = new RemoteWebDriver(gridURL, chromeOptions);
        }
    }

    public void setBrowser(String browser) {
        //for selenide
        //Configuration.browser = browser;
        //Configuration.screenshots = true;
        //Configuration.savePageSource = false;

        if (browser.equals("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();

            //headless mode - will not open the browser when running the test
            firefoxOptions.addArguments("--headless=new");

            //for selenide
            //Configuration.browserCapabilities = firefoxOptions;
            driver = new FirefoxDriver(firefoxOptions);
        } else {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless=new");

            //for selenide
            //Configuration.browserCapabilities = chromeOptions;
            driver = new ChromeDriver(chromeOptions);

        }
        // for selenide
        //com.codeborne.selenide.Selenide.open("about:blank");
        //driver = WebDriverRunner.getWebDriver();
    }
}
