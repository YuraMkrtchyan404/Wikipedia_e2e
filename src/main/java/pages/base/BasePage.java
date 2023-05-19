package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.locators.BasePageLocators.*;

import pages.common.CreateAccountPage;
import pages.common.MainPage;
import pages.common.RandomArticlePage;

public class BasePage {
    protected WebDriver driver;
    private final By mainHamburgerDropdown = By.id(DROPDOWN_CHECKBOX_ID);
    private final By mainIcon = By.xpath(MAIN_ICON_XPATH);
    private final By searchField = By.xpath(HEADER_SEARCH_FIELD);
    private final By searchButton = By.xpath(SEARCH_BUTTON_XPATH);
    private final By createAccount = By.cssSelector(CREATE_ACCOUNT_LINK_CSSSELECTOR);
    private final By randomArticle = By.xpath(RANDOM_ARTICLE_LINK_XPATH);

    public MainPage goToMainPage() {
        WebElement icon = driver.findElement(mainIcon);
        icon.click();
        return new MainPage(driver);
    }

    public void clickMainDropdown() {
        WebElement dropdown = driver.findElement(mainHamburgerDropdown);
        dropdown.click();
    }

    public void fillInSearch(String input) {
        WebElement search = driver.findElement(searchField);
        search.sendKeys(input);
    }

    public void clickSearchButton() {
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(searchButton));
    }

    public CreateAccountPage goToCreateAccount() {
        WebElement link = driver.findElement(createAccount);
        link.click();
        return new CreateAccountPage(driver);
    }

    public RandomArticlePage generateRandomArticle() {
        WebElement link = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(randomArticle));
        link.click();
        return new RandomArticlePage(driver);
    }
}
