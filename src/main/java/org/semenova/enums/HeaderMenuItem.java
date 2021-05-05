package org.semenova.enums;

public enum HeaderMenuItem {
    COMPUTERS("Computers"),
    ELECTRONICS("electronics"),
    APPAREL("apparel"),
    DIGITAL_DOWNLOADS("digital_downloads"),
    BOOKS("books"),
    JEWELRY("jewelry"),
    GIFT_CARDS("gift_cards");

    private String value;

    HeaderMenuItem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
