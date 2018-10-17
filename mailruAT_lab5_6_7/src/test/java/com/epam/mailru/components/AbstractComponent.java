package com.epam.mailru.components;

import com.epam.mailru.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractComponent extends AbstractPage {

    public AbstractComponent(WebDriver driver) {
        super(driver);
    }

}
