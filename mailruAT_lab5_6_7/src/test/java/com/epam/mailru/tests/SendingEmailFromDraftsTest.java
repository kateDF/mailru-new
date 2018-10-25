package com.epam.mailru.tests;

import com.epam.mailru.entity.Email;
import com.epam.mailru.entity.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDateTime;

public class SendingEmailFromDraftsTest extends BaseTest {

    private static final User defaultUser = User.getDefaultUser();
    private static Email message = new Email.EmailBuilder("ATestMailBox@ya.ru", "Subject " + LocalDateTime.now(),
            "AT Text").build();

    @BeforeMethod
    public void setUpPreconditions(){
        steps.openMainPage();
        steps.logIn(defaultUser);
        steps.clickCreateMessage();
        steps.createMessage(message);
        steps.saveAsDraft();
    }

    @Test
    public void sendEmailFromDraft(){
        steps.openDrafts();
        steps.openMessageFromDrafts(message);
        steps.sendMessage();

        steps.openDrafts();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(steps.hasMessageInDrafts(message), "Message was not deleted from drafts");

        steps.openSentEmailsPage();
        Assert.assertTrue(steps.hasMessageInSentEmails(message), "Message was not found in sent emails folder.");
    }

}
