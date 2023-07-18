package pages.optimove;

import abstractpages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private static final String COMPANY_BTN = "//div/*[contains(text(),'Company')]";
    private static final String CAREER_BTN = "//a[contains(text(),'Career')]";
    private static final String CLOSE_POP_UP_BTN = "//button[contains(@aria-label,'Dismiss')]/div";
    private static final String CLOSE_COOCKIE_WINDOW = "//a[@class='cookiebanner__close d-block']";

    public MainPage closeCockieWindow(){
        waitUntilElementToBeClickableByXpath(CLOSE_COOCKIE_WINDOW).click();
        return this;
    }
    public MainPage closePopUpHelper(){
        waitUntilElementToBeClickableByXpath(CLOSE_POP_UP_BTN).click();
        return this;
    }

    public MainPage openOptimove() {
        driver.get("https://www.optimove.com/");
        return this;
    }

    public MainPage moveToCompanyBtn() {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath(COMPANY_BTN));
        actions.moveToElement(element).perform();
        sleep(1000);
        return this;
    }

    public Career clickCareerBtn(){
        waitUntilElementToBeClickableByXpath(CAREER_BTN).click();
        sleep(1000);
        return new Career(driver);
    }


}
