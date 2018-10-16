package com.epam.mailru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends AbstractPage {

    @FindBy (xpath = "//*[@id='b-compose__sent']//div[@class='message-sent__title']")
    private WebElement confirmationMessage;

    @FindBy (xpath = "//*[@id='b-compose__sent']//span[@class='message-sent__info']")
    private WebElement confirmationRecepient;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getConfirmationToSendEmail() {
        String confirmationMessage = null;
        if (this.confirmationMessage != null) {
            confirmationMessage = this.confirmationMessage.getText();
        }
        return confirmationMessage;
    }

    public String getConfirmationRecepient() {
        String confirmationRecepient = null;
        if (this.confirmationRecepient != null) {
            confirmationRecepient = this.confirmationRecepient.getText();
        }
        return confirmationRecepient;
    }

}
