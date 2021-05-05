package org.semenova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.semenova.driver.WebDriverHolder;
import org.semenova.enums.HeaderMenuItem;
import org.semenova.enums.ListHeaderMenuItem;

public class HeaderMenu extends BasePage{

    @FindBy (css = ".header-menu")
    protected WebElement headerMenuElement;

    public HeaderMenu() {
        PageFactory.initElements(WebDriverHolder.getInstance().getDriver(), this);
    }

    public BasePage moveToHeaderMenuItem(HeaderMenuItem headerMenuItem){
        WebElement chooseHeaderMenuItem = WebDriverHolder.getInstance().getDriver()
                .findElement(By.linkText(headerMenuItem.getValue()));

        actionProvider().moveToElement(chooseHeaderMenuItem).build().perform();
        return new BasePage();
    }

    public ProductsPage selectSublistHeaderMenu(ListHeaderMenuItem listHeaderMenuItem){
        headerMenuElement.findElement(By.linkText(listHeaderMenuItem.getValue())).click();
        return new ProductsPage();
    }
}
