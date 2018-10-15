package com.epam.mailru.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {

    private WebDriver driver;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForClicableAndClick(WebElement element) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }

}
