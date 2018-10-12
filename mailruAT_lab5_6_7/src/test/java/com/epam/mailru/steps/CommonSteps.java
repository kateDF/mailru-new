package com.epam.mailru.steps;

import com.epam.mailru.pages.MainPage;
import org.openqa.selenium.WebDriver;

public class CommonSteps {

    private WebDriver driver;

    public CommonSteps(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage openMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        return mainPage;
    }

}
