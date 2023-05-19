package pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

import static constants.locators.SearchResultPageLocators.ERROR_MESSAGE_XPATH;

public class SearchResultPage extends BasePage {
    private final By errorMessage = By.xpath(ERROR_MESSAGE_XPATH);

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
    }

    public String errorMessageDisplayStatus() {
        WebElement message = driver.findElement(errorMessage);
        return message.getCssValue("display");
    }
}
