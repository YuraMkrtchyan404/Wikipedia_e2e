package common;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.common.CreateAccountPage;

import static constants.inputs.InputConstants.*;
import static constants.urls.URL.CREATE_ACCOUNT_PAGE_URL;
import static constants.messages.AssertionMessages.STATUS_BLOCK;

public class CreateAccountTests extends BaseTest {

    private CreateAccountPage goToCreateAccountPage(){
        return homePage.clickSearchButton().goToCreateAccount();
    }

    /*
    The pop-up message was impossible to find in the DOM (Or my skills were not enough). That's why I am testing that
    it stays on the same page after skipping the required fields.
     */
    @Test
    public void skipUsernameTest(){
        CreateAccountPage createAccountPage = goToCreateAccountPage();
        createAccountPage.clickSubmitButton();
        Assert.assertEquals(driver.getCurrentUrl(), CREATE_ACCOUNT_PAGE_URL);
    }

    @Test
    public void occupiedUsernameTest(){
        CreateAccountPage createAccountPage = goToCreateAccountPage();
        createAccountPage.setUserName(OCCUPIED_NAME);
        Assert.assertEquals(createAccountPage.NameOccupiedDisplayStatus(), STATUS_BLOCK);
    }

    @Test
    public void skipPasswordTest(){
        CreateAccountPage createAccountPage = goToCreateAccountPage();
        createAccountPage.setUserName(VALID_USERNAME);
        createAccountPage.clickSubmitButton();
        Assert.assertEquals(driver.getCurrentUrl(), CREATE_ACCOUNT_PAGE_URL);
    }

    @Test
    public void non_matchingPasswordTest(){
        CreateAccountPage createAccountPage = goToCreateAccountPage();
        createAccountPage.setUserName(VALID_USERNAME);
        createAccountPage.setPassword(PASSWORD);
        createAccountPage.setConfirmPassword(BAD_CONFIRM_PASSWORD);
        createAccountPage.setCaptcha(JUST_SOMETHING);
        createAccountPage.clickSubmitButton();
        String message = createAccountPage.non_matchingPasswordsMessageDisplayStatus();
        Assert.assertEquals(message, STATUS_BLOCK);
    }

    @Test
    public void shortPasswordMessageTest(){
        CreateAccountPage createAccountPage = goToCreateAccountPage();
        createAccountPage.setUserName(VALID_USERNAME);
        createAccountPage.setPassword("short");
        String message = createAccountPage.shortPasswordMessageDisplayStatus();
        Assert.assertEquals(message, STATUS_BLOCK);
    }
}
