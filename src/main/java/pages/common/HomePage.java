package pages.common;

import constants.locators.SearchResultPageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import static constants.locators.HomePageLocators.SEARCH_BUTTON_XPATH;
import static constants.locators.HomePageLocators.SEARCH_FIELD_ID;

public class HomePage {
    protected WebDriver driver;
    private final By searchField = By.id(SEARCH_FIELD_ID);
    private final By searchButton = By.xpath(SEARCH_BUTTON_XPATH);

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillSearchField(String input) {
        WebElement search = driver.findElement(searchField);
        search.sendKeys(input);
    }

    public SearchResultPage clickSearchButton(String input){
        fillSearchField(input);
        WebElement button = driver.findElement(searchButton);
        button.click();
        return new SearchResultPage(driver);
    }

    public AdvancedSearchPage clickSearchButton(){
        WebElement button = driver.findElement(searchButton);
        button.click();
        return new AdvancedSearchPage(driver);
    }
}
