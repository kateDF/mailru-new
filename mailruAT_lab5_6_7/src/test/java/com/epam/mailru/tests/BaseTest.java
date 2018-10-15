package com.epam.mailru.tests;

import com.epam.mailru.driver.ChromeWebdriver;
import com.epam.mailru.steps.CommonSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    protected CommonSteps steps;

    @BeforeClass
    public void setUp() {
        WebDriver chromeDriver = ChromeWebdriver.getInstance();
        steps = new CommonSteps(chromeDriver);
    }

    @AfterClass
    public void tearDown() {
        ChromeWebdriver.closeDriver();
    }

}
