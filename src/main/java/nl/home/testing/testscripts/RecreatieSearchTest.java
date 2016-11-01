package nl.home.testing.testscripts;


import nl.home.testing.properties.Search;
import nl.home.testing.pageobjects.HomePage;
;
import nl.home.testing.pageobjects.RecreationPage;
import nl.home.testing.utils.ExcelUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

//This class is used to test quick search using Recreatie properties in home page

public class RecreatieSearchTest extends BaseClass {

    String screenShotPath="D:/Project/Exercise1/src/main/resources/screenshots/recreationsearch_test/TestResults_";
    String expectedValue;


    @BeforeTest(alwaysRun=true)
    public void openUrl() {
        driver.get(FUNDA_NL);
        recrepage=new RecreationPage(driver);
        homepage = new HomePage(driver);
        homepage.clickRecreatielLnk();
        waitUntillPageLoad();
    }
    @Test(dataProvider = "recreationpage")
    public void searchLocation(final Search search) throws Exception {
        recrepage.setPLACE_LOCATOR(search.getLocation());
        recrepage.setRANGE_SELECTOR(search.getDistance());
        captureScreenShot(screenShotPath);
        recrepage.clickSearch();
        captureScreenShot(screenShotPath);
        waitUntillPageLoad();
    }

    @DataProvider(name = "recreationpage")
    public Object[][] Authentication() throws Exception {
        List<Search> searches = ExcelUtils.getSearchOptions("D://Project//Exercise1//src//main//resources//TestData//DataProvider.xls","Recreation_Search");
        Object[][] objArray = ExcelUtils.getOptions(searches);
        return objArray;

    }

}
