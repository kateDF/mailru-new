package com.epam.mailru.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    private static final String EMAIL_DOMAIN = "@mail.ru";

    @BeforeMethod
    public void setUpPreconditions() {
        steps.openMainPage();
    }

    @Test
    public void logInTest() {
        steps.logIn(DEFAULT_USER);
        String actualUser = steps.getCurrentUser();
        Assert.assertEquals(actualUser, DEFAULT_USER.getUsername() + EMAIL_DOMAIN,
                "Should be:" + DEFAULT_USER.getUsername() + EMAIL_DOMAIN + ", but actual user: " + actualUser);
    }

}
