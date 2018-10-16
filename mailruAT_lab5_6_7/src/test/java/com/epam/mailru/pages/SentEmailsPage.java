package com.epam.mailru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SentEmailsPage extends AbstractPage {

    public SentEmailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
