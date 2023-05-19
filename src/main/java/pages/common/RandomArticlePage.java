package pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;

import static constants.locators.RandomArticlePageLocators.*;

public class RandomArticlePage extends BasePage {
    public static final By language = By.linkText(LANGUAGE_LINK_TEXT);
    private final By languagesDropdown = By.id(LANGUAGE_DROPDOWN_ID);

    public RandomArticlePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLanguageDropdown() {
        WebElement dropdown = driver.findElement(languagesDropdown);
        dropdown.click();
    }

    //I am proud of this one :D
    public String[] clickLanguageFromList(){
        String[] beforeAfter = new String[2];
        WebElement list = null;
        while (list == null){
            try {
                list = new WebDriverWait(driver, Duration.ofSeconds(2))
                        .until(ExpectedConditions.elementToBeClickable(language));
                beforeAfter[0] = driver.getCurrentUrl();
            }catch (org.openqa.selenium.NoSuchElementException | TimeoutException e){
                clickMainDropdown();
                generateRandomArticle();

                clickLanguageDropdown();
            }
        }

        list.click();
        beforeAfter[1] = driver.getCurrentUrl();
        return beforeAfter;
    }
}
