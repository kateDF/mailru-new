package com.epam.mailru.tests;

import com.epam.mailru.entity.Email;
import com.epam.mailru.entity.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDateTime;

public class DragAndDropEmailTest extends BaseTest {

    private static final User defaultUser = User.getDefaultUser();
    private static Email message = new Email.EmailBuilder("ATestMailBox@ya.ru", "Subject " + LocalDateTime.now(),
            "AT Text").build();

    @BeforeMethod
    public void setUpPreconditions() {
        steps.openMainPage();
        steps.logIn(defaultUser);
        steps.clickCreateMessage();
        steps.createMessage(message);
        steps.sendMessage();
    }

    @Test
    public void dragEmailFromSentListAndDropToArchive() {
        steps.openSentEmailsPage();
        steps.dragAndDropFromSentToArchive(message);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(steps.hasMessageInSentEmails(message), "Message was not moved from drafts.");

        steps.openArchive();
        Assert.assertTrue(steps.hasMessageInArchive(message), "Message was not found in archive.");
    }

}
