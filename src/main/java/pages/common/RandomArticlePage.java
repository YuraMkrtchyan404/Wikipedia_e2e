package pages.common;

import constants.locators.RandomArticlePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import static constants.locators.RandomArticlePageLocators.LANGUAGE_DROPDOWN_ID;

public class RandomArticlePage extends BasePage {
    private By languagesDropdown = By.id(LANGUAGE_DROPDOWN_ID);

    public RandomArticlePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLanguageDropdown() {
        WebElement dropdown = driver.findElement(languagesDropdown);
        dropdown.click();
    }


}
