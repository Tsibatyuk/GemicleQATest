package abstractpages;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.optimove.MainPage;

import java.util.ArrayList;

abstract public class BaseTest<T extends BaseTest> {

    protected WebDriver driver;


    //type name of the browser you're using in this variable (chrome or firefox)
    private static final String BROWSER_NAME = "chrome";
    //put false here if you want to see browser or true to headless mode
    private final boolean headless = false;

    @BeforeMethod
    public void setUp() throws Exception {
        switch (BROWSER_NAME) {
            case ("chrome") -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(headless);
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                if (!headless) {
                    driver.manage().window().maximize();
                }
            }
            case ("firefox") -> {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(headless);
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
                if (!headless) {
                    driver.manage().window().maximize();
                }
            }
            default -> throw new Exception("You chose not valid browser!");
        }
    }
    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public T scroll(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")", "");
        return (T) this;
    }

    public void switchToTab(int tabNumber) {
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(tabNumber - 1));
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void switchToNextTab() {
        driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
    }

    @AfterMethod
    public void closeWindow() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public boolean urlContains(String urlPath) {
        return driver.getCurrentUrl().contains(urlPath);
    }
}