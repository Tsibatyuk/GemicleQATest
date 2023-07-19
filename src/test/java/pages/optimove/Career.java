package pages.optimove;

import abstractpages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Career extends BasePage {

    public Career(WebDriver driver) {
        super(driver);
    }

    private static final String ALL_BTN = "//div[@class='select-dropdown__wrapper']//span[contains(text(), 'Offices')]/..//div[contains(@class, 'selectric-hide-select')]/..";
    private static final String CLOSE_COOCKIE_MESSAGE = "//a[@class='cookiebanner__close d-block']";
    private static final String POSITION_DROPDOWN_LIST = "//div[@class='selectric']";
    private static final String JOB_CARD = "//div[@class='block-careers-listing__job col']/*/*/a";


    public Career asserions(){
        List<WebElement> jobCard = driver.findElements(By.xpath(JOB_CARD));
        jobCard.forEach(webElement ->
                Assert.assertEquals(webElement
                .getText(), "QA Automation Engineer",
                "Current text "+webElement.getText()+" is different from 'QA Automation Engineer'"));
        return this;
    }

    public boolean selectUkrfronDropDown(){
        waitUntilElementToBeClickableByXpath("//ul/*[contains(text(),'UKR')]").click();
        List<WebElement> dropdownPositionList = driver.findElements(By.xpath(POSITION_DROPDOWN_LIST));
        boolean checkSelectedOfficesValue = dropdownPositionList
                .stream()
                .findFirst().orElse(null)
                .getText().equals("UKR");
        try{
        if(checkSelectedOfficesValue !=true){
            throw new Exception("selected wrong value");
        }
        }catch(Exception e){
            System.out.println("Got exception "+ e.getMessage());
        }
        return checkSelectedOfficesValue;
    }

    public Career closeCoockieMessage() {
            waitUntilElementToBeClickableByXpath(CLOSE_COOCKIE_MESSAGE).click();
        return this;
    }

    public Career clickTheAllBtn() {
        waitUntilElementToBeClickableByXpath(ALL_BTN).click();
        return this;
    }

    public Career closeHelperPopup() {
        while(driver.findElements(By.xpath("//iframe")).size()<6) {
           moveCursourByCordinate(1,1);
        }
            driver.switchTo().frame(waitUntilElementToBeClickableByXpath
                            ("//iframe[@id='hubspot-conversations-iframe']"));
                            waitUntilElementToBeClickableByXpath
                            ("//div[@class='VizExIcon__IconWrapper-sc-1nnwznd-0 bJncTg']").click();
            driver.switchTo().defaultContent();
        return this;
    }
}