package com.epam.mailru.tests;

import com.epam.mailru.entity.Email;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalTime;

public class SearchingEmailTest extends BaseTest {

    private static final String USERNAME = "autesttest";
    private static final String PASSWORD = "test12345";

    private static Email message = new Email("ATestMailBox@ya.ru", "Subject automation test mailbox " + LocalTime.now(), "Main Text - automation test mailbox");

    @BeforeMethod
    public void setUpPreconditions() {
        steps.openMainPage();
        steps.logIn(USERNAME, PASSWORD);
        steps.clickCreateMessage();
        steps.createMessage(message);
        steps.sendMessage();
    }

    @Test
    public void searchEmailBySubject() {
        steps.openSentEmailsPage();
        steps.searchBySubject(message.getSubject());
        Assert.assertTrue(steps.hasEmailSubjectInSearchResult(message.getSubject()), "Message was not found in search results.");
    }

}
