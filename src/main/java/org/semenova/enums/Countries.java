package org.semenova.enums;

public enum Countries {
    USA("United States of America");

    private String value;

    Countries(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
