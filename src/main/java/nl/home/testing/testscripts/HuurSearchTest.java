package nl.home.testing.testscripts;


import nl.home.testing.properties.Search;

import nl.home.testing.pageobjects.HomePage;
import nl.home.testing.pageobjects.HuurPage;
import nl.home.testing.utils.ExcelUtils;
import org.apache.commons.logging.Log;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;

//This class is used to test quick search using Huur properties in home page

public class HuurSearchTest extends BaseClass {

    String screenShotPath="D:/Project/Exercise1/src/main/resources/screenshots/huursearch_test/TestResults_";
    String expectedPageTitle,actualPageTitle;
    private static Logger Log = Logger.getLogger(Log.class.getName());
    @BeforeTest
    public void openUrl() {
        driver.get(FUNDA_NL);
        huurpage = new HuurPage(driver);
        homepage = new HomePage(driver);
        homepage.clickHuurLnk();
        waitUntillPageLoad();
    }



    /**
     * Test case to search using location name and other fields with default values
     * @param search
     * @throws Exception
     */
    @Test(dataProvider = "huurSearch")
    public void searchLocation(final Search search) throws Exception {

        huurpage.setPLACE_LOCATOR(search.getLocation());
        huurpage.setRANGE_SELECTOR(search.getDistance());
        huurpage.setMIN_PRICE_SELECTOR(search.getMinPrice());
        huurpage.setMAX_PRICE_SELECTOR(search.getTotPrice());
        captureScreenShot(screenShotPath);
        huurpage.clickSearch();
        Log.info("Navigated to huur page");
        expectedPageTitle=search.getPageTitle();
        actualPageTitle=homepage.getNewPageTitle();
        System.out.println(expectedPageTitle);
        captureScreenShot(screenShotPath);
       assertEquals(actualPageTitle,expectedPageTitle);
        homepage.clickHomeButton();
        Reporter.log("Test case passed");

    }




    @DataProvider(name = "huurSearch")
    public Object[][] Authentication() throws Exception {
        List<Search> searches = ExcelUtils.getSearchOptions("D://Project//Exercise1//src//main//resources//TestData//DataProvider.xls","Huur_Search");
        Object[][] objArray = ExcelUtils.getOptions(searches);
        return objArray;
}
}
