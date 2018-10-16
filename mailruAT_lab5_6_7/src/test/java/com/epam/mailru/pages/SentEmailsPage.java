package com.epam.mailru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SentEmailsPage extends AbstractEmailsList {

    public SentEmailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
