package nl.home.testing.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HuurPage {
    WebDriver driver;
    String actualTitle;
    By PLACE_LOCATOR = By.id("autocomplete-input");
    By RANGE_SELECTOR = By.id("Afstand");
    By MIN_PRICE_SELECTOR = By.id("range-filter-selector-select-filter_fundahuurprijsvan");
    By MAX_PRICE_SELECTOR = By.id("range-filter-selector-select-filter_fundahuurprijstot");
    By SEARCH_BUTTON = By.xpath("//button[@type='submit']");



    public HuurPage(WebDriver driver) {
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


    public String getPageTitle()
    {
        actualTitle=driver.getTitle();
        return actualTitle;

    }

}
