package com.epam.mailru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForVisibility(WebElement element) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfAllElements(element));
    }

}
