package com.epam.mailru.tests;

import com.epam.mailru.entity.Email;
import com.epam.mailru.entity.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class SearchingEmailTest extends BaseTest {

    private static final User defaultUser = User.getDefaultUser();
    private static Email message = new Email("ATestMailBox@ya.ru", "Subject " + LocalDateTime.now(),
            "Main Text - automation test mailbox");

    @BeforeMethod
    public void setUpPreconditions() {
        steps.openMainPage();
        steps.logIn(defaultUser);
        steps.clickCreateMessage();
        steps.createMessage(message);
        steps.sendMessage();
    }

    @Test
    public void searchEmailBySubject() {
        steps.searchBySubject(message.getSubject());
        Assert.assertTrue(steps.hasEmailSubjectInSearchResult(message.getSubject()), "Message was not found in search results.");
    }

}
