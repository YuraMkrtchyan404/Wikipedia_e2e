package common;

import base.BaseTest;
import constants.urls.URL;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.common.SearchResultPage;

import static constants.inputs.InputConstants.INVALID_LONG_INPUT;
import static constants.inputs.InputConstants.VALID_INPUT;
import static constants.locators.SearchResultPageLocators.BLOCK_DISPLAY_STATUS;
import static constants.urls.URL.ARTICLE_URL;

public class SearchTests extends BaseTest {


    @Test
    public void noInputTest() {
        homePage.clickSearchButton();
        Assert.assertEquals(driver.getCurrentUrl(), URL.ADVANCED_SEARCH_PAGE_URL);
    }

    @Test
    public void tooLongInputTest() {
        SearchResultPage searchResultPage = homePage.clickSearchButton(INVALID_LONG_INPUT);
        String errorMessageDisplayStatus = searchResultPage.errorMessageDisplayStatus();
        Assert.assertEquals(errorMessageDisplayStatus, BLOCK_DISPLAY_STATUS);
    }

    @Test
    public void validInputTest() {
        homePage.fillSearchField(VALID_INPUT);
        homePage.clickSearchButton();
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, ARTICLE_URL);
    }
}
