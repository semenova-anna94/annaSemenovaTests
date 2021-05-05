package org.semenova.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.semenova.driver.WebDriverHolder;

public class LogInPage extends BasePage {

    @FindBy(id = "Email")
    private WebElement emailInput;

    @FindBy(id = "Password")
    private WebElement passwordInput;

    @FindBy(css = ".button-1.login-button")
    private WebElement logInButton;

    @FindBy(css = ".validation-summary-errors")
    private WebElement messageError;

    @FindBy(css = ".field-validation-error")
    private WebElement emailError;

    public LogInPage() {
        super();
    }


    public BasePage successfulLogin(String name, String password){
        enterValue(name, emailInput);
        enterValue(password, passwordInput);
        logInButton.click();
        return new BasePage();
    }

    private BasePage enterValue(String value, WebElement element){
       element.clear();
       element.sendKeys(value);
       return this;
    }

    public BasePage unsuccessfulLogin(String name, String password) {
        enterValue(name, emailInput);
        enterValue(password, passwordInput);
        logInButton.click();
        return this;
    }

    public String getMessageErrorText(){
        return messageError.getText();
    }

    public String getEmailErrorText(){
        return emailError.getText();
    }

}
