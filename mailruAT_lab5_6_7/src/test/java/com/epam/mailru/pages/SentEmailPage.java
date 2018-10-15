package com.epam.mailru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SentEmailPage extends AbstractPage {

    public SentEmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
