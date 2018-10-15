package com.epam.mailru.tests;

import com.epam.mailru.entity.Email;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateEmailAndSaveDraftTest extends BaseTest {

    private static final String USERNAME = "autesttest";
    private static final String PASSWORD = "test12345";
    private static Email message = new Email("ATestMailBox@ya.ru", "Subject automation test mailbox", "Main Text - automation test mailbox");

    @BeforeMethod
    public void setUpPreconditions() {
        steps.openMainPage();
        steps.logIn(USERNAME, PASSWORD);
    }

    @Test
    public void createEmailAndSaveAsDraft() {
        steps.clickCreateMessage();
        steps.createMessage(message);
        steps.saveAsDraft();
        message.setTime(steps.getSaveTime());
        steps.openDrafts();
        Assert.assertTrue(steps.hasMessageInDrafts(message), "Message was not found in drafts.");
    }

}
