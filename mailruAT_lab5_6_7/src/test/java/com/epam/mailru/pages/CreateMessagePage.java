package com.epam.mailru.pages;

import com.epam.mailru.entity.Email;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateMessagePage extends AbstractPage {

    private static final String BASE_URL = "https://e.mail.ru/compose/";

    @FindBy(xpath = "//textarea[@tabindex='4']")
    private WebElement intputRecepient;

    @FindBy(xpath = "//input[@name='Subject']")
    private WebElement inputSubject;

    @FindBy(xpath = "//table[@class='mceLayout']/tbody//iframe")
    private WebElement containerForFrameMessageInput;

    @FindBy(id = "tinymce")
    private WebElement textAreaMessage;

    @FindBy(xpath = "//div[@data-name='saveDraft']")
    private WebElement saveAsDraftButton;

    @FindBy(xpath = "//div[@data-name='send']")
    private WebElement sendButton;

    @FindBy(xpath = "//div[@data-mnemo='saveStatus']/span[@class='time']")
    private WebElement saveTime;

    public void openPage() {
        // this if prevent reopening the same page
        if (!driver.getCurrentUrl().startsWith(BASE_URL)) {
            driver.navigate().to(BASE_URL);
        }
    }

    public CreateMessagePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CreateMessagePage enterRecipient(String email) {
        intputRecepient.sendKeys(email);
        return this;
    }

    public CreateMessagePage enterSubject(String subject) {
        inputSubject.sendKeys(subject);
        return this;
    }

    public CreateMessagePage enterTestMessage(String message) {
        driver.switchTo().frame(containerForFrameMessageInput);
        textAreaMessage.clear();
        textAreaMessage.sendKeys(message);
        driver.switchTo().defaultContent();
        return this;
    }

    public CreateMessagePage saveEmailAsDraft() {
        saveAsDraftButton.click();
        waitForVisibility(saveTime);
        return this;
    }

    public String getTimeOfSaving() {
        waitForVisibility(saveTime);
        return saveTime.getText();
    }

    public ConfirmationPage clickSendButton() {
        waitForDocumentReady();
        waitElementRefresh(sendButton);
        sendButton.click();
        return new ConfirmationPage(driver);
    }

}
