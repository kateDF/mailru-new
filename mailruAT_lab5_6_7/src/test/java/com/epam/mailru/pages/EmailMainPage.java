package com.epam.mailru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailMainPage extends AbstractPage {

    @FindBy(id = "PH_logoutLink")
    private WebElement logOutButton;

    public EmailMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickLogOut(){
        logOutButton.click();
    }

}
