package com.epam.mailru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateMessagePage extends AbstractPage {

    public CreateMessagePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
