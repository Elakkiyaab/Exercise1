package nl.home.testing.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class HomePage {

    WebDriver driver;
    String SearchValue,locationValue,actualTitle;
    By login = By.linkText("Inloggen");

    By registration = By.linkText("Registreren");

    By koopLnk = By.linkText("Koop");

    By huurLnk = By.linkText("Huur");

    By nieuwbouwLnk = By.linkText("Nieuwbouw");

    By recreatieLnk = By.linkText("Recreatie");

    By europaLnk = By.linkText("Europa");

    By lastSearchText = By.xpath("//*[@id='content']/div[1]/div[4]/form/div[1]/p/a");

    By PLACE_LOCATOR = By.id("autocomplete-input");
    By RANGE_SELECTOR = By.id("Afstand");
    By MIN_PRICE_SELECTOR = By.id("range-filter-selector-select-filter_fundakoopprijsvan");
    By MAX_PRICE_SELECTOR = By.id("range-filter-selector-select-filter_fundakoopprijstot");
    By SEARCH_BUTTON = By.xpath("//button[@type='submit']");
    By HOME_BUTTON = By.xpath("html/body/header/div/nav/a/img");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickLogin() {

        driver.findElement(login).click();

    }

    public void clickRegistration() {

        driver.findElement(registration).click();

    }

    public void clickKoopLnk() {

        driver.findElement(koopLnk).click();

    }

    public void clickHuurLnk() {

        driver.findElement(huurLnk).click();

    }

    public void clickNieuwbouwLnk() {

        driver.findElement(nieuwbouwLnk).click();

    }

    public void clickRecreatielLnk() {

        driver.findElement(recreatieLnk).click();

    }

    public void clickEuropaLnk() {

        driver.findElement(europaLnk).click();

    }

    public String getLastSearchText() {


        SearchValue =   driver.findElement(lastSearchText).getText();
        return SearchValue;

    }
    public String getLocationText()
    {
        locationValue = driver.findElement(PLACE_LOCATOR).getAttribute("value");
        return locationValue;
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

    public void clickHomeButton() {
        driver.findElement(HOME_BUTTON).click();
    }

    public String getNewPageTitle()
    {
        actualTitle=driver.getTitle();
        return actualTitle;

    }
}
