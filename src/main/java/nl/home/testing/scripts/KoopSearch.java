package nl.home.testing.scripts;


import nl.home.testing.data.Search;
import nl.home.testing.pageobjects.HomePage;
import nl.home.testing.utils.ExcelUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;


public class KoopSearch extends BaseClass {

    public static final String SEARCH_PARAMETERS = "searchParameters";
    String screenShotPath="D:/Project/Exercise1/src/main/resources/screenshots/koopsearch_test/TestResults_";
    String expectedValue;


    @BeforeTest
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
    /**
     * Test case to check the last searched criteria are also displayed on the quick search component after each successful search
     * @throws Exception
     */



    @DataProvider(name = SEARCH_PARAMETERS)
    public Object[][] Authentication() throws Exception {
          List<Search> searches = ExcelUtils.getSearchOptions("D://Project//Exercise1//src//main//resources//TestData//DataProvider.xls","Search");
        Object [][] objArray = new Object[searches.size()][];
        int index =0;
        for(Search data:searches) {
            objArray[index] = new Object[1];
            objArray[index++][0] = data;
        }
        return objArray;
    }

    //Search using location, distance , min distance , max distance




}
