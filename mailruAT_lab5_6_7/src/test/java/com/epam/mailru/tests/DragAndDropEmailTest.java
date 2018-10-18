package com.epam.mailru.tests;

import com.epam.mailru.entity.Email;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDateTime;

public class DragAndDropEmailTest extends BaseTest {

    private static final String USERNAME = "autesttest";
    private static final String PASSWORD = "test12345";
    private static Email message = new Email("ATestMailBox@ya.ru", "Subject " + LocalDateTime.now(),
            "Main Text - automation test mailbox");

    @BeforeMethod
    public void setUpPreconditions() {
        steps.openMainPage();
        steps.logIn(USERNAME, PASSWORD);
        steps.clickCreateMessage();
        steps.createMessage(message);
        steps.sendMessage();
    }

    @Test
    public void dragEmailFromSentListAndDropToArchive() {
        steps.openSentEmailsPage();
        steps.dragAndDropFromSentToArchive(message);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(steps.hasMessageInSentEmails(message));
        steps.openArchive();
        Assert.assertTrue(steps.hasMessageInArchive(message));
    }

}
