package nl.home.testing.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class RecreationPage {
    WebDriver driver;
    String actualTitle;
    By PLACE_LOCATOR = By.id("search-place-postalcode");
    By RANGE_SELECTOR = By.id("Range");
    By MIN_PRICE_SELECTOR = By.id("SaleFrom");
    By MAX_PRICE_SELECTOR = By.id("SaleTo");
    By SEARCH_BUTTON = By.xpath("//input[@value='Zoeken']");
    By KOOP_LNK = By.id("toggleSale");
    By HUUR_LNK = By.id("toggleRent");
    By BOTH_LNK = By.xpath("//*[@id='toggleBoth']");




    public RecreationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setPLACE_LOCATOR(String strLocationText) {
        driver.findElement(PLACE_LOCATOR).isEnabled();
        driver.findElement(PLACE_LOCATOR).clear();
        driver.findElement(PLACE_LOCATOR).click();
        driver.findElement(PLACE_LOCATOR).sendKeys(strLocationText);
    }

    public void setRANGE_SELECTOR(String strRange) {
        new Select(driver.findElement(RANGE_SELECTOR)).selectByValue(strRange);
    }

    public void setMIN_PRICE_SELECTOR(String strMinPrice) {
        new Select(driver.findElement(MIN_PRICE_SELECTOR)).selectByValue(strMinPrice);
    }

    public void setMAX_PRICE_SELECTOR(String strTotPrice) {
        (new Select(driver.findElement(MAX_PRICE_SELECTOR))).selectByValue(strTotPrice);
    }

    public void clickSearch() {
        driver.findElement(SEARCH_BUTTON).click();
    }

    public void clickKoopLnk() {
        driver.findElement(KOOP_LNK).click();
    }
    public void clickHuurLnk() {
        driver.findElement(HUUR_LNK).click();
    }
    public void clickBothLnk() {
        driver.findElement(BOTH_LNK).click();
    }

}
