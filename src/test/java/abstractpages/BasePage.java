package abstractpages;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


abstract public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private int BASE_WAIT = 1;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(BASE_WAIT));
    }

    protected WebElement waitUntilElementToBeVisibleByXpath(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
    protected WebElement waitClackable(String locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    protected Boolean waitUntilElementToBeInvisibilityByXpath(String locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }

    protected WebElement waitUntilElementToBeClickableByXpath(String locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    protected WebElement waitUntilPresenceOfElementByXpath(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    protected List<WebElement> waitUntilPresenceOfAllElementsByXpath(String locator) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
    }

    protected List<WebElement> waitUntilElementsToBeVisibleByXpath(String locator) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        return driver.findElements(By.xpath(locator));
    }



    public void goToNextTab(int tabNumber) {
        waitUntilNumberOfTabToBe(tabNumber);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber - 1));
    }

    public void waitUntilNumberOfTabToBe(int tabNumber) {
        wait.until(ExpectedConditions.numberOfWindowsToBe(tabNumber));
    }

    public static void scrollToElement(WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        var elementPosition = element.getLocation().getY();
        var jsCommand = "window.scroll(" + 0 + "," + (elementPosition - (driver.manage().window().getSize().getHeight() / 2)) + ");";
        js.executeScript(jsCommand);
    }

    @SneakyThrows
    public void waitTillCircleLoaderDisappear(String locator) {
        waitUntilElementToBeInvisibilityByXpath(locator);
        Thread.sleep(100);
    }

    @SneakyThrows
    public void waitTillVehicleLoaderDisappear(String locator) {
        waitUntilElementToBeInvisibilityByXpath(locator);
        Thread.sleep(100);
    }

    @SneakyThrows
    public void waitTillButtonLoaderDisappear(String locator) {
        waitUntilElementToBeInvisibilityByXpath(locator);
        Thread.sleep(100);
    }

    public void sleep(int millyseconds) {
        try {
            Thread.sleep(millyseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}