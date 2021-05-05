package org.semenova.tests;

import org.semenova.driver.WebDriverHolder;
import org.semenova.enums.HeaderMenuItem;
import org.semenova.enums.ListHeaderMenuItem;
import org.semenova.pages.*;
import org.semenova.utils.PropertiesReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CartAndWishlistTests extends BaseTestClass {
    private String expectedSuccessMessage = "The product has been added to your wishlist";
    private String expectedQuantityAddItemInWishlist = "(1)";
    private String expectedWishlistName = "Wishlist";
    private String expectedNotebooksName = PropertiesReader.getInstance().getProperty("notebooks.name");
    private String expectedQuantityRemovedItemInWishlist = "(0)";
    private String expectedEmptyWishlistMessage = "The wishlist is empty!";
    private String expectedQuantityItemInShoppingCart = "(1)";
    private String expectedShoppingCartName = "Shopping cart";

    ProductsPage productsPage;
    WishlistPage wishlistPage;
    ShoppingCartPage shoppingCartPage;
    LogInPage logInPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void logout() {
        WebDriverHolder.getInstance().getDriver().manage().deleteAllCookies();
        WebDriverHolder.getInstance().getDriver().get(PropertiesReader.getInstance().getProperty("app.url"));
    }

    @Test
    public void addProductToWishlist() {
        BasePage basePage = new BasePage()
                .getHeaderMenu().moveToHeaderMenuItem(HeaderMenuItem.COMPUTERS);
        productsPage = basePage.getHeaderMenu().selectSublistHeaderMenu(ListHeaderMenuItem.NOTEBOOKS);
        productsPage.addToWishlist(PropertiesReader.getInstance().getProperty("notebooks.name")).waitTillPageIsLoaded();
        Assert.assertEquals(productsPage.getSuccessMessageText(), expectedSuccessMessage);

        wishlistPage = productsPage.clickWishlistPage();
        Assert.assertEquals(wishlistPage.getQuantityItemInWishlist(), expectedQuantityAddItemInWishlist);
        Assert.assertEquals(wishlistPage.getWishlistPageName(), expectedWishlistName);
        Assert.assertEquals(wishlistPage.getProductName(), expectedNotebooksName);
    }

    @Test
    public void removeProductFromWishlist(){
        BasePage basePage = new BasePage()
                .getHeaderMenu().moveToHeaderMenuItem(HeaderMenuItem.COMPUTERS);
        productsPage = basePage.getHeaderMenu().selectSublistHeaderMenu(ListHeaderMenuItem.NOTEBOOKS);
        productsPage.addToWishlist(PropertiesReader.getInstance().getProperty("notebooks.name")).waitTillPageIsLoaded();
        wishlistPage = productsPage.clickWishlistPage();
        wishlistPage.clickOnRemoveButtonFromWishlist();
        Assert.assertEquals(wishlistPage.getEmptyWishlistMessage(), expectedEmptyWishlistMessage);
        Assert.assertEquals(wishlistPage.getQuantityItemInWishlist(), expectedQuantityRemovedItemInWishlist);
    }

    @Test
    public void addProductFromWishlistToShoppingCartAndPayOrder() {
        BasePage basePage = new BasePage()
                .getMainMenu()
                .selectLoginMenuItem();

        ((LogInPage)basePage).successfulLogin(PropertiesReader.getInstance().getProperty("user.name"),
                PropertiesReader.getInstance().getProperty("user.password"));

        basePage.getHeaderMenu().moveToHeaderMenuItem(HeaderMenuItem.COMPUTERS);
        productsPage = basePage.getHeaderMenu().selectSublistHeaderMenu(ListHeaderMenuItem.NOTEBOOKS);
        productsPage.addToWishlist(PropertiesReader.getInstance().getProperty("notebooks.name")).waitTillPageIsLoaded();
        wishlistPage = productsPage.clickWishlistPage();
        shoppingCartPage = wishlistPage.addProductToShoppingCart();

        Assert.assertEquals(shoppingCartPage.getQuantityItemInShoppingCart(), expectedQuantityItemInShoppingCart);
        Assert.assertEquals(shoppingCartPage.getShoppingCartPageName(), expectedShoppingCartName);

        checkoutPage = shoppingCartPage.clickOnTermsOfServiceCheckbox().clickOnCheckoutButton();








    }
}
