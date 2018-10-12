package com.epam.mailru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EmailMainPage extends AbstractPage {

    public EmailMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
