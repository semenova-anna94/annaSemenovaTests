package org.semenova.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.semenova.driver.WebDriverHolder;

public class WishlistPage extends BasePage{

    @FindBy (css = ".wishlist-qty")
    protected WebElement quantityItemInWishlist;

    @FindBy (tagName = "h1")
    protected WebElement wishlistPageName;

    @FindBy (css = ".product-name")
    protected WebElement productName;

    @FindBy (css = ".remove-btn")
    protected WebElement removeButtonFromWishlist;

    @FindBy (css = ".no-data")
    protected WebElement emptyWishlistMessage;

    @FindBy (name = "addtocart")
    protected WebElement addToCartCheckbox;

    @FindBy (name = "addtocartbutton")
    protected WebElement addToCartButton;

    public WishlistPage(){
        super();
    }

    public WishlistPage waitTillPageIsLoaded() {
        WebDriverHolder.getInstance().getWaiter().until(ExpectedConditions.visibilityOf(wishlistPageName));
        return this;
    }

    public String getQuantityItemInWishlist(){
        return quantityItemInWishlist.getText();
    }

    public String getWishlistPageName(){
        return wishlistPageName.getText();
    }

    public String getProductName(){
        return productName.getText();
    }

    public WishlistPage clickOnRemoveButtonFromWishlist(){
        removeButtonFromWishlist.click();
        return new WishlistPage();
    }

    public String getEmptyWishlistMessage(){
        return emptyWishlistMessage.getText();
    }

    public ShoppingCartPage addProductToShoppingCart(){
        addToCartCheckbox.click();
        addToCartButton.click();
        return new ShoppingCartPage();
    }


}
