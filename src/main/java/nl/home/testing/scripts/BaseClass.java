package nl.home.testing.scripts;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.*;
import nl.home.testing.pageobjects.HomePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;



public class BaseClass {

    WebDriver driver;
    protected static final String FUNDA_NL = "http://www.funda.nl/";;
    HomePage homepage;

    @BeforeSuite
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "D://Project//Exercise1//driver//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // method for Wait condition
    public void waitUntillPageLoad() {

        // TO wait until the page is loaded.
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wdriver) {
                return ((JavascriptExecutor) driver).executeScript(
                        "return document.readyState"
                ).equals("complete");
            }
        });
    }

    // Method to take screenshot

    public void captureScreenShot(String strPath){
// Take screenshot and store as a file format
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
// now copy the  screenshot to desired location using copyFile method

            FileUtils.copyFile(src, new File(strPath+System.currentTimeMillis()+".png"));                              }
        catch (IOException e)

        {
            System.out.println(e.getMessage());
        }
    }

    public void getTestReport() {
        ExtentReports extent = ExtentReports.get(BaseClass.class);
        extent.init("C:\\Mukesh\\Report\\myreport.html", true);
        extent.log();
    }
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
