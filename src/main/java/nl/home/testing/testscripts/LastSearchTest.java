package nl.home.testing.testscripts;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import nl.home.testing.pageobjects.HomePage;



//This class is used to check last searched string in home page
public class LastSearchTest extends BaseClass {

    String expectedValue,actualValue;
    String screenShotPath="D:/Project/Exercise1/src/main/resources/screenshots/lastSearch_test/TestResults_";
    @BeforeTest
    public void openUrl() {
        driver.get(FUNDA_NL);
        homepage = new HomePage(driver);
        homepage.clickKoopLnk();
        waitUntillPageLoad();
    }


    @Test
    public void checkLastSearchText() throws Exception {
        homepage.setPLACE_LOCATOR("Utrecht");
        expectedValue=homepage.getLocationText();
        homepage.clickSearch();
        homepage.clickHomeButton();
        waitUntillPageLoad();
        captureScreenShot(screenShotPath);
        actualValue=homepage.getLastSearchText();
        Assert.assertEquals(actualValue,expectedValue);

    }
}
