package com.epam.mailru.tests;

import static com.epam.mailru.driver.WebDriverFactory.BrowserType;

import com.epam.mailru.driver.WebDriverFactory;
import com.epam.mailru.steps.CommonSteps;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    protected CommonSteps steps;

    protected final Logger logger = Logger.getLogger(this.getClass().getSimpleName());

    @BeforeClass
    public void setUp() {
        WebDriver chromeDriver = WebDriverFactory.getInstance(BrowserType.CHROME);
        steps = new CommonSteps(chromeDriver);
        logger.info("Driver initialized");
    }

    @AfterClass
    public void tearDown() {
        WebDriverFactory.closeDriver();
        logger.info("Driver closed");
    }

}
