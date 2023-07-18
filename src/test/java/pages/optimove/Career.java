package pages.optimove;

import abstractpages.BasePage;

import commonaction.CommonAction;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class Career extends BasePage {

    public Career(WebDriver driver) {
        super(driver);
    }

    private static final String UKR_BTN = "//li[contains(text(),'UKR')]";
    private static final String ALL_BTN = "(//div[@class='selectric'])[1]";
    private static final String CLOSE_HEADER_MESSAGE = "//*[@class='announcement-bar__close-btn']";

public Career closeTheHeaderMessage(){
    waitUntilElementToBeClickableByXpath(CLOSE_HEADER_MESSAGE).click();
    return this;
}

    public WebElement AllBtn() {
        return driver.findElement(By.xpath(ALL_BTN));
    }

    public Career scrollPageToTheAllBtn(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AllBtn());

//        Actions actions = new Actions(driver);
//
//        actions.moveToElement(AllBtn()).perform();
//        scrollToElement(AllBtn(), driver);
        return this;
    }

    public Career clickTheAllBtn(){
        waitUntilElementToBeClickableByXpath(ALL_BTN).click();
        return this;
    }

    public Career clickTheUkrBtn(){
        waitUntilElementToBeClickableByXpath(UKR_BTN).click();
        return this;
    }

}
