package nl.home.testing.testscripts;


import nl.home.testing.properties.Search;
import nl.home.testing.pageobjects.HomePage;
import nl.home.testing.utils.ExcelUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

//This class is used to test quick search using koop properties in home page

public class KoopSearchTest extends BaseClass {

    public static final String SEARCH_PARAMETERS = "searchParameters";
    String screenShotPath="D:/Project/Exercise1/src/main/resources/screenshots/koopsearch_test/TestResults_";
    String expectedValue;


    @BeforeTest(alwaysRun=true)
    public void openUrl() {
        driver.get(FUNDA_NL);
        homepage = new HomePage(driver);
        homepage.clickKoopLnk();
        waitUntillPageLoad();
    }



    /**
     * Test case to search using location name and other fields with default values
     * @param search
     * @throws Exception
     */
    @Test(dataProvider = SEARCH_PARAMETERS,priority=0)
    public void searchLocation(final Search search) throws Exception {
      homepage.setPLACE_LOCATOR(search.getLocation());
      homepage.setRANGE_SELECTOR(search.getDistance());
       homepage.setMIN_PRICE_SELECTOR(search.getMinPrice());
        homepage.setMAX_PRICE_SELECTOR(search.getTotPrice());
        captureScreenShot(screenShotPath);
        homepage.clickSearch();
        captureScreenShot(screenShotPath);
        homepage.clickHomeButton();
        waitUntillPageLoad();
    }




    @DataProvider(name = SEARCH_PARAMETERS)
    public Object[][] Authentication() throws Exception {
          List<Search> searches = ExcelUtils.getSearchOptions("D://Project//Exercise1//src//main//resources//TestData//DataProvider.xls","Koop_Search");
        Object[][] objArray = ExcelUtils.getOptions(searches);
        return objArray;

    }


}
