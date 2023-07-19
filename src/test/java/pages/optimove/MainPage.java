package pages.optimove;

import abstractpages.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private static final String COMPANY_BTN = "//div/*[contains(text(),'Company')]";
    private static final String CAREER_BTN = "//a[contains(text(),'Career')]";

    public MainPage openSiteOptimove() {
        driver.get("https://www.optimove.com/");
        return this;
    }

    public MainPage moveToTheCompanyBtn() {
        WebElement element = waitUntilElementToBeClickableByXpath(COMPANY_BTN);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        sleep(1000);
        return this;
    }

    public Career clickTheCareerBtn(){
        waitUntilElementToBeClickableByXpath(CAREER_BTN).click();
        sleep(1000);
        return new Career(driver);
    }
}
