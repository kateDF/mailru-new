package com.epam.mailru.steps;

import com.epam.mailru.pages.EmailMainPage;
import com.epam.mailru.pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.testng.reporters.jq.Main;

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

    public EmailMainPage logIn(String username, String password){
        MainPage mainPage = new MainPage(driver);
        mainPage.enterUsername(username);
        mainPage.enterPassword(password);
        mainPage.selectDoNotRemember();
        mainPage.clickSubmit();
        return new EmailMainPage(driver);
    }

}
