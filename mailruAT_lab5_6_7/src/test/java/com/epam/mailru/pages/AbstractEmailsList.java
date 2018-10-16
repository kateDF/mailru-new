package com.epam.mailru.pages;

import com.epam.mailru.entity.Email;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class AbstractEmailsList extends AbstractPage {

    private static final By RECIPIENT_IN_DRAFT_ELEMENT = By.xpath("div//div[@class='b-datalist__item__addr']");
    private static final By SUBJECT_IN_DRAFT_ELEMENT = By.xpath("div//div[@class='b-datalist__item__subj']");

    @FindBy(xpath = "//div[contains(@class,'letters_to')]//a[contains(@class, 'b-datalist__item__link')]")
    private List<WebElement> messagesAsElements;

    public AbstractEmailsList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean hasInList(Email email) {
        //TODO: smth instead of refresh
        driver.navigate().refresh();
        return findInList(email) != null;
    }

    public boolean openMessageFromEmailList(Email email) {
        WebElement linkToFoundEmail = findInList(email);
        if (linkToFoundEmail != null) {
            linkToFoundEmail.click();
            waitForDocumentReady();
            return true;
        }
        return false;
    }

    private WebElement findInList(Email email) {
        //TODO: add checking by text content
        for (WebElement message : messagesAsElements) {
            WebElement recipientAct = message.findElement(RECIPIENT_IN_DRAFT_ELEMENT);
            if (email.getRecipientEmail().equals(recipientAct.getText())) {
                WebElement subjectAct = message.findElement(SUBJECT_IN_DRAFT_ELEMENT);
                if (subjectAct == null & email.getSubject() == null
                        || subjectAct.getText().contains(email.getSubject())) {
                    return message;
                }
            }
        }
        return null;
    }

}
