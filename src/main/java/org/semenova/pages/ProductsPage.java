package org.semenova.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.semenova.driver.WebDriverHolder;
import org.semenova.utils.PropertiesReader;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy (css = "div.bar-notification.success p")
    protected WebElement successMessage;

    @FindBy (css = ".bar-notification.success a")
    protected WebElement wishlistLink;

    public ProductsPage() {
        super();
    }

    public ProductsPage addToWishlist(String item) {
        List<WebElement> list = WebDriverHolder.getInstance().getDriver().findElements(By.cssSelector(".product-title"));
        String[] arrayItems = new String[list.size()];
        int j = 0;
        for(WebElement webElement: list)
        {
            arrayItems[j]=webElement.getText();
            j++;
        }

        for (int i = 0; i < arrayItems.length; i++) {
            System.out.println(arrayItems[i]);
            if (arrayItems[i].equals(item)) {
                System.out.println(arrayItems[i].equals(item) + arrayItems[i]);
                WebElement chooseItem = WebDriverHolder.getInstance().getDriver()
                        .findElement(By.xpath("//a[contains(text(),'" + arrayItems[i] + "')]//following::button[text()='Add to wishlist']"));
                actionProvider().moveToElement(chooseItem).build().perform();
                chooseItem.click();
            }
        }
        return this;
    }

    public String getSuccessMessageText(){
        return successMessage.getText();
    }

    public ProductsPage waitTillPageIsLoaded() {
        WebDriverHolder.getInstance().getWaiter().until(ExpectedConditions.visibilityOf(successMessage));
        return this;
    }

    public WishlistPage clickWishlistPage() {
        wishlistLink.click();
        return new WishlistPage();
    }
}



