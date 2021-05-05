package org.semenova.enums;

public enum Currencies {
    US_DOLLAR("US Dollar"),
    EURO("Euro");

    private String value;

    Currencies(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
