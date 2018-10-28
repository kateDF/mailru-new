package com.epam.mailru.config;

import static com.epam.mailru.driver.AbstractWebDriverFactory.BrowserType;
import static com.epam.mailru.driver.AbstractWebDriverFactory.WebDriverType;

import com.epam.mailru.entity.User;


import java.util.ResourceBundle;

public class Config {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("config");

    public static WebDriverType getWebDriverType() {
        return WebDriverType.valueOf(bundle.getString("driverType"));
    }

    public static BrowserType getBrowserType() {
        return BrowserType.valueOf(bundle.getString("browserType"));
    }

    public static User getDefaultUser() {
        return new User(bundle.getString("user"), bundle.getString("password"));
    }

}
