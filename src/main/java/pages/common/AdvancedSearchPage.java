package pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;

import static constants.locators.AdvancedSearchPageLocators.*;

public class AdvancedSearchPage extends BasePage {

    private final By advancedSearchDropdown = By.xpath(ADVANCED_SEARCH_DROPDOWN_XPATH);
    private final By theseWordsInputField = By.xpath(THESE_WORDS_FIELD_XPATH);
    private final By exactlyThisTextField = By.xpath(EXACTLY_THIS_TEXT_FIELD_XPATH);
    private final By searchButton = By.xpath(SEARCH_BUTTON_XPATH);
    private final By sortingOptionsDropdown = By.xpath(SORTING_DROPDOWN);
    private final By editDateCurrentOnTop = By.xpath(CURRENT_ON_TOP_SORT_XPATH);
    public static final By searchResult = By.xpath(RESULT_TEXT);
    public static final By searchText = By.xpath(SEARCH_TEXT_RESULT_XPATH);

    public AdvancedSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAdvancedSearchDropdown() {
        WebElement dropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(advancedSearchDropdown));
        dropdown.click();
    }

    public void fillTheseWordsField(String input) {
        WebElement field = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(theseWordsInputField));
        field.sendKeys(input);
    }

    public void clickSearch() {
        WebElement button = driver.findElement(searchButton);
        button.click();
    }

    public void searchWithTheseWordsInputField(String input) {
        clickAdvancedSearchDropdown();
        fillTheseWordsField(input);
        clickSearch();
    }

    public WebElement getOneSearchResult(By searchResult) {
        WebElement result = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(searchResult));
        return result;
    }

    public void fillExactlyThisTextField(String input) {
        WebElement field = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(exactlyThisTextField));
        field.sendKeys(input);
    }

    public void clickSortDropdown() {
        WebElement dropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(sortingOptionsDropdown));
        dropdown.click();
    }

    public void setSortingOptionsDropdownToCurrentOnTop() {
        WebElement option = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(editDateCurrentOnTop));
        option.click();
    }

    public WebElement getListOfResults() {
        WebElement searchResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("mw-search-result-data")));
        return searchResult.findElement(By.tagName("li"));
    }

}
