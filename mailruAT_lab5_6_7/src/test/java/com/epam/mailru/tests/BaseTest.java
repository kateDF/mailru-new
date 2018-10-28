package com.epam.mailru.tests;

import static com.epam.mailru.driver.AbstractWebDriverFactory.BrowserType;
import static com.epam.mailru.driver.AbstractWebDriverFactory.WebDriverType;

import com.epam.mailru.config.Config;
import com.epam.mailru.driver.AbstractWebDriverFactory;
import com.epam.mailru.entity.User;
import com.epam.mailru.steps.CommonSteps;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    private static final WebDriverType WEB_DRIVER_TYPE = Config.getWebDriverType();
    private static final BrowserType BROWSER_TYPE = Config.getBrowserType();
    protected static final User DEFAULT_USER = Config.getDefaultUser();
    private final Logger logger = LogManager.getRootLogger();

    protected CommonSteps steps;

    @BeforeClass
    public void setUp() {
        WebDriver webDriverInstance = AbstractWebDriverFactory.getInstance(WEB_DRIVER_TYPE, BROWSER_TYPE);
        steps = new CommonSteps(webDriverInstance);
        logger.info("Driver initialized");
    }

    @AfterClass
    public void tearDown() {
        AbstractWebDriverFactory.closeDriver(WEB_DRIVER_TYPE, BROWSER_TYPE);
        logger.info("Driver closed");
    }

}
