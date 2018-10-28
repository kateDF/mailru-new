package com.epam.mailru.driver;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWebDriverFactory {

    private static LocalWebDriverFactory localWebDriverFactory = new LocalWebDriverFactory();
    private static RemoteWebDriverFactory remoteWebDriverFactory = new RemoteWebDriverFactory();

    private static Map<String, WebDriver> instances = new HashMap<>();

    public enum BrowserType {
        FIREFOX,
        CHROME,
        IE,
        OPERA
    }

    public enum WebDriverType {
        REMOTE,
        LOCAL
    }

    public static WebDriver getInstance(WebDriverType driverType, BrowserType browserType) {
        String key = driverType.name() + browserType.name();
        WebDriver driver = null;
        if (!instances.containsKey(key)) {
            switch (driverType) {
                case LOCAL:
                    driver = localWebDriverFactory.createWebDriver(browserType);
                    break;
                case REMOTE:
                    driver = remoteWebDriverFactory.createWebDriver(browserType);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown web driver specified: " + driverType);
            }
            instances.put(key, driver);
        } else {
            driver = instances.get(key);
        }
        return driver;
    }

    public static void closeDriver(WebDriverType driverType, BrowserType browserType) {
       closeDriver(getInstance(driverType, browserType));
    }

    private static void closeDriver(WebDriver driver) {
        try {
            driver.quit();
        } catch (Exception e) {
            System.out.println("Can not quit browser");
        }
    }

}
