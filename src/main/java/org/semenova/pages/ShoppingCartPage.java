package org.semenova.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.semenova.driver.WebDriverHolder;

public class ShoppingCartPage extends BasePage {

    @FindBy (css = ".cart-qty")
    protected WebElement quantityItemInShoppingCart;

    @FindBy (tagName = "h1")
    protected WebElement shoppingCartNamePage;

    @FindBy (id = "checkout")
    protected WebElement checkoutButton;

    @FindBy (id = "termsofservice")
    protected WebElement termsOfServiceCheckbox;

    public ShoppingCartPage(){
        super();
    }

    public ShoppingCartPage waitTillPageIsLoaded() {
        WebDriverHolder.getInstance().getWaiter().until(ExpectedConditions.visibilityOf(checkoutButton));
        return this;
    }

    public String getQuantityItemInShoppingCart(){
       return quantityItemInShoppingCart.getText();
    }

    public String getShoppingCartPageName(){
        return shoppingCartNamePage.getText();
    }

    public ShoppingCartPage clickOnTermsOfServiceCheckbox(){
        termsOfServiceCheckbox.click();
        return this;
    }

    public CheckoutPage clickOnCheckoutButton(){
        checkoutButton.click();
        return new CheckoutPage();
    }
}
