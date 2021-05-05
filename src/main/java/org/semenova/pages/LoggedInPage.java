package org.semenova.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.semenova.driver.WebDriverHolder;

public class LoggedInPage extends BasePage {

    @FindBy(css = ".ico-logout")
    private WebElement logOutLink;

    public LoggedInPage() {
        super();
    }


    public BasePage logOut() {
        logOutLink.click();
        return new BasePage();
    }
}

