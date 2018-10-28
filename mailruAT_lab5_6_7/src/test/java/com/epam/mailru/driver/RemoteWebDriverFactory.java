package com.epam.mailru.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

class RemoteWebDriverFactory{

    private static final String REMOTE_URL = "http://127.0.0.1:4444/wd/hub";

    WebDriver createWebDriver(AbstractWebDriverFactory.BrowserType browserType) {
        WebDriver driver = null;
        switch (browserType) {
            case CHROME:
                try {
                    driver = new RemoteWebDriver(new URL(REMOTE_URL), DesiredCapabilities.chrome());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            case FIREFOX:
                try {
                    driver = new RemoteWebDriver(new URL(REMOTE_URL), DesiredCapabilities.firefox());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                throw new IllegalArgumentException("Wrong browser type");
        }
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
