package com.epam.mailru.tests;

import static com.epam.mailru.driver.WebDriverFactory.BrowserType;

import com.epam.mailru.driver.WebDriverFactory;
import com.epam.mailru.steps.CommonSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    protected CommonSteps steps;

    @BeforeClass
    public void setUp() {
        WebDriver chromeDriver = WebDriverFactory.getInstance(BrowserType.CHROME);
        steps = new CommonSteps(chromeDriver);
    }

    @AfterClass
    public void tearDown() {
        WebDriverFactory.closeDriver();
    }

}
