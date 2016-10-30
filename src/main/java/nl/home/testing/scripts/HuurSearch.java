package nl.home.testing.scripts;


import nl.home.testing.data.Search;

import nl.home.testing.pageobjects.HomePage;
import nl.home.testing.pageobjects.HuurPage;
import nl.home.testing.utils.ExcelUtils;
import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class HuurSearch extends BaseClass {

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
        actualPageTitle=huurpage.getPageTitle();
        captureScreenShot(screenShotPath);
        huurpage.getPageTitle();
        Assert.assertEquals(expectedPageTitle,actualPageTitle);
        homepage.clickHomeButton();
        Reporter.log("Test case passed");

    }




    @DataProvider(name = "huurSearch")
    public Object[][] Authentication() throws Exception {
        List<Search> searches = ExcelUtils.getSearchOptions("D://Project//Exercise1//src//main//resources//TestData//DataProvider.xls","Huur_Search");
        Object [][] objArray = new Object[searches.size()][];
        int index =0;
        for(Search data:searches) {
            objArray[index] = new Object[1];
            objArray[index++][0] = data;
        }
        return objArray;
    }
}
