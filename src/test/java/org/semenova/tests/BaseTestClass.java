package org.semenova.tests;

import org.apache.commons.io.FileUtils;
import org.semenova.constants.Constants;
import org.semenova.driver.WebDriverHolder;
import org.semenova.listeners.MyListener;
import org.semenova.utils.PropertiesReader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;

@Listeners(MyListener.class)
public class BaseTestClass {

    @BeforeSuite
    public void beforeSuite() throws IOException {
        reCreateScreenshotFolder();
        WebDriverHolder.getInstance().initDriver();
    }

    @AfterSuite
    public void afterSuite() {
        if (WebDriverHolder.getInstance().getDriver() != null) {
            WebDriverHolder.getInstance().getDriver().quit();
        }
    }

    public void goToUrl(String url) {
        WebDriverHolder.getInstance().getDriver().get(url);
    }

    public void goToUrl() {
        goToUrl(PropertiesReader.getInstance().getProperty("app.url"));
    }

    private void reCreateScreenshotFolder() throws IOException{
        File screenshotFolder = new File(Constants.SCREENSHOT_FOLDER);
        if (screenshotFolder.exists()) {
            FileUtils.forceDelete(screenshotFolder);
        }
        FileUtils.forceMkdir(screenshotFolder);
    }

}
