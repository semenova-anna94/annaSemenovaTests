package org.semenova.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.semenova.driver.WebDriverHolder;

public class CheckoutPage extends BasePage {

    @FindBy (tagName = "h1")
    protected WebElement checkoutPageName;

    private BillingAddressPage billingAddressPage;

    public CheckoutPage() {
        super();
    }

    public CheckoutPage waitTillPageIsLoaded() {
        WebDriverHolder.getInstance().getWaiter().until(ExpectedConditions.visibilityOf(checkoutPageName));
        return this;
    }

    public BillingAddressPage getBillingAddressPage(){
        return new BillingAddressPage();
    }


}
