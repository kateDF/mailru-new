package com.epam.mailru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitForVisibility(WebElement element) {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOfAllElements(element));
    }

    protected void waitForClicableAndClick(WebElement element) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void waitForDocumentReady() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
    }

    protected void waitElementRefresh(WebElement element) {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
    }
}
