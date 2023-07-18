package tests;

import abstractpages.BaseTest;
import org.testng.annotations.Test;
import pages.optimove.MainPage;

public class QaVacancyCheck extends BaseTest {

    @Test
    public void check(){
        MainPage mainPage = new MainPage(driver);

        mainPage.openOptimove()

//                .closePopUpHelper()
//                .closeCockieWindow()
                .moveToCompanyBtn()
                .clickCareerBtn()
                .scrollPageToTheAllBtn()
                .clickTheAllBtn()
                .clickTheUkrBtn();

    }
}
