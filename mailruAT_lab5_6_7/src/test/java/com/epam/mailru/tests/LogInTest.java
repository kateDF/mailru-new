package com.epam.mailru.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    private static final String USERNAME = "autesttest";
    private static final String EMAIL_DOMAIN = "@mail.ru";
    private static final String PASSWORD = "test12345";

    @BeforeMethod
    public void setUpPreconditions(){
        steps.openMainPage();
    }

    @Test
    public void tryTest() {
        steps.logIn(USERNAME, PASSWORD);
        String actualUser = steps.getCurrentUser();
        Assert.assertEquals(actualUser, USERNAME + EMAIL_DOMAIN,
                "Should be:" + USERNAME + EMAIL_DOMAIN + ", but actual user: " + actualUser);
    }

}
