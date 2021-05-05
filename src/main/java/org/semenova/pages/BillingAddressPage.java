package org.semenova.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.semenova.driver.WebDriverHolder;
import org.semenova.enums.Countries;
import org.semenova.enums.Currencies;

public class BillingAddressPage {

    @FindBy (id = "checkout-step-billing")
    protected WebElement billingAddressStep;

    @FindBy (id = "ShipToSameAddress")
    protected WebElement shipToSameAddressCheckbox;

    @FindBy (id = "BillingNewAddress_CountryId")
    protected WebElement billingCountrySelect;

    @FindBy (id = "BillingNewAddress_StateProvinceId")
    protected WebElement billingStateSelect;

    @FindBy (id = "BillingNewAddress_City")
    protected WebElement billingCityInput;

    @FindBy (id = "BillingNewAddress_Address1")
    protected WebElement billingAddress1Input;

    @FindBy (id = "BillingNewAddress_ZipPostalCode")
    protected WebElement billingZipInput;

    @FindBy (id = "BillingNewAddress.PhoneNumber")
    protected WebElement billingPhoneInput;

    @FindBy (css = "button-1.new-address-next-step-button")
    protected WebElement newAddressStepButton;

    public BillingAddressPage(){
        PageFactory.initElements(WebDriverHolder.getInstance().getDriver(), this);
    }

    private BillingAddressPage enterValue(String value, WebElement element){
        element.clear();
        element.sendKeys(value);
        return this;
    }

    public BillingAddressPage chooseBillingCountry(Countries country){
        Select billingCountry = new Select(billingCountrySelect);
        billingCountry.selectByVisibleText(country.getValue());
        return this;
    }

//    public BillingAddressPage chooseBillingState() {
//        Select billingState = new Select(billingStateSelect);
//        billingState.selectByVisibleText(country.getValue());
//        return this;
//    }
}
