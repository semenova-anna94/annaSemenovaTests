package org.semenova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.semenova.driver.WebDriverHolder;
import org.semenova.enums.MainMenuItems;

public class MainMenu {

    @FindBy(css = ".header-links")
    protected WebElement baseMenuElement;

    public MainMenu(){
        PageFactory.initElements(WebDriverHolder.getInstance().getDriver(), this);
    }

    public BasePage selectMenuItem(MainMenuItems menuItem){
        baseMenuElement.findElement(By.xpath(".//a[@class='ico-" + menuItem.getValue() + "']")).click();
        return new BasePage();
    }

    public LogInPage selectLoginMenuItem(){
        selectMenuItem(MainMenuItems.lOG_IN);
        return new LogInPage();
    }

    public boolean isMainMenuElementVisible(MainMenuItems menuItem){
        return baseMenuElement.findElement(By.xpath(".//a[@class='ico-" + menuItem.getValue() + "']")).isDisplayed();
    }
}
