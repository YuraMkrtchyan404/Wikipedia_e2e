package constants.locators;

public class CreateAccountPageLocators {
    public static final String USERNAME_XPATH = "//body[1]/div[2]/div[1]/div[3]/main[1]/div[3]/div[3]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/input[1]";
    public static final String PASSWORD_XPATH = "//body[1]/div[2]/div[1]/div[3]/main[1]/div[3]/div[3]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/input[1]";
    public static final String CONFIRM_PASSWORD_ID = "wpRetype";
    public static final String EMAIL_ID = "wpEmail";
    public static final String BUTTON_ID = "wpCreateaccount";
    public static final String USERNAME_OCCUPIED_CSSSELECTOR = "body.skin-vector.skin-vector-search-vue.mediawiki.ltr.sitedir-ltr.mw-hide-empty-elt.ns--1.ns-special.mw-special-CreateAccount.page-Special_CreateAccount.rootpage-Special_CreateAccount.skin-vector-2022.action-view.uls-dialog-sticky-hide:nth-child(2) div.mw-page-container:nth-child(3) div.mw-page-container-inner div.mw-content-container main.mw-body div.vector-body div.mw-body-content:nth-child(3) div.mw-ui-container:nth-child(1) form.mw-htmlform.mw-ui-vform.mw-ui-container div:nth-child(2) div.mw-htmlform-field-HTMLTextField.loginText.mw-ui-vform-field:nth-child(2) div.mw-input:nth-child(2) > div.mw-message-box.mw-message-box-error";
    public static final String CAPTCHA_ID = "mw-input-captchaWord";
    public static final String NON_MATCHING_PASSWORDS_MASSAGE_XPATH = "//div[contains(text(),'The passwords you entered do not match.')]";
    public static final String SHORT_PASSWORD_MESSAGE_XPATH = "//body/div[2]/div[1]/div[3]/main[1]/div[3]/div[3]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]";

}
