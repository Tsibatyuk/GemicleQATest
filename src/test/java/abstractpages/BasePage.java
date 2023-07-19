package abstractpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private int BASE_WAIT = 5;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(BASE_WAIT));
    }

    protected WebElement waitUntilElementToBeClickableByXpath(String locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public void sleep(int millyseconds) {
        try {
            Thread.sleep(millyseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void moveCursourByCordinate(int x, int y){
        Actions actions = new Actions(driver);
        actions.moveByOffset( x, y).perform();
    }
}
