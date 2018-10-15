package com.epam.mailru.pages;

import com.epam.mailru.entity.Email;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DraftsPage extends AbstractPage {

    private static final By RECIPIENT_IN_DRAFT_ELEMENT = By.xpath("div//div[@class='b-datalist__item__addr']");
    private static final By SUBJECT_IN_DRAFT_ELEMENT = By.xpath("div//div[@class='b-datalist__item__subj']");
    private static final By TIME_IN_DRAFT_ELEMENT = By.xpath("div//span[contains(@class, 'date__value')]");

    @FindBy(xpath = "//div[contains(@class,'letters_to')]//a[contains(@class, 'b-datalist__item__link')]")
    List<WebElement> draftMessagesAsElements;

    public DraftsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public boolean hasInDrafts(Email email, String savingTime) {
        if (findInDrafts(email, savingTime) != null) {
            return true;
        }
        return false;
    }

    public boolean searchAndOpenFromDrafts(Email email, String savingTime) {
        WebElement linkToFoundEmail = findInDrafts(email, savingTime);
        if (linkToFoundEmail != null) {
            linkToFoundEmail.click();
            return true;
        }
        return false;
    }

    private WebElement findInDrafts(Email email, String savingTime){
        //TODO: add checking by text content
        for (WebElement message : draftMessagesAsElements) {
            WebElement recipientAct = message.findElement(RECIPIENT_IN_DRAFT_ELEMENT);
            if (email.getRecipientEmail().equals(recipientAct.getText())) {
                WebElement subjectAct = message.findElement(SUBJECT_IN_DRAFT_ELEMENT);
                if (subjectAct == null & email.getSubject() == null
                        || subjectAct.getText().contains(email.getSubject())) {
                    WebElement time = message.findElement(TIME_IN_DRAFT_ELEMENT);
                    if (savingTime.equals(time.getText())) {
                        return message;
                    }
                }
            }
        }
        return null;
    }

}
