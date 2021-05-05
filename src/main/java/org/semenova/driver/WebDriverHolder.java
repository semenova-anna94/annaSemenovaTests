package org.semenova.driver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class WebDriverHolder {
    private WebDriver driver = null;
    private WebDriverWait wait =null;
    private static WebDriverHolder instance = null;

    public static WebDriverHolder getInstance() {
        if (instance == null) {
            instance = new WebDriverHolder();
        }
        return instance;
    }

    private WebDriverHolder() {

    }

    public WebDriver getDriver() {
        return driver;
    }

    public JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) getDriver();
    }

    public void initDriver() {
        if (Objects.isNull(driver)) {
            driver = WebDriverFactory.initDriver();
            wait = new WebDriverWait(driver, 30);
        }
    }

    public WebDriverWait getWaiter() {
        return wait;
    }
}
