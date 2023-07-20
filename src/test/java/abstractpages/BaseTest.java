package abstractpages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

abstract public class BaseTest {

    protected WebDriver driver;

    //type name of the browser you're using in this variable (chrome, firefox or edge)
    private static final String BROWSER_NAME = "firefox";
    //put false here if you want to see browser or true to headless mode
    private final boolean headless = false;

    @BeforeMethod
    public void setUp() throws Exception {
        switch (BROWSER_NAME) {
            case ("chrome") -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(headless);
                chromeOptions.addArguments("--remote-allow-origins=*");
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
            case ("edge") -> {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setHeadless(headless);
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver(edgeOptions);
                driver.manage().window().maximize();
                if (!headless) {
                    driver.manage().window().maximize();
                }
            }
            default -> throw new Exception("You chose not valid browser!");
        }
    }

    @AfterMethod
    public void closeWindow() {
        driver.quit();
    }
}
