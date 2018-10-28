package com.epam.mailru.tests;

import com.epam.mailru.entity.Email;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class SearchingEmailTest extends BaseTest {

    private static Email message = new Email.EmailBuilder("ATestMailBox@ya.ru", "Subject " + LocalDateTime.now(),
            "AT Text").build();

    @BeforeMethod
    public void setUpPreconditions() {
        steps.openMainPage();
        steps.logIn(DEFAULT_USER);
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
