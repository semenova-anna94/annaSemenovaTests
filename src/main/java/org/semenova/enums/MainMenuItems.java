package org.semenova.enums;

public enum MainMenuItems {
    REGISTER("register"),
    lOG_IN("login"),
    WISHLIST("wishlist"),
    SHOPPING_CART("cart"),
    LOG_OUT("logout"),
    ACCOUNT("account");

    private String value;

    MainMenuItems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
