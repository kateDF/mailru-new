package com.epam.mailru.tests;

import com.epam.mailru.entity.Email;
import com.epam.mailru.entity.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class CreateEmailAndSaveDraftTest extends BaseTest {

    private static final User defaultUser = User.getDefaultUser();
    private static Email message = new Email.EmailBuilder("ATestMailBox@ya.ru", "Subject " + LocalDateTime.now(),
            "AT Text").build();

    @BeforeMethod
    public void setUpPreconditions() {
        steps.openMainPage();
        steps.logIn(defaultUser);
    }

    @Test
    public void createEmailAndSaveAsDraft() {
        steps.clickCreateMessage();
        steps.createMessage(message);
        steps.saveAsDraft();

        steps.openDrafts();
        Assert.assertTrue(steps.hasMessageInDrafts(message), "Message was not found in drafts.");
    }

}
