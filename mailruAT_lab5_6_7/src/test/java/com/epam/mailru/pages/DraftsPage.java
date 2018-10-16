package com.epam.mailru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DraftsPage extends AbstractEmailsList {

    public DraftsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
