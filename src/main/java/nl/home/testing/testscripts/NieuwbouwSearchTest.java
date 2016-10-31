package nl.home.testing.testscripts;


import nl.home.testing.data.Search;
import nl.home.testing.pageobjects.HomePage;
import nl.home.testing.utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class NieuwbouwSearchTest extends BaseClass {

    public static final String SEARCH_PARAMETERS = "searchParameters";
    String screenShotPath = "D:/Project/Exercise1/src/main/resources/screenshots/nieuwbouwsearch_test/TestResults_";
    String expectedPageTitle, actualPageTitle;


    @BeforeTest(alwaysRun=true)
    public void openUrl() {
        driver.get(FUNDA_NL);
        homepage = new HomePage(driver);
        homepage.clickNieuwbouwLnk();
        waitUntillPageLoad();
    }


    /**
     * Test case to search using location name and other fields with default values
     *
     * @param search
     * @throws Exception
     */
    @Test(dataProvider = "nieuwbouwserach")
    public void searchLocation(final Search search) throws Exception {
        homepage.setPLACE_LOCATOR(search.getLocation());
        homepage.setRANGE_SELECTOR(search.getDistance());
        captureScreenShot(screenShotPath);
        homepage.clickSearch();
        waitUntillPageLoad();
        actualPageTitle = homepage.getNewPageTitle();
        expectedPageTitle = search.getPageTitle();
        captureScreenShot(screenShotPath);
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
        homepage.clickHomeButton();

    }


    @DataProvider(name = "nieuwbouwserach")
    public Object[][] Authentication() throws Exception {
        List<Search> searches = ExcelUtils.getSearchOptions("D://Project//Exercise1//src//main//resources//TestData//DataProvider.xls", "Nieuwbouw_Search");
        Object[][] objArray = ExcelUtils.getOptions(searches);
        return objArray;
    }

}