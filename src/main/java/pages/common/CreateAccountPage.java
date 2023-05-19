package pages.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;
import java.util.PrimitiveIterator;

import static constants.locators.CreateAccountPageLocators.*;

public class CreateAccountPage extends BasePage {
    private final By userName = By.xpath(USERNAME_XPATH);
    private final By password = By.xpath(PASSWORD_XPATH);
    private final By confirmPassword = By.id(CONFIRM_PASSWORD_ID);
    private final By emailAddress = By.id(EMAIL_ID);
    private final By submitButton = By.id(BUTTON_ID);
    private final By userNameOccupied = By.cssSelector(USERNAME_OCCUPIED_CSSSELECTOR);
    private final By captcha = By.id(CAPTCHA_ID);
    private final By non_matchingPasswordsMessage = By.xpath(NON_MATCHING_PASSWORDS_MASSAGE_XPATH);
    private final By shortPasswordMessage = By.xpath(SHORT_PASSWORD_MESSAGE_XPATH);
    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String input) {
        WebElement userNameField = driver.findElement(userName);
        userNameField.sendKeys(input);
    }

    public void setPassword(String input) {
        WebElement passwordField = driver.findElement(password);
        passwordField.sendKeys(input);
    }

    public void setConfirmPassword(String input) {
        WebElement confirmPasswordField = driver.findElement(confirmPassword);
        confirmPasswordField.sendKeys(input);
    }

    public void setEmailAddress(String input) {
        WebElement emailAddressField = driver.findElement(emailAddress);
        emailAddressField.sendKeys(input);
    }

    public void setCaptcha(String input){
        WebElement captchaField = driver.findElement(captcha);
        captchaField.sendKeys(input);
    }

    public void clickSubmitButton() {
        WebElement submit = driver.findElement(submitButton);
        submit.click();
    }

    public String NameOccupiedDisplayStatus(){
        WebElement message = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(userNameOccupied));
        return message.getCssValue("display");
    }

    public String non_matchingPasswordsMessageDisplayStatus(){
        WebElement message = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(non_matchingPasswordsMessage));
        return message.getCssValue("display");
    }

    public String shortPasswordMessageDisplayStatus(){
        WebElement message = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(shortPasswordMessage));
        return message.getCssValue("display");
    }
}
