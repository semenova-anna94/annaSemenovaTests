package org.semenova.enums;

public enum ListHeaderMenuItem {
    DESKTOPS("Desktops"),
    NOTEBOOKS("Notebooks"),
    SOFTWARE(""),
    CAMERA_PHOTO(""),
    CELL_PHONE(""),
    OTHERS(""),
    SHOES(""),
    CLOTHING(""),
    ACCESSORIES("");

    private String value;

    ListHeaderMenuItem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
