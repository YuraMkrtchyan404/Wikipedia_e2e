package common;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.common.AdvancedSearchPage;

import java.util.List;

import static constants.inputs.InputConstants.SEARCH_SENTENCE;
import static constants.inputs.InputConstants.SEARCH_WORDS;

public class AdvancedSearchTests extends BaseTest {



    @Test
    public void theseWordsTest() {
        String[] wordArray = SEARCH_WORDS.split(" ");
        AdvancedSearchPage advancedSearchPage = homePage.clickSearchButton();
        advancedSearchPage.searchWithTheseWordsInputField(SEARCH_WORDS);
        WebElement element = advancedSearchPage.getOneSearchResult(AdvancedSearchPage.searchResult);
        Assert.assertTrue(element.getText().contains(wordArray[0]) || element.getText().contains(wordArray[1]));
    }

    @Test
    public void exactlyThisTextTest(){
        String[] wordArray = SEARCH_SENTENCE.split(" ");
        AdvancedSearchPage advancedSearchPage = homePage.clickSearchButton();
        advancedSearchPage.clickAdvancedSearchDropdown();
        advancedSearchPage.fillExactlyThisTextField(SEARCH_SENTENCE);
        advancedSearchPage.clickSearch();
        WebElement element = advancedSearchPage.getOneSearchResult(AdvancedSearchPage.searchText);
        Assert.assertTrue(element.getText().toLowerCase().contains(wordArray[0]) || element.getText().toLowerCase().contains(wordArray[1]));
    }

//    @Test
//    public void sortTest(){
//        AdvancedSearchPage advancedSearchPage = homePage.clickSearchButton();
//        advancedSearchPage.clickAdvancedSearchDropdown();
//        advancedSearchPage.clickSortDropdown();
//        advancedSearchPage.setSortingOptionsDropdownToCurrentOnTop();
//        advancedSearchPage.fillTheseWordsField("car");
//        advancedSearchPage.clickSearch();
//        List<WebElement> searchResults = advancedSearchPage.getListOfResults();
//        System.out.println(searchResults.isEmpty());
//        Assert.assertTrue(1==1);
//    }


}
