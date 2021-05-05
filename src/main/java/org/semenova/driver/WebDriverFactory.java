package org.semenova.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.semenova.enums.BrowserName;

public class WebDriverFactory {
    public static WebDriver initDriver(BrowserName browserName) {
        WebDriver driver = null;
        switch (browserName) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();

        return driver;
    }

    public static WebDriver initDriver() {
        String browserName = null;
        try {
            browserName = System.getProperty("browserName", "chrome");
        } catch (NullPointerException e) {
            System.out.println("Don't find WebDriver");
        }
        return initDriver(BrowserName.valueOf(browserName.toUpperCase()));
    }

}
