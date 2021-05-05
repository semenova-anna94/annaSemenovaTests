package org.semenova.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.semenova.driver.WebDriverHolder;
import org.semenova.enums.Currencies;
import org.semenova.enums.MainMenuItems;

public class BasePage {

    @FindBy (id = "customerCurrency")
    protected WebElement changeCurrencySelect;

    @FindBy (id = "small-searchterms")
    protected WebElement searchInput;

    private MainMenu mainMenu;

    private HeaderMenu headerMenu;

    public BasePage() {
        PageFactory.initElements(WebDriverHolder.getInstance().getDriver(), this);
    }

    public BasePage changeCurrency(Currencies currency){
        Select currencySelect = new Select(changeCurrencySelect);
        currencySelect.selectByVisibleText(currency.getValue());
        return new BasePage();
    }

    public BasePage search(String template){
        searchInput.clear();
        searchInput.sendKeys(template);
        searchInput.submit();
        return new BasePage();
    }

    public MainMenu getMainMenu() {
        return new MainMenu();
    }

    public boolean isUserLoggedIn(){
        return  getMainMenu().isMainMenuElementVisible(MainMenuItems.LOG_OUT);
    }

    public HeaderMenu getHeaderMenu() {
        return new HeaderMenu();
    }

    public BasePage waitTillPageIsLoaded() {
        WebDriverHolder.getInstance().getWaiter().until(ExpectedConditions.visibilityOf(changeCurrencySelect));
        return this;
    }

    public Actions actionProvider(){
        Actions action = new Actions(WebDriverHolder.getInstance().getDriver());
        return action;
    }
}

