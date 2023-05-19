package common;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.common.AdvancedSearchPage;
import pages.common.MainPage;

import java.time.Duration;

public class RandomArticleTests extends BaseTest {
    @Test
    public void randomArticleTest(){
        AdvancedSearchPage advancedSearchPage = homePage.clickSearchButton();
        MainPage mainPage = advancedSearchPage.goToMainPage();
        mainPage.clickMainDropdown();
        mainPage.generateRandomArticle();
        String article1 = driver.getCurrentUrl();

        mainPage.clickMainDropdown();
        mainPage.generateRandomArticle();
        String article2 = driver.getCurrentUrl();
        Assert.assertNotEquals(article1, article2);
    }
}
