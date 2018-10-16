package com.epam.mailru.tests;

import com.epam.mailru.entity.Email;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalTime;

public class SendingEmailFromDraftsTest extends BaseTest {

    private static final String USERNAME = "autesttest";
    private static final String PASSWORD = "test12345";

    private static Email message = new Email("ATestMailBox@ya.ru", "Subject automation test mailbox " + LocalTime.now(), "Main Text - automation test mailbox");

    @BeforeMethod
    public void setUpPreconditions(){
        steps.openMainPage();
        steps.logIn(USERNAME, PASSWORD);
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
