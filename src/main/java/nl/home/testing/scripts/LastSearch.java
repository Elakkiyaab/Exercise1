package nl.home.testing.scripts;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import nl.home.testing.pageobjects.HomePage;

import java.io.File;


public class LastSearch extends BaseClass {

    String expectedValue;
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

        if(homepage.getLastSearchText().contentEquals(expectedValue))
        {
            System.out.println("content matches");

        } else
            System.out.print("content doesn't matches");

    }
}
