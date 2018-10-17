package com.epam.mailru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailMainPage extends AbstractPage {

    @FindBy(id = "PH_logoutLink")
    private WebElement logOutButton;

    @FindBy(id = "PH_user-email")
    private WebElement userEmailActual;

    @FindBy(xpath = "//a[@data-name='compose']")
    private WebElement createMessageButton;

    public EmailMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage clickLogOut() {
        waitForClicableAndClick(logOutButton);
        return new MainPage(driver);
    }

    public String getCurrentUserEmail() {
        waitForVisibility(userEmailActual);
        return userEmailActual.getText();
    }

    public CreateMessagePage clickCreateMessage() {
        waitForClicableAndClick(createMessageButton);
        return new CreateMessagePage(driver);
    }

}
