package tests;

import abstractpages.BaseTest;
import jdk.jfr.Description;
import pages.optimove.Career;
import pages.optimove.MainPage;

import org.testng.annotations.Test;

public class QaVacancyCheck extends BaseTest {

    @Test
    @Description("test for job cart filtering")
    public void checkTheVacancyCards(){
        MainPage mainPage = new MainPage(driver);
        Career career = new Career(driver);

        mainPage
                .openSiteOptimove()
                .moveToTheCompanyBtn()
                .clickTheCareerBtn()
                .closeHelperPopup()
                .closeCoockieMessage()
                .clickTheAllBtn()
                .selectUkrfronDropDown();
        career
                .asserions();
    }
}
